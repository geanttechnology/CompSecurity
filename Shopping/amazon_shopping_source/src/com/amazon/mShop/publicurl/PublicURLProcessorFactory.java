// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;

import android.net.Uri;
import java.util.List;

// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessException, HomeURLProcessor, ProductURLProcessor, CartURLProcessor, 
//            WishlistURLProcessor, OrderURLProcessor, PushNotificationsURLProcessor, YourAccountURLProcssor, 
//            RecommendationsURLProcessor, DealsURLProcessor, PublicURLProcessor

public class PublicURLProcessorFactory
{

    private PublicURLProcessorFactory()
    {
    }

    public static PublicURLProcessor getInstance(Uri uri)
        throws PublicURLProcessException
    {
        List list = uri.getPathSegments();
        Object obj;
        String s;
        if (list.size() > 0)
        {
            s = (String)list.get(0);
        } else
        {
            s = null;
        }
        obj = null;
        if (s == null || "".equals(s))
        {
            obj = new HomeURLProcessor(uri);
        } else
        if ("products".equals(s))
        {
            obj = new ProductURLProcessor(uri);
        } else
        if ("cart".equals(s))
        {
            obj = new CartURLProcessor(uri);
        } else
        if ("wishlists".equals(s))
        {
            obj = new WishlistURLProcessor(uri);
        } else
        if ("orders".equals(s))
        {
            obj = new OrderURLProcessor(uri);
        } else
        if ("account".equals(s))
        {
            if (list.size() >= 2 && "notifications".equals(list.get(1)))
            {
                obj = new PushNotificationsURLProcessor(uri);
            } else
            if (list.size() == 1)
            {
                obj = new YourAccountURLProcssor(uri);
            }
        } else
        if ("recommendations".equals(s))
        {
            obj = new RecommendationsURLProcessor(uri);
        } else
        if ("deals".equals(s))
        {
            obj = new DealsURLProcessor(uri);
        }
        if (obj == null)
        {
            throw new PublicURLProcessException(PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_ERROR_PATH);
        } else
        {
            return ((PublicURLProcessor) (obj));
        }
    }
}
