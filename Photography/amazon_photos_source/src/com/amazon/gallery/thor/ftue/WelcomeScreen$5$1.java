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

class this._cls1
    implements android.view.er
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        if (WelcomeScreen.access$1300(_fld0) != null)
        {
            GLogger.i(WelcomeScreen.access$1100(), "Show learn more page test result: %s", new Object[] {
                WelcomeScreen.access$1300(_fld0)
            });
            WelcomeScreen.access$1400(_fld0).recordEvent(icsEvent.LearnMoreOpened);
            WelcomeScreen.access$1500(_fld0).getProfiler().trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.sEvent.LearnMoreClicked, ClickstreamEventHelper.createClickstreamExtra("FTUE-Event", HitType.PAGE_TOUCH));
            WelcomeScreen.access$1600(_fld0);
        }
    }

    l.buttonText()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/WelcomeScreen$5

/* anonymous class */
    class WelcomeScreen._cls5
        implements Runnable
    {

        final WelcomeScreen this$0;
        final String val$buttonText;
        final View val$ftueWelcomeLayout;

        public void run()
        {
            TextView textview = (TextView)ftueWelcomeLayout.findViewById(0x7f0c016f);
            textview.setText(buttonText);
            textview.setVisibility(0);
            textview.setOnClickListener(new WelcomeScreen._cls5._cls1());
        }

            
            {
                this$0 = final_welcomescreen;
                ftueWelcomeLayout = view;
                buttonText = String.this;
                super();
            }
    }

}
