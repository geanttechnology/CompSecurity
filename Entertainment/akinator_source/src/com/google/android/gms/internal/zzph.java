// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzph extends zze
{

    private int zzaLA;
    private String zzaLB;
    private String zzaLC;
    private boolean zzaLD;
    private boolean zzaLE;
    private boolean zzaLF;
    private String zzaLy;
    private int zzaLz;

    public zzph()
    {
        this(false);
    }

    public zzph(boolean flag)
    {
        this(flag, zzyL());
    }

    public zzph(boolean flag, int i)
    {
        zzx.zzbI(i);
        zzaLz = i;
        zzaLE = flag;
    }

    static int zzyL()
    {
        UUID uuid = UUID.randomUUID();
        int i = (int)(uuid.getLeastSignificantBits() & 0x7fffffffL);
        if (i == 0)
        {
            int j = (int)(uuid.getMostSignificantBits() & 0x7fffffffL);
            i = j;
            if (j == 0)
            {
                Log.e("GAv4", "UUID.randomUUID() returned 0.");
                return 0x7fffffff;
            }
        }
        return i;
    }

    private void zzyP()
    {
        if (zzaLF)
        {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        } else
        {
            return;
        }
    }

    public void setScreenName(String s)
    {
        zzyP();
        zzaLy = s;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("screenName", zzaLy);
        hashmap.put("interstitial", Boolean.valueOf(zzaLD));
        hashmap.put("automatic", Boolean.valueOf(zzaLE));
        hashmap.put("screenId", Integer.valueOf(zzaLz));
        hashmap.put("referrerScreenId", Integer.valueOf(zzaLA));
        hashmap.put("referrerScreenName", zzaLB);
        hashmap.put("referrerUri", zzaLC);
        return zzB(hashmap);
    }

    public void zza(zzph zzph1)
    {
        if (!TextUtils.isEmpty(zzaLy))
        {
            zzph1.setScreenName(zzaLy);
        }
        if (zzaLz != 0)
        {
            zzph1.zzib(zzaLz);
        }
        if (zzaLA != 0)
        {
            zzph1.zzic(zzaLA);
        }
        if (!TextUtils.isEmpty(zzaLB))
        {
            zzph1.zzdT(zzaLB);
        }
        if (!TextUtils.isEmpty(zzaLC))
        {
            zzph1.zzdU(zzaLC);
        }
        if (zzaLD)
        {
            zzph1.zzam(zzaLD);
        }
        if (zzaLE)
        {
            zzph1.zzal(zzaLE);
        }
    }

    public volatile void zza(zze zze1)
    {
        zza((zzph)zze1);
    }

    public void zzal(boolean flag)
    {
        zzyP();
        zzaLE = flag;
    }

    public void zzam(boolean flag)
    {
        zzyP();
        zzaLD = flag;
    }

    public void zzdT(String s)
    {
        zzyP();
        zzaLB = s;
    }

    public void zzdU(String s)
    {
        zzyP();
        if (TextUtils.isEmpty(s))
        {
            zzaLC = null;
            return;
        } else
        {
            zzaLC = s;
            return;
        }
    }

    public void zzib(int i)
    {
        zzyP();
        zzaLz = i;
    }

    public void zzic(int i)
    {
        zzyP();
        zzaLA = i;
    }

    public String zzyM()
    {
        return zzaLy;
    }

    public int zzyN()
    {
        return zzaLz;
    }

    public String zzyO()
    {
        return zzaLC;
    }
}
