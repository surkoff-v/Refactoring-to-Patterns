package com.sv.MyWork.descriptors;

import com.sv.MyWork.domain.RemoteUser;
import com.sv.MyWork.domain.User;

/**
 * Абстракция «описатель колонки».
 * Содержит фабричные методы для создания всех нужных подклассов.
 */
public abstract class AttributeDescriptor {

    protected final String  columnName;
    protected final Class<?> ownerClass;
    protected final Class<?> valueType;

    /* конструктор доступен только внутри пакета / иерархии */
    AttributeDescriptor(String columnName,
                        Class<?> ownerClass,
                        Class<?> valueType) {
        this.columnName = columnName;
        this.ownerClass = ownerClass;
        this.valueType  = valueType;
    }

    public static AttributeDescriptor forInteger(String columnName, Class aClass) {
        return new DefaultDescriptor(columnName, aClass, Integer.TYPE);
    }

    public static AttributeDescriptor forReference(String columName, Class aClass, Class<User> targetEntity, Class<RemoteUser> remoteEntity) {
        return new ReferenceDescriptor(columName, aClass,
                targetEntity, remoteEntity);
    }

    public static AttributeDescriptor forBoolean(String columName, Class aClass) {
        return new BooleanDescriptor(columName, aClass, Boolean.TYPE);
    }

    public static AttributeDescriptor forDate(String columnName, Class aClass) {
        return new DefaultDescriptor(columnName, aClass, java.util.Date.class);
    }

}
