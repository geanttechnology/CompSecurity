// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.c.a;
import java.io.File;
import java.lang.reflect.Field;

// Referenced classes of package com.mopub.common.d:
//            n, m

public final class c
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a f[];
        private final String e;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/mopub/common/d/c$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("FORCE_PORTRAIT", 0, "portrait");
            b = new a("FORCE_LANDSCAPE", 1, "landscape");
            c = new a("DEVICE_ORIENTATION", 2, "device");
            d = new a("UNDEFINED", 3, "");
            f = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i, String s1)
        {
            super(s, i);
            e = s1;
        }
    }


    public static int a(int i, int j)
    {
        byte byte0 = 9;
        if (1 == j)
        {
            j = byte0;
            switch (i)
            {
            default:
                j = 1;
                // fall through

            case 1: // '\001'
            case 2: // '\002'
                return j;
            }
        }
        if (2 == j)
        {
            switch (i)
            {
            default:
                return 0;

            case 2: // '\002'
            case 3: // '\003'
                return 8;
            }
        } else
        {
            com.mopub.common.c.a.b("Unknown screen orientation. Defaulting to portrait.");
            return 9;
        }
    }

    public static long a(File file)
    {
        long l = 0xa00000L;
        long l1;
        file = new StatFs(file.getAbsolutePath());
        l1 = file.getBlockCount();
        l1 = ((long)file.getBlockSize() * l1) / 50L;
        l = l1;
_L2:
        return Math.max(Math.min(l, 0x6400000L), 0x1e00000L);
        file;
        com.mopub.common.c.a.b("Unable to calculate 2% of available disk space, defaulting to minimum");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean a(Context context)
    {
        if (context == null)
        {
            return false;
        }
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
        {
            return false;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public static int b(Context context)
    {
        ActivityManager activitymanager;
        long l;
        long l1;
        activitymanager = (ActivityManager)context.getSystemService("activity");
        l = activitymanager.getMemoryClass();
        l1 = l;
        if (!com.mopub.common.d.n.a().a(n.k))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        int i;
        i = android/content/pm/ApplicationInfo.getDeclaredField("FLAG_LARGE_HEAP").getInt(null);
        if (!com.mopub.common.d.m.a(context.getApplicationInfo().flags, i))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        i = ((Integer)(new i.a(activitymanager, "getLargeMemoryClass")).a()).intValue();
        l = i;
        l1 = l;
_L2:
        return (int)Math.min(0x1e00000L, (l1 / 8L) * 1024L * 1024L);
        context;
        com.mopub.common.c.a.b("Unable to reflectively determine large heap size on Honeycomb and above.");
        l1 = l;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Point c(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 13) goto _L2; else goto _L1
_L1:
        Object obj1 = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT < 17) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = new Point();
        ((Display) (obj1)).getRealSize(((Point) (obj)));
        obj1 = Integer.valueOf(((Point) (obj)).x);
        obj = Integer.valueOf(((Point) (obj)).y);
_L7:
        Integer integer;
label0:
        {
            if (obj1 != null)
            {
                integer = ((Integer) (obj));
                if (obj != null)
                {
                    break label0;
                }
            }
            context = context.getResources().getDisplayMetrics();
            obj1 = Integer.valueOf(((DisplayMetrics) (context)).widthPixels);
            integer = Integer.valueOf(((DisplayMetrics) (context)).heightPixels);
        }
        return new Point(((Integer) (obj1)).intValue(), integer.intValue());
_L4:
        obj = (Integer)(new i.a(obj1, "getRawWidth")).a();
        Integer integer1 = (Integer)(new i.a(obj1, "getRawHeight")).a();
        obj1 = obj;
        obj = integer1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj1 = null;
_L5:
        com.mopub.common.c.a.a("Display#getRawWidth/Height failed.", exception);
        obj = null;
        continue; /* Loop/switch isn't completed */
        exception;
        obj1 = obj;
        if (true) goto _L5; else goto _L2
_L2:
        obj = null;
        obj1 = null;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
