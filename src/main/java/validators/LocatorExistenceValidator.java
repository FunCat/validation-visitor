package validators;

import models.CommonSearchRule;
import models.ComplexSearchRule;
import models.FormInnerSearchRule;
import models.FormSearchRule;
import models.ComplexInnerSearchRule;

public class LocatorExistenceValidator implements ValidatorVisitor {

    @Override
    public boolean validate(CommonSearchRule commonSearchRule) {
        return commonSearchRule.getCss() != null || commonSearchRule.getXpath() != null;
    }

    @Override
    public boolean validate(ComplexSearchRule complexSearchRule) {
        return complexSearchRule.getComplexInnerSearchRules().stream()
            .allMatch(searchRule -> searchRule.beValidated(this));
    }

    @Override
    public boolean validate(ComplexInnerSearchRule complexInnerSearchRule) {
        return complexInnerSearchRule.getCss() != null || complexInnerSearchRule.getXpath() != null;
    }

    @Override
    public boolean validate(FormSearchRule formSearchRule) {
        return (formSearchRule.getCss() != null || formSearchRule.getXpath() != null)
            && formSearchRule.getInnerSearchRules().stream()
            .allMatch(searchRule -> searchRule.beValidated(this));
    }

    @Override
    public boolean validate(FormInnerSearchRule formInnerSearchRule) {
        return formInnerSearchRule.getCss() != null || formInnerSearchRule.getXpath() != null;
    }
}
