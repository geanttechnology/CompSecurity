// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;


// Referenced classes of package com.aviary.android.feather.headless.filters:
//            NativeToolFilter

public static final class Q extends Enum
{

    private static final None $VALUES[];
    public static final None Blemish;
    public static final None Blur;
    public static final None ColorSplash;
    public static final None None;
    public static final None RedEye;
    public static final None TiltShift;
    public static final None Whiten;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/aviary/android/feather/headless/filters/NativeToolFilter$NativeToolType, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        ColorSplash = new <init>("ColorSplash", 0);
        TiltShift = new <init>("TiltShift", 1);
        Blemish = new <init>("Blemish", 2);
        RedEye = new <init>("RedEye", 3);
        Whiten = new <init>("Whiten", 4);
        Blur = new <init>("Blur", 5);
        None = new <init>("None", 6);
        $VALUES = (new .VALUES[] {
            ColorSplash, TiltShift, Blemish, RedEye, Whiten, Blur, None
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
