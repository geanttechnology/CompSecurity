// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import java.io.File;
import java.net.URI;

class f extends k
{

    public f(GetPromotionBannerResponse.PromotionBanner promotionbanner)
    {
        super(promotionbanner.a, "PromotionBanner", URI.create(promotionbanner.i));
    }

    public static String e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.c());
        stringbuilder.append(File.separator);
        stringbuilder.append("PromotionBanner");
        stringbuilder.append(File.separator);
        stringbuilder.append("thumbnail");
        stringbuilder.append(File.separator);
        return stringbuilder.toString();
    }
}
