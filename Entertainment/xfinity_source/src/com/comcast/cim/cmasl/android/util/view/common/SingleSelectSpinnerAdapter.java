// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class SingleSelectSpinnerAdapter extends BaseAdapter
    implements SpinnerAdapter
{

    private final LayoutInflater inflater;
    private final String items[];
    private int selectedItem;

    public int getCount()
    {
        return items.length;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = inflater.inflate(com.comcast.cim.cmasl.android.util.R.layout.single_select_spinner_drop_down_item, null);
        viewgroup = (TextView)view.findViewById(com.comcast.cim.cmasl.android.util.R.id.item_text);
        viewgroup.setText((String)getItem(i));
        if (i == selectedItem)
        {
            viewgroup.setSelected(true);
            return view;
        } else
        {
            viewgroup.setSelected(false);
            return view;
        }
    }

    public Object getItem(int i)
    {
        return items[i];
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public int getSelectedItem()
    {
        return selectedItem;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = inflater.inflate(com.comcast.cim.cmasl.android.util.R.layout.single_select_spinner_item, null);
        viewgroup = (String)getItem(i);
        ((TextView)view.findViewById(com.comcast.cim.cmasl.android.util.R.id.item_text)).setText(viewgroup);
        return view;
    }

    public void setSelectedItem(int i)
    {
        selectedItem = i;
    }
}
