// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.a.a.e;
import com.google.a.b.k;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.google.android.gms.gcm.Task;
import com.target.a.a.b;
import com.target.ui.service.TargetGcmTaskService;
import com.target.ui.service.n;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class a
{

    private static final String KEY_ADVERTISING_ID = "KEY_ADVERTISING_ID";
    private static final String KEY_MAY_TRACK = "KEY_MAY_TRACK";
    private static final String LOG_TAG = "AdvertisingIdProvider";
    private static final String SHARED_PREFS_BUCKET_NAME = "ADVERTISING_ID_CACHE";
    private final Context mContext;
    private boolean mHasScheduledGcmTasks;
    private final SharedPreferences mSharedPrefs;
    private final com.target.ui.service.TargetGcmTaskService.a mTargetGcmTaskScheduler;

    public a(com.target.a.a.a a1)
    {
        mHasScheduledGcmTasks = false;
        mContext = a1.a();
        mTargetGcmTaskScheduler = new com.target.ui.service.TargetGcmTaskService.a(a1);
        mSharedPrefs = mContext.getSharedPreferences("ADVERTISING_ID_CACHE", 0);
    }

    static com.google.android.gms.ads.a.a a(a a1)
    {
        return a1.d();
    }

    private void a(com.google.android.gms.ads.a.a a1)
    {
        boolean flag;
        if (!a1.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a1 = a1.a();
        } else
        {
            a1 = null;
        }
        mSharedPrefs.edit().putString("KEY_ADVERTISING_ID", a1).putBoolean("KEY_MAY_TRACK", flag).apply();
    }

    static void a(a a1, com.google.android.gms.ads.a.a a2)
    {
        a1.a(a2);
    }

    public static void a(Executor executor, com.target.a.a.a a1)
    {
        (new a(a1)).a(executor);
    }

    private void b()
    {
        if (mHasScheduledGcmTasks)
        {
            return;
        }
        Task task;
        for (Iterator iterator = c().iterator(); iterator.hasNext(); mTargetGcmTaskScheduler.a(task))
        {
            task = (Task)iterator.next();
        }

        mHasScheduledGcmTasks = true;
    }

    private List c()
    {
        java.util.ArrayList arraylist = k.a();
        arraylist.add((new com.google.android.gms.gcm.PeriodicTask.a()).a("INVALIDATE_ADVERTISING_ID_CACHE").a(com/target/ui/service/TargetGcmTaskService).a(n.INVALIDATE_ADVERTISING_ID_CACHE_UPDATE_INTERVAL_SECONDS).b(n.INVALIDATE_ADVERTISING_ID_CACHE_UPDATE_FLEX_IN_SECONDS).b(false).c(true).a(0).a(true).b());
        boolean flag = mSharedPrefs.getBoolean("KEY_MAY_TRACK", true);
        boolean flag1 = mSharedPrefs.contains("KEY_ADVERTISING_ID");
        if (flag && !flag1)
        {
            arraylist.add((new com.google.android.gms.gcm.OneoffTask.a()).a("POPULATE_EMPTY_ADVERTISING_ID_CACHE").a(com/target/ui/service/TargetGcmTaskService).b(false).c(true).a(0).a(false).a(0L, n.POPULATE_EMPTY_ADVERTISING_ID_CACHE_MAX_DELAY).b());
        }
        return arraylist;
    }

    private com.google.android.gms.ads.a.a d()
    {
        com.target.a.a.b.e("AdvertisingIdProvider", "Fetching advertising ID");
        com.google.android.gms.ads.a.a a1 = com.google.android.gms.ads.a.a.b(mContext);
        return a1;
        Object obj;
        obj;
_L2:
        com.target.a.a.b.b("AdvertisingIdProvider", "Unable to fetch advertising ID: ", ((Throwable) (obj)));
        return null;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public e a()
    {
        b();
        return e.c(mSharedPrefs.getString("KEY_ADVERTISING_ID", null));
    }

    public void a(Executor executor)
    {
        com.target.a.a.b.d("AdvertisingIdProvider", "Starting new task to fetch advertising id");
        executor.execute(new Runnable() {

            final a this$0;

            public void run()
            {
                com.google.android.gms.ads.a.a a1 = a.a(a.this);
                if (a1 != null)
                {
                    a.a(a.this, a1);
                }
            }

            
            {
                this$0 = a.this;
                super();
            }
        });
    }
}
