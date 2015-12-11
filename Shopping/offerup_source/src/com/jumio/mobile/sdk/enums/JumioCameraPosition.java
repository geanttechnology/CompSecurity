// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mobile.sdk.enums;


public final class JumioCameraPosition extends Enum
{

    private static final JumioCameraPosition $VALUES[];
    public static final JumioCameraPosition BACK;
    public static final JumioCameraPosition FRONT;

    private JumioCameraPosition(String s, int i)
    {
        super(s, i);
    }

    public static JumioCameraPosition valueOf(String s)
    {
        return (JumioCameraPosition)Enum.valueOf(com/jumio/mobile/sdk/enums/JumioCameraPosition, s);
    }

    public static JumioCameraPosition[] values()
    {
        return (JumioCameraPosition[])$VALUES.clone();
    }

    static 
    {
        FRONT = new JumioCameraPosition("FRONT", 0);
        BACK = new JumioCameraPosition("BACK", 1);
        $VALUES = (new JumioCameraPosition[] {
            FRONT, BACK
        });
    }
}
