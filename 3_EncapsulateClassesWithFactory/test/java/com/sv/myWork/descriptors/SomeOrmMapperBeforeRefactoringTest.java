package com.sv.myWork.descriptors;

import com.sv.MyWork.descriptors.AttributeDescriptor;
import com.sv.MyWork.descriptors.SomeOrmMapper;
import com.sv.myWork.descriptors.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/** Проверяем, что клиент собирает правильный набор дескрипторов. */
public class SomeOrmMapperBeforeRefactoringTest {

    /* анонимная имплементация, т.к. SomeOrmMapper абстрактный */
    private final SomeOrmMapper mapper = new SomeOrmMapper() {};

    @Test
    void createAttributeDescriptors_contains_expected_elements() {
        List<AttributeDescriptor> list = mapper.createAttributeDescriptors();

        assertThat(list).hasSize(7)                                   // см. код клиента
                .anyMatch(ad -> ad instanceof BooleanDescriptor)
                .anyMatch(ad -> ad instanceof ReferenceDescriptor)
                .anyMatch(ad -> ad instanceof DefaultDescriptor);
    }
}