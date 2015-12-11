// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.internal:
//            zzlg, zzli

abstract class <init>
    implements Runnable
{

    final zzlg zzabL;

    public void run()
    {
        zzlg.zzc(zzabL).lock();
        boolean flag = Thread.interrupted();
        if (flag)
        {
            zzlg.zzc(zzabL).unlock();
            return;
        }
        zznO();
        zzlg.zzc(zzabL).unlock();
        return;
        Object obj;
        obj;
        zzlg.zzd(zzabL).zza(((RuntimeException) (obj)));
        zzlg.zzc(zzabL).unlock();
        return;
        obj;
        zzlg.zzc(zzabL).unlock();
        throw obj;
    }

    protected abstract void zznO();

    private (zzlg zzlg1)
    {
        zzabL = zzlg1;
        super();
    }

    zzabL(zzlg zzlg1, zzabL zzabl)
    {
        this(zzlg1);
    }
}
