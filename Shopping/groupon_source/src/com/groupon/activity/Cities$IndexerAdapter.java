// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import roboguice.util.Strings;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

// Referenced classes of package com.groupon.activity:
//            Cities

class sections extends ArrayAdapter
    implements SectionIndexer, StickyListHeadersAdapter
{
    private class DivisionFilter extends Filter
    {

        private List items;
        final Cities.IndexerAdapter this$1;

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
                    String s = ((Division)listiterator.next()).name;
                    if (!Cities.access$1100(this$0).getDisplayName(s).toLowerCase().contains(charsequence))
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
            for (charsequence = ((List)filterresults.values).iterator(); charsequence.hasNext(); add(filterresults))
            {
                filterresults = (Division)charsequence.next();
            }

            notifyDataSetChanged();
        }

        public DivisionFilter(List list)
        {
            this$1 = Cities.IndexerAdapter.this;
            super();
            items = list;
        }
    }


    private HashMap alphaIndexer;
    private List originalObjects;
    private int sectioner[];
    private String sections[];
    final Cities this$0;

    public Filter getFilter()
    {
        return new DivisionFilter(originalObjects);
    }

    public long getHeaderId(int i)
    {
        Object obj = (Division)getItem(i);
        if (Cities.access$700(Cities.this).getCurrentCountry().shouldUseDivisionAsHeader())
        {
            return (long)((Division) (obj)).parent.id.hashCode();
        }
        obj = ((Division) (obj)).name;
        if (((String) (obj)).length() > 0)
        {
            obj = ((String) (obj)).substring(0, 1);
        } else
        {
            obj = "";
        }
        return (long)((String) (obj)).hashCode();
    }

    public View getHeaderView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            TextView textview;
            int j;
            if (Cities.access$700(Cities.this).getCurrentCountry().isJapan())
            {
                j = 0x7f03014b;
            } else
            {
                j = 0x7f030064;
            }
            view1 = Cities.access$900(Cities.this).inflate(j, viewgroup, false);
        }
        viewgroup = (Division)getItem(i);
        view = ((Division) (viewgroup)).name;
        if (view.length() > 0)
        {
            view = view.substring(0, 1);
        } else
        {
            view = "";
        }
        textview = (TextView)view1.findViewById(0x7f1001a1);
        if (((Division) (viewgroup)).parent == null)
        {
            viewgroup = "";
        } else
        {
            viewgroup = ((Division) (viewgroup)).parent.name;
        }
        if (!Cities.access$700(Cities.this).getCurrentCountry().shouldUseDivisionAsHeader())
        {
            viewgroup = view;
        }
        textview.setText(viewgroup);
        return view1;
    }

    public int getPositionForSection(int i)
    {
        String s = sections[i];
        return ((Integer)alphaIndexer.get(s)).intValue();
    }

    public int getSectionForPosition(int i)
    {
        i = sectioner[i];
        if (i > -1)
        {
            return i;
        } else
        {
            return 0;
        }
    }

    public Object[] getSections()
    {
        return sections;
    }

    public DivisionFilter.items(Context context, int i, List list)
    {
        this$0 = Cities.this;
        super(context, i, list);
        originalObjects = new ArrayList(list);
        alphaIndexer = new HashMap();
        sectioner = new int[list.size()];
        i = -1;
        int k = 0;
        while (k < list.size()) 
        {
            cities = (Division)list.get(k);
            if (hasParent())
            {
                sectioner[k] = i;
            } else
            {
                cities = name.substring(0, 1);
                int j = i;
                if (!alphaIndexer.containsKey(Cities.this))
                {
                    j = i + 1;
                    alphaIndexer.put(Cities.this, Integer.valueOf(k));
                }
                sectioner[k] = j;
                i = j;
            }
            k++;
        }
        cities = new ArrayList(alphaIndexer.keySet());
        Collections.sort(Cities.this);
        sections = new String[size()];
        toArray(sections);
    }
}
