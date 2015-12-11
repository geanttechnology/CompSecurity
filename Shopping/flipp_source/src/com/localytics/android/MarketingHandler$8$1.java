// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.AsyncTask;
import android.support.v4.app.ah;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, MarketingDialogFragment, JavaScriptClient, Constants, 
//            MessagingListener

class val.campaignId extends AsyncTask
{

    final onPostExecute this$1;
    final int val$campaignId;

    protected transient Boolean doInBackground(Void avoid[])
    {
        return Boolean.valueOf(setMarketingMessageAsDisplayed(val$campaignId));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            if (MarketingHandler.access$300(_fld0) != null)
            {
                MarketingDialogFragment.newInstance().setData(marketingMessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(jsCallbacks)).show(MarketingHandler.access$300(_fld0), "marketing_dialog");
                if (!Constants.isTestModeEnabled())
                {
                    ((MessagingListener)listeners).localyticsWillDisplayInAppMessage();
                }
                MarketingHandler.access$300(_fld0).b();
            } else
            {
                MarketingHandler.access$500(_fld0, val$campaignId);
            }
        }
        MarketingHandler.access$402(_fld0, false);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    nt()
    {
        this$1 = final_nt;
        val$campaignId = I.this;
        super();
    }
}
