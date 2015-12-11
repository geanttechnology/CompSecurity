// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import android.widget.Adapter;
import com.groupon.util.MergeAdapter;

public class ShoppingCartMergeAdapter extends MergeAdapter
{

    public static final int SHOPPING_CART_ADAPTER_POSITION = 0;
    public static final int WIDGET_ADAPTER_POSITION = 1;
    private boolean isUSACompatible;

    public ShoppingCartMergeAdapter(boolean flag, Adapter aadapter[])
    {
        super(aadapter);
        isUSACompatible = flag;
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    protected int chooseAdapter(int i)
    {
        Adapter adapter = adapters[1];
        for (Adapter adapter1 = adapters[0]; !isUSACompatible || adapter.getCount() == 0 || i < adapter1.getCount();)
        {
            return 0;
        }

        return 1;
    }

    public boolean isEnabled(int i)
    {
        boolean flag = false;
        if (getDelegateAdapter(i) == adapters[0])
        {
            flag = true;
        }
        return flag;
    }
}
