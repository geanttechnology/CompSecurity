// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdg, zzhv, zzew, zzip, 
//            zziq, zzdi, zzan, zzhu

public final class zzdn
    implements zzdg
{

    private final zze zzxj;
    private final zzew zzxk;
    private final zzdi zzxm;

    public zzdn(zzdi zzdi1, zze zze1, zzew zzew1)
    {
        zzxm = zzdi1;
        zzxj = zze1;
        zzxk = zzew1;
    }

    private static void zza(Context context, Map map)
    {
        if (TextUtils.isEmpty((String)map.get("u")))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Destination url cannot be empty.");
            return;
        }
    /* block-local class not found */
    class zzb {}

        map = (new zzb()).zzb(context, map);
        try
        {
            context.startActivity(map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(context.getMessage());
        }
    }

    private static void zzb(zzip zzip1, Map map)
    {
        map = (String)map.get("u");
        if (TextUtils.isEmpty(map))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Destination url cannot be empty.");
            return;
        } else
        {
    /* block-local class not found */
    class zza {}

            (new zza(zzip1, map)).zzgn();
            return;
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
                return zzp.zzbz().zzgw();
            }
            if ("l".equalsIgnoreCase(map))
            {
                return zzp.zzbz().zzgv();
            }
            if ("c".equalsIgnoreCase(map))
            {
                return zzp.zzbz().zzgx();
            }
        }
        return -1;
    }

    private void zzm(boolean flag)
    {
        if (zzxk != null)
        {
            zzxk.zzn(flag);
        }
    }

    public void zza(zzip zzip1, Map map)
    {
        String s = (String)map.get("a");
        if (s == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Action missing from an open GMSG.");
        } else
        {
            if (zzxj != null && !zzxj.zzbe())
            {
                zzxj.zzp((String)map.get("u"));
                return;
            }
            zziq zziq1 = zzip1.zzgS();
            if ("expand".equalsIgnoreCase(s))
            {
                if (zzip1.zzgW())
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaE("Cannot expand WebView that is already expanded.");
                    return;
                } else
                {
                    zzm(false);
                    zziq1.zza(zzc(map), zzd(map));
                    return;
                }
            }
            if ("webapp".equalsIgnoreCase(s))
            {
                zzip1 = (String)map.get("u");
                zzm(false);
                if (zzip1 != null)
                {
                    zziq1.zza(zzc(map), zzd(map), zzip1);
                    return;
                } else
                {
                    zziq1.zza(zzc(map), zzd(map), (String)map.get("html"), (String)map.get("baseurl"));
                    return;
                }
            }
            if ("in_app_purchase".equalsIgnoreCase(s))
            {
                zzip1 = (String)map.get("product_id");
                map = (String)map.get("report_urls");
                if (zzxm != null)
                {
                    if (map != null && !map.isEmpty())
                    {
                        map = map.split(" ");
                        zzxm.zza(zzip1, new ArrayList(Arrays.asList(map)));
                        return;
                    } else
                    {
                        zzxm.zza(zzip1, new ArrayList());
                        return;
                    }
                }
            } else
            {
                if ("app".equalsIgnoreCase(s) && "true".equalsIgnoreCase((String)map.get("play_store")))
                {
                    zzb(zzip1, map);
                    return;
                }
                if ("app".equalsIgnoreCase(s) && "true".equalsIgnoreCase((String)map.get("system_browser")))
                {
                    zza(zzip1.getContext(), map);
                    return;
                }
                zzm(true);
                zzan zzan1 = zzip1.zzgU();
                s = (String)map.get("u");
                if (!TextUtils.isEmpty(s))
                {
                    String s1 = s;
                    if (zzan1 != null)
                    {
                        s1 = s;
                        if (zzan1.zzb(Uri.parse(s)))
                        {
                            s1 = zzp.zzbx().zzd(zzip1.getContext(), s, zzip1.zzha());
                        }
                    }
                    zzip1 = zzp.zzbx().zza(zzip1, s1);
                } else
                {
                    zzip1 = s;
                }
                zziq1.zza(new AdLauncherIntentInfoParcel((String)map.get("i"), zzip1, (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
                return;
            }
        }
    }
}
