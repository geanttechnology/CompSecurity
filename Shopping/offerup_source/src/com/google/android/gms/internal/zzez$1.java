// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzez, zzeo

class zzzR
    implements Runnable
{

    final zzez zzzR;

    public void run()
    {
        try
        {
            zzez.zza(zzzR).onAdClicked();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not call onAdClicked.", remoteexception);
        }
    }

    l.client.zzb(zzez zzez1)
    {
        zzzR = zzez1;
        super();
    }
}
