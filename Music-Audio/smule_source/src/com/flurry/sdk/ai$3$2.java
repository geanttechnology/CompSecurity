// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            hq, ai, gk, gd, 
//            fp

class t> extends hq
{

    final a a;

    public void safeRun()
    {
        ai.j(a.a);
    }

    >(> >)
    {
        a = >;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/ai$3

/* anonymous class */
    class ai._cls3
        implements gk.a
    {

        final ai a;

        public volatile void a(gk gk1, Object obj)
        {
            a(gk1, (Void)obj);
        }

        public void a(gk gk1, Void void1)
        {
            if (a.b())
            {
                return;
            }
            int i = gk1.e();
            gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: HTTP HEAD status code is:").append(i).append(" for url: ").append(ai.f(a)).toString());
            if (gk1.c())
            {
                ai.a(a, ai.a(a, gk1));
                gk1 = gk1.b("Accept-Ranges");
                if (ai.d(a) > 0L && gk1 != null && !gk1.isEmpty())
                {
                    ai.b(a, "bytes".equals(((String)gk1.get(0)).trim()));
                    gk1 = a;
                    long l = ai.d(a) / ai.i(a);
                    int j;
                    if (ai.d(a) % ai.i(a) > 0L)
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    ai.a(gk1, (int)((long)j + l));
                } else
                {
                    ai.a(a, 1);
                }
                if (ai.e(a) > 0L && ai.d(a) > ai.e(a))
                {
                    gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Size limit exceeded -- limit: ").append(ai.e(a)).append(", content-length: ").append(ai.d(a)).append(" bytes!").toString());
                    fp.a().b(new ai._cls3._cls1());
                    return;
                } else
                {
                    fp.a().b(new ai._cls3._cls2(this));
                    return;
                }
            } else
            {
                fp.a().b(new ai._cls3._cls3());
                return;
            }
        }

            
            {
                a = ai1;
                super();
            }

        // Unreferenced inner class com/flurry/sdk/ai$3$1

/* anonymous class */
        class ai._cls3._cls1 extends hq
        {

            final ai._cls3 a;

            public void safeRun()
            {
                ai.h(a.a);
            }

                    
                    {
                        a = ai._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/flurry/sdk/ai$3$3

/* anonymous class */
        class ai._cls3._cls3 extends hq
        {

            final ai._cls3 a;

            public void safeRun()
            {
                ai.h(a.a);
            }

                    
                    {
                        a = ai._cls3.this;
                        super();
                    }
        }

    }

}
