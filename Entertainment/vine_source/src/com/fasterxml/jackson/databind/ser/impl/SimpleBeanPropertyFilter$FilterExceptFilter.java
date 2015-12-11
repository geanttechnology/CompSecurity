// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import java.io.Serializable;
import java.util.Set;

// Referenced classes of package com.fasterxml.jackson.databind.ser.impl:
//            SimpleBeanPropertyFilter

public static class _propertiesToInclude extends SimpleBeanPropertyFilter
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    protected final Set _propertiesToInclude;

    protected boolean include(BeanPropertyWriter beanpropertywriter)
    {
        return _propertiesToInclude.contains(beanpropertywriter.getName());
    }

    protected boolean include(PropertyWriter propertywriter)
    {
        return _propertiesToInclude.contains(propertywriter.getName());
    }

    public Y(Set set)
    {
        _propertiesToInclude = set;
    }
}
