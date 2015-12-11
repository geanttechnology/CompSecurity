// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mobile.sdk.enums;


public final class JumioDataCenter extends Enum
{

    private static final JumioDataCenter $VALUES[];
    public static final JumioDataCenter EU;
    public static final JumioDataCenter US;

    private JumioDataCenter(String s, int i)
    {
        super(s, i);
    }

    public static JumioDataCenter valueOf(String s)
    {
        return (JumioDataCenter)Enum.valueOf(com/jumio/mobile/sdk/enums/JumioDataCenter, s);
    }

    public static JumioDataCenter[] values()
    {
        return (JumioDataCenter[])$VALUES.clone();
    }

    static 
    {
        EU = new JumioDataCenter("EU", 0);
        US = new JumioDataCenter("US", 1);
        $VALUES = (new JumioDataCenter[] {
            EU, US
        });
    }
}
