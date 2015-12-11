// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzgm

class zzDW
    implements a
{

    final zzgm zzDN;
    final String zzDR;
    final Integer zzDS;
    final Integer zzDT;
    final int zzDU;
    final int zzDV;
    final int zzDW;

    public Object zze(Object obj)
    {
        return zzf((List)obj);
    }

    public zza zzf(List list)
    {
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        String s;
        List list1;
        Integer integer;
        Integer integer1;
        try
        {
            if (list.isEmpty())
            {
                break MISSING_BLOCK_LABEL_93;
            }
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            zzb.zzb("Could not get attribution icon", list);
            return null;
        }
        s = zzDR;
        list1 = zzgm.zze(list);
        integer = zzDS;
        integer1 = zzDT;
        if (zzDU <= 0)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        list = Integer.valueOf(zzDU);
_L1:
        list = new zza(s, list1, integer, integer1, list, zzDV + zzDW);
        return list;
        list = null;
          goto _L1
        return null;
    }

    mats.zza(zzgm zzgm1, String s, Integer integer, Integer integer1, int i, int j, int k)
    {
        zzDN = zzgm1;
        zzDR = s;
        zzDS = integer;
        zzDT = integer1;
        zzDU = i;
        zzDV = j;
        zzDW = k;
        super();
    }
}
