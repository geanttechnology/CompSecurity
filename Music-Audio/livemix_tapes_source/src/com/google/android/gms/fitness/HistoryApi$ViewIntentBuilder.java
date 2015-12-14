// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness:
//            HistoryApi

public static class zzanl
{

    private final Context mContext;
    private long zzMS;
    private final DataType zzanl;
    private DataSource zzanm;
    private long zzann;
    private String zzano;

    private Intent zzj(Intent intent)
    {
        if (zzano != null)
        {
            Intent intent1 = (new Intent(intent)).setPackage(zzano);
            ResolveInfo resolveinfo = mContext.getPackageManager().resolveActivity(intent1, 0);
            if (resolveinfo != null)
            {
                intent = resolveinfo.activityInfo.name;
                intent1.setComponent(new ComponentName(zzano, intent));
                return intent1;
            }
        }
        return intent;
    }

    public Intent build()
    {
        boolean flag1 = true;
        Intent intent;
        boolean flag;
        if (zzMS > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Start time must be set");
        if (zzann > zzMS)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "End time must be set and after start time");
        intent = new Intent("vnd.google.fitness.VIEW");
        intent.setType(DataType.getMimeType(zzanm.getDataType()));
        intent.putExtra("vnd.google.fitness.start_time", zzMS);
        intent.putExtra("vnd.google.fitness.end_time", zzann);
        zzc.zza(zzanm, intent, "vnd.google.fitness.data_source");
        return zzj(intent);
    }

    public zzj setDataSource(DataSource datasource)
    {
        zzx.zzb(datasource.getDataType().equals(zzanl), "Data source %s is not for the data type %s", new Object[] {
            datasource, zzanl
        });
        zzanm = datasource;
        return this;
    }

    public zzanm setPreferredApplication(String s)
    {
        zzano = s;
        return this;
    }

    public zzano setTimeInterval(long l, long l1, TimeUnit timeunit)
    {
        zzMS = timeunit.toMillis(l);
        zzann = timeunit.toMillis(l1);
        return this;
    }

    public A(Context context, DataType datatype)
    {
        mContext = context;
        zzanl = datatype;
    }
}
