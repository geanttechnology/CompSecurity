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
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            ActionViewBuilder, RetailSearchSuggestionRow, SuggestionsItemListener, RetailSearchSuggestionFilter

public class RetailSearchSuggestionAdapter extends BaseAdapter
    implements Filterable
{

    private StyleSpan boldStyleSpan;
    private Context context;
    private RetailSearchSuggestionFilter filter;
    private boolean isCNJP;
    private final LayoutInflater layoutInflater;
    private SuggestionsItemListener listener;
    private Pattern pattern;
    private QuerySubmitListener querySubmitListener;
    private String searchTerm;
    private List suggestionRows;

    public RetailSearchSuggestionAdapter(Context context1, SuggestionsItemListener suggestionsitemlistener, QuerySubmitListener querysubmitlistener)
    {
        boolean flag1 = true;
        super();
        boldStyleSpan = new StyleSpan(1);
        RetailSearchDaggerGraphController.inject(this);
        layoutInflater = LayoutInflater.from(context1);
        context = context1;
        listener = suggestionsitemlistener;
        querySubmitListener = querysubmitlistener;
        context1 = SearchConfiguration.getConfiguration().getRealm().getLocale();
        boolean flag = flag1;
        if (!Locale.CHINA.toString().equals(context1))
        {
            if (Locale.JAPAN.toString().equals(context1))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        isCNJP = flag;
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
        ((LinearLayout)linearlayout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_suggestions)).setVisibility(8);
        context1 = (LinearLayout)linearlayout.findViewById(com.amazon.retailsearch.R.id.rs_entry_action);
        context1.setVisibility(0);
        context1 = new ActionViewBuilder(context1, querySubmitListener);
        context1.showVoice = retailsearchsuggestionrow.voiceEnabled();
        context1.showScan = retailsearchsuggestionrow.showBarcode();
        context1.showSnap = retailsearchsuggestionrow.hasSnap();
        context1.showFlow = retailsearchsuggestionrow.isFlowEnabled();
        context1.showVisualScan = retailsearchsuggestionrow.showVisualScan();
        context1.build();
    }

    private View updateItemView(Context context1, RetailSearchSuggestionRow retailsearchsuggestionrow, LinearLayout linearlayout)
    {
        if (android.os.Build.VERSION.SDK_INT > 10)
        {
            linearlayout.setAlpha(1.0F);
        } else
        {
            linearlayout.setVisibility(0);
        }
        if (RetailSearchSuggestionRow.RowType.ICON.equals(retailsearchsuggestionrow.getRowType()))
        {
            updateActionView(context1, retailsearchsuggestionrow, linearlayout);
            return linearlayout;
        } else
        {
            updateSuggestionItemView(context1, retailsearchsuggestionrow, linearlayout);
            return linearlayout;
        }
    }

    private void updateSuggestionItemView(Context context1, RetailSearchSuggestionRow retailsearchsuggestionrow, final LinearLayout layout)
    {
        ((LinearLayout)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_suggestions)).setVisibility(0);
        ((LinearLayout)layout.findViewById(com.amazon.retailsearch.R.id.rs_entry_action)).setVisibility(8);
        final String searchSuggestion = retailsearchsuggestionrow.getSuggestion();
        final Object id = (TextView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_text);
        ((TextView) (id)).setText(searchSuggestion);
        setSuggestionBold(((TextView) (id)), searchTerm);
        String s = retailsearchsuggestionrow.getSuggestionType().name();
        Object obj = (ImageView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_clear);
        if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.PAST_SEARCHES.name().equals(s) || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.name().equals(s))
        {
            ((TextView) (id)).setTextColor(context1.getResources().getColor(com.amazon.retailsearch.R.color.rs_search_iss_pastsearches));
            id = retailsearchsuggestionrow.getPastSearchId();
            final String deleteURL = retailsearchsuggestionrow.getDeleteUrl();
            ((ImageView) (obj)).setVisibility(0);
            ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final RetailSearchSuggestionAdapter this$0;
                final String val$deleteURL;
                final String val$id;
                final LinearLayout val$layout;

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
                        layout.startAnimation(view);
                        return;
                    } else
                    {
                        layout.setVisibility(8);
                        return;
                    }
                }

            
            {
                this$0 = RetailSearchSuggestionAdapter.this;
                id = s;
                deleteURL = s1;
                layout = linearlayout;
                super();
            }
            });
        } else
        {
            ((TextView) (id)).setTextColor(context1.getResources().getColor(0x106000c));
            ((ImageView) (obj)).setVisibility(8);
            if (listener != null)
            {
                listener.onA9SuggestionShow();
            }
        }
        obj = (TextView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_department);
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
        context1 = (ImageView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_query_builder);
        context1.setVisibility(0);
        context1.setOnClickListener(new android.view.View.OnClickListener() {

            final RetailSearchSuggestionAdapter this$0;
            final String val$searchSuggestion;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    listener.onQueryBuilderClick(searchSuggestion);
                }
            }

            
            {
                this$0 = RetailSearchSuggestionAdapter.this;
                searchSuggestion = s;
                super();
            }
        });
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        LinearLayout linearlayout = (LinearLayout)view;
        view = linearlayout;
        if (linearlayout == null)
        {
            view = (LinearLayout)layoutInflater.inflate(com.amazon.retailsearch.R.layout.rs_search_dropdown_item, viewgroup, false);
        }
        viewgroup = (RetailSearchSuggestionRow)suggestionRows.get(i);
        return updateItemView(context, viewgroup, view);
    }

    public void setFilter(RetailSearchSuggestionFilter retailsearchsuggestionfilter)
    {
        filter = retailsearchsuggestionfilter;
    }

    public void updateSuggestionContent(String s, List list)
    {
        searchTerm = s;
        suggestionRows = list;
        if (!TextUtils.isEmpty(s))
        {
            pattern = Pattern.compile((new StringBuilder()).append("(^|(?:\\s))").append(Pattern.quote(s.toLowerCase())).toString());
        }
    }

}
