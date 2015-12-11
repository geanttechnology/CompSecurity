// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.Context;
import com.b.e.b.b;

// Referenced classes of package com.b.a:
//            b, g, j, h, 
//            k

public final class i
{

    private static com.b.a.b a = new com.b.a.b();

    public static void a()
    {
        a.d();
    }

    public static void a(Context context)
    {
        com.b.a.b b1 = a;
        if (b1.ab != null || context == null)
        {
            return;
        } else
        {
            b1.ab = context;
            b1.f = new b(b1);
            b1.f.a(new g(b1), true);
            return;
        }
    }

    public static void a(String s)
    {
        com.b.a.b b1;
        for (b1 = a; s.length() == 0 || b1.f == null;)
        {
            return;
        }

        b1.f.a(new j(b1, s), true);
    }

    public static void b()
    {
        a.e();
    }

    public static void b(String s)
    {
        com.b.a.b b1 = a;
        if (s.length() == 0 || b1.f == null)
        {
            return;
        } else
        {
            b1.f.a(new h(b1, s), true);
            return;
        }
    }

    public static void c()
    {
        com.b.a.b b1 = a;
        b1.f.a(new k(b1), true);
    }

}
