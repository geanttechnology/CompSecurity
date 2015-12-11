// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            QuantitySwitcherDialog

private class maxQuantity extends BaseAdapter
{

    private final int DEFAULT_MAX_QUANTITY = 10;
    private int currentQuantity;
    private int maxQuantity;
    final QuantitySwitcherDialog this$0;

    public int getCount()
    {
        return maxQuantity + 1;
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(viewgroup.getContext()).inflate(com.amazon.retailsearch.itySwitcherAdapter, viewgroup, false);
        }
        ((TextView)view1.findViewById(com.amazon.retailsearch.itySwitcherAdapter)).setText(getItem(i).toString());
        view = view1.findViewById(com.amazon.retailsearch.itySwitcherAdapter.getItem);
        if (i == currentQuantity)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 4;
        }
        view.setVisibility(i);
        return view1;
    }

    public (int i, int j)
    {
        this$0 = QuantitySwitcherDialog.this;
        super();
        currentQuantity = i;
        if (j > -1)
        {
            maxQuantity = Math.min(10, j);
            maxQuantity = Math.max(maxQuantity, currentQuantity);
            return;
        } else
        {
            maxQuantity = 10;
            QuantitySwitcherDialog.access$000().error("Invalid stockOnHand. Uses default value:10");
            return;
        }
    }
}
