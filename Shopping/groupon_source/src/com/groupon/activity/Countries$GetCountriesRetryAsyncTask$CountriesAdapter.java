// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.groupon.models.country.Country;
import com.groupon.util.CountryUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Countries

private class this._cls1 extends ArrayAdapter
{
    class CountryNameFilter extends Filter
    {

        private List items;
        final Countries.GetCountriesRetryAsyncTask.CountriesAdapter this$2;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            charsequence = charsequence.toString().toLowerCase();
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            ArrayList arraylist = new ArrayList(items);
            if (Strings.notEmpty(charsequence))
            {
                ListIterator listiterator = arraylist.listIterator();
                do
                {
                    if (!listiterator.hasNext())
                    {
                        break;
                    }
                    String s = ((Country)listiterator.next()).shortName;
                    if (!Countries.GetCountriesRetryAsyncTask.access$900(this$1).getDisplayName(s).toLowerCase().contains(charsequence))
                    {
                        listiterator.remove();
                    }
                } while (true);
            }
            filterresults.count = arraylist.size();
            filterresults.values = arraylist;
            return filterresults;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            clear();
            addAll((List)filterresults.values);
            notifyDataSetChanged();
        }

        public CountryNameFilter(List list)
        {
            this$2 = Countries.GetCountriesRetryAsyncTask.CountriesAdapter.this;
            super();
            items = list;
        }
    }


    final this._cls1 this$1;

    public Filter getFilter()
    {
        return new CountryNameFilter(Countries.access$100(this._cls1.this.CountryNameFilter));
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s = ((Country)getItem(i)).shortName;
        if (view == null)
        {
            view = Countries.access$700(getItem).inflate(0x7f030063, viewgroup, false);
        }
        ((TextView)view.findViewById(0x7f100078)).setText(getItem(this._cls1.this).getDisplayName(s));
        return view;
    }

    public CountryNameFilter.items()
    {
        this$1 = this._cls1.this;
        super(_fld1, 0x1090008, new ArrayList(Countries.access$100(_fld1)));
    }
}
