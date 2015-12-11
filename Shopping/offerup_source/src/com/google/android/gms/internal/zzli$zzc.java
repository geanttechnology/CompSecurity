// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zza;
import java.lang.ref.WeakReference;

class <init>
    implements android.os.eathRecipient, <init>
{

    private final WeakReference zzacA;
    private final WeakReference zzacB;
    private final WeakReference zzacz;

    private void zzoh()
    {
        Object obj = (<init>)zzacz.get();
        zza zza1 = (zza)zzacA.get();
        if (zza1 != null && obj != null)
        {
            zza1.remove(((ove) (obj)).zznF().intValue());
        }
        obj = (IBinder)zzacB.get();
        if (zzacB != null)
        {
            ((IBinder) (obj)).unlinkToDeath(this, 0);
        }
    }

    public void binderDied()
    {
        zzoh();
    }

    public void zzc(zzoh zzoh1)
    {
        zzoh();
    }

    private ( , zza zza1, IBinder ibinder)
    {
        zzacA = new WeakReference(zza1);
        zzacz = new WeakReference();
        zzacB = new WeakReference(ibinder);
    }

    zzacB(zzacB zzacb, zza zza1, IBinder ibinder, zzacB zzacb1)
    {
        this(zzacb, zza1, ibinder);
    }
}
