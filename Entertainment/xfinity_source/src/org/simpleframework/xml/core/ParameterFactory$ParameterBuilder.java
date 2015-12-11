// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            ParameterFactory

private static class type
{

    private final Class entry;
    private final Class label;
    private final Class type;

    private transient Constructor getConstructor(Class aclass[])
        throws Exception
    {
        return type.getConstructor(aclass);
    }

    public Constructor getConstructor()
        throws Exception
    {
        if (entry != null)
        {
            return getConstructor(label, entry);
        } else
        {
            return getConstructor(label);
        }
    }

    public Constructor getConstructor(Class class1)
        throws Exception
    {
        return getConstructor(new Class[] {
            java/lang/reflect/Constructor, class1, org/simpleframework/xml/stream/Format, Integer.TYPE
        });
    }

    public Constructor getConstructor(Class class1, Class class2)
        throws Exception
    {
        return getConstructor(new Class[] {
            java/lang/reflect/Constructor, class1, class2, org/simpleframework/xml/stream/Format, Integer.TYPE
        });
    }

    public (Class class1, Class class2)
    {
        this(class1, class2, null);
    }

    public <init>(Class class1, Class class2, Class class3)
    {
        label = class2;
        entry = class3;
        type = class1;
    }
}
