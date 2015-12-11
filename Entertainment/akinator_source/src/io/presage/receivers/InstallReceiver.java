// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.receivers;

import android.content.Context;
import android.content.Intent;
import io.presage.utils.do.a;
import io.presage.utils.e;
import java.util.HashMap;

// Referenced classes of package io.presage.receivers:
//            AbstractReceiver

public class InstallReceiver extends AbstractReceiver
{

    public InstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context = new HashMap();
        e.b(new String[] {
            "InstallReceiver", "Receive Intent:", intent.toString()
        });
        if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) || "android.intent.action.PACKAGE_INSTALL".equals(intent.getAction()))
        {
            context.put("event", "install");
            context.put("package", intent.getDataString());
        }
        if (("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) || "android.intent.action.PACKAGE_FULLY_REMOVED".equals(intent.getAction())) && !intent.getBooleanExtra("android.intent.extra.REPLACING", false))
        {
            context.put("event", "uninstall");
            context.put("package", intent.getDataString());
        }
        if ("android.intent.action.PACKAGE_REPLACED".equals(intent.getAction()))
        {
            context.put("event", "update");
            context.put("package", intent.getDataString());
        }
        if ("android.intent.action.PACKAGE_FIRST_LAUNCH".equals(intent.getAction()))
        {
            context.put("event", "first_launch");
            context.put("package", intent.getDataString());
        }
        if (!context.isEmpty())
        {
            e.b(new String[] {
                "InstallReceiver", "Send event:", context.get("event").toString(), "-", context.get("package").toString()
            });
            a().a("event", context);
        }
    }
}
