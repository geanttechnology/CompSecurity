// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.SearchRecentSuggestions;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.view.EbaySearchProvider;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.search.RefinementLocks;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile:
//            MyApp

public class eBayDictionaryProvider extends EbaySearchProvider
{

    private static String keywordEntry = null;

    public eBayDictionaryProvider()
    {
        super("com.ebay.mobile.ebaysearch");
    }

    public static void clearHistory(Context context)
    {
        keywordEntry = null;
        EbaySearchProvider.getSuggestionsManager(context, "com.ebay.mobile.ebaysearch").clearHistory();
    }

    public static SearchParameters getDefaultSearchParameters(Context context, String s)
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        context = new SearchParameters(EbayApiUtil.getCurrentCountry(), dcshelper.getSearchPageSize(context.getResources()), 0);
        context.keywords = s;
        s = MyApp.getPrefs().getPostalCode();
        if (SearchUtil.showShippingCosts())
        {
            context.buyerPostalCode = ((PostalCodeSpecification) (s)).postalCode;
            return context;
        } else
        {
            context.hideShipping = true;
            return context;
        }
    }

    public static SearchParameters getLockedSearchParameters(Context context, String s)
    {
        context = getDefaultSearchParameters(context, s);
        if (DeviceConfiguration.getAsync().get(DcsBoolean.SearchRefineLocking))
        {
            RefinementLocks.applyLocks(context);
        }
        return context;
    }

    public static String getQueryText()
    {
        return keywordEntry;
    }

    public static void saveRecentQuery(Context context, String s)
    {
        keywordEntry = s;
        EbaySearchProvider.getSuggestionsManager(context, "com.ebay.mobile.ebaysearch").saveRecentQuery(s, null);
    }

    protected MatrixCursor addEbaySuggestions(Cursor cursor, String s, ComponentName componentname)
    {
        keywordEntry = s;
        return super.addEbaySuggestions(cursor, s, componentname);
    }

    protected EbayCountry getCountry()
    {
        if (MyApp.getApp() == null)
        {
            return (new Preferences(getContext(), false)).getCurrentCountry();
        } else
        {
            return EbayApiUtil.getCurrentCountry();
        }
    }

}
