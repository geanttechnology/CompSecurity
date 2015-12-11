// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;


// Referenced classes of package com.amazon.avod.sdk:
//            VideoPlaybackStarter

public static final class mParameterValue extends Enum
{

    private static final LIMITED $VALUES[];
    public static final LIMITED FULL;
    public static final LIMITED LIMITED;
    private final String mParameterValue;

    public static mParameterValue valueOf(String s)
    {
        return (mParameterValue)Enum.valueOf(com/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile, s);
    }

    public static mParameterValue[] values()
    {
        return (mParameterValue[])$VALUES.clone();
    }

    public String getParameterValue()
    {
        return mParameterValue;
    }

    static 
    {
        FULL = new <init>("FULL", 0, "full");
        LIMITED = new <init>("LIMITED", 1, "limited");
        $VALUES = (new .VALUES[] {
            FULL, LIMITED
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mParameterValue = s1;
    }
}
