// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.ui.view.common.i;
import java.util.List;

// Referenced classes of package com.target.ui.view.account:
//            OrderSummaryView

public class OrderSummaryListView extends LinearLayout
    implements i
{

    private static final String TAG = com/target/ui/view/account/OrderSummaryListView.getSimpleName();

    public OrderSummaryListView(Context context)
    {
        super(context);
        a();
    }

    public OrderSummaryListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public OrderSummaryListView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        a();
    }

    private void a()
    {
        setOrientation(1);
    }

    public void a(List list, OrderSummaryView.a a1)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getContext());
        addView(layoutinflater.inflate(0x7f0300e2, this, false));
        for (int j = 0; j < list.size(); j++)
        {
            OrderSummary ordersummary = (OrderSummary)list.get(j);
            OrderSummaryView ordersummaryview = (OrderSummaryView)layoutinflater.inflate(0x7f030178, this, false);
            addView(ordersummaryview);
            ordersummaryview.a(ordersummary);
            ordersummaryview.setOrderSummaryClickListener(a1);
            if (j != list.size() - 1)
            {
                addView(layoutinflater.inflate(0x7f0300e0, this, false));
            }
        }

    }

    public View getView()
    {
        return this;
    }

}
