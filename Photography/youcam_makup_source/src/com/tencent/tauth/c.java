// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.connect.b.l;
import com.tencent.connect.b.m;
import com.tencent.open.a.k;

// Referenced classes of package com.tencent.tauth:
//            b

public class c
{

    private static c b;
    private final l a;

    private c(String s, Context context)
    {
        com.tencent.open.utils.c.a(context.getApplicationContext());
        a = l.a(s, context);
    }

    public static c a(String s, Context context)
    {
        com/tencent/tauth/c;
        JVM INSTR monitorenter ;
        k.a("openSDK_LOG", "createInstance()  -- start");
        if (b != null) goto _L2; else goto _L1
_L1:
        b = new c(s, context);
_L4:
        boolean flag = a(context, s);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        s = null;
_L5:
        com/tencent/tauth/c;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (s.equals(b.b())) goto _L4; else goto _L3
_L3:
        b.a(context);
        b = new c(s, context);
          goto _L4
        s;
        throw s;
        k.a("openSDK_LOG", "createInstance()  -- end");
        s = b;
          goto _L5
    }

    private static boolean a(Context context, String s)
    {
        try
        {
            ComponentName componentname = new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity");
            context.getPackageManager().getActivityInfo(componentname, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = (new StringBuilder()).append("\u6CA1\u6709\u5728AndroidManifest.xml\u4E2D\u68C0\u6D4B\u5230com.tencent.tauth.AuthActivity,\u8BF7\u52A0\u4E0Acom.tencent.open.AuthActivity,\u5E76\u914D\u7F6E<data android:scheme=\"tencent").append(s).append("\" />,\u8BE6\u7EC6\u4FE1\u606F\u8BF7\u67E5\u770B\u5B98\u7F51\u6587\u6863.").toString();
            k.e("AndroidManifest.xml \u6CA1\u6709\u68C0\u6D4B\u5230com.tencent.tauth.AuthActivity", (new StringBuilder()).append(context).append("\n\u914D\u7F6E\u793A\u4F8B\u5982\u4E0B: \n<activity\n     android:name=\"com.tencent.connect.util.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n     <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent").append(s).append("\" />\n").append("</intent-filter>\n").append("</activity>").toString());
            return false;
        }
        try
        {
            s = new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity");
            context.getPackageManager().getActivityInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            k.e("AndroidManifest.xml \u6CA1\u6709\u68C0\u6D4B\u5230com.tencent.connect.common.AssistActivity", (new StringBuilder()).append("\u6CA1\u6709\u5728AndroidManifest.xml\u4E2D\u68C0\u6D4B\u5230com.tencent.connect.common.AssistActivity,\u8BF7\u52A0\u4E0Acom.tencent.connect.common.AssistActivity,\u8BE6\u7EC6\u4FE1\u606F\u8BF7\u67E5\u770B\u5B98\u7F51\u6587\u6863.").append("\n\u914D\u7F6E\u793A\u4F8B\u5982\u4E0B: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"portrait\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>").toString());
            return false;
        }
        return true;
    }

    public int a(Activity activity, String s, b b1)
    {
        return a.a(activity, s, b1);
    }

    public void a(Context context)
    {
        a.a().a(null, "0");
        a.a().a(null);
    }

    public boolean a()
    {
        return a.b();
    }

    public String b()
    {
        return a.a().b();
    }

    public m c()
    {
        return a.a();
    }
}
