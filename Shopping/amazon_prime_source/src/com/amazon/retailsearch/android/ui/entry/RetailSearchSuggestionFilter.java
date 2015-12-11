// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.os.Looper;
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
        public final String searchTerm;
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
    private final RetailSearchEntryContext searchEntryContext;
    private boolean skipDepartmentResultsFromISS;
    private ISuggestionDataProvider suggestionDataProvider;

    public RetailSearchSuggestionFilter(ISuggestionDataProvider isuggestiondataprovider, String s, EditText edittext, RetailSearchEntryContext retailsearchentrycontext, RetailSearchSuggestionFilterListener retailsearchsuggestionfilterlistener)
    {
        skipDepartmentResultsFromISS = false;
        RetailSearchDaggerGraphController.inject(this);
        searchEntryContext = retailsearchentrycontext;
        searchBox = edittext;
        filterListener = retailsearchsuggestionfilterlistener;
        suggestionDataProvider = isuggestiondataprovider;
        searchAlias = s;
    }

    public RetailSearchSuggestionFilter(ISuggestionDataProvider isuggestiondataprovider, String s, EditText edittext, RetailSearchEntryContext retailsearchentrycontext, RetailSearchSuggestionFilterListener retailsearchsuggestionfilterlistener, boolean flag)
    {
        this(isuggestiondataprovider, s, edittext, retailsearchentrycontext, retailsearchsuggestionfilterlistener);
        skipDepartmentResultsFromISS = flag;
    }

    private void appendBarcodeEntries(List list)
    {
        list.add(new RetailSearchSuggestionRow(searchEntryContext.voiceEnabled(), searchEntryContext.hasSnapIt(), searchEntryContext.isFlowEnabled(), searchEntryContext.showBarcodeIconForFlow(), searchEntryContext.showBarcodeEntry()));
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
                String s;
                if (TextUtils.isEmpty(suggestiondataitem1.getSearchAlias()))
                {
                    list1 = "aps";
                } else
                {
                    list1 = suggestiondataitem1.getSearchAlias();
                }
                if ("aps".equals(list1))
                {
                    s = null;
                } else
                {
                    s = suggestiondataitem1.getDepartmentName();
                }
                list.add(new RetailSearchSuggestionRow(suggestiondataitem1.getSuggestion(), list1, s, suggestiondataitem1.getDeleteURL(), suggestiondataitem1.getId(), suggestiondataitem1.getQuery(), suggestiondataitem1.getPos(), suggestiondataitem1.getXcatPos(), suggestiondataitem1.isSpellCorrectedValue(), suggestiondataitem1.isXcatValue(), suggestiondataitem1.isFallbackValue(), suggestiondataitem1.getType(), j, i));
            }
        }
    }

    protected android.widget.Filter.FilterResults performFiltering(final CharSequence constraint)
    {
        android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
        if (constraint == null)
        {
            return filterresults;
        }
        if (filterListener != null)
        {
            filterListener.beforePerformFiltering();
        }
        ArrayList arraylist = new ArrayList();
        if (searchEntryContext.hasActionItems() && TextUtils.isEmpty(searchEntryContext.getCurrentDepartmentName()) && (TextUtils.isEmpty(constraint) || searchEntryContext.isFirstTimeEnter()))
        {
            ArrayList arraylist1 = new ArrayList();
            appendBarcodeEntries(arraylist1);
            final android.widget.Filter.FilterResults barcodeResults = new android.widget.Filter.FilterResults();
            barcodeResults.count = arraylist.size();
            barcodeResults.values = new FilterResultValue(arraylist1, constraint.toString());
            platform.invokeLater(new Runnable() {

                final RetailSearchSuggestionFilter this$0;
                final android.widget.Filter.FilterResults val$barcodeResults;
                final CharSequence val$constraint;

                public void run()
                {
                    updateUI(constraint.toString(), barcodeResults, false);
                }

            
            {
                this$0 = RetailSearchSuggestionFilter.this;
                constraint = charsequence;
                barcodeResults = filterresults;
                super();
            }
            });
            appendBarcodeEntries(arraylist);
        }
        if (suggestionDataProvider != null)
        {
            boolean flag;
            synchronized (searchEntryContext)
            {
                flag = searchEntryContext.isForceUpdatePastSearches();
                searchEntryContext.setForceUpdatePastSearches(false);
            }
            appendSuggestionData(arraylist, suggestionDataProvider.getSuggestions(searchAlias, constraint.toString(), flag, skipDepartmentResultsFromISS));
        }
        if (filterListener != null)
        {
            filterListener.afterConstructRows(arraylist);
        }
        searchEntryContext.setFirstTimeEnter(false);
        filterresults.values = new FilterResultValue(arraylist, (String)constraint);
        filterresults.count = arraylist.size();
        return filterresults;
        constraint;
        retailsearchentrycontext;
        JVM INSTR monitorexit ;
        throw constraint;
    }

    protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
    {
        updateUI(charsequence.toString(), filterresults, true);
    }

    protected void updateUI(String s, android.widget.Filter.FilterResults filterresults, boolean flag)
    {
        if (filterresults != null && filterresults.values != null && Thread.currentThread().equals(Looper.getMainLooper().getThread())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        String s1;
        obj = (FilterResultValue)filterresults.values;
        filterresults = new ArrayList();
        for (Iterator iterator = ((FilterResultValue) (obj)).rows.iterator(); iterator.hasNext(); filterresults.add((RetailSearchSuggestionRow)iterator.next())) { }
        obj = ((FilterResultValue) (obj)).searchTerm;
        if (filterListener != null)
        {
            filterListener.beforePublishResults(filterresults, flag);
        }
        if (filterresults.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = searchBox.getText().toString();
        if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(((CharSequence) (obj))) && !s1.startsWith(((String) (obj))) && !((String) (obj)).startsWith(s1)) goto _L1; else goto _L3
_L3:
        if (filterListener == null) goto _L1; else goto _L4
_L4:
        filterListener.afterPublishResults(s, filterresults);
        return;
    }
}
