// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.DialogInterface;
import android.view.View;
import com.amazon.gallery.framework.kindle.ParentalControl;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls1
    implements android.content.lickListener
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        FacebookScreen.access$500(_fld0).proceedToNext(_fld0, true);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$1

/* anonymous class */
    class FacebookScreen._cls1
        implements android.view.View.OnClickListener
    {

        final FacebookScreen this$0;

        public void onClick(View view)
        {
            ((FTUEMetricsHelper)FacebookScreen.access$000(FacebookScreen.this).getProfiler()).logClickEvent(com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper.ClickSource.FACEBOOK_CLICK, FacebookScreen.access$100(FacebookScreen.this));
            if (FacebookScreen.access$300(FacebookScreen.this).isSocialNetworkingBlocked(FacebookScreen.access$200(FacebookScreen.this)))
            {
                FacebookScreen.access$300(FacebookScreen.this).promptSocialNetworkingBlocked(FacebookScreen.access$400(FacebookScreen.this));
                return;
            } else
            {
                (new android.support.v7.app.AlertDialog.Builder(FacebookScreen.access$700(FacebookScreen.this))).setMessage(0x7f0e00da).setPositiveButton(0x7f0e0093, FacebookScreen.access$600(FacebookScreen.this)).setNegativeButton(0x7f0e0092, new FacebookScreen._cls1._cls1()).show();
                return;
            }
        }

            
            {
                this$0 = FacebookScreen.this;
                super();
            }
    }

}
