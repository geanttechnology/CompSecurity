// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.os.Handler;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.util.aj;

// Referenced classes of package com.picsart.upload:
//            a, b

final class 
    implements aj
{

    final b a;
    final a b;

    public final void a()
    {
        b.c.post(new Runnable() {

            private a._cls7 a;

            public final void run()
            {
                a.a.a("twitter");
                try
                {
                    if (com.picsart.upload.a.d(a.b) != null)
                    {
                        AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("twitter", "url")).setPicsArtPlus(true));
                    }
                    return;
                }
                catch (Exception exception)
                {
                    d.b("itemuploader", new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                    });
                }
            }

            
            {
                a = a._cls7.this;
                super();
            }
        });
    }

    public final void b()
    {
        b.c.post(new Runnable() {

            private a._cls7 a;

            public final void run()
            {
                a.a.a("twitter", "");
                try
                {
                    if (com.picsart.upload.a.d(a.b) != null)
                    {
                        AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageFaileEvent("twitter", "url")).setPicsArtPlus(true));
                    }
                    return;
                }
                catch (Exception exception)
                {
                    d.b("itemuploader", new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                    });
                }
            }

            
            {
                a = a._cls7.this;
                super();
            }
        });
    }

    (a a1, b b1)
    {
        b = a1;
        a = b1;
        super();
    }
}
