// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzie

public final class zzgw
{

    private int mOrientation;
    private List zzDJ;
    private String zzFU;
    private String zzFV;
    private List zzFW;
    private String zzFX;
    private String zzFY;
    private List zzFZ;
    private long zzGa;
    private boolean zzGb;
    private final long zzGc = -1L;
    private long zzGd;
    private boolean zzGe;
    private boolean zzGf;
    private boolean zzGg;
    private boolean zzGh;
    private int zzGi;
    private String zzGj;
    private boolean zzGk;
    private String zzwq;
    private final AdRequestInfoParcel zzzz;

    public zzgw(AdRequestInfoParcel adrequestinfoparcel)
    {
        zzGa = -1L;
        zzGb = false;
        zzGd = -1L;
        mOrientation = -1;
        zzGe = false;
        zzGf = false;
        zzGg = false;
        zzGh = true;
        zzGi = 0;
        zzGj = "";
        zzGk = false;
        zzzz = adrequestinfoparcel;
    }

    static String zzd(Map map, String s)
    {
        map = (List)map.get(s);
        if (map != null && !map.isEmpty())
        {
            return (String)map.get(0);
        } else
        {
            return null;
        }
    }

    static long zze(Map map, String s)
    {
        map = (List)map.get(s);
        if (map == null || map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        map = (String)map.get(0);
        float f = Float.parseFloat(map);
        return (long)(f * 1000F);
        NumberFormatException numberformatexception;
        numberformatexception;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Could not parse float from ")).append(s).append(" header: ").append(map).toString());
        return -1L;
    }

    static List zzf(Map map, String s)
    {
        map = (List)map.get(s);
        if (map != null && !map.isEmpty())
        {
            map = (String)map.get(0);
            if (map != null)
            {
                return Arrays.asList(map.trim().split("\\s+"));
            }
        }
        return null;
    }

    private boolean zzg(Map map, String s)
    {
        map = (List)map.get(s);
        return map != null && !map.isEmpty() && Boolean.valueOf((String)map.get(0)).booleanValue();
    }

    private void zzi(Map map)
    {
        zzFU = zzd(map, "X-Afma-Ad-Size");
    }

    private void zzj(Map map)
    {
        map = zzf(map, "X-Afma-Click-Tracking-Urls");
        if (map != null)
        {
            zzFW = map;
        }
    }

    private void zzk(Map map)
    {
        map = (List)map.get("X-Afma-Debug-Dialog");
        if (map != null && !map.isEmpty())
        {
            zzFX = (String)map.get(0);
        }
    }

    private void zzl(Map map)
    {
        map = zzf(map, "X-Afma-Tracking-Urls");
        if (map != null)
        {
            zzFZ = map;
        }
    }

    private void zzm(Map map)
    {
        long l = zze(map, "X-Afma-Interstitial-Timeout");
        if (l != -1L)
        {
            zzGa = l;
        }
    }

    private void zzn(Map map)
    {
        zzFY = zzd(map, "X-Afma-ActiveView");
    }

    private void zzo(Map map)
    {
        zzGf = "native".equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzp(Map map)
    {
        zzGe = zzGe | zzg(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzq(Map map)
    {
        zzGb = zzGb | zzg(map, "X-Afma-Mediation");
    }

    private void zzr(Map map)
    {
        map = zzf(map, "X-Afma-Manual-Tracking-Urls");
        if (map != null)
        {
            zzDJ = map;
        }
    }

    private void zzs(Map map)
    {
        long l = zze(map, "X-Afma-Refresh-Rate");
        if (l != -1L)
        {
            zzGd = l;
        }
    }

    private void zzt(Map map)
    {
        map = (List)map.get("X-Afma-Orientation");
        if (map != null && !map.isEmpty())
        {
            map = (String)map.get(0);
            if ("portrait".equalsIgnoreCase(map))
            {
                mOrientation = com.google.android.gms.ads.internal.zzp.zzbx().zzgH();
            } else
            if ("landscape".equalsIgnoreCase(map))
            {
                mOrientation = com.google.android.gms.ads.internal.zzp.zzbx().zzgG();
                return;
            }
        }
    }

    private void zzu(Map map)
    {
        map = (List)map.get("X-Afma-Use-HTTPS");
        if (map != null && !map.isEmpty())
        {
            zzGg = Boolean.valueOf((String)map.get(0)).booleanValue();
        }
    }

    private void zzv(Map map)
    {
        map = (List)map.get("X-Afma-Content-Url-Opted-Out");
        if (map != null && !map.isEmpty())
        {
            zzGh = Boolean.valueOf((String)map.get(0)).booleanValue();
        }
    }

    private void zzw(Map map)
    {
        map = zzf(map, "X-Afma-OAuth-Token-Status");
        zzGi = 0;
        if (map != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        map = map.iterator();
        String s;
        do
        {
            if (!map.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s = (String)map.next();
            if ("Clear".equalsIgnoreCase(s))
            {
                zzGi = 1;
                return;
            }
        } while (!"No-Op".equalsIgnoreCase(s));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        zzGi = 0;
        return;
    }

    private void zzx(Map map)
    {
        map = (List)map.get("X-Afma-Gws-Query-Id");
        if (map != null && !map.isEmpty())
        {
            zzGj = (String)map.get(0);
        }
    }

    private void zzy(Map map)
    {
        map = zzd(map, "X-Afma-Fluid");
        if (map != null && map.equals("height"))
        {
            zzGk = true;
        }
    }

    public final void zzb(String s, Map map, String s1)
    {
        zzFV = s;
        zzwq = s1;
        zzh(map);
    }

    public final void zzh(Map map)
    {
        zzi(map);
        zzj(map);
        zzk(map);
        zzl(map);
        zzm(map);
        zzq(map);
        zzr(map);
        zzs(map);
        zzt(map);
        zzn(map);
        zzu(map);
        zzp(map);
        zzo(map);
        zzv(map);
        zzw(map);
        zzx(map);
        zzy(map);
    }

    public final AdResponseParcel zzj(long l)
    {
        return new AdResponseParcel(zzzz, zzFV, zzwq, zzFW, zzFZ, zzGa, zzGb, -1L, zzDJ, zzGd, mOrientation, zzFU, l, zzFX, zzFY, zzGe, zzGf, zzGg, zzGh, false, zzGi, zzGj, zzGk);
    }
}
