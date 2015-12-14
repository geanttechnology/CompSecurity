// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia:
//            InlineAd

class val.inlineAd
    implements com.millennialmedia.internal.utils.
{

    final pressionTimerRunnable this$0;
    final InlineAd val$inlineAd;

    public void onViewableChanged(boolean flag)
    {
        bilityListener bilitylistener = this._cls0.this;
        bilitylistener;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (pressionTimerRunnable != null || pressionFound) goto _L2; else goto _L3
_L3:
        pressionTimerRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

            final InlineAd.ImpressionListener._cls1 this$1;

            public void run()
            {
label0:
                {
                    synchronized (this$0)
                    {
                        impressionTimerRunnable = null;
                        if (viewabilityWatcher.viewable && !impressionFound)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                impressionFound = true;
                impressionlistener;
                JVM INSTR monitorexit ;
                AdPlacementReporter.setDisplayed(InlineAd.access$300(inlineAd).getAdPlacementReporter());
                viewabilityWatcher.stopWatching();
                return;
                exception1;
                impressionlistener;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                this$1 = InlineAd.ImpressionListener._cls1.this;
                super();
            }
        }, 1000L);
_L5:
        bilitylistener;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (flag) goto _L5; else goto _L4
_L4:
        if (pressionTimerRunnable == null) goto _L5; else goto _L6
_L6:
        pressionTimerRunnable.cancel();
        pressionTimerRunnable = null;
          goto _L5
        Exception exception;
        exception;
        bilitylistener;
        JVM INSTR monitorexit ;
        throw exception;
    }

    _cls1.this._cls1()
    {
        this$0 = final__pcls1;
        val$inlineAd = InlineAd.this;
        super();
    }
}
