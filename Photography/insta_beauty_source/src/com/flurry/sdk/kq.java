// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class kq extends WeakReference
{

    public kq(Object obj)
    {
        super(obj);
    }

    public boolean equals(Object obj)
    {
        Object obj1 = get();
        if (obj instanceof Reference)
        {
            return obj1.equals(((Reference)obj).get());
        } else
        {
            return obj1.equals(obj);
        }
    }

    public int hashCode()
    {
        Object obj = get();
        if (obj == null)
        {
            return super.hashCode();
        } else
        {
            return obj.hashCode();
        }
    }
}
