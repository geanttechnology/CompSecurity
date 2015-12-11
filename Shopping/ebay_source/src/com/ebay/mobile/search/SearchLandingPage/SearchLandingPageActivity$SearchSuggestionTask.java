// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.autocomplete.AutoCompleteApi;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.util.EbayApiUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageActivity, SearchSuggestionAdapter

private static class activityRef extends AsyncTask
{

    private WeakReference activityRef;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient ArrayList doInBackground(String as[])
    {
        Object obj = null;
        ArrayList arraylist = obj;
        if (!isCancelled())
        {
            SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
            arraylist = obj;
            if (searchlandingpageactivity != null)
            {
                arraylist = obj;
                if (as != null)
                {
                    arraylist = obj;
                    if (as.length > 0)
                    {
                        as = as[0];
                        try
                        {
                            as = as.toLowerCase(Locale.getDefault()).trim();
                            arraylist = EbayApiUtil.getAutoCompleteApi(searchlandingpageactivity.getEbayContext(), MyApp.getPrefs().getCurrentCountry()).autoFillSuggestions(as);
                        }
                        // Misplaced declaration of an exception variable
                        catch (String as[])
                        {
                            return null;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String as[])
                        {
                            return null;
                        }
                    }
                }
            }
        }
        return arraylist;
    }

    protected void onCancelled()
    {
        SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
        if (searchlandingpageactivity != null && !searchlandingpageactivity.isFinishing())
        {
            searchlandingpageactivity.progress.setVisibility(8);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
        if (searchlandingpageactivity != null && !searchlandingpageactivity.isFinishing())
        {
            if (arraylist != null)
            {
                searchlandingpageactivity.suggestionList = arraylist;
                searchlandingpageactivity.suggestionAdapter.updateSuggestionList(searchlandingpageactivity.suggestionList, searchlandingpageactivity.lastQueryUsed);
            }
            searchlandingpageactivity.progress.setVisibility(8);
            if (!searchlandingpageactivity.suggestionListView.isShown())
            {
                searchlandingpageactivity.suggestionListView.setVisibility(0);
                searchlandingpageactivity.isSuggestionVisible = true;
            }
        }
    }

    protected void onPreExecute()
    {
        SearchLandingPageActivity searchlandingpageactivity = (SearchLandingPageActivity)activityRef.get();
        if (searchlandingpageactivity != null && !searchlandingpageactivity.isFinishing())
        {
            searchlandingpageactivity.progress.setVisibility(0);
        }
    }

    (SearchLandingPageActivity searchlandingpageactivity)
    {
        activityRef = new WeakReference(searchlandingpageactivity);
    }
}
