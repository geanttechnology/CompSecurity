// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.os.Handler;
import android.widget.EditText;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.network.exceptions.TerminalException;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            DesktopScreen

class this._cls2
    implements Runnable
{

    final ._cls0 this$2;

    public void run()
    {
        DesktopScreen.access$1900(_fld0);
        DesktopScreen.access$800(_fld0).setText("");
        DesktopScreen.access$2300(_fld0).setNotification(DesktopScreen.access$2200(_fld0).getString(0x7f0e00b0, new Object[] {
            email
        }));
        DesktopScreen.access$2400(_fld0).proceedToNext(_fld0, true);
    }

    l.email()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/DesktopScreen$EmailClickListener$1

/* anonymous class */
    class DesktopScreen.EmailClickListener._cls1
        implements com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler
    {

        final DesktopScreen.EmailClickListener this$1;
        final CharSequence val$email;

        public void onFailure(TerminalException terminalexception)
        {
            DesktopScreen.access$2700(this$0).post(DesktopScreen.access$2600(this$0));
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((Void)obj);
        }

        public void onSuccess(Void void1)
        {
            if (DesktopScreen.access$700(this$0) != null)
            {
                ((AmazonInsightsHelper)DesktopScreen.access$2100(this$0).getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER)).recordEvent(DesktopScreen.MetricsEvent.EmailSent);
                DesktopScreen.access$2500(this$0).post(new DesktopScreen.EmailClickListener._cls1._cls1());
            }
        }

            
            {
                this$1 = final_emailclicklistener;
                email = CharSequence.this;
                super();
            }
    }

}
