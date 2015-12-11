// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.SuggestedSearchItem;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.view_holders.SearchSuggestionsViewHolder;

public class SearchSuggestionsAdapter extends CursorAdapter
{

    android.view.View.OnClickListener clearButtonListener;
    Context cntx;
    View footerView;

    public SearchSuggestionsAdapter(Context context, Cursor cursor, int i, android.view.View.OnClickListener onclicklistener)
    {
        super(context, cursor, i);
        cntx = context;
        clearButtonListener = onclicklistener;
    }

    private void addFooterClearButton(ListView listview)
    {
        if (listview.getHeaderViewsCount() == 0)
        {
            footerView = ((LayoutInflater)cntx.getSystemService("layout_inflater")).inflate(0x7f0300af, null);
            listview.setAdapter(null);
            listview.addHeaderView(footerView);
            listview.setAdapter(this);
            ((Button)footerView.findViewById(0x7f0c029b)).setOnClickListener(clearButtonListener);
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        context = (CustomMatrixCursor)cursor;
        context = (SuggestedSearchItem)context.get(context.getColumnIndex(PMData.DATA_COL));
        view = (SearchSuggestionsViewHolder)view.getTag();
        ((SearchSuggestionsViewHolder) (view)).searchSuggestion.setText(((SuggestedSearchItem) (context)).kw);
        if (GlobalDbController.getGlobalDbController().isBrand(((SuggestedSearchItem) (context)).kw))
        {
            context.type = "brand";
            ((SearchSuggestionsViewHolder) (view)).brandIndicatorLabel.setVisibility(0);
            return;
        } else
        {
            context.type = null;
            ((SearchSuggestionsViewHolder) (view)).brandIndicatorLabel.setVisibility(8);
            return;
        }
    }

    public CharSequence convertToString(Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        return ((SuggestedSearchItem)cursor.get(cursor.getColumnIndex(PMData.DATA_COL))).kw;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f0300b0, viewgroup, false);
        cursor = (ListView)viewgroup;
        cursor = new SearchSuggestionsViewHolder();
        cursor.searchSuggestion = (PMTextView)context.findViewById(0x7f0c029c);
        cursor.brandIndicatorLabel = (PMTextView)context.findViewById(0x7f0c029d);
        context.setTag(cursor);
        return context;
    }
}
