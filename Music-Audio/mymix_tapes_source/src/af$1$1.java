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
        af.b(a.a).h();
    }

    ct(ct ct)
    {
        a = ct;
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
            ax.a(new af._cls1._cls1(this));
        }

        public final void a(float f)
        {
            af.a(a).a(f);
        }

        public final void a(int i)
        {
            ax.a(new af._cls1._cls2(i));
        }

            
            {
                a = af1;
                super();
            }

        // Unreferenced inner class af$1$2

/* anonymous class */
        final class af._cls1._cls2
            implements Runnable
        {

            private int a;
            private af._cls1 b;

            public final void run()
            {
                if (a == 4)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.c(b.a, "Recorder error");
                    af.b(b.a).g();
                    return;
                } else
                {
                    af.b(b.a).i();
                    return;
                }
            }

                    
                    {
                        b = af._cls1.this;
                        a = i;
                        super();
                    }
        }

    }

}
