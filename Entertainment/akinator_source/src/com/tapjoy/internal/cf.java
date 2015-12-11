// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.lang.ref.WeakReference;

public final class cf
{

    public WeakReference a;

    public cf()
    {
    }

    public final Object a()
    {
        WeakReference weakreference = a;
        if (weakreference != null)
        {
            return weakreference.get();
        } else
        {
            return null;
        }
    }

    public final void a(Object obj)
    {
        a = new WeakReference(obj);
    }
}
