// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Provider;
import org.roboguice.shaded.goole.common.base.Objects;

// Referenced classes of package com.google.inject.util:
//            Providers

private static final class <init>
    implements Provider
{

    private final Object instance;

    public boolean equals(Object obj)
    {
        return (obj instanceof <init>) && Objects.equal(instance, ((instance)obj).instance);
    }

    public Object get()
    {
        return instance;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            instance
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("of(").append(instance).append(")").toString();
    }

    private (Object obj)
    {
        instance = obj;
    }

    instance(Object obj, instance instance1)
    {
        this(obj);
    }
}
