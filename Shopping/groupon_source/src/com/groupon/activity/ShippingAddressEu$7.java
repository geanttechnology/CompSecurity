// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressEu

class val.countryNames extends ArrayAdapter
{

    final ShippingAddressEu this$0;
    final String val$countryNames[];

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            view = inflater;
            int j;
            if (isUSACompatible)
            {
                j = 0x7f03020b;
            } else
            {
                j = 0x7f030209;
            }
            viewgroup = view.inflate(j, null, false);
        }
        view = (TextView)viewgroup;
        view.setText(val$countryNames[i]);
        return view;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            view = inflater;
            int j;
            if (isUSACompatible)
            {
                j = 0x7f03020b;
            } else
            {
                j = 0x7f030209;
            }
            viewgroup = view.inflate(j, null, false);
        }
        view = (TextView)viewgroup;
        view.setText(val$countryNames[i]);
        return view;
    }

    (int i, String as[], String as1[])
    {
        this$0 = final_shippingaddresseu;
        val$countryNames = as1;
        super(Context.this, i, as);
    }
}
