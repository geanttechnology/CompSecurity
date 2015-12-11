// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            ShippingAddress

class val.stringArray1 extends ArrayAdapter
{

    final ShippingAddress this$0;
    final String val$stringArray1[];
    final String val$stringArray2[];

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        int j;
        if (view == null)
        {
            view = inflater.inflate(0x1090009, null);
        }
        viewgroup = (TextView)(TextView)view;
        viewgroup.setTextSize(0, (int)getContext().getResources().getDimension(0x7f0b0065));
        j = (int)getContext().getResources().getDimension(0x7f0b0064);
        viewgroup.setPadding(j, j, j, j);
        if (val$stringArray2 != null)
        {
            view = val$stringArray2[i];
        } else
        {
            view = val$stringArray1[i];
        }
        viewgroup.setText(view);
        return viewgroup;
    }

    (String as[], String as1[], String as2[])
    {
        this$0 = final_shippingaddress;
        val$stringArray2 = as1;
        val$stringArray1 = as2;
        super(final_context, I.this, as);
    }
}
