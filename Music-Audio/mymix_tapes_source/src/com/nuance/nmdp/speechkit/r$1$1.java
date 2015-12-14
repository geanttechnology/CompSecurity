// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ac;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            r, SpeechError, q, Recognition

final class a
    implements Runnable
{

    private SpeechError a;
    private Error b;

    public final void run()
    {
        if (r.a(b.b) != null)
        {
            r.a(b.b).onError(b.b, a);
        }
    }

    Error(Error error, SpeechError speecherror)
    {
        b = error;
        a = speecherror;
        super();
    }

    // Unreferenced inner class com/nuance/nmdp/speechkit/r$1

/* anonymous class */
    final class r._cls1 extends q
    {

        final r a;

        protected final void a(SpeechError speecherror)
        {
            r.a(a, new r._cls1._cls1(this, speecherror));
        }

        protected final void a(Object obj)
        {
            obj = (Recognition)obj;
            r.d(a, new r._cls1._cls4(((Recognition) (obj))));
        }

        protected final void b()
        {
            r.b(a, new r._cls1._cls2());
        }

        protected final void c()
        {
            r.c(a, new r._cls1._cls3());
        }

            
            {
                a = r1;
                super(m, s, flag, flag1, s1, ac);
            }

        // Unreferenced inner class com/nuance/nmdp/speechkit/r$1$2

/* anonymous class */
        final class r._cls1._cls2
            implements Runnable
        {

            private r._cls1 a;

            public final void run()
            {
                if (r.a(a.a) != null)
                {
                    r.a(a.a).onRecordingBegin(a.a);
                }
            }

                    
                    {
                        a = r._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/nuance/nmdp/speechkit/r$1$3

/* anonymous class */
        final class r._cls1._cls3
            implements Runnable
        {

            private r._cls1 a;

            public final void run()
            {
                if (r.a(a.a) != null)
                {
                    r.a(a.a).onRecordingDone(a.a);
                }
            }

                    
                    {
                        a = r._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/nuance/nmdp/speechkit/r$1$4

/* anonymous class */
        final class r._cls1._cls4
            implements Runnable
        {

            private Recognition a;
            private r._cls1 b;

            public final void run()
            {
                if (r.a(b.a) != null)
                {
                    r.a(b.a).onResults(b.a, a);
                }
            }

                    
                    {
                        b = r._cls1.this;
                        a = recognition;
                        super();
                    }
        }

    }

}
