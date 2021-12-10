package inspectit.ocelot.configuration.docs;

import j2html.tags.Tag;
import static j2html.TagCreator.*;

public class ConfigDocAction extends ConfigDocObject{

    public ConfigDocAction(String name, String shortDescription, String longDescription) {
        super(name, shortDescription, longDescription);
    }

    public ConfigDocAction(String name, String shortDescription) {
        super(name, shortDescription);
    }

    @Override
    Tag specificConfigDocPartial() {
        return div(h2(this.getName()), p(this.getShortDescription()));
    }
}
