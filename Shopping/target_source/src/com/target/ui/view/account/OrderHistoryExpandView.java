// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.target.ui.view.common.ExpandView;
import com.target.ui.view.common.i;
import java.util.List;

// Referenced classes of package com.target.ui.view.account:
//            OrderSummaryListView

public class OrderHistoryExpandView extends ExpandView
{

    public OrderHistoryExpandView(Context context)
    {
        super(context);
    }

    public OrderHistoryExpandView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public OrderHistoryExpandView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void a(String s)
    {
        setTitle(s);
    }

    public void a(List list, OrderSummaryView.a a1)
    {
        OrderSummaryListView ordersummarylistview = (OrderSummaryListView)LayoutInflater.from(getContext()).inflate(0x7f030179, this, false);
        setChildView(ordersummarylistview);
        ordersummarylistview.a(list, a1);
    }

    public void a(boolean flag)
    {
        setExpanded(flag);
    }

    protected void setChildView(OrderSummaryListView ordersummarylistview)
    {
        super.setChildView(ordersummarylistview);
    }

    protected volatile void setChildView(i i)
    {
        setChildView((OrderSummaryListView)i);
    }
}
