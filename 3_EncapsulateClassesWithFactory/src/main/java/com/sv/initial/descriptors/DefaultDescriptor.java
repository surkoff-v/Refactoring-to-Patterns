package com.sv.initial.descriptors;

/* package-private */
class DefaultDescriptor extends AttributeDescriptor {

    DefaultDescriptor(String columnName,
                      Class<?> ownerClass,
                      Class<?> valueType) {
        super(columnName, ownerClass, valueType);
    }
}