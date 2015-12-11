// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public abstract class FilteringAdapter extends ArrayAdapter
{
    protected class ObjectFilter extends Filter
    {

        private List items;
        final FilteringAdapter this$0;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            charsequence = charsequence.toString().toLowerCase();
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            ArrayList arraylist = new ArrayList(items);
            if (Strings.notEmpty(charsequence))
            {
                for (int i = arraylist.size() - 1; i >= 0; i--)
                {
                    if (getStringRepresentation(arraylist.get(i)).toLowerCase().contains(charsequence))
                    {
                        arraylist.remove(i);
                    }
                }

            }
            filterresults.count = arraylist.size();
            filterresults.values = arraylist;
            return filterresults;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            clear();
            for (charsequence = ((List)filterresults.values).iterator(); charsequence.hasNext(); add(filterresults))
            {
                filterresults = ((android.widget.Filter.FilterResults) (charsequence.next()));
            }

            notifyDataSetChanged();
        }

        public ObjectFilter(List list)
        {
            this$0 = FilteringAdapter.this;
            super();
            items = list;
        }
    }


    protected final List originalObjects;

    public FilteringAdapter(Context context, int i, List list)
    {
        super(context, i, list);
        originalObjects = new ArrayList(list);
    }

    public Filter getFilter()
    {
        return new ObjectFilter(originalObjects);
    }

    protected abstract String getStringRepresentation(Object obj);
}
