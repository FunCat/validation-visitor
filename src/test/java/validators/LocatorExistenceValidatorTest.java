package validators;

import static org.junit.Assert.*;

import models.CommonSearchRule;
import models.ComplexSearchRule;
import models.FormInnerSearchRule;
import models.FormSearchRule;
import models.ComplexInnerSearchRule;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class LocatorExistenceValidatorTest {

    ValidatorVisitor validator = new LocatorExistenceValidator();

    CommonSearchRule validCommonSearchRule = new CommonSearchRule("text", "button", "css", null);
    CommonSearchRule invalidCommonSearchRule = new CommonSearchRule("text", "button", null, null);

    @Test
    public void validate_TrueWhenValidCommonSearchRule() {
        assertTrue(validator.validate(validCommonSearchRule));
    }

    @Test
    public void validate_FalseWhenInvalidCommonSearchRule() {
        assertFalse(validator.validate(invalidCommonSearchRule));
    }

    ComplexSearchRule validComplexSearchRule = new ComplexSearchRule("dropdown",
        Lists.newArrayList(
            new ComplexInnerSearchRule("text", "root", "css", null),
            new ComplexInnerSearchRule(null, "list", null, "xpath")
        ));
    ComplexSearchRule invalidComplexSearchRule = new ComplexSearchRule("dropdown",
        Lists.newArrayList(
            new ComplexInnerSearchRule("text", "root", null, null),
            new ComplexInnerSearchRule(null, "list", null, "xpath")
        ));

    @Test
    public void validate_TrueWhenValidComplexSearchRule() {
        assertTrue(validator.validate(validComplexSearchRule));
    }

    @Test
    public void validate_FalseWhenInvalidComplexSearchRule() {
        assertFalse(validator.validate(invalidComplexSearchRule));
    }

    FormSearchRule validFormSearchRule = new FormSearchRule("HtmlForm", "form", "css", null,
        Lists.newArrayList(
            new FormInnerSearchRule("text", "button", "css", null),
            new FormInnerSearchRule("value", "textfield", null, "xpath")
        ));
    FormSearchRule invalidFormSearchRule = new FormSearchRule("HtmlForm", "form", null, null,
        Lists.newArrayList(
            new FormInnerSearchRule("text", "button", "css", null),
            new FormInnerSearchRule("value", "textfield", null, "xpath")
        ));

    @Test
    public void validate_TrueWhenValidFormSearchRule() {
        assertTrue(validator.validate(validFormSearchRule));
    }

    @Test
    public void validate_FalseWhenInvalidFormSearchRule() {
        assertFalse(validator.validate(invalidFormSearchRule));
    }
}