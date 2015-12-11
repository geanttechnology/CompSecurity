// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;

// Referenced classes of package com.google.common.base:
//            Supplier

public final class Suppliers
{
    private static class SupplierOfInstance
        implements Supplier, Serializable
    {

        final Object instance;

        public Object get()
        {
            return instance;
        }

        SupplierOfInstance(Object obj)
        {
            instance = obj;
        }
    }


    public static Supplier ofInstance(Object obj)
    {
        return new SupplierOfInstance(obj);
    }
}
