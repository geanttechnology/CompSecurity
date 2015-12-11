// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.AmazonDevice.Identity.Common.SdkLogLevel;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOODMSUserIdentifier

static class 
{

    static final int $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[];

    static 
    {
        $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel = new int[SdkLogLevel.values().length];
        try
        {
            $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelDebug.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelError.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelInfo.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelWarn.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
