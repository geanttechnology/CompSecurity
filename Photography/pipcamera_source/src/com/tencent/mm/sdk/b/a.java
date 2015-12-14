// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Looper;
import android.os.Process;

// Referenced classes of package com.tencent.mm.sdk.b:
//            b

public final class a
{

    private static int level = 6;
    private static a n;
    private static a o;
    private static final String p;

    static int a()
    {
        return level;
    }

    public static void a(String s, String s1)
    {
        a(s, s1, null);
    }

    public static transient void a(String s, String s1, Object aobj[])
    {
        if (o != null && o.b() <= 4)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            aobj = s1;
            if (s1 == null)
            {
                aobj = "";
            }
            s1 = o;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            s1.f(s, ((String) (aobj)));
        }
    }

    public static void b(String s, String s1)
    {
        if (o != null && o.b() <= 2)
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = "";
            }
            s1 = o;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            s1.d(s, s2);
        }
    }

    public static void c(String s, String s1)
    {
        if (o != null && o.b() <= 1)
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = "";
            }
            s1 = o;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            s1.e(s, s2);
        }
    }

    static 
    {
        Object obj = new b();
        n = ((a) (obj));
        o = ((a) (obj));
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append((new StringBuilder("VERSION.RELEASE:[")).append(android.os.Build.VERSION.RELEASE).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] VERSION.CODENAME:[")).append(android.os.Build.VERSION.CODENAME).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] VERSION.INCREMENTAL:[")).append(android.os.Build.VERSION.INCREMENTAL).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] BOARD:[")).append(Build.BOARD).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] DEVICE:[")).append(Build.DEVICE).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] DISPLAY:[")).append(Build.DISPLAY).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] FINGERPRINT:[")).append(Build.FINGERPRINT).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] HOST:[")).append(Build.HOST).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] MANUFACTURER:[")).append(Build.MANUFACTURER).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] MODEL:[")).append(Build.MODEL).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] PRODUCT:[")).append(Build.PRODUCT).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] TAGS:[")).append(Build.TAGS).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] TYPE:[")).append(Build.TYPE).toString());
        ((StringBuilder) (obj)).append((new StringBuilder("] USER:[")).append(Build.USER).append("]").toString());
        p = ((StringBuilder) (obj)).toString();
    }

    private class a
    {

        public abstract int b();

        public abstract void d(String s, String s1);

        public abstract void e(String s, String s1);

        public abstract void f(String s, String s1);
    }

}
