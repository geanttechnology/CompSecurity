// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.amazon.mShop.control.search.AdvSearchSuggestionsController;
import com.amazon.mShop.control.search.AdvSearchSuggestionsSubscriber;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import com.amazon.retailsearch.android.api.intent.search.SearchIntentUriBuilder;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.SearchSuggestion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity

public class SuggestionsProvider extends ContentProvider
    implements AdvSearchSuggestionsSubscriber
{

    private final String COLUMN[] = {
        "_id", "suggest_text_1", "suggest_text_2", "suggest_intent_data", "intent_extra_data_key"
    };
    private final AdvSearchSuggestionsController mSSC = new AdvSearchSuggestionsController(this);
    private List mValues;

    public SuggestionsProvider()
    {
        mValues = new ArrayList();
    }

    private Cursor getBarcodeEntryCursor()
    {
        MatrixCursor matrixcursor = new MatrixCursor(new String[] {
            "_id", "suggest_icon_1", "suggest_text_1", "suggest_text_2", "suggest_intent_data"
        });
        String s = null;
        String s1 = null;
        Object obj = getContext().getResources();
        int i;
        if (ActivityUtils.isFlowEnabled(getContext()))
        {
            s = ((Resources) (obj)).getString(com.amazon.mShop.android.lib.R.string.view_it_scan_it_description);
            s1 = ((Resources) (obj)).getString(com.amazon.mShop.android.lib.R.string.view_it_flow_description);
            obj = ((Resources) (obj)).getString(com.amazon.mShop.android.lib.R.string.view_it_flow);
            i = com.amazon.mShop.android.lib.R.drawable.flow_icon;
        } else
        {
            obj = ((Resources) (obj)).getString(com.amazon.mShop.android.lib.R.string.snapit);
            i = com.amazon.mShop.android.lib.R.drawable.search_suggestion_snapit;
        }
        matrixcursor.addRow(new String[] {
            "0", (new StringBuilder()).append(com.amazon.mShop.android.lib.R.drawable.search_suggestion_barcode).append("").toString(), getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_button), s, "BARCODE_SEARCH_QUERY_KEYWORD"
        });
        if (ConfigUtils.isEnabled(getContext(), com.amazon.mShop.android.lib.R.string.config_hasSnapIt))
        {
            matrixcursor.addRow(new String[] {
                "1", (new StringBuilder()).append(i).append("").toString(), obj, s1, "IMAGE_SEARCH_QUERY_KEYWORD"
            });
        }
        return matrixcursor;
    }

    private String[] makeSuggestionRow(int i, SearchSuggestion searchsuggestion)
    {
        String s2 = searchsuggestion.getQuery();
        SearchIntentUriBuilder searchintenturibuilder = new SearchIntentUriBuilder();
        searchintenturibuilder.query(s2);
        String s1 = searchsuggestion.getDepartment();
        Object obj = s1;
        if (!Util.isEmpty(s1))
        {
            obj = String.format(getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.search_suggestions_department_text), new Object[] {
                s1
            });
        }
        String s = ((String) (obj));
        obj = searchsuggestion.getFilters();
        if (!Util.isEmpty(((String) (obj))) && !Util.isEmpty(s1))
        {
            searchintenturibuilder.filter(((String) (obj)));
            searchintenturibuilder.categoryName(s1);
        }
        if (searchsuggestion.getAutoSearch() != null)
        {
            searchsuggestion = searchsuggestion.getAutoSearch().toString();
        } else
        {
            searchsuggestion = "";
        }
        obj = searchintenturibuilder.build();
        s1 = Integer.toString(i);
        if (obj != null)
        {
            obj = ((Uri) (obj)).toString();
        } else
        {
            obj = "";
        }
        return (new String[] {
            s1, s2, s, obj, searchsuggestion
        });
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        return "vnd.android.cursor.dir/vnd.android.search.suggest";
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return null;
    }

    public boolean onCreate()
    {
        return false;
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        this;
        JVM INSTR monitorenter ;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onSearchSuggestionsReceived(List list)
    {
        mValues = list;
        this;
        JVM INSTR monitorenter ;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        mValues.clear();
        as = uri.toString();
        int l = as.lastIndexOf("/search_suggest_query/");
        int i1 = "/search_suggest_query/".length();
        int k = as.lastIndexOf("?");
        int i = k;
        if (k == -1)
        {
            i = as.length();
        }
        as1 = as.substring(l + i1, i).toLowerCase();
        if (as1.length() == 0)
        {
            SearchActivity.setShouldShowBarcodeEntry(true);
            SearchActivity.setPreviousSearchTerm("");
        }
        if (!SearchActivity.getShouldShowBarcodeEntry()) goto _L2; else goto _L1
_L1:
        SearchActivity.setShouldShowBarcodeEntry(false);
        if (Util.isEmpty(SearchActivity.getCurrentDepartmentName())) goto _L4; else goto _L3
_L3:
        as = new MatrixCursor(COLUMN);
_L6:
        return as;
_L4:
        return getBarcodeEntryCursor();
_L2:
        s = new MatrixCursor(COLUMN);
        as = s;
        if (as1.length() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        mSSC.getSearchSuggestions(uri.getLastPathSegment().toLowerCase());
        int j = 0;
        this;
        JVM INSTR monitorenter ;
        wait();
        this;
        JVM INSTR monitorexit ;
        uri = mValues.iterator();
        do
        {
            as = s;
            if (!uri.hasNext())
            {
                break;
            }
            s.addRow(makeSuggestionRow(j, (SearchSuggestion)uri.next()));
            j++;
        } while (true);
        if (true) goto _L6; else goto _L5
_L5:
        uri;
        this;
        JVM INSTR monitorexit ;
        return null;
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return 0;
    }
}
