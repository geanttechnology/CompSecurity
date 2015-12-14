// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness;

import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznu;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness:
//            BleApi, ConfigApi, HistoryApi, RecordingApi, 
//            SensorsApi, SessionsApi

public class Fitness
{

    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    public static final Void API = null;
    public static final Api BLE_API;
    public static final BleApi BleApi = zzrs();
    public static final Api CONFIG_API;
    public static final ConfigApi ConfigApi = new zznn();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api HISTORY_API;
    public static final HistoryApi HistoryApi = new zzno();
    public static final Api RECORDING_API;
    public static final RecordingApi RecordingApi = new zznq();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    public static final Scope SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
    public static final Scope SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
    public static final Scope SCOPE_NUTRITION_READ = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
    public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");
    public static final Api SENSORS_API;
    public static final Api SESSIONS_API;
    public static final SensorsApi SensorsApi = new zznr();
    public static final SessionsApi SessionsApi = new zzns();
    public static final Api zzagz;
    public static final com.google.android.gms.common.api.Api.zzc zzanc;
    public static final com.google.android.gms.common.api.Api.zzc zzand;
    public static final com.google.android.gms.common.api.Api.zzc zzane;
    public static final com.google.android.gms.common.api.Api.zzc zzanf;
    public static final com.google.android.gms.common.api.Api.zzc zzang;
    public static final com.google.android.gms.common.api.Api.zzc zzanh;
    public static final com.google.android.gms.common.api.Api.zzc zzani;
    public static final zznk zzanj = new zznp();

    private Fitness()
    {
    }

    public static long getEndTime(Intent intent, TimeUnit timeunit)
    {
        long l = intent.getLongExtra("vnd.google.fitness.end_time", -1L);
        if (l == -1L)
        {
            return -1L;
        } else
        {
            return timeunit.convert(l, TimeUnit.MILLISECONDS);
        }
    }

    public static long getStartTime(Intent intent, TimeUnit timeunit)
    {
        long l = intent.getLongExtra("vnd.google.fitness.start_time", -1L);
        if (l == -1L)
        {
            return -1L;
        } else
        {
            return timeunit.convert(l, TimeUnit.MILLISECONDS);
        }
    }

    private static BleApi zzrs()
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            return new zznm();
        } else
        {
            return new zznu();
        }
    }

    static 
    {
        zzanc = new com.google.android.gms.common.api.Api.zzc();
        zzand = new com.google.android.gms.common.api.Api.zzc();
        zzane = new com.google.android.gms.common.api.Api.zzc();
        zzanf = new com.google.android.gms.common.api.Api.zzc();
        zzang = new com.google.android.gms.common.api.Api.zzc();
        zzanh = new com.google.android.gms.common.api.Api.zzc();
        zzani = new com.google.android.gms.common.api.Api.zzc();
        SENSORS_API = new Api("Fitness.SENSORS_API", new com.google.android.gms.internal.zzmp.zzb(), zzanh);
        RECORDING_API = new Api("Fitness.RECORDING_API", new com.google.android.gms.internal.zzmo.zzb(), zzang);
        SESSIONS_API = new Api("Fitness.SESSIONS_API", new com.google.android.gms.internal.zzmq.zzb(), zzani);
        HISTORY_API = new Api("Fitness.HISTORY_API", new com.google.android.gms.internal.zzmm.zzb(), zzane);
        CONFIG_API = new Api("Fitness.CONFIG_API", new com.google.android.gms.internal.zzml.zzb(), zzand);
        BLE_API = new Api("Fitness.BLE_API", new com.google.android.gms.internal.zzmk.zzb(), zzanc);
        zzagz = new Api("Fitness.INTERNAL_API", new com.google.android.gms.internal.zzmn.zza(), zzanf);
    }
}
