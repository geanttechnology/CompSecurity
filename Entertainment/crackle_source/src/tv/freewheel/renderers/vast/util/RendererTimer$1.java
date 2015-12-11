// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package tv.freewheel.renderers.vast.util:
//            RendererTimer

class this._cls0 extends TimerTask
{

    final RendererTimer this$0;

    public void run()
    {
        Log.d(RendererTimer.access$000(), (new StringBuilder()).append("tick duration=").append(RendererTimer.access$100(RendererTimer.this)).append(", counter=").append(RendererTimer.access$200(RendererTimer.this)).toString());
        if (RendererTimer.access$300(RendererTimer.this).get() != 0)
        {
            return;
        }
        if (RendererTimer.access$200(RendererTimer.this) > 0)
        {
            int _tmp = RendererTimer.access$210(RendererTimer.this);
        } else
        {
            RendererTimer.access$400(RendererTimer.this).purge();
            RendererTimer.access$400(RendererTimer.this).cancel();
            RendererTimer.access$402(RendererTimer.this, null);
            RendererTimer.access$500(RendererTimer.this).timeOut();
        }
        RendererTimer.access$500(RendererTimer.this).playHeadTime(RendererTimer.access$100(RendererTimer.this) - RendererTimer.access$200(RendererTimer.this));
    }

    endererTimerService()
    {
        this$0 = RendererTimer.this;
        super();
    }
}
