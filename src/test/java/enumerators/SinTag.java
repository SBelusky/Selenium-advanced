package enumerators;

public enum SinTag {
    MURDER("murder"),
    HIJACK("hijack"),
    BLACKMAIL("blackmail"),
    CAR_ACCIDENT("car accident"),
    ROBBERY("robbery");

    private String xpathValue;

    SinTag(String xpathValue) {
        this.xpathValue = xpathValue;
    }

    public String getXpathValue() {
        return xpathValue;
    }
}
