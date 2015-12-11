// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItPhotoCaptureView, ViewItActivity, ViewItMetricHelper, ViewItSlidingDrawerView, 
//            CameraBgHelper, ViewItScannedItemAnimationFrame

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        ViewItPhotoCaptureView.access$100(_fld0).getViewItMetricHelper().logCountMetricsPerSession("history-maximized", 1);
        RefMarkerObserver.logRefMarker("fl_tray_open");
        ViewItPhotoCaptureView.access$300(_fld0).updateHandleBackground(0.0F);
        ViewItPhotoCaptureView.access$300(_fld0).updateBottomToolBar();
        ViewItPhotoCaptureView.access$100(_fld0).getCameraBgHelper().setCameraFlashMode("off");
        updateFlashModeButtonVisibility();
        updateTitle(com.amazon.mShop.android.lib.xt);
        if (ViewItPhotoCaptureView.access$400(_fld0).getVisibility() == 0)
        {
            ViewItPhotoCaptureView.access$400(_fld0).updateSlidingDrawerAndDismissAnimationWindow(false);
        }
        if (!ViewItPhotoCaptureView.access$100(_fld0).isEnginePaused())
        {
            ViewItPhotoCaptureView.access$100(_fld0).pauseEngine();
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3

/* anonymous class */
    class ViewItPhotoCaptureView._cls3
        implements ViewItSlidingDrawer.OnDrawerOpenListener
    {

        final ViewItPhotoCaptureView this$0;

        public void onDrawerOpened()
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new ViewItPhotoCaptureView._cls3._cls1());
        }

            
            {
                this$0 = ViewItPhotoCaptureView.this;
                super();
            }
    }

}
