// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import roboguice.util.Strings;

public class ABTestListAdapter extends ArrayAdapter
{
    protected class ABTestFilter extends Filter
    {

        private List items;
        final ABTestListAdapter this$0;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            charsequence = charsequence.toString().toLowerCase();
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            ArrayList arraylist = new ArrayList();
            if (Strings.notEmpty(charsequence))
            {
                Iterator iterator = items.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if (s.toLowerCase().contains(charsequence))
                    {
                        arraylist.add(s);
                    }
                } while (true);
                filterresults.count = arraylist.size();
                filterresults.values = arraylist;
                return filterresults;
            } else
            {
                filterresults.count = items.size();
                filterresults.values = items;
                return filterresults;
            }
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            clear();
            addAll((List)filterresults.values);
            notifyDataSetChanged();
        }

        public ABTestFilter(List list)
        {
            this$0 = ABTestListAdapter.this;
            super();
            items = list;
        }
    }


    public static final String NO_RESPONSE = "No response from server";
    private Context context;
    private final Map currentOverrides = new HashMap();
    private final LayoutInflater inflater;
    private final List originalList = new ArrayList();
    private final Map serverStatus;
    private final Map unSavedOverrides = new HashMap();

    public ABTestListAdapter(Context context1, int i, List list, Map map, Map map1)
    {
        super(context1, i, list);
        context = context1;
        inflater = LayoutInflater.from(context1);
        originalList.addAll(list);
        currentOverrides.putAll(map);
        serverStatus = new HashMap(map1);
    }

    public void addOverride(String s, String s1)
    {
        unSavedOverrides.put(s, s1);
        notifyDataSetChanged();
    }

    public Filter getFilter()
    {
        return new ABTestFilter(originalList);
    }

    public int getNumberOfUnsavedChanges()
    {
        int i = 0;
        Iterator iterator = unSavedOverrides.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            String s = (String)unSavedOverrides.get(s1);
            if (currentOverrides.containsKey(s1))
            {
                s1 = (String)currentOverrides.get(s1);
                if (s == null || s != null && !s.equals(s1))
                {
                    i++;
                }
            } else
            if (s != null)
            {
                i++;
            }
        } while (true);
        return i;
    }

    public String getOverrideValue(String s)
    {
        if (unSavedOverrides.containsKey(s))
        {
            return (String)unSavedOverrides.get(s);
        } else
        {
            return (String)currentOverrides.get(s);
        }
    }

    public Map getUnsavedOverrides()
    {
        return unSavedOverrides;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s1 = (String)getItem(i);
        Object obj;
        String s;
        TextView textview;
        TextView textview1;
        TextView textview2;
        View view1;
        if (view != null)
        {
            viewgroup = view;
        } else
        {
            viewgroup = inflater.inflate(0x7f030018, viewgroup, false);
        }
        textview = (TextView)viewgroup.findViewById(0x7f100096);
        textview2 = (TextView)viewgroup.findViewById(0x7f100098);
        textview1 = (TextView)viewgroup.findViewById(0x7f10009a);
        obj = viewgroup.findViewById(0x7f100097);
        view1 = viewgroup.findViewById(0x7f100099);
        if (unSavedOverrides.containsKey(s1))
        {
            view = (String)unSavedOverrides.get(s1);
        } else
        {
            view = (String)currentOverrides.get(s1);
        }
        s = (String)serverStatus.get(s1);
        if (s1.equals("Disable"))
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
        if (s1.equals("Disable"))
        {
            i = 8;
        } else
        {
            i = 0;
        }
        view1.setVisibility(i);
        if (view == null)
        {
            obj = "No Override";
        } else
        {
            obj = view;
        }
        textview2.setText(((CharSequence) (obj)));
        obj = context.getResources();
        if (view == null)
        {
            i = 0x7f0e00d5;
        } else
        {
            i = 0x7f0e00c2;
        }
        textview2.setTextColor(((Resources) (obj)).getColor(i));
        view = s;
        if (s == null)
        {
            view = "No response from server";
        }
        textview1.setText(view);
        textview.setText(s1);
        return viewgroup;
    }

    public void restoreOverrides(HashMap hashmap)
    {
        if (hashmap != null)
        {
            unSavedOverrides.putAll(hashmap);
        }
    }
}
