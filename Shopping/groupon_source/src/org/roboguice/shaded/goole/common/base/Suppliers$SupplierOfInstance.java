// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.base;

import java.io.Serializable;

// Referenced classes of package org.roboguice.shaded.goole.common.base:
//            Supplier, Suppliers, Objects

private static class instance
    implements Serializable, Supplier
{

    final Object instance;

    public boolean equals(Object obj)
    {
        if (obj instanceof instance)
        {
            obj = (instance)obj;
            return Objects.equal(instance, ((instance) (obj)).instance);
        } else
        {
            return false;
        }
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
        return (new StringBuilder()).append("Suppliers.ofInstance(").append(instance).append(")").toString();
    }

    I(Object obj)
    {
        instance = obj;
    }
}
