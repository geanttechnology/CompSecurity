// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class ng.Object
    implements Runnable
{

    private a a;

    public final void run()
    {
        au.a(a.a).h();
    }

    ct(ct ct)
    {
        a = ct;
        super();
    }

    // Unreferenced inner class au$1

/* anonymous class */
    final class au._cls1
        implements az
    {

        final au a;

        public final void a(Object obj)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(a, "Player error");
            ax.a(new au._cls1._cls1());
        }

        public final void b(Object obj)
        {
            ax.a(new au._cls1._cls2(this));
        }

        public final void c(Object obj)
        {
            ax.a(new au._cls1._cls3());
        }

            
            {
                a = au1;
                super();
            }

        // Unreferenced inner class au$1$1

/* anonymous class */
        final class au._cls1._cls1
            implements Runnable
        {

            private au._cls1 a;

            public final void run()
            {
                au.a(a.a).g();
            }

                    
                    {
                        a = au._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class au$1$3

/* anonymous class */
        final class au._cls1._cls3
            implements Runnable
        {

            private au._cls1 a;

            public final void run()
            {
                au.a(a.a).i();
            }

                    
                    {
                        a = au._cls1.this;
                        super();
                    }
        }

    }

}
