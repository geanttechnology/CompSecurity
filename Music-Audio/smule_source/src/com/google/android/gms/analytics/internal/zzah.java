// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.zzht;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzq, zzai, zze

public class zzah extends zzd
{

    private SharedPreferences zzIA;
    private long zzIB;
    private long zzIC;
    private final zza zzID = new zza("monitoring", zzgI().zziv());

    protected zzah(zze zze)
    {
        super(zze);
        zzIC = -1L;
    }

    static SharedPreferences zza(zzah zzah1)
    {
        return zzah1.zzIA;
    }

    public void zzaR(String s)
    {
        zzgF();
        zzgR();
        android.content.SharedPreferences.Editor editor = zzIA.edit();
        if (TextUtils.isEmpty(s))
        {
            editor.remove("installation_campaign");
        } else
        {
            editor.putString("installation_campaign", s);
        }
        if (!editor.commit())
        {
            zzaI("Failed to commit campaign data");
        }
    }

    protected void zzgb()
    {
        zzIA = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public long zzjd()
    {
        zzgF();
        zzgR();
        if (zzIB == 0L)
        {
            long l = zzIA.getLong("first_run", 0L);
            if (l != 0L)
            {
                zzIB = l;
            } else
            {
                long l1 = zzgG().currentTimeMillis();
                android.content.SharedPreferences.Editor editor = zzIA.edit();
                editor.putLong("first_run", l1);
                if (!editor.commit())
                {
                    zzaI("Failed to commit first run time");
                }
                zzIB = l1;
            }
        }
        return zzIB;
    }

    public zzai zzje()
    {
        return new zzai(zzgG(), zzjd());
    }

    public long zzjf()
    {
        zzgF();
        zzgR();
        if (zzIC == -1L)
        {
            zzIC = zzIA.getLong("last_dispatch", 0L);
        }
        return zzIC;
    }

    public void zzjg()
    {
        zzgF();
        zzgR();
        long l = zzgG().currentTimeMillis();
        android.content.SharedPreferences.Editor editor = zzIA.edit();
        editor.putLong("last_dispatch", l);
        editor.apply();
        zzIC = l;
    }

    public String zzjh()
    {
        zzgF();
        zzgR();
        String s = zzIA.getString("installation_campaign", null);
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return s;
        }
    }

    public zza zzji()
    {
        return zzID;
    }

    private class zza
    {

        private final String mName;
        private final long zzIE;
        final zzah zzIF;

        private void zzjj()
        {
            long l = zzIF.zzgG().currentTimeMillis();
            android.content.SharedPreferences.Editor editor = zzah.zza(zzIF).edit();
            editor.remove(zzjo());
            editor.remove(zzjp());
            editor.putLong(zzjn(), l);
            editor.commit();
        }

        private long zzjk()
        {
            long l = zzjm();
            if (l == 0L)
            {
                return 0L;
            } else
            {
                return Math.abs(l - zzIF.zzgG().currentTimeMillis());
            }
        }

        private long zzjm()
        {
            return zzah.zza(zzIF).getLong(zzjn(), 0L);
        }

        private String zzjn()
        {
            return (new StringBuilder()).append(mName).append(":start").toString();
        }

        private String zzjo()
        {
            return (new StringBuilder()).append(mName).append(":count").toString();
        }

        public void zzaS(String s)
        {
            String s1;
            if (zzjm() == 0L)
            {
                zzjj();
            }
            s1 = s;
            if (s == null)
            {
                s1 = "";
            }
            this;
            JVM INSTR monitorenter ;
            long l = zzah.zza(zzIF).getLong(zzjo(), 0L);
            if (l > 0L)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            s = zzah.zza(zzIF).edit();
            s.putString(zzjp(), s1);
            s.putLong(zzjo(), 1L);
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
            s = zzah.zza(zzIF).edit();
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_149;
            }
            s.putString(zzjp(), s1);
            s.putLong(zzjo(), l + 1L);
            s.apply();
            this;
            JVM INSTR monitorexit ;
            return;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        public Pair zzjl()
        {
            long l = zzjk();
            if (l >= zzIE)
            {
                if (l > zzIE * 2L)
                {
                    zzjj();
                    return null;
                }
                String s = zzah.zza(zzIF).getString(zzjp(), null);
                l = zzah.zza(zzIF).getLong(zzjo(), 0L);
                zzjj();
                if (s != null && l > 0L)
                {
                    return new Pair(s, Long.valueOf(l));
                }
            }
            return null;
        }

        protected String zzjp()
        {
            return (new StringBuilder()).append(mName).append(":value").toString();
        }

        private zza(String s, long l)
        {
            zzIF = zzah.this;
            super();
            zzv.zzbS(s);
            boolean flag;
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzv.zzQ(flag);
            mName = s;
            zzIE = l;
        }

        zza(String s, long l, _cls1 _pcls1)
        {
            this(s, l);
        }
    }

}
