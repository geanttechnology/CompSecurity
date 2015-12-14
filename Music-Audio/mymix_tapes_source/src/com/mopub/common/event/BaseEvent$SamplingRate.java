// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public static final class mSamplingRate extends Enum
{

    private static final NATIVE_VIDEO $VALUES[];
    public static final NATIVE_VIDEO AD_REQUEST;
    public static final NATIVE_VIDEO NATIVE_VIDEO;
    private final double mSamplingRate;

    public static mSamplingRate valueOf(String s)
    {
        return (mSamplingRate)Enum.valueOf(com/mopub/common/event/BaseEvent$SamplingRate, s);
    }

    public static mSamplingRate[] values()
    {
        return (mSamplingRate[])$VALUES.clone();
    }

    public double getSamplingRate()
    {
        return mSamplingRate;
    }

    static 
    {
        AD_REQUEST = new <init>("AD_REQUEST", 0, 0.10000000000000001D);
        NATIVE_VIDEO = new <init>("NATIVE_VIDEO", 1, 0.10000000000000001D);
        $VALUES = (new .VALUES[] {
            AD_REQUEST, NATIVE_VIDEO
        });
    }

    private (String s, int i, double d)
    {
        super(s, i);
        mSamplingRate = d;
    }
}
