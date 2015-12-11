// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import com.b.e.n;
import com.b.e.p;

// Referenced classes of package com.b.e.a:
//            b, c

public final class a
{

    private static final String f = "com.google.android.gms";
    private static final String g = "com.google.android.gms.ads.identifier.service.START";
    public String a;
    public String b;
    public n c;
    public Context d;
    public String e;

    public a(Context context, n n)
    {
        d = context;
        c = n;
    }

    public static String a(Context context)
    {
        Exception exception1;
        String s = "";
        b b1 = new b((byte)0);
        Intent intent = new Intent(g);
        intent.setPackage(f);
        if (context.bindService(intent, b1, 1))
        {
            try
            {
                s = (new c(b1.a())).a();
            }
            catch (Exception exception)
            {
                context.unbindService(b1);
                return "";
            }
            finally
            {
                context.unbindService(b1);
            }
            context.unbindService(b1);
        }
        return s;
        throw exception1;
    }

    public static String a(String s)
    {
        Object obj = null;
        String s1 = obj;
        if (s != null)
        {
            s1 = obj;
            if (s.length() > 0)
            {
                try
                {
                    s1 = p.b(p.a((new StringBuilder("JetportGotAMaskOfThe")).append(s).append("S.D_K-").toString()));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return null;
                }
            }
        }
        return s1;
    }

    public static String b(Context context)
    {
        if (Integer.valueOf(android.os.Build.VERSION.SDK_INT).intValue() >= 3)
        {
            context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (context != null && context.length() > 0 && !"9774d56d682e549c".equals(context) && !"unknown".equals(context) && !"android_id".equals(context))
            {
                return context;
            }
        }
        return null;
    }

    public static String e()
    {
        if (Integer.valueOf(android.os.Build.VERSION.SDK_INT).intValue() < 9)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        String s;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            s = Build.SERIAL;
        } else
        {
            s = "";
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (s.length() <= 0 || s.equals("unknown") || s.length() <= 3 || s.substring(0, 3).equals("***"))
        {
            break MISSING_BLOCK_LABEL_93;
        }
        flag = s.substring(0, 3).equals("000");
        if (!flag)
        {
            return s;
        }
        break MISSING_BLOCK_LABEL_93;
        Exception exception;
        exception;
        return null;
    }

    public final String a()
    {
        if (e == null)
        {
            e = "";
        }
        return e;
    }

    public final boolean b()
    {
        return e == null || e.length() == 0;
    }

    public final boolean c()
    {
        Object obj = Boolean.FALSE;
        if (android.os.Build.VERSION.SDK_INT <= 8)
        {
            obj = Boolean.FALSE;
        } else
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b b1;
            try
            {
                d.getPackageManager().getPackageInfo("com.android.vending", 0);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return Boolean.FALSE.booleanValue();
            }
            b1 = new b((byte)0);
            obj = new Intent(g);
            ((Intent) (obj)).setPackage(f);
            if (d.bindService(((Intent) (obj)), b1, 1))
            {
                obj = Boolean.TRUE;
                d.unbindService(b1);
            } else
            {
                obj = Boolean.FALSE;
            }
        }
        return ((Boolean) (obj)).booleanValue();
    }

    public final Boolean d()
    {
        Boolean boolean1;
        Boolean boolean2;
        b b1;
        boolean flag;
        flag = true;
        boolean2 = Boolean.FALSE;
        b1 = new b((byte)0);
        Intent intent = new Intent(g);
        intent.setPackage(f);
        boolean1 = boolean2;
        if (!d.bindService(intent, b1, 1))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        if ((new c(b1.a())).b())
        {
            flag = false;
        }
        boolean1 = Boolean.valueOf(flag);
        d.unbindService(b1);
        return boolean1;
        Object obj;
        obj;
        d.unbindService(b1);
        return boolean2;
        obj;
        d.unbindService(b1);
        throw obj;
    }

}
