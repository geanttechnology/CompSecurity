// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.log;

import android.content.Context;
import com.amazon.retailsearch.metrics.CategoryBrowseDCMLogger;
import com.amazon.retailsearch.metrics.NullCategoryBrowseLogger;
import com.amazon.retailsearch.metrics.NullRetailSearchLogger;
import com.amazon.retailsearch.metrics.NullSearchBoxLogger;
import com.amazon.retailsearch.metrics.RetailSearchDCMLogger;
import com.amazon.retailsearch.metrics.RetailSearchLoggingConfig;
import com.amazon.retailsearch.metrics.SearchBoxDCMLogger;

// Referenced classes of package com.amazon.retailsearch.android.api.log:
//            CategoryBrowseLogger, RetailSearchLogger, SearchBoxLogger

public class RetailSearchLoggingProvider
{

    private static RetailSearchLoggingProvider loggingProvider = null;
    private final CategoryBrowseLogger categoryBrowseLogger;
    private final RetailSearchLogger retailSearchLogger;
    private final SearchBoxLogger searchBoxLogger;

    private RetailSearchLoggingProvider(Context context)
    {
        RetailSearchLoggingConfig retailsearchloggingconfig = new RetailSearchLoggingConfig(context);
        if (retailsearchloggingconfig.isLoggingEnabled())
        {
            retailSearchLogger = new RetailSearchDCMLogger(context, retailsearchloggingconfig);
            categoryBrowseLogger = new CategoryBrowseDCMLogger(context, retailsearchloggingconfig);
            searchBoxLogger = new SearchBoxDCMLogger(context, retailsearchloggingconfig);
            return;
        } else
        {
            retailSearchLogger = new NullRetailSearchLogger();
            categoryBrowseLogger = new NullCategoryBrowseLogger();
            searchBoxLogger = new NullSearchBoxLogger();
            return;
        }
    }

    public static RetailSearchLoggingProvider getInstance()
    {
        return loggingProvider;
    }

    public static void init(Context context)
    {
        loggingProvider = new RetailSearchLoggingProvider(context);
    }

    public final CategoryBrowseLogger getCategoryBrowseLogger()
    {
        return categoryBrowseLogger;
    }

    public final RetailSearchLogger getRetailSearchLogger()
    {
        return retailSearchLogger;
    }

    public final SearchBoxLogger getSearchBoxLogger()
    {
        return searchBoxLogger;
    }

}
