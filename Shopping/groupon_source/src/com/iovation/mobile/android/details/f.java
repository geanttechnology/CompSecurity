// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, k, j

public class f
    implements i
{

    public f()
    {
    }

    public String a()
    {
        String s = k.a("cat /proc/cpuinfo");
        if (s != null)
        {
            s = k.b(s).toUpperCase(Locale.getDefault());
            if (s.startsWith("Processor\t: ".toUpperCase(Locale.getDefault())))
            {
                return s.substring("Processor\t: ".length(), s.length());
            }
        }
        return null;
    }

    public void a(Context context, j j1)
    {
        j1.a("ABN", Build.DISPLAY);
        j1.a("ASL", Integer.toString(android.os.Build.VERSION.SDK_INT));
        try
        {
            j1.a("AFPID", k.a(Build.FINGERPRINT.getBytes("utf-8")));
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        j1.a("MODEL", Build.MODEL);
        j1.a("KERID", Build.ID);
        j1.a("AFPCL", Build.FINGERPRINT);
        j1.a("ANDD", Build.DEVICE);
        j1.a("BHOST", Build.HOST);
        j1.a("DMFG", Build.MANUFACTURER);
        j1.a("APRD", Build.PRODUCT);
        j1.a("KERD", Long.toString(Build.TIME));
        j1.a("OSVER", android.os.Build.VERSION.RELEASE);
        j1.a("BRAND", Build.BRAND);
        j1.a("UPTIME", Double.toString((double)SystemClock.uptimeMillis() / 1000D));
        j1.a("CPU", a());
        j1.a("PHYMEM", c());
        j1.a("HOST", b().trim());
    }

    public String b()
    {
        return k.a("getprop net.hostname");
    }

    public String c()
    {
        String s = k.b(k.a("cat /proc/meminfo"));
        if (s != null && s.startsWith("MemTotal:        ") && s.endsWith(" kB"))
        {
            return Long.toString(Long.valueOf(s.substring("MemTotal:        ".length(), s.length() - " kB".length()).trim()).longValue() / 1024L);
        } else
        {
            return null;
        }
    }
}
