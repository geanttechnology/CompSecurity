// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.lang.reflect.Method;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage

private static final class type extends type
{

    private Method getValueDescriptorMethod;
    private Method valueOfMethod;

    public Object get(type type)
    {
        return GeneratedMessage.access$1400(getValueDescriptorMethod, super.getValueDescriptorMethod(type), new Object[0]);
    }

    public Object get(GeneratedMessage generatedmessage)
    {
        return GeneratedMessage.access$1400(getValueDescriptorMethod, super.getValueDescriptorMethod(generatedmessage), new Object[0]);
    }

    public void set(getValueDescriptorMethod getvaluedescriptormethod, Object obj)
    {
        super.getValueDescriptorMethod(getvaluedescriptormethod, GeneratedMessage.access$1400(valueOfMethod, null, new Object[] {
            obj
        }));
    }

    ( , String s, Class class1, Class class2)
    {
        super(, s, class1, class2);
        valueOfMethod = GeneratedMessage.access$1300(type, "valueOf", new Class[] {
            com/google/protobuf/Descriptors$EnumValueDescriptor
        });
        getValueDescriptorMethod = GeneratedMessage.access$1300(type, "getValueDescriptor", new Class[0]);
    }
}
