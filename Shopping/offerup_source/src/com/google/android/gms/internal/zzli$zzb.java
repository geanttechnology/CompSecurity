// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.internal:
//            zzli, zzlj

abstract class zzacy
{

    private final zzlj zzacy;

    public final void zzg(zzli zzli1)
    {
        zzli.zzb(zzli1).lock();
        zzlj zzlj;
        zzlj zzlj1;
        zzlj = zzli.zzc(zzli1);
        zzlj1 = zzacy;
        if (zzlj != zzlj1)
        {
            zzli.zzb(zzli1).unlock();
            return;
        }
        zznO();
        zzli.zzb(zzli1).unlock();
        return;
        Exception exception;
        exception;
        zzli.zzb(zzli1).unlock();
        throw exception;
    }

    protected abstract void zznO();

    protected (zzlj zzlj)
    {
        zzacy = zzlj;
    }
}
