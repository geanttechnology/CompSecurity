// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJCloseButton, TapjoyConnectCore

public static final class ams.setMargins extends Enum
{

    private static final BOTTOM_RIGHT $VALUES[];
    public static final BOTTOM_RIGHT BOTTOM_CENTER;
    public static final BOTTOM_RIGHT BOTTOM_LEFT;
    public static final BOTTOM_RIGHT BOTTOM_RIGHT;
    public static final BOTTOM_RIGHT CENTER;
    public static final BOTTOM_RIGHT TOP_CENTER;
    public static final BOTTOM_RIGHT TOP_LEFT;
    public static final BOTTOM_RIGHT TOP_RIGHT;
    private final android.widget.OM_RIGHT layoutParameters = new android.widget.<init>(-2, -2);

    public static ams.setMargins valueOf(String s)
    {
        return (ams.setMargins)Enum.valueOf(com/tapjoy/TJCloseButton$ClosePosition, s);
    }

    public static ams.setMargins[] values()
    {
        return (ams.setMargins[])$VALUES.clone();
    }

    final android.widget.lone getLayoutParams()
    {
        return layoutParameters;
    }

    static 
    {
        TOP_LEFT = new <init>("TOP_LEFT", 0, new int[] {
            10, 9
        });
        TOP_CENTER = new <init>("TOP_CENTER", 1, new int[] {
            10, 14
        });
        TOP_RIGHT = new <init>("TOP_RIGHT", 2, new int[] {
            10, 11
        });
        CENTER = new <init>("CENTER", 3, new int[] {
            13
        });
        BOTTOM_LEFT = new <init>("BOTTOM_LEFT", 4, new int[] {
            12, 9
        });
        BOTTOM_CENTER = new <init>("BOTTOM_CENTER", 5, new int[] {
            12, 14
        });
        BOTTOM_RIGHT = new <init>("BOTTOM_RIGHT", 6, new int[] {
            12, 11
        });
        $VALUES = (new .VALUES[] {
            TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
        });
    }

    private ams(String s, int i, int ai[])
    {
        super(s, i);
        int j = ai.length;
        for (i = 0; i < j; i++)
        {
            int k = ai[i];
            layoutParameters.addRule(k);
        }

        i = (int)(-10F * TapjoyConnectCore.getDeviceScreenDensityScale());
        layoutParameters.setMargins(0, i, i, 0);
    }
}
