// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.common.references;

import java.lang.ref.SoftReference;

public class OOMSoftReference
{

    SoftReference softRef1;
    SoftReference softRef2;
    SoftReference softRef3;

    public OOMSoftReference()
    {
        softRef1 = null;
        softRef2 = null;
        softRef3 = null;
    }

    public void clear()
    {
        if (softRef1 != null)
        {
            softRef1.clear();
            softRef1 = null;
        }
        if (softRef2 != null)
        {
            softRef2.clear();
            softRef2 = null;
        }
        if (softRef3 != null)
        {
            softRef3.clear();
            softRef3 = null;
        }
    }

    public Object get()
    {
        if (softRef1 == null)
        {
            return null;
        } else
        {
            return softRef1.get();
        }
    }

    public void set(Object obj)
    {
        softRef1 = new SoftReference(obj);
        softRef2 = new SoftReference(obj);
        softRef3 = new SoftReference(obj);
    }
}
