// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import ac;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            s, TextRecognizer, x, p, 
//            y, GenericRecognition, SpeechError

final class z extends s
    implements TextRecognizer
{

    private TextRecognizer.Listener b;
    private final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary c;

    public z(x x1, String s1, String s2, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, TextRecognizer.Listener listener, Object obj)
    {
        super(x1, "websearch", -1, s1, s2, obj);
        synchronized (a)
        {
            b = listener;
        }
        c = dictionary;
        a();
    }

    static TextRecognizer.Listener a(z z1)
    {
        return z1.b;
    }

    static void a(z z1, Runnable runnable)
    {
        z1.a(runnable);
    }

    static void b(z z1, Runnable runnable)
    {
        z1.a(runnable);
    }

    protected final p a(m m, String s1, boolean flag, boolean flag1, String s2, String s3, ac ac)
    {
        return new y(m, s2, s3, c, ac) {

            final z a;

            protected final void a(SpeechError speecherror)
            {
                z.a(a, new Runnable(this, speecherror) {

                    private SpeechError a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (z.a(b.a) != null)
                        {
                            z.a(b.a).onError(b.a, a);
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
                obj = (GenericRecognition)obj;
                com.nuance.nmdp.speechkit.z.b(a, new Runnable(this, ((GenericRecognition) (obj))) {

                    private GenericRecognition a;
                    private _cls1 b;

                    public final void run()
                    {
                        if (z.a(b.a) != null)
                        {
                            z.a(b.a).onResults(b.a, a);
                        }
                    }

            
            {
                b = _pcls1;
                a = genericrecognition;
                super();
            }
                });
            }

            protected final void b()
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(a, "onRecordingRegin is called for TextRecognizer for nothing.");
            }

            protected final void c()
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(a, "onRecordingDone is called for TextRecognizer for nothing.");
            }

            
            {
                a = z.this;
                super(m, s1, s2, dictionary, ac);
            }
        };
    }

    public final void setListener(TextRecognizer.Listener listener)
    {
        x.a(listener, "listener");
        synchronized (a)
        {
            b = listener;
        }
    }
}
