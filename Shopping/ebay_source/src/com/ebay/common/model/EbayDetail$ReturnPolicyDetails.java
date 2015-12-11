// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.common.model:
//            EbayDetail

public static final class shippingCostPaidBy
    implements Serializable
{

    public ArrayList refund;
    public ArrayList returnsAccepted;
    public ArrayList returnsWithin;
    public ArrayList shippingCostPaidBy;

    public static CharSequence[] getEntries(ArrayList arraylist)
    {
        CharSequence acharsequence[] = new CharSequence[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++)
        {
            acharsequence[i] = ((shippingCostPaidBy)arraylist.get(i)).escription;
        }

        return acharsequence;
    }

    public static CharSequence[] getEntryValues(ArrayList arraylist)
    {
        CharSequence acharsequence[] = new CharSequence[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++)
        {
            acharsequence[i] = ((escription)arraylist.get(i)).oken;
        }

        return acharsequence;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Return Policy\n");
        stringbuilder.append("Refunds").append("\n");
        for (Iterator iterator = refund.iterator(); iterator.hasNext(); stringbuilder.append((refund)iterator.next())) { }
        stringbuilder.append("ReturnsAccepted").append("\n");
        for (Iterator iterator1 = returnsAccepted.iterator(); iterator1.hasNext(); stringbuilder.append((returnsAccepted)iterator1.next())) { }
        stringbuilder.append("ReturnsWithin").append("\n");
        for (Iterator iterator2 = returnsWithin.iterator(); iterator2.hasNext(); stringbuilder.append((returnsWithin)iterator2.next())) { }
        stringbuilder.append("ShippingCostPaidBy").append("\n");
        for (Iterator iterator3 = shippingCostPaidBy.iterator(); iterator3.hasNext(); stringbuilder.append((shippingCostPaidBy)iterator3.next())) { }
        return stringbuilder.toString();
    }

    public ()
    {
        refund = new ArrayList();
        returnsAccepted = new ArrayList();
        returnsWithin = new ArrayList();
        shippingCostPaidBy = new ArrayList();
    }
}
