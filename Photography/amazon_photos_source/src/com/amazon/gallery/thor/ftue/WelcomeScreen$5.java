// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.view.View;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            WelcomeScreen

class val.buttonText
    implements Runnable
{

    final WelcomeScreen this$0;
    final String val$buttonText;
    final View val$ftueWelcomeLayout;

    public void run()
    {
        TextView textview = (TextView)val$ftueWelcomeLayout.findViewById(0x7f0c016f);
        textview.setText(val$buttonText);
        textview.setVisibility(0);
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final WelcomeScreen._cls5 this$1;

            public void onClick(View view)
            {
                if (WelcomeScreen.access$1300(this$0) != null)
                {
                    GLogger.i(WelcomeScreen.access$1100(), "Show learn more page test result: %s", new Object[] {
                        WelcomeScreen.access$1300(this$0)
                    });
                    WelcomeScreen.access$1400(this$0).recordEvent(WelcomeScreen.MetricsEvent.LearnMoreOpened);
                    WelcomeScreen.access$1500(this$0).getProfiler().trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.LearnMoreClicked, ClickstreamEventHelper.createClickstreamExtra("FTUE-Event", HitType.PAGE_TOUCH));
                    WelcomeScreen.access$1600(this$0);
                }
            }

            
            {
                this$1 = WelcomeScreen._cls5.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_welcomescreen;
        val$ftueWelcomeLayout = view;
        val$buttonText = String.this;
        super();
    }
}
