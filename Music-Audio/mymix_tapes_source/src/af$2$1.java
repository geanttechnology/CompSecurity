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
        af.b(a.a).k();
    }

    ct(ct ct)
    {
        a = ct;
        super();
    }

    // Unreferenced inner class af$2

/* anonymous class */
    final class af._cls2
        implements az
    {

        final af a;

        public final void a(Object obj)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(a, "Prompt error");
            ax.a(new af._cls2._cls1(this));
        }

        public final void b(Object obj)
        {
        }

        public final void c(Object obj)
        {
            ax.a(new af._cls2._cls2());
        }

            
            {
                a = af1;
                super();
            }

        // Unreferenced inner class af$2$2

/* anonymous class */
        final class af._cls2._cls2
            implements Runnable
        {

            private af._cls2 a;

            public final void run()
            {
                af.b(a.a).l();
            }

                    
                    {
                        a = af._cls2.this;
                        super();
                    }
        }

    }

}
