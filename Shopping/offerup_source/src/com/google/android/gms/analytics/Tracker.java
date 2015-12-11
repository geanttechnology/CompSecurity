// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.measurement.zzg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            ExceptionReporter, GoogleAnalytics

public class Tracker extends zzd
{

    private boolean zzLN;
    private final Map zzLO = new HashMap();
    private final zzad zzLP;
    private final zza zzLQ;
    private ExceptionReporter zzLR;
    private zzal zzLS;
    private final Map zzvS = new HashMap();

    Tracker(zzf zzf1, String s, zzad zzad1)
    {
        super(zzf1);
        if (s != null)
        {
            zzvS.put("&tid", s);
        }
        zzvS.put("useSecure", "1");
        zzvS.put("&a", Integer.toString((new Random()).nextInt(0x7fffffff) + 1));
        if (zzad1 == null)
        {
            zzLP = new zzad("tracking");
        } else
        {
            zzLP = zzad1;
        }
        zzLQ = new zza(zzf1);
    }

    static zza zza(Tracker tracker)
    {
        return tracker.zzLQ;
    }

    private static boolean zza(java.util.Map.Entry entry)
    {
        String s = (String)entry.getKey();
        entry.getValue();
        return s.startsWith("&") && s.length() >= 2;
    }

    static com.google.android.gms.analytics.internal.zza zzb(Tracker tracker)
    {
        return tracker.zziA();
    }

    private static String zzb(java.util.Map.Entry entry)
    {
        if (!zza(entry))
        {
            return null;
        } else
        {
            return ((String)entry.getKey()).substring(1);
        }
    }

