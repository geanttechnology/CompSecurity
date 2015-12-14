// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;

// Referenced classes of package com.google.android.gms.ads.internal.reward.client:
//            zza

public class zze
    implements RewardItem
{

    private final zza zzHc;

    public zze(zza zza1)
    {
        zzHc = zza1;
    }

    public int getAmount()
    {
        if (zzHc == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = zzHc.getAmount();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward getAmount to RewardItem", remoteexception);
            return 0;
        }
        return i;
    }

    public String getType()
    {
        if (zzHc == null)
        {
            return null;
        }
        String s;
        try
        {
            s = zzHc.getType();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward getType to RewardItem", remoteexception);
            return null;
        }
        return s;
    }
}
