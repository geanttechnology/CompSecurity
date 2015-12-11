// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import android.text.TextUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static class 
{

    public String cartId;
    public em.isBopisSelected counts;
    public Date createdOn;
    public Date lastAccessedAt;
    public Date lastModifiedBySystemOn;
    public Date lastModifiedByUserOn;
    public List messages;
    public List promotions;
    public List sellerGroups;
    public em.isBopisSelected shippingAddress;
    public  totalSummary;

    public int getBuyableCount()
    {
        Iterator iterator;
        int i;
        int j;
        j = 0;
        i = 0;
        if (sellerGroups == null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        iterator = sellerGroups.iterator();
_L2:
        Object obj;
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_251;
            }
            obj = (sellerGroups)iterator.next();
        } while (obj == null || ((sellerGroups) (obj)).itemGroups == null);
        obj = ((itemGroups) (obj)).itemGroups.iterator();
        j = i;
_L4:
        i = j;
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        Object obj1 = (itemGroups)((Iterator) (obj)).next();
        if (((itemGroups) (obj1)).ems == null) goto _L4; else goto _L3
_L3:
        obj1 = ((ems) (obj1)).ems.iterator();
        i = j;
_L7:
        j = i;
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L5
_L5:
        Object obj2;
        obj2 = (em)((Iterator) (obj1)).next();
        if (((em) (obj2)).orderTransactions == null || ((em) (obj2)).orderTransactions.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        obj2 = ((em) (obj2)).orderTransactions.iterator();
        j = i;
_L8:
        i = j;
        if (!((Iterator) (obj2)).hasNext()) goto _L7; else goto _L6
_L6:
        j += ((tion)((Iterator) (obj2)).next()).quantityRequested;
          goto _L8
        if (!TextUtils.isEmpty(((em) (obj2)).transactionId) || !((em) (obj2)).isItemEnded && !((em) (obj2)).isUnbuyable)
        {
            i += ((em) (obj2)).quantityRequested;
        }
          goto _L7
        return j;
    }

    public boolean hasBopisSelectedItem()
    {
        if (sellerGroups != null)
        {
            Iterator iterator = sellerGroups.iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (sellerGroups)iterator.next();
                if (((sellerGroups) (obj)).itemGroups != null)
                {
                    obj = ((itemGroups) (obj)).itemGroups.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        Object obj1 = (itemGroups)((Iterator) (obj)).next();
                        if (((itemGroups) (obj1)).ems != null)
                        {
                            obj1 = ((ems) (obj1)).ems.iterator();
                            while (((Iterator) (obj1)).hasNext()) 
                            {
                                if (((em)((Iterator) (obj1)).next()).isBopisSelected())
                                {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public ()
    {
    }
}
