// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingUtilityViewModel

public class ActiveItemsViewHolder extends ViewHolder
{

    private final View activeDashBoard;
    public final TextView activeItemsTextView;
    private final View bidsContainer;
    private final View haveOffersSeparator;
    public final TextView listingWithBidsTextView;
    public final TextView noOffersOrBidsText;
    private final View offersContainer;
    public final TextView offersTextView;
    private final TextView oopsActiveText;

    public ActiveItemsViewHolder(View view)
    {
        super(view);
        Resources resources = view.getResources();
        String s = resources.getString(0x7f07046d);
        int i = s.length();
        s = (new StringBuilder()).append(s).append("\n").append(resources.getString(0x7f070468)).toString();
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        int j = s.length();
        spannablestringbuilder.setSpan(new TextAppearanceSpan(view.getContext(), 0x7f0a0152), i, j, 33);
        spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d00df)), i, j, 33);
        activeDashBoard = view.findViewById(0x7f100219);
        offersContainer = view.findViewById(0x7f100224);
        haveOffersSeparator = view.findViewById(0x7f10021e);
        bidsContainer = view.findViewById(0x7f10021b);
        activeItemsTextView = (TextView)view.findViewById(0x7f10021d);
        offersTextView = (TextView)view.findViewById(0x7f100225);
        listingWithBidsTextView = (TextView)view.findViewById(0x7f10021c);
        noOffersOrBidsText = (TextView)view.findViewById(0x7f10021f);
        oopsActiveText = (TextView)view.findViewById(0x7f10021a);
        oopsActiveText.setText(spannablestringbuilder);
        activeDashBoard.setOnClickListener(this);
        offersContainer.setOnClickListener(this);
    }

    private void goToNoOffersOrBids()
    {
        noOffersOrBidsText.setVisibility(0);
        offersContainer.setVisibility(8);
        haveOffersSeparator.setVisibility(8);
        bidsContainer.setVisibility(8);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        return viewmodel != null && (viewmodel instanceof SellingUtilityViewModel);
    }

    public void bind(ViewModel viewmodel)
    {
        boolean flag;
label0:
        {
            flag = false;
            super.bind(viewmodel);
            if (viewmodel instanceof SellingUtilityViewModel)
            {
                viewmodel = (SellingUtilityViewModel)viewmodel;
                if (!((SellingUtilityViewModel) (viewmodel)).isActiveFailure)
                {
                    break label0;
                }
                oopsActiveText.setVisibility(0);
                activeItemsTextView.setVisibility(8);
                noOffersOrBidsText.setVisibility(8);
                offersContainer.setVisibility(8);
                haveOffersSeparator.setVisibility(8);
                bidsContainer.setVisibility(8);
            }
            return;
        }
        oopsActiveText.setVisibility(8);
        activeItemsTextView.setVisibility(0);
        activeItemsTextView.setText(String.valueOf(((SellingUtilityViewModel) (viewmodel)).noOfActiveItems));
        if (((SellingUtilityViewModel) (viewmodel)).haveNewOffers == 0 && ((SellingUtilityViewModel) (viewmodel)).listingsWithBids == 0)
        {
            goToNoOffersOrBids();
            return;
        }
        offersTextView.setText(String.valueOf(((SellingUtilityViewModel) (viewmodel)).haveNewOffers));
        listingWithBidsTextView.setText(String.valueOf(((SellingUtilityViewModel) (viewmodel)).listingsWithBids));
        noOffersOrBidsText.setVisibility(8);
        View view = offersContainer;
        int i;
        if (((SellingUtilityViewModel) (viewmodel)).haveNewOffers > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = haveOffersSeparator;
        if (((SellingUtilityViewModel) (viewmodel)).haveNewOffers > 0 && ((SellingUtilityViewModel) (viewmodel)).listingsWithBids > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = bidsContainer;
        if (((SellingUtilityViewModel) (viewmodel)).listingsWithBids > 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void onClick(View view)
    {
        if (!(model instanceof SellingUtilityViewModel)) goto _L2; else goto _L1
_L1:
        SellingUtilityViewModel sellingutilityviewmodel = (SellingUtilityViewModel)model;
        view.getId();
        JVM INSTR lookupswitch 2: default 48
    //                   2131755545: 49
    //                   2131755556: 68;
           goto _L3 _L4 _L5
_L3:
        return;
_L4:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE;
        sellingutilityviewmodel.activeItemType = "activeAll";
_L2:
        super.onClick(view);
        return;
_L5:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE;
        sellingutilityviewmodel.activeItemType = "NewOffers";
        if (true) goto _L2; else goto _L6
_L6:
    }
}
