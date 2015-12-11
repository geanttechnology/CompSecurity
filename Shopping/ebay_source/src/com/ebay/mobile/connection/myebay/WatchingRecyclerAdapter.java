// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.sell.widget.SelectableContainerLayout;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayBaseRecyclerAdapter

public class WatchingRecyclerAdapter extends MyEbayBaseRecyclerAdapter
{
    class WatchingHeaderViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder
    {

        private final View textContent;
        final WatchingRecyclerAdapter this$0;

        protected void onBindView(int i, CharSequence charsequence)
        {
            if (getSectionFromItemPosition(i).size() == 0)
            {
                if (textContent != null)
                {
                    textContent.setVisibility(8);
                }
                return;
            }
            if (textContent != null)
            {
                textContent.setVisibility(0);
            }
            textView.setText(charsequence);
        }

        public WatchingHeaderViewHolder(View view)
        {
            this$0 = WatchingRecyclerAdapter.this;
            super(view);
            textContent = view.findViewById(0x7f1003dd);
        }
    }

    private class WatchingItemViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder
        implements android.view.View.OnClickListener
    {

        private final TextView bidBin;
        private final RemoteImageView image;
        protected final TextView mskuOptions;
        private final TextView price;
        private final TextView secondaryText;
        private final TextView shippingCost;
        final WatchingRecyclerAdapter this$0;
        private final TextView timeLeft;
        protected final TextView title;

        private void resetViews()
        {
            title.setMaxLines(2);
            title.setTextColor(textColorPrimary);
            mskuOptions.setVisibility(8);
            bidBin.setVisibility(0);
            timeLeft.setVisibility(0);
            price.setTypeface(Typeface.DEFAULT, 0);
            shippingCost.setTypeface(Typeface.DEFAULT, 0);
        }

        protected void onBindView(int i, MyEbayListItem myebaylistitem)
        {
            resetViews();
            i = getSectionFromItemPosition(i).listType;
            setTitle(myebaylistitem, this);
            image.setRemoteImageUrl(myebaylistitem.imageUrl);
            setListingTypeState(myebaylistitem, i, bidBin, secondaryText);
            setTimeLeft(timeLeft, myebaylistitem.endDate, EbayResponse.currentHostTime());
            boolean flag = setItemPricing(myebaylistitem, price);
            setShippingCost(myebaylistitem, shippingCost, flag);
            if (flag)
            {
                handleCurrencyConversionSetup();
            }
        }

        protected volatile void onBindView(int i, Object obj)
        {
            onBindView(i, (MyEbayListItem)obj);
        }

        public void onClick(View view)
        {
            onViewHolderClick(getLayoutPosition());
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

        public WatchingItemViewHolder(View view)
        {
            this$0 = WatchingRecyclerAdapter.this;
            super(view, null);
            image = (RemoteImageView)view.findViewById(0x7f10005b);
            title = (TextView)view.findViewById(0x7f100108);
            mskuOptions = (TextView)view.findViewById(0x7f1003db);
            price = (TextView)view.findViewById(0x7f100109);
            shippingCost = (TextView)view.findViewById(0x7f1003b3);
            bidBin = (TextView)view.findViewById(0x7f1003dc);
            secondaryText = (TextView)view.findViewById(0x7f1003b4);
            timeLeft = (TextView)view.findViewById(0x7f1003b7);
            view.setOnClickListener(this);
        }
    }


    public WatchingRecyclerAdapter(Activity activity, MyEbayBaseRecyclerAdapter.MyEbayAdapterCallback myebayadaptercallback, int i)
    {
        super(activity, myebayadaptercallback, i);
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.BaseViewHolder)viewholder, i);
    }

    public void onBindViewHolder(com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.BaseViewHolder baseviewholder, int i)
    {
        super.onBindViewHolder(baseviewholder, i);
        if (!(baseviewholder instanceof WatchingItemViewHolder)) goto _L2; else goto _L1
_L1:
        MyEbayListItem myebaylistitem;
        com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section;
        myebaylistitem = (MyEbayListItem)getItem(i);
        section = getSectionFromItemPosition(i);
        i = 0x7f020268;
        ((WatchingItemViewHolder)baseviewholder).setSelected(isSelectionEnabled(), isSelected(myebaylistitem));
        if (section == null || section.loadedItems <= 0) goto _L2; else goto _L3
_L3:
        if (section.loadedItems != 1) goto _L5; else goto _L4
_L4:
        i = 0x7f020266;
_L7:
        ((WatchingItemViewHolder)baseviewholder).setBackground(getContext().getResources().getDrawable(i));
_L2:
        return;
_L5:
        if (myebaylistitem == section.list.get(0))
        {
            i = 0x7f020269;
        } else
        if (myebaylistitem == section.list.get(section.loadedItems - 1))
        {
            i = 0x7f020267;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewgroup)
    {
        return new WatchingHeaderViewHolder(inflater.inflate(headerResource, viewgroup, false));
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup viewgroup)
    {
        return new WatchingItemViewHolder(LayoutInflater.from(getContext()).inflate(itemLayoutResource, viewgroup, false));
    }

    public void onViewHolderClick(int i)
    {
        if (isSelectionEnabled())
        {
            toggleSelection((MyEbayListItem)getItem(i));
            notifyItemChanged(i);
            return;
        } else
        {
            callback.onItemPressed(i);
            return;
        }
    }

    protected boolean setItemPricing(MyEbayListItem myebaylistitem, TextView textview)
    {
        Object obj = null;
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency;
        if (myebaylistitem.transaction != null && myebaylistitem.transaction.totalTransactionPrice != null)
        {
            itemcurrency = myebaylistitem.transaction.totalTransactionPrice;
            myebaylistitem = obj;
        } else
        {
            itemcurrency = myebaylistitem.currentPrice;
            myebaylistitem = myebaylistitem.convertedCurrentPrice;
        }
        return setCurrency(textview, itemcurrency, myebaylistitem);
    }

    protected void setTitle(MyEbayListItem myebaylistitem, WatchingItemViewHolder watchingitemviewholder)
    {
        if (myebaylistitem.nameValueList == null || myebaylistitem.nameValueList.isEmpty())
        {
            watchingitemviewholder.title.setText(myebaylistitem.title);
            return;
        } else
        {
            watchingitemviewholder.title.setMaxLines(1);
            watchingitemviewholder.title.setTextColor(textColorSecondary);
            watchingitemviewholder.mskuOptions.setVisibility(0);
            watchingitemviewholder.mskuOptions.setText(myebaylistitem.title);
            watchingitemviewholder.title.setText(getMskuStringForItem(myebaylistitem));
            return;
        }
    }
}
