// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


// Referenced classes of package netswipe:
//            o, ce, c, cz, 
//            cl

class ad
    implements Runnable
{

    final o a;

    ad(o o1)
    {
        a = o1;
        super();
    }

    public void run()
    {
        byte abyte0[] = o.j(a).c();
        String s;
        String s1;
        if (o.b(a).b())
        {
            s = "front";
        } else
        {
            s = "back";
        }
        if (o.a(a).e())
        {
            s1 = "portrait";
        } else
        {
            s1 = "landscape";
        }
        o.l(a).a(o.k(a), abyte0, s, s1, o.b(a).d(), Boolean.toString(o.b(a).c()));
        o.a(a, "cardDetection", System.currentTimeMillis() - o.m(a));
    }
}
