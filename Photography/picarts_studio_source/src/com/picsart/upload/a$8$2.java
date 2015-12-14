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
        a.a.a("dropbox", "");
        try
        {
            if (com.picsart.upload.a.d(a.a) != null)
            {
                AnalyticUtils.getInstance(com.picsart.upload.a.d(a.a)).track((new com.socialin.android.apiv3.events.Factory.ExportImageFaileEvent("dropbox", "bin")).setPicsArtPlus(true));
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

    // Unreferenced inner class com/picsart/upload/a$8

/* anonymous class */
    final class a._cls8
        implements aj
    {

        final b a;
        final a b;

        public final void a()
        {
            b.c.post(new a._cls8._cls1());
        }

        public final void b()
        {
            b.c.post(new a._cls8._cls2(this));
        }

            
            {
                b = a1;
                a = b1;
                super();
            }

        // Unreferenced inner class com/picsart/upload/a$8$1

/* anonymous class */
        final class a._cls8._cls1
            implements Runnable
        {

            private a._cls8 a;

            public final void run()
            {
                a.a.a("dropbox");
                try
                {
                    if (com.picsart.upload.a.d(a.b) != null)
                    {
                        AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("dropbox", "bin")).setPicsArtPlus(true));
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
                        a = a._cls8.this;
                        super();
                    }
        }

    }

}
