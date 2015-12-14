// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager, b

public abstract class u
{

    public static final String a;
    public static final String b;

    public static final String a()
    {
        return Globals.J();
    }

    public static final String a(Context context)
    {
        String s = context.getString(0x7f07073e);
        context = s;
        if ("Unknown".equals(s))
        {
            context = "YMK140514-01";
        }
        return context;
    }

    public static final String a(Context context, NetworkManager networkmanager)
    {
        if (Globals.d)
        {
            context = z.b(context);
            context = (new StringBuilder()).append("Baidu_").append(context).toString();
            networkmanager = z.c();
            String s = z.d();
            if (!networkmanager.isEmpty() && !s.isEmpty())
            {
                return (new StringBuilder()).append("Baidu_").append(s).append("_").append(networkmanager).toString();
            } else
            {
                NetworkManager.c.set(true);
                return context;
            }
        } else
        {
            return networkmanager.I();
        }
    }

    public static final String b()
    {
        return NetworkManager.F();
    }

    public static final String b(Context context)
    {
        String s = Globals.J();
        context = context.getString(0x7f070733);
        if ("Unknown".equals(context))
        {
            return s;
        } else
        {
            return context;
        }
    }

    public static final String c()
    {
        return com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
    }

    public static final String c(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        context.getSize(point);
        return (new StringBuilder()).append(point.x).append("X").append(point.y).toString();
    }

    public static final String d(Context context)
    {
        return z.b(context);
    }

    static 
    {
        a = Build.MODEL;
        b = Build.MANUFACTURER;
    }
}
