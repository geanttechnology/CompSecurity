// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import java.lang.ref.SoftReference;
import java.util.Hashtable;

public class h
{

    Hashtable a;

    public h()
    {
        a = new Hashtable();
    }

    public Object a(Object obj)
    {
        Object obj1 = (SoftReference)a.get(obj);
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            Object obj2 = ((SoftReference) (obj1)).get();
            obj1 = obj2;
            if (obj2 == null)
            {
                a.remove(obj);
                return obj2;
            }
        }
        return obj1;
    }

    public Object a(Object obj, Object obj1)
    {
        obj = (SoftReference)a.put(obj, new SoftReference(obj1));
        if (obj == null)
        {
            return null;
        } else
        {
            return ((SoftReference) (obj)).get();
        }
    }

    public Object b(Object obj)
    {
        obj = (SoftReference)a.remove(obj);
        if (obj == null)
        {
            return null;
        } else
        {
            return ((SoftReference) (obj)).get();
        }
    }
}
