// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            co, dy, bg, dc, 
//            cn, am, dz, f, 
//            ea, cx, h

class ah
{

    private static final String b = com/amazon/device/ads/ah.getSimpleName();
    final am a;
    private final ds.k c;
    private final dy.d d;
    private final f e;
    private final ea f;
    private final cn g;
    private final bg h;

    public ah(ds.k k, am am1, dy.d d1, f f1, ea ea, bg bg1)
    {
        c = k;
        a = am1;
        d = d1;
        e = f1;
        f = ea;
        g = co.a(b);
        h = bg1;
    }

    static f a(ah ah1)
    {
        return ah1.e;
    }

    static void a(ah ah1, String s, boolean flag, cx cx)
    {
        Object obj;
        Object obj1;
        obj1 = ah1.d.a();
        ((dy) (obj1)).e(b);
        ((dy) (obj1)).d();
        ((dy) (obj1)).c(s);
        ((dy) (obj1)).c("User-Agent", ah1.h.i());
        obj = null;
        obj1 = ((dy) (obj1)).c();
        obj = obj1;
_L2:
        if (obj != null)
        {
            obj = ((dy.g) (obj)).a().c();
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            ah1.c.a(ah1. new Runnable(s, ((String) (obj)), flag, cx) {

                final String a;
                final String b;
                final boolean c;
                final cx d;
                final ah e;

                public final void run()
                {
                    f f1 = ah.a(e);
                    String s1 = a;
                    String s2 = b;
                    boolean flag1 = c;
                    cx cx1 = d;
                    f1.a.a(s1, s2, flag1, cx1);
                }

            
            {
                e = ah.this;
                a = s;
                b = s1;
                c = flag;
                d = cx;
                super();
            }
            }, ds.b.a, ds.c.a);
        }
        return;
        dy.c c1;
        c1;
        ah1.g.d("Could not load URL (%s) into AdContainer: %s", new Object[] {
            s, c1.getMessage()
        });
        if (true) goto _L2; else goto _L1
_L1:
        ah1.g.d("Could not load URL (%s) into AdContainer.", new Object[] {
            s
        });
        return;
    }

    public final void a(String s)
    {
        a.a(s);
    }

    public final void a(String s, boolean flag, cx cx)
    {
        String s1 = dz.b(s);
        if (s1.equals("http") || s1.equals("https"))
        {
            c.a(new Runnable(s, flag, cx) {

                final String a;
                final boolean b;
                final cx c;
                final ah d;

                public final void run()
                {
                    ah.a(d, a, b, c);
                }

            
            {
                d = ah.this;
                a = s;
                b = flag;
                c = cx;
                super();
            }
            }, ds.b.a, ds.c.b);
            return;
        } else
        {
            a(s);
            return;
        }
    }

}
