// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.preference;


public final class SoundType extends Enum
{

    private static final SoundType $VALUES[];
    public static final SoundType ALWAYS;
    public static final SoundType DEFAULT_MODE;
    public static final SoundType NO_SOUND;
    private final int value;

    private SoundType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static SoundType fromInt(int i)
    {
        switch (i)
        {
        default:
            return DEFAULT_MODE;

        case 0: // '\0'
            return DEFAULT_MODE;

        case 1: // '\001'
            return NO_SOUND;

        case 2: // '\002'
            return ALWAYS;
        }
    }

    public static SoundType valueOf(String s)
    {
        return (SoundType)Enum.valueOf(com/arellomobile/android/push/preference/SoundType, s);
    }

    public static SoundType[] values()
    {
        return (SoundType[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        DEFAULT_MODE = new SoundType("DEFAULT_MODE", 0, 0);
        NO_SOUND = new SoundType("NO_SOUND", 1, 1);
        ALWAYS = new SoundType("ALWAYS", 2, 2);
        $VALUES = (new SoundType[] {
            DEFAULT_MODE, NO_SOUND, ALWAYS
        });
    }
}
