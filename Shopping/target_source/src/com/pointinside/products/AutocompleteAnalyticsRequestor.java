// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.PIException;
import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.internal.utils.IOUtils;
import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.pointinside.products:
//            AutocompleteResult, AutocompleteURLBuilder, AutocompleteSuggestion

public final class AutocompleteAnalyticsRequestor
{

    private final AutocompleteResult mAutocompleteResult;
    private final AutocompleteSuggestion mSelectedItem;

    public AutocompleteAnalyticsRequestor(AutocompleteResult autocompleteresult, AutocompleteSuggestion autocompletesuggestion)
    {
        mAutocompleteResult = autocompleteresult;
        mSelectedItem = autocompletesuggestion;
    }

    String getPOSTBody()
        throws PIException
    {
        return (new com.pointinside.internal.utils.IOUtils.AnalyticsPOSTData(new BaseAnalyticsData[] {
            ((AutocompleteAnalyticsData.Builder)(new AutocompleteAnalyticsData.Builder()).selectedItem(mSelectedItem).allItems(mAutocompleteResult.mSuggestions).resultNumber(mAutocompleteResult.originalIndexFromSuggestion(mSelectedItem)).commonAnalyticData(mAutocompleteResult.url.commonAnalyticData).datetime(System.currentTimeMillis())).build()
        })).getJSONString();
    }

    public void sendAnalyticsInfo()
        throws PIException
    {
        HttpURLConnection httpurlconnection;
        HttpURLConnection httpurlconnection1;
        HttpURLConnection httpurlconnection2;
        Object obj;
        if (mAutocompleteResult == null)
        {
            throw new PIException("Provided AutocompleteResult cannot be null. Cannot proceed with analytics");
        }
        if (mSelectedItem == null)
        {
            throw new PIException("Provided selected suggestion cannot be null. Cannot proceed with analytics");
        }
        obj = null;
        httpurlconnection2 = null;
        httpurlconnection1 = httpurlconnection2;
        httpurlconnection = obj;
        mAutocompleteResult.url.setQualifiers("analytics");
        httpurlconnection1 = httpurlconnection2;
        httpurlconnection = obj;
        httpurlconnection2 = mAutocompleteResult.url.openConnection();
        httpurlconnection1 = httpurlconnection2;
        httpurlconnection = httpurlconnection2;
        IOUtils.executeHttpPostRequest(httpurlconnection2, getPOSTBody());
        if (httpurlconnection2 != null)
        {
            httpurlconnection2.disconnect();
        }
        return;
        IOException ioexception;
        ioexception;
        httpurlconnection = httpurlconnection1;
        throw new PIException(ioexception);
        Exception exception;
        exception;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw exception;
    }
}
