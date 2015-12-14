// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            u, GenericResult, t, SpeechError

final class a
    implements Runnable
{

    private GenericResult a;
    private cResult b;

    public final void run()
    {
        if (u.a(b.b) != null)
        {
            u.a(b.b).onComplete(b.b, a, u.b(b.b));
        }
    }

    cResult(cResult cresult, GenericResult genericresult)
    {
        b = cresult;
        a = genericresult;
        super();
    }

    // Unreferenced inner class com/nuance/nmdp/speechkit/u$1

/* anonymous class */
    final class u._cls1 extends t
    {

        final u a;

        protected final void a(SpeechError speecherror)
        {
            u.a(a, speecherror);
        }

        protected final void a(Object obj)
        {
            obj = (GenericResult)obj;
            u.a(a, new u._cls1._cls1(this, ((GenericResult) (obj))));
        }

            
            {
                a = u1;
                super(m, s);
            }
    }

}
