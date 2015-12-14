// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            ab, Vocalizer, SpeechError

final class b
    implements Runnable
{

    private String a;
    private Object b;
    private b c;

    public final void run()
    {
        ab.c(c.c).onSpeakingBegin(c.c, a, b);
    }

    c(c c1, String s, Object obj)
    {
        c = c1;
        a = s;
        b = obj;
        super();
    }

    // Unreferenced inner class com/nuance/nmdp/speechkit/ab$2

/* anonymous class */
    final class ab._cls2
        implements Vocalizer.Listener
    {

        final ab a;

        public final void onSpeakingBegin(Vocalizer vocalizer, String s, Object obj)
        {
            ab.a(a, new ab._cls2._cls1(this, s, obj));
        }

        public final void onSpeakingDone(Vocalizer vocalizer, String s, SpeechError speecherror, Object obj)
        {
            ab.b(a, new ab._cls2._cls2(s, speecherror, obj));
        }

            
            {
                a = ab1;
                super();
            }

        // Unreferenced inner class com/nuance/nmdp/speechkit/ab$2$2

/* anonymous class */
        final class ab._cls2._cls2
            implements Runnable
        {

            private String a;
            private SpeechError b;
            private Object c;
            private ab._cls2 d;

            public final void run()
            {
                ab.c(d.a).onSpeakingDone(d.a, a, b, c);
            }

                    
                    {
                        d = ab._cls2.this;
                        a = s;
                        b = speecherror;
                        c = obj;
                        super();
                    }
        }

    }

}
