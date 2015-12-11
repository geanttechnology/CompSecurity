// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;
import com.helpshift.e.a;
import com.helpshift.h.g;
import java.util.UUID;

// Referenced classes of package com.helpshift:
//            v

public class y
{
    private static class a
    {

        private static final y a = new y(com.helpshift.v.a());

        static y a()
        {
            return a;
        }

    }


    private g a;

    public y(Context context)
    {
        a = new g(context);
    }

    public static y a()
    {
        return com.helpshift.a.a();
    }

    public com.helpshift.e.a a(String s)
    {
        com.helpshift.e.a a2 = a.a(s);
        com.helpshift.e.a a1 = a2;
        if (a2 == null)
        {
            a1 = new com.helpshift.e.a(s);
            a1.d(UUID.randomUUID().toString());
        }
        return a1;
    }

    public void a(String s, String s1)
    {
        s = a(s);
        s.a(s1);
        a.a(s);
    }

    public String b(String s)
    {
        return a(s).c();
    }

    public void b(String s, String s1)
    {
        s = a(s);
        s.b(s1);
        a.a(s);
    }

    public String c(String s)
    {
        return a(s).d();
    }

    public void c(String s, String s1)
    {
        s = a(s);
        s.c(s1);
        a.a(s);
    }

    public String d(String s)
    {
        return a(s).e();
    }
}
