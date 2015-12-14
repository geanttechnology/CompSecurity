// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.baidupush;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.baidu.android.pushservice.PushManager;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;
import java.util.Calendar;

// Referenced classes of package com.cyberlink.youcammakeup.baidupush:
//            b

public class a extends ax
{

    private final Context a;
    private final b b;
    private final NetworkManager c;

    public a(Context context, NetworkManager networkmanager, b b1)
    {
        a = context;
        c = networkmanager;
        b = b1;
    }

    public static String a(Context context, String s)
    {
        if (context != null && s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        context = ((ApplicationInfo) (context)).metaData;
_L4:
        if (context == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = context.getString(s);
        return context;
        context = null;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a()
    {
        String s = z.c();
        String s1 = z.d();
        m.b("BaiduRegisterTask", (new StringBuilder()).append("Baidu channelID=").append(s).append(", userID=").append(s1).toString());
        if (s.isEmpty() || s1.isEmpty())
        {
            m.b("BaiduRegisterTask", (new StringBuilder()).append("before start work at ").append(Calendar.getInstance().getTimeInMillis()).toString());
            PushManager.startWork(Globals.d().getApplicationContext(), 0, a(a, "api_key"));
            m.b("BaiduRegisterTask", (new StringBuilder()).append("after start work at ").append(Calendar.getInstance().getTimeInMillis()).toString());
        } else
        {
            c.a(s1, s, a);
        }
        b.a(null);
    }

    public void a(bn bn)
    {
    }
}
