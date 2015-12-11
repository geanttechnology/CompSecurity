// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealbreakdown;

import com.groupon.models.BookingDetails;
import com.groupon.models.GenericAmount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.models.dealbreakdown:
//            PurchaseBreakdown, DealBreakdownItem, DealBreakdownAdjustment, DealBreakdownTenderItem

public class DealBreakdown
    implements PurchaseBreakdown
{

    public List adjustments;
    public List items;
    public String multiUsePromoCode;
    public List paymentMethods;
    public List tenders;

    public DealBreakdown()
    {
    }

    public List getAdjustments()
    {
        return adjustments;
    }

    public DealBreakdownItem getBreakdownItem()
    {
        if (items != null && items.size() > 0)
        {
            return (DealBreakdownItem)items.get(0);
        } else
        {
            return null;
        }
    }

    public DealBreakdownAdjustment getDiscountAdjustment()
    {
        for (Iterator iterator = adjustments.iterator(); iterator.hasNext();)
        {
            DealBreakdownAdjustment dealbreakdownadjustment = (DealBreakdownAdjustment)iterator.next();
            if (dealbreakdownadjustment.type.toLowerCase().equals("discount"))
            {
                return dealbreakdownadjustment;
            }
        }

        return null;
    }

    public List getPaymentMethods()
    {
        return paymentMethods;
    }

    public DealBreakdownAdjustment getTax()
    {
        DealBreakdownAdjustment dealbreakdownadjustment = null;
        Iterator iterator = adjustments.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DealBreakdownAdjustment dealbreakdownadjustment1 = (DealBreakdownAdjustment)iterator.next();
            if (dealbreakdownadjustment1.type.toLowerCase().equals("tax"))
            {
                dealbreakdownadjustment = dealbreakdownadjustment1;
            }
        } while (true);
        Ln.d(dealbreakdownadjustment.type, new Object[0]);
        return dealbreakdownadjustment;
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
        if (items != null && items.size() > 0)
        {
            return ((DealBreakdownItem)items.get(0)).travelBookingDetails;
        } else
        {
            return null;
        }
    }
}
