// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.animation.ObjectAnimator;
import android.os.SystemClock;
import android.widget.ProgressBar;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ColdBootProgressEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ColdBootUIHandler

class val.progress
    implements Runnable
{

    final ColdBootUIHandler this$0;
    final int val$progress;

    public void run()
    {
        if (val$progress < ColdBootUIHandler.access$200(ColdBootUIHandler.this).getProgress())
        {
            return;
        }
        if (ColdBootUIHandler.access$800(ColdBootUIHandler.this) != null)
        {
            ColdBootUIHandler.access$800(ColdBootUIHandler.this).cancel();
        }
        if (ColdBootUIHandler.access$900(ColdBootUIHandler.this) == 0L)
        {
            ColdBootUIHandler.access$200(ColdBootUIHandler.this).setProgress(val$progress);
            return;
        }
        long l = (long)((float)ColdBootUIHandler.access$1000(ColdBootUIHandler.this) * ((float)ColdBootUIHandler.access$200(ColdBootUIHandler.this).getProgress() / (float)ColdBootUIHandler.access$1100(ColdBootUIHandler.this)));
        long l2 = SystemClock.uptimeMillis();
        long l1 = (l2 - ColdBootUIHandler.access$1200(ColdBootUIHandler.this)) + (ColdBootUIHandler.access$1000(ColdBootUIHandler.this) - l);
        int i = val$progress;
        int j = val$progress - ColdBootUIHandler.access$1100(ColdBootUIHandler.this);
        l = l1;
        if (l1 > 0L)
        {
            l = l1;
            if ((float)l1 / (float)j > (float)ColdBootUIHandler.access$1300(ColdBootUIHandler.this))
            {
                l = (long)j * ColdBootUIHandler.access$1300(ColdBootUIHandler.this);
            }
        }
        l1 = l;
        if (l < 0L)
        {
            l1 = 0L;
        }
        GLogger.v(ColdBootUIHandler.access$1400(), "Interpolating to %d with a duration of %d", new Object[] {
            Integer.valueOf(i), Long.valueOf(l1)
        });
        GlobalMessagingBus.post(new ColdBootProgressEvent(i, l1));
        ColdBootUIHandler.access$802(ColdBootUIHandler.this, ObjectAnimator.ofInt(ColdBootUIHandler.access$200(ColdBootUIHandler.this), "progress", new int[] {
            i
        }));
        ColdBootUIHandler.access$800(ColdBootUIHandler.this).setDuration(l1);
        ColdBootUIHandler.access$800(ColdBootUIHandler.this).setInterpolator(ColdBootUIHandler.access$1500(ColdBootUIHandler.this));
        ColdBootUIHandler.access$800(ColdBootUIHandler.this).start();
        ColdBootUIHandler.access$1102(ColdBootUIHandler.this, i);
        ColdBootUIHandler.access$1002(ColdBootUIHandler.this, l1);
        ColdBootUIHandler.access$1202(ColdBootUIHandler.this, l2);
    }

    obalMessagingBus()
    {
        this$0 = final_coldbootuihandler;
        val$progress = I.this;
        super();
    }
}
