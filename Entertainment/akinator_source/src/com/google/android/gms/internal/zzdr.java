// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzid, zzie, zzfc, 
//            zziz, zzja, zzdm

public final class zzdr
    implements zzdk
{

    private final zze zzxQ;
    private final zzfc zzxR;
    private final zzdm zzxT;

    public zzdr(zzdm zzdm1, zze zze1, zzfc zzfc1)
    {
        zzxT = zzdm1;
        zzxQ = zze1;
        zzxR = zzfc1;
    }

    private static void zza(Context context, Map map)
    {
        if (TextUtils.isEmpty((String)map.get("u")))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Destination url cannot be empty.");
            return;
        }
    /* block-local class not found */
    class zzb {}

        map = (new zzb()).zzb(context, map);
        try
        {
            zzp.zzbv().zzb(context, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(context.getMessage());
        }
    }

    private static boolean zzc(Map map)
    {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map map)
    {
        map = (String)map.get("o");
        if (map != null)
        {
            if ("p".equalsIgnoreCase(map))
            {
                return zzp.zzbx().zzgH();
            }
            if ("l".equalsIgnoreCase(map))
            {
                return zzp.zzbx().zzgG();
            }
            if ("c".equalsIgnoreCase(map))
            {
                return zzp.zzbx().zzgI();
            }
        }
        return -1;
    }

    private static void zze(zziz zziz1, Map map)
    {
        map = (String)map.get("u");
        if (TextUtils.isEmpty(map))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Destination url cannot be empty.");
            return;
        } else
        {
    /* block-local class not found */
    class zza {}

            (new zza(zziz1, map)).zzgz();
            return;
        }
    }

    private void zzm(boolean flag)
    {
        if (zzxR != null)
        {
            zzxR.zzn(flag);
        }
    }

    public void zza(zziz zziz1, Map map)
    {
        String s = (String)map.get("a");
        if (s == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Action missing from an open GMSG.");
        } else
        {
            if (zzxQ != null && !zzxQ.zzbe())
            {
                zzxQ.zzp((String)map.get("u"));
                return;
            }
            zzja zzja1 = zziz1.zzhe();
            if ("expand".equalsIgnoreCase(s))
            {
                if (zziz1.zzhi())
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot expand WebView that is already expanded.");
                    return;
                } else
                {
                    zzm(false);
                    zzja1.zza(zzc(map), zzd(map));
                    return;
                }
            }
            if ("webapp".equalsIgnoreCase(s))
            {
                zziz1 = (String)map.get("u");
                zzm(false);
                if (zziz1 != null)
                {
                    zzja1.zza(zzc(map), zzd(map), zziz1);
                    return;
                } else
                {
                    zzja1.zza(zzc(map), zzd(map), (String)map.get("html"), (String)map.get("baseurl"));
                    return;
                }
            }
            if ("in_app_purchase".equalsIgnoreCase(s))
            {
                zziz1 = (String)map.get("product_id");
                map = (String)map.get("report_urls");
                if (zzxT != null)
                {
                    if (map != null && !map.isEmpty())
                    {
                        map = map.split(" ");
                        zzxT.zza(zziz1, new ArrayList(Arrays.asList(map)));
                        return;
                    } else
                    {
                        zzxT.zza(zziz1, new ArrayList());
                        return;
                    }
                }
            } else
            {
                if ("app".equalsIgnoreCase(s) && "true".equalsIgnoreCase((String)map.get("play_store")))
                {
                    zze(zziz1, map);
                    return;
                }
                if ("app".equalsIgnoreCase(s) && "true".equalsIgnoreCase((String)map.get("system_browser")))
                {
                    zza(zziz1.getContext(), map);
                    return;
                }
                zzm(true);
                zziz1.zzhg();
                s = (String)map.get("u");
                if (!TextUtils.isEmpty(s))
                {
                    zziz1 = zzp.zzbv().zza(zziz1, s);
                } else
                {
                    zziz1 = s;
                }
                zzja1.zza(new AdLauncherIntentInfoParcel((String)map.get("i"), zziz1, (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
                return;
            }
        }
    }
}
