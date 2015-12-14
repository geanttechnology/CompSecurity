// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;


public final class  extends Enum
{

    private static final LAYER_TRANSFORM $VALUES[];
    public static final LAYER_TRANSFORM BRUSH;
    public static final LAYER_TRANSFORM CAMERA;
    public static final LAYER_TRANSFORM COLOR_PICKER;
    public static final LAYER_TRANSFORM LAYER_TRANSFORM;
    public static final LAYER_TRANSFORM PHOTO;
    public static final LAYER_TRANSFORM SHAPE;
    public static final LAYER_TRANSFORM TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/view/DrawingView$EditingMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BRUSH = new <init>("BRUSH", 0);
        SHAPE = new <init>("SHAPE", 1);
        TEXT = new <init>("TEXT", 2);
        COLOR_PICKER = new <init>("COLOR_PICKER", 3);
        PHOTO = new <init>("PHOTO", 4);
        CAMERA = new <init>("CAMERA", 5);
        LAYER_TRANSFORM = new <init>("LAYER_TRANSFORM", 6);
        $VALUES = (new .VALUES[] {
            BRUSH, SHAPE, TEXT, COLOR_PICKER, PHOTO, CAMERA, LAYER_TRANSFORM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
