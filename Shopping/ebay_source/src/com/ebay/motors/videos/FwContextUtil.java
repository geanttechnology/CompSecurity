// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.motors.videos;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.Iterator;
import java.util.List;

public final class FwContextUtil
{

    public static final String EXTRA_INTERNAL_LINK = "inAppLink";

    public FwContextUtil()
    {
    }

    public static Intent getLocalActivity(Context context, Intent intent)
    {
label0:
        {
            if (intent == null || intent.getComponent() != null)
            {
                break label0;
            }
            String s = context.getPackageName();
            context = context.getPackageManager().queryIntentActivities(intent, 0);
            if (context == null || context.isEmpty())
            {
                break label0;
            }
            context = context.iterator();
            ActivityInfo activityinfo;
            do
            {
                if (!context.hasNext())
                {
                    break label0;
                }
                activityinfo = ((ResolveInfo)context.next()).activityInfo;
            } while (!s.equals(activityinfo.packageName));
            intent.setComponent(new ComponentName(activityinfo.packageName, activityinfo.name));
            intent.putExtra("inAppLink", true);
        }
        return intent;
    }
}
