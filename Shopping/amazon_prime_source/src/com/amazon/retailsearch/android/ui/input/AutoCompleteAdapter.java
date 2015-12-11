// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.amazon.retailsearch.data.ISuggestionDataProvider;
import com.amazon.retailsearch.data.SuggestionDataItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AutoCompleteAdapter extends BaseAdapter
    implements Filterable
{
    final class SuggestionFilter extends Filter
    {

        private CharSequence mLastConstraint;
        final AutoCompleteAdapter this$0;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            Object obj = mSuggestionLock;
            obj;
            JVM INSTR monitorenter ;
            if (mSearchSuggestionProvider == null || charsequence == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            if (!charsequence.equals(mLastConstraint))
            {
                List list = mSearchSuggestionProvider.getSuggestions(charsequence.toString());
                filterresults.values = list;
                filterresults.count = list.size();
            }
            mLastConstraint = charsequence;
            obj;
            JVM INSTR monitorexit ;
            return filterresults;
            charsequence;
            obj;
            JVM INSTR monitorexit ;
            throw charsequence;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            mSuggestions.clear();
            if (filterresults.count > 0)
            {
                for (charsequence = ((List)filterresults.values).iterator(); charsequence.hasNext(); mSuggestions.add(filterresults))
                {
                    filterresults = (SuggestionDataItem)charsequence.next();
                }

            }
            notifyDataSetChanged();
        }

        SuggestionFilter()
        {
            this$0 = AutoCompleteAdapter.this;
            super();
        }
    }

    private class ViewHolder
    {

        TextView textView;
        final AutoCompleteAdapter this$0;

        private ViewHolder()
        {
            this$0 = AutoCompleteAdapter.this;
            super();
        }

    }


    private Filter mFilter;
    private final LayoutInflater mLayoutInflater;
    private ISuggestionDataProvider mSearchSuggestionProvider;
    private final Object mSuggestionLock = new Object();
    private final List mSuggestions = new ArrayList();

    AutoCompleteAdapter(Context context)
    {
        mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        mFilter = new SuggestionFilter();
    }

    public int getCount()
    {
        return mSuggestions.size();
    }

    public Filter getFilter()
    {
        return mFilter;
    }

    public Object getItem(int i)
    {
        return mSuggestions.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        SuggestionDataItem suggestiondataitem;
        if (view == null)
        {
            view = mLayoutInflater.inflate(0x109000a, null);
            viewgroup = new ViewHolder();
            viewgroup.textView = (TextView)view.findViewById(0x1020014);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        suggestiondataitem = (SuggestionDataItem)mSuggestions.get(i);
        if (suggestiondataitem != null)
        {
            ((ViewHolder) (viewgroup)).textView.setText(suggestiondataitem.getDisplayText());
        }
        return view;
    }

    public void setSearchSuggestionProvider(ISuggestionDataProvider isuggestiondataprovider)
    {
        synchronized (mSuggestionLock)
        {
            mSearchSuggestionProvider = isuggestiondataprovider;
        }
        return;
        isuggestiondataprovider;
        obj;
        JVM INSTR monitorexit ;
        throw isuggestiondataprovider;
    }



}
