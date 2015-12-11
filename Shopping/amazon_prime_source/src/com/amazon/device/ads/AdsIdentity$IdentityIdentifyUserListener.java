// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdsIdentity, MobileAdsLoggerFactory, MobileAdsLogger

private static class ger
    implements er
{

    private final MobileAdsLogger logger;

    public void userIdentified()
    {
        logger.d("User successfully identified.");
    }

    public er(MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        logger = mobileadsloggerfactory.createMobileAdsLogger(AdsIdentity.access$000());
    }
}
