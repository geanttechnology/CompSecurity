// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.gcm.Task;
import com.google.android.gms.gcm.c;
import com.google.android.gms.gcm.e;
import com.target.a.a.a;
import com.target.a.a.b;

// Referenced classes of package com.target.ui.service:
//            AppConfigUpdateService

public class TargetGcmTaskService extends c
{
    public static class a
    {

        private static final String LOG_TAG = "TargetGcmTaskScheduler";
        private final Context mContext;

        private void a(String s)
        {
            com.target.a.a.b.b("TargetGcmTaskScheduler", (new StringBuilder()).append("Google Play Services not available, cannot: ").append(s).toString());
        }

        private boolean a()
        {
            return com.google.android.gms.common.b.a().a(mContext) == 0;
        }

        private com.google.android.gms.gcm.a b()
        {
            return com.google.android.gms.gcm.a.a(mContext);
        }

        public boolean a(Task task)
        {
            if (!a())
            {
                a((new StringBuilder()).append("schedule: ").append(task).toString());
                return false;
            } else
            {
                b().a(task);
                return true;
            }
        }

        public a(com.target.a.a.a a1)
        {
            mContext = a1.a();
        }
    }


    public TargetGcmTaskService()
    {
    }

    public int a(e e1)
    {
        e1 = e1.a();
        if (!"update_app_config".equals(e1)) goto _L2; else goto _L1
_L1:
        startService(new Intent(this, com/target/ui/service/AppConfigUpdateService));
_L4:
        return 0;
_L2:
        if ("INVALIDATE_ADVERTISING_ID_CACHE".equals(e1) || "POPULATE_EMPTY_ADVERTISING_ID_CACHE".equals(e1))
        {
            com.target.ui.analytics.a.a(AsyncTask.THREAD_POOL_EXECUTOR, new com.target.a.a.a(this));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
