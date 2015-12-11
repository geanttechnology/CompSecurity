// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.x;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.gcm:
//            d, Task

public class a
{

    private static a a;
    private Context b;
    private final PendingIntent c;

    private a(Context context)
    {
        b = context;
        c = PendingIntent.getBroadcast(b, 0, new Intent(), 0);
    }

    private Intent a()
    {
        int i = d.c(b);
        if (i < d.a)
        {
            Log.e("GcmNetworkManager", (new StringBuilder()).append("Google Play Services is not available, dropping GcmNetworkManager request. code=").append(i).toString());
            return null;
        } else
        {
            Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
            intent.setPackage(d.b(b));
            intent.putExtra("app", c);
            return intent;
        }
    }

    public static a a(Context context)
    {
        if (a == null)
        {
            a = new a(context.getApplicationContext());
        }
        return a;
    }

    static void a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Must provide a valid tag.");
        }
        if (100 < s.length())
        {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        } else
        {
            return;
        }
    }

    private void b(String s)
    {
        boolean flag;
        boolean flag1 = true;
        x.a(s, "GcmTaskService must not be null.");
        Object obj = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
        ((Intent) (obj)).setPackage(b.getPackageName());
        obj = b.getPackageManager().queryIntentServices(((Intent) (obj)), 0);
        if (obj != null && ((List) (obj)).size() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        obj = ((List) (obj)).iterator();
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        if (!((ResolveInfo)((Iterator) (obj)).next()).serviceInfo.name.equals(s))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        flag = flag1;
_L4:
        x.b(flag, (new StringBuilder()).append("The GcmTaskService class you provided ").append(s).append(" does not seem to support receiving").append(" com.google.android.gms.gcm.ACTION_TASK_READY.").toString());
        return;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(Task task)
    {
        b(task.c());
        Intent intent = a();
        if (intent == null)
        {
            return;
        } else
        {
            Bundle bundle = intent.getExtras();
            bundle.putString("scheduler_action", "SCHEDULE_TASK");
            task.a(bundle);
            intent.putExtras(bundle);
            b.sendBroadcast(intent);
            return;
        }
    }
}
