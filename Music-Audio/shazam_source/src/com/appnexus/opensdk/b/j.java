// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.location.Location;
import android.os.Build;
import com.appnexus.opensdk.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.appnexus.opensdk.b:
//            b, k

public final class j
{

    public static String A = "http://mediation.adnxs.com/install?";
    private static j B = null;
    public static String x = "http://mediation.adnxs.com";
    public static String y = "http://mediation.adnxs.com/";
    public static String z = "http://mediation.adnxs.com/mob?";
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public final String f;
    public final String g;
    public String h;
    public boolean i;
    public String j;
    public boolean k;
    public final String l = "2.6";
    public String m;
    public String n;
    public final String o = TimeZone.getDefault().getDisplayName(true, 0);
    public final String p = Locale.getDefault().getLanguage();
    public boolean q;
    public Location r;
    public int s;
    public HashMap t;
    public HashSet u;
    public HashSet v;
    public HashSet w;

    private j()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = false;
        f = Build.MANUFACTURER;
        g = Build.MODEL;
        h = null;
        i = false;
        j = null;
        q = true;
        r = null;
        s = -1;
        t = new HashMap();
        u = new HashSet();
        v = new HashSet();
        w = new HashSet();
    }

    public static j a()
    {
        if (B == null)
        {
            B = new j();
            com.appnexus.opensdk.b.b.a(b.b, com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.an.d.init));
        }
        return B;
    }

    public final void a(z z1, String s1)
    {
        if (com.appnexus.opensdk.b.k.a(s1)) goto _L2; else goto _L1
_L1:
        public static final class _cls1
        {

            public static final int a[];

            static 
            {
                a = new int[com.appnexus.opensdk.z.values().length];
                try
                {
                    a[z.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[z.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[z.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[z1.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 41
    //                   2 51
    //                   3 61;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        u.add(s1);
        return;
_L4:
        v.add(s1);
        return;
_L5:
        w.add(s1);
        return;
    }

}
