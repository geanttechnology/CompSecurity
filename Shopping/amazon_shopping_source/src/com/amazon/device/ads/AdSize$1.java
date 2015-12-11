// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdSize

static class zeType
{

    static final int $SwitchMap$com$amazon$device$ads$AdSize$SizeType[];

    static 
    {
        $SwitchMap$com$amazon$device$ads$AdSize$SizeType = new int[zeType.values().length];
        try
        {
            $SwitchMap$com$amazon$device$ads$AdSize$SizeType[zeType.EXPLICIT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$AdSize$SizeType[zeType.AUTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$AdSize$SizeType[zeType.INTERSTITIAL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
