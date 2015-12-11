// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.lang.reflect.Method;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, Message

private static final class type extends type
{

    private final Method newBuilderMethod;

    private Object coerceType(Object obj)
    {
        if (type.isInstance(obj))
        {
            return obj;
        } else
        {
            return ((type)GeneratedMessage.access$1400(newBuilderMethod, null, new Object[0])).newBuilderMethod((Message)obj).newBuilderMethod();
        }
    }

    public newBuilderMethod newBuilder()
    {
        return (newBuilderMethod)GeneratedMessage.access$1400(newBuilderMethod, null, new Object[0]);
    }

    public void set(newBuilderMethod newbuildermethod, Object obj)
    {
        super.newBuilderMethod(newbuildermethod, coerceType(obj));
    }

    ( , String s, Class class1, Class class2)
    {
        super(, s, class1, class2);
        newBuilderMethod = GeneratedMessage.access$1300(type, "newBuilder", new Class[0]);
    }
}
