package com.sv.MyWork.descriptors;

/* package-private */
class ReferenceDescriptor extends AttributeDescriptor {

    final Class<?> targetEntity;
    final Class<?> remoteEntity;

    ReferenceDescriptor(String columnName,
                        Class<?> ownerClass,
                        Class<?> targetEntity,
                        Class<?> remoteEntity) {
        super(columnName, ownerClass, targetEntity);
        this.targetEntity = targetEntity;
        this.remoteEntity = remoteEntity;
    }
}