// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;


public final class FrequencyCapType extends Enum
{

    private static final FrequencyCapType $VALUES[];
    public static final FrequencyCapType ADSPACE;
    public static final FrequencyCapType PUBLISHER;
    public static final FrequencyCapType STREAM;

    private FrequencyCapType(String s, int i)
    {
        super(s, i);
    }

    public static FrequencyCapType valueOf(String s)
    {
        return (FrequencyCapType)Enum.valueOf(com/flurry/android/impl/ads/protocol/v13/FrequencyCapType, s);
    }

    public static FrequencyCapType[] values()
    {
        return (FrequencyCapType[])$VALUES.clone();
    }

    static 
    {
        ADSPACE = new FrequencyCapType("ADSPACE", 0);
        PUBLISHER = new FrequencyCapType("PUBLISHER", 1);
        STREAM = new FrequencyCapType("STREAM", 2);
        $VALUES = (new FrequencyCapType[] {
            ADSPACE, PUBLISHER, STREAM
        });
    }
}
