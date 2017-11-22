package models;

import java.util.List;
import validators.ValidatorVisitor;

public class FormSearchRule implements SearchRule {

    private String section;
    private String type;
    private String css;
    private String xpath;
    private List<FormInnerSearchRule> innerSearchRules;

    public FormSearchRule() {
    }

    public FormSearchRule(String section, String type, String css, String xpath,
                          List<FormInnerSearchRule> innerSearchRules) {
        this.section = section;
        this.type = type;
        this.css = css;
        this.xpath = xpath;
        this.innerSearchRules = innerSearchRules;
    }

    public String getSection() {
        return section;
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

    public List<FormInnerSearchRule> getInnerSearchRules() {
        return innerSearchRules;
    }

    @Override
    public boolean beValidated(ValidatorVisitor validatorVisitor) {
        return validatorVisitor.validate(this);
    }
}
