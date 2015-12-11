// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

private class array extends BaseAdapter
{

    public List array;
    final ShippingAddressLATAM this$0;

    public int getCount()
    {
        return array.size();
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f030207, null, false);
        }
        view = (TextView)viewgroup;
        view.setText(getItemLabel(i));
        return view;
    }

    public com.groupon.models.shippingFields.X getItem(int i)
    {
        return (com.groupon.models.shippingFields.X)array.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public String getItemLabel(int i)
    {
        return getItem(i).X;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f030209, null, false);
        }
        view = (TextView)viewgroup;
        view.setText(getItemLabel(i));
        return view;
    }

    public (List list)
    {
        this$0 = ShippingAddressLATAM.this;
        super();
        array = list;
    }
}
