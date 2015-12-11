// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.adview;


public final class Orientation extends Enum
{

    private static final Orientation $VALUES[];
    public static final Orientation LANDSCAPE;
    public static final Orientation NONE;
    public static final Orientation PORTRAIT;

    private Orientation(String s, int i)
    {
        super(s, i);
    }

    public static Orientation valueOf(String s)
    {
        return (Orientation)Enum.valueOf(com/apprupt/sdk/adview/Orientation, s);
    }

    public static Orientation[] values()
    {
        return (Orientation[])$VALUES.clone();
    }

    public String toString()
    {
    /* anonymous class not found */
    class _anm1 {}

        switch (_cls1..SwitchMap.com.apprupt.sdk.adview.Orientation[ordinal()])
        {
        default:
            return "none";

        case 1: // '\001'
            return "portrait";

        case 2: // '\002'
            return "landscape";
        }
    }

    static 
    {
        NONE = new Orientation("NONE", 0);
        PORTRAIT = new Orientation("PORTRAIT", 1);
        LANDSCAPE = new Orientation("LANDSCAPE", 2);
        $VALUES = (new Orientation[] {
            NONE, PORTRAIT, LANDSCAPE
        });
    }
}
