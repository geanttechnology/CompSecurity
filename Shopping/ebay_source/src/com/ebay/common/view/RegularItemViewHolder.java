// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.net.api.search.idealmodel.LabeledAnswerSrpListItem;
import com.ebay.common.net.api.search.idealmodel.RegularSrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItemViewModel;
import com.ebay.common.util.LruHistoryCache;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.search.LruVisitedItemCache;
import com.ebay.mobile.search.SearchResultFragmentActivity;
import com.ebay.mobile.search.SrpListItemRenderer;

public class RegularItemViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder
    implements android.view.View.OnClickListener
{

    public final TextView bidCountText;
    public final TextView binLabel;
    public final TextView classifiedLabel;
    public final TextView detailsLabel;
    public final TextView distanceText;
    public final ImageView ebayPlusBadge;
    public final TextView eekText;
    public final RemoteImageView image;
    public final FrameLayout imageFrame;
    private final com.ebay.common.ConstantsCommon.ItemKind itemKind;
    private int itemRank;
    private com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType itemType;
    private SrpListItem listItem;
    public final TextView oboLabel;
    public final TextView optionsLabel;
    public final TextView priceText;
    public final TextView promotedLabel;
    private final SrpListItemRenderer renderer;
    public final View rootView;
    public final TextView shippingText;
    public final TextView strikethroughText;
    public final TextView timeLeftText;
    public final TextView titleText;
    public final TextView unitText;

    public RegularItemViewHolder(View view, SrpListItemRenderer srplistitemrenderer, boolean flag)
    {
        super(view, null);
        renderer = srplistitemrenderer;
        view.setOnClickListener(this);
        if (flag)
        {
            itemKind = com.ebay.common.ConstantsCommon.ItemKind.SellersOther;
        } else
        {
            itemKind = com.ebay.common.ConstantsCommon.ItemKind.Found;
        }
        rootView = view;
        imageFrame = (FrameLayout)view.findViewById(0x7f100131);
        image = (RemoteImageView)view.findViewById(0x7f10005b);
        promotedLabel = (TextView)view.findViewById(0x7f1007fc);
        priceText = (TextView)view.findViewById(0x7f1007ff);
        oboLabel = (TextView)view.findViewById(0x7f100800);
        unitText = (TextView)view.findViewById(0x7f100802);
        detailsLabel = (TextView)view.findViewById(0x7f100803);
        strikethroughText = (TextView)view.findViewById(0x7f100804);
        binLabel = (TextView)view.findViewById(0x7f100801);
        classifiedLabel = (TextView)view.findViewById(0x7f100806);
        eekText = (TextView)view.findViewById(0x7f10080d);
        ebayPlusBadge = (ImageView)view.findViewById(0x7f100808);
        titleText = (TextView)view.findViewById(0x7f1007fd);
        bidCountText = (TextView)view.findViewById(0x7f100809);
        timeLeftText = (TextView)view.findViewById(0x7f10080a);
        optionsLabel = (TextView)view.findViewById(0x7f10080b);
        distanceText = (TextView)view.findViewById(0x7f10080c);
        shippingText = (TextView)view.findViewById(0x7f100805);
        rootView.setTag(null);
    }

    private void sendTracking()
    {
        LabeledAnswerSrpListItem labeledanswersrplistitem;
        if (listItem.impressionTracking != null)
        {
            if (!(labeledanswersrplistitem = (LabeledAnswerSrpListItem)listItem).trackingSent)
            {
                TrackingData trackingdata = new TrackingData("PromotedListingImp", TrackingType.PAGE_IMPRESSION);
                trackingdata.addKeyValuePair("svcdata", listItem.impressionTracking);
                trackingdata.send(((SearchResultFragmentActivity)rootView.getContext()).getEbayContext());
                labeledanswersrplistitem.trackingSent = true;
                return;
            }
        }
    }

    protected void onBindView(int i, SrpListItem srplistitem)
    {
        listItem = srplistitem;
        itemType = listItem.itemType;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[];

            static 
            {
                $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType = new int[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.REGULAR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.LABELED_ANSWER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType[itemType.ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 57
    //                   2 95;
           goto _L1 _L2 _L3
_L1:
        itemRank = srplistitem.trackingRank;
        return;
_L2:
        renderer.setItem(this, ((RegularSrpListItem)listItem).viewModel);
        rootView.setTag(((RegularSrpListItem)listItem).viewModel);
        continue; /* Loop/switch isn't completed */
_L3:
        renderer.setItem(this, ((LabeledAnswerSrpListItem)listItem).viewModel);
        rootView.setTag(((LabeledAnswerSrpListItem)listItem).viewModel);
        sendTracking();
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected volatile void onBindView(int i, Object obj)
    {
        onBindView(i, (SrpListItem)obj);
    }

    public void onClick(View view)
    {
        SearchResultFragmentActivity searchresultfragmentactivity = (SearchResultFragmentActivity)view.getContext();
        _cls1..SwitchMap.com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType[itemType.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 124;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        java.util.Date date;
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency;
        long l;
        boolean flag;
        RegularSrpListItem regularsrplistitem = (RegularSrpListItem)listItem;
        l = regularsrplistitem.getId();
        date = regularsrplistitem.getEndDate();
        itemcurrency = regularsrplistitem.getOriginalRetailPrice();
        flag = regularsrplistitem.viewModel.isEbayPlus;
_L5:
        LruVisitedItemCache.get().remember(Long.valueOf(l));
        renderer.markItemAsVisited(view, l);
        searchresultfragmentactivity.onSearchItemClicked(l, date, itemcurrency, flag, itemKind, itemRank);
        return;
_L3:
        Object obj = (LabeledAnswerSrpListItem)listItem;
        l = ((LabeledAnswerSrpListItem) (obj)).getId();
        date = ((LabeledAnswerSrpListItem) (obj)).getEndDate();
        itemcurrency = ((LabeledAnswerSrpListItem) (obj)).getOriginalRetailPrice();
        flag = ((LabeledAnswerSrpListItem) (obj)).viewModel.isEbayPlus;
        obj = new TrackingData("PromotedListingClick", TrackingType.EVENT);
        ((TrackingData) (obj)).addKeyValuePair("svcdata", listItem.clickTracking);
        ((TrackingData) (obj)).send(searchresultfragmentactivity.getEbayContext());
        if (true) goto _L5; else goto _L4
_L4:
    }
}
