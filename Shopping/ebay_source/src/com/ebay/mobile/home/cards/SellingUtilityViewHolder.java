// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.RecordStatusEnum;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            PaddingSpan, SellingUtilityViewModel

public class SellingUtilityViewHolder extends ViewHolder
{

    private final View activeCountBoard;
    private final View activeCountSeparator;
    private final View activeDashBoard;
    private final TextView activeItemsTextView;
    private final View activeStatBoard;
    private final TextView allRelisted;
    private final TextView allSoldMsgText;
    private final View bidsContainer;
    private final TextView gmvDuration;
    private final View haveOffersSeparator;
    private final TextView listingWithBidsTextView;
    private final TextView noOfAwaitingPayment;
    private final TextView noOfSoldItems;
    private final TextView noOfUnSoldItems;
    private final TextView noOffersOrBidsText;
    private final TextView noPaidFor;
    public final TextView notYetRelistedText;
    private final View offersContainer;
    private final TextView offersTextView;
    private final TextView oopsActiveText;
    private final TextView oopsSoldText;
    private final TextView oopsSoldTotalText;
    private final TextView oopsUnSoldText;
    private final View paidForBoard;
    private final View paymentBoard;
    private final View paymentSeparator;
    private final Resources resources;
    private final View soldBoard;
    private final View soldCountBoard;
    private final View soldCountSeparator;
    private final View soldDashBoard;
    private final View soldStatBoard;
    private final View soldTotalBoard;
    private final TextView totalSold;
    private final View unsoldCountBoard;
    private final View unsoldCountSeparator;
    private final View unsoldDashBoard;

