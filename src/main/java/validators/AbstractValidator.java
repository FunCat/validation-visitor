package validators;

import models.CommonSearchRule;
import models.ComplexInnerSearchRule;
import models.ComplexSearchRule;
import models.FormInnerSearchRule;
import models.FormSearchRule;

public class AbstractValidator implements ValidatorVisitor{

    @Override
    public boolean validate(CommonSearchRule commonSearchRule) {
        return true;
    }

    @Override
    public boolean validate(ComplexSearchRule complexSearchRule) {
        return true;
    }

    @Override
    public boolean validate(ComplexInnerSearchRule complexInnerSearchRule) {
        return true;
    }

    @Override
    public boolean validate(FormSearchRule formSearchRule) {
        return true;
    }

    @Override
    public boolean validate(FormInnerSearchRule formInnerSearchRule) {
        return true;
    }
}
