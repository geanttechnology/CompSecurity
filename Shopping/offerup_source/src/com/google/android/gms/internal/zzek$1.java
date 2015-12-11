// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzei, zzen, zzek

class zzzF
    implements Runnable
{

    final zzei zzzF;
    final zzek zzzG;

    public void run()
    {
        try
        {
            zzzF.zzzv.destroy();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not destroy mediation adapter.", remoteexception);
        }
    }

    l.client.zzb(zzek zzek, zzei zzei1)
    {
        zzzG = zzek;
        zzzF = zzei1;
        super();
    }
}
