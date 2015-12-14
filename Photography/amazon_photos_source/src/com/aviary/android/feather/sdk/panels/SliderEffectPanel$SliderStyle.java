// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;


// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            SliderEffectPanel

static final class I extends Enum
{

    private static final WheelStyle $VALUES[];
    public static final WheelStyle SeekBarStyle;
    public static final WheelStyle WheelStyle;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/aviary/android/feather/sdk/panels/SliderEffectPanel$SliderStyle, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        SeekBarStyle = new <init>("SeekBarStyle", 0);
        WheelStyle = new <init>("WheelStyle", 1);
        $VALUES = (new .VALUES[] {
            SeekBarStyle, WheelStyle
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
