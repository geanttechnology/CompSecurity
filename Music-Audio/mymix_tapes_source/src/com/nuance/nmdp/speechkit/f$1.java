// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            e, f, DataUploadResult, SpeechError

final class nit> extends e
{

    final f a;

    protected final void a(SpeechError speecherror)
    {
        f.a(a, new Runnable(speecherror) {

            private SpeechError a;
            private f._cls1 b;

            public final void run()
            {
                if (f.a(b.a) != null)
                {
                    f.a(b.a).onError(b.a, a);
                }
            }

            
            {
                b = f._cls1.this;
                a = speecherror;
                super();
            }
        });
    }

    protected final void a(Object obj)
    {
        obj = (DataUploadResult)obj;
        f.b(a, new Runnable(((DataUploadResult) (obj))) {

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
        });
    }

    _cls2.a(f f1, m m, String s, List list)
    {
        a = f1;
        super(m, s, list);
    }
}
