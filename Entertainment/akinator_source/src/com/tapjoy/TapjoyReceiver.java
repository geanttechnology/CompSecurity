// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gf;
import java.util.List;

public class TapjoyReceiver extends BroadcastReceiver
{

    public TapjoyReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        gf.a(context);
        if ("com.tapjoy.PUSH_CLICK".equals(intent.getAction()))
        {
            String s = intent.getStringExtra("com.tapjoy.PUSH_ID");
            String s1 = intent.getStringExtra("com.tapjoy.PUSH_PAYLOAD");
            if (s != null && s.length() != 0)
            {
                Object obj = context.getPackageManager();
                String s2 = context.getPackageName();
                intent = new Intent("android.intent.action.MAIN");
                intent.setPackage(s2);
                intent.addCategory("android.intent.category.LAUNCHER");
                obj = ((PackageManager) (obj)).queryIntentActivities(intent, 0);
                if (obj == null || ((List) (obj)).size() <= 0)
                {
                    intent = null;
                } else
                {
                    intent = new Intent(intent);
                    intent.setFlags(0x10000000);
                    intent.setClassName(((ResolveInfo)((List) (obj)).get(0)).activityInfo.packageName, ((ResolveInfo)((List) (obj)).get(0)).activityInfo.name);
                }
                if (intent != null)
                {
                    if (s1 != null)
                    {
                        intent.putExtra("com.tapjoy.PUSH_PAYLOAD", s1);
                    }
                    gd.a(context).e(s);
                    context.startActivity(intent);
                } else
                {
                    ga.b("No intent that can be used to launch the main activity.");
                }
            }
        }
        if (isOrderedBroadcast())
        {
            setResult(-1, null, null);
        }
    }
}
