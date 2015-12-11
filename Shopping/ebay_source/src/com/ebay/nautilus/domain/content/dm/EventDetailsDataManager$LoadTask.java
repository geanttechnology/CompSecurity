// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.net.api.events.EventDetailsRequest;
import com.ebay.nautilus.domain.net.api.events.EventDetailsResponse;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EventDetailsDataManager

private final class country extends AsyncTask
{

    private final Authentication auth;
    private final EbayCountry country;
    final EventDetailsDataManager this$0;

    protected transient EventDetailsResponse doInBackground( a[])
    {
        String s;
        EventDetailsDataManager eventdetailsdatamanager;
        eventdetailsdatamanager = EventDetailsDataManager.this;
        if (auth == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        s = auth.iafToken;
_L1:
        a = (EventDetailsResponse)EventDetailsDataManager.access$000(eventdetailsdatamanager, new EventDetailsRequest(s, country, a[0].eventSeoName));
        return a;
        s = null;
          goto _L1
        a;
        return null;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground(([])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(this, null);
    }

    protected void onPostExecute(EventDetailsResponse eventdetailsresponse)
    {
        super.onPostExecute(eventdetailsresponse);
        handleLoadDataResult(this, eventdetailsresponse);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((EventDetailsResponse)obj);
    }

    public (Authentication authentication, EbayCountry ebaycountry)
    {
        this$0 = EventDetailsDataManager.this;
        super();
        auth = authentication;
        country = ebaycountry;
    }
}
