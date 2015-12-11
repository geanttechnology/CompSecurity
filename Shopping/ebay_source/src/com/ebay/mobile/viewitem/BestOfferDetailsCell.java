// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.bestoffer.BestOfferStatusLocale;
import com.ebay.mobile.bestoffer.BestOfferViewHelper;
import com.ebay.nautilus.domain.data.BestOffer;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemViewData, ItemViewActivity

public class BestOfferDetailsCell
{

    private ItemViewActivity a;
    private TextView amount;
    private TextView amountLabel;
    private LinearLayout parent;
    private TextView status;
    private TextView timeRemaining;
    private LinearLayout timeRemainingParent;

    public BestOfferDetailsCell(ItemViewActivity itemviewactivity)
    {
        a = itemviewactivity;
    }

    private boolean areDetailsVisible(Item item, ViewItemViewData viewitemviewdata)
    {
        String s;
        if (item.offers != null && !item.offers.isEmpty())
        {
            if ((TextUtils.isEmpty(s = MyApp.getPrefs().getCurrentUser()) || TextUtils.isEmpty(item.sellerUserId) || !s.equalsIgnoreCase(item.sellerUserId)) && viewitemviewdata.kind != com.ebay.common.ConstantsCommon.ItemKind.Won && ((BestOffer)item.offers.get(item.offers.size() - 1)).buyerId.equals(s))
            {
                return true;
            }
        }
        return false;
    }

    private String getAmountLabel(BestOffer bestoffer)
    {
        String s = "";
        if (bestoffer.codeType.equals("BuyerBestOffer"))
        {
            s = a.getString(0x7f0705d2);
        } else
        {
            if (bestoffer.codeType.equals("BuyerCounterOffer"))
            {
                return a.getString(0x7f0705d1);
            }
            if (bestoffer.codeType.equals("SellerCounterOffer"))
            {
                return a.getString(0x7f0705ad);
            }
        }
        return s;
    }

    public void refresh(Item item)
    {
label0:
        {
            boolean flag = areDetailsVisible(item, a.viewData);
            LinearLayout linearlayout = parent;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            linearlayout.setVisibility(i);
            if (flag)
            {
                item = (BestOffer)item.offers.get(item.offers.size() - 1);
                amountLabel.setText(getAmountLabel(item));
                String s = BestOfferViewHelper.getBidValueStr(a.getResources(), ((BestOffer) (item)).currentOffer, ((BestOffer) (item)).quantity);
                amount.setText(s);
                status.setText(BestOfferStatusLocale.getCaption(a, ((BestOffer) (item)).status));
                long l = item.timeLeft();
                i = BestOfferViewHelper.getExpiresColor(a, l);
                status.setTextColor(BestOfferViewHelper.getStatusColor(a.getResources(), ((BestOffer) (item)).status));
                if (!((BestOffer) (item)).status.equals("Pending") && !((BestOffer) (item)).status.equals("Active"))
                {
                    break label0;
                }
                timeRemainingParent.setVisibility(0);
                timeRemaining.setText(BestOfferViewHelper.getExpiresStr(a.getResources(), l));
                timeRemaining.setTextColor(i);
            }
            return;
        }
        timeRemainingParent.setVisibility(8);
    }
}
