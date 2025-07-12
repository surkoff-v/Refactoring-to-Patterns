package com.sv.initial.descriptors;

import com.sv.initial.domain.RemoteUser;
import com.sv.initial.domain.User;

import java.util.ArrayList;
import java.util.List;

/** Абстрактный класс, подготавливающий дескрипторы для сущности. */
public abstract class SomeOrmMapper {

    protected List<AttributeDescriptor> createAttributeDescriptors() {

        List<AttributeDescriptor> result = new ArrayList<>();

        /* --- клиент знает КОНКРЕТНЫЕ классы и их конструкторы --- */
        result.add(new DefaultDescriptor("remoteId",          getClass(), Integer.TYPE));
        result.add(new DefaultDescriptor("createdDate",       getClass(), java.util.Date.class));
        result.add(new DefaultDescriptor("lastChangedDate",   getClass(), java.util.Date.class));

        result.add(new ReferenceDescriptor("createdBy",       getClass(),
                User.class, RemoteUser.class));
        result.add(new ReferenceDescriptor("lastChangedBy",   getClass(),
                User.class, RemoteUser.class));

        result.add(new DefaultDescriptor("optimisticLockVersion", getClass(), Integer.TYPE));

        result.add(new BooleanDescriptor("isActive", getClass(), Boolean.TYPE));

        return result;
    }
}
