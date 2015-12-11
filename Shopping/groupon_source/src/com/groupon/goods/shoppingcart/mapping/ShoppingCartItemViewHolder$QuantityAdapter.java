// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.mapping;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.groupon.goods.shoppingcart.mapping:
//            ShoppingCartItemViewHolder

private static class  extends ArrayAdapter
{

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)super.getDropDownView(i, view, viewgroup);
        if (((Integer)getItem(i)).intValue() == 0)
        {
            view.setText(getContext().getString(0x7f080314));
        }
        return view;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)super.getView(i, view, viewgroup);
        viewgroup = (Integer)getItem(i);
        view.setText(getContext().getString(0x7f08009f, new Object[] {
            viewgroup
        }));
        return view;
    }

    public (Context context, int i, List list)
    {
        super(context, i, list);
    }
}
