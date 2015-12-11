// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.db.models.MarketRateResult;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.util.ImageUrl;
import com.groupon.util.LoggingUtils;
import com.groupon.view.UrlImageView;
import com.groupon.view.dealcards.DealCardView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.getaways.carousel:
//            HotelDealCardViewPresenter

public class GetawaysWidgetRecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class DealCardViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
        implements DealCardView
    {

        UrlImageView imageView;
        TextView locationTextView;
        TextView priceTextView;
        TextView referencePriceTextView;
        TextView titleView;

        public void displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption displayoption, boolean flag)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[];

                static 
                {
                    $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption = new int[com.groupon.view.dealcards.DealCardView.DisplayOption.values().length];
                    try
                    {
                        $SwitchMap$com$groupon$view$dealcards$DealCardView$DisplayOption[com.groupon.view.dealcards.DealCardView.DisplayOption.REFERENCE_PRICE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

            switch (_cls1..SwitchMap.com.groupon.view.dealcards.DealCardView.DisplayOption[displayoption.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                displayoption = referencePriceTextView;
                break;
            }
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            displayoption.setVisibility(i);
        }

        public void setBadges(CharSequence charsequence, int i, int j)
        {
        }

        public void setBoughts(CharSequence charsequence)
        {
        }

        public void setGBucks(CharSequence charsequence)
        {
        }

        public void setGoodsConnectedMarketPlaceText(CharSequence charsequence)
        {
        }

        public void setImage(ImageUrl imageurl)
        {
            imageView.setImageUrl(imageurl);
        }

        public void setIncentiveText(CharSequence charsequence)
        {
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
        }

        public void setTitle(CharSequence charsequence)
        {
            titleView.setText(charsequence);
        }

        public void setUrgentInfo(CharSequence charsequence)
        {
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

    private class OnDealCardViewClickListener
        implements android.view.View.OnClickListener
    {

        final GetawaysWidgetRecyclerViewAdapter this$0;

        public void onClick(View view)
        {
            onWidgetClickListener.onDealClicked(view);
        }

        private OnDealCardViewClickListener()
        {
            this$0 = GetawaysWidgetRecyclerViewAdapter.this;
            super();
        }

    }

    private class OnSeeAllButtonClickListener
        implements android.view.View.OnClickListener
    {

        final GetawaysWidgetRecyclerViewAdapter this$0;

        public void onClick(View view)
        {
            onWidgetClickListener.onSeeAllButtonClicked();
        }

        private OnSeeAllButtonClickListener()
        {
            this$0 = GetawaysWidgetRecyclerViewAdapter.this;
            super();
        }

    }

    public static interface OnWidgetClickListener
    {

        public abstract void onDealClicked(View view);

        public abstract void onSeeAllButtonClicked();
    }

    public static class SeeAllButtonViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        public SeeAllButtonViewHolder(View view)
        {
            super(view);
        }
    }


    private static final int DEAL_CARD_VIEW_TYPE_ID = 0x7f0300fa;
    private static final int MAX_ITEMS = 6;
    private static final int SEE_ALL_BUTTON_VIEW_TYPE_ID = 0x7f0300f6;
    private static final String WIDGET_IMPRESSION_SPECIFIER = "Getaways_Widget_Nearby_Tonight";
    private final String channel;
    private final List deals = new ArrayList();
    private final LoggingUtils loggingUtils;
    private final String nstChannel;
    private OnWidgetClickListener onWidgetClickListener;
    private final HotelDealCardViewPresenter presenter;

    public GetawaysWidgetRecyclerViewAdapter(HotelDealCardViewPresenter hoteldealcardviewpresenter, String s, String s1, LoggingUtils loggingutils)
    {
        presenter = hoteldealcardviewpresenter;
        channel = s;
        nstChannel = s1;
        loggingUtils = loggingutils;
    }

    private boolean isSeeAllButtonVisible()
    {
        return getItemCount() == 7;
    }

    public MarketRateResult getItem(int i)
    {
        return (MarketRateResult)deals.get(i);
    }

    public int getItemCount()
    {
        int j = Math.min(deals.size(), 6);
        int i;
        if (j == 6)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + j;
    }

    public int getItemViewType(int i)
    {
        return !isSeeAllButtonVisible() || i != 6 ? 0x7f0300fa : 0x7f0300f6;
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (getItemViewType(i) == 0x7f0300fa)
        {
            viewholder = (DealCardViewHolder)viewholder;
            MarketRateResult marketrateresult = getItem(i);
            presenter.present(viewholder, marketrateresult);
            loggingUtils.logMarketRateDealImpression(nstChannel, marketrateresult.remoteId, i, marketrateresult.productType);
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        default:
            return null;

        case 2130903290: 
            viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300fa, viewgroup, false);
            viewgroup.setOnClickListener(new OnDealCardViewClickListener(null));
            return new DealCardViewHolder(viewgroup);

        case 2130903286: 
            viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300f6, viewgroup, false);
            viewgroup.setOnClickListener(new OnSeeAllButtonClickListener(null));
            return new SeeAllButtonViewHolder(viewgroup);
        }
    }

    public void setDeals(List list)
    {
        deals.clear();
        deals.addAll(list);
        if (list.size() > 0)
        {
            loggingUtils.logImpression("", "hotel", "Getaways_Widget_Nearby_Tonight", channel, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        }
        notifyDataSetChanged();
    }

    public void setOnWidgetClickListener(OnWidgetClickListener onwidgetclicklistener)
    {
        onWidgetClickListener = onwidgetclicklistener;
    }

}
