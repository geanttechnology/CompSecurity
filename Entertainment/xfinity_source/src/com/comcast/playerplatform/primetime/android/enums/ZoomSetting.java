// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.enums;


public final class ZoomSetting extends Enum
{

    private static final ZoomSetting $VALUES[];
    public static final ZoomSetting Full;
    public static final ZoomSetting None;

    private ZoomSetting(String s, int i)
    {
        super(s, i);
    }

    public static ZoomSetting valueOf(String s)
    {
        return (ZoomSetting)Enum.valueOf(com/comcast/playerplatform/primetime/android/enums/ZoomSetting, s);
    }

    public static ZoomSetting[] values()
    {
        return (ZoomSetting[])$VALUES.clone();
    }

    static 
    {
        None = new ZoomSetting("None", 0);
        Full = new ZoomSetting("Full", 1);
        $VALUES = (new ZoomSetting[] {
            None, Full
        });
    }
}
