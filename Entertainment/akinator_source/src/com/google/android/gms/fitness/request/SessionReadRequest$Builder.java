// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SessionReadRequest

public static class zzasU
{

    private String zzHP;
    private long zzNY;
    private long zzapN;
    private List zzapW;
    private String zzasS;
    private boolean zzasT;
    private List zzasU;
    private List zzasd;
    private boolean zzaso;

    static String zza(zzasU zzasu)
    {
        return zzasu.zzasS;
    }

    static String zzb(zzasS zzass)
    {
        return zzass.zzHP;
    }

    static long zzc(zzHP zzhp)
    {
        return zzhp.zzNY;
    }

    static long zzd(zzNY zzny)
    {
        return zzny.zzapN;
    }

    static List zze(zzapN zzapn)
    {
        return zzapn.zzapW;
    }

    static List zzf(zzapW zzapw)
    {
        return zzapw.zzasd;
    }

    static boolean zzg(zzasd zzasd1)
    {
        return zzasd1.zzasT;
    }

    static boolean zzh(zzasT zzast)
    {
        return zzast.zzaso;
    }

    static List zzi(zzaso zzaso1)
    {
        return zzaso1.zzasU;
    }

    public SessionReadRequest build()
    {
        boolean flag;
        if (zzNY > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid start time: %s", new Object[] {
            Long.valueOf(zzNY)
        });
        if (zzapN > 0L && zzapN > zzNY)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid end time: %s", new Object[] {
            Long.valueOf(zzapN)
        });
        return new SessionReadRequest(this, null);
    }

    public zzapN enableServerQueries()
    {
        zzaso = true;
        return this;
    }

    public zzaso excludePackage(String s)
    {
        zzx.zzb(s, "Attempting to use a null package name");
        if (!zzasU.contains(s))
        {
            zzasU.add(s);
        }
        return this;
    }

    public zzasU read(DataSource datasource)
    {
        zzx.zzb(datasource, "Attempting to add a null data source");
        if (!zzasd.contains(datasource))
        {
            zzasd.add(datasource);
        }
        return this;
    }

    public zzasd read(DataType datatype)
    {
        zzx.zzb(datatype, "Attempting to use a null data type");
        if (!zzapW.contains(datatype))
        {
            zzapW.add(datatype);
        }
        return this;
    }

    public zzapW readSessionsFromAllApps()
    {
        zzasT = true;
        return this;
    }

    public zzasT setSessionId(String s)
    {
        zzHP = s;
        return this;
    }

    public zzHP setSessionName(String s)
    {
        zzasS = s;
        return this;
    }

    public zzasS setTimeInterval(long l, long l1, TimeUnit timeunit)
    {
        zzNY = timeunit.toMillis(l);
        zzapN = timeunit.toMillis(l1);
        return this;
    }

    public ()
    {
        zzNY = 0L;
        zzapN = 0L;
        zzapW = new ArrayList();
        zzasd = new ArrayList();
        zzasT = false;
        zzaso = false;
        zzasU = new ArrayList();
    }
}
