// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.AsyncTask;
import android.support.v4.app.ah;
import android.util.SparseArray;
import android.widget.Toast;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, MarketingMessage, MarketingDialogFragment, JavaScriptClient, 
//            LocalyticsManager

class val.marketingMessage extends AsyncTask
{

    final l.appContext this$1;
    final MarketingMessage val$marketingMessage;

    protected volatile Object doInBackground(Object aobj[])
    {
        return ((Object) (doInBackground((MarketingMessage[])aobj)));
    }

    protected transient Object[] doInBackground(MarketingMessage amarketingmessage[])
    {
        if (MarketingHandler.access$900(_fld0, amarketingmessage[0]))
        {
            amarketingmessage = amarketingmessage[0];
        } else
        {
            amarketingmessage = null;
        }
        return (new Object[] {
            amarketingmessage, MarketingHandler.access$1000(_fld0, null)
        });
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Object[])obj);
    }

    protected void onPostExecute(Object aobj[])
    {
        MarketingMessage marketingmessage = (MarketingMessage)aobj[0];
        aobj = (SparseArray)aobj[1];
        if (marketingmessage == null)
        {
            MarketingDialogFragment marketingdialogfragment;
            try
            {
                Toast.makeText(appContext, "The downloaded campaign file is broken.", 0).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", ((Exception) (aobj)));
            }
            break MISSING_BLOCK_LABEL_182;
        }
        if (MarketingHandler.access$300(_fld0) != null && MarketingHandler.access$300(_fld0).a((new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString()) == null)
        {
            marketingdialogfragment = MarketingDialogFragment.newInstance();
            marketingdialogfragment.setRetainInstance(false);
            marketingdialogfragment.setData(marketingmessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(((SparseArray) (aobj)))).show(MarketingHandler.access$300(_fld0), (new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString());
            MarketingHandler.access$300(_fld0).b();
            return;
        }
    }

    protected void onPreExecute()
    {
        int i = ((Integer)val$marketingMessage.get("_id")).intValue();
        boolean flag = MarketingHandler.access$700(_fld0, val$marketingMessage).endsWith(".zip");
        if (!MarketingHandler.access$800(_fld0, i, flag))
        {
            Toast.makeText(appContext, "Downloading the campaign...\nIt'll be shown in few seconds.", 0).show();
        }
    }

    t()
    {
        this$1 = final_t;
        val$marketingMessage = MarketingMessage.this;
        super();
    }
}
