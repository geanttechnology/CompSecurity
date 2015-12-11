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
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingUtilityViewModel

public class SoldItemsViewHolder extends ViewHolder
{

    private final TextView allSoldMsgText;
    private final TextView gmvDuration;
    private final TextView noOfAwaitingPayment;
    private final TextView noOfSoldItems;
    private final TextView noPaidFor;
    private final TextView oopsSoldText;
    private final View paidForBoard;
    private final View paymentBoard;
    private final View paymentSeparator;
    private final Resources resources;
    private final View soldBoard;
    private final View soldDashBoard;
    private final View soldTotalBoard;
    private final TextView totalSold;

    public SoldItemsViewHolder(View view)
    {
        super(view);
        resources = view.getResources();
        String s = resources.getString(0x7f07046f);
        String s1 = (new StringBuilder()).append(s).append("\n").append(resources.getString(0x7f07046e)).toString();
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s1);
        int i = s.length();
        int j = s1.length();
        spannablestringbuilder.setSpan(new TextAppearanceSpan(view.getContext(), 0x7f0a0152), i, j, 33);
        spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d00df)), i, j, 33);
        noOfSoldItems = (TextView)view.findViewById(0x7f1002b4);
        soldBoard = view.findViewById(0x7f1002a3);
        soldDashBoard = view.findViewById(0x7f1002b3);
        soldTotalBoard = view.findViewById(0x7f1002b0);
        paymentBoard = view.findViewById(0x7f1002b1);
        paymentSeparator = view.findViewById(0x7f1002b5);
        paidForBoard = view.findViewById(0x7f1002ba);
        noOfAwaitingPayment = (TextView)view.findViewById(0x7f1002b2);
        noPaidFor = (TextView)view.findViewById(0x7f1002bb);
        allSoldMsgText = (TextView)view.findViewById(0x7f1002b6);
        totalSold = (TextView)view.findViewById(0x7f1002bc);
        gmvDuration = (TextView)view.findViewById(0x7f1002bd);
        oopsSoldText = (TextView)view.findViewById(0x7f10021a);
        oopsSoldText.setText(spannablestringbuilder);
        soldBoard.setOnClickListener(this);
        paymentBoard.setOnClickListener(this);
        paidForBoard.setOnClickListener(this);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        return viewmodel != null && (viewmodel instanceof SellingUtilityViewModel);
    }

    public void bind(ViewModel viewmodel)
    {
        byte byte0;
label0:
        {
            byte0 = 8;
            super.bind(viewmodel);
            DeviceConfiguration.getAsync();
            if (viewmodel instanceof SellingUtilityViewModel)
            {
                viewmodel = (SellingUtilityViewModel)viewmodel;
                if (!((SellingUtilityViewModel) (viewmodel)).isSoldFailure)
                {
                    break label0;
                }
                oopsSoldText.setVisibility(0);
                soldDashBoard.setVisibility(8);
                soldTotalBoard.setVisibility(8);
            }
            return;
        }
        oopsSoldText.setVisibility(8);
        soldDashBoard.setVisibility(0);
        soldTotalBoard.setVisibility(0);
        noOfSoldItems.setText(String.valueOf(((SellingUtilityViewModel) (viewmodel)).noOfSoldItems));
        Object obj;
        boolean flag;
        int i;
        int j;
        if ((((SellingUtilityViewModel) (viewmodel)).awaitPayment <= 0 || ((SellingUtilityViewModel) (viewmodel)).isAwaitingPaymentDisabled) && ((SellingUtilityViewModel) (viewmodel)).paidShipNow <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            noOfAwaitingPayment.setText(String.valueOf(((SellingUtilityViewModel) (viewmodel)).awaitPayment));
            noPaidFor.setText(String.valueOf(((SellingUtilityViewModel) (viewmodel)).paidShipNow));
        }
        obj = allSoldMsgText;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj)).setVisibility(i);
        obj = noOfAwaitingPayment;
        if (!flag && ((SellingUtilityViewModel) (viewmodel)).awaitPayment > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj)).setVisibility(i);
        if (!flag && !((SellingUtilityViewModel) (viewmodel)).isAwaitingPaymentDisabled && ((SellingUtilityViewModel) (viewmodel)).awaitPayment > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj = paymentBoard;
        if (i != 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((View) (obj)).setVisibility(j);
        obj = paymentSeparator;
        if (i != 0 && ((SellingUtilityViewModel) (viewmodel)).paidShipNow > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = paidForBoard;
        i = byte0;
        if (!flag)
        {
            i = byte0;
            if (((SellingUtilityViewModel) (viewmodel)).paidShipNow > 0)
            {
                i = 0;
            }
        }
        ((View) (obj)).setVisibility(i);
        totalSold.setVisibility(0);
        gmvDuration.setVisibility(0);
        totalSold.setText(((SellingUtilityViewModel) (viewmodel)).gmv);
        gmvDuration.setText(resources.getQuantityString(0x7f08002c, ((SellingUtilityViewModel) (viewmodel)).gmvDuration, new Object[] {
            Integer.valueOf(((SellingUtilityViewModel) (viewmodel)).gmvDuration)
        }));
    }

    public void onClick(View view)
    {
        if (!(model instanceof SellingUtilityViewModel)) goto _L2; else goto _L1
_L1:
        SellingUtilityViewModel sellingutilityviewmodel = (SellingUtilityViewModel)model;
        view.getId();
        JVM INSTR lookupswitch 3: default 56
    //                   2131755683: 57
    //                   2131755697: 76
    //                   2131755706: 92;
           goto _L3 _L4 _L5 _L6
_L3:
        return;
_L4:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD;
        sellingutilityviewmodel.soldItemType = "soldAll";
_L2:
        super.onClick(view);
        return;
_L5:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD;
        sellingutilityviewmodel.soldItemType = "AwaitingPayment";
        continue; /* Loop/switch isn't completed */
_L6:
        sellingutilityviewmodel.sellListType = com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD;
        sellingutilityviewmodel.soldItemType = "AwaitingShipment";
        if (true) goto _L2; else goto _L7
_L7:
    }
}
