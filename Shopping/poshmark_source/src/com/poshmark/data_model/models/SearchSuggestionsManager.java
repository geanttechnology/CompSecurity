// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.database.Cursor;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.adapters.SearchSuggestionsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.http.PMHttpRequest;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.utils.FeatureManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, SuggestedSearchResults, SuggestedSearchItem

public class SearchSuggestionsManager
    implements PMApiResponseHandler
{

    SearchSuggestionsAdapter dropdownListAdapter;
    boolean pendingResults;
    String searchString;

    public SearchSuggestionsManager()
    {
        pendingResults = false;
    }

    private void resetAdapterCursor()
    {
        Cursor cursor = dropdownListAdapter.getCursor();
        if (cursor != null)
        {
            cursor.close();
        }
        dropdownListAdapter.changeCursor(null);
    }

    public Cursor fillCursorWithRecents()
    {
        dropdownListAdapter.getCursor();
        CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
            PMData.ID_COL, PMData.DATA_COL
        });
        GlobalDbController.getGlobalDbController().populateCursorWithRecentSavedSearches(custommatrixcursor, 5);
        return custommatrixcursor;
    }

    public void fillFilteredCursor(CharSequence charsequence)
    {
        searchString = charsequence.toString();
        if (FeatureManager.getGlobalFeatureManager().isAutoCompleteSearchEnabled())
        {
            if (searchString.length() > 0)
            {
                PMApi.getSuggestedSearch(charsequence.toString(), this);
            }
        } else
        {
            charsequence = dropdownListAdapter.getCursor();
            CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            GlobalDbController.getGlobalDbController().populateCursorWithRelevantSavedSearches(custommatrixcursor, searchString);
            dropdownListAdapter.changeCursor(custommatrixcursor);
            if (charsequence != null)
            {
                charsequence.close();
                return;
            }
        }
    }

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError() && pmapiresponse.httpCode != 503)
        {
            String s = (String)pmapiresponse.httpRequest.queryParams.get("query");
            if (searchString.equals(s))
            {
                SuggestedSearchResults suggestedsearchresults = (SuggestedSearchResults)pmapiresponse.data;
                Cursor cursor = dropdownListAdapter.getCursor();
                CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                    PMData.ID_COL, PMData.DATA_COL
                });
                GlobalDbController.getGlobalDbController().populateCursorWithRelevantSavedSearches(custommatrixcursor, (String)pmapiresponse.httpRequest.queryParams.get("query"));
                pmapiresponse = suggestedsearchresults.data.iterator();
                do
                {
                    if (!pmapiresponse.hasNext())
                    {
                        break;
                    }
                    SuggestedSearchItem suggestedsearchitem = (SuggestedSearchItem)pmapiresponse.next();
                    if (!GlobalDbController.getGlobalDbController().isKeywordInSavedSearches(suggestedsearchitem.kw))
                    {
                        custommatrixcursor.addRow(new Object[] {
                            Integer.valueOf(0), suggestedsearchitem
                        });
                    }
                } while (true);
                dropdownListAdapter.changeCursor(custommatrixcursor);
                if (cursor != null)
                {
                    cursor.close();
                }
            }
            return;
        } else
        {
            resetAdapterCursor();
            return;
        }
    }

    public void setListAdapter(SearchSuggestionsAdapter searchsuggestionsadapter)
    {
        dropdownListAdapter = searchsuggestionsadapter;
    }
}
