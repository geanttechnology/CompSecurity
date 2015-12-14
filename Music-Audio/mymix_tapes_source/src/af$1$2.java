// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class ng.Object
    implements Runnable
{

    private int a;
    private b b;

    public final void run()
    {
        if (a == 4)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(b.b, "Recorder error");
            af.b(b.b).g();
            return;
        } else
        {
            af.b(b.b).i();
            return;
        }
    }

    ct(ct ct, int i)
    {
        b = ct;
        a = i;
        super();
    }

    // Unreferenced inner class af$1

/* anonymous class */
    final class af._cls1
        implements bb
    {

        final af a;

        public final void a()
        {
            ax.a(new af._cls1._cls1());
        }

        public final void a(float f)
        {
            af.a(a).a(f);
        }

        public final void a(int i)
        {
            ax.a(new af._cls1._cls2(this, i));
        }

            
            {
                a = af1;
                super();
            }

        // Unreferenced inner class af$1$1

/* anonymous class */
        final class af._cls1._cls1
            implements Runnable
        {

            private af._cls1 a;

            public final void run()
            {
                af.b(a.a).h();
            }

                    
                    {
                        a = af._cls1.this;
                        super();
                    }
        }

    }

}
