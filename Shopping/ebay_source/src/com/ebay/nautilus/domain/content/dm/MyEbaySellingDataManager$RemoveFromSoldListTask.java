// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbaySellingDataManager

private final class refinement extends AsyncTask
{

    public final onPostExecute observer;
    public final SellingListRefinement refinement;
    final MyEbaySellingDataManager this$0;

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
            refinement refinement1 = tRemoveFromSoldListRequest(ebaytradingapi.site, ebaytradingapi.iafToken, amyebaylistitem);
            amyebaylistitem = new Content(amyebaylistitem, MyEbaySellingDataManager.access$100(MyEbaySellingDataManager.this, refinement1).getResultStatus());
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
        handleRemoveFromSoldListResult(this, null, refinement);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleRemoveFromSoldListResult(this, content, refinement);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public Y(Y y)
    {
        this(y, null);
    }

    public <init>(<init> <init>1, SellingListRefinement sellinglistrefinement)
    {
        this$0 = MyEbaySellingDataManager.this;
        super();
        observer = <init>1;
        refinement = sellinglistrefinement;
    }
}
