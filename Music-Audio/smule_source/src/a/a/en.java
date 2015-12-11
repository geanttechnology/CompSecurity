// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.util.Log;
import java.util.concurrent.ExecutorService;

// Referenced classes of package a.a:
//            eo, dd, ev, eb

public final class en
{

    public static eo a;
    private static ev b;

    public static void a()
    {
    }

    public static void a(ev ev1)
    {
        b = ev1;
    }

    public static void a(String s)
    {
        Log.i("Crittercism", s);
    }

    public static void a(String s, Throwable throwable)
    {
        Log.e("Crittercism", s, throwable);
    }

    public static void a(Throwable throwable)
    {
        if (throwable instanceof dd)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ev ev1 = b;
        if (b != null && a == eo.b)
        {
            ev ev2 = b;
            throwable = new ev._cls1(ev2, throwable, Thread.currentThread().getId());
            if (!ev2.c.a(throwable))
            {
                ev2.b.execute(throwable);
            }
        }
        return;
        throwable;
        throw throwable;
        throwable;
    }

    public static void b()
    {
    }

    public static void b(String s)
    {
        Log.e("Crittercism", s);
    }

    public static void b(String s, Throwable throwable)
    {
        Log.w("Crittercism", s, throwable);
    }

    public static void c()
    {
    }

    public static void c(String s)
    {
        Log.w("Crittercism", s);
    }

    static 
    {
        a = eo.a;
    }
}
