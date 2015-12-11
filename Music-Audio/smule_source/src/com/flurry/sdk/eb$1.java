// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            fy, eb, fp, ed, 
//            fx

class it>
    implements fy
{

    final eb a;

    public void a(ed ed1)
    {
        fp.a().a(new Runnable(ed1) {

            final ed a;
            final eb._cls1 b;

            public void run()
            {
                ed.a a1 = a.a;
                switch (eb._cls8.a[a1.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    eb.a(b.a, a);
                    return;

                case 2: // '\002'
                    eb.a(b.a);
                    return;

                case 3: // '\003'
                    eb.a(b.a, a.b);
                    return;

                case 4: // '\004'
                    eb.b(b.a, a.b);
                    return;

                case 5: // '\005'
                    eb.c(b.a, a.b);
                    break;
                }
            }

            
            {
                b = eb._cls1.this;
                a = ed1;
                super();
            }
        });
    }

    public void notify(fx fx)
    {
        a((ed)fx);
    }

    it>(eb eb1)
    {
        a = eb1;
        super();
    }
}
