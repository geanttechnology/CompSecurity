// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shoppingCart;

import com.crittercism.app.Crittercism;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.shoppingCart:
//            ShoppingCartItem, ShoppingCartItemLogSummary, ShoppingCartDealOption, ShoppingCartSubtotal

public class ShoppingCart
{

    public String consumerId;
    public boolean freeShipping;
    public List items;
    public List messages;
    public int numberOfItems;
    public ShoppingCartSubtotal subtotal;
    public String uuid;

    public ShoppingCart()
    {
    }

    public String generateTrackingString(int i)
    {
        if (i <= 2)
        {
            return "[]";
        }
        StringBuilder stringbuilder;
        ObjectMapper objectmapper;
        Iterator iterator;
        Object obj;
        int j;
        int k;
        int l;
        int i1;
        try
        {
            stringbuilder = new StringBuilder();
        }
        catch (Exception exception)
        {
            Crittercism.logHandledException(exception);
            return "[]";
        }
        k = 1;
        stringbuilder.append('[');
        if (items == null) goto _L2; else goto _L1
_L1:
        j = 0 + 2;
        objectmapper = new ObjectMapper();
        iterator = items.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        obj = ((ShoppingCartItem)iterator.next()).getLogSummary();
        obj.position = k;
        obj = objectmapper.writeValueAsString(obj);
        i1 = 0;
        if (k > 1)
        {
            i1 = 1;
        }
        if (((String) (obj)).length() + j + i1 <= i) goto _L4; else goto _L2
_L2:
        stringbuilder.append(']');
        return stringbuilder.toString();
_L4:
        l = j;
        if (k <= 1)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        stringbuilder.append(',');
        l = j + i1;
        stringbuilder.append(((String) (obj)));
        j = ((String) (obj)).length();
        j = l + j;
        k++;
          goto _L5
    }

    public int hashCode()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (items != null && !items.isEmpty())
        {
            Iterator iterator = items.iterator();
            while (iterator.hasNext()) 
            {
                ShoppingCartItem shoppingcartitem = (ShoppingCartItem)iterator.next();
                int i;
                if (shoppingcartitem.dealOption != null && Strings.notEmpty(shoppingcartitem.dealOption.uuid))
                {
                    i = shoppingcartitem.dealOption.uuid.hashCode();
                } else
                {
                    i = 0;
                }
                stringbuilder.append(i);
                stringbuilder.append(shoppingcartitem.quantity);
            }
        }
        return stringbuilder.toString().hashCode();
    }

    public boolean isUpdating()
    {
        for (Iterator iterator = items.iterator(); iterator.hasNext();)
        {
            if (((ShoppingCartItem)iterator.next()).updating)
            {
                return true;
            }
        }

        return false;
    }
}
