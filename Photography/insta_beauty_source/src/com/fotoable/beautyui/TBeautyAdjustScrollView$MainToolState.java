// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;


public final class A extends Enum
{

    private static final Crop $VALUES[];
    public static final Crop BigEye;
    public static final Crop ClearEye;
    public static final Crop Crop;
    public static final Crop EnhanceNose;
    public static final Crop EyeBag;
    public static final Crop OneKey;
    public static final Crop QuBan;
    public static final Crop SlimFace;
    public static final Crop SlimNose;
    public static final Crop Soften;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/fotoable/beautyui/TBeautyAdjustScrollView$MainToolState, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        OneKey = new <init>("OneKey", 0);
        Soften = new <init>("Soften", 1);
        QuBan = new <init>("QuBan", 2);
        SlimFace = new <init>("SlimFace", 3);
        BigEye = new <init>("BigEye", 4);
        EyeBag = new <init>("EyeBag", 5);
        EnhanceNose = new <init>("EnhanceNose", 6);
        SlimNose = new <init>("SlimNose", 7);
        ClearEye = new <init>("ClearEye", 8);
        Crop = new <init>("Crop", 9);
        $VALUES = (new .VALUES[] {
            OneKey, Soften, QuBan, SlimFace, BigEye, EyeBag, EnhanceNose, SlimNose, ClearEye, Crop
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
