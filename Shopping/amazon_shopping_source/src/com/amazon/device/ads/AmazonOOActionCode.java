// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


public final class AmazonOOActionCode extends Enum
{

    private static final AmazonOOActionCode $VALUES[];
    public static final AmazonOOActionCode DISPLAY;
    public static final AmazonOOActionCode HANDLED;
    public static final AmazonOOActionCode REJECT;

    private AmazonOOActionCode(String s, int i)
    {
        super(s, i);
    }

    public static AmazonOOActionCode valueOf(String s)
    {
        return (AmazonOOActionCode)Enum.valueOf(com/amazon/device/ads/AmazonOOActionCode, s);
    }

    public static AmazonOOActionCode[] values()
    {
        return (AmazonOOActionCode[])$VALUES.clone();
    }

    static 
    {
        REJECT = new AmazonOOActionCode("REJECT", 0);
        DISPLAY = new AmazonOOActionCode("DISPLAY", 1);
        HANDLED = new AmazonOOActionCode("HANDLED", 2);
        $VALUES = (new AmazonOOActionCode[] {
            REJECT, DISPLAY, HANDLED
        });
    }
}
