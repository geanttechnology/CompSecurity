// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAccountManager

public static final class mValue extends Enum
{

    private static final BOTTOM_RIGHT $VALUES[];
    public static final BOTTOM_RIGHT BOTTOM_CENTER;
    public static final BOTTOM_RIGHT BOTTOM_LEFT;
    public static final BOTTOM_RIGHT BOTTOM_RIGHT;
    public static final BOTTOM_RIGHT CENTER_CENTER;
    public static final BOTTOM_RIGHT CENTER_LEFT;
    public static final BOTTOM_RIGHT CENTER_RIGHT;
    public static final BOTTOM_RIGHT TOP_CENTER;
    public static final BOTTOM_RIGHT TOP_LEFT;
    public static final BOTTOM_RIGHT TOP_RIGHT;
    private String mValue;

    public static mValue get(String s)
    {
        mValue amvalue[] = values();
        int j = amvalue.length;
        for (int i = 0; i < j; i++)
        {
            mValue mvalue = amvalue[i];
            if (mvalue.getValue().equals(s))
            {
                return mvalue;
            }
        }

        MAPLog.e(MAPAccountManager.access$000(), "Invalid ScreenPosition value: %s", new Object[] {
            s
        });
        return null;
    }

    public static getValue valueOf(String s)
    {
        return (getValue)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition, s);
    }

    public static getValue[] values()
    {
        return (getValue[])$VALUES.clone();
    }

    public String getValue()
    {
        return mValue;
    }

    public String toString()
    {
        return getValue();
    }

    static 
    {
        TOP_LEFT = new <init>("TOP_LEFT", 0, "top_left");
        TOP_CENTER = new <init>("TOP_CENTER", 1, "top_center");
        TOP_RIGHT = new <init>("TOP_RIGHT", 2, "top_right");
        CENTER_LEFT = new <init>("CENTER_LEFT", 3, "center_left");
        CENTER_CENTER = new <init>("CENTER_CENTER", 4, "center_center");
        CENTER_RIGHT = new <init>("CENTER_RIGHT", 5, "center_right");
        BOTTOM_LEFT = new <init>("BOTTOM_LEFT", 6, "bottom_left");
        BOTTOM_CENTER = new <init>("BOTTOM_CENTER", 7, "bottom_center");
        BOTTOM_RIGHT = new <init>("BOTTOM_RIGHT", 8, "bottom_right");
        $VALUES = (new .VALUES[] {
            TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER_CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }
}
