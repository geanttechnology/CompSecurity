// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;


public final class A extends Enum
{

    private static final MASK $VALUES[];
    public static final MASK CROP;
    public static final MASK MASK;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/socialin/android/photo/collage/ShapeCropHelper$EditMode, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        CROP = new <init>("CROP", 0);
        MASK = new <init>("MASK", 1);
        $VALUES = (new .VALUES[] {
            CROP, MASK
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
