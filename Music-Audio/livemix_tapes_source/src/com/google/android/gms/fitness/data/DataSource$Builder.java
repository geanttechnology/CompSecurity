// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            DataSource, Application, Device, DataType

public static final class zzanL
{

    private String mName;
    private int zzUS;
    private Device zzanJ;
    private Application zzanK;
    private String zzanL;
    private DataType zzanl;

    static DataType zza(zzanL zzanl1)
    {
        return zzanl1.zzanl;
    }

    static int zzb(zzanl zzanl1)
    {
        return zzanl1.zzUS;
    }

    static String zzc(zzUS zzus)
    {
        return zzus.mName;
    }

    static Device zzd(mName mname)
    {
        return mname.zzanJ;
    }

    static Application zze(zzanJ zzanj)
    {
        return zzanj.zzanK;
    }

    static String zzf(zzanK zzank)
    {
        return zzank.zzanL;
    }

    public DataSource build()
    {
        boolean flag1 = true;
        boolean flag;
        if (zzanl != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must set data type");
        if (zzUS >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must set data source type");
        return new DataSource(this, null);
    }

    public zzUS setAppPackageName(Context context)
    {
        return setAppPackageName(context.getPackageName());
    }

    public setAppPackageName setAppPackageName(String s)
    {
        zzanK = Application.zzcQ(s);
        return this;
    }

    public zzanK setDataType(DataType datatype)
    {
        zzanl = datatype;
        return this;
    }

    public zzanl setDevice(Device device)
    {
        zzanJ = device;
        return this;
    }

    public zzanJ setName(String s)
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
        zzanL = s;
        return this;
    }

    public zzanL setType(int i)
    {
        zzUS = i;
        return this;
    }

    public ()
    {
        zzUS = -1;
        zzanL = "";
    }
}
