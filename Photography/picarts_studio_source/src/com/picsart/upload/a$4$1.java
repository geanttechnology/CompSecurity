// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.os.Handler;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.util.aj;

// Referenced classes of package com.picsart.upload:
//            b, a

final class a
    implements Runnable
{

    private oString a;

    public final void run()
    {
        a.a.a("facebook");
        try
        {
            if (com.picsart.upload.a.d(a.a) != null)
            {
                AnalyticUtils.getInstance(com.picsart.upload.a.d(a.a)).track((new com.socialin.android.apiv3.events.Factory.ExportImageEvent("facebook", "bin")).setPicsArtPlus(true));
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

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/picsart/upload/a$4

/* anonymous class */
    final class a._cls4
        implements aj
    {

        final b a;
        final a b;

        public final void a()
        {
            b.c.post(new a._cls4._cls1(this));
        }

        public final void b()
        {
            b.c.post(new a._cls4._cls2());
        }

            
            {
                b = a1;
                a = b1;
                super();
            }

        // Unreferenced inner class com/picsart/upload/a$4$2

/* anonymous class */
        final class a._cls4._cls2
            implements Runnable
        {

            private a._cls4 a;

            public final void run()
            {
                a.a.a("facebook", "");
                try
                {
                    if (com.picsart.upload.a.d(a.b) != null)
                    {
                        AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageFaileEvent("facebook", "bin")).setPicsArtPlus(true));
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
                        a = a._cls4.this;
                        super();
                    }
        }

    }

}
