// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.enums;


public final class AdType extends Enum
{

    private static final AdType $VALUES[];
    public static final AdType AUDITUDE;
    public static final AdType C3;
    public static final AdType FREEWHEEL;
    public static final AdType MANIFEST_MANIPULATOR;
    public static final AdType NONE;

    private AdType(String s, int i)
    {
        super(s, i);
    }

    public static AdType valueOf(String s)
    {
        return (AdType)Enum.valueOf(com/comcast/playerplatform/primetime/android/enums/AdType, s);
    }

    public static AdType[] values()
    {
        return (AdType[])$VALUES.clone();
    }

    static 
    {
        AUDITUDE = new AdType("AUDITUDE", 0);
        C3 = new AdType("C3", 1);
        MANIFEST_MANIPULATOR = new AdType("MANIFEST_MANIPULATOR", 2);
        NONE = new AdType("NONE", 3);
        FREEWHEEL = new AdType("FREEWHEEL", 4);
        $VALUES = (new AdType[] {
            AUDITUDE, C3, MANIFEST_MANIPULATOR, NONE, FREEWHEEL
        });
    }
}
