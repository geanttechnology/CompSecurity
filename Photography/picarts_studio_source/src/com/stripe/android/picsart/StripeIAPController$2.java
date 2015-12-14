// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import com.socialin.android.apiv3.model.ShopItemsListResponse;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import myobfuscated.bp.c;

// Referenced classes of package com.stripe.android.picsart:
//            StripeIAPController

class val.listener
    implements d
{

    final StripeIAPController this$0;
    final c val$listener;

    public void onCancelRequest(ShopItemsListResponse shopitemslistresponse, Request request)
    {
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
        onCancelRequest((ShopItemsListResponse)obj, request);
    }

    public void onFailure(Exception exception, Request request)
    {
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public void onSuccess(ShopItemsListResponse shopitemslistresponse, Request request)
    {
        val$listener.a(shopitemslistresponse.response);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ShopItemsListResponse)obj, request);
    }

    ponse()
    {
        this$0 = final_stripeiapcontroller;
        val$listener = c.this;
        super();
    }
}
