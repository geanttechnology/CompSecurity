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

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        a.a.run();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/brushlib/view/DrawingView$5

/* anonymous class */
    final class DrawingView._cls5
        implements Runnable
    {

        final Runnable a;
        private ScheduledExecutorService b;
        private DrawingView c;

        public final void run()
        {
            if (!c.c.f.b())
            {
                DrawingView.j(c).post(new DrawingView._cls5._cls1(this));
                b.shutdown();
                return;
            } else
            {
                b.schedule(this, 500L, TimeUnit.MILLISECONDS);
                return;
            }
        }

            
            {
                c = drawingview;
                a = runnable;
                b = scheduledexecutorservice;
                super();
            }
    }

}
