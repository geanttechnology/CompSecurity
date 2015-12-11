// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.f;

import java.lang.ref.WeakReference;

public abstract class u
    implements Runnable
{

    public final WeakReference a;

    public u(Object obj)
    {
        a = new WeakReference(obj);
    }
}
