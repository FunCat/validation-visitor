package models;

import java.util.List;
import validators.ValidatorVisitor;

public class ComplexSearchRule implements Validatable {

    private String type;
    private List<ComplexInnerSearchRule> complexInnerSearchRules;

    public ComplexSearchRule() {
    }

    public String getType() {
        return type;
    }

    public List<ComplexInnerSearchRule> getComplexInnerSearchRules() {
        return complexInnerSearchRules;
    }

    public ComplexSearchRule(String type, List<ComplexInnerSearchRule> complexInnerSearchRules) {
        this.type = type;
        this.complexInnerSearchRules = complexInnerSearchRules;
    }

    @Override
    public boolean beValidated(ValidatorVisitor validatorVisitor) {
        return validatorVisitor.validate(this);
    }
}