    public SellingUtilityViewHolder(View view)
    {
        super(view);
        resources = view.getResources();
        android.content.Context context = view.getContext();
        String s = resources.getString(0x7f07046d);
        int i = s.length();
        int j = resources.getColor(0x7f0d00df);
        Object obj = resources.getString(0x7f07046f);
        int k = ((String) (obj)).length();
        Object obj1 = (new StringBuilder()).append(((String) (obj))).append("\n").append(resources.getString(0x7f07046e)).toString();
        obj = new SpannableStringBuilder(((CharSequence) (obj1)));
        int l = ((String) (obj1)).length();
        ((SpannableStringBuilder) (obj)).setSpan(new TextAppearanceSpan(context, 0x7f0a0152), k, l, 33);
        ((SpannableStringBuilder) (obj)).setSpan(new ForegroundColorSpan(j), k, l, 33);
        Object obj2 = (new StringBuilder()).append(s).append("\n").append(resources.getString(0x7f070470)).toString();
        obj1 = new SpannableStringBuilder(((CharSequence) (obj2)));
        k = ((String) (obj2)).length();
        ((SpannableStringBuilder) (obj1)).setSpan(new TextAppearanceSpan(context, 0x7f0a0152), i, k, 33);
        ((SpannableStringBuilder) (obj1)).setSpan(new ForegroundColorSpan(j), i, k, 33);
        s = (new StringBuilder()).append(s).append("\n").append(resources.getString(0x7f070468)).toString();
        obj2 = new SpannableStringBuilder(s);
        k = s.length();
        ((SpannableStringBuilder) (obj2)).setSpan(new TextAppearanceSpan(context, 0x7f0a0152), i, k, 33);
        ((SpannableStringBuilder) (obj2)).setSpan(new ForegroundColorSpan(j), i, k, 33);
        offersContainer = view.findViewById(0x7f100224);
        haveOffersSeparator = view.findViewById(0x7f10021e);
        bidsContainer = view.findViewById(0x7f10021b);
        activeItemsTextView = (TextView)view.findViewById(0x7f10021d);
        offersTextView = (TextView)view.findViewById(0x7f100225);
        listingWithBidsTextView = (TextView)view.findViewById(0x7f10021c);
        noOffersOrBidsText = (TextView)view.findViewById(0x7f10021f);
        noOfSoldItems = (TextView)view.findViewById(0x7f1002b4);
        paymentBoard = view.findViewById(0x7f1002b1);
        paymentSeparator = view.findViewById(0x7f1002b5);
        paidForBoard = view.findViewById(0x7f1002ba);
        noOfAwaitingPayment = (TextView)view.findViewById(0x7f1002b2);
        noPaidFor = (TextView)view.findViewById(0x7f1002bb);
        allSoldMsgText = (TextView)view.findViewById(0x7f1002b6);
        totalSold = (TextView)view.findViewById(0x7f1002bc);
        gmvDuration = (TextView)view.findViewById(0x7f1002bd);
        noOfUnSoldItems = (TextView)view.findViewById(0x7f1002d1);
        notYetRelistedText = (TextView)view.findViewById(0x7f1002d2);
        allRelisted = (TextView)view.findViewById(0x7f1002d3);
        unsoldDashBoard = view.findViewById(0x7f1002a2);
        soldDashBoard = view.findViewById(0x7f1002b3);
        soldBoard = view.findViewById(0x7f1002a3);
        activeDashBoard = view.findViewById(0x7f1002a1);
        activeStatBoard = view.findViewById(0x7f100222);
        soldTotalBoard = view.findViewById(0x7f1002b0);
        soldStatBoard = view.findViewById(0x7f1002b9);
        oopsActiveText = (TextView)view.findViewById(0x7f100223);
        if (oopsActiveText != null)
        {
            oopsActiveText.setText(((CharSequence) (obj2)));
        }
        oopsSoldText = (TextView)view.findViewById(0x7f1002a4);
        if (oopsSoldText != null)
        {
            oopsSoldText.setText(((CharSequence) (obj)));
        }
        oopsSoldTotalText = (TextView)view.findViewById(0x7f1002be);
        if (oopsSoldTotalText != null)
        {
            oopsSoldTotalText.setText(((CharSequence) (obj)));
        }
        oopsUnSoldText = (TextView)view.findViewById(0x7f1002d6);
        if (oopsUnSoldText != null)
        {
            oopsUnSoldText.setText(((CharSequence) (obj1)));
        }
        activeCountBoard = view.findViewById(0x7f100220);
        activeCountSeparator = view.findViewById(0x7f100221);
        unsoldCountBoard = view.findViewById(0x7f1002d4);
        unsoldCountSeparator = view.findViewById(0x7f1002d5);
        soldCountBoard = view.findViewById(0x7f1002b7);
        soldCountSeparator = view.findViewById(0x7f1002b8);
        if (soldBoard != null)
        {
            soldBoard.setOnClickListener(this);
        }
        if (paymentBoard != null)
        {
            paymentBoard.setOnClickListener(this);
        }
        if (paidForBoard != null)
        {
            paidForBoard.setOnClickListener(this);
        }
        if (activeDashBoard != null)
        {
            activeDashBoard.setOnClickListener(this);
        }
        if (offersContainer != null)
        {
            offersContainer.setOnClickListener(this);
        }
        if (unsoldDashBoard != null)
        {
            unsoldDashBoard.setOnClickListener(this);
        }
    }

    private Spannable getRelistedText(int i)
    {
        int j = String.valueOf(i).length();
        Object obj = resources.getQuantityString(0x7f080003, i, new Object[] {
            Integer.valueOf(i)
        });
        i = ((String) (obj)).length();
        obj = new SpannableString(((CharSequence) (obj)));
        ((Spannable) (obj)).setSpan(new AbsoluteSizeSpan((int)TypedValue.applyDimension(0, resources.getDimensionPixelSize(0x7f09015a), resources.getDisplayMetrics())), 0, j, 33);
        ((Spannable) (obj)).setSpan(new PaddingSpan(resources.getDimensionPixelSize(0x7f090051), resources.getDimensionPixelSize(0x7f09007a)), 0, j, 33);
        ((Spannable) (obj)).setSpan(new TextAppearanceSpan(notYetRelistedText.getContext(), 0x7f0a013d), j, i, 33);
        ((Spannable) (obj)).setSpan(new PaddingSpan(0.0F, 0.0F), j, i, 33);
        return ((Spannable) (obj));
    }

