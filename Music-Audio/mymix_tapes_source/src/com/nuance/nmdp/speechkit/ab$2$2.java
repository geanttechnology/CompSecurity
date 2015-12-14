// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            ab, SpeechError, Vocalizer

final class c
    implements Runnable
{

    private String a;
    private SpeechError b;
    private Object c;
    private rror d;

    public final void run()
    {
        ab.c(d.d).onSpeakingDone(d.d, a, b, c);
    }

    rror(rror rror, String s, SpeechError speecherror, Object obj)
    {
        d = rror;
        a = s;
        b = speecherror;
        c = obj;
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
            ab.a(a, new ab._cls2._cls1(s, obj));
        }

        public final void onSpeakingDone(Vocalizer vocalizer, String s, SpeechError speecherror, Object obj)
        {
            ab.b(a, new ab._cls2._cls2(this, s, speecherror, obj));
        }

            
            {
                a = ab1;
                super();
            }

        // Unreferenced inner class com/nuance/nmdp/speechkit/ab$2$1

/* anonymous class */
        final class ab._cls2._cls1
            implements Runnable
        {

            private String a;
            private Object b;
            private ab._cls2 c;

            public final void run()
            {
                ab.c(c.a).onSpeakingBegin(c.a, a, b);
            }

                    
                    {
                        c = ab._cls2.this;
                        a = s;
                        b = obj;
                        super();
                    }
        }

    }

}
