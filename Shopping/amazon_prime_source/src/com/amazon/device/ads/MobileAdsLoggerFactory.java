// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            LogcatLogger, MobileAdsLogger, Logger

class MobileAdsLoggerFactory
{

    private static MobileAdsLoggerFactory loggerFactory;

    MobileAdsLoggerFactory()
    {
    }

    static void setLoggerFactory(MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        loggerFactory = mobileadsloggerfactory;
    }

    public MobileAdsLogger createMobileAdsLogger(String s)
    {
        if (loggerFactory != null)
        {
            return loggerFactory.createMobileAdsLogger(s);
        } else
        {
            return createMobileAdsLogger(s, ((Logger) (new LogcatLogger())));
        }
    }

    MobileAdsLogger createMobileAdsLogger(String s, Logger logger)
    {
        return (new MobileAdsLogger(logger)).withLogTag(s);
    }
}
