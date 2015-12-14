// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.ShopItemsListResponse;
import com.socialin.android.apiv3.request.GetShopItemsListParams;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetShopItemsListController extends BaseSocialinApiRequestController
{

    int requestId;

    public GetShopItemsListController()
    {
        requestId = -1;
    }

    public void doRequest(String s, GetShopItemsListParams getshopitemslistparams)
    {
        int j = 0;
        params = getshopitemslistparams;
        if (status == 0)
        {
            return;
        }
        status = 0;
        SocialinApiV3 socialinapiv3 = SocialinApiV3.getInstance();
        String s3 = SocialinV3.market;
        String s1;
        String s2;
        int i;
        if (getshopitemslistparams == null)
        {
            s1 = "";
        } else
        {
            s1 = getshopitemslistparams.price;
        }
        if (getshopitemslistparams == null)
        {
            s2 = "";
        } else
        {
            s2 = getshopitemslistparams.tag;
        }
        if (getshopitemslistparams == null)
        {
            i = 0;
        } else
        {
            i = getshopitemslistparams.limit;
        }
        if (getshopitemslistparams != null)
        {
            j = getshopitemslistparams.offset;
        }
        requestId = socialinapiv3.getShopItems(s, this, 5, s3, s1, s2, i, j);
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
        if (shopitemslistresponse == null || shopitemslistresponse.response == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        obj = new ArrayList();
        iterator = shopitemslistresponse.response.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next();
        if (shopitem.type.equals("items_old"))
        {
            ((ArrayList) (obj)).add(shopitem);
        }
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        ((Exception) (obj)).printStackTrace();
_L2:
        super.onSuccess(shopitemslistresponse, request);
        return;
_L4:
        if (((ArrayList) (obj)).isEmpty()) goto _L2; else goto _L7
_L7:
        shopitemslistresponse.response.removeAll(((java.util.Collection) (obj)));
          goto _L2
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ShopItemsListResponse)obj, request);
    }
}
