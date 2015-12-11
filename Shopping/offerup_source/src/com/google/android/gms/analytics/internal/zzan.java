// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzaa, zzz, zzf

public class zzan extends zzd
{

    protected boolean zzLD;
    protected int zzNW;
    protected String zzOZ;
    protected boolean zzPQ;
    protected boolean zzPR;
    protected boolean zzPS;
    protected String zzPa;
    protected int zzPc;

    public zzan(zzf zzf)
    {
        super(zzf);
    }

    private static int zzbv(String s)
    {
        s = s.toLowerCase();
        if ("verbose".equals(s))
        {
            return 0;
        }
        if ("info".equals(s))
        {
            return 1;
        }
        if ("warning".equals(s))
        {
            return 2;
        }
        return !"error".equals(s) ? -1 : 3;
    }

    public int getLogLevel()
    {
        zziE();
        return zzNW;
    }

    void zza(zzaa zzaa1)
    {
        zzba("Loading global XML config values");
        if (zzaa1.zzko())
        {
            String s = zzaa1.zzkp();
            zzOZ = s;
            zzb("XML config - app name", s);
        }
        if (zzaa1.zzkq())
        {
            String s1 = zzaa1.zzkr();
            zzPa = s1;
            zzb("XML config - app version", s1);
        }
        if (zzaa1.zzks())
        {
            int i = zzbv(zzaa1.zzkt());
            if (i >= 0)
            {
                zzNW = i;
                zza("XML config - log level", Integer.valueOf(i));
            }
        }
        if (zzaa1.zzku())
        {
            int j = zzaa1.zzkv();
            zzPc = j;
            zzPR = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(j));
        }
        if (zzaa1.zzkw())
        {
            boolean flag = zzaa1.zzkx();
            zzLD = flag;
            zzPS = true;
            zzb("XML config - dry run", Boolean.valueOf(flag));
        }
    }

    protected void zzhR()
    {
        zzlm();
    }

    public String zzkp()
    {
        zziE();
        return zzOZ;
    }

    public String zzkr()
    {
        zziE();
        return zzPa;
    }

    public boolean zzks()
    {
        zziE();
        return zzPQ;
    }

    public boolean zzku()
    {
        zziE();
        return zzPR;
    }

    public boolean zzkw()
    {
        zziE();
        return zzPS;
    }

    public boolean zzkx()
    {
        zziE();
        return zzLD;
    }

    public int zzll()
    {
        zziE();
        return zzPc;
    }

    protected void zzlm()
    {
        Object obj = getContext();
        try
        {
            obj = ((Context) (obj)).getPackageManager().getApplicationInfo(((Context) (obj)).getPackageName(), 129);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzd("PackageManager doesn't know about the app package", obj);
            obj = null;
        }
        if (obj == null)
        {
            zzbd("Couldn't get ApplicationInfo to load global config");
        } else
        {
            obj = ((ApplicationInfo) (obj)).metaData;
            if (obj != null)
            {
                int i = ((Bundle) (obj)).getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0)
                {
                    zzaa zzaa1 = (zzaa)(new zzz(zziq())).zzad(i);
                    if (zzaa1 != null)
                    {
                        zza(zzaa1);
                        return;
                    }
                }
            }
        }
    }
}
