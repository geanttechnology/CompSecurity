// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            gd

public class cs
{

    private static final String a = com/flurry/sdk/cs.getSimpleName();
    private static final List b = Arrays.asList(new String[] {
        "com.android.chrome", "org.mozilla.firefox", "mobi.mgeek.TunnyBrowser", "com.UCMobile.intl", "com.opera.mini.android", "com.jiubang.browser", "com.opera.browser", "com.uc.browser.en", "acr.browser.barebones", "com.boatbrowser.free", 
        "com.mx.browser", "com.ilegendsoft.mercury", "gpc.myweb.hinet.net.PopupWeb", "mobi.browser.flashfox", "com.baidu.browser.inter", "com.sec.webbrowserminiapp", "com.android.browser", "com.android.vending"
    });

    public cs()
    {
    }

    public static Intent a(Context context, String s)
    {
label0:
        {
            if (context == null || TextUtils.isEmpty(s))
            {
                return null;
            }
            Object obj = context.getPackageManager();
            context = new Intent("android.intent.action.VIEW", Uri.parse(s));
            s = ((PackageManager) (obj)).queryIntentActivities(context, 0x10000);
            if (s == null || s.size() <= 0)
            {
                break label0;
            }
            s = s.iterator();
            do
            {
                if (!s.hasNext())
                {
                    break label0;
                }
                obj = ((ResolveInfo)s.next()).activityInfo;
            } while (!a(((ActivityInfo) (obj)).packageName));
            return a(((ActivityInfo) (obj)), ((Intent) (context)));
        }
        return null;
    }

    private static Intent a(ActivityInfo activityinfo, Intent intent)
    {
        gd.a(3, a, (new StringBuilder()).append("Launching App in package: ").append(activityinfo.packageName).toString());
        activityinfo = new ComponentName(activityinfo.applicationInfo.packageName, activityinfo.name);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(activityinfo);
        return intent;
    }

    private static boolean a(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (TextUtils.isEmpty(s))
            {
                break label0;
            }
            if (!"com.android.vending".equalsIgnoreCase(s))
            {
                flag = flag1;
                if (!"com.google.market".equalsIgnoreCase(s))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

}
