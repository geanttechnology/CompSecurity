// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssContentsDataManager

private abstract class keyParams extends AsyncTask
{

    protected final Authentication auth;
    protected final EbayCountry country;
    protected final onPostExecute keyParams;
    final UssContentsDataManager this$0;

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(null, false, false, null);
        loadTask = null;
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(content, false, false, null);
        loadTask = null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (Authentication authentication, EbayCountry ebaycountry,  )
    {
        this$0 = UssContentsDataManager.this;
        super();
        country = ebaycountry;
        auth = authentication;
        keyParams = ;
    }
}
