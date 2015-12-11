// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.preference;


public final class VibrateType extends Enum
{

    private static final VibrateType $VALUES[];
    public static final VibrateType ALWAYS;
    public static final VibrateType DEFAULT_MODE;
    public static final VibrateType NO_VIBRATE;
    private final int value;

    private VibrateType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static VibrateType fromInt(int i)
    {
        switch (i)
        {
        default:
            return DEFAULT_MODE;

        case 0: // '\0'
            return DEFAULT_MODE;

        case 1: // '\001'
            return NO_VIBRATE;

        case 2: // '\002'
            return ALWAYS;
        }
    }

    public static VibrateType valueOf(String s)
    {
        return (VibrateType)Enum.valueOf(com/arellomobile/android/push/preference/VibrateType, s);
    }

    public static VibrateType[] values()
    {
        return (VibrateType[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        DEFAULT_MODE = new VibrateType("DEFAULT_MODE", 0, 0);
        NO_VIBRATE = new VibrateType("NO_VIBRATE", 1, 1);
        ALWAYS = new VibrateType("ALWAYS", 2, 2);
        $VALUES = (new VibrateType[] {
            DEFAULT_MODE, NO_VIBRATE, ALWAYS
        });
    }
}
