// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            t, u, GenericResult, SpeechError

final class nit> extends t
{

    final u a;

    protected final void a(SpeechError speecherror)
    {
        u.a(a, speecherror);
    }

    protected final void a(Object obj)
    {
        obj = (GenericResult)obj;
        u.a(a, new Runnable(((GenericResult) (obj))) {

            private GenericResult a;
            private u._cls1 b;

            public final void run()
            {
                if (u.a(b.a) != null)
                {
                    u.a(b.a).onComplete(b.a, a, u.b(b.a));
                }
            }

            
            {
                b = u._cls1.this;
                a = genericresult;
                super();
            }
        });
    }

    _cls1.a(u u1, m m, String s)
    {
        a = u1;
        super(m, s);
    }
}
