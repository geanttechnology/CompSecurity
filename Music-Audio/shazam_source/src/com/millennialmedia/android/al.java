// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.util.Log;

// Referenced classes of package com.millennialmedia.android:
//            s

public final class al
{
    static final class a
    {

        static int a = 4;

        static void a(String s1, String s2)
        {
            Log.e((new StringBuilder("MMSDK-")).append(s1).toString(), s2);
        }


        a()
        {
        }
    }


    static void a()
    {
        s.j();
    }

    static void a(String s1, String s2)
    {
        s.j();
        if (a.a <= 6)
        {
            a.a(s1, s2);
        }
    }

    static void a(String s1, String s2, Throwable throwable)
    {
        s.j();
        if (a.a <= 6)
        {
            a.a(s1, (new StringBuilder()).append(s2).append(": ").append(Log.getStackTraceString(throwable)).toString());
        }
    }

    static void b()
    {
        s.j();
    }

    static void c()
    {
        s.j();
    }

    static void d()
    {
        s.j();
    }

    static 
    {
        s.a(new a());
    }
}
