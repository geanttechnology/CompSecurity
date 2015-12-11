// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjl;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpf;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.measurement.zzi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            zzc, GoogleAnalytics

public class zzb extends zzc
    implements zzi
{

    private static DecimalFormat zzLp;
    private final zzf zzLf;
    private final String zzLq;
    private final Uri zzLr;
    private final boolean zzLs;
    private final boolean zzLt;

    public zzb(zzf zzf1, String s)
    {
        this(zzf1, s, true, false);
    }

    public zzb(zzf zzf1, String s, boolean flag, boolean flag1)
    {
        super(zzf1);
        zzx.zzcr(s);
        zzLf = zzf1;
        zzLq = s;
        zzLs = flag;
        zzLt = flag1;
        zzLr = zzaR(zzLq);
    }

    private static String zzA(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }

    private static void zza(Map map, String s, double d)
    {
        if (d != 0.0D)
        {
            map.put(s, zzb(d));
        }
    }

    private static void zza(Map map, String s, int i, int j)
    {
        if (i > 0 && j > 0)
        {
            map.put(s, (new StringBuilder()).append(i).append("x").append(j).toString());
        }
    }

    private static void zza(Map map, String s, boolean flag)
    {
        if (flag)
        {
            map.put(s, "1");
        }
    }

    static Uri zzaR(String s)
    {
        zzx.zzcr(s);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(s);
        return builder.build();
    }

    static String zzb(double d)
    {
        if (zzLp == null)
        {
            zzLp = new DecimalFormat("0.######");
        }
        return zzLp.format(d);
    }

    private static void zzb(Map map, String s, String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            map.put(s, s1);
        }
    }

    public static Map zzc(com.google.android.gms.measurement.zzc zzc1)
    {
        HashMap hashmap = new HashMap();
        Object obj = (zzjn)zzc1.zzd(com/google/android/gms/internal/zzjn);
        if (obj != null)
        {
            obj = ((zzjn) (obj)).zzhZ().entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s = zzh(entry.getValue());
                if (s != null)
                {
                    hashmap.put(entry.getKey(), s);
                }
            } while (true);
        }
        obj = (zzjo)zzc1.zzd(com/google/android/gms/internal/zzjo);
        if (obj != null)
        {
            zzb(hashmap, "t", ((zzjo) (obj)).zzia());
            zzb(hashmap, "cid", ((zzjo) (obj)).getClientId());
            zzb(hashmap, "uid", ((zzjo) (obj)).getUserId());
            zzb(hashmap, "sc", ((zzjo) (obj)).zzid());
            zza(hashmap, "sf", ((zzjo) (obj)).zzif());
            zza(hashmap, "ni", ((zzjo) (obj)).zzie());
            zzb(hashmap, "adid", ((zzjo) (obj)).zzib());
            zza(hashmap, "ate", ((zzjo) (obj)).zzic());
        }
        obj = (zzph)zzc1.zzd(com/google/android/gms/internal/zzph);
        if (obj != null)
        {
            zzb(hashmap, "cd", ((zzph) (obj)).zzyM());
            zza(hashmap, "a", ((zzph) (obj)).zzyN());
            zzb(hashmap, "dr", ((zzph) (obj)).zzyO());
        }
        obj = (zzpf)zzc1.zzd(com/google/android/gms/internal/zzpf);
        if (obj != null)
        {
            zzb(hashmap, "ec", ((zzpf) (obj)).zzyJ());
            zzb(hashmap, "ea", ((zzpf) (obj)).getAction());
            zzb(hashmap, "el", ((zzpf) (obj)).getLabel());
            zza(hashmap, "ev", ((zzpf) (obj)).getValue());
        }
        obj = (zzpc)zzc1.zzd(com/google/android/gms/internal/zzpc);
        if (obj != null)
        {
            zzb(hashmap, "cn", ((zzpc) (obj)).getName());
            zzb(hashmap, "cs", ((zzpc) (obj)).getSource());
            zzb(hashmap, "cm", ((zzpc) (obj)).zzyu());
            zzb(hashmap, "ck", ((zzpc) (obj)).zzyv());
            zzb(hashmap, "cc", ((zzpc) (obj)).getContent());
            zzb(hashmap, "ci", ((zzpc) (obj)).getId());
            zzb(hashmap, "anid", ((zzpc) (obj)).zzyw());
            zzb(hashmap, "gclid", ((zzpc) (obj)).zzyx());
            zzb(hashmap, "dclid", ((zzpc) (obj)).zzyy());
            zzb(hashmap, "aclid", ((zzpc) (obj)).zzyz());
        }
        obj = (zzpg)zzc1.zzd(com/google/android/gms/internal/zzpg);
        if (obj != null)
        {
            zzb(hashmap, "exd", ((zzpg) (obj)).getDescription());
            zza(hashmap, "exf", ((zzpg) (obj)).zzyK());
        }
        obj = (zzpi)zzc1.zzd(com/google/android/gms/internal/zzpi);
        if (obj != null)
        {
            zzb(hashmap, "sn", ((zzpi) (obj)).zzyQ());
            zzb(hashmap, "sa", ((zzpi) (obj)).getAction());
            zzb(hashmap, "st", ((zzpi) (obj)).getTarget());
        }
        obj = (zzpj)zzc1.zzd(com/google/android/gms/internal/zzpj);
        if (obj != null)
        {
            zzb(hashmap, "utv", ((zzpj) (obj)).zzyR());
            zza(hashmap, "utt", ((zzpj) (obj)).getTimeInMillis());
            zzb(hashmap, "utc", ((zzpj) (obj)).zzyJ());
            zzb(hashmap, "utl", ((zzpj) (obj)).getLabel());
        }
        obj = (zzjl)zzc1.zzd(com/google/android/gms/internal/zzjl);
        if (obj != null)
        {
            obj = ((zzjl) (obj)).zzhX().entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s1 = com.google.android.gms.analytics.zzc.zzQ(((Integer)entry1.getKey()).intValue());
                if (!TextUtils.isEmpty(s1))
                {
                    hashmap.put(s1, entry1.getValue());
                }
            } while (true);
        }
        obj = (zzjm)zzc1.zzd(com/google/android/gms/internal/zzjm);
        if (obj != null)
        {
            obj = ((zzjm) (obj)).zzhY().entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry2 = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s2 = com.google.android.gms.analytics.zzc.zzS(((Integer)entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(s2))
                {
                    hashmap.put(s2, zzb(((Double)entry2.getValue()).doubleValue()));
                }
            } while (true);
        }
        obj = (zzpe)zzc1.zzd(com/google/android/gms/internal/zzpe);
        if (obj != null)
        {
            Object obj1 = ((zzpe) (obj)).zzyF();
            if (obj1 != null)
            {
                for (obj1 = ((ProductAction) (obj1)).build().entrySet().iterator(); ((Iterator) (obj1)).hasNext();)
                {
                    java.util.Map.Entry entry4 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                    if (((String)entry4.getKey()).startsWith("&"))
                    {
                        hashmap.put(((String)entry4.getKey()).substring(1), entry4.getValue());
                    } else
                    {
                        hashmap.put(entry4.getKey(), entry4.getValue());
                    }
                }

            }
            obj1 = ((zzpe) (obj)).zzyI().iterator();
            for (int i = 1; ((Iterator) (obj1)).hasNext(); i++)
            {
                hashmap.putAll(((Promotion)((Iterator) (obj1)).next()).zzaX(com.google.android.gms.analytics.zzc.zzW(i)));
            }

            obj1 = ((zzpe) (obj)).zzyG().iterator();
            for (int j = 1; ((Iterator) (obj1)).hasNext(); j++)
            {
                hashmap.putAll(((Product)((Iterator) (obj1)).next()).zzaX(com.google.android.gms.analytics.zzc.zzU(j)));
            }

            obj = ((zzpe) (obj)).zzyH().entrySet().iterator();
            for (int k = 1; ((Iterator) (obj)).hasNext(); k++)
            {
                java.util.Map.Entry entry3 = (java.util.Map.Entry)((Iterator) (obj)).next();
                Object obj2 = (List)entry3.getValue();
                String s3 = com.google.android.gms.analytics.zzc.zzZ(k);
                obj2 = ((List) (obj2)).iterator();
                for (int l = 1; ((Iterator) (obj2)).hasNext(); l++)
                {
                    hashmap.putAll(((Product)((Iterator) (obj2)).next()).zzaX((new StringBuilder()).append(s3).append(com.google.android.gms.analytics.zzc.zzX(l)).toString()));
                }

                if (!TextUtils.isEmpty((CharSequence)entry3.getKey()))
                {
                    hashmap.put((new StringBuilder()).append(s3).append("nm").toString(), entry3.getKey());
                }
            }

        }
        obj = (zzpd)zzc1.zzd(com/google/android/gms/internal/zzpd);
        if (obj != null)
        {
            zzb(hashmap, "ul", ((zzpd) (obj)).getLanguage());
            zza(hashmap, "sd", ((zzpd) (obj)).zzyA());
            zza(hashmap, "sr", ((zzpd) (obj)).zzyB(), ((zzpd) (obj)).zzyC());
            zza(hashmap, "vp", ((zzpd) (obj)).zzyD(), ((zzpd) (obj)).zzyE());
        }
        zzc1 = (zzpb)zzc1.zzd(com/google/android/gms/internal/zzpb);
        if (zzc1 != null)
        {
            zzb(hashmap, "an", zzc1.zzkp());
            zzb(hashmap, "aid", zzc1.zzuM());
            zzb(hashmap, "aiid", zzc1.zzyt());
            zzb(hashmap, "av", zzc1.zzkr());
        }
        return hashmap;
    }

    private static String zzh(Object obj)
    {
        if (obj == null)
        {
            obj = null;
        } else
        if (obj instanceof String)
        {
            String s = (String)obj;
            obj = s;
            if (TextUtils.isEmpty(s))
            {
                return null;
            }
        } else
        {
            if (obj instanceof Double)
            {
                obj = (Double)obj;
                if (((Double) (obj)).doubleValue() != 0.0D)
                {
                    return zzb(((Double) (obj)).doubleValue());
                } else
                {
                    return null;
                }
            }
            if (obj instanceof Boolean)
            {
                if (obj != Boolean.FALSE)
                {
                    return "1";
                } else
                {
                    return null;
                }
            } else
            {
                return String.valueOf(obj);
            }
        }
        return ((String) (obj));
    }

    public void zzb(com.google.android.gms.measurement.zzc zzc1)
    {
        zzx.zzw(zzc1);
        zzx.zzb(zzc1.zzyj(), "Can't deliver not submitted measurement");
        zzx.zzcj("deliver should be called on worker thread");
        Object obj1 = zzc1.zzye();
        Object obj = (zzjo)((com.google.android.gms.measurement.zzc) (obj1)).zze(com/google/android/gms/internal/zzjo);
        if (TextUtils.isEmpty(((zzjo) (obj)).zzia()))
        {
            zziu().zzh(zzc(((com.google.android.gms.measurement.zzc) (obj1))), "Ignoring measurement without type");
        } else
        {
            if (TextUtils.isEmpty(((zzjo) (obj)).getClientId()))
            {
                zziu().zzh(zzc(((com.google.android.gms.measurement.zzc) (obj1))), "Ignoring measurement without client id");
                return;
            }
            if (!zzLf.zziI().getAppOptOut())
            {
                double d = ((zzjo) (obj)).zzif();
                if (zzam.zza(d, ((zzjo) (obj)).getClientId()))
                {
                    zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
                    return;
                }
                obj1 = zzc(((com.google.android.gms.measurement.zzc) (obj1)));
                ((Map) (obj1)).put("v", "1");
                ((Map) (obj1)).put("_v", zze.zzMH);
                ((Map) (obj1)).put("tid", zzLq);
                if (zzLf.zziI().isDryRunEnabled())
                {
                    zzc("Dry run is enabled. GoogleAnalytics would have sent", zzA(((Map) (obj1))));
                    return;
                }
                HashMap hashmap = new HashMap();
                zzam.zzc(hashmap, "uid", ((zzjo) (obj)).getUserId());
                Object obj2 = (zzpb)zzc1.zzd(com/google/android/gms/internal/zzpb);
                if (obj2 != null)
                {
                    zzam.zzc(hashmap, "an", ((zzpb) (obj2)).zzkp());
                    zzam.zzc(hashmap, "aid", ((zzpb) (obj2)).zzuM());
                    zzam.zzc(hashmap, "av", ((zzpb) (obj2)).zzkr());
                    zzam.zzc(hashmap, "aiid", ((zzpb) (obj2)).zzyt());
                }
                obj2 = ((zzjo) (obj)).getClientId();
                String s = zzLq;
                boolean flag;
                if (!TextUtils.isEmpty(((zzjo) (obj)).zzib()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj = new zzh(0L, ((String) (obj2)), s, flag, 0L, hashmap);
                ((Map) (obj1)).put("_s", String.valueOf(zzhP().zza(((zzh) (obj)))));
                zzc1 = new zzab(zziu(), ((Map) (obj1)), zzc1.zzyh(), true);
                zzhP().zza(zzc1);
                return;
            }
        }
    }

    public Uri zzhI()
    {
        return zzLr;
    }
}
