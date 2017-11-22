package models;

import validators.ValidatorVisitor;

public class CommonSearchRule implements SearchRule {

    private String uniqueness;
    private String type;
    private String css;
    private String xpath;

    public CommonSearchRule() {
    }

    public CommonSearchRule(String uniqueness, String type, String css, String xpath) {
        this.uniqueness = uniqueness;
        this.type = type;
        this.css = css;
        this.xpath = xpath;
    }

    public String getUniqueness() {
        return uniqueness;
    }

    public String getType() {
        return type;
    }

    public String getCss() {
        return css;
    }

    public String getXpath() {
        return xpath;
    }

    @Override
    public boolean beValidated(ValidatorVisitor validatorVisitor) {
        return validatorVisitor.validate(this);
    }
}
