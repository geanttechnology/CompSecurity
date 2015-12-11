// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MAPUtils, AuthenticationPlatformPreferredMarketplaceRetriever, AmazonOOMAPAdapter, PreferredMarketplaceRetriever

class AmazonOOPreferredMarketplaceRetrieverFactory
{

    private final MAPUtils mapUtils;

    AmazonOOPreferredMarketplaceRetrieverFactory()
    {
        this(new MAPUtils());
    }

    AmazonOOPreferredMarketplaceRetrieverFactory(MAPUtils maputils)
    {
        mapUtils = maputils;
    }

    public PreferredMarketplaceRetriever createPreferredMarketplaceRetriever()
    {
        if (mapUtils.isMAPAvailable())
        {
            return new AuthenticationPlatformPreferredMarketplaceRetriever(new AmazonOOMAPAdapter());
        } else
        {
            return new PreferredMarketplaceRetriever.NullPreferredMarketplaceRetriever();
        }
    }
}
