// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zziz, zzcf, zzmn, 
//            zzcg

public final class zzdi
    implements zzdk
{

    public zzdi()
    {
    }

    private void zzb(zziz zziz1, Map map)
    {
        String s1 = (String)map.get("label");
        String s = (String)map.get("start_label");
        map = (String)map.get("timestamp");
        if (TextUtils.isEmpty(s1))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No label given for CSI tick.");
            return;
        }
        if (TextUtils.isEmpty(map))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No timestamp given for CSI tick.");
            return;
        }
        long l;
        try
        {
            l = zzc(Long.parseLong(map));
        }
        // Misplaced declaration of an exception variable
        catch (zziz zziz1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Malformed timestamp for CSI tick.", zziz1);
            return;
        }
        map = s;
        if (TextUtils.isEmpty(s))
        {
            map = "native:view_load";
        }
        zziz1.zzhn().zza(s1, map, l);
    }

    private long zzc(long l)
    {
        return (l - zzp.zzbz().currentTimeMillis()) + zzp.zzbz().elapsedRealtime();
    }

    private void zzc(zziz zziz1, Map map)
    {
        map = (String)map.get("value");
        if (TextUtils.isEmpty(map))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No value given for CSI experiment.");
            return;
        }
        zziz1 = zziz1.zzhn().zzdm();
        if (zziz1 == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No ticker for WebView, dropping experiment ID.");
            return;
        } else
        {
            zziz1.zze("e", map);
            return;
        }
    }

    private void zzd(zziz zziz1, Map map)
    {
        String s = (String)map.get("name");
        map = (String)map.get("value");
        if (TextUtils.isEmpty(map))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No value given for CSI extra.");
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No name given for CSI extra.");
            return;
        }
        zziz1 = zziz1.zzhn().zzdm();
        if (zziz1 == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No ticker for WebView, dropping extra parameter.");
            return;
        } else
        {
            zziz1.zze(s, map);
            return;
        }
    }

    public final void zza(zziz zziz1, Map map)
    {
        String s = (String)map.get("action");
        if ("tick".equals(s))
        {
            zzb(zziz1, map);
        } else
        {
            if ("experiment".equals(s))
            {
                zzc(zziz1, map);
                return;
            }
            if ("extra".equals(s))
            {
                zzd(zziz1, map);
                return;
            }
        }
    }
}
