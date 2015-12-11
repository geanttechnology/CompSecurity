// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.utils.CurrencyUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, ListingSummary

public class PMBundle extends PMData
{

    String discount_message;
    int discount_percent;
    List posts;
    UserReference seller;
    BigDecimal total_discount;
    String total_discount_title;
    BigDecimal total_original_price;
    BigDecimal total_price;

    public PMBundle()
    {
        posts = Collections.synchronizedList(new ArrayList());
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        for (Iterator iterator = posts.iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (ListingSummary)iterator.next()
})) { }
    }

    public String getBundleDiscountMessage()
    {
        return discount_message;
    }

    public String getFinalPriceAsString()
    {
        if (total_price != null)
        {
            return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(total_price)).toString();
        } else
        {
            return null;
        }
    }

    public List getList()
    {
        return posts;
    }

    public List getListOfPostsInBundle()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = posts.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ListingSummary listingsummary = (ListingSummary)iterator.next();
            if (listingsummary.inventory != null && listingsummary.isAvailableForPurchase())
            {
                arraylist.add(listingsummary.getIdAsString());
            }
        } while (true);
        return arraylist;
    }

    public String getSavingsAsString()
    {
        if (total_discount != null)
        {
            return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(total_discount)).toString();
        } else
        {
            return null;
        }
    }

    public String getSellerAvataar()
    {
        return seller.getAvataar();
    }

    public String getSellerId()
    {
        if (seller != null)
        {
            return seller.getUserId();
        } else
        {
            return null;
        }
    }

    public String getSellerUsername()
    {
        if (seller != null)
        {
            return seller.getUserName();
        } else
        {
            return null;
        }
    }

    public String getTotalDiscountTitle()
    {
        return total_discount_title;
    }

    public List removeUnavailableItems()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = posts.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ListingSummary listingsummary = (ListingSummary)iterator.next();
            if (listingsummary.inventory != null && !listingsummary.isAvailableForPurchase())
            {
                arraylist.add(listingsummary);
                iterator.remove();
            }
        } while (true);
        return arraylist;
    }
}
