package validators;

import static org.junit.Assert.*;

import models.CommonSearchRule;
import models.ComplexInnerSearchRule;
import models.ComplexSearchRule;
import models.FormInnerSearchRule;
import models.FormSearchRule;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class UniquenessExistenceValidatorTest {

    UniquenessExistenceValidator validator = new UniquenessExistenceValidator();

    CommonSearchRule validCommonSearchRule = new CommonSearchRule("text", "button", "css", null);
    CommonSearchRule invalidCommonSearchRule = new CommonSearchRule(null, "button", "css", null);

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
            new ComplexInnerSearchRule("text", "root", "css", null),
            new ComplexInnerSearchRule("value", "list", null, "xpath")
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
    FormSearchRule invalidFormSearchRule = new FormSearchRule("HtmlForm", "form", "css", null,
        Lists.newArrayList(
            new FormInnerSearchRule("text", "button", "css", null),
            new FormInnerSearchRule(null, "textfield", null, "xpath")
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