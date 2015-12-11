// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.rio.j2me.client.services.mShop.WebLink;

// Referenced classes of package com.amazon.mShop.details:
//            FriendAppProxy

public class ExternalBuyLinkProxy extends FriendAppProxy
{

    private WebLink mWebLink;

    public ExternalBuyLinkProxy()
    {
    }

    public ExternalBuyLinkProxy(ProductController productcontroller)
    {
        mWebLink = productcontroller.getExternalBuyLink();
    }

    public String getButtonLabel(Context context)
    {
        return mWebLink.getName();
    }

    protected Intent getIntentForStart(Context context, ProductController productcontroller)
    {
        productcontroller = productcontroller.getExternalBuyLink().getLinkUrl();
        context = productcontroller;
        if (productcontroller.startsWith("open:"))
        {
            context = productcontroller.substring("open:".length());
        }
        return new Intent("android.intent.action.VIEW", Uri.parse(context));
    }

    protected Intent getIntentForStart(Context context, String s)
    {
        return null;
    }

    protected String getPackageName(Context context)
    {
        return null;
    }

    protected String getRefTag()
    {
        return "ext";
    }

    protected boolean isFriendAppInstalled(Context context)
    {
        return true;
    }

    protected boolean needFriendAppUpdate(Context context)
    {
        return false;
    }
}
