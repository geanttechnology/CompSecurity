// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import org.cybergarage.upnp.Device;

public class DeviceListAdapter extends ArrayAdapter
{

    private Context context;
    private int curIndex;
    private List items;

    public DeviceListAdapter(Context context1, int i, List list)
    {
        super(context1, i, list);
        curIndex = -1;
        context = context1;
        items = list;
    }

    public Context getContext()
    {
        return context;
    }

    public int getCount()
    {
        return items.size();
    }

    public int getCurIndex()
    {
        return curIndex;
    }

    public Device getCurrentItem()
    {
        if (items != null && items.size() > 0 && curIndex >= 0 && curIndex < items.size())
        {
            return (Device)items.get(curIndex);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public Device getItem(int i)
    {
        return (Device)items.get(i);
    }

    public volatile int getPosition(Object obj)
    {
        return getPosition((Device)obj);
    }

    public int getPosition(Device device)
    {
        return items.indexOf(device);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        view = viewgroup;
        if (viewgroup == null)
        {
            view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030042, null);
        }
        viewgroup = (TextView)view.findViewById(0x7f0a00d2);
        if (viewgroup != null)
        {
            viewgroup.setText(((Device)items.get(i)).getFriendlyName());
        }
        viewgroup = (ImageView)view.findViewById(0x7f0a00d4);
        viewgroup.setVisibility(4);
        view.setClickable(false);
        if (i == curIndex)
        {
            viewgroup.setVisibility(0);
        }
        return view;
    }

    public void setCurIndex(int i)
    {
        curIndex = i;
    }

    public void unselectItem()
    {
        curIndex = -1;
    }
}
