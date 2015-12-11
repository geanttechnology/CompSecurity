// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.checkout:
//            PaymentMethodActivity

private class otherPaymentMethods extends BaseExpandableListAdapter
{

    private final Context context;
    private final ArrayList otherPaymentMethods;
    final PaymentMethodActivity this$0;

    public Object getChild(int i, int j)
    {
        if (j < otherPaymentMethods.size())
        {
            return otherPaymentMethods.get(j);
        } else
        {
            return null;
        }
    }

    public long getChildId(int i, int j)
    {
        return (long)j;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0302ce, null);
        }
        Object obj = (TextView)viewgroup.findViewById(0x7f10053a);
        view = (String)otherPaymentMethods.get(j);
        ((TextView) (obj)).setText(view);
        obj = (ImageView)viewgroup.findViewById(0x7f1009a0);
        if (selectedPaymentMethod != null)
        {
            if (selectedPaymentMethod.equals("CashOnPickup") && view.equals(context.getString(0x7f070c4d)))
            {
                ((ImageView) (obj)).setVisibility(0);
            } else
            if (selectedPaymentMethod.equals("MoneyXferAcceptedInCheckout") && view.equals(context.getString(0x7f070c51)))
            {
                ((ImageView) (obj)).setVisibility(0);
            } else
            {
                ((ImageView) (obj)).setVisibility(8);
            }
        } else
        {
            ((ImageView) (obj)).setVisibility(8);
        }
        viewgroup.setTag(otherPaymentMethods.get(j));
        return viewgroup;
    }

    public int getChildrenCount(int i)
    {
        return otherPaymentMethods.size();
    }

    public Object getGroup(int i)
    {
        return Integer.valueOf(0);
    }

    public int getGroupCount()
    {
        return 1;
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0302cd, null);
        }
        ((TextView)viewgroup.findViewById(0x7f10099d)).setText(context.getString(0x7f070c4b));
        return viewgroup;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public (Context context1, ArrayList arraylist)
    {
        this$0 = PaymentMethodActivity.this;
        super();
        context = context1;
        otherPaymentMethods = arraylist;
    }
}
