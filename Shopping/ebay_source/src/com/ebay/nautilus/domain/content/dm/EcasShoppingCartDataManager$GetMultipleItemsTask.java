// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCartResponse;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetMultipleItemsRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetMultipleItemsResponse;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EcasShoppingCartDataManager

public final class ecasShoppingCart extends ecasShoppingCart
{

    private final EcasShoppingCartResponse ecasShoppingCart;
    private final EbayShoppingApi shoppingApiContext;
    final EcasShoppingCartDataManager this$0;

    protected transient Content doInBackground(Long along[])
    {
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        LinkedList linkedlist = new LinkedList();
        double d = along.length;
        double d1 = Math.ceil(d / 20D);
        for (int i = 0; (double)i < d1;)
        {
            Long along1[];
            GetMultipleItemsResponse getmultipleitemsresponse;
            int j;
            if ((double)(i + 1) == d1)
            {
                j = Double.valueOf(d).intValue();
            } else
            {
                j = (i + 1) * 20;
            }
            along1 = (Long[])Arrays.copyOfRange(along, i * 20, j);
            getmultipleitemsresponse = (GetMultipleItemsResponse)EcasShoppingCartDataManager.access$300(EcasShoppingCartDataManager.this, new GetMultipleItemsRequest(shoppingApiContext, Arrays.asList(along1), "Details"), resultstatusowner);
            if (getmultipleitemsresponse != null && getmultipleitemsresponse.items != null)
            {
                linkedlist.addAll(getmultipleitemsresponse.items);
                i++;
            } else
            {
                return new Content(resultstatusowner.getResultStatus());
            }
        }

        return new Content(linkedlist, resultstatusowner.getResultStatus());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Long[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.stExecute(content);
        if (content.getData() != null)
        {
            outstandingTasks.add(DataManager.executeOnThreadPool(new k(EcasShoppingCartDataManager.this, ecasShoppingCart, (List)content.getData(), siteId, itemId, userId, action, caller), new Void[0]));
            outstandingTasks.remove(this);
            return;
        }
        outstandingTasks.remove(this);
        if (caller != null)
        {
            caller.rtChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        } else
        {
            ((action)EcasShoppingCartDataManager.access$400(EcasShoppingCartDataManager.this)).rtChanged(EcasShoppingCartDataManager.this, action, new Content(content.getStatus()));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public k(EbayShoppingApi ebayshoppingapi, EcasShoppingCartResponse ecasshoppingcartresponse, String s, String s1, String s2, k k, 
            k k1)
    {
        this$0 = EcasShoppingCartDataManager.this;
        super(EcasShoppingCartDataManager.this, k, s, s1, s2, k1);
        shoppingApiContext = ebayshoppingapi;
        ecasShoppingCart = ecasshoppingcartresponse;
    }
}
