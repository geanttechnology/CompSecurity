// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.cart.Incentive;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.sell.widget.SelectableContainerLayout;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.shell.app.FwContext;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayBaseRecyclerAdapter

public class BuyingRecyclerAdapter extends MyEbayBaseRecyclerAdapter
{
    public class BuyingHeaderViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder
    {

        private final View bucksContainer;
        private final View headerContainer;
        private final View marginView;
        final BuyingRecyclerAdapter this$0;
        private final Drawable topCardBackground;

        protected void onBindView(int i, CharSequence charsequence)
        {
            if (getSectionFromItemPosition(i).size() == 0)
            {
                textView.setVisibility(8);
                if (bucksContainer != null)
                {
                    bucksContainer.setVisibility(8);
                }
                if (marginView != null)
                {
                    if (getListCount() == getListIndexFromItemPosition(i) + 1)
                    {
                        marginView.setVisibility(0);
                    } else
                    {
                        marginView.setVisibility(8);
                    }
                }
                if (headerContainer != null)
                {
                    headerContainer.setVisibility(8);
                }
            } else
            if (marginView == null && bucksContainer == null)
            {
                textView.setVisibility(8);
                if (headerContainer != null)
                {
                    headerContainer.setVisibility(8);
                    return;
                }
            } else
            {
                if (marginView != null)
                {
                    marginView.setVisibility(0);
                }
                headerContainer.setVisibility(0);
                textView.setVisibility(0);
                headerContainer.setBackground(topCardBackground);
                if (bucksContainer != null)
                {
                    if (bucks != null && (bucksPosition == -1 || bucksPosition == i))
                    {
                        bucksPosition = i;
                        setupBucksView();
                    } else
                    {
                        bucksContainer.setVisibility(8);
                    }
                }
                textView.setText(charsequence);
                return;
            }
        }

        protected void setupBucksView()
        {
            Object obj = (TextView)bucksContainer.findViewById(0x7f1000ea);
            TextView textview = (TextView)bucksContainer.findViewById(0x7f1000eb);
            String s = null;
            java.util.Date date = bucks.expiration;
            if (date != null)
            {
                s = java.text.DateFormat.getDateTimeInstance(2, 3).format(date);
            }
            if (obj != null && textview != null)
            {
                ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(bucks.discountAmount, 0));
                obj = s;
                if (s == null)
                {
                    obj = "";
                }
                textview.setText(((CharSequence) (obj)));
                bucksContainer.setVisibility(0);
                return;
            } else
            {
                bucksContainer.setVisibility(8);
                return;
            }
        }