    public static int getSellingUtilityResource(com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup)
    {
        int k = 0;
        int j = 0;
        int i = 0;
        boolean flag5 = false;
        boolean flag4 = false;
        boolean flag3 = false;
        contentgroup = contentgroup.contents.iterator();
        do
        {
            if (!contentgroup.hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.next();
            if (contentrecord.type == ContentTypeEnum.ACTIVE)
            {
                if (contentrecord.activeListingsSummary != null)
                {
                    k = contentrecord.activeListingsSummary.numberOfActiveListings;
                }
                boolean flag;
                if (contentrecord.status == RecordStatusEnum.FAILURE)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag5 = flag;
            } else
            if (contentrecord.type == ContentTypeEnum.SOLD)
            {
                if (contentrecord.soldListingsSummary != null)
                {
                    j = contentrecord.soldListingsSummary.numberOfSoldItems;
                }
                boolean flag1;
                if (contentrecord.status == RecordStatusEnum.FAILURE || contentrecord.soldListingsSummary != null && contentrecord.soldListingsSummary.hasMoreSold)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag4 = flag1;
            } else
            if (contentrecord.type == ContentTypeEnum.UNSOLD)
            {
                if (contentrecord.unsoldListingsSummary != null)
                {
                    i = contentrecord.unsoldListingsSummary.numberOfUnsoldListings;
                }
                boolean flag2;
                if (contentrecord.status == RecordStatusEnum.FAILURE)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                flag3 = flag2;
            }
        } while (true);
        if (k == 0 && j > 0 && i == 0)
        {
            return flag5 ? 11 : 9;
        }
        if (k > 0 && j > 0 && i == 0 && !flag3)
        {
            return 11;
        }
        return k != 0 || i <= 0 || j <= 0 || flag4 ? 8 : 11;
    }

    private void goToNoOffersOrBids()
    {
        noOffersOrBidsText.setVisibility(0);
        offersContainer.setVisibility(8);
        haveOffersSeparator.setVisibility(8);
        bidsContainer.setVisibility(8);
    }

    public static boolean isValidModel(ViewModel viewmodel)
    {
        return viewmodel != null && (viewmodel instanceof SellingUtilityViewModel);
    }

    private void updateActiveDashBoard(SellingUtilityViewModel sellingutilityviewmodel)
    {
        boolean flag = false;
        if (sellingutilityviewmodel.isActiveFailure)
        {
            oopsActiveText.setVisibility(0);
            activeStatBoard.setVisibility(8);
            activeCountBoard.setVisibility(8);
            activeCountSeparator.setVisibility(8);
            return;
        }
        oopsActiveText.setVisibility(8);
        activeStatBoard.setVisibility(0);
        activeCountBoard.setVisibility(0);
        activeCountSeparator.setVisibility(0);
        if (sellingutilityviewmodel.noOfActiveItems > 0)
        {
            activeDashBoard.setVisibility(0);
            Object obj = resources;
            float f;
            int i;
            if (sellingutilityviewmodel.noOfActiveItems > 9999)
            {
                i = 0x7f0901d5;
            } else
            {
                i = 0x7f0900b1;
            }
            f = ((Resources) (obj)).getDimension(i);
            activeItemsTextView.setTextSize(0, f);
            activeItemsTextView.setText(String.valueOf(sellingutilityviewmodel.noOfActiveItems));
            if (sellingutilityviewmodel.haveNewOffers == 0 && sellingutilityviewmodel.listingsWithBids == 0)
            {
                goToNoOffersOrBids();
                return;
            }
            offersTextView.setText(String.valueOf(sellingutilityviewmodel.haveNewOffers));
            listingWithBidsTextView.setText(String.valueOf(sellingutilityviewmodel.listingsWithBids));
            noOffersOrBidsText.setVisibility(8);
            obj = offersContainer;
            if (sellingutilityviewmodel.haveNewOffers > 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
            obj = haveOffersSeparator;
            if (sellingutilityviewmodel.haveNewOffers > 0 && sellingutilityviewmodel.listingsWithBids > 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
            obj = bidsContainer;
            if (sellingutilityviewmodel.listingsWithBids > 0)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
            return;
        } else
        {
            activeDashBoard.setVisibility(8);
            return;
        }
    }

    private void updateSoldDashBoard(SellingUtilityViewModel sellingutilityviewmodel)
    {
        DeviceConfiguration.getAsync();
        if (soldDashBoard != null)
        {
            if (sellingutilityviewmodel.isSoldFailure)
            {
                oopsSoldText.setVisibility(0);
                soldTotalBoard.setVisibility(8);
                if (soldStatBoard != null)
                {
                    soldStatBoard.setVisibility(8);
                } else
                {
                    soldDashBoard.setVisibility(8);
                }
                soldCountBoard.setVisibility(8);
                soldCountSeparator.setVisibility(8);
            } else
            {
                oopsSoldText.setVisibility(8);
                if (soldStatBoard != null)
                {
                    soldStatBoard.setVisibility(0);
                } else
                {
                    soldDashBoard.setVisibility(8);
                }
                soldTotalBoard.setVisibility(0);
                soldCountBoard.setVisibility(0);
                soldCountSeparator.setVisibility(0);
                if (sellingutilityviewmodel.noOfSoldItems > 0)
                {
                    soldDashBoard.setVisibility(0);
                    Object obj = resources;
                    float f;
                    int i;
                    int j;
                    int k;
                    if (sellingutilityviewmodel.noOfSoldItems > 9999)
                    {
                        i = 0x7f0901d5;
                    } else
                    {
                        i = 0x7f0900b1;
                    }
                    f = ((Resources) (obj)).getDimension(i);
                    noOfSoldItems.setTextSize(0, f);
                    noOfSoldItems.setText(String.valueOf(sellingutilityviewmodel.noOfSoldItems));
                    if ((sellingutilityviewmodel.awaitPayment <= 0 || sellingutilityviewmodel.isAwaitingPaymentDisabled) && sellingutilityviewmodel.paidShipNow <= 0)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i == 0)
                    {
                        noOfAwaitingPayment.setText(String.valueOf(sellingutilityviewmodel.awaitPayment));
                        noPaidFor.setText(String.valueOf(sellingutilityviewmodel.paidShipNow));
                    }
                    obj = allSoldMsgText;
                    if (i != 0)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    ((TextView) (obj)).setVisibility(j);
                    obj = noOfAwaitingPayment;
                    if (i == 0 && sellingutilityviewmodel.awaitPayment > 0)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    ((TextView) (obj)).setVisibility(j);
                    if (i == 0 && !sellingutilityviewmodel.isAwaitingPaymentDisabled && sellingutilityviewmodel.awaitPayment > 0)
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    obj = paymentBoard;
                    if (j != 0)
                    {
                        k = 0;
                    } else
                    {
                        k = 8;
                    }
                    ((View) (obj)).setVisibility(k);
                    obj = paymentSeparator;
                    if (j != 0 && sellingutilityviewmodel.paidShipNow > 0)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    ((View) (obj)).setVisibility(j);
                    obj = paidForBoard;
                    if (i == 0 && sellingutilityviewmodel.paidShipNow > 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((View) (obj)).setVisibility(i);
                } else
                {
                    soldDashBoard.setVisibility(8);
                }
            }
        }
        if (oopsSoldTotalText != null)
        {
            if (sellingutilityviewmodel.isSoldFailure)
            {
                oopsSoldTotalText.setVisibility(0);
                totalSold.setVisibility(8);
                gmvDuration.setVisibility(8);
            } else
            {
                oopsSoldTotalText.setVisibility(8);
                totalSold.setVisibility(0);
                gmvDuration.setVisibility(0);
            }
        }
        totalSold.setText(sellingutilityviewmodel.gmv);
        gmvDuration.setText(resources.getQuantityString(0x7f08002c, sellingutilityviewmodel.gmvDuration, new Object[] {
            Integer.valueOf(sellingutilityviewmodel.gmvDuration)
        }));
    }

    private void updateUnSoldDashBoard(SellingUtilityViewModel sellingutilityviewmodel)
    {
        if (sellingutilityviewmodel.isUnSoldFailure)
        {
            unsoldDashBoard.setVisibility(0);
            oopsUnSoldText.setVisibility(0);
            unsoldCountBoard.setVisibility(8);
            unsoldCountSeparator.setVisibility(8);
            notYetRelistedText.setVisibility(8);
            allRelisted.setVisibility(8);
            return;
        }
        oopsUnSoldText.setVisibility(8);
        unsoldCountBoard.setVisibility(0);
        unsoldCountSeparator.setVisibility(0);
        if (sellingutilityviewmodel.noOfUnSoldItems > 0)
        {
            unsoldDashBoard.setVisibility(0);
            Resources resources1 = resources;
            float f;
            int i;
            if (sellingutilityviewmodel.noOfUnSoldItems > 9999)
            {
                i = 0x7f0901d5;
            } else
            {
                i = 0x7f0900b1;
            }
            f = resources1.getDimension(i);
            noOfUnSoldItems.setTextSize(0, f);
            noOfUnSoldItems.setText(String.valueOf(sellingutilityviewmodel.noOfUnSoldItems));
            if (sellingutilityviewmodel.notRelisted > 0)
            {
                notYetRelistedText.setVisibility(0);
                allRelisted.setVisibility(8);
                notYetRelistedText.setText(getRelistedText(sellingutilityviewmodel.notRelisted), android.widget.TextView.BufferType.SPANNABLE);
                return;
            } else
            {
                notYetRelistedText.setVisibility(8);
                allRelisted.setVisibility(0);
                return;
            }
        } else
        {
            unsoldDashBoard.setVisibility(8);
            return;
        }
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof SellingUtilityViewModel)
        {
            viewmodel = (SellingUtilityViewModel)viewmodel;
            if (activeDashBoard != null)
            {
                updateActiveDashBoard(viewmodel);
            }
            updateSoldDashBoard(viewmodel);
            if (unsoldDashBoard != null)
            {
                updateUnSoldDashBoard(viewmodel);
            }
            int i;
            boolean flag;
            if (((SellingUtilityViewModel) (viewmodel)).gmvAmount > 0.0D || ((SellingUtilityViewModel) (viewmodel)).isSoldFailure)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (soldBoard != null)
            {
                soldBoard.setClickable(flag);
            }
            i = getItemViewType();
            if (i == 10 || i == 11)
            {
                if (flag)
                {
                    if (soldDashBoard != null)
                    {
                        soldDashBoard.setOnClickListener(this);
                    }
                    if (soldTotalBoard != null)
                    {
                        soldTotalBoard.setOnClickListener(this);
                    }
                }
                if (soldDashBoard != null)
                {
                    soldDashBoard.setClickable(flag);
                }
                if (soldTotalBoard != null)
                {
                    soldTotalBoard.setClickable(flag);
                }
            }
        }
    }

    public void onClick(View view)
    {
        if (!(model instanceof SellingUtilityViewModel)) goto _L2; else goto _L1
_L1:
        SellingUtilityViewModel sellingutilityviewmodel = (SellingUtilityViewModel)model;
        view.getId();
        JVM INSTR lookupswitch 8: default 96
    //                   2131755556: 168
    //                   2131755681: 151
    //                   2131755682: 185
    //                   2131755683: 97
    //                   2131755696: 97
    //                   2131755697: 117
    //                   2131755699: 97
    //                   2131755706: 134;
           goto _L3 _L4 _L5 _L6 _L7 _L7 _L8 _L7 _L9
_L3:
        return;
_L7:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD;
        sellingutilityviewmodel.soldItemType = "soldAll";
_L2:
        super.onClick(view);
        return;
_L8:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD;
        sellingutilityviewmodel.soldItemType = "AwaitingPayment";
        continue; /* Loop/switch isn't completed */
_L9:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD;
        sellingutilityviewmodel.soldItemType = "AwaitingShipment";
        continue; /* Loop/switch isn't completed */
_L5:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE;
        sellingutilityviewmodel.activeItemType = "activeAll";
        continue; /* Loop/switch isn't completed */
_L4:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE;
        sellingutilityviewmodel.activeItemType = "NewOffers";
        continue; /* Loop/switch isn't completed */
_L6:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.UNSOLD;
        if (true) goto _L2; else goto _L10
_L10:
    }
}
