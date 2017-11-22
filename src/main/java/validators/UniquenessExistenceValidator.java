package validators;

import models.CommonSearchRule;
import models.ComplexSearchRule;
import models.FormInnerSearchRule;
import models.FormSearchRule;
import models.ComplexInnerSearchRule;

public class UniquenessExistenceValidator implements ValidatorVisitor {

    @Override
    public boolean validate(CommonSearchRule commonSearchRule) {
        return commonSearchRule.getUniqueness() != null;
    }

    @Override
    public boolean validate(ComplexSearchRule complexSearchRule) {
        return complexSearchRule.getComplexInnerSearchRules().stream()
            .allMatch(searchRule -> searchRule.beValidated(this));
    }

    @Override
    public boolean validate(ComplexInnerSearchRule complexInnerSearchRule) {
        return complexInnerSearchRule.getTitle().equals("root") ?
            complexInnerSearchRule.getUniqueness() != null
            : complexInnerSearchRule.getUniqueness() == null;
    }

    @Override
    public boolean validate(FormSearchRule formSearchRule) {
        return formSearchRule.getInnerSearchRules().stream()
            .allMatch(searchRule -> searchRule.beValidated(this));
    }

    @Override
    public boolean validate(FormInnerSearchRule formInnerSearchRule) {
        return formInnerSearchRule.getUniqueness() != null;
    }
}
