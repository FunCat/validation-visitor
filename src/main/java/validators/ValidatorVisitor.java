package validators;

import models.CommonSearchRule;
import models.ComplexSearchRule;
import models.FormInnerSearchRule;
import models.FormSearchRule;
import models.ComplexInnerSearchRule;

public interface ValidatorVisitor {
    boolean validate(CommonSearchRule commonSearchRule);
    boolean validate(ComplexSearchRule complexSearchRule);
    boolean validate(ComplexInnerSearchRule complexInnerSearchRule);
    boolean validate(FormSearchRule formSearchRule);
    boolean validate(FormInnerSearchRule formInnerSearchRule);
}
