// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzez, zzfa, zzeo

class zzzS
    implements Runnable
{

    final zzez zzzR;
    final com.google.ads.st.ErrorCode zzzS;

    public void run()
    {
        try
        {
            zzez.zza(zzzR).onAdFailedToLoad(zzfa.zza(zzzS));
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
        }
    }

    l.client.zzb(zzez zzez1, com.google.ads.st.ErrorCode errorcode)
    {
        zzzR = zzez1;
        zzzS = errorcode;
        super();
    }
}
