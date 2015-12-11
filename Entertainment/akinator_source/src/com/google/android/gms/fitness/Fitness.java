// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness;

import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzov;
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
    public static final BleApi BleApi = zzse();
    public static final Api CONFIG_API;
    public static final ConfigApi ConfigApi = new zzoo();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api HISTORY_API;
    public static final HistoryApi HistoryApi = new zzop();
    public static final Api RECORDING_API;
    public static final RecordingApi RecordingApi = new zzor();
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
    public static final SensorsApi SensorsApi = new zzos();
    public static final SessionsApi SessionsApi = new zzot();
    public static final Api zzaiH;
    public static final com.google.android.gms.common.api.Api.zzc zzapC;
    public static final com.google.android.gms.common.api.Api.zzc zzapD;
    public static final com.google.android.gms.common.api.Api.zzc zzapE;
    public static final com.google.android.gms.common.api.Api.zzc zzapF;
    public static final com.google.android.gms.common.api.Api.zzc zzapG;
    public static final com.google.android.gms.common.api.Api.zzc zzapH;
    public static final com.google.android.gms.common.api.Api.zzc zzapI;
    public static final zzol zzapJ = new zzoq();

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

    private static BleApi zzse()
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            return new zzon();
        } else
        {
            return new zzov();
        }
    }

    static 
    {
        zzapC = new com.google.android.gms.common.api.Api.zzc();
        zzapD = new com.google.android.gms.common.api.Api.zzc();
        zzapE = new com.google.android.gms.common.api.Api.zzc();
        zzapF = new com.google.android.gms.common.api.Api.zzc();
        zzapG = new com.google.android.gms.common.api.Api.zzc();
        zzapH = new com.google.android.gms.common.api.Api.zzc();
        zzapI = new com.google.android.gms.common.api.Api.zzc();
        SENSORS_API = new Api("Fitness.SENSORS_API", new com.google.android.gms.internal.zznr.zzb(), zzapH);
        RECORDING_API = new Api("Fitness.RECORDING_API", new com.google.android.gms.internal.zznq.zzb(), zzapG);
        SESSIONS_API = new Api("Fitness.SESSIONS_API", new com.google.android.gms.internal.zzns.zzb(), zzapI);
        HISTORY_API = new Api("Fitness.HISTORY_API", new com.google.android.gms.internal.zzno.zzb(), zzapE);
        CONFIG_API = new Api("Fitness.CONFIG_API", new com.google.android.gms.internal.zznn.zzb(), zzapD);
        BLE_API = new Api("Fitness.BLE_API", new com.google.android.gms.internal.zznm.zzb(), zzapC);
        zzaiH = new Api("Fitness.INTERNAL_API", new com.google.android.gms.internal.zznp.zza(), zzapF);
    }
}
