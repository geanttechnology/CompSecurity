// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;


// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            n, af, m, o, 
//            k

class a
    implements Runnable
{

    final n a;

    public void run()
    {
        if (a.x != -1 && a.w != null)
        {
            if (a.x == 255)
            {
                a.m();
            } else
            if (a.x == 254)
            {
                a.o();
            } else
            if (a.x == 253)
            {
                a.n();
            } else
            if (!a.c.n())
            {
                a.r = true;
            } else
            {
                Object obj = a.w.a(a.x);
                obj = a.c.a(((q) (obj)), a.y);
                a.a(((k) (obj)).a, ((k) (obj)).b, ((k) (obj)).f, ((k) (obj)).g);
            }
            a.f.a(0);
        }
    }

    (n n1)
    {
        a = n1;
        super();
    }
}