    private static void zzb(Map map, Map map1)
    {
        zzx.zzw(map1);
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                String s = zzb(entry);
                if (s != null)
                {
                    map1.put(s, entry.getValue());
                }
            }
        }
    }

    static zzk zzc(Tracker tracker)
    {
        return tracker.zziB();
    }

    private static void zzc(Map map, Map map1)
    {
        zzx.zzw(map1);
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                String s = zzb(entry);
                if (s != null && !map1.containsKey(s))
                {
                    map1.put(s, entry.getValue());
                }
            }
        }
    }

    static zzu zzd(Tracker tracker)
    {
        return tracker.zziC();
    }

    static zzu zze(Tracker tracker)
    {
        return tracker.zziC();
    }

    static zzad zzf(Tracker tracker)
    {
        return tracker.zzLP;
    }

    static zzaf zzg(Tracker tracker)
    {
        return tracker.zziu();
    }

    static zzaf zzh(Tracker tracker)
    {
        return tracker.zziu();
    }

    private boolean zzhS()
    {
        return zzLR != null;
    }

    static zzb zzi(Tracker tracker)
    {
        return tracker.zzhP();
    }

    static zzb zzj(Tracker tracker)
    {
        return tracker.zzhP();
    }

    static zzal zzk(Tracker tracker)
    {
        return tracker.zzLS;
    }

    static String zzp(Activity activity)
    {
        zzx.zzw(activity);
        activity = activity.getIntent();
        if (activity != null)
        {
            if (!TextUtils.isEmpty(activity = activity.getStringExtra("android.intent.extra.REFERRER_NAME")))
            {
                return activity;
            }
        }
        return null;
    }

    public void enableAdvertisingIdCollection(boolean flag)
    {
        zzLN = flag;
    }

    public void enableAutoActivityTracking(boolean flag)
    {
        zzLQ.enableAutoActivityTracking(flag);
    }

    public void enableExceptionReporting(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzhS() != flag)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        android.content.Context context = getContext();
        zzLR = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), context);
        Thread.setDefaultUncaughtExceptionHandler(zzLR);
        zzba("Uncaught exceptions will be reported to Google Analytics");
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Thread.setDefaultUncaughtExceptionHandler(zzLR.zzhL());
        zzba("Uncaught exceptions will not be reported to Google Analytics");
          goto _L1
    }

    public String get(String s)
    {
        zziE();
        if (!TextUtils.isEmpty(s))
        {
            if (zzvS.containsKey(s))
            {
                return (String)zzvS.get(s);
            }
            if (s.equals("&ul"))
            {
                return zzam.zza(Locale.getDefault());
            }
            if (s.equals("&cid"))
            {
                return zziz().zzjt();
            }
            if (s.equals("&sr"))
            {
                return zziC().zzkj();
            }
            if (s.equals("&aid"))
            {
                return zziB().zzjb().zzuM();
            }
            if (s.equals("&an"))
            {
                return zziB().zzjb().zzkp();
            }
            if (s.equals("&av"))
            {
                return zziB().zzjb().zzkr();
            }
            if (s.equals("&aiid"))
            {
                return zziB().zzjb().zzyt();
            }
        }
        return null;
    }

    public void send(Map map)
    {
        HashMap hashmap;
        String s;
        long l;
        boolean flag;
        boolean flag1;
        l = zzit().currentTimeMillis();
        if (zzhK().getAppOptOut())
        {
            zzbb("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        flag = zzhK().isDryRunEnabled();
        hashmap = new HashMap();
        zzb(zzvS, hashmap);
        zzb(map, hashmap);
        flag1 = zzam.zze((String)zzvS.get("useSecure"), true);
        zzc(zzLO, hashmap);
        zzLO.clear();
        map = (String)hashmap.get("t");
        if (TextUtils.isEmpty(map))
        {
            zziu().zzh(hashmap, "Missing hit type parameter");
            return;
        }
        s = (String)hashmap.get("tid");
        if (TextUtils.isEmpty(s))
        {
            zziu().zzh(hashmap, "Missing tracking id parameter");
            return;
        }
        boolean flag2 = zzhT();
        this;
        JVM INSTR monitorenter ;
        int j;
        if (!"screenview".equalsIgnoreCase(map) && !"pageview".equalsIgnoreCase(map) && !"appview".equalsIgnoreCase(map) && !TextUtils.isEmpty(map))
        {
            break MISSING_BLOCK_LABEL_257;
        }
        j = Integer.parseInt((String)zzvS.get("&a")) + 1;
        int i;
        i = j;
        if (j >= 0x7fffffff)
        {
            i = 1;
        }
        zzvS.put("&a", Integer.toString(i));
        this;
        JVM INSTR monitorexit ;
        zziw().zzg(new _cls1(hashmap, flag2, map, l, flag, flag1, s));
        return;
        map;
        this;
        JVM INSTR monitorexit ;
        throw map;
    }

    public void set(String s, String s1)
    {
        zzx.zzb(s, "Key should be non-null");
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            zzvS.put(s, s1);
            return;
        }
    }

    public void setAnonymizeIp(boolean flag)
    {
        set("&aip", zzam.zzJ(flag));
    }

    public void setAppId(String s)
    {
        set("&aid", s);
    }

    public void setAppInstallerId(String s)
    {
        set("&aiid", s);
    }

    public void setAppName(String s)
    {
        set("&an", s);
    }

    public void setAppVersion(String s)
    {
        set("&av", s);
    }

    public void setCampaignParamsOnNextHit(Uri uri)
    {
        if (uri != null && !uri.isOpaque())
        {
            if (!TextUtils.isEmpty(uri = uri.getQueryParameter("referrer")))
            {
                uri = Uri.parse((new StringBuilder("http://hostname/?")).append(uri).toString());
                String s = uri.getQueryParameter("utm_id");
                if (s != null)
                {
                    zzLO.put("&ci", s);
                }
                s = uri.getQueryParameter("anid");
                if (s != null)
                {
                    zzLO.put("&anid", s);
                }
                s = uri.getQueryParameter("utm_campaign");
                if (s != null)
                {
                    zzLO.put("&cn", s);
                }
                s = uri.getQueryParameter("utm_content");
                if (s != null)
                {
                    zzLO.put("&cc", s);
                }
                s = uri.getQueryParameter("utm_medium");
                if (s != null)
                {
                    zzLO.put("&cm", s);
                }
                s = uri.getQueryParameter("utm_source");
                if (s != null)
                {
                    zzLO.put("&cs", s);
                }
                s = uri.getQueryParameter("utm_term");
                if (s != null)
                {
                    zzLO.put("&ck", s);
                }
                s = uri.getQueryParameter("dclid");
                if (s != null)
                {
                    zzLO.put("&dclid", s);
                }
                s = uri.getQueryParameter("gclid");
                if (s != null)
                {
                    zzLO.put("&gclid", s);
                }
                uri = uri.getQueryParameter("aclid");
                if (uri != null)
                {
                    zzLO.put("&aclid", uri);
                    return;
                }
            }
        }
    }

    public void setClientId(String s)
    {
        set("&cid", s);
    }

    public void setEncoding(String s)
    {
        set("&de", s);
    }

    public void setHostname(String s)
    {
        set("&dh", s);
    }

    public void setLanguage(String s)
    {
        set("&ul", s);
    }

    public void setLocation(String s)
    {
        set("&dl", s);
    }

    public void setPage(String s)
    {
        set("&dp", s);
    }

    public void setReferrer(String s)
    {
        set("&dr", s);
    }

    public void setSampleRate(double d)
    {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String s)
    {
        set("&sd", s);
    }

    public void setScreenName(String s)
    {
        set("&cd", s);
    }

    public void setScreenResolution(int i, int j)
    {
        if (i < 0 && j < 0)
        {
            zzbd("Invalid width or height. The values should be non-negative.");
            return;
        } else
        {
            set("&sr", (new StringBuilder()).append(i).append("x").append(j).toString());
            return;
        }
    }

    public void setSessionTimeout(long l)
    {
        zzLQ.setSessionTimeout(1000L * l);
    }

    public void setTitle(String s)
    {
        set("&dt", s);
    }

    public void setUseSecure(boolean flag)
    {
        set("useSecure", zzam.zzJ(flag));
    }

    public void setViewportSize(String s)
    {
        set("&vp", s);
    }

    void zza(zzal zzal1)
    {
        zzba("Loading Tracker config values");
        zzLS = zzal1;
        if (zzLS.zzlc())
        {
            zzal1 = zzLS.getTrackingId();
            set("&tid", zzal1);
            zza("trackingId loaded", zzal1);
        }
        if (zzLS.zzld())
        {
            zzal1 = Double.toString(zzLS.zzle());
            set("&sf", zzal1);
            zza("Sample frequency loaded", zzal1);
        }
        if (zzLS.zzlf())
        {
            int i = zzLS.getSessionTimeout();
            setSessionTimeout(i);
            zza("Session timeout loaded", Integer.valueOf(i));
        }
        if (zzLS.zzlg())
        {
            boolean flag = zzLS.zzlh();
            enableAutoActivityTracking(flag);
            zza("Auto activity tracking loaded", Boolean.valueOf(flag));
        }
        if (zzLS.zzli())
        {
            boolean flag1 = zzLS.zzlj();
            if (flag1)
            {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(flag1));
        }
        enableExceptionReporting(zzLS.zzlk());
    }

    protected void zzhR()
    {
        zzLQ.zza();
        String s = zzhQ().zzkp();
        if (s != null)
        {
            set("&an", s);
        }
        s = zzhQ().zzkr();
        if (s != null)
        {
            set("&av", s);
        }
    }

    boolean zzhT()
    {
        return zzLN;
    }

    private class zza extends zzd
        implements GoogleAnalytics.zza
    {

        final Tracker zzMa;
        private boolean zzMb;
        private int zzMc;
        private long zzMd;
        private boolean zzMe;
        private long zzMf;

        private void zzhV()
        {
            if (zzMd >= 0L || zzMb)
            {
                zzhK().zza(com.google.android.gms.analytics.Tracker.zza(zzMa));
                return;
            } else
            {
                zzhK().zzb(com.google.android.gms.analytics.Tracker.zza(zzMa));
                return;
            }
        }

        public void enableAutoActivityTracking(boolean flag)
        {
            zzMb = flag;
            zzhV();
        }

        public void setSessionTimeout(long l)
        {
            zzMd = l;
            zzhV();
        }

        protected void zzhR()
        {
        }

        public boolean zzhU()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag;
            flag = zzMe;
            zzMe = false;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        boolean zzhW()
        {
            return zzit().elapsedRealtime() >= zzMf + Math.max(1000L, zzMd);
        }

        public void zzn(Activity activity)
        {
            if (zzMc == 0 && zzhW())
            {
                zzMe = true;
            }
            zzMc = zzMc + 1;
            if (zzMb)
            {
                Object obj = activity.getIntent();
                if (obj != null)
                {
                    zzMa.setCampaignParamsOnNextHit(((Intent) (obj)).getData());
                }
                HashMap hashmap = new HashMap();
                hashmap.put("&t", "screenview");
                Tracker tracker = zzMa;
                if (com.google.android.gms.analytics.Tracker.zzk(zzMa) != null)
                {
                    obj = com.google.android.gms.analytics.Tracker.zzk(zzMa).zzq(activity);
                } else
                {
                    obj = activity.getClass().getCanonicalName();
                }
                tracker.set("&cd", ((String) (obj)));
                if (TextUtils.isEmpty((CharSequence)hashmap.get("&dr")))
                {
                    activity = Tracker.zzp(activity);
                    if (!TextUtils.isEmpty(activity))
                    {
                        hashmap.put("&dr", activity);
                    }
                }
                zzMa.send(hashmap);
            }
        }

        public void zzo(Activity activity)
        {
            zzMc = zzMc - 1;
            zzMc = Math.max(0, zzMc);
            if (zzMc == 0)
            {
                zzMf = zzit().elapsedRealtime();
            }
        }

        protected zza(zzf zzf1)
        {
            zzMa = Tracker.this;
            super(zzf1);
            zzMd = -1L;
        }
    }


    private class _cls1
        implements Runnable
    {

        final Map zzLT;
        final boolean zzLU;
        final String zzLV;
        final long zzLW;
        final boolean zzLX;
        final boolean zzLY;
        final String zzLZ;
        final Tracker zzMa;

        public void run()
        {
            boolean flag1 = true;
            if (com.google.android.gms.analytics.Tracker.zza(zzMa).zzhU())
            {
                zzLT.put("sc", "start");
            }
            zzam.zzd(zzLT, "cid", zzMa.zzhK().getClientId());
            Object obj = (String)zzLT.get("sf");
            if (obj != null)
            {
                double d = zzam.zza(((String) (obj)), 100D);
                if (zzam.zza(d, (String)zzLT.get("cid")))
                {
                    zzMa.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
                    return;
                }
            }
            obj = com.google.android.gms.analytics.Tracker.zzb(zzMa);
            boolean flag;
            if (zzLU)
            {
                zzam.zzb(zzLT, "ate", ((com.google.android.gms.analytics.internal.zza) (obj)).zzic());
                zzam.zzc(zzLT, "adid", ((com.google.android.gms.analytics.internal.zza) (obj)).zzig());
            } else
            {
                zzLT.remove("ate");
                zzLT.remove("adid");
            }
            obj = Tracker.zzc(zzMa).zzjb();
            zzam.zzc(zzLT, "an", ((zzpb) (obj)).zzkp());
            zzam.zzc(zzLT, "av", ((zzpb) (obj)).zzkr());
            zzam.zzc(zzLT, "aid", ((zzpb) (obj)).zzuM());
            zzam.zzc(zzLT, "aiid", ((zzpb) (obj)).zzyt());
            zzLT.put("v", "1");
            zzLT.put("_v", zze.zzMH);
            zzam.zzc(zzLT, "ul", com.google.android.gms.analytics.Tracker.zzd(zzMa).zzki().getLanguage());
            zzam.zzc(zzLT, "sr", com.google.android.gms.analytics.Tracker.zze(zzMa).zzkj());
            if (zzLV.equals("transaction") || zzLV.equals("item"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && !com.google.android.gms.analytics.Tracker.zzf(zzMa).zzkF())
            {
                com.google.android.gms.analytics.Tracker.zzg(zzMa).zzh(zzLT, "Too many hits sent too quickly, rate limiting invoked");
                return;
            }
            long l1 = zzam.zzbq((String)zzLT.get("ht"));
            long l = l1;
            if (l1 == 0L)
            {
                l = zzLW;
            }
            if (zzLX)
            {
                obj = new zzab(zzMa, zzLT, l, zzLY);
                com.google.android.gms.analytics.Tracker.zzh(zzMa).zzc("Dry run enabled. Would have sent hit", obj);
                return;
            }
            obj = (String)zzLT.get("cid");
            HashMap hashmap = new HashMap();
            zzam.zza(hashmap, "uid", zzLT);
            zzam.zza(hashmap, "an", zzLT);
            zzam.zza(hashmap, "aid", zzLT);
            zzam.zza(hashmap, "av", zzLT);
            zzam.zza(hashmap, "aiid", zzLT);
            String s = zzLZ;
            if (TextUtils.isEmpty((CharSequence)zzLT.get("adid")))
            {
                flag1 = false;
            }
            obj = new zzh(0L, ((String) (obj)), s, flag1, 0L, hashmap);
            l1 = Tracker.zzi(zzMa).zza(((zzh) (obj)));
            zzLT.put("_s", String.valueOf(l1));
            obj = new zzab(zzMa, zzLT, l, zzLY);
            Tracker.zzj(zzMa).zza(((zzab) (obj)));
        }

        _cls1(Map map, boolean flag, String s, long l, boolean flag1, 
                boolean flag2, String s1)
        {
            zzMa = Tracker.this;
            zzLT = map;
            zzLU = flag;
            zzLV = s;
            zzLW = l;
            zzLX = flag1;
            zzLY = flag2;
            zzLZ = s1;
            super();
        }
    }

}
