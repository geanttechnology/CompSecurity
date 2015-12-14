// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.view.View;
import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia:
//            NativeAd, MMLog

static class ble
{

    volatile boolean impressionFound;
    volatile com.millennialmedia.internal.utils.e impressionTimerRunnable;
    com.millennialmedia.internal.utils. viewabilityWatcher;

    public void cancel()
    {
        if (impressionTimerRunnable != null)
        {
            MMLog.d(NativeAd.access$100(), "Cancelling previous impression timer runnable");
            impressionTimerRunnable.cancel();
            impressionTimerRunnable = null;
        }
        if (viewabilityWatcher != null)
        {
            MMLog.d(NativeAd.access$100(), "Stopping previous impression viewability watcher");
            viewabilityWatcher.stopWatching();
            viewabilityWatcher = null;
        }
    }

    protected void listen()
    {
        if (viewabilityWatcher == null)
        {
            return;
        } else
        {
            viewabilityWatcher.setMinViewabilityPercent(50);
            viewabilityWatcher.startWatching();
            return;
        }
    }

    wabilityListener(final NativeAd nativeAd, View view)
    {
        impressionFound = false;
        viewabilityWatcher = new com.millennialmedia.internal.utils.(view, new com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener() {

            final NativeAd.ImpressionListener this$0;
            final NativeAd val$nativeAd;

            public void onViewableChanged(boolean flag)
            {
                NativeAd.ImpressionListener impressionlistener = NativeAd.ImpressionListener.this;
                impressionlistener;
                JVM INSTR monitorenter ;
                if (!flag) goto _L2; else goto _L1
_L1:
                if (impressionTimerRunnable != null || impressionFound) goto _L2; else goto _L3
_L3:
                impressionTimerRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
label0:
                        {
                            synchronized (_fld0)
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
                        AdPlacementReporter.setDisplayed(NativeAd.access$000(nativeAd).getAdPlacementReporter());
                        viewabilityWatcher.stopWatching();
                        viewabilityWatcher = null;
                        return;
                        exception;
                        impressionlistener;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }, 1000L);
_L5:
                impressionlistener;
                JVM INSTR monitorexit ;
                return;
_L2:
                if (flag) goto _L5; else goto _L4
_L4:
                if (impressionTimerRunnable == null) goto _L5; else goto _L6
_L6:
                impressionTimerRunnable.cancel();
                impressionTimerRunnable = null;
                  goto _L5
                Exception exception;
                exception;
                impressionlistener;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = NativeAd.ImpressionListener.this;
                nativeAd = nativead;
                super();
            }
        });
    }
}
