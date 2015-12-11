// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            DataSource, Application, DataType, Device

public static final class zzaql
{

    private String mName;
    private int zzWJ;
    private DataType zzapL;
    private Device zzaqj;
    private Application zzaqk;
    private String zzaql;

    static DataType zza(zzaql zzaql1)
    {
        return zzaql1.zzapL;
    }

    static int zzb(zzapL zzapl)
    {
        return zzapl.zzWJ;
    }

    static String zzc(zzWJ zzwj)
    {
        return zzwj.mName;
    }

    static Device zzd(mName mname)
    {
        return mname.zzaqj;
    }

    static Application zze(zzaqj zzaqj1)
    {
        return zzaqj1.zzaqk;
    }

    static String zzf(zzaqk zzaqk1)
    {
        return zzaqk1.zzaql;
    }

    public DataSource build()
    {
        boolean flag1 = true;
        boolean flag;
        if (zzapL != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must set data type");
        if (zzWJ >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must set data source type");
        return new DataSource(this, null);
    }

    public zzWJ setAppPackageName(Context context)
    {
        return setAppPackageName(context.getPackageName());
    }

    public setAppPackageName setAppPackageName(String s)
    {
        zzaqk = Application.zzcP(s);
        return this;
    }

    public zzaqk setDataType(DataType datatype)
    {
        zzapL = datatype;
        return this;
    }

    public zzapL setDevice(Device device)
    {
        zzaqj = device;
        return this;
    }

    public zzaqj setName(String s)
    {
        mName = s;
        return this;
    }

    public mName setStreamName(String s)
    {
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Must specify a valid stream name");
        zzaql = s;
        return this;
    }

    public zzaql setType(int i)
    {
        zzWJ = i;
        return this;
    }

    public ()
    {
        zzWJ = -1;
        zzaql = "";
    }
}
