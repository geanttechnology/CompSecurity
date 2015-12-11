// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.support.v4.app.ah;
import android.util.SparseArray;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, MarketingMessage, LocalyticsManager

class val.jsCallbacks
    implements Runnable
{

    final MarketingHandler this$0;
    final SparseArray val$jsCallbacks;
    final MarketingMessage val$marketingMessage;

    public void run()
    {
        if (MarketingHandler.access$300(MarketingHandler.this) != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (MarketingHandler.access$300(MarketingHandler.this).a("marketing_dialog") != null || MarketingHandler.access$400(MarketingHandler.this)) goto _L1; else goto _L3
_L3:
        MarketingHandler.access$402(MarketingHandler.this, true);
        class _cls1 extends AsyncTask
        {

            final MarketingHandler._cls8 this$1;
            final int val$campaignId;

            protected transient Boolean doInBackground(Void avoid[])
            {
                return Boolean.valueOf(setMarketingMessageAsDisplayed(campaignId));
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    if (MarketingHandler.access$300(this$0) != null)
                    {
                        MarketingDialogFragment.newInstance().setData(marketingMessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(jsCallbacks)).show(MarketingHandler.access$300(this$0), "marketing_dialog");
                        if (!Constants.isTestModeEnabled())
                        {
                            ((MessagingListener)listeners).localyticsWillDisplayInAppMessage();
                        }
                        MarketingHandler.access$300(this$0).b();
                    } else
                    {
                        MarketingHandler.access$500(this$0, campaignId);
                    }
                }
                MarketingHandler.access$402(this$0, false);
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Boolean)obj);
            }

            _cls1()
            {
                this$1 = MarketingHandler._cls8.this;
                campaignId = i;
                super();
            }
        }

        (new _cls1()).execute(new Void[0]);
        return;
        Exception exception;
        exception;
        LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", exception);
        return;
    }

    _cls1()
    {
        this$0 = final_marketinghandler;
        val$marketingMessage = marketingmessage;
        val$jsCallbacks = SparseArray.this;
        super();
    }
}
