package drools;

import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.command.Command;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.conf.KieBaseOption;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class StatefulSessionServices {
    private final KieServices kieServices;
    private final KieContainer kContainer;
    private KieSession kieSession = null;
    private KieFileSystem kieFileSystem = null;

    public StatefulSessionServices(List<String> ruleFilePaths, HashMap<String, String> properties) {
        kieServices = KieServices.Factory.get();

        KieBaseConfiguration kieBaseConfiguration = kieServices.newKieBaseConfiguration();
        for (String key : properties.keySet()) {
            kieBaseConfiguration.setProperty(key, properties.get(key));
        }

        kContainer = getKieContainer(ruleFilePaths);
    }

    public KieContainer getKieContainer(List<String> ruleFilePaths) {
        for (String path : ruleFilePaths) {
            File file = new File(path);
            org.kie.api.io.Resource resource = kieServices.getResources().newFileSystemResource(file).setResourceType(ResourceType.DRL);
            if (kieFileSystem == null) {
                kieFileSystem = kieServices.newKieFileSystem();
            }
            kieFileSystem.write(resource);
        }
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    public KieSession getKieSession() {
        if (kieSession == null) {
            kieSession = kContainer.newKieSession();
        }
        return kieSession;
    }

    public void dispose() {
        if (kieSession != null) {
            kieSession.dispose();
        }
    }

    public void addObject(Object value) {
        KieSession session = getKieSession();
        session.insert(value);
    }

    public void addObject(List<Object> values) {
        KieSession session = getKieSession();
        for (Object value : values) {
            session.insert(value);
        }
    }
}
