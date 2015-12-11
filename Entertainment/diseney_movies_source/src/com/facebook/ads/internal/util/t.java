// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;

import java.lang.ref.WeakReference;

public abstract class t
    implements Runnable
{

    private final WeakReference a;

    public t(Object obj)
    {
        a = new WeakReference(obj);
    }

    public Object a()
    {
        return a.get();
    }
}
