// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.groupon.view.ObservableScrollView;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

class this._cls1
    implements Runnable
{

    final nessContent this$1;

    public void run()
    {
        progressBar.setVisibility(8);
        businessContent.setVisibility(0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/BusinessDetailPage$4

/* anonymous class */
    class BusinessDetailPage._cls4
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final BusinessDetailPage this$0;

        public void onGlobalLayout()
        {
            Handler handler = new Handler(getApplicationContext().getMainLooper());
            handler.postDelayed(new BusinessDetailPage._cls4._cls1(), 500L);
            handler.postDelayed(new BusinessDetailPage._cls4._cls2(), 1000L);
            ratingsContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

            
            {
                this$0 = BusinessDetailPage.this;
                super();
            }

        // Unreferenced inner class com/groupon/activity/BusinessDetailPage$4$1

/* anonymous class */
        class BusinessDetailPage._cls4._cls1
            implements Runnable
        {

            final BusinessDetailPage._cls4 this$1;

            public void run()
            {
                scrollView.smoothScrollTo(0, (int)ratingsContainer.getY());
            }

                    
                    {
                        this$1 = BusinessDetailPage._cls4.this;
                        super();
                    }
        }

    }

}
