// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

// Referenced classes of package org.msgpack.template:
//            TemplateBuilder, FieldOption

public static class option
{

    private Field field;
    private FieldOption option;

    static String arrayTypeToString(Class class1)
    {
        int i = 1;
        for (class1 = class1.getComponentType(); class1.isArray();)
        {
            class1 = class1.getComponentType();
            i++;
        }

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(class1.getName());
        for (int j = 0; j < i; j++)
        {
            stringbuilder.append("[]");
        }

        return stringbuilder.toString();
    }

    public Field getField()
    {
        return field;
    }

    public Type getGenericType()
    {
        return field.getGenericType();
    }

    public String getJavaTypeName()
    {
        Class class1 = field.getType();
        if (class1.isArray())
        {
            return arrayTypeToString(class1);
        } else
        {
            return class1.getName();
        }
    }

    public String getName()
    {
        return field.getName();
    }

    public FieldOption getOption()
    {
        return option;
    }

    public Class getType()
    {
        return field.getType();
    }

    public boolean isAvailable()
    {
        return option != FieldOption.IGNORE;
    }

    public boolean isNullable()
    {
        return option == FieldOption.NULLABLE;
    }

    public boolean isOptional()
    {
        return option == FieldOption.OPTIONAL;
    }

    public boolean isRequired()
    {
        return option == FieldOption.REQUIRED;
    }

    public ()
    {
        field = null;
        option = FieldOption.IGNORE;
    }

    public option(Field field1, FieldOption fieldoption)
    {
        field = field1;
        option = fieldoption;
    }
}
