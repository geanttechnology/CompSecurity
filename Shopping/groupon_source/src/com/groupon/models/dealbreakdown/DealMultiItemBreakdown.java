// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealbreakdown;

import android.text.TextUtils;
import com.groupon.models.BookingDetails;
import com.groupon.models.GenericAmount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.models.dealbreakdown:
//            PurchaseBreakdown, DealBreakdownTenderItem, DealBreakdownGenericAmount

public class DealMultiItemBreakdown
    implements PurchaseBreakdown
{

    public Map addressDetails;
    public Map addresses;
    public List adjustments;
    public Map deliveryDetails;
    public Map finalPrice;
    public List items;
    public String multiUsePromoCode;
    public String promoCodes;
    public DealBreakdownGenericAmount subtotal;
    public List tenders;
    public DealBreakdownGenericAmount total;

    public DealMultiItemBreakdown()
    {
    }

    public List getAdjustments()
    {
        return adjustments;
    }

    public List getPaymentMethods()
    {
        return null;
    }

    public String getPromoCode()
    {
        if (TextUtils.isEmpty(multiUsePromoCode))
        {
            return promoCodes;
        } else
        {
            return multiUsePromoCode;
        }
    }

    public List getTenderItemsOfType(String s)
    {
        ArrayList arraylist = new ArrayList();
        Ln.d("PAYMENT: getTenderItemsOfType %s", new Object[] {
            s
        });
        if (tenders != null && tenders.size() > 0)
        {
            Ln.d("PAYMENT: total tenders = %d", new Object[] {
                Integer.valueOf(tenders.size())
            });
            Iterator iterator = tenders.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                DealBreakdownTenderItem dealbreakdowntenderitem = (DealBreakdownTenderItem)iterator.next();
                if (dealbreakdowntenderitem.type.equals(s))
                {
                    Ln.d("PAYMENT: found %s with value %d", new Object[] {
                        s, Integer.valueOf(dealbreakdowntenderitem.amount.getAmount())
                    });
                    arraylist.add(dealbreakdowntenderitem);
                }
            } while (true);
        }
        return arraylist;
    }

    public BookingDetails getTravelBookingDetails()
    {
        return null;
    }
}
