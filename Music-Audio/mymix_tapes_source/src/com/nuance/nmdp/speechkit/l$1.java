// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            k, l, GenericResult, SpeechError

final class nit> extends k
{

    final l a;

    protected final void a(SpeechError speecherror)
    {
        l.a(a, speecherror);
    }

    protected final void a(Object obj)
    {
        obj = (GenericResult)obj;
        l.a(a, new Runnable(((GenericResult) (obj))) {

            private GenericResult a;
            private l._cls1 b;

            public final void run()
            {
                if (l.a(b.a) != null)
                {
                    l.a(b.a).onComplete(b.a, a, l.b(b.a));
                }
            }

            
            {
                b = l._cls1.this;
                a = genericresult;
                super();
            }
        });
    }

    _cls1.a(l l1, m m, String s, String s1, List list)
    {
        a = l1;
        super(m, s, s1, list);
    }
}
