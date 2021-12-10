package inspectit.ocelot.configuration.docs;

import j2html.tags.Tag;

import static j2html.TagCreator.*;

abstract class ConfigDocObject {

    public ConfigDocObject(String name, String shortDescription, String longDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public ConfigDocObject(String name, String shortDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = "";
    }

    private String name;
    private String shortDescription;
    private String longDescription;

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    abstract Tag specificConfigDocPartial();

    public Tag mainConfigDocPartial() {
        return div(h2("MainPartial"), p(this.specificConfigDocPartial()));
    }

}
