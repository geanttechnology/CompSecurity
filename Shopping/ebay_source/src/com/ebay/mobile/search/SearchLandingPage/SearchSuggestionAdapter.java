// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.model.AutoFillSuggestion;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchPrefixType

public class SearchSuggestionAdapter extends ArrayAdapter
    implements android.view.View.OnClickListener
{
    public static class SearchSuggestionInfo
    {

        long categoryId;
        String categoryName;
        boolean isUserSearch;
        String query;
        String userQuery;

        public SearchSuggestionInfo()
        {
            query = "";
            userQuery = "";
            categoryName = "";
            categoryId = 0L;
        }
    }

    public static interface SearchSuggestionListener
    {

        public abstract void onSearchQueryRefinementSelected(SearchSuggestionInfo searchsuggestioninfo);

        public abstract void onSearchQuerySubmitted(SearchSuggestionInfo searchsuggestioninfo);
    }

    private static class ViewHolder
    {

        ImageView refinementIcon;
        TextView text;

        private ViewHolder()
        {
        }

    }


    private String lastQueryUsed;
    private final SearchSuggestionListener listener;
    private List suggestionList;

    public SearchSuggestionAdapter(Context context, SearchSuggestionListener searchsuggestionlistener)
    {
        super(context, 0);
        suggestionList = new ArrayList();
        lastQueryUsed = "";
        listener = searchsuggestionlistener;
    }

    public int getCount()
    {
        int i;
        if (suggestionList != null)
        {
            i = suggestionList.size();
        } else
        {
            i = 0;
        }
        return i + 1;
    }

    public AutoFillSuggestion getItem(int i)
    {
        if (suggestionList != null && i < suggestionList.size())
        {
            return (AutoFillSuggestion)suggestionList.get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        SearchSuggestionInfo searchsuggestioninfo;
        AutoFillSuggestion autofillsuggestion;
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(getContext(), 0x7f0301ec, null);
            viewgroup.refinementIcon = (ImageView)view.findViewById(0x7f100617);
            viewgroup.text = (TextView)view.findViewById(0x7f100618);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).text.setOnClickListener(this);
        searchsuggestioninfo = new SearchSuggestionInfo();
        autofillsuggestion = getItem(i);
        if (autofillsuggestion != null)
        {
            i = lastQueryUsed.length();
            int j = autofillsuggestion.title.length();
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(autofillsuggestion.title);
            if (i <= autofillsuggestion.title.length())
            {
                spannablestringbuilder.setSpan(new StyleSpan(1), i, j, 17);
            }
            if (!TextUtils.isEmpty(autofillsuggestion.categoryName))
            {
                spannablestringbuilder.append("\n");
                spannablestringbuilder.append(autofillsuggestion.categoryName);
                spannablestringbuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(0x7f0d00e7)), j, spannablestringbuilder.length(), 18);
                spannablestringbuilder.setSpan(new RelativeSizeSpan(0.7F), j, spannablestringbuilder.length(), 18);
            }
            ((ViewHolder) (viewgroup)).text.setText(spannablestringbuilder);
            ((ViewHolder) (viewgroup)).text.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            ((ViewHolder) (viewgroup)).refinementIcon.setVisibility(0);
            searchsuggestioninfo.isUserSearch = false;
            searchsuggestioninfo.query = autofillsuggestion.title;
            searchsuggestioninfo.userQuery = lastQueryUsed;
            if (!TextUtils.isEmpty(autofillsuggestion.categoryId))
            {
                searchsuggestioninfo.categoryId = Long.valueOf(autofillsuggestion.categoryId).longValue();
            }
            searchsuggestioninfo.categoryName = autofillsuggestion.categoryName;
            ((ViewHolder) (viewgroup)).refinementIcon.setTag(searchsuggestioninfo);
            ((ViewHolder) (viewgroup)).text.setTag(searchsuggestioninfo);
            ((ViewHolder) (viewgroup)).refinementIcon.setOnClickListener(this);
        } else
        if (i == getCount() - 1)
        {
            ((ViewHolder) (viewgroup)).refinementIcon.setVisibility(4);
            Object obj = getContext().getString(0x7f07095e);
            i = ((String) (obj)).length();
            obj = new SpannableStringBuilder(((CharSequence) (obj)));
            ((SpannableStringBuilder) (obj)).append("\n");
            ((SpannableStringBuilder) (obj)).append(lastQueryUsed);
            ((SpannableStringBuilder) (obj)).setSpan(new ForegroundColorSpan(getContext().getResources().getColor(0x7f0d00e7)), i, ((SpannableStringBuilder) (obj)).length(), 18);
            ((SpannableStringBuilder) (obj)).setSpan(new RelativeSizeSpan(0.7F), i, ((SpannableStringBuilder) (obj)).length(), 18);
            ((ViewHolder) (viewgroup)).text.setCompoundDrawablesWithIntrinsicBounds(0x7f020240, 0, 0, 0);
            ((ViewHolder) (viewgroup)).text.setText(((CharSequence) (obj)));
            searchsuggestioninfo.isUserSearch = true;
            searchsuggestioninfo.query = lastQueryUsed;
            searchsuggestioninfo.userQuery = lastQueryUsed;
            ((ViewHolder) (viewgroup)).text.setTag(searchsuggestioninfo);
            return view;
        }
        return view;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131756567 2131756568: default 28
    //                   2131756567 29
    //                   2131756568 59;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        view = (SearchSuggestionInfo)view.getTag();
        if (listener != null && view != null)
        {
            listener.onSearchQueryRefinementSelected(view);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        view = (SearchSuggestionInfo)view.getTag();
        if (listener != null && view != null)
        {
            listener.onSearchQuerySubmitted(view);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void updateSuggestionList(List list, String s)
    {
        if (list != null)
        {
            String s1;
            if (TextUtils.isEmpty(s))
            {
                s = "";
            }
            s1 = SearchPrefixType.SELLER.getName();
            if (s.regionMatches(true, 0, s1, 0, s1.length()))
            {
                lastQueryUsed = s.substring(s1.length());
            } else
            {
                lastQueryUsed = s;
            }
            suggestionList = list;
            notifyDataSetChanged();
        }
    }
}
