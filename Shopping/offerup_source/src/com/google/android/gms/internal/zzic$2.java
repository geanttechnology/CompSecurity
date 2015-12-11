// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzIt
    implements Callable
{

    final Runnable zzIt;

    public final Object call()
    {
        return zzgA();
    }

    public final Void zzgA()
    {
        zzIt.run();
        return null;
    }

    (Runnable runnable)
    {
        zzIt = runnable;
        super();
    }
}
