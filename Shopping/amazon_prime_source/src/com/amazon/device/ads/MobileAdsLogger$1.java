// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLogger

static class vel
{

    static final int $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[];

    static 
    {
        $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level = new int[vel.values().length];
        try
        {
            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[vel.DEBUG.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[vel.ERROR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[vel.INFO.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[vel.VERBOSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$MobileAdsLogger$Level[vel.WARN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
