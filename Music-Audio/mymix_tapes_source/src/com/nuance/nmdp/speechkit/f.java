// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            b, DataUploadCommand, x, a, 
//            e, DataUploadResult, SpeechError

final class f extends b
    implements DataUploadCommand
{

    private DataUploadCommand.Listener b;
    private boolean c;

    public f(x x1, DataUploadCommand.Listener listener, Object obj)
    {
        super(x1, x1.k(), obj);
        synchronized (a)
        {
            b = listener;
        }
        c = false;
        a();
    }

    static DataUploadCommand.Listener a(f f1)
    {
        return f1.b;
    }

    static void a(f f1, Runnable runnable)
    {
        f1.a(runnable);
    }

    static void b(f f1, Runnable runnable)
    {
        f1.a(runnable);
    }

    protected final a a(m m, String s, List list)
    {
        return new e(m, s, list) {

            final f a;

            protected final void a(SpeechError speecherror)
            {
                f.a(a, new Runnable(this, speecherror) {

                    private SpeechError a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (f.a(b.a) != null)
                        {
                            f.a(b.a).onError(b.a, a);
                        }
                    }

            
            {
                b = _pcls1;
                a = speecherror;
                super();
            }
                });
            }

            protected final void a(Object obj)
            {
                obj = (DataUploadResult)obj;
                f.b(a, new Runnable(this, ((DataUploadResult) (obj))) {

                    private DataUploadResult a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (f.a(b.a) != null)
                        {
                            f.a(b.a).onResults(b.a, a);
                        }
                    }

            
            {
                b = _pcls1;
                a = datauploadresult;
                super();
            }
                });
            }

            
            {
                a = f.this;
                super(m, s, list);
            }
        };
    }

    final void b()
    {
        c = true;
    }

    public final void setListener(DataUploadCommand.Listener listener)
    {
        x.a(listener, "listener");
        synchronized (a)
        {
            b = listener;
        }
    }

    public final void start()
    {
        if (c)
        {
            super.start();
        }
    }
}
