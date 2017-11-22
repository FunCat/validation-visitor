package models;

import validators.ValidatorVisitor;

public interface Validatable {
    boolean beValidated(ValidatorVisitor validatorVisitor);

}
