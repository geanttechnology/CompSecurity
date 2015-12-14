// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.DialogInterface;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.actions.FacebookHelper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.network.exceptions.SndsNoLinkedFacebookAccountException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls2
    implements android.content.ckListener
{

    final ._cls0 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        FacebookScreen.access$1900(_fld0).proceedToNext(_fld0, true);
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$5

/* anonymous class */
    class FacebookScreen._cls5
        implements com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler
    {

        final FacebookScreen this$0;

        public void onFailure(TerminalException terminalexception)
        {
            Throwable throwable;
            GLogger.wx(FacebookScreen.access$2300(), "Failed to import facebook photos?", terminalexception);
            throwable = terminalexception.getCause();
            if (!(terminalexception instanceof SndsNoLinkedFacebookAccountException)) goto _L2; else goto _L1
_L1:
            FacebookScreen.access$2500(FacebookScreen.this).unlinkFacebookFlagFromDevice(FacebookScreen.access$2400(FacebookScreen.this));
_L4:
            FacebookScreen.access$2900(FacebookScreen.this).runOnUiThread(new FacebookScreen._cls5._cls2());
            FacebookScreen.access$3100(FacebookScreen.this).runOnUiThread(FacebookScreen.access$3000(FacebookScreen.this));
            return;
_L2:
            if (throwable != null && (throwable.getCause() instanceof SndsNoLinkedFacebookAccountException))
            {
                FacebookScreen.access$2500(FacebookScreen.this).unlinkFacebookFlagFromDevice(FacebookScreen.access$2600(FacebookScreen.this));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onSuccess(Boolean boolean1)
        {
            ((AmazonInsightsHelper)FacebookScreen.access$1500(FacebookScreen.this).getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER)).recordEvent(FacebookScreen.MetricsEvent.FacebookPhotosImported);
            FacebookScreen.access$2200(FacebookScreen.this).runOnUiThread(boolean1. new FacebookScreen._cls5._cls1());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((Boolean)obj);
        }

            
            {
                this$0 = FacebookScreen.this;
                super();
            }

        // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$5$2

/* anonymous class */
        class FacebookScreen._cls5._cls2
            implements Runnable
        {

            final FacebookScreen._cls5 this$1;

            public void run()
            {
                FacebookScreen.access$2700(this$0).hide();
                (new android.support.v7.app.AlertDialog.Builder(FacebookScreen.access$2800(this$0))).setMessage(0x7f0e00d8).setTitle(0x7f0e0119).setPositiveButton(0x7f0e0093, new FacebookScreen._cls5._cls2._cls1()).show();
            }

                    
                    {
                        this$1 = FacebookScreen._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$5$2$1

/* anonymous class */
        class FacebookScreen._cls5._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FacebookScreen._cls5._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = FacebookScreen._cls5._cls2.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$5$1

/* anonymous class */
    class FacebookScreen._cls5._cls1
        implements Runnable
    {

        final FacebookScreen._cls5 this$1;
        final Boolean val$hasPhotos;

        public void run()
        {
            FacebookScreen.access$1600(this$0).hide();
            if (hasPhotos.booleanValue())
            {
                FacebookScreen.access$1800(this$0).runOnUiThread(FacebookScreen.access$1700(this$0));
                return;
            } else
            {
                (new android.support.v7.app.AlertDialog.Builder(FacebookScreen.access$2000(this$0))).setMessage(0x7f0e00db).setTitle(0x7f0e00dd).setPositiveButton(0x7f0e0093, new FacebookScreen._cls5._cls1._cls1()).show();
                FacebookScreen.access$2100(this$0);
                return;
            }
        }

            
            {
                this$1 = final__pcls5;
                hasPhotos = Boolean.this;
                super();
            }
    }

}
