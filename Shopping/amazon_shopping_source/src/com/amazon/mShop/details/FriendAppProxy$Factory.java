// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import com.amazon.mShop.control.item.ProductController;

// Referenced classes of package com.amazon.mShop.details:
//            FriendAppProxy, AmazonAppStoreProxy, AmazonMp3Proxy, AmazonKindleProxy, 
//            AmazonVideoProxy, ExternalBuyLinkProxy

public static class 
{

    public static FriendAppProxy getProxy(Context context, String s)
    {
        AmazonAppStoreProxy amazonappstoreproxy = null;
        if (FriendAppProxy.isAmazonAppstoreDownloadUrl(context, s))
        {
            amazonappstoreproxy = AmazonAppStoreProxy.getInstance();
        } else
        if (FriendAppProxy.isAmazonMp3DownloadUrl(context, s))
        {
            return AmazonMp3Proxy.getInstance();
        }
        return amazonappstoreproxy;
    }

    public static FriendAppProxy getProxy(ProductController productcontroller)
    {
        AmazonAppStoreProxy amazonappstoreproxy = null;
        if (productcontroller.isMobileApp())
        {
            amazonappstoreproxy = AmazonAppStoreProxy.getInstance();
        } else
        {
            if (productcontroller.isMusic())
            {
                return AmazonMp3Proxy.getInstance();
            }
            if (productcontroller.isKindleBook())
            {
                return AmazonKindleProxy.getInstance();
            }
            if (productcontroller.isVideo())
            {
                return AmazonVideoProxy.getInstance();
            }
            if (productcontroller.hasExternalBuyLink())
            {
                return new ExternalBuyLinkProxy(productcontroller);
            }
            if (productcontroller.isAudiobook())
            {
                return null;
            }
        }
        return amazonappstoreproxy;
    }

    public ()
    {
    }
}
