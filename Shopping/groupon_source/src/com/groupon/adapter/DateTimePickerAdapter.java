// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.groupon.fragment.RapiSearchResultFragmentPresenter;
import java.util.List;

public class DateTimePickerAdapter extends BaseAdapter
{

    private int adapterId;
    private final Context context;
    private List dataList;
    private final LayoutInflater inflater;
    private RapiSearchResultFragmentPresenter rapiSearchResultFragmentPresenter;

    public DateTimePickerAdapter(int i, Context context1, List list, RapiSearchResultFragmentPresenter rapisearchresultfragmentpresenter)
    {
        adapterId = 0;
        context = context1;
        dataList = list;
        rapiSearchResultFragmentPresenter = rapisearchresultfragmentpresenter;
        adapterId = i;
        inflater = LayoutInflater.from(context1);
    }

    public int getCount()
    {
        if (dataList != null)
        {
            return dataList.size();
        } else
        {
            return 0;
        }
    }

    public com.groupon.fragment.RapiSearchResultFragmentPresenter.ValuePair getItem(int i)
    {
        if (dataList != null)
        {
            return (com.groupon.fragment.RapiSearchResultFragmentPresenter.ValuePair)dataList.get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getPosition(Integer integer)
    {
        for (int i = 0; i < dataList.size(); i++)
        {
            if (integer.equals(dataList.get(i)))
            {
                return i;
            }
        }

        return 0;
    }

    public int getSelectedPosition()
    {
        return rapiSearchResultFragmentPresenter.getSelectedPositionFor(adapterId);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        com.groupon.fragment.RapiSearchResultFragmentPresenter.ValuePair valuepair = (com.groupon.fragment.RapiSearchResultFragmentPresenter.ValuePair)dataList.get(i);
        View view1 = view;
        if (view == null)
        {
            view1 = inflater.inflate(0x7f0300bb, viewgroup, false);
        }
        view = (TextView)view1.findViewById(0x7f100208);
        view.setText(valuepair.displayValue);
        if (i == getSelectedPosition())
        {
            view.setTextColor(context.getResources().getColor(0x7f0e00ee));
            view.setTextSize(1, 19F);
            return view1;
        } else
        {
            view.setTextColor(context.getResources().getColor(0x7f0e00d7));
            view.setTextSize(1, 16F);
            return view1;
        }
    }

    public void setDataList(List list)
    {
        dataList = list;
        notifyDataSetChanged();
    }

    public void setSelectedPosition(int i, boolean flag)
    {
        rapiSearchResultFragmentPresenter.setSelectedPositionFor(adapterId, i);
        if (flag)
        {
            notifyDataSetChanged();
        }
    }
}
