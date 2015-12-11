// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class cd extends WeakReference
{

    private final Object a;

    public cd(Object obj, Object obj1, ReferenceQueue referencequeue)
    {
        super(obj1, referencequeue);
        a = obj;
    }

    public final Object a()
    {
        return a;
    }
}
