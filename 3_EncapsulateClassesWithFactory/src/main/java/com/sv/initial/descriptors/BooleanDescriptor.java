package com.sv.initial.descriptors;

/* package-private! — не виден клиентам снаружи */
class BooleanDescriptor extends AttributeDescriptor {

    /* конструктор «#» = package-private / protected */
    BooleanDescriptor(String columnName,
                      Class<?> ownerClass,
                      Class<?> valueType) {
        super(columnName, ownerClass, valueType);
    }
}
