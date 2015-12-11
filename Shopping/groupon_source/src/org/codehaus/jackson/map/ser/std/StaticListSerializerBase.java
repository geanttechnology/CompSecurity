// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.ser.std;

import org.codehaus.jackson.map.BeanProperty;

// Referenced classes of package org.codehaus.jackson.map.ser.std:
//            SerializerBase

public abstract class StaticListSerializerBase extends SerializerBase
{

    protected final BeanProperty _property;

    protected StaticListSerializerBase(Class class1, BeanProperty beanproperty)
    {
        super(class1, false);
        _property = beanproperty;
    }
}
