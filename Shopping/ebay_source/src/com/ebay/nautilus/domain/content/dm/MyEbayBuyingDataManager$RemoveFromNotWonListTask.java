// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayBuyingDataManager

private final class observer extends AsyncTask
{

    public final onPostExecute observer;
    final MyEbayBuyingDataManager this$0;

    protected transient Content doInBackground(MyEbayListItem amyebaylistitem[])
    {
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        EbayTradingApi ebaytradingapi = getApi(resultstatusowner);
        if (ebaytradingapi == null)
        {
            return new Content(resultstatusowner.getResultStatus());
        }
        try
        {
            observer observer1 = RemoveFromDidntWinListRequest(ebaytradingapi.site, ebaytradingapi.iafToken, amyebaylistitem);
            amyebaylistitem = new Content(amyebaylistitem, MyEbayBuyingDataManager.access$100(MyEbayBuyingDataManager.this, observer1).getResultStatus());
        }
        // Misplaced declaration of an exception variable
        catch (MyEbayListItem amyebaylistitem[])
        {
            return null;
        }
        return amyebaylistitem;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((MyEbayListItem[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleRemoveFromNotWonListResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleRemoveFromNotWonListResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public ( )
    {
        this$0 = MyEbayBuyingDataManager.this;
        super();
        observer = ;
    }
}
