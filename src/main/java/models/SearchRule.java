package models;

import validators.ValidatorVisitor;

public interface SearchRule {
    boolean beValidated(ValidatorVisitor validatorVisitor);

}
