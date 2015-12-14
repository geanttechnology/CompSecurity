// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzmn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzi

public class zzp
{

    private final Context mContext;
    private final String zzBY;
    private final VersionInfoParcel zzBZ;
    private final zzce zzCa;
    private final zzcg zzCb;
    private final zzig zzCc = (new com.google.android.gms.internal.zzig.zzb()).zza("min_1", 4.9406564584124654E-324D, 1.0D).zza("1_5", 1.0D, 5D).zza("5_10", 5D, 10D).zza("10_20", 10D, 20D).zza("20_30", 20D, 30D).zza("30_max", 30D, 1.7976931348623157E+308D).zzgK();
    private final long zzCd[];
    private final String zzCe[];
    private zzce zzCf;
    private zzce zzCg;
    private zzce zzCh;
    private zzce zzCi;
    private boolean zzCj;
    private zzi zzCk;
    private boolean zzCl;
    private boolean zzCm;
    private long zzCn;

    public zzp(Context context, VersionInfoParcel versioninfoparcel, String s, zzcg zzcg, zzce zzce)
    {
        zzCn = -1L;
        mContext = context;
        zzBZ = versioninfoparcel;
        zzBY = s;
        zzCb = zzcg;
        zzCa = zzce;
        context = (String)zzby.zzuF.get();
        if (context == null)
        {
            zzCe = new String[0];
            zzCd = new long[0];
        } else
        {
            context = TextUtils.split(context, ",");
            zzCe = new String[context.length];
            zzCd = new long[context.length];
            int i = 0;
            while (i < context.length) 
            {
                try
                {
                    zzCd[i] = Long.parseLong(context[i]);
                }
                // Misplaced declaration of an exception variable
                catch (VersionInfoParcel versioninfoparcel)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Unable to parse frame hash target time number.", versioninfoparcel);
                    zzCd[i] = -1L;
                }
                i++;
            }
        }
    }

    private void zzc(zzi zzi1)
    {
        long l = ((Long)zzby.zzuG.get()).longValue();
        long l1 = zzi1.getCurrentPosition();
        int i = 0;
        do
        {
label0:
            {
                if (i < zzCe.length)
                {
                    if (zzCe[i] != null || l <= Math.abs(l1 - zzCd[i]))
                    {
                        break label0;
                    }
                    zzCe[i] = zza(zzi1);
                }
                return;
            }
            i++;
        } while (true);
    }

    private void zzfd()
    {
        if (zzCh != null && zzCi == null)
        {
            zzcc.zza(zzCb, zzCh, new String[] {
                "vff"
            });
            zzcc.zza(zzCb, zzCa, new String[] {
                "vtt"
            });
            zzCi = zzcc.zzb(zzCb);
        }
        long l = com.google.android.gms.ads.internal.zzp.zzbz().nanoTime();
        if (zzCj && zzCm && zzCn != -1L)
        {
            double d = (double)TimeUnit.SECONDS.toNanos(1L) / (double)(l - zzCn);
            zzCc.zza(d);
        }
        zzCm = zzCj;
        zzCn = l;
    }

    public void onStop()
    {
        if (((Boolean)zzby.zzuE.get()).booleanValue() && !zzCl)
        {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", zzBY);
            bundle.putString("player", zzCk.zzer());
            com.google.android.gms.internal.zzig.zza zza1;
            for (Iterator iterator = zzCc.getBuckets().iterator(); iterator.hasNext(); bundle.putString((new StringBuilder("fps_p_")).append(zza1.name).toString(), Double.toString(zza1.zzIV)))
            {
                zza1 = (com.google.android.gms.internal.zzig.zza)iterator.next();
                bundle.putString((new StringBuilder("fps_c_")).append(zza1.name).toString(), Integer.toString(zza1.count));
            }

            for (int i = 0; i < zzCd.length; i++)
            {
                String s = zzCe[i];
                if (s != null)
                {
                    bundle.putString((new StringBuilder("fh_")).append(Long.valueOf(zzCd[i])).toString(), s);
                }
            }

            com.google.android.gms.ads.internal.zzp.zzbv().zza(mContext, zzBZ.zzJu, "gmob-apps", bundle, true);
            zzCl = true;
        }
    }

    String zza(TextureView textureview)
    {
        textureview = textureview.getBitmap(8, 8);
        long l2 = 0L;
        long l1 = 63L;
        for (int i = 0; i < 8;)
        {
            long l3 = l1;
            int j = 0;
            l1 = l2;
            l2 = l3;
            while (j < 8) 
            {
                int k = textureview.getPixel(j, i);
                int l = Color.blue(k);
                int i1 = Color.red(k);
                if (Color.green(k) + (l + i1) > 128)
                {
                    l3 = 1L;
                } else
                {
                    l3 = 0L;
                }
                l1 |= l3 << (int)l2;
                l2--;
                j++;
            }
            i++;
            l3 = l1;
            l1 = l2;
            l2 = l3;
        }

        return String.format("%016X", new Object[] {
            Long.valueOf(l2)
        });
    }

    public void zza(zzi zzi1)
    {
        zzcc.zza(zzCb, zzCa, new String[] {
            "vpc"
        });
        zzCf = zzcc.zzb(zzCb);
        zzCk = zzi1;
    }

    public void zzb(zzi zzi1)
    {
        zzfd();
        zzc(zzi1);
    }

    public void zzeR()
    {
        if (zzCf == null || zzCg != null)
        {
            return;
        } else
        {
            zzcc.zza(zzCb, zzCf, new String[] {
                "vfr"
            });
            zzCg = zzcc.zzb(zzCb);
            return;
        }
    }

    public void zzfe()
    {
        zzCj = true;
        if (zzCg != null && zzCh == null)
        {
            zzcc.zza(zzCb, zzCg, new String[] {
                "vfp"
            });
            zzCh = zzcc.zzb(zzCb);
        }
    }

    public void zzff()
    {
        zzCj = false;
    }
}
