// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.mopub.common.c.a;
import com.mopub.common.d.m;

public class f
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a f[];
        public final int e;

        static a a(int i1)
        {
            switch (i1)
            {
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            default:
                return a;

            case 9: // '\t'
                return b;

            case 1: // '\001'
                return c;

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                return d;
            }
        }

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/mopub/common/f$a, s1);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        public final String toString()
        {
            return Integer.toString(e);
        }

        static 
        {
            a = new a("UNKNOWN", 0, 0);
            b = new a("ETHERNET", 1, 1);
            c = new a("WIFI", 2, 2);
            d = new a("MOBILE", 3, 3);
            f = (new a[] {
                a, b, c, d
            });
        }

        private a(String s1, int i1, int j1)
        {
            super(s1, i1);
            e = j1;
        }
    }


    private static volatile f t;
    String a;
    public final String b;
    public String c;
    public final String d;
    public final String e;
    public String f;
    public String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l = "3.11.0";
    public final String m;
    public final String n;
    public String o;
    public final Context p;
    private String q;
    private boolean r;
    private boolean s;
    private final ConnectivityManager u;

    private f(Context context)
    {
        r = false;
        s = false;
        p = context.getApplicationContext();
        u = (ConnectivityManager)p.getSystemService("connectivity");
        h = Build.MANUFACTURER;
        i = Build.MODEL;
        j = Build.PRODUCT;
        k = android.os.Build.VERSION.RELEASE;
        m = b(p);
        PackageManager packagemanager = p.getPackageManager();
        n = context.getPackageName();
        try
        {
            context = packagemanager.getApplicationInfo(n, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = null;
        }
        if (context != null)
        {
            o = (String)packagemanager.getApplicationLabel(context);
        }
        context = (TelephonyManager)p.getSystemService("phone");
        a = context.getNetworkOperator();
        b = context.getNetworkOperator();
        if (context.getPhoneType() == 2 && context.getSimState() == 5)
        {
            a = context.getSimOperator();
            c = context.getSimOperator();
        }
        d = context.getNetworkCountryIso();
        e = context.getSimCountryIso();
        try
        {
            f = context.getNetworkOperatorName();
            if (context.getSimState() == 5)
            {
                g = context.getSimOperatorName();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            f = null;
            g = null;
        }
        context = android.provider.Settings.Secure.getString(p.getContentResolver(), "android_id");
        if (context == null)
        {
            context = "";
        } else
        {
            context = com.mopub.common.d.m.a(context);
        }
        q = (new StringBuilder("sha:")).append(context).toString();
    }

    public static f a()
    {
        Object obj;
        obj = t;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        com/mopub/common/f;
        JVM INSTR monitorenter ;
        obj = t;
        com/mopub/common/f;
        JVM INSTR monitorexit ;
        return ((f) (obj));
        obj;
        com/mopub/common/f;
        JVM INSTR monitorexit ;
        throw obj;
        return ((f) (obj));
    }

    public static f a(Context context)
    {
        f f1;
        f1 = t;
        if (f1 != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        com/mopub/common/f;
        JVM INSTR monitorenter ;
        f f2 = t;
        f1 = f2;
        if (f2 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        f1 = new f(context);
        t = f1;
        com/mopub/common/f;
        JVM INSTR monitorexit ;
        return f1;
        context;
        com/mopub/common/f;
        JVM INSTR monitorexit ;
        throw context;
        return f1;
    }

    private static String b(Context context)
    {
        try
        {
            String s1 = context.getPackageName();
            context = context.getPackageManager().getPackageInfo(s1, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.mopub.common.c.a.b("Failed to retrieve PackageInfo#versionName.");
            return null;
        }
        return context;
    }

    public final a b()
    {
        byte byte0 = -1;
        int i1 = byte0;
        if (p.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            NetworkInfo networkinfo = u.getActiveNetworkInfo();
            i1 = byte0;
            if (networkinfo != null)
            {
                i1 = networkinfo.getType();
            }
        }
        return com.mopub.common.a.a(i1);
    }

    public final String c()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = q;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = r;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
