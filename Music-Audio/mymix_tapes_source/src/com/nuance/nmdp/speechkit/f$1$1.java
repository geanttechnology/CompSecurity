// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            f, SpeechError, e, DataUploadResult

final class a
    implements Runnable
{

    private SpeechError a;
    private Error b;

    public final void run()
    {
        if (f.a(b.b) != null)
        {
            f.a(b.b).onError(b.b, a);
        }
    }

    Error(Error error, SpeechError speecherror)
    {
        b = error;
        a = speecherror;
        super();
    }

    // Unreferenced inner class com/nuance/nmdp/speechkit/f$1

/* anonymous class */
    final class f._cls1 extends e
    {

        final f a;

        protected final void a(SpeechError speecherror)
        {
            f.a(a, new f._cls1._cls1(this, speecherror));
        }

        protected final void a(Object obj)
        {
            obj = (DataUploadResult)obj;
            f.b(a, new f._cls1._cls2(((DataUploadResult) (obj))));
        }

            
            {
                a = f1;
                super(m, s, list);
            }

        // Unreferenced inner class com/nuance/nmdp/speechkit/f$1$2

/* anonymous class */
        final class f._cls1._cls2
            implements Runnable
        {

            private DataUploadResult a;
            private f._cls1 b;

            public final void run()
            {
                if (f.a(b.a) != null)
                {
                    f.a(b.a).onResults(b.a, a);
                }
            }

                    
                    {
                        b = f._cls1.this;
                        a = datauploadresult;
                        super();
                    }
        }

    }

}
