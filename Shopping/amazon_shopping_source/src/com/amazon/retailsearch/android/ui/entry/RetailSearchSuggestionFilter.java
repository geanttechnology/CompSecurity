// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Filter;
import com.amazon.retailsearch.data.ISuggestionDataProvider;
import com.amazon.retailsearch.data.SuggestionDataItem;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionRow, RetailSearchEntryContext, RetailSearchSuggestionFilterListener

public class RetailSearchSuggestionFilter extends Filter
{
    private class FilterResultValue
    {

        public List rows;
        public String searchTerm;
        final RetailSearchSuggestionFilter this$0;

        public FilterResultValue(List list, String s)
        {
            this$0 = RetailSearchSuggestionFilter.this;
            super();
            rows = list;
            searchTerm = s;
        }
    }


    private static final String ALIAS_APS = "aps";
    private RetailSearchSuggestionFilterListener filterListener;
    RetailSearchAndroidPlatform platform;
    private String searchAlias;
    private final EditText searchBox;
    private RetailSearchEntryContext searchEntryContext;
    private ISuggestionDataProvider suggestionDataProvider;
    List suggestionRows;

    public RetailSearchSuggestionFilter(ISuggestionDataProvider isuggestiondataprovider, String s, EditText edittext, RetailSearchEntryContext retailsearchentrycontext, RetailSearchSuggestionFilterListener retailsearchsuggestionfilterlistener)
    {
        suggestionRows = new ArrayList();
        RetailSearchDaggerGraphController.inject(this);
        searchEntryContext = retailsearchentrycontext;
        searchBox = edittext;
        filterListener = retailsearchsuggestionfilterlistener;
        suggestionDataProvider = isuggestiondataprovider;
        searchAlias = s;
    }

    private String addQueryParam(String s, String s1, String s2)
    {
        String s3 = s;
        if (!TextUtils.isEmpty(s1))
        {
            s3 = s;
            if (!TextUtils.isEmpty(s2))
            {
                s3 = (new StringBuilder()).append(s).append("&").append(s1).append("=").append(Uri.encode(s2)).toString();
            }
        }
        return s3;
    }

    private void appendBarcodeEntries(List list)
    {
        RetailSearchSuggestionRow retailsearchsuggestionrow = new RetailSearchSuggestionRow();
        retailsearchsuggestionrow.setVoiceEnabled(searchEntryContext.voiceEnabled());
        retailsearchsuggestionrow.setHasSnap(searchEntryContext.hasSnapIt());
        retailsearchsuggestionrow.setFlowEnabled(searchEntryContext.isFlowEnabled());
        retailsearchsuggestionrow.setShowVisualScan(searchEntryContext.showVisualScan());
        retailsearchsuggestionrow.setShowBarcode(searchEntryContext.showBarcodeEntry());
        retailsearchsuggestionrow.setRowType(RetailSearchSuggestionRow.RowType.ICON);
        list.add(retailsearchsuggestionrow);
    }

