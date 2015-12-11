// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.DealSummary;
import com.groupon.models.nst.DealImpressionMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.core.AbTestService;
import com.groupon.util.DealUtils;
import com.groupon.util.ImageUrl;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LayoutUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.view.UrlImageView;
import com.groupon.view.dealcards.DealCardView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.getaways.carousel:
//            DealCardViewPresenter

public class DealsRecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class DealCardViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
        implements DealCardView
    {

        public LinearLayout badgesContainer;
        public TextView badgesTextView;
        public UrlImageView dealImageView;
        public TextView dealIncentiveTitle;
        public TextView dealsBoughtView;
        public TextView gbucksTextView;
        public TextView goodsConnectedMarketPlace;
        public TextView locationTextView;
        public TextView mobileOnly;
        public View newSoldOutBannerContainer;
        public TextView newSoldOutBannerText;
        public FrameLayout priceContainer;
        public TextView priceTextView;
        public TextView referencePriceTextView;
        Drawable soldOutDrawable;
        public TextView titleView;
        public TextView urgencyPricingLabel;

        public void displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption displayoption, boolean flag)
        {
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag5 = false;
            boolean flag6 = false;
            boolean flag7 = false;
            boolean flag8 = false;
            boolean flag9 = false;
            boolean flag1 = false;
            boolean flag10 = false;
            boolean flag2 = false;
            int i = 0;
            static class _cls1
            {

                static final int $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[];

                static 
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption = new int[com.groupon.view.dealcards.DealCardView.DisplayOption.values().length];
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.LOCATION.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.INCENTIVE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.PRICE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.REFERENCE_PRICE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.G_BUCKS.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.MOBILE_ONLY.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.URGENT_INFO.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.BOUGHTS.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.SOLD_OUT.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.GOODS_CONNECTED_MARKETPLACE.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.BADGES.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.groupon.view.dealcards.DealCardView.DisplayOption[displayoption.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                displayoption = locationTextView;
                if (!flag)
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 2: // '\002'
                displayoption = dealIncentiveTitle;
                if (flag)
                {
                    i = ((flag3) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 3: // '\003'
                displayoption = priceTextView;
                if (flag)
                {
                    i = ((flag4) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 4: // '\004'
                displayoption = referencePriceTextView;
                if (flag)
                {
                    i = ((flag5) ? 1 : 0);
                } else
                {
                    i = 4;
                }
                displayoption.setVisibility(i);
                return;

            case 5: // '\005'
                displayoption = gbucksTextView;
                if (flag)
                {
                    i = ((flag6) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 6: // '\006'
                displayoption = mobileOnly;
                if (flag)
                {
                    i = ((flag7) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 7: // '\007'
                displayoption = urgencyPricingLabel;
                if (flag)
                {
                    i = ((flag8) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 8: // '\b'
                displayoption = dealsBoughtView;
                if (flag)
                {
                    i = ((flag9) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 9: // '\t'
                displayoption = newSoldOutBannerContainer;
                FrameLayout framelayout;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                displayoption = newSoldOutBannerText;
                if (flag)
                {
                    i = ((flag1) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                framelayout = priceContainer;
                if (flag)
                {
                    displayoption = soldOutDrawable;
                } else
                {
                    displayoption = null;
                }
                framelayout.setForeground(displayoption);
                return;

            case 10: // '\n'
                displayoption = goodsConnectedMarketPlace;
                if (flag)
                {
                    i = ((flag10) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                displayoption.setVisibility(i);
                return;

            case 11: // '\013'
                displayoption = badgesTextView;
                break;
            }
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            displayoption.setVisibility(i);
            displayoption = badgesContainer;
            if (flag)
            {
                i = ((flag2) ? 1 : 0);
            } else
            {
                i = 8;
            }
            displayoption.setVisibility(i);
        }

        public void setBadges(CharSequence charsequence, int i, int j)
        {
            badgesTextView.setText(charsequence);
            badgesTextView.setTextColor(i);
            badgesTextView.setBackgroundColor(j);
        }

        public void setBoughts(CharSequence charsequence)
        {
            dealsBoughtView.setText(charsequence);
        }

        public void setGBucks(CharSequence charsequence)
        {
            gbucksTextView.setText(charsequence);
        }

        public void setGoodsConnectedMarketPlaceText(CharSequence charsequence)
        {
            goodsConnectedMarketPlace.setText(charsequence);
        }

        public void setImage(ImageUrl imageurl)
        {
            dealImageView.setImageUrl(imageurl);
        }

        public void setIncentiveText(CharSequence charsequence)
        {
            dealIncentiveTitle.setText(charsequence);
        }

        public void setLocation(CharSequence charsequence)
        {
            locationTextView.setText(charsequence);
        }

        public void setPrice(CharSequence charsequence)
        {
            priceTextView.setText(charsequence);
        }

        public void setPriceColor(int i)
        {
            priceTextView.setTextColor(i);
        }

        public void setRating(double d)
        {
        }

        public void setReferencePrice(CharSequence charsequence)
        {
            referencePriceTextView.setText(charsequence);
        }

        public void setSoldOutText(CharSequence charsequence)
        {
            newSoldOutBannerText.setText(charsequence);
        }

        public void setTitle(CharSequence charsequence)
        {
            titleView.setText(charsequence);
        }

        public void setUrgentInfo(CharSequence charsequence)
        {
            urgencyPricingLabel.setText(charsequence);
        }

        public void strikePrice(boolean flag)
        {
        }

        public void strikeReferencePrice(boolean flag)
        {
            if (flag)
            {
                referencePriceTextView.setPaintFlags(referencePriceTextView.getPaintFlags() | 0x10);
                return;
            } else
            {
                referencePriceTextView.setPaintFlags(referencePriceTextView.getPaintFlags() & 0xffffffef);
                return;
            }
        }

        public DealCardViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private class InternalOnClickListener
        implements android.view.View.OnClickListener
    {

        final DealsRecyclerViewAdapter this$0;

        public void onClick(View view)
        {
            if (onDealClickListener != null)
            {
                onDealClickListener.onClick(view);
            }
        }

        private InternalOnClickListener()
        {
            this$0 = DealsRecyclerViewAdapter.this;
            super();
        }

    }


    private final AbTestService abTestService;
    private final List deals = new ArrayList();
    private final IncentivesUtil incentivesUtil;
    private final String keyString;
    private final LayoutUtil layoutUtil;
    private final LoggingUtils loggingUtils;
    private final String nstChannel;
    private android.view.View.OnClickListener onDealClickListener;
    private final DealCardViewPresenter presenter;

    public DealsRecyclerViewAdapter(LoggingUtils loggingutils, IncentivesUtil incentivesutil, LayoutUtil layoututil, AbTestService abtestservice, DealCardViewPresenter dealcardviewpresenter, String s, String s1)
    {
        loggingUtils = loggingutils;
        incentivesUtil = incentivesutil;
        layoutUtil = layoututil;
        abTestService = abtestservice;
        nstChannel = s;
        keyString = s1;
        presenter = dealcardviewpresenter;
    }

    private void alignViews(DealCardViewHolder dealcardviewholder, DealSummary dealsummary)
    {
        layoutUtil.setStartViewEndView(dealcardviewholder.locationTextView, dealcardviewholder.referencePriceTextView);
        layoutUtil.setStartViewEndView(dealcardviewholder.urgencyPricingLabel, dealcardviewholder.priceTextView);
        layoutUtil.setStartViewEndView(dealcardviewholder.mobileOnly, dealcardviewholder.priceTextView);
        layoutUtil.setStartViewEndView(dealcardviewholder.dealIncentiveTitle, dealcardviewholder.priceTextView);
        layoutUtil.setStartViewEndView(dealcardviewholder.gbucksTextView, dealcardviewholder.priceTextView);
        layoutUtil.setStartViewEndView(dealcardviewholder.goodsConnectedMarketPlace, dealcardviewholder.priceTextView);
        layoutUtil.setDrawableStart(dealcardviewholder.mobileOnly, 0x7f020286);
        if (DealUtils.isGoodsShoppingDeal(dealsummary))
        {
            layoutUtil.setStartViewEndView(dealcardviewholder.dealsBoughtView, dealcardviewholder.referencePriceTextView);
            layoutUtil.alignViewBaselines(dealcardviewholder.dealsBoughtView, dealcardviewholder.referencePriceTextView);
            return;
        } else
        {
            layoutUtil.setStartViewEndView(dealcardviewholder.dealsBoughtView, dealcardviewholder.priceTextView);
            layoutUtil.alignViewBaselines(dealcardviewholder.dealsBoughtView, dealcardviewholder.priceTextView);
            return;
        }
    }

    private JsonEncodedNSTField getDealImpressionExtraInfo(AbstractDeal abstractdeal)
    {
        Object obj = JsonEncodedNSTField.NULL_JSON_NST_FIELD;
        if (abstractdeal != null)
        {
            obj = new DealImpressionMetadata(abstractdeal.derivedPricingMetadataOfferType, incentivesUtil.getIncentivePromoCode(abstractdeal), abstractdeal.getDealStatus());
        }
        return ((JsonEncodedNSTField) (obj));
    }

    public DealSummary getItem(int i)
    {
        return (DealSummary)deals.get(i);
    }

    public int getItemCount()
    {
        return deals.size();
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((DealCardViewHolder)viewholder, i);
    }

    public void onBindViewHolder(DealCardViewHolder dealcardviewholder, int i)
    {
        DealSummary dealsummary = getItem(i);
        presenter.present(dealcardviewholder, dealsummary);
        alignViews(dealcardviewholder, dealsummary);
        loggingUtils.logDealImpressionV1(nstChannel, "", dealsummary, i, getDealImpressionExtraInfo(dealsummary), keyString, abTestService, true, true, true);
    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public DealCardViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300bd, viewgroup, false);
        viewgroup.setOnClickListener(new InternalOnClickListener(null));
        return new DealCardViewHolder(viewgroup);
    }

    public void setDeals(List list, boolean flag)
    {
        if (flag)
        {
            int i = deals.size();
            deals.addAll(list);
            notifyItemRangeInserted(i + 1, list.size());
            return;
        } else
        {
            deals.clear();
            deals.addAll(list);
            notifyDataSetChanged();
            return;
        }
    }

    public void setOnDealClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onDealClickListener = onclicklistener;
    }

}
