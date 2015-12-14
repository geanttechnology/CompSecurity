// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            b, GenericCommand, x, SpeechError, 
//            a, k, GenericResult

final class l extends b
    implements GenericCommand
{

    private GenericCommand.Listener b;
    private String c;
    private SpeechError d;

    l(x x1, String s, GenericCommand.Listener listener, Object obj)
    {
        super(x1, x1.l(), obj);
        d = null;
        c = s;
        synchronized (a)
        {
            b = listener;
        }
        a();
    }

    static GenericCommand.Listener a(l l1)
    {
        return l1.b;
    }

    static SpeechError a(l l1, SpeechError speecherror)
    {
        l1.d = speecherror;
        return speecherror;
    }

    static void a(l l1, Runnable runnable)
    {
        l1.a(runnable);
    }

    static SpeechError b(l l1)
    {
        return l1.d;
    }

    protected final a a(m m, String s, List list)
    {
        return new k(m, s, c, list) {

            final l a;

            protected final void a(SpeechError speecherror)
            {
                l.a(a, speecherror);
            }

            protected final void a(Object obj)
            {
                obj = (GenericResult)obj;
                l.a(a, new Runnable(this, ((GenericResult) (obj))) {

                    private GenericResult a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (l.a(b.a) != null)
                        {
                            l.a(b.a).onComplete(b.a, a, l.b(b.a));
                        }
                    }

            
            {
                b = _pcls1;
                a = genericresult;
                super();
            }
                });
            }

            
            {
                a = l.this;
                super(m, s, s1, list);
            }
        };
    }
}
