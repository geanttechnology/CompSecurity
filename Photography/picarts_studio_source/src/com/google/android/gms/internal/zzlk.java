// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzlk
{

    private static final ExecutorService zzacD = Executors.newFixedThreadPool(2, new zza(null));

    public static ExecutorService zzoj()
    {
        return zzacD;
    }


    /* member class not found */
    class zza {}

}
