// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.content.Context;
import com.google.android.gms.gcm.Task;
import com.target.a.a.a;
import com.target.a.a.b;

// Referenced classes of package com.target.ui.service:
//            TargetGcmTaskService

public static class mContext
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

    public (a a1)
    {
        mContext = a1.a();
    }
}
