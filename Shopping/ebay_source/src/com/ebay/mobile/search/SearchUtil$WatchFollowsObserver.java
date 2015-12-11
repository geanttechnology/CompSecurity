// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.common.UserCache;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.notifications.ItemCache;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search:
//            SearchUtil, SavedSearchList

public static class FollowedSearchesChanged extends com.ebay.common.content.dm.ollowsObserverBase
{

    public SearchParameters getDefaultSearchParameters()
    {
        String s;
        if (observer != null)
        {
            s = observer.getSearchQuery();
        } else
        {
            s = null;
        }
        return eBayDictionaryProvider.getDefaultSearchParameters(context, s);
    }

    protected transient void onDeleteSavedSearchesFromCache(Context context, String as[])
    {
        SavedSearchList savedsearchlist = UserCache.getSavedSearchList();
        ItemCache itemcache = new ItemCache(context);
        int j = as.length;
label0:
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            Iterator iterator = savedsearchlist.getSearchList().iterator();
            SavedSearch savedsearch;
            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }
                savedsearch = (SavedSearch)iterator.next();
            } while (TextUtils.isEmpty(savedsearch.id) || !savedsearch.id.equals(s));
            itemcache.deleteSavedSearch(s);
            savedsearchlist.removeById(context, s);
        }

    }

    public FollowedSearchesChanged(Context context, com.ebay.common.content.dm.owedSearchesChanged owedsearcheschanged)
    {
        super(context, owedsearcheschanged);
    }
}
