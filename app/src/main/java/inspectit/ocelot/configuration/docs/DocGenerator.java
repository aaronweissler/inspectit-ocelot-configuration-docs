package inspectit.ocelot.configuration.docs;

import j2html.tags.Tag;
import org.yaml.snakeyaml.Yaml;
import static j2html.TagCreator.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DocGenerator {

    public DocGenerator() {
    }

    private String configsRoot = "config";

    private final List<String> TYPES = List.of(new String[]{"actions", "rules", "scopes"});

    //could actually use FileAccessor.readConfigurationFile
    public Optional<String> readConfigurationFile(String path) {
        try {
            byte[] rawFileContent = Files.readAllBytes(Path.of(path));
            String fileContent = new String(rawFileContent, StandardCharsets.UTF_8);
            return Optional.of(fileContent);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    private Map parseSingleFile(String path){
        Yaml yaml = new Yaml();
        String src = readConfigurationFile(path).orElse("");
        Object loadedYaml = yaml.load(src);

        return null;
    }

    //could actually use getAllYamlFile from AgentConfigurationReloadTask?
    private void parseAllFiles(){

    }

    public String generateSinglePageHTML(List<ConfigDocObject> configDocObjects){
        return body(
                div(configDocObjects.stream().map(ConfigDocObject::mainConfigDocPartial).toArray(Tag[]::new)
                )
        ).render();
    }

    public static void main(String[] args) throws IOException {

        List<ConfigDocObject> configDocObjects = new ArrayList<>();

        configDocObjects.add(new ConfigDocAction("a_testaction", "An action to test HTML generation."));
        configDocObjects.add(new ConfigDocAction("a_testaction2", "Another action to test HTML generation."));

        DocGenerator docGenerator = new DocGenerator();
        System.out.println(docGenerator.generateSinglePageHTML(configDocObjects));

    }

}
