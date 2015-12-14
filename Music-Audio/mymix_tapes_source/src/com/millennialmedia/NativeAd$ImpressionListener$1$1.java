// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia:
//            NativeAd

class this._cls1
    implements Runnable
{

    final abilityWatcher this$1;

    public void run()
    {
label0:
        {
            synchronized (_fld0)
            {
                essionTimerRunnable = null;
                if (abilityWatcher.wable && !essionFound)
                {
                    break label0;
                }
            }
            return;
        }
        essionFound = true;
        _lcls1;
        JVM INSTR monitorexit ;
        AdPlacementReporter.setDisplayed(NativeAd.access$000(nativeAd).acementReporter());
        abilityWatcher.pWatching();
        abilityWatcher = null;
        return;
        exception;
        _lcls1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    l.nativeAd()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/NativeAd$ImpressionListener$1

/* anonymous class */
    class NativeAd.ImpressionListener._cls1
        implements com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener
    {

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
            impressionTimerRunnable = ThreadUtils.runOnWorkerThreadDelayed(new NativeAd.ImpressionListener._cls1._cls1(), 1000L);
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
                this$0 = final_impressionlistener;
                nativeAd = NativeAd.this;
                super();
            }
    }

}
