// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;


final class  extends Enum
{

    private static final CAMERA $VALUES[];
    public static final CAMERA BRUSH;
    public static final CAMERA CAMERA;
    public static final CAMERA SHAPE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/draw/dialog/SelectShapeDialog$ShapeReason, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHAPE = new <init>("SHAPE", 0);
        BRUSH = new <init>("BRUSH", 1);
        CAMERA = new <init>("CAMERA", 2);
        $VALUES = (new .VALUES[] {
            SHAPE, BRUSH, CAMERA
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