        public BuyingHeaderViewHolder(View view)
        {
            this$0 = BuyingRecyclerAdapter.this;
            super(view);
            bucksContainer = view.findViewById(0x7f1003ae);
            marginView = view.findViewById(0x7f1003af);
            headerContainer = view.findViewById(0x7f1003b0);
            topCardBackground = getContext().getResources().getDrawable(0x7f020269);
        }
    }

    private class BuyingItemViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder
        implements android.view.View.OnClickListener
    {

        protected final TextView bidOrBin;
        protected final RemoteImageView image;
        protected final TextView mskuOptions;
        protected final TextView price;
        protected final TextView secondaryBin;
        protected final TextView secondaryText;
        protected final TextView shippingCost;
        final BuyingRecyclerAdapter this$0;
        protected final TextView timeLeft;
        protected final TextView title;
        protected final TextView userStatus;

        private void resetViews()
        {
            userStatus.setVisibility(0);
            userStatus.setTextColor(textColorPrimary);
            title.setMaxLines(2);
            mskuOptions.setVisibility(8);
            bidOrBin.setVisibility(0);
            secondaryBin.setVisibility(8);
            timeLeft.setVisibility(0);
            timeLeft.setTextColor(textColorSecondary);
            shippingCost.setVisibility(0);
            secondaryText.setVisibility(8);
            price.setTypeface(Typeface.DEFAULT, 0);
            shippingCost.setTypeface(Typeface.DEFAULT, 0);
        }

        protected void onBindView(int i, MyEbayListItem myebaylistitem)
        {
            i = getSectionFromItemPosition(i).listType;
            resetViews();
            image.setRemoteImageUrl(myebaylistitem.imageUrl);
            setTitle(myebaylistitem, this);
            setStatus(this, myebaylistitem, i);
            i;
            JVM INSTR tableswitch 4 7: default 76
        //                       4 90
        //                       5 116
        //                       6 129
        //                       7 103;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            boolean flag = false;
_L7:
            if (flag)
            {
                handleCurrencyConversionSetup();
            }
            return;
_L2:
            flag = setupViewBuyingBidding(myebaylistitem, this);
            continue; /* Loop/switch isn't completed */
_L5:
            flag = setupViewBuyingOffer(myebaylistitem, this);
            continue; /* Loop/switch isn't completed */
_L3:
            flag = setupViewBuyingWon(myebaylistitem, this);
            continue; /* Loop/switch isn't completed */
_L4:
            flag = setupViewBuyingNotWon(myebaylistitem, this);
            if (true) goto _L7; else goto _L6
_L6:
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

        public void setSelected(boolean flag, boolean flag1, boolean flag2)
        {
            SelectableContainerLayout selectablecontainerlayout = (SelectableContainerLayout)itemView;
            selectablecontainerlayout.setIsSelectionEnabled(flag, flag1);
            selectablecontainerlayout.setIsSelected(flag2);
        }

        public BuyingItemViewHolder(View view)
        {
            this$0 = BuyingRecyclerAdapter.this;
            super(view, null);
            image = (RemoteImageView)view.findViewById(0x7f10005b);
            userStatus = (TextView)view.findViewById(0x7f1003b1);
            title = (TextView)view.findViewById(0x7f100108);
            mskuOptions = (TextView)view.findViewById(0x7f1003b2);
            price = (TextView)view.findViewById(0x7f100109);
            shippingCost = (TextView)view.findViewById(0x7f1003b3);
            secondaryText = (TextView)view.findViewById(0x7f1003b4);
            bidOrBin = (TextView)view.findViewById(0x7f1003b5);
            secondaryBin = (TextView)view.findViewById(0x7f1003b6);
            timeLeft = (TextView)view.findViewById(0x7f1003b7);
            view.setOnClickListener(this);
        }
    }

    static interface CountCallback
    {

        public abstract int getCountForListType(int i);
    }

    private class LoadMoreHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ListIndexViewHolder
        implements android.view.View.OnClickListener
    {

        private final TextView count;
        final BuyingRecyclerAdapter this$0;
        private final TextView title;

        protected void onBindView(int i, int j)
        {
            i = getSectionFromItemPosition(i).listType;
            i;
            JVM INSTR tableswitch 4 7: default 44
        //                       4 91
        //                       5 113
        //                       6 124
        //                       7 102;
               goto _L1 _L2 _L3 _L4 _L5
_L4:
            break MISSING_BLOCK_LABEL_124;
_L1:
            String s = "";
_L6:
            if (countCallback != null)
            {
                i = countCallback.getCountForListType(i);
            } else
            {
                i = 0;
            }
            title.setText(s);
            count.setText(Integer.toString(i));
            return;
_L2:
            s = seeMoreBids;
              goto _L6
_L5:
            s = seeMoreOffers;
              goto _L6
_L3:
            s = seeMorePurchases;
              goto _L6
            s = seeMoreLost;
              goto _L6
        }

        public void onClick(View view)
        {
            callback.onItemPressed(getLayoutPosition());
        }

        public LoadMoreHolder(View view)
        {
            this$0 = BuyingRecyclerAdapter.this;
            super(view);
            title = (TextView)view.findViewById(0x7f1003c7);
            count = (TextView)view.findViewById(0x7f1003c8);
            view.setBackground(getContext().getResources().getDrawable(0x7f020267));
            view.setOnClickListener(this);
        }
    }


    protected Incentive bucks;
    protected int bucksPosition;
    protected final CountCallback countCallback;
    private final String counterOffer;
    private final java.text.DateFormat dateFormat;
    private final String feedbackLeft;
    private final String highBidder;
    private final boolean isUserFromDe;
    private final String leaveFeedback;
    private final String offerDeclined;
    private final String offerExpired;
    private final String offerSent;
    private final String outbid;
    private final String paid;
    private final String payNow;
    private final String payUponInvoice;
    private final String reserveNotMet;
    protected final String seeMoreBids;
    protected final String seeMoreLost;
    protected final String seeMoreOffers;
    protected final String seeMorePurchases;
    private final String shipped;
    private final UserCache userCache;
    private final String userId;

    public BuyingRecyclerAdapter(Activity activity, MyEbayBaseRecyclerAdapter.MyEbayAdapterCallback myebayadaptercallback, String s, int i, CountCallback countcallback, Incentive incentive)
    {
        super(activity, myebayadaptercallback, i);
        bucksPosition = -1;
        userId = s;
        isUserFromDe = MyApp.getPrefs().getCurrentCountry().getCountryCode().equals(EbaySite.DE.localeCountry);
        userCache = new UserCache(activity, ((FwContext)activity).getEbayContext());
        seeMoreBids = resources.getString(0x7f070646);
        seeMoreOffers = resources.getString(0x7f070648);
        seeMorePurchases = resources.getString(0x7f070649);
        seeMoreLost = resources.getString(0x7f070647);
        outbid = resources.getString(0x7f070580);
        highBidder = resources.getString(0x7f070457);
        reserveNotMet = resources.getString(0x7f07091b);
        offerDeclined = resources.getString(0x7f070710);
        offerSent = resources.getString(0x7f070726);
        offerExpired = resources.getString(0x7f0704d4);
        counterOffer = resources.getString(0x7f07026a);
        payNow = resources.getString(0x7f070764);
        paid = resources.getString(0x7f07075c);
        shipped = resources.getString(0x7f070b34);
        leaveFeedback = resources.getString(0x7f0705d8);
        feedbackLeft = resources.getString(0x7f070412);
        payUponInvoice = resources.getString(0x7f070645);
        dateFormat = DateFormat.getMediumDateFormat(activity);
        countCallback = countcallback;
        bucks = incentive;
    }

    private boolean isItemClickable(MyEbayListItem myebaylistitem, int i)
    {
        getSectionFromItemPosition(i).listType;
        JVM INSTR tableswitch 5 6: default 32
    //                   5 34
    //                   6 58;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        if (myebaylistitem.orderId == null && isPaid(myebaylistitem) && isSelectionEnabled())
        {
            return true;
        }
          goto _L1
_L3:
        return isSelectionEnabled();
    }

    private boolean isPaid(MyEbayListItem myebaylistitem)
    {
        if (myebaylistitem.transaction != null)
        {
            if (ItemTransaction.isPaidFor(myebaylistitem.transaction.paidStatus) || ItemTransaction.isPaidUsingTradingQuirk(myebaylistitem.transaction.paidStatus, myebaylistitem.transaction.paidTime))
            {
                return true;
            }
            myebaylistitem = userCache.getPaidStatusAndTime(String.valueOf(myebaylistitem.id), myebaylistitem.transaction.transactionId);
            if (myebaylistitem != null)
            {
                return ItemTransaction.isPaidFor(((com.ebay.common.UserCache.PaidStatusAndTime) (myebaylistitem)).status) || ItemTransaction.isPaidUsingTradingQuirk(((com.ebay.common.UserCache.PaidStatusAndTime) (myebaylistitem)).status, ((com.ebay.common.UserCache.PaidStatusAndTime) (myebaylistitem)).apiTime);
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }

    private boolean isPui(MyEbayListItem myebaylistitem)
    {
        if (myebaylistitem.transaction != null)
        {
            return "PayUponInvoice".equals(myebaylistitem.transaction.paidStatus);
        } else
        {
            return false;
        }
    }

    private boolean setItemPricing(int i, MyEbayListItem myebaylistitem, TextView textview)
    {
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = null;
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency1;
        if (myebaylistitem.transaction != null && myebaylistitem.transaction.totalTransactionPrice != null)
        {
            itemcurrency1 = myebaylistitem.transaction.totalTransactionPrice;
        } else
        {
            itemcurrency1 = myebaylistitem.currentPrice;
            itemcurrency = myebaylistitem.convertedCurrentPrice;
        }
        if (i == 7)
        {
            return setCurrency(textview, myebaylistitem.bestOfferAmount, itemcurrency);
        } else
        {
            return setCurrency(textview, itemcurrency1, itemcurrency);
        }
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.BaseViewHolder)viewholder, i);
    }

    public void onBindViewHolder(com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.BaseViewHolder baseviewholder, int i)
    {
        super.onBindViewHolder(baseviewholder, i);
        if (!(baseviewholder instanceof BuyingItemViewHolder)) goto _L2; else goto _L1
_L1:
        MyEbayListItem myebaylistitem;
        com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section;
        int j;
        myebaylistitem = (MyEbayListItem)getItem(i);
        section = getSectionFromItemPosition(i);
        j = 0x7f020268;
        ((BuyingItemViewHolder)baseviewholder).setSelected(isSelectionEnabled(), isItemClickable(myebaylistitem, i), isSelected(myebaylistitem));
        if (section == null || section.loadedItems <= 0) goto _L2; else goto _L3
_L3:
        if (headerResource != 0x7f030166) goto _L5; else goto _L4
_L4:
        if (section.loadedItems != 1) goto _L7; else goto _L6
_L6:
        i = 0x7f020266;
_L9:
        ((BuyingItemViewHolder)baseviewholder).setBackground(getContext().getResources().getDrawable(i));
_L2:
        return;
_L7:
        if (myebaylistitem == section.list.get(0))
        {
            i = 0x7f020269;
        } else
        {
            i = j;
            if (myebaylistitem == section.list.get(section.loadedItems - 1))
            {
                i = 0x7f020267;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i = j;
        if (section.loadedItems <= section.totalItems)
        {
            i = j;
            if (myebaylistitem == section.list.get(section.loadedItems - 1))
            {
                i = 0x7f020267;
            }
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewgroup)
    {
        return new BuyingHeaderViewHolder(inflater.inflate(headerResource, viewgroup, false));
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup viewgroup)
    {
        return new BuyingItemViewHolder(LayoutInflater.from(getContext()).inflate(itemLayoutResource, viewgroup, false));
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ListIndexViewHolder onCreateMoreViewHolder(ViewGroup viewgroup)
    {
        return new LoadMoreHolder(LayoutInflater.from(getContext()).inflate(0x7f030170, viewgroup, false));
    }

    public void onViewHolderClick(int i)
    {
        if (isSelectionEnabled())
        {
            MyEbayListItem myebaylistitem = (MyEbayListItem)getItem(i);
            if (isItemClickable(myebaylistitem, i))
            {
                toggleSelection(myebaylistitem);
                notifyItemChanged(i);
            }
            return;
        } else
        {
            callback.onItemPressed(i);
            return;
        }
    }

    public void setBucksContent(Incentive incentive)
    {
        bucks = incentive;
        notifyDataSetChanged();
    }

    protected void setStatus(BuyingItemViewHolder buyingitemviewholder, MyEbayListItem myebaylistitem, int i)
    {
        TextView textview;
        boolean flag;
        flag = false;
        textview = buyingitemviewholder.userStatus;
        if (i == 4)
        {
            if (!TextUtils.isEmpty(myebaylistitem.highBidderId) && myebaylistitem.highBidderId.equalsIgnoreCase(userId))
            {
                textview.setText(highBidder);
                if (!myebaylistitem.reserveMet)
                {
                    buyingitemviewholder.secondaryText.setVisibility(0);
                    buyingitemviewholder.secondaryText.setText(reserveNotMet);
                }
                return;
            } else
            {
                textview.setText(outbid);
                textview.setTextColor(colorPriceReserveNotMet);
                return;
            }
        }
        if (i != 7) goto _L2; else goto _L1
_L1:
        buyingitemviewholder = myebaylistitem.bestOfferStatus;
        buyingitemviewholder.hashCode();
        JVM INSTR lookupswitch 4: default 152
    //                   -938740869: 238
    //                   355417861: 223
    //                   632840270: 192
    //                   982065527: 208;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        i = -1;
          goto _L8
_L6:
        if (!buyingitemviewholder.equals("Declined")) goto _L3; else goto _L9
_L9:
        i = ((flag) ? 1 : 0);
          goto _L8
_L7:
        if (!buyingitemviewholder.equals("Pending")) goto _L3; else goto _L10
_L10:
        i = 1;
          goto _L8
_L5:
        if (!buyingitemviewholder.equals("Expired")) goto _L3; else goto _L11
_L11:
        i = 2;
          goto _L8
_L4:
        if (!buyingitemviewholder.equals("Countered")) goto _L3; else goto _L12
_L12:
        i = 3;
_L8:
        switch (i)
        {
        default:
            textview.setVisibility(8);
            return;

        case 0: // '\0'
            textview.setText(offerDeclined);
            return;

        case 1: // '\001'
            textview.setText(offerSent);
            return;

        case 2: // '\002'
            textview.setText(offerExpired);
            return;

        case 3: // '\003'
            textview.setText(counterOffer);
            break;
        }
        textview.setTextColor(colorPriceReserveNotMet);
        return;
_L2:
        if (i == 6)
        {
            textview.setVisibility(8);
            return;
        }
        if (i == 5)
        {
            com.ebay.nautilus.domain.data.MyEbayListItem.Transaction transaction = myebaylistitem.transaction;
            if (transaction != null)
            {
                if (transaction.shipped)
                {
                    textview.setText(shipped);
                    buyingitemviewholder.secondaryText.setVisibility(0);
                    myebaylistitem = buyingitemviewholder.secondaryText;
                    if (transaction.feedbackLeft)
                    {
                        buyingitemviewholder = feedbackLeft;
                    } else
                    {
                        buyingitemviewholder = leaveFeedback;
                    }
                    myebaylistitem.setText(buyingitemviewholder);
                    return;
                }
                if (isPui(myebaylistitem))
                {
                    textview.setText(payUponInvoice);
                    return;
                }
                if (isPaid(myebaylistitem))
                {
                    textview.setText(paid);
                    return;
                }
                if (isUserFromDe)
                {
                    textview.setVisibility(8);
                    return;
                } else
                {
                    textview.setTextColor(colorPriceReserveNotMet);
                    textview.setText(payNow);
                    return;
                }
            } else
            {
                textview.setVisibility(8);
                return;
            }
        } else
        {
            textview.setVisibility(8);
            return;
        }
    }

    protected void setTitle(MyEbayListItem myebaylistitem, BuyingItemViewHolder buyingitemviewholder)
    {
        buyingitemviewholder.title.setText(myebaylistitem.title);
        if (myebaylistitem.nameValueList != null && !myebaylistitem.nameValueList.isEmpty())
        {
            buyingitemviewholder.title.setMaxLines(1);
            buyingitemviewholder.mskuOptions.setVisibility(0);
            buyingitemviewholder.mskuOptions.setText(getMskuStringForItem(myebaylistitem));
        }
    }

    protected boolean setupViewBuyingBidding(MyEbayListItem myebaylistitem, BuyingItemViewHolder buyingitemviewholder)
    {
        setListingTypeState(myebaylistitem, 4, buyingitemviewholder.bidOrBin, buyingitemviewholder.secondaryBin);
        setTimeLeft(buyingitemviewholder.timeLeft, myebaylistitem.endDate, EbayResponse.currentHostTime());
        boolean flag = setItemPricing(4, myebaylistitem, buyingitemviewholder.price);
        setShippingCost(myebaylistitem, buyingitemviewholder.shippingCost, flag);
        return flag;
    }

    protected boolean setupViewBuyingNotWon(MyEbayListItem myebaylistitem, BuyingItemViewHolder buyingitemviewholder)
    {
        setListingTypeState(myebaylistitem, 6, buyingitemviewholder.bidOrBin, buyingitemviewholder.secondaryBin);
        buyingitemviewholder.timeLeft.setText(dateFormat.format(myebaylistitem.endDate));
        buyingitemviewholder.shippingCost.setVisibility(8);
        return setItemPricing(6, myebaylistitem, buyingitemviewholder.price);
    }

    protected boolean setupViewBuyingOffer(MyEbayListItem myebaylistitem, BuyingItemViewHolder buyingitemviewholder)
    {
        setTimeLeft(buyingitemviewholder.timeLeft, myebaylistitem.endDate, EbayResponse.currentHostTime());
        boolean flag = setItemPricing(7, myebaylistitem, buyingitemviewholder.price);
        setShippingCost(myebaylistitem, buyingitemviewholder.shippingCost, flag);
        return flag;
    }

    protected boolean setupViewBuyingWon(MyEbayListItem myebaylistitem, BuyingItemViewHolder buyingitemviewholder)
    {
        boolean flag;
        if (myebaylistitem.transaction != null && myebaylistitem.transaction.createdDate != null)
        {
            buyingitemviewholder.timeLeft.setText(dateFormat.format(myebaylistitem.transaction.createdDate));
        } else
        {
            buyingitemviewholder.timeLeft.setVisibility(8);
        }
        buyingitemviewholder.bidOrBin.setVisibility(4);
        flag = setItemPricing(5, myebaylistitem, buyingitemviewholder.price);
        setShippingCost(myebaylistitem, buyingitemviewholder.shippingCost, flag);
        return flag;
    }
}
