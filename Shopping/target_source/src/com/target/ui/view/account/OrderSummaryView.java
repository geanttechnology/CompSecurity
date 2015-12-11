// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.model.guest.interfaces.OrderSummaryProduct;
import com.target.ui.util.j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.ui.view.account:
//            OrderSummaryProductView

public class OrderSummaryView extends FrameLayout
    implements android.view.View.OnClickListener
{
    static class Views
    {

        TextView orderDate;
        LinearLayout orderList;
        TextView orderNumber;

        Views(View view)
        {
            ButterKnife.bind(this, view);
        }
    }

    public static interface a
    {

        public abstract void b(OrderSummary ordersummary);
    }


    private static final String TAG = com/target/ui/view/account/OrderSummaryView.getSimpleName();
    private a mClickListener;
    private OrderSummary mOrderSummary;
    private Views mViews;

    public OrderSummaryView(Context context)
    {
        super(context);
        a(context);
    }

    public OrderSummaryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public OrderSummaryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private Drawable a(int i)
    {
        return getResources().getDrawable(i);
    }

    private String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
            return getResources().getString(0x7f0900ad, new Object[] {
                simpledateformat.format(date)
            });
        }
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030177, this);
        mViews = new Views(this);
        setOnClickListener(this);
        if (j.b())
        {
            context = b(0x7f020231);
        } else
        {
            context = a(0x7f020231);
        }
        setForeground(context);
    }

    private Drawable b(int i)
    {
        return getResources().getDrawable(i, null);
    }

    private int getSecondToLastChildViewIndex()
    {
        return mViews.orderList.getChildCount() - 1;
    }

    public void a(OrderSummary ordersummary)
    {
        mOrderSummary = ordersummary;
        List list = ordersummary.c();
        LayoutInflater layoutinflater = LayoutInflater.from(getContext());
        for (int i = 0; i < list.size(); i++)
        {
            OrderSummaryProduct ordersummaryproduct = (OrderSummaryProduct)list.get(i);
            OrderSummaryProductView ordersummaryproductview = (OrderSummaryProductView)layoutinflater.inflate(0x7f03017b, this, false);
            mViews.orderList.addView(ordersummaryproductview, getSecondToLastChildViewIndex());
            if (i != list.size() - 1)
            {
                View view = layoutinflater.inflate(0x7f030023, mViews.orderList, false);
                mViews.orderList.addView(view, getSecondToLastChildViewIndex());
            }
            ordersummaryproductview.a(ordersummaryproduct);
        }

        mViews.orderDate.setText(a(ordersummary.b()));
        mViews.orderNumber.setText(getResources().getString(0x7f0900ac, new Object[] {
            ordersummary.a()
        }));
    }

    public void onClick(View view)
    {
        if (mClickListener != null)
        {
            mClickListener.b(mOrderSummary);
        }
    }

    protected void onLayout(boolean flag, int i, int k, int l, int i1)
    {
        getLayoutParams().height = -2;
        super.onLayout(flag, i, k, l, i1);
    }

    public void setOrderSummaryClickListener(a a1)
    {
        mClickListener = a1;
    }

}
