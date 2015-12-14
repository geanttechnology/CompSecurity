// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.connect.a.a;
import com.tencent.open.a.k;
import com.tencent.open.utils.c;
import com.tencent.tauth.b;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tencent.connect.b:
//            m, a

public class l
{

    private com.tencent.connect.b.a a;
    private m b;

    private l(String s, Context context)
    {
        k.c("openSDK_LOG", "new QQAuth() --start");
        b = new m(s);
        a = new com.tencent.connect.b.a(b);
        com.tencent.connect.a.a.c(context, b);
        k.c("openSDK_LOG", "new QQAuth() --end");
    }

    private int a(Activity activity, Fragment fragment, String s, b b1, String s1)
    {
        Iterator iterator;
        s1 = activity.getApplicationContext().getPackageName();
        iterator = activity.getPackageManager().getInstalledApplications(128).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ApplicationInfo applicationinfo = (ApplicationInfo)iterator.next();
        if (!s1.equals(applicationinfo.packageName)) goto _L4; else goto _L3
_L3:
        s1 = applicationinfo.sourceDir;
_L6:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        int i;
        s1 = com.tencent.open.utils.a.a(new File(s1));
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_174;
        }
        k.b("openSDK_LOG", (new StringBuilder()).append("-->login channelId: ").append(s1).toString());
        i = a(activity, s, b1, s1, s1, "");
        return i;
        s1;
        k.b("openSDK_LOG", (new StringBuilder()).append("-->login get channel id exception.").append(s1.getMessage()).toString());
        s1.printStackTrace();
        k.b("openSDK_LOG", "-->login channelId is null ");
        com.tencent.connect.common.a.j = false;
        return a.a(activity, s, b1, false, fragment);
_L2:
        s1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static l a(String s, Context context)
    {
        c.a(context.getApplicationContext());
        k.c("openSDK_LOG", "QQAuth -- createInstance() --start");
        try
        {
            PackageManager packagemanager = context.getPackageManager();
            packagemanager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packagemanager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            k.b("openSDK_LOG", "createInstance() error --end", s);
            Toast.makeText(context.getApplicationContext(), "\u8BF7\u53C2\u7167\u6587\u6863\u5728Androidmanifest.xml\u52A0\u4E0AAuthActivity\u548CAssitActivity\u7684\u5B9A\u4E49 ", 1).show();
            return null;
        }
        s = new l(s, context);
        k.c("openSDK_LOG", "QQAuth -- createInstance()  --end");
        return s;
    }

    public int a(Activity activity, String s, b b1)
    {
        k.c("openSDK_LOG", "login()");
        return a(activity, s, b1, "");
    }

    public int a(Activity activity, String s, b b1, String s1)
    {
        k.c("openSDK_LOG", (new StringBuilder()).append("-->login activity: ").append(activity).toString());
        return a(activity, null, s, b1, s1);
    }

    public int a(Activity activity, String s, b b1, String s1, String s2, String s3)
    {
        k.c("openSDK_LOG", "loginWithOEM");
        com.tencent.connect.common.a.j = true;
        String s4 = s1;
        if (s1.equals(""))
        {
            s4 = "null";
        }
        s1 = s2;
        if (s2.equals(""))
        {
            s1 = "null";
        }
        s2 = s3;
        if (s3.equals(""))
        {
            s2 = "null";
        }
        com.tencent.connect.common.a.h = s1;
        com.tencent.connect.common.a.g = s4;
        com.tencent.connect.common.a.i = s2;
        return a.a(activity, s, b1);
    }

    public m a()
    {
        return b;
    }

    public boolean b()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("isSessionValid(), result = ");
        String s;
        if (b.a())
        {
            s = "true";
        } else
        {
            s = "false";
        }
        k.a("openSDK_LOG", stringbuilder.append(s).append("").toString());
        return b.a();
    }
}
