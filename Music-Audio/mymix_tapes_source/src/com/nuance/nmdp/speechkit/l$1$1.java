// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            l, GenericResult, k, SpeechError

final class a
    implements Runnable
{

    private GenericResult a;
    private cResult b;

    public final void run()
    {
        if (l.a(b.b) != null)
        {
            l.a(b.b).onComplete(b.b, a, l.b(b.b));
        }
    }

    cResult(cResult cresult, GenericResult genericresult)
    {
        b = cresult;
        a = genericresult;
        super();
    }

    // Unreferenced inner class com/nuance/nmdp/speechkit/l$1

/* anonymous class */
    final class l._cls1 extends k
    {

        final l a;

        protected final void a(SpeechError speecherror)
        {
            l.a(a, speecherror);
        }

        protected final void a(Object obj)
        {
            obj = (GenericResult)obj;
            l.a(a, new l._cls1._cls1(this, ((GenericResult) (obj))));
        }

            
            {
                a = l1;
                super(m, s, s1, list);
            }
    }

}
