// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzr, zzaj, zzf

public class zzai extends zzd
{

    private SharedPreferences zzPC;
    private long zzPD;
    private long zzPE;
    private final zza zzPF = new zza("monitoring", zziv().zzkg(), null);

    protected zzai(zzf zzf)
    {
        super(zzf);
        zzPE = -1L;
    }

    static SharedPreferences zza(zzai zzai1)
    {
        return zzai1.zzPC;
    }

    public void zzbm(String s)
    {
        zzis();
        zziE();
        android.content.SharedPreferences.Editor editor = zzPC.edit();
        if (TextUtils.isEmpty(s))
        {
            editor.remove("installation_campaign");
        } else
        {
            editor.putString("installation_campaign", s);
        }
        if (!editor.commit())
        {
            zzbd("Failed to commit campaign data");
        }
    }

    protected void zzhR()
    {
        zzPC = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public long zzkO()
    {
        zzis();
        zziE();
        if (zzPD == 0L)
        {
            long l = zzPC.getLong("first_run", 0L);
            if (l != 0L)
            {
                zzPD = l;
            } else
            {
                long l1 = zzit().currentTimeMillis();
                android.content.SharedPreferences.Editor editor = zzPC.edit();
                editor.putLong("first_run", l1);
                if (!editor.commit())
                {
                    zzbd("Failed to commit first run time");
                }
                zzPD = l1;
            }
        }
        return zzPD;
    }

    public zzaj zzkP()
    {
        return new zzaj(zzit(), zzkO());
    }

    public long zzkQ()
    {
        zzis();
        zziE();
        if (zzPE == -1L)
        {
            zzPE = zzPC.getLong("last_dispatch", 0L);
        }
        return zzPE;
    }

    public void zzkR()
    {
        zzis();
        zziE();
        long l = zzit().currentTimeMillis();
        android.content.SharedPreferences.Editor editor = zzPC.edit();
        editor.putLong("last_dispatch", l);
        editor.apply();
        zzPE = l;
    }

    public String zzkS()
    {
        zzis();
        zziE();
        String s = zzPC.getString("installation_campaign", null);
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return s;
        }
    }

    public zza zzkT()
    {
        return zzPF;
    }

    private class zza
    {

        private final String mName;
        private final long zzPG;
        final zzai zzPH;

        private void zzkU()
        {
            long l = zzPH.zzit().currentTimeMillis();
            android.content.SharedPreferences.Editor editor = zzai.zza(zzPH).edit();
            editor.remove(zzkZ());
            editor.remove(zzla());
            editor.putLong(zzkY(), l);
            editor.commit();
        }

        private long zzkV()
        {
            long l = zzkX();
            if (l == 0L)
            {
                return 0L;
            } else
            {
                return Math.abs(l - zzPH.zzit().currentTimeMillis());
            }
        }

        private long zzkX()
        {
            return zzai.zza(zzPH).getLong(zzkY(), 0L);
        }

        private String zzkY()
        {
            return (new StringBuilder()).append(mName).append(":start").toString();
        }

        private String zzkZ()
        {
            return (new StringBuilder()).append(mName).append(":count").toString();
        }

        public final void zzbn(String s)
        {
            String s1;
            if (zzkX() == 0L)
            {
                zzkU();
            }
            s1 = s;
            if (s == null)
            {
                s1 = "";
            }
            this;
            JVM INSTR monitorenter ;
            long l = zzai.zza(zzPH).getLong(zzkZ(), 0L);
            if (l > 0L)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            s = zzai.zza(zzPH).edit();
            s.putString(zzla(), s1);
            s.putLong(zzkZ(), 1L);
            s.apply();
            this;
            JVM INSTR monitorexit ;
            return;
            boolean flag;
            if ((UUID.randomUUID().getLeastSignificantBits() & 0x7fffffffffffffffL) < 0x7fffffffffffffffL / (l + 1L))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s = zzai.zza(zzPH).edit();
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_149;
            }
            s.putString(zzla(), s1);
            s.putLong(zzkZ(), l + 1L);
            s.apply();
            this;
            JVM INSTR monitorexit ;
            return;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public final Pair zzkW()
        {
            long l = zzkV();
            if (l >= zzPG)
            {
                if (l > zzPG << 1)
                {
                    zzkU();
                    return null;
                }
                String s = zzai.zza(zzPH).getString(zzla(), null);
                l = zzai.zza(zzPH).getLong(zzkZ(), 0L);
                zzkU();
                if (s != null && l > 0L)
                {
                    return new Pair(s, Long.valueOf(l));
                }
            }
            return null;
        }

        protected final String zzla()
        {
            return (new StringBuilder()).append(mName).append(":value").toString();
        }

        private zza(String s, long l)
        {
            zzPH = zzai.this;
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
            mName = s;
            zzPG = l;
        }

        zza(String s, long l, _cls1 _pcls1)
        {
            this(s, l);
        }
    }

}
