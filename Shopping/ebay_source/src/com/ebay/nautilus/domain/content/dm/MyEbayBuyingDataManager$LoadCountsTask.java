// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.DatedContent;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayBuyingDataManager

private final class includeBestOfferList extends AsyncTask
{

    public final boolean includeBestOfferList;
    public final boolean includeBidList;
    public final boolean includeLostList;
    public final boolean includeWonList;
    final MyEbayBuyingDataManager this$0;

    protected transient DatedContent doInBackground(Void avoid[])
    {
        try
        {
            avoid = loadCounts(includeBidList, includeWonList, includeLostList, includeBestOfferList);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(DatedContent datedcontent)
    {
        handleLoadCountsResult(this, datedcontent);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((DatedContent)obj);
    }

    public (boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        this$0 = MyEbayBuyingDataManager.this;
        super();
        includeBidList = flag;
        includeWonList = flag1;
        includeLostList = flag2;
        includeBestOfferList = flag3;
    }
}
