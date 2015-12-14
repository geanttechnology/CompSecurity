// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.pf.common.utility.m;
import java.io.IOException;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.b:
//            b

public class a extends ax
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/b/a.getSimpleName();
    private final Context b;
    private final NetworkManager c;
    private final b d;

    public a(Context context, NetworkManager networkmanager, b b1)
    {
        b = context;
        c = networkmanager;
        d = b1;
    }

    private static int a(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder()).append("Could not get package name: ").append(context).toString());
        }
        return i;
    }

    private static void a(Context context, String s)
    {
        int i = a(context);
        m.c(a, (new StringBuilder()).append("Saving regId(").append(s).append(") on app version (").append(i).append(")").toString());
        z.a("appVersion", i, context);
        z.a("registration_id", s, context);
        com.cyberlink.beautycircle.a.a(context, s);
    }

    private void a(String s)
    {
        c.a(s, b);
        d.a(s);
    }

    private static String b(Context context)
    {
        String s = z.b("registration_id", context);
        if (s.isEmpty())
        {
            m.c(a, "Registration not found.");
            s = "";
        } else
        if (z.c("appVersion", context) != a(context))
        {
            m.c(a, "App version changed.");
            return "";
        }
        return s;
    }

    public void a()
    {
        Context context = b;
        String s = b(context);
        if (!s.isEmpty())
        {
            a(s);
            return;
        }
        try
        {
            String s1 = GoogleCloudMessaging.getInstance(context).register(new String[] {
                "8121036310"
            });
            a(context, s1);
            a(s1);
            return;
        }
        catch (IOException ioexception)
        {
            d.b(new bn(null, ioexception));
        }
        return;
    }

    public void a(bn bn1)
    {
        d.b(bn1);
    }

}
