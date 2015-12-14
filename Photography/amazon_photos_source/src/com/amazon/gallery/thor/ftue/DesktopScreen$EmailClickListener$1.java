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

class val.email
    implements com.amazon.gallery.framework.network.l
{

    final is._cls0 this$1;
    final CharSequence val$email;

    public void onFailure(TerminalException terminalexception)
    {
        DesktopScreen.access$2700(_fld0).post(DesktopScreen.access$2600(_fld0));
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((Void)obj);
    }

    public void onSuccess(Void void1)
    {
        if (DesktopScreen.access$700(_fld0) != null)
        {
            ((AmazonInsightsHelper)DesktopScreen.access$2100(_fld0).getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER)).recordEvent(t);
            DesktopScreen.access$2500(_fld0).post(new Runnable() {

                final DesktopScreen.EmailClickListener._cls1 this$2;

                public void run()
                {
                    DesktopScreen.access$1900(this$0);
                    DesktopScreen.access$800(this$0).setText("");
                    DesktopScreen.access$2300(this$0).setNotification(DesktopScreen.access$2200(this$0).getString(0x7f0e00b0, new Object[] {
                        email
                    }));
                    DesktopScreen.access$2400(this$0).proceedToNext(this$0, true);
                }

            
            {
                this$2 = DesktopScreen.EmailClickListener._cls1.this;
                super();
            }
            });
        }
    }

    _cls1.this._cls2()
    {
        this$1 = final__pcls2;
        val$email = CharSequence.this;
        super();
    }
}
