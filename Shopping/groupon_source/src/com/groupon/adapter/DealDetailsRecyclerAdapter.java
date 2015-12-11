// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.groupon.callbacks.OnRecyclerViewHeaderLoadedListener;
import com.groupon.models.dealdetails.DealDetailsViewType;
import com.groupon.mvc.controller.recycleritem.RecyclerItemViewController;
import com.groupon.mvc.view.viewholder.AdditionalInfoViewHolder;
import com.groupon.mvc.view.viewholder.AmenitiesViewHolder;
import com.groupon.mvc.view.viewholder.CabWidgetsViewHolder;
import com.groupon.mvc.view.viewholder.CavWidgetsViewHolder;
import com.groupon.mvc.view.viewholder.CompanyInfoViewHolder;
import com.groupon.mvc.view.viewholder.DateTimeFinderReservationViewHolder;
import com.groupon.mvc.view.viewholder.DeliveryEstimationViewHolder;
import com.groupon.mvc.view.viewholder.DetailsHeaderViewHolder;
import com.groupon.mvc.view.viewholder.DirectionsViewHolder;
import com.groupon.mvc.view.viewholder.ExposedMultiOptionsViewHolder;
import com.groupon.mvc.view.viewholder.FinePrintViewHolder;
import com.groupon.mvc.view.viewholder.GiftingViewHolder;
import com.groupon.mvc.view.viewholder.HighlightsViewHolder;
import com.groupon.mvc.view.viewholder.IncentivesViewHolder;
import com.groupon.mvc.view.viewholder.LiveChatViewHolder;
import com.groupon.mvc.view.viewholder.MarketplaceViewHolder;
import com.groupon.mvc.view.viewholder.MerchantRecommendationsViewHolder;
import com.groupon.mvc.view.viewholder.MoreInfoViewHolder;
import com.groupon.mvc.view.viewholder.OtherDetailsViewHolder;
import com.groupon.mvc.view.viewholder.QAndAViewHolder;
import com.groupon.mvc.view.viewholder.RecyclerItemViewHolder;
import com.groupon.mvc.view.viewholder.TipsViewHolder;
import com.groupon.mvc.view.viewholder.TravelUgcReviewsViewHolder;
import com.groupon.mvc.view.viewholder.TripAdvisorReviewsViewHolder;
import com.groupon.mvc.view.viewholder.WhatYouGetViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DealDetailsRecyclerAdapter extends android.support.v7.widget.RecyclerView.Adapter
{

    private Context context;
    private List detailsViewTypes;
    private OnRecyclerViewHeaderLoadedListener onHeaderLoadedListener;
    private Map viewControllersMap;

    public DealDetailsRecyclerAdapter(Context context1, Map map)
    {
        context = context1;
        viewControllersMap = new HashMap(map);
        detailsViewTypes = new ArrayList(map.keySet());
    }

    private int getPreviousItemPosition(DealDetailsViewType dealdetailsviewtype)
    {
        int i = -1;
        dealdetailsviewtype = getPreviousItemType(dealdetailsviewtype);
        if (dealdetailsviewtype == null)
        {
            return -1;
        }
        Iterator iterator = detailsViewTypes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DealDetailsViewType dealdetailsviewtype1 = (DealDetailsViewType)iterator.next();
            if (dealdetailsviewtype1 == dealdetailsviewtype)
            {
                i = detailsViewTypes.indexOf(dealdetailsviewtype1);
            }
        } while (true);
        int j = i;
        if (i == -1)
        {
            j = getPreviousItemPosition(dealdetailsviewtype);
        }
        return j;
    }

    private DealDetailsViewType getPreviousItemType(DealDetailsViewType dealdetailsviewtype)
    {
        DealDetailsViewType adealdetailsviewtype[] = DealDetailsViewType.values();
        int i = 0;
        do
        {
label0:
            {
label1:
                {
                    if (i < adealdetailsviewtype.length)
                    {
                        if (adealdetailsviewtype[i] != dealdetailsviewtype)
                        {
                            break label0;
                        }
                        if (i - 1 >= 0)
                        {
                            break label1;
                        }
                    }
                    return null;
                }
                return adealdetailsviewtype[i - 1];
            }
            i++;
        } while (true);
    }

    private View inflateItemView(int i, ViewGroup viewgroup)
    {
        return LayoutInflater.from(context).inflate(i, viewgroup, false);
    }

    public void alterItemRange(Map map)
    {
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DealDetailsViewType dealdetailsviewtype = (DealDetailsViewType)iterator.next();
            RecyclerItemViewController recycleritemviewcontroller = (RecyclerItemViewController)map.get(dealdetailsviewtype);
            if (detailsViewTypes.contains(dealdetailsviewtype))
            {
                if (recycleritemviewcontroller.isReady())
                {
                    updateItem(dealdetailsviewtype, recycleritemviewcontroller);
                } else
                if (recycleritemviewcontroller.isUnavailable())
                {
                    removeItem(dealdetailsviewtype);
                }
            } else
            if (recycleritemviewcontroller.isReady())
            {
                insertItem(dealdetailsviewtype, recycleritemviewcontroller);
            }
        } while (true);
    }

    public int getFirstPositionForItem(DealDetailsViewType dealdetailsviewtype)
    {
        int j = detailsViewTypes.size();
        for (int i = 0; i <= j; i++)
        {
            if (dealdetailsviewtype == detailsViewTypes.get(i))
            {
                return i;
            }
        }

        return 0;
    }

    public int getItemCount()
    {
        if (viewControllersMap != null)
        {
            return viewControllersMap.size();
        } else
        {
            return 0;
        }
    }

    public int getItemViewType(int i)
    {
        return ((DealDetailsViewType)detailsViewTypes.get(i)).ordinal();
    }

    public void insertItem(DealDetailsViewType dealdetailsviewtype, RecyclerItemViewController recycleritemviewcontroller)
    {
        int i = getPreviousItemPosition(dealdetailsviewtype);
        if (i >= -1)
        {
            insertItem(dealdetailsviewtype, recycleritemviewcontroller, i + 1);
        }
    }

    public void insertItem(DealDetailsViewType dealdetailsviewtype, RecyclerItemViewController recycleritemviewcontroller, int i)
    {
        if (!detailsViewTypes.contains(dealdetailsviewtype))
        {
            viewControllersMap.put(dealdetailsviewtype, recycleritemviewcontroller);
            detailsViewTypes.add(i, dealdetailsviewtype);
            notifyItemRangeInserted(i, 1);
        }
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        i = getItemViewType(i);
        Object obj = DealDetailsViewType.values()[i];
        obj = (RecyclerItemViewController)viewControllersMap.get(obj);
        viewholder = (RecyclerItemViewHolder)viewholder;
        viewholder.bind(((RecyclerItemViewController) (obj)).getModel(), ((RecyclerItemViewController) (obj)).getCallback());
        viewholder.populateViews();
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        Object obj;
        DealDetailsViewType dealdetailsviewtype;
        dealdetailsviewtype = DealDetailsViewType.values()[i];
        obj = null;
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[];

            static 
            {
                $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType = new int[DealDetailsViewType.values().length];
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.HEADER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.DATE_TIME_FINDER_RESERVATION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.VERTICALLY_EXPOSED_MULTI_OPTIONS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.INCENTIVES.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.MERCHANT_RECOMMENDATION.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.MARKETPLACE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.HIGHLIGHTS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.GIFTING.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.CAB_WIDGETS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.WHAT_YOU_GET.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.FINE_PRINT.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.COMPANY_INFO.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.DIRECTIONS.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.ADDITIONAL_INFO.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.MORE_INFO.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.AMENITIES.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.OTHER_DETAILS.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.TIPS.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.Q_AND_A.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.CAV_WIDGETS.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.LIVE_CHAT.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.TRAVEL_TRIPADVISOR_REVIEWS.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.TRAVEL_UGC_REVIEWS.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$models$dealdetails$DealDetailsViewType[DealDetailsViewType.DELIVERY_ESTIMATION.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.models.dealdetails.DealDetailsViewType[dealdetailsviewtype.ordinal()];
        JVM INSTR tableswitch 1 24: default 128
    //                   1 140
    //                   2 158
    //                   3 176
    //                   4 194
    //                   5 212
    //                   6 230
    //                   7 248
    //                   8 266
    //                   9 284
    //                   10 302
    //                   11 320
    //                   12 338
    //                   13 356
    //                   14 374
    //                   15 392
    //                   16 410
    //                   17 429
    //                   18 448
    //                   19 467
    //                   20 486
    //                   21 505
    //                   22 524
    //                   23 543
    //                   24 562;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
_L1:
        viewgroup = obj;
_L27:
        ButterKnife.bind(this, ((RecyclerItemViewHolder) (viewgroup)).itemView);
        return viewgroup;
_L2:
        viewgroup = new DetailsHeaderViewHolder(inflateItemView(0x7f0301c6, viewgroup));
        continue; /* Loop/switch isn't completed */
_L3:
        viewgroup = new DateTimeFinderReservationViewHolder(inflateItemView(0x7f0301c4, viewgroup));
        continue; /* Loop/switch isn't completed */
_L4:
        viewgroup = new ExposedMultiOptionsViewHolder(inflateItemView(0x7f0301d5, viewgroup));
        continue; /* Loop/switch isn't completed */
_L5:
        viewgroup = new IncentivesViewHolder(inflateItemView(0x7f0301cb, viewgroup));
        continue; /* Loop/switch isn't completed */
_L6:
        viewgroup = new MerchantRecommendationsViewHolder(inflateItemView(0x7f0301ce, viewgroup));
        continue; /* Loop/switch isn't completed */
_L7:
        viewgroup = new MarketplaceViewHolder(inflateItemView(0x7f0301cd, viewgroup));
        continue; /* Loop/switch isn't completed */
_L8:
        viewgroup = new HighlightsViewHolder(inflateItemView(0x7f0301ca, viewgroup));
        continue; /* Loop/switch isn't completed */
_L9:
        viewgroup = new GiftingViewHolder(inflateItemView(0x7f0301c9, viewgroup));
        continue; /* Loop/switch isn't completed */
_L10:
        viewgroup = new CabWidgetsViewHolder(inflateItemView(0x7f0301c1, viewgroup));
        continue; /* Loop/switch isn't completed */
_L11:
        viewgroup = new WhatYouGetViewHolder(inflateItemView(0x7f0301d6, viewgroup));
        continue; /* Loop/switch isn't completed */
_L12:
        viewgroup = new FinePrintViewHolder(inflateItemView(0x7f0301c8, viewgroup));
        continue; /* Loop/switch isn't completed */
_L13:
        viewgroup = new CompanyInfoViewHolder(inflateItemView(0x7f0301c3, viewgroup));
        continue; /* Loop/switch isn't completed */
_L14:
        viewgroup = new DirectionsViewHolder(inflateItemView(0x7f0301c7, viewgroup));
        continue; /* Loop/switch isn't completed */
_L15:
        viewgroup = new AdditionalInfoViewHolder(inflateItemView(0x7f0301bf, viewgroup));
        continue; /* Loop/switch isn't completed */
_L16:
        viewgroup = new MoreInfoViewHolder(inflateItemView(0x7f0301cf, viewgroup));
        continue; /* Loop/switch isn't completed */
_L17:
        viewgroup = new AmenitiesViewHolder(inflateItemView(0x7f0301c0, viewgroup));
        continue; /* Loop/switch isn't completed */
_L18:
        viewgroup = new OtherDetailsViewHolder(inflateItemView(0x7f0301d0, viewgroup));
        continue; /* Loop/switch isn't completed */
_L19:
        viewgroup = new TipsViewHolder(inflateItemView(0x7f0301d2, viewgroup));
        continue; /* Loop/switch isn't completed */
_L20:
        viewgroup = new QAndAViewHolder(inflateItemView(0x7f0301d1, viewgroup));
        continue; /* Loop/switch isn't completed */
_L21:
        viewgroup = new CavWidgetsViewHolder(inflateItemView(0x7f0301c2, viewgroup));
        continue; /* Loop/switch isn't completed */
_L22:
        viewgroup = new LiveChatViewHolder(inflateItemView(0x7f0301cc, viewgroup));
        continue; /* Loop/switch isn't completed */
_L23:
        viewgroup = new TripAdvisorReviewsViewHolder(inflateItemView(0x7f0301d3, viewgroup));
        continue; /* Loop/switch isn't completed */
_L24:
        viewgroup = new TravelUgcReviewsViewHolder(inflateItemView(0x7f0301d4, viewgroup));
        continue; /* Loop/switch isn't completed */
_L25:
        viewgroup = new DeliveryEstimationViewHolder(inflateItemView(0x7f0301c5, viewgroup));
        if (true) goto _L27; else goto _L26
_L26:
    }

    public void onViewAttachedToWindow(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
label0:
        {
            super.onViewAttachedToWindow(viewholder);
            if (DealDetailsViewType.HEADER == DealDetailsViewType.values()[viewholder.getItemViewType()] && onHeaderLoadedListener != null)
            {
                if (viewControllersMap.size() != 1)
                {
                    break label0;
                }
                onHeaderLoadedListener.onHeaderLoaded((DetailsHeaderViewHolder)viewholder);
            }
            return;
        }
        onHeaderLoadedListener.onHeaderReloaded((DetailsHeaderViewHolder)viewholder);
    }

    public void removeItem(DealDetailsViewType dealdetailsviewtype)
    {
        int i = detailsViewTypes.indexOf(dealdetailsviewtype);
        viewControllersMap.remove(dealdetailsviewtype);
        detailsViewTypes.remove(dealdetailsviewtype);
        notifyItemChanged(i);
    }

    public void setOnHeaderLoadedListener(OnRecyclerViewHeaderLoadedListener onrecyclerviewheaderloadedlistener)
    {
        onHeaderLoadedListener = onrecyclerviewheaderloadedlistener;
    }

    public void updateItem(DealDetailsViewType dealdetailsviewtype, RecyclerItemViewController recycleritemviewcontroller)
    {
        viewControllersMap.put(dealdetailsviewtype, recycleritemviewcontroller);
        notifyItemChanged(detailsViewTypes.indexOf(dealdetailsviewtype));
    }
}
