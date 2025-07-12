package com.sv.initial.descriptors;

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


    /* Допустим, здесь идут общие методы чтения/записи ResultSet и т. п. */
}
