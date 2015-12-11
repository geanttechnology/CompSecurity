// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.AmazonDevice.Identity.Common.ILogOutput;
import com.AmazonDevice.Identity.Common.LogType;
import com.AmazonDevice.Identity.Common.SdkLogLevel;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOODMSUserIdentifier, MobileAdsLoggerFactory, MobileAdsLogger

protected static class  extends ILogOutput
{

    private static final String LOGTAG = "DMSAuth";
    private final MobileAdsLogger logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger("DMSAuth");

    public void printOutput(String s, SdkLogLevel sdkloglevel, LogType logtype)
    {
        switch (nDevice.Identity.Common.SdkLogLevel[sdkloglevel.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            logger.d(s);
            return;

        case 2: // '\002'
            logger.e(s);
            return;

        case 3: // '\003'
            logger.i(s);
            return;

        case 4: // '\004'
            logger.w(s);
            break;
        }
    }

    protected ()
    {
    }
}
