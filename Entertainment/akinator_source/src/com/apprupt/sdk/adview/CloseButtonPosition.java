// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.adview;


public final class CloseButtonPosition extends Enum
{

    private static final CloseButtonPosition $VALUES[];
    public static final CloseButtonPosition BOTTOM_CENTER;
    public static final CloseButtonPosition BOTTOM_LEFT;
    public static final CloseButtonPosition BOTTOM_RIGHT;
    public static final CloseButtonPosition CENTER;
    public static final CloseButtonPosition HIDDEN;
    public static final CloseButtonPosition TOP_CENTER;
    public static final CloseButtonPosition TOP_LEFT;
    public static final CloseButtonPosition TOP_RIGHT;

    private CloseButtonPosition(String s, int i)
    {
        super(s, i);
    }

    public static CloseButtonPosition valueOf(String s)
    {
        return (CloseButtonPosition)Enum.valueOf(com/apprupt/sdk/adview/CloseButtonPosition, s);
    }

    public static CloseButtonPosition[] values()
    {
        return (CloseButtonPosition[])$VALUES.clone();
    }

    public String toString()
    {
    /* anonymous class not found */
    class _anm1 {}

        switch (_cls1..SwitchMap.com.apprupt.sdk.adview.CloseButtonPosition[ordinal()])
        {
        default:
            return "top-right";

        case 1: // '\001'
            return "hidden";

        case 2: // '\002'
            return "bottom-right";

        case 3: // '\003'
            return "bottom-left";

        case 4: // '\004'
            return "bottom-center";

        case 5: // '\005'
            return "center";

        case 6: // '\006'
            return "top-left";

        case 7: // '\007'
            return "top-center";
        }
    }

    static 
    {
        HIDDEN = new CloseButtonPosition("HIDDEN", 0);
        TOP_RIGHT = new CloseButtonPosition("TOP_RIGHT", 1);
        BOTTOM_RIGHT = new CloseButtonPosition("BOTTOM_RIGHT", 2);
        BOTTOM_LEFT = new CloseButtonPosition("BOTTOM_LEFT", 3);
        TOP_LEFT = new CloseButtonPosition("TOP_LEFT", 4);
        CENTER = new CloseButtonPosition("CENTER", 5);
        TOP_CENTER = new CloseButtonPosition("TOP_CENTER", 6);
        BOTTOM_CENTER = new CloseButtonPosition("BOTTOM_CENTER", 7);
        $VALUES = (new CloseButtonPosition[] {
            HIDDEN, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT, TOP_LEFT, CENTER, TOP_CENTER, BOTTOM_CENTER
        });
    }
}
