// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.os.AsyncTask;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.FindPopularSearchesRequest;
import com.ebay.common.net.api.search.FindPopularSearchesResponse;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager

public final class tag extends AsyncTask
    implements tag
{

    private final EbayShoppingApi api;
    private List categories;
    private final String keywords;
    private final parentSearchLoadTask parentSearchLoadTask;
    private ArrayList popularSearchKeywords;
    private final int tag;
    final SearchDataManager this$0;

    private List addCategoryToList(EbayCategorySummary ebaycategorysummary, List list)
    {
        if (ebaycategorysummary == null)
        {
            return list;
        }
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        ((List) (obj)).add(ebaycategorysummary);
        return ((List) (obj));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        Object obj;
        obj = new FindPopularSearchesRequest(api, keywords, categories);
        avoid = null;
        obj = (FindPopularSearchesResponse)com.ebay.nautilus.kernel.net.tegories(getEbayContext(), ((com.ebay.nautilus.kernel.net.Request) (obj)));
        avoid = ((Void []) (obj));
_L1:
        Object obj1;
        if (avoid == null)
        {
            return null;
        } else
        {
            return avoid.getRelatedSearches();
        }
        obj1;
        ((com.ebay.nautilus.kernel.net.arches) (obj1)).tackTrace();
          goto _L1
        obj1;
        ((com.ebay.nautilus.kernel.net.tackTrace) (obj1)).StackTrace();
          goto _L1
        obj1;
        ((IOException) (obj1)).printStackTrace();
          goto _L1
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
          goto _L1
    }

    public ArrayList getPopularKeywords()
    {
        return popularSearchKeywords;
    }

    public int getTag()
    {
        return tag;
    }

    protected void onCancelled()
    {
        super.onCancelled();
        SearchDataManager.access$400(SearchDataManager.this, parentSearchLoadTask, this);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        popularSearchKeywords = arraylist;
        SearchDataManager.access$400(SearchDataManager.this, parentSearchLoadTask, this);
    }

    public ms(ms ms)
    {
        this$0 = SearchDataManager.this;
        super();
        popularSearchKeywords = null;
        parentSearchLoadTask = ms;
        searchdatamanager = ess._mth300(ms).searchParameters;
        api = new EbayShoppingApi(country.site);
        keywords = SearchDataManager.this.keywords;
        categories = null;
        categories = addCategoryToList(category, categories);
        categories = addCategoryToList(category1, categories);
        categories = addCategoryToList(category2, categories);
        tag = 0;
    }

    public tag(EbayShoppingApi ebayshoppingapi, String s, List list, int i)
    {
        this$0 = SearchDataManager.this;
        super();
        popularSearchKeywords = null;
        parentSearchLoadTask = null;
        api = ebayshoppingapi;
        keywords = s;
        categories = list;
        tag = i;
    }
}
