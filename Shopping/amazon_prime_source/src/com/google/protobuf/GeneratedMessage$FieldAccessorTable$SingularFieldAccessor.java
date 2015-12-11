// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.lang.reflect.Method;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage

private static class clearMethod
    implements clearMethod
{

    protected final Method clearMethod;
    protected final Method getMethod;
    protected final Method getMethodBuilder;
    protected final Method hasMethod;
    protected final Method hasMethodBuilder;
    protected final Method setMethod;
    protected final Class type;

    public void addRepeated(clearMethod clearmethod, Object obj)
    {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
    }

    public void clear(clearMethod clearmethod)
    {
        GeneratedMessage.access$1400(clearMethod, clearmethod, new Object[0]);
    }

    public Object get(clearMethod clearmethod)
    {
        return GeneratedMessage.access$1400(getMethodBuilder, clearmethod, new Object[0]);
    }

    public Object get(GeneratedMessage generatedmessage)
    {
        return GeneratedMessage.access$1400(getMethod, generatedmessage, new Object[0]);
    }

    public getMethod getBuilder(getMethod getmethod)
    {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }

    public Object getRepeated(getMethod getmethod, int i)
    {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }

    public Object getRepeated(GeneratedMessage generatedmessage, int i)
    {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }

    public int getRepeatedCount(getMethod getmethod)
    {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }

    public int getRepeatedCount(GeneratedMessage generatedmessage)
    {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }

    public boolean has(getMethod getmethod)
    {
        return ((Boolean)GeneratedMessage.access$1400(hasMethodBuilder, getmethod, new Object[0])).booleanValue();
    }

    public boolean has(GeneratedMessage generatedmessage)
    {
        return ((Boolean)GeneratedMessage.access$1400(hasMethod, generatedmessage, new Object[0])).booleanValue();
    }

    public hasMethod newBuilder()
    {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    public void set(hasMethod hasmethod, Object obj)
    {
        GeneratedMessage.access$1400(setMethod, hasmethod, new Object[] {
            obj
        });
    }

    public void setRepeated(setMethod setmethod, int i, Object obj)
    {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
    }

    ( , String s, Class class1, Class class2)
    {
        getMethod = GeneratedMessage.access$1300(class1, (new StringBuilder()).append("get").append(s).toString(), new Class[0]);
        getMethodBuilder = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("get").append(s).toString(), new Class[0]);
        type = getMethod.getReturnType();
        setMethod = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("set").append(s).toString(), new Class[] {
            type
        });
        hasMethod = GeneratedMessage.access$1300(class1, (new StringBuilder()).append("has").append(s).toString(), new Class[0]);
        hasMethodBuilder = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("has").append(s).toString(), new Class[0]);
        clearMethod = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("clear").append(s).toString(), new Class[0]);
    }
}
