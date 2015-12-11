// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzl, zzm

public final class zzy
{
    public static final class zza
    {

        private Date zzaT;
        private Location zzaX;
        private boolean zzoN;
        private int zzsR;
        private int zzsU;
        private String zzsV;
        private String zzsX;
        private final Bundle zzsZ = new Bundle();
        private final HashMap zztA = new HashMap();
        private final HashSet zztB = new HashSet();
        private final HashSet zztC = new HashSet();
        private String zztb;
        private final Bundle zztu = new Bundle();
        private final HashSet zztz = new HashSet();

        static Date zza(zza zza1)
        {
            return zza1.zzaT;
        }

        static String zzb(zza zza1)
        {
            return zza1.zzsX;
        }

        static int zzc(zza zza1)
        {
            return zza1.zzsR;
        }

        static HashSet zzd(zza zza1)
        {
            return zza1.zztz;
        }

        static Location zze(zza zza1)
        {
            return zza1.zzaX;
        }

        static boolean zzf(zza zza1)
        {
            return zza1.zzoN;
        }

        static Bundle zzg(zza zza1)
        {
            return zza1.zztu;
        }

        static HashMap zzh(zza zza1)
        {
            return zza1.zztA;
        }

        static String zzi(zza zza1)
        {
            return zza1.zzsV;
        }

        static String zzj(zza zza1)
        {
            return zza1.zztb;
        }

        static int zzk(zza zza1)
        {
            return zza1.zzsU;
        }

        static HashSet zzl(zza zza1)
        {
            return zza1.zztB;
        }

        static Bundle zzm(zza zza1)
        {
            return zza1.zzsZ;
        }

        static HashSet zzn(zza zza1)
        {
            return zza1.zztC;
        }

        public void setManualImpressionsEnabled(boolean flag)
        {
            zzoN = flag;
        }

        public void zzF(String s)
        {
            zztz.add(s);
        }

        public void zzG(String s)
        {
            zztB.add(s);
        }

        public void zzH(String s)
        {
            zztB.remove(s);
        }

        public void zzI(String s)
        {
            zzsX = s;
        }

        public void zzJ(String s)
        {
            zzsV = s;
        }

        public void zzK(String s)
        {
            zztb = s;
        }

        public void zzL(String s)
        {
            zztC.add(s);
        }

        public void zza(NetworkExtras networkextras)
        {
            if (networkextras instanceof AdMobExtras)
            {
                zza(com/google/ads/mediation/admob/AdMobAdapter, ((AdMobExtras)networkextras).getExtras());
                return;
            } else
            {
                zztA.put(networkextras.getClass(), networkextras);
                return;
            }
        }

        public void zza(Class class1, Bundle bundle)
        {
            zztu.putBundle(class1.getName(), bundle);
        }

        public void zza(Date date)
        {
            zzaT = date;
        }

        public void zzb(Location location)
        {
            zzaX = location;
        }

        public void zzb(Class class1, Bundle bundle)
        {
            if (zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null)
            {
                zztu.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(class1.getName(), bundle);
        }

        public void zzb(String s, String s1)
        {
            zzsZ.putString(s, s1);
        }

        public void zzj(boolean flag)
        {
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            zzsU = i;
        }

        public void zzm(int i)
        {
            zzsR = i;
        }

        public zza()
        {
            zzsR = -1;
            zzoN = false;
            zzsU = -1;
        }
    }


    public static final String DEVICE_ID_EMULATOR = zzl.zzcF().zzaE("emulator");
    private final Date zzaT;
    private final Set zzaV;
    private final Location zzaX;
    private final boolean zzoN;
    private final int zzsR;
    private final int zzsU;
    private final String zzsV;
    private final String zzsX;
    private final Bundle zzsZ;
    private final String zztb;
    private final Bundle zztu;
    private final Map zztv;
    private final SearchAdRequest zztw;
    private final Set zztx;
    private final Set zzty;

    public zzy(zza zza1)
    {
        this(zza1, null);
    }

    public zzy(zza zza1, SearchAdRequest searchadrequest)
    {
        zzaT = com.google.android.gms.ads.internal.client.zza.zza(zza1);
        zzsX = zza.zzb(zza1);
        zzsR = zza.zzc(zza1);
        zzaV = Collections.unmodifiableSet(zza.zzd(zza1));
        zzaX = zza.zze(zza1);
        zzoN = zza.zzf(zza1);
        zztu = zza.zzg(zza1);
        zztv = Collections.unmodifiableMap(zza.zzh(zza1));
        zzsV = zza.zzi(zza1);
        zztb = zza.zzj(zza1);
        zztw = searchadrequest;
        zzsU = zza.zzk(zza1);
        zztx = Collections.unmodifiableSet(zza.zzl(zza1));
        zzsZ = zza.zzm(zza1);
        zzty = Collections.unmodifiableSet(zza.zzn(zza1));
    }

    public static void updateCorrelator()
    {
        zzl.zzcH().zzcL();
    }

    public Date getBirthday()
    {
        return zzaT;
    }

    public String getContentUrl()
    {
        return zzsX;
    }

    public Bundle getCustomEventExtrasBundle(Class class1)
    {
        Bundle bundle = zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null)
        {
            return bundle.getBundle(class1.getClass().getName());
        } else
        {
            return null;
        }
    }

    public Bundle getCustomTargeting()
    {
        return zzsZ;
    }

    public int getGender()
    {
        return zzsR;
    }

    public Set getKeywords()
    {
        return zzaV;
    }

    public Location getLocation()
    {
        return zzaX;
    }

    public boolean getManualImpressionsEnabled()
    {
        return zzoN;
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return (NetworkExtras)zztv.get(class1);
    }

    public Bundle getNetworkExtrasBundle(Class class1)
    {
        return zztu.getBundle(class1.getName());
    }

    public String getPublisherProvidedId()
    {
        return zzsV;
    }

    public boolean isTestDevice(Context context)
    {
        return zztx.contains(zzl.zzcF().zzQ(context));
    }

    public String zzcM()
    {
        return zztb;
    }

    public SearchAdRequest zzcN()
    {
        return zztw;
    }

    public Map zzcO()
    {
        return zztv;
    }

    public Bundle zzcP()
    {
        return zztu;
    }

    public int zzcQ()
    {
        return zzsU;
    }

    public Set zzcR()
    {
        return zzty;
    }

}
