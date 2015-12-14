// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            b, GenericCommand, x, SpeechError, 
//            a, t, GenericResult

final class u extends b
    implements GenericCommand
{

    private GenericCommand.Listener b;
    private SpeechError c;

    public u(x x1, GenericCommand.Listener listener, Object obj)
    {
        super(x1, x1.m(), obj);
        c = null;
        synchronized (a)
        {
            b = listener;
        }
        a();
    }

    static GenericCommand.Listener a(u u1)
    {
        return u1.b;
    }

    static SpeechError a(u u1, SpeechError speecherror)
    {
        u1.c = speecherror;
        return speecherror;
    }

    static void a(u u1, Runnable runnable)
    {
        u1.a(runnable);
    }

    static SpeechError b(u u1)
    {
        return u1.c;
    }

    protected final a a(m m, String s, List list)
    {
        return new t(m, s) {

            final u a;

            protected final void a(SpeechError speecherror)
            {
                u.a(a, speecherror);
            }

            protected final void a(Object obj)
            {
                obj = (GenericResult)obj;
                u.a(a, new Runnable(this, ((GenericResult) (obj))) {

                    private GenericResult a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (u.a(b.a) != null)
                        {
                            u.a(b.a).onComplete(b.a, a, u.b(b.a));
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
                a = u.this;
                super(m, s);
            }
        };
    }
}
