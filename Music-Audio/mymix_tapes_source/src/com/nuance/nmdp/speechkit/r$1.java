// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ac;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            q, r, Recognition, SpeechError

final class nit> extends q
{

    final r a;

    protected final void a(SpeechError speecherror)
    {
        r.a(a, new Runnable(speecherror) {

            private SpeechError a;
            private r._cls1 b;

            public final void run()
            {
                if (r.a(b.a) != null)
                {
                    r.a(b.a).onError(b.a, a);
                }
            }

            
            {
                b = r._cls1.this;
                a = speecherror;
                super();
            }
        });
    }

    protected final void a(Object obj)
    {
        obj = (Recognition)obj;
        r.d(a, new Runnable(((Recognition) (obj))) {

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
        });
    }

    protected final void b()
    {
        r.b(a, new Runnable() {

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
        });
    }

    protected final void c()
    {
        r.c(a, new Runnable() {

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
        });
    }

    _cls4.a(r r1, m m, String s, boolean flag, boolean flag1, String s1, ac ac)
    {
        a = r1;
        super(m, s, flag, flag1, s1, ac);
    }
}
