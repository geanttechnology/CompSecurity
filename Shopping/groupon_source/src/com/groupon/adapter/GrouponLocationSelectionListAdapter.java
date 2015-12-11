// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;

public class GrouponLocationSelectionListAdapter extends ArrayAdapter
{
    private static class LocationViewHolder
    {

        public ProgressBar itemProgress;
        public TextView locationAddress;

        private LocationViewHolder()
        {
        }

    }


    private boolean allItemsEnabled;
    private final LayoutInflater layoutInflater;
    private int progressItemIndex;
    private boolean showItemProgressIndicator;

    public GrouponLocationSelectionListAdapter(Context context, int i, List list)
    {
        super(context, i, list);
        allItemsEnabled = true;
        progressItemIndex = -1;
        layoutInflater = LayoutInflater.from(context);
    }

    public boolean areAllItemsEnabled()
    {
        return allItemsEnabled;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = layoutInflater.inflate(0x7f030129, viewgroup, false);
            viewgroup = new LocationViewHolder();
            viewgroup.locationAddress = (TextView)view.findViewById(0x7f100369);
            viewgroup.itemProgress = (ProgressBar)view.findViewById(0x7f10036a);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (LocationViewHolder)view.getTag();
        }
        ((LocationViewHolder) (viewgroup)).locationAddress.setText((CharSequence)getItem(i));
        viewgroup = ((LocationViewHolder) (viewgroup)).itemProgress;
        if (showItemProgressIndicator && progressItemIndex == i)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        viewgroup.setVisibility(i);
        return view;
    }

    public boolean isEnabled(int i)
    {
        return areAllItemsEnabled();
    }

    public void setAllItemsEnabled(boolean flag)
    {
        allItemsEnabled = flag;
    }

    public void setProgressItemIndex(int i)
    {
        progressItemIndex = i;
    }

    public void setShowItemProgressIndicator(boolean flag)
    {
        showItemProgressIndicator = flag;
    }
}
