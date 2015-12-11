// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.ViewHolder;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.PrefetchingManager;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.metrics.IssLogger;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            ActionViewBuilder, RetailSearchSuggestionRow, SuggestionTextView, RetailSearchEntryContext, 
//            RetailSearchSuggestionFilter, SuggestionsItemListener, DisplayStateChangeListener

public class RetailSearchSuggestionAdapter extends BaseAdapter
    implements Filterable
{
    public class ISSViewType
    {

        public static final int ACTION_ROW = 0;
        public static final int SUGGESTION_ROW = 1;
        final RetailSearchSuggestionAdapter this$0;

        public ISSViewType()
        {
            this$0 = RetailSearchSuggestionAdapter.this;
            super();
        }
    }


    private static final int ISS_VIEW_TYPE_COUNT = 2;
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter);
    private final StyleSpan boldStyleSpan = new StyleSpan(1);
    private final Context context;
    private final RetailSearchEntryContext entryContext;
    private final RetailSearchSuggestionFilter filter;
    private boolean hasActionRow;
    private final boolean isCNJP;
    private final LayoutInflater layoutInflater;
    private final SuggestionsItemListener listener;
    private Pattern pattern;
    PrefetchingManager prefetchingManager;
    private final QuerySubmitListener querySubmitListener;
    private String searchTerm;
    private List suggestionRows;

    public RetailSearchSuggestionAdapter(Context context1, SuggestionsItemListener suggestionsitemlistener, QuerySubmitListener querysubmitlistener, RetailSearchEntryContext retailsearchentrycontext, RetailSearchSuggestionFilter retailsearchsuggestionfilter)
    {
        boolean flag = false;
        super();
        hasActionRow = false;
        RetailSearchDaggerGraphController.inject(this);
        layoutInflater = LayoutInflater.from(context1);
        context = context1;
        listener = suggestionsitemlistener;
        querySubmitListener = querysubmitlistener;
        entryContext = retailsearchentrycontext;
        filter = retailsearchsuggestionfilter;
        context1 = SearchConfiguration.getConfiguration().getRealm().getLocale();
        if (Locale.CHINA.toString().equals(context1) || Locale.JAPAN.toString().equals(context1))
        {
            flag = true;
        }
        isCNJP = flag;
    }

    private View getActionView(RetailSearchSuggestionRow retailsearchsuggestionrow, View view, ViewGroup viewgroup)
    {
        LinearLayout linearlayout = (LinearLayout)view;
        if (view == null)
        {
            linearlayout = (LinearLayout)layoutInflater.inflate(com.amazon.retailsearch.R.layout.rs_iss_row_action, viewgroup, false);
        }
        hasActionRow = true;
        updateActionView(context, retailsearchsuggestionrow, linearlayout);
        return linearlayout;
    }

    private View getSuggestionView(RetailSearchSuggestionRow retailsearchsuggestionrow, int i, View view, ViewGroup viewgroup)
    {
        LinearLayout linearlayout = (LinearLayout)view;
        view = linearlayout;
        if (linearlayout == null)
        {
            view = (LinearLayout)layoutInflater.inflate(com.amazon.retailsearch.R.layout.rs_iss_row_suggestion, viewgroup, false);
        }
        updateSuggestionItemView(context, retailsearchsuggestionrow, view, i);
        return view;
    }

    private void setSuggestionBold(TextView textview, String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        int i;
        byte byte0;
        obj = textview.getText().toString();
        byte0 = -1;
        if (!isCNJP)
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((String) (obj)).toLowerCase().indexOf(s.toLowerCase());
_L4:
        if (i > -1)
        {
            obj = new SpannableString(((CharSequence) (obj)));
            ((SpannableString) (obj)).setSpan(boldStyleSpan, i, s.length() + i, 18);
            textview.setText(((CharSequence) (obj)));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        i = byte0;
        if (pattern != null)
        {
            Matcher matcher = pattern.matcher(((String) (obj)).toLowerCase());
            i = byte0;
            if (matcher.find())
            {
                i = matcher.end(1);
            }
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void updateActionView(Context context1, RetailSearchSuggestionRow retailsearchsuggestionrow, LinearLayout linearlayout)
    {
        context1 = new ActionViewBuilder(linearlayout, querySubmitListener);
        context1.showVoice = retailsearchsuggestionrow.voiceEnabled();
        context1.showScan = retailsearchsuggestionrow.showBarcode();
        context1.showSnap = retailsearchsuggestionrow.hasSnap();
        context1.showFlow = retailsearchsuggestionrow.isFlowEnabled();
        context1.showBarcodeIconForFlow = retailsearchsuggestionrow.showBarcodeIconForFlow();
        context1.build();
    }

    private void updateSuggestionItemView(Context context1, RetailSearchSuggestionRow retailsearchsuggestionrow, final LinearLayout rowLayout, final int position)
    {
        SuggestionTextView suggestiontextview = (SuggestionTextView)ViewHolder.get(rowLayout, com.amazon.retailsearch.R.id.rs_search_dropdown_item_text);
        final String searchSuggestion = retailsearchsuggestionrow.getSuggestion();
        suggestiontextview.setText(searchSuggestion);
        setSuggestionBold(suggestiontextview, searchTerm);
        String s = retailsearchsuggestionrow.getSuggestionType().name();
        Object obj = (ImageView)ViewHolder.get(rowLayout, com.amazon.retailsearch.R.id.rs_search_dropdown_item_clear);
        final boolean isA9Suggestion;
        if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.PAST_SEARCHES.name().equals(s) || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.name().equals(s))
        {
            suggestiontextview.setTextColor(context1.getResources().getColor(com.amazon.retailsearch.R.color.rs_search_iss_pastsearches));
            final String id = retailsearchsuggestionrow.getPastSearchId();
            final String deleteURL = retailsearchsuggestionrow.getDeleteUrl();
            ((ImageView) (obj)).setVisibility(0);
            ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final RetailSearchSuggestionAdapter this$0;
                final String val$deleteURL;
                final String val$id;
                final LinearLayout val$rowLayout;

                public void onClick(View view)
                {
                    if (listener != null)
                    {
                        listener.onDeletePastSearchesClick(id, deleteURL);
                    }
                    if (android.os.Build.VERSION.SDK_INT > 10)
                    {
                        view = new AlphaAnimation(1.0F, 0.0F);
                        view.setDuration(500L);
                        view.setRepeatCount(0);
                        view.setFillAfter(false);
                        rowLayout.startAnimation(view);
                        return;
                    } else
                    {
                        rowLayout.setVisibility(8);
                        return;
                    }
                }

            
            {
                this$0 = RetailSearchSuggestionAdapter.this;
                id = s;
                deleteURL = s1;
                rowLayout = linearlayout;
                super();
            }
            });
        } else
        {
            suggestiontextview.setTextColor(context1.getResources().getColor(0x106000c));
            ((ImageView) (obj)).setVisibility(8);
        }
        obj = (TextView)ViewHolder.get(rowLayout, com.amazon.retailsearch.R.id.rs_search_dropdown_item_department);
        retailsearchsuggestionrow = retailsearchsuggestionrow.getDepartment();
        if (!TextUtils.isEmpty(retailsearchsuggestionrow))
        {
            context1 = context1.getResources().getString(com.amazon.retailsearch.R.string.rs_search_suggestions_department_text, new Object[] {
                retailsearchsuggestionrow
            });
            ((TextView) (obj)).setVisibility(0);
            ((TextView) (obj)).setText(context1);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        context1 = (ImageView)ViewHolder.get(rowLayout, com.amazon.retailsearch.R.id.rs_search_dropdown_item_query_builder);
        context1.setVisibility(0);
        context1.setOnClickListener(new android.view.View.OnClickListener() {

            final RetailSearchSuggestionAdapter this$0;
            final int val$position;
            final String val$searchSuggestion;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    listener.onQueryBuilderClick(searchSuggestion);
                }
                view = generateQuery(position);
                prefetchingManager.prefetchForQueryBuilder(view);
            }

            
            {
                this$0 = RetailSearchSuggestionAdapter.this;
                searchSuggestion = s;
                position = i;
                super();
            }
        });
        if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.A9_SUGGESTION.name().equals(s) || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.name().equals(s))
        {
            isA9Suggestion = true;
        } else
        {
            isA9Suggestion = false;
        }
        suggestiontextview.setDisplayStateChangeListener(new DisplayStateChangeListener() {

            final RetailSearchSuggestionAdapter this$0;
            final boolean val$isA9Suggestion;
            final int val$position;

            public void onHide()
            {
                prefetchingManager.cancelPreviousISSPrefetchingRequests();
            }

            public void onShow()
            {
                if (listener != null && isA9Suggestion)
                {
                    listener.onA9SuggestionShow();
                }
                if (prefetchingManager.isPrefetchingEnabled() && !prefetchingManager.isOutOfBudget() && suggestionRows.size() > position)
                {
                    RetailSearchQuery retailsearchquery = generateQuery(position);
                    PrefetchingManager prefetchingmanager = prefetchingManager;
                    int i;
                    if (hasActionRow)
                    {
                        i = position - 1;
                    } else
                    {
                        i = position;
                    }
                    prefetchingmanager.prefetchForISS(retailsearchquery, i);
                }
            }

            
            {
                this$0 = RetailSearchSuggestionAdapter.this;
                isA9Suggestion = flag;
                position = i;
                super();
            }
        });
    }

    public RetailSearchQuery generateQuery(int i)
    {
        Object obj = (RetailSearchSuggestionRow)suggestionRows.get(i);
        String s1 = ((RetailSearchSuggestionRow) (obj)).getSuggestion();
        String s2 = ((RetailSearchSuggestionRow) (obj)).getSearchAlias();
        String s = ((RetailSearchSuggestionRow) (obj)).getQuery();
        obj = new RetailSearchQuery(s2, s1, s, IssLogger.createLogData(((RetailSearchSuggestionRow) (obj)), entryContext.getSearchAlias(), s2, s1, s));
        try
        {
            ((RetailSearchQuery) (obj)).setRefTag(IssLogger.computeSelectRefTag(suggestionRows, i, s));
        }
        catch (Exception exception)
        {
            log.error("exception occurred while calculating the ISS selection ref-tag", exception);
            return ((RetailSearchQuery) (obj));
        }
        return ((RetailSearchQuery) (obj));
    }

    public int getCount()
    {
        if (suggestionRows == null)
        {
            return 0;
        } else
        {
            return suggestionRows.size();
        }
    }

    public Filter getFilter()
    {
        return filter;
    }

    public Object getItem(int i)
    {
        if (suggestionRows == null)
        {
            return null;
        } else
        {
            return (RetailSearchSuggestionRow)suggestionRows.get(i);
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        if (suggestionRows == null || suggestionRows.size() <= i)
        {
            log.error((new StringBuilder()).append("getItemViewType called for invalid position (").append(i).append(")").toString());
            return -1;
        }
        RetailSearchSuggestionRow.RowType rowtype = ((RetailSearchSuggestionRow)suggestionRows.get(i)).getRowType();
        if (rowtype == null)
        {
            log.error((new StringBuilder()).append("the rowType of row ").append(i).append(" is not set").toString());
            return -1;
        } else
        {
            return rowtype.getViewType();
        }
    }

    public List getSuggestionRows()
    {
        return suggestionRows;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        RetailSearchSuggestionRow retailsearchsuggestionrow;
        if (suggestionRows == null || suggestionRows.size() <= i)
        {
            log.error((new StringBuilder()).append("getView called for invalid position (").append(i).append(")").toString());
            return view;
        }
        retailsearchsuggestionrow = (RetailSearchSuggestionRow)suggestionRows.get(i);
        Object obj;
        int j;
        if (retailsearchsuggestionrow.getRowType() != null)
        {
            j = retailsearchsuggestionrow.getRowType().getViewType();
        } else
        {
            j = -1;
        }
        obj = null;
        j;
        JVM INSTR tableswitch 0 1: default 116
    //                   0 170
    //                   1 182;
           goto _L1 _L2 _L3
_L1:
        viewgroup = obj;
_L5:
        if (viewgroup == null)
        {
            log.error((new StringBuilder()).append("getView called for invalid view. position = ").append(i).append(", viewType = ").append(j).toString());
            return view;
        }
        break; /* Loop/switch isn't completed */
_L2:
        viewgroup = getActionView(retailsearchsuggestionrow, view, viewgroup);
        continue; /* Loop/switch isn't completed */
_L3:
        viewgroup = getSuggestionView(retailsearchsuggestionrow, i, view, viewgroup);
        if (true) goto _L5; else goto _L4
_L4:
        if (android.os.Build.VERSION.SDK_INT > 10)
        {
            viewgroup.setAlpha(1.0F);
        } else
        {
            viewgroup.setVisibility(0);
        }
        return viewgroup;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public void updateSuggestionContent(String s, List list)
    {
        searchTerm = s;
        suggestionRows = list;
        hasActionRow = false;
        if (!TextUtils.isEmpty(s))
        {
            pattern = Pattern.compile((new StringBuilder()).append("(^|(?:\\s))").append(Pattern.quote(s.toLowerCase())).toString());
        }
    }




}
