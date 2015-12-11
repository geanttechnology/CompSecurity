// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzc, zzp, zzv

class zzs extends zzy
{
    public final class zza
    {

        private final long zzaNp;
        private boolean zzaNq;
        final zzs zzaNr;
        private long zzavc;
        private final String zzue;

        private void zzzX()
        {
            if (zzaNq)
            {
                return;
            } else
            {
                zzaNq = true;
                zzavc = zzs.zza(zzaNr).getLong(zzue, zzaNp);
                return;
            }
        }

        public long get()
        {
            zzzX();
            return zzavc;
        }

        public void set(long l)
        {
            android.content.SharedPreferences.Editor editor = zzs.zza(zzaNr).edit();
            editor.putLong(zzue, l);
            editor.apply();
            zzavc = l;
        }

        public zza(String s, long l)
        {
            zzaNr = zzs.this;
            super();
            zzx.zzcr(s);
            zzue = s;
            zzaNp = l;
        }
    }

    public final class zzb
    {

        private final long zzPG;
        final zzs zzaNr;
        final String zzaNs;
        private final String zzaNt;
        private final String zzaNu;

        private void zzkU()
        {
            zzaNr.zzis();
            long l = zzaNr.zzit().currentTimeMillis();
            android.content.SharedPreferences.Editor editor = zzs.zza(zzaNr).edit();
            editor.remove(zzaNt);
            editor.remove(zzaNu);
            editor.putLong(zzaNs, l);
            editor.apply();
        }

        private long zzkV()
        {
            zzaNr.zzis();
            long l = zzkX();
            if (l == 0L)
            {
                zzkU();
                return 0L;
            } else
            {
                return Math.abs(l - zzaNr.zzit().currentTimeMillis());
            }
        }

        private long zzkX()
        {
            return zzs.zzb(zzaNr).getLong(zzaNs, 0L);
        }

        public void zzbn(String s)
        {
            zzaNr.zzis();
            if (zzkX() == 0L)
            {
                zzkU();
            }
            String s1 = s;
            if (s == null)
            {
                s1 = "";
            }
            long l = zzs.zza(zzaNr).getLong(zzaNt, 0L);
            if (l <= 0L)
            {
                s = zzs.zza(zzaNr).edit();
                s.putString(zzaNu, s1);
                s.putLong(zzaNt, 1L);
                s.apply();
                return;
            }
            boolean flag;
            if ((UUID.randomUUID().getLeastSignificantBits() & 0x7fffffffffffffffL) < 0x7fffffffffffffffL / (l + 1L))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s = zzs.zza(zzaNr).edit();
            if (flag)
            {
                s.putString(zzaNu, s1);
            }
            s.putLong(zzaNt, l + 1L);
            s.apply();
        }

        public Pair zzkW()
        {
            zzaNr.zzis();
            long l = zzkV();
            if (l < zzPG)
            {
                return null;
            }
            if (l > zzPG * 2L)
            {
                zzkU();
                return null;
            }
            String s = zzs.zzb(zzaNr).getString(zzaNu, null);
            l = zzs.zzb(zzaNr).getLong(zzaNt, 0L);
            zzkU();
            if (s == null || l <= 0L)
            {
                return zzs.zzaNg;
            } else
            {
                return new Pair(s, Long.valueOf(l));
            }
        }

        private zzb(String s, long l)
        {
            zzaNr = zzs.this;
            super();
            zzx.zzcr(s);
            boolean flag;
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzaa(flag);
            zzaNs = (new StringBuilder()).append(s).append(":start").toString();
            zzaNt = (new StringBuilder()).append(s).append(":count").toString();
            zzaNu = (new StringBuilder()).append(s).append(":value").toString();
            zzPG = l;
        }

        zzb(String s, long l, _cls1 _pcls1)
        {
            this(s, l);
        }
    }


    static final Pair zzaNg = new Pair("", Long.valueOf(0L));
    private SharedPreferences zzPC;
    public final zzb zzaNh = new zzb("health_monitor", zzzt().zzkg());
    public final zza zzaNi = new zza("last_upload", 0L);
    public final zza zzaNj = new zza("last_upload_attempt", 0L);
    public final zza zzaNk = new zza("backoff", 0L);
    public final zza zzaNl = new zza("last_delete_stale", 0L);
    private String zzaNm;
    private boolean zzaNn;
    private long zzaNo;

    zzs(zzv zzv)
    {
        super(zzv);
    }

    static SharedPreferences zza(zzs zzs1)
    {
        return zzs1.zzPC;
    }

    static SharedPreferences zzb(zzs zzs1)
    {
        return zzs1.zzzV();
    }

    static MessageDigest zzbs(String s)
    {
        int i = 0;
_L3:
        if (i >= 2) goto _L2; else goto _L1
_L1:
        MessageDigest messagedigest = MessageDigest.getInstance(s);
        if (messagedigest != null)
        {
            return messagedigest;
        }
        continue; /* Loop/switch isn't completed */
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        i++;
          goto _L3
_L2:
        return null;
    }

    private SharedPreferences zzzV()
    {
        zzis();
        zziE();
        return zzPC;
    }

    void zzan(boolean flag)
    {
        zzis();
        zzyd().zzzQ().zzj("Setting useService", Boolean.valueOf(flag));
        android.content.SharedPreferences.Editor editor = zzzV().edit();
        editor.putBoolean("use_service", flag);
        editor.apply();
    }

    protected void zzhR()
    {
        zzPC = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    }

    Pair zzzS()
    {
        zzis();
        long l = zzit().elapsedRealtime();
        if (zzaNm != null && l < zzaNo)
        {
            return new Pair(zzaNm, Boolean.valueOf(zzaNn));
        }
        zzaNo = l + zzzt().zzza();
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            zzaNm = info.getId();
            zzaNn = info.isLimitAdTrackingEnabled();
        }
        catch (Throwable throwable)
        {
            zzyd().zzzP().zzj("Unable to get advertising id", throwable);
            zzaNm = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(zzaNm, Boolean.valueOf(zzaNn));
    }

    String zzzT()
    {
        String s = (String)zzzS().first;
        MessageDigest messagedigest = zzbs("MD5");
        if (messagedigest == null)
        {
            return null;
        } else
        {
            return String.format(Locale.US, "%032X", new Object[] {
                new BigInteger(1, messagedigest.digest(s.getBytes()))
            });
        }
    }

    String zzzU()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    Boolean zzzW()
    {
        zzis();
        if (!zzzV().contains("use_service"))
        {
            return null;
        } else
        {
            return Boolean.valueOf(zzzV().getBoolean("use_service", false));
        }
    }

}
