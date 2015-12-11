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

class this._cls0
    implements android.view.obalLayoutListener
{

    final BusinessDetailPage this$0;

    public void onGlobalLayout()
    {
        Handler handler = new Handler(getApplicationContext().getMainLooper());
        handler.postDelayed(new Runnable() {

            final BusinessDetailPage._cls4 this$1;

            public void run()
            {
                scrollView.smoothScrollTo(0, (int)ratingsContainer.getY());
            }

            
            {
                this$1 = BusinessDetailPage._cls4.this;
                super();
            }
        }, 500L);
        handler.postDelayed(new Runnable() {

            final BusinessDetailPage._cls4 this$1;

            public void run()
            {
                progressBar.setVisibility(8);
                businessContent.setVisibility(0);
            }

            
            {
                this$1 = BusinessDetailPage._cls4.this;
                super();
            }
        }, 1000L);
        ratingsContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    _cls2.this._cls1()
    {
        this$0 = BusinessDetailPage.this;
        super();
    }
}
