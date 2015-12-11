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

public static class _propertiesToExclude extends SimpleBeanPropertyFilter
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    protected final Set _propertiesToExclude;

    protected boolean include(BeanPropertyWriter beanpropertywriter)
    {
        return !_propertiesToExclude.contains(beanpropertywriter.getName());
    }

    protected boolean include(PropertyWriter propertywriter)
    {
        return !_propertiesToExclude.contains(propertywriter.getName());
    }

    public (Set set)
    {
        _propertiesToExclude = set;
    }
}
