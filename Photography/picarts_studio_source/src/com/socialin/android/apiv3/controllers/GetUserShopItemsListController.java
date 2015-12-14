// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.ShopItemsListResponse;
import com.socialin.android.apiv3.request.GetShopItemsListParams;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetUserShopItemsListController extends BaseSocialinApiRequestController
{

    int requestId;

    public GetUserShopItemsListController()
    {
        requestId = -1;
    }

    public void doRequest(String s, GetShopItemsListParams getshopitemslistparams)
    {
        params = getshopitemslistparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().getUserShopItems(s, this, 5);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (GetShopItemsListParams)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((ShopItemsListResponse)response, request);
    }

    public void onSuccess(ShopItemsListResponse shopitemslistresponse, Request request)
    {
        Object obj;
        Iterator iterator;
        obj = new ArrayList();
        iterator = shopitemslistresponse.response.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next();
        if (shopitem.type.equals("items_old"))
        {
            ((ArrayList) (obj)).add(shopitem);
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        ((Exception) (obj)).printStackTrace();
_L6:
        super.onSuccess(shopitemslistresponse, request);
        return;
_L2:
        if (((ArrayList) (obj)).isEmpty()) goto _L6; else goto _L5
_L5:
        shopitemslistresponse.response.removeAll(((java.util.Collection) (obj)));
          goto _L6
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ShopItemsListResponse)obj, request);
    }
}