    private void appendSuggestionData(List list, List list1)
    {
        if (list1 != null)
        {
            int i = 0;
            int j = 0;
            Iterator iterator = list1.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                SuggestionDataItem suggestiondataitem = (SuggestionDataItem)iterator.next();
                com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType suggestiontype = suggestiondataitem.getType();
                if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.A9_SUGGESTION.equals(suggestiontype) || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.equals(suggestiontype))
                {
                    int k = i + 1;
                    i = k;
                    if (suggestiondataitem.isXcatValue())
                    {
                        j++;
                        i = k;
                    }
                }
            } while (true);
            Iterator iterator1 = list1.iterator();
            while (iterator1.hasNext()) 
            {
                SuggestionDataItem suggestiondataitem1 = (SuggestionDataItem)iterator1.next();
                RetailSearchSuggestionRow retailsearchsuggestionrow = new RetailSearchSuggestionRow();
                String s2 = suggestiondataitem1.getSuggestion();
                String s1 = makeQuery("paramText", s2);
                String s3 = suggestiondataitem1.getSearchAlias();
                String s;
                if ("aps".equals(s3))
                {
                    list1 = null;
                } else
                {
                    list1 = suggestiondataitem1.getDepartmentName();
                }
                s = s1;
                if (!TextUtils.isEmpty(s3))
                {
                    s = s1;
                    if (!TextUtils.isEmpty(list1))
                    {
                        s = addQueryParam(s1, "paramSuggestionDepartmentName", list1);
                    }
                }
                s = addQueryParam(s, "paramSuggestionDepartmentFilter", s3);
                retailsearchsuggestionrow.setSuggestion(s2);
                retailsearchsuggestionrow.setDepartment(list1);
                retailsearchsuggestionrow.setDeleteUrl(suggestiondataitem1.getDeleteURL());
                retailsearchsuggestionrow.setIntentData(s);
                retailsearchsuggestionrow.setPastSearchId(suggestiondataitem1.getId());
                retailsearchsuggestionrow.setQuery(suggestiondataitem1.getQuery());
                retailsearchsuggestionrow.setPos(suggestiondataitem1.getPos());
                retailsearchsuggestionrow.setXcatPos(suggestiondataitem1.getXcatPos());
                retailsearchsuggestionrow.setSpellCorrected(suggestiondataitem1.isSpellCorrectedValue());
                retailsearchsuggestionrow.setXcat(suggestiondataitem1.isXcatValue());
                retailsearchsuggestionrow.setFallBack(suggestiondataitem1.isFallbackValue());
                retailsearchsuggestionrow.setRowType(RetailSearchSuggestionRow.RowType.SUGGESTION);
                retailsearchsuggestionrow.setSuggestionType(suggestiondataitem1.getType());
                retailsearchsuggestionrow.setXcatSize(j);
                retailsearchsuggestionrow.setA9SuggestionSize(i);
                list.add(retailsearchsuggestionrow);
            }
        }
    }

    private String makeQuery(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            return (new StringBuilder()).append("?").append(s).append("=").append(Uri.encode(s1)).toString();
        } else
        {
            return "?";
        }
    }

    protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
    {
        android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
        if (charsequence == null)
        {
            return filterresults;
        }
        if (filterListener != null)
        {
            filterListener.beforePerformFiltering();
        }
        ArrayList arraylist = new ArrayList();
        if ((searchEntryContext.hasScanIt() || searchEntryContext.hasSnapIt()) && TextUtils.isEmpty(searchEntryContext.getCurrentDepartmentName()) && (TextUtils.isEmpty(charsequence) || searchEntryContext.isFirstTimeEnter()))
        {
            appendBarcodeEntries(arraylist);
            filterresults.count = arraylist.size();
            filterresults.values = new FilterResultValue(arraylist, (String)charsequence);
            publishResults(charsequence, filterresults, false);
        }
        if (suggestionDataProvider != null)
        {
            boolean flag;
            synchronized (searchEntryContext)
            {
                flag = searchEntryContext.isForceUpdatePastSearches();
                searchEntryContext.setForceUpdatePastSearches(false);
            }
            appendSuggestionData(arraylist, suggestionDataProvider.getSuggestions(searchAlias, charsequence.toString(), flag));
        }
        searchEntryContext.setFirstTimeEnter(false);
        filterresults.values = new FilterResultValue(arraylist, (String)charsequence);
        filterresults.count = arraylist.size();
        return filterresults;
        charsequence;
        retailsearchentrycontext;
        JVM INSTR monitorexit ;
        throw charsequence;
    }

    protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
    {
        publishResults(charsequence, filterresults, true);
    }

    protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults, boolean flag)
    {
        if (filterresults != null && filterresults.values != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        filterresults = (FilterResultValue)filterresults.values;
        suggestionRows.clear();
        RetailSearchSuggestionRow retailsearchsuggestionrow;
        for (Iterator iterator = ((FilterResultValue) (filterresults)).rows.iterator(); iterator.hasNext(); suggestionRows.add(retailsearchsuggestionrow))
        {
            retailsearchsuggestionrow = (RetailSearchSuggestionRow)iterator.next();
        }

        filterresults = ((FilterResultValue) (filterresults)).searchTerm;
        if (filterListener != null)
        {
            filterListener.beforePublishResults(suggestionRows, flag);
        }
        if (suggestionRows.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s = searchBox.getText().toString();
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(filterresults) && !s.startsWith(filterresults) && !filterresults.startsWith(s)) goto _L1; else goto _L3
_L3:
        if (filterListener == null) goto _L1; else goto _L4
_L4:
        filterListener.afterPublishResults((String)charsequence, suggestionRows);
        return;
    }
}
