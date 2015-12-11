// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetMultipleItemsRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GetMultipleItemsNetLoader extends EbaySimpleNetLoader
{

    private final EbayShoppingApi api;
    private final List itemIds;
    private final String selector;

    public GetMultipleItemsNetLoader(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, List list, String s)
    {
        super(ebaycontext);
        api = ebayshoppingapi;
        itemIds = list;
        selector = s;
    }

    public GetMultipleItemsNetLoader(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String as[], String s)
    {
        this(ebaycontext, ebayshoppingapi, stringToLong(Arrays.asList(as)), s);
    }

    private static List stringToLong(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext();)
        {
            String s = (String)list.next();
            try
            {
                arraylist.add(Long.valueOf(Long.parseLong(s)));
            }
            catch (Exception exception) { }
        }

        return arraylist;
    }

    protected EbayRequest createRequest()
    {
        return new GetMultipleItemsRequest(api, itemIds, selector);
    }
}
