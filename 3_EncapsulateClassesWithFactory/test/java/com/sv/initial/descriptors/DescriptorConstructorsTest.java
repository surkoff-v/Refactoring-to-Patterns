package com.sv.initial.descriptors;

import com.sv.initial.domain.RemoteUser;
import com.sv.initial.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DescriptorConstructorsTest {

    /* локальный «владелец» для проверки ownerClass */
    static class DummyOwner {}

    @Test
    void defaultDescriptor_stores_all_values() {
        DefaultDescriptor d =
                new DefaultDescriptor("age", DummyOwner.class, Integer.TYPE);

        assertThat(d.columnName).isEqualTo("age");
        assertThat(d.ownerClass).isEqualTo(DummyOwner.class);
        assertThat(d.valueType).isEqualTo(Integer.TYPE);
    }

    @Test
    void booleanDescriptor_sets_boolean_type() {
        BooleanDescriptor d =
                new BooleanDescriptor("active", DummyOwner.class, Boolean.TYPE);

        assertThat(d.valueType).isEqualTo(Boolean.TYPE);
    }

    @Test
    void referenceDescriptor_holds_target_and_remote_entities() {
        ReferenceDescriptor d =
                new ReferenceDescriptor("user_id",
                        DummyOwner.class,
                        User.class,
                        RemoteUser.class);

        assertThat(d.targetEntity).isEqualTo(User.class);
        assertThat(d.remoteEntity).isEqualTo(RemoteUser.class);
    }
}