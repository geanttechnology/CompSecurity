// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItPhotoCaptureView, ViewItActivity, ViewItMetricHelper, ViewItSlidingDrawerView, 
//            CameraBgHelper, ViewItScannedItemAnimationFrame

class this._cls0
    implements werOpenListener
{

    final ViewItPhotoCaptureView this$0;

    public void onDrawerOpened()
    {
        com.amazon.mShop.platform.nce().invokeLater(new Runnable() {

            final ViewItPhotoCaptureView._cls3 this$1;

            public void run()
            {
                ViewItPhotoCaptureView.access$100(this$0).getViewItMetricHelper().logCountMetricsPerSession("history-maximized", 1);
                RefMarkerObserver.logRefMarker("fl_tray_open");
                ViewItPhotoCaptureView.access$300(this$0).updateHandleBackground(0.0F);
                ViewItPhotoCaptureView.access$300(this$0).updateBottomToolBar();
                ViewItPhotoCaptureView.access$100(this$0).getCameraBgHelper().setCameraFlashMode("off");
                updateFlashModeButtonVisibility();
                updateTitle(com.amazon.mShop.android.lib.R.string.view_it_history_text);
                if (ViewItPhotoCaptureView.access$400(this$0).getVisibility() == 0)
                {
                    ViewItPhotoCaptureView.access$400(this$0).updateSlidingDrawerAndDismissAnimationWindow(false);
                }
                if (!ViewItPhotoCaptureView.access$100(this$0).isEnginePaused())
                {
                    ViewItPhotoCaptureView.access$100(this$0).pauseEngine();
                }
            }

            
            {
                this$1 = ViewItPhotoCaptureView._cls3.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = ViewItPhotoCaptureView.this;
        super();
    }
}
