// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.text.TextUtils;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.finding.PagedList;
import com.ebay.common.net.api.search.SavedSearchesApi;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.shopping.EbayShoppingApiHelper;
import com.ebay.common.util.EbayObservableAsyncTask;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

private static final class context extends EbayObservableAsyncTask
{

    private final Authentication authentication;
    private final EbayContext context;
    public final boolean isRetry;
    private final Object parameters;

    private com.ebay.common.net.api.search.ext doSearch(SavedSearch savedsearch)
        throws com.ebay.nautilus.kernel.net.ntext, com.ebay.nautilus.kernel.net.ntext, com.ebay.common.net.ncTask, com.ebay.nautilus.kernel.net.ntext, IOException, InterruptedException
    {
        Object obj;
        obj = DeviceConfiguration.getAsync();
        obj = SavedSearchesApi.findItem(context, savedsearch, ((DeviceConfiguration) (obj)).get(DcsNautilusBoolean.GBH));
        new com.ebay.mobile.search.ask.context(savedsearch, authentication);
        if (savedsearch.searchParameters == null || savedsearch.searchParameters.category == null || savedsearch.searchParameters.category.name != null)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        Object obj1 = new EbayShoppingApi(savedsearch.searchParameters.country.site);
        savedsearch = savedsearch.searchParameters.category;
        int i;
        int j;
        try
        {
            obj1 = EbayShoppingApiHelper.getCategoryInfo(context, ((EbayShoppingApi) (obj1)), ((EbayCategorySummary) (savedsearch)).id, false);
        }
        // Misplaced declaration of an exception variable
        catch (SavedSearch savedsearch)
        {
            return ((com.ebay.common.net.api.search.ext) (obj));
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        if (((ArrayList) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_235;
        }
        obj1 = (EbayCategory)((ArrayList) (obj1)).get(0);
        if (((EbayCategory) (obj1)).id != ((EbayCategorySummary) (savedsearch)).id)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        savedsearch.name = ((EbayCategory) (obj1)).name;
        if (TextUtils.isEmpty(((EbayCategory) (obj1)).namePath))
        {
            break MISSING_BLOCK_LABEL_235;
        }
        j = -1;
        i = ((EbayCategory) (obj1)).namePath.indexOf(':');
_L2:
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        i = ((EbayCategory) (obj1)).namePath.indexOf(':', i + 1);
        if (true) goto _L2; else goto _L1
_L1:
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        savedsearch = new com.ebay.common.net.api.search.ext(((com.ebay.common.net.api.search.ext) (obj)).ext, ((com.ebay.common.net.api.search.ext) (obj)).ext, null, ((com.ebay.common.net.api.search.ext) (obj)).ext, ((com.ebay.common.net.api.search.ext) (obj)).ext, ((com.ebay.common.net.api.search.ext) (obj)).ext);
        return savedsearch;
        return ((com.ebay.common.net.api.search.ext) (obj));
    }

    protected com.ebay.common.net.api.search.ext doInBackgroundInternal(Void void1)
        throws com.ebay.nautilus.kernel.net.ntext, com.ebay.nautilus.kernel.net.ntext, com.ebay.common.net.ncTask, com.ebay.nautilus.kernel.net.ntext, IOException, InterruptedException
    {
        if (!isRetry)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        void1 = (com.ebay.common.net.api.search.try)parameters;
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (((com.ebay.common.net.api.search.meters) (void1)).meters == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((PagedList)((com.ebay.common.net.api.search.meters) (void1)).meters).retry();
        return void1;
        try
        {
            void1 = doSearch((SavedSearch)parameters);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            throw EbayApiUtil.buildOutOfMemoryError(void1);
        }
        return void1;
        return void1;
    }

    protected volatile Object doInBackgroundInternal(Object obj)
        throws com.ebay.nautilus.kernel.net.rameters, com.ebay.nautilus.kernel.net.rameters, com.ebay.common.net.ncTask, com.ebay.nautilus.kernel.net.rameters, IOException, InterruptedException
    {
        return doInBackgroundInternal((Void)obj);
    }

    public (EbayContext ebaycontext, SavedSearch savedsearch, Authentication authentication1)
    {
        authentication = authentication1;
        isRetry = false;
        parameters = savedsearch;
        context = ebaycontext;
    }

    public context(EbayContext ebaycontext, com.ebay.common.net.api.search.ext ext, Authentication authentication1)
    {
        authentication = authentication1;
        isRetry = true;
        parameters = ext;
        context = ebaycontext;
    }
}
