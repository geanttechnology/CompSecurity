// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.d;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            ox, ph, ul, pg, 
//            pk

public class pj
    implements ox
{

    public pj()
    {
    }

    public void zza(ul ul1, Map map)
    {
        ph ph1 = zzp.zzbK();
        if (map.containsKey("abort"))
        {
            if (!ph1.a(ul1))
            {
                zzb.zzaE("Precache abort but no preload task running.");
            }
            return;
        }
        String s = (String)map.get("src");
        if (s == null)
        {
            zzb.zzaE("Precache video action is missing the src parameter.");
            return;
        }
        int i;
        try
        {
            i = Integer.parseInt((String)map.get("player"));
        }
        catch (NumberFormatException numberformatexception)
        {
            i = 0;
        }
        if (map.containsKey("mimetype"))
        {
            map = (String)map.get("mimetype");
        } else
        {
            map = "";
        }
        if (ph1.b(ul1))
        {
            zzb.zzaE("Precache task already running.");
            return;
        } else
        {
            d.a(ul1.e());
            (new pg(ul1, ul1.e().zzoF.a(ul1, i, map), s)).zzgn();
            return;
        }
    }
}
