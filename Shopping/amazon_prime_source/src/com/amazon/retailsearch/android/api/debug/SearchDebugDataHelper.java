// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugDataStore

public class SearchDebugDataHelper
{

    private static SearchDebugDataHelper instance = null;
    SearchDebugDataStore dataStore;

    private SearchDebugDataHelper()
    {
        RetailSearchDaggerGraphController.inject(this);
    }

    public static SearchDebugDataHelper getInstance()
    {
        if (instance == null)
        {
            return new SearchDebugDataHelper();
        } else
        {
            return instance;
        }
    }

    public CollectionMap getDebugCookies()
    {
        return dataStore.getCookies();
    }

    public String getSearchServiceUrl()
    {
        return dataStore.getCustomServiceUrl();
    }

}
