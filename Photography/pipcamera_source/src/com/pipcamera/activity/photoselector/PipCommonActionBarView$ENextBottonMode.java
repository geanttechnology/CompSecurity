// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;


public final class Q extends Enum
{

    private static final BUTTON $VALUES[];
    public static final BUTTON BUTTON;
    public static final BUTTON ICON;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/pipcamera/activity/photoselector/PipCommonActionBarView$ENextBottonMode, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        ICON = new <init>("ICON", 0);
        BUTTON = new <init>("BUTTON", 1);
        $VALUES = (new .VALUES[] {
            ICON, BUTTON
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
