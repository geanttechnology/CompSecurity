// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.restart;

import android.app.ActivityManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.pf.common.restart:
//            RestartService

class b
    implements Callable
{

    final ActivityManager a;
    final String b;
    final RestartService c;

    public Boolean a()
    {
        for (Iterator iterator = a.getRunningAppProcesses().iterator(); iterator.hasNext();)
        {
            android.app.unningAppProcessInfo unningappprocessinfo = (android.app.unningAppProcessInfo)iterator.next();
            if (b.equals(unningappprocessinfo.processName))
            {
                return Boolean.valueOf(true);
            }
        }

        return Boolean.valueOf(false);
    }

    public Object call()
    {
        return a();
    }

    rocessInfo(RestartService restartservice, ActivityManager activitymanager, String s)
    {
        c = restartservice;
        a = activitymanager;
        b = s;
        super();
    }
}
