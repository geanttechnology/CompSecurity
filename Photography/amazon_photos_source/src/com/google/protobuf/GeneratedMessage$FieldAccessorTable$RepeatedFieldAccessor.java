// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage

private static class clearMethod
    implements clearMethod
{

    protected final Method addRepeatedMethod;
    protected final Method clearMethod;
    protected final Method getCountMethod;
    protected final Method getCountMethodBuilder;
    protected final Method getMethod;
    protected final Method getMethodBuilder;
    protected final Method getRepeatedMethod;
    protected final Method getRepeatedMethodBuilder;
    protected final Method setRepeatedMethod;
    protected final Class type;

    public void addRepeated(clearMethod clearmethod, Object obj)
    {
        GeneratedMessage.access$1400(addRepeatedMethod, clearmethod, new Object[] {
            obj
        });
    }

    public void clear(addRepeatedMethod addrepeatedmethod)
    {
        GeneratedMessage.access$1400(clearMethod, addrepeatedmethod, new Object[0]);
    }

    public Object get(clearMethod clearmethod)
    {
        return GeneratedMessage.access$1400(getMethodBuilder, clearmethod, new Object[0]);
    }

    public Object get(GeneratedMessage generatedmessage)
    {
        return GeneratedMessage.access$1400(getMethod, generatedmessage, new Object[0]);
    }

    public boolean has(getMethod getmethod)
    {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    public boolean has(GeneratedMessage generatedmessage)
    {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    public getMethod newBuilder()
    {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    public void set(getMethod getmethod, Object obj)
    {
        clear(getmethod);
        for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); addRepeated(getmethod, ((Iterator) (obj)).next())) { }
    }

    ( , String s, Class class1, Class class2)
    {
        getMethod = GeneratedMessage.access$1300(class1, (new StringBuilder()).append("get").append(s).append("List").toString(), new Class[0]);
        getMethodBuilder = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("get").append(s).append("List").toString(), new Class[0]);
        getRepeatedMethod = GeneratedMessage.access$1300(class1, (new StringBuilder()).append("get").append(s).toString(), new Class[] {
            Integer.TYPE
        });
        getRepeatedMethodBuilder = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("get").append(s).toString(), new Class[] {
            Integer.TYPE
        });
        type = getRepeatedMethod.getReturnType();
        setRepeatedMethod = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("set").append(s).toString(), new Class[] {
            Integer.TYPE, type
        });
        addRepeatedMethod = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("add").append(s).toString(), new Class[] {
            type
        });
        getCountMethod = GeneratedMessage.access$1300(class1, (new StringBuilder()).append("get").append(s).append("Count").toString(), new Class[0]);
        getCountMethodBuilder = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("get").append(s).append("Count").toString(), new Class[0]);
        clearMethod = GeneratedMessage.access$1300(class2, (new StringBuilder()).append("clear").append(s).toString(), new Class[0]);
    }
}
