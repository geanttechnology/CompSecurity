// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser.impl;

import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.map.deser.SettableBeanProperty;

// Referenced classes of package org.codehaus.jackson.map.deser.impl:
//            ExternalTypeHandler

public static class Property
{

    private final HashMap _nameToPropertyIndex = new HashMap();
    private final ArrayList _properties = new ArrayList();

    public void addExternal(SettableBeanProperty settablebeanproperty, String s)
    {
        Integer integer = Integer.valueOf(_properties.size());
        _properties.add(new Property(settablebeanproperty, s));
        _nameToPropertyIndex.put(settablebeanproperty.getName(), integer);
        _nameToPropertyIndex.put(s, integer);
    }

    public ExternalTypeHandler build()
    {
        return new ExternalTypeHandler((Property[])_properties.toArray(new Property[_properties.size()]), _nameToPropertyIndex, null, null);
    }

    public Property()
    {
    }
}
