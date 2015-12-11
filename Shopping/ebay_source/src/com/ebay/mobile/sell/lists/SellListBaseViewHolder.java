// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.sell.widget.SelectableContainerLayout;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;

public abstract class SellListBaseViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder
    implements android.view.View.OnClickListener
{
    public static interface OnViewHolderClickListener
    {

        public abstract void onViewHolderClick(int i);
    }


    private final String free;
    private final String freight;
    protected RemoteImageView image;
    protected OnViewHolderClickListener listener;
    protected TextView price;
    private final String shippingFormat;
    protected TextView statusText2;
    protected TextView subtext1;
    protected TextView subtext2;
    protected TextView subtext3;
    protected TextView textView2;
    private final String varies;

    public SellListBaseViewHolder(View view, OnViewHolderClickListener onviewholderclicklistener)
    {
        super(view, (TextView)view.findViewById(0x1020014));
        listener = onviewholderclicklistener;
        view.setOnClickListener(this);
        textView2 = (TextView)view.findViewById(0x7f100725);
        statusText2 = (TextView)view.findViewById(0x7f100727);
        image = (RemoteImageView)view.findViewById(0x7f10005b);
        price = (TextView)view.findViewById(0x7f100128);
        subtext1 = (TextView)view.findViewById(0x7f100728);
        subtext2 = (TextView)view.findViewById(0x7f100729);
        subtext3 = (TextView)view.findViewById(0x7f10072a);
        view = view.getContext().getResources();
        SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry());
        varies = view.getString(0x7f070b9f);
        free = view.getString(0x7f070422);
        freight = view.getString(0x7f070425);
        shippingFormat = view.getString(0x7f0707a3);
    }

    public void onClick(View view)
    {
        if (listener != null)
        {
            listener.onViewHolderClick(getPosition());
        }
    }

    public void setBackground(Drawable drawable)
    {
        itemView.setBackground(drawable);
    }

    public void setSelected(boolean flag, boolean flag1)
    {
        SelectableContainerLayout selectablecontainerlayout = (SelectableContainerLayout)itemView;
        selectablecontainerlayout.setIsSelectionEnabled(flag);
        selectablecontainerlayout.setIsSelected(flag1);
    }

    protected void setShippingCost(MyEbayListItem myebaylistitem, TextView textview)
    {
        textview.setVisibility(0);
        if (myebaylistitem.shippingCost == null || myebaylistitem.shippingCost.code == null || myebaylistitem.shippingCost.value == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        double d = Double.parseDouble(myebaylistitem.shippingCost.value);
        if (EbayCurrency.getInstance(myebaylistitem.shippingCost.code).isInsignificant(d))
        {
            textview.setText(free);
            return;
        }
        try
        {
            myebaylistitem = EbayCurrencyUtil.formatDisplay(myebaylistitem.shippingCost, 2);
            textview.setText(String.format(shippingFormat, new Object[] {
                myebaylistitem
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MyEbayListItem myebaylistitem)
        {
            textview.setVisibility(4);
        }
        return;
        if ("Freight".equals(myebaylistitem.shippingType))
        {
            textview.setText(freight);
            return;
        }
        if ("Free".equals(myebaylistitem.shippingType))
        {
            textview.setText(free);
            return;
        }
        if ("NotSpecified".equals(myebaylistitem.shippingType) || "Calculated".equals(myebaylistitem.shippingType))
        {
            textview.setText(varies);
            return;
        } else
        {
            textview.setVisibility(4);
            return;
        }
    }
}
