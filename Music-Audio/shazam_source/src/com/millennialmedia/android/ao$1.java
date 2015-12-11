// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ao, v, ab, ak

final class c
    implements Runnable
{

    final ab a;
    final String b;
    final String c;
    final ao d;

    public final void run()
    {
        aa aa;
        if (v.a(d.getContext()).e)
        {
            d.c();
        } else
        if (d.i == 0)
        {
            d.b();
        } else
        {
            d.a();
        }
        aa = a.d();
        if (aa != null && (aa instanceof ak))
        {
            ((ak)aa).d();
        }
        d.d = true;
        d.loadDataWithBaseURL(b, c, "text/html", "UTF-8", null);
    }

    (ao ao1, ab ab1, String s, String s1)
    {
        d = ao1;
        a = ab1;
        b = s;
        c = s1;
        super();
    }
}
