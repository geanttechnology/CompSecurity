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

public static class zzaqx
{

    private String zzGY;
    private long zzMS;
    private long zzann;
    private List zzanw;
    private List zzapG;
    private boolean zzapR;
    private String zzaqv;
    private boolean zzaqw;
    private List zzaqx;

    static String zza(zzaqx zzaqx1)
    {
        return zzaqx1.zzaqv;
    }

    static String zzb(zzaqv zzaqv1)
    {
        return zzaqv1.zzGY;
    }

    static long zzc(zzGY zzgy)
    {
        return zzgy.zzMS;
    }

    static long zzd(zzMS zzms)
    {
        return zzms.zzann;
    }

    static List zze(zzann zzann1)
    {
        return zzann1.zzanw;
    }

    static List zzf(zzanw zzanw1)
    {
        return zzanw1.zzapG;
    }

    static boolean zzg(zzapG zzapg)
    {
        return zzapg.zzaqw;
    }

    static boolean zzh(zzaqw zzaqw1)
    {
        return zzaqw1.zzapR;
    }

    static List zzi(zzapR zzapr)
    {
        return zzapr.zzaqx;
    }

    public SessionReadRequest build()
    {
        boolean flag;
        if (zzMS > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid start time: %s", new Object[] {
            Long.valueOf(zzMS)
        });
        if (zzann > 0L && zzann > zzMS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid end time: %s", new Object[] {
            Long.valueOf(zzann)
        });
        return new SessionReadRequest(this, null);
    }

    public zzann enableServerQueries()
    {
        zzapR = true;
        return this;
    }

    public zzapR excludePackage(String s)
    {
        zzx.zzb(s, "Attempting to use a null package name");
        if (!zzaqx.contains(s))
        {
            zzaqx.add(s);
        }
        return this;
    }

    public zzaqx read(DataSource datasource)
    {
        zzx.zzb(datasource, "Attempting to add a null data source");
        if (!zzapG.contains(datasource))
        {
            zzapG.add(datasource);
        }
        return this;
    }

    public zzapG read(DataType datatype)
    {
        zzx.zzb(datatype, "Attempting to use a null data type");
        if (!zzanw.contains(datatype))
        {
            zzanw.add(datatype);
        }
        return this;
    }

    public zzanw readSessionsFromAllApps()
    {
        zzaqw = true;
        return this;
    }

    public zzaqw setSessionId(String s)
    {
        zzGY = s;
        return this;
    }

    public zzGY setSessionName(String s)
    {
        zzaqv = s;
        return this;
    }

    public zzaqv setTimeInterval(long l, long l1, TimeUnit timeunit)
    {
        zzMS = timeunit.toMillis(l);
        zzann = timeunit.toMillis(l1);
        return this;
    }

    public ()
    {
        zzMS = 0L;
        zzann = 0L;
        zzanw = new ArrayList();
        zzapG = new ArrayList();
        zzaqw = false;
        zzapR = false;
        zzaqx = new ArrayList();
    }
}
