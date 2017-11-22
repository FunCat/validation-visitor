package models;

import validators.ValidatorVisitor;

public class ComplexInnerSearchRule implements SearchRule{

    private String uniqueness;
    private String title;
    private String css;
    private String xpath;

    public ComplexInnerSearchRule() {
    }

    public ComplexInnerSearchRule(String uniqueness, String title, String css, String xpath) {
        this.uniqueness = uniqueness;
        this.title = title;
        this.css = css;
        this.xpath = xpath;
    }

    public String getUniqueness() {
        return uniqueness;
    }

    public String getTitle() {
        return title;
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
