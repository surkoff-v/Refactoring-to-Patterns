package com.sv.MyWork.descriptors;

/* package-private */
class DefaultDescriptor extends AttributeDescriptor {

    protected DefaultDescriptor(String columnName,
                      Class<?> ownerClass,
                      Class<?> valueType) {
        super(columnName, ownerClass, valueType);
    }
}