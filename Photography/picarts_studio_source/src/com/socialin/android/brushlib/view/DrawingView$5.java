// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.os.Handler;
import com.socialin.android.brushlib.state.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

final class b
    implements Runnable
{

    final Runnable a;
    private ScheduledExecutorService b;
    private DrawingView c;

    public final void run()
    {
        if (!c.c.f.b())
        {
            DrawingView.j(c).post(new Runnable() {

                private DrawingView._cls5 a;

                public final void run()
                {
                    a.a.run();
                }

            
            {
                a = DrawingView._cls5.this;
                super();
            }
            });
            b.shutdown();
            return;
        } else
        {
            b.schedule(this, 500L, TimeUnit.MILLISECONDS);
            return;
        }
    }

    _cls1.a(DrawingView drawingview, Runnable runnable, ScheduledExecutorService scheduledexecutorservice)
    {
        c = drawingview;
        a = runnable;
        b = scheduledexecutorservice;
        super();
    }
}
