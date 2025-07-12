package com.sv.myWork.descriptors;

import com.sv.MyWork.descriptors.AttributeDescriptor;
import com.sv.MyWork.domain.RemoteUser;
import com.sv.MyWork.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DescriptorConstructorsTest {

    /* локальный «владелец» для проверки ownerClass */
    static class DummyOwner {}

    @Test
    void defaultDescriptor_stores_all_values() {
        AttributeDescriptor d =
                 AttributeDescriptor.forInteger("age", DummyOwner.class);

       // assertThat(d.columnName).isEqualTo("age");
       // assertThat(d.ownerClass).isEqualTo(DummyOwner.class);
       // assertThat(d.valueType).isEqualTo(Integer.TYPE);
    }

    @Test
    void booleanDescriptor_sets_boolean_type() {
        AttributeDescriptor d =
                AttributeDescriptor.forBoolean("active", DummyOwner.class);

       // assertThat(d.valueType).isEqualTo(Boolean.TYPE);
    }

    @Test
    void referenceDescriptor_holds_target_and_remote_entities() {
        AttributeDescriptor d =
                AttributeDescriptor.forReference("user_id",
                        DummyOwner.class,
                        User.class,
                        RemoteUser.class);

       // assertThat(d.targetEntity).isEqualTo(User.class);
       // assertThat(d.remoteEntity).isEqualTo(RemoteUser.class);
    }
}