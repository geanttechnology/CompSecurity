// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class MediaProperty
    implements Serializable
{

    private static final Map sRegistry = new HashMap();

    protected MediaProperty()
    {
        sRegistry.put(getName(), this);
    }

    public static MediaProperty fromString(String s)
    {
        return (MediaProperty)sRegistry.get(s);
    }

    public static Collection getRegisteredMediaProperties()
    {
        return sRegistry.values();
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof MediaProperty))
        {
            return false;
        } else
        {
            return getName().equals(((MediaProperty)obj).getName());
        }
    }

    public abstract String getName();

    public String toString()
    {
        return getName();
    }

}
