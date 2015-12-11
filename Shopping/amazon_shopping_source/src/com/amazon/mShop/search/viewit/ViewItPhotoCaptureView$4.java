// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Resources;
import android.widget.ListView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItPhotoCaptureView, ViewItActivity, ViewItMetricHelper, ViewItSlidingDrawerView, 
//            ViewItSlidingDrawerBrowser

class this._cls0
    implements werCloseListener
{

    final ViewItPhotoCaptureView this$0;

    public void onDrawerClosed()
    {
        com.amazon.mShop.platform.nce().invokeLater(new Runnable() {

            final ViewItPhotoCaptureView._cls4 this$1;

            public void run()
            {
                ViewItPhotoCaptureView.access$100(this$0).getViewItMetricHelper().logCountMetricsPerSession("history-minimized", 1);
                RefMarkerObserver.logRefMarker("fl_tray_close");
                ViewItPhotoCaptureView.access$300(this$0).updateHandleBackground(1.0F);
                ViewItPhotoCaptureView.access$300(this$0).updateBottomToolBar();
                updateFlashModeButtonVisibility();
                updateTitle(com.amazon.mShop.android.lib.R.string.view_it_searching);
                ViewItSlidingDrawerBrowser viewitslidingdrawerbrowser = ViewItPhotoCaptureView.access$300(this$0).getBrowser();
                viewitslidingdrawerbrowser.deleteUndoObject();
                if (viewitslidingdrawerbrowser.getObjectsCount() == 0 && !ViewItPhotoCaptureView.access$300(this$0).isProgressBarDisplayed())
                {
                    ViewItPhotoCaptureView.access$300(this$0).setListViewHeaderVisibility(0);
                    ViewItPhotoCaptureView.access$300(this$0).updateBottomOffset(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_vertical_bottom_empty_offset));
                } else
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                        final _cls1 this$2;

                        public void run()
                        {
                            ViewItPhotoCaptureView.access$300(this$0).getListView().setSelection(1);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                }
                if (!ViewItPhotoCaptureView.access$100(this$0).isEngineStopped()) goto _L2; else goto _L1
_L1:
                ViewItPhotoCaptureView.access$100(this$0).startScanning();
_L4:
                ViewItPhotoCaptureView.access$100(this$0).enableLoading();
                ViewItPhotoCaptureView.access$100(this$0).enableDrawing();
                return;
_L2:
                if (ViewItPhotoCaptureView.access$100(this$0).isEnginePaused())
                {
                    ViewItPhotoCaptureView.access$100(this$0).unpauseEngine();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$1 = ViewItPhotoCaptureView._cls4.this;
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
