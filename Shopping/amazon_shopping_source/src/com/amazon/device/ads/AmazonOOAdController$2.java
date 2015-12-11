// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AmazonOOAdController, AmazonOOActionCode

static class 
{

    static final int $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[];

    static 
    {
        $SwitchMap$com$amazon$device$ads$AmazonOOActionCode = new int[AmazonOOActionCode.values().length];
        try
        {
            $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[AmazonOOActionCode.REJECT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[AmazonOOActionCode.HANDLED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[AmazonOOActionCode.DISPLAY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
