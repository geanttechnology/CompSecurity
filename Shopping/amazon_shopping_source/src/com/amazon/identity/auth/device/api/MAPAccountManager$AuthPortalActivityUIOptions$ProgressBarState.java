// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAccountManager

public static final class mValue extends Enum
{

    private static final SPINNER_LARGE $VALUES[];
    public static final SPINNER_LARGE OFF;
    public static final SPINNER_LARGE PROGRESS_BAR;
    public static final SPINNER_LARGE SPINNER_LARGE;
    public static final SPINNER_LARGE SPINNER_MEDIUM;
    public static final SPINNER_LARGE SPINNER_SMALL;
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

        MAPLog.e(MAPAccountManager.access$000(), "Invalid ProgressBarState value: %s", new Object[] {
            s
        });
        return null;
    }

    public static getValue valueOf(String s)
    {
        return (getValue)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState, s);
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
        OFF = new <init>("OFF", 0, "off");
        PROGRESS_BAR = new <init>("PROGRESS_BAR", 1, "progress_bar");
        SPINNER_SMALL = new <init>("SPINNER_SMALL", 2, "spinner_small");
        SPINNER_MEDIUM = new <init>("SPINNER_MEDIUM", 3, "spinner_medium");
        SPINNER_LARGE = new <init>("SPINNER_LARGE", 4, "spinner_large");
        $VALUES = (new .VALUES[] {
            OFF, PROGRESS_BAR, SPINNER_SMALL, SPINNER_MEDIUM, SPINNER_LARGE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }
}
