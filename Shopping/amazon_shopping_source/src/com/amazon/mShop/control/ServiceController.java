// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.mShop.MShopService;

public class ServiceController
{

    public ServiceController()
    {
    }

    public static MShopService getMShopService()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getMShopService();
    }
}
