package com.sv.MyWork.descriptors;

import com.sv.MyWork.domain.RemoteUser;
import com.sv.MyWork.domain.User;

import java.util.ArrayList;
import java.util.List;

/** Абстрактный класс, подготавливающий дескрипторы для сущности. */
public abstract class SomeOrmMapper {

    protected List<AttributeDescriptor> createAttributeDescriptors() {

        List<AttributeDescriptor> result = new ArrayList<>();

        result.add(AttributeDescriptor.forInteger("remoteId", getClass()));

        result.add(AttributeDescriptor.forDate("createdDate", getClass()));
        result.add(AttributeDescriptor.forDate("lastChangedDate", getClass()));

        result.add(AttributeDescriptor.forReference("createdBy", getClass(), User.class, RemoteUser.class));
        result.add(AttributeDescriptor.forReference("lastChangedBy", getClass(), User.class, RemoteUser.class));

        result.add(AttributeDescriptor.forInteger("optimisticLockVersion", getClass()));

        result.add(AttributeDescriptor.forBoolean("isActive", getClass()));

        return result;
    }


}
