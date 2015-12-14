// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            ab, Vocalizer, SpeechError

final class a
    implements izer.Listener
{

    final ab a;

    public final void onSpeakingBegin(Vocalizer vocalizer, String s, Object obj)
    {
        ab.a(a, new Runnable(s, obj) {

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
        });
    }

    public final void onSpeakingDone(Vocalizer vocalizer, String s, SpeechError speecherror, Object obj)
    {
        ab.b(a, new Runnable(s, speecherror, obj) {

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
        });
    }

    _cls2.c(ab ab1)
    {
        a = ab1;
        super();
    }
}
