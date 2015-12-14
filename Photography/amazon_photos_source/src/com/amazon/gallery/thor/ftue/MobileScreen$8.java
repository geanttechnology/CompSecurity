// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            MobileScreen

class this._cls0
    implements Runnable
{

    final MobileScreen this$0;

    public void run()
    {
        MobileScreen.access$1600(MobileScreen.this);
        InputMethodManager inputmethodmanager = (InputMethodManager)MobileScreen.access$1700(MobileScreen.this).getSystemService("input_method");
        if (inputmethodmanager != null && MobileScreen.access$1800(MobileScreen.this) != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(MobileScreen.access$1800(MobileScreen.this).getWindowToken(), 0);
        }
        if (!MobileScreen.access$1100(MobileScreen.this))
        {
            MobileScreen.access$2000(MobileScreen.this).setNotification(MobileScreen.access$1900(MobileScreen.this));
        } else
        {
            ((AmazonInsightsHelper)MobileScreen.access$2100(MobileScreen.this).getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER)).recordEventWithPrecondition(tricsEvent.SmsSent, etricsEvent.LearnMoreOpened);
            CharSequence charsequence = MobileScreen.access$200(MobileScreen.this).getText();
            Object obj = charsequence;
            if (charsequence == null)
            {
                obj = "";
            }
            MobileScreen.access$2300(MobileScreen.this).setNotification(String.format(MobileScreen.access$2200(MobileScreen.this), new Object[] {
                obj
            }));
        }
        MobileScreen.access$2400(MobileScreen.this).proceedToNext(MobileScreen.this, true);
        MobileScreen.access$200(MobileScreen.this).setText("");
    }

    etricsEvent()
    {
        this$0 = MobileScreen.this;
        super();
    }
}
