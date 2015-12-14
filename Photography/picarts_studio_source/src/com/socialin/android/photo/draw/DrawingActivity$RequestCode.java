// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;


final class A extends Enum
{

    private static final SELECT_CLIPART $VALUES[];
    public static final SELECT_CLIPART CANCEL_CONFIRM;
    public static final SELECT_CLIPART CHOOSE_PIC_FOR_ADD_PHOTO;
    public static final SELECT_CLIPART CHOOSE_PIC_FOR_LAYER;
    public static final SELECT_CLIPART CROP_IMAGE_FOR_ADD_PHOTO;
    public static final SELECT_CLIPART CROP_IMG_FOR_LAYER;
    public static final SELECT_CLIPART EXPORT;
    public static final SELECT_CLIPART SAVE_TO_SD;
    public static final SELECT_CLIPART SELECT_BRUSH;
    public static final SELECT_CLIPART SELECT_CLIPART;
    public static final SELECT_CLIPART SELECT_SHAPE;
    public static final SELECT_CLIPART SELECT_TEXT;

    public static A fromInt(int i)
    {
        A aa[] = values();
        if (i < 0 || i >= aa.length)
        {
            return null;
        } else
        {
            return values()[i];
        }
    }

    public static values valueOf(String s)
    {
        return (values)Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$RequestCode, s);
    }

    public static values[] values()
    {
        return (values[])$VALUES.clone();
    }

    public final int toInt()
    {
        return ordinal();
    }

    static 
    {
        SAVE_TO_SD = new <init>("SAVE_TO_SD", 0);
        EXPORT = new <init>("EXPORT", 1);
        CANCEL_CONFIRM = new <init>("CANCEL_CONFIRM", 2);
        CHOOSE_PIC_FOR_LAYER = new <init>("CHOOSE_PIC_FOR_LAYER", 3);
        CHOOSE_PIC_FOR_ADD_PHOTO = new <init>("CHOOSE_PIC_FOR_ADD_PHOTO", 4);
        CROP_IMG_FOR_LAYER = new <init>("CROP_IMG_FOR_LAYER", 5);
        CROP_IMAGE_FOR_ADD_PHOTO = new <init>("CROP_IMAGE_FOR_ADD_PHOTO", 6);
        SELECT_BRUSH = new <init>("SELECT_BRUSH", 7);
        SELECT_TEXT = new <init>("SELECT_TEXT", 8);
        SELECT_SHAPE = new <init>("SELECT_SHAPE", 9);
        SELECT_CLIPART = new <init>("SELECT_CLIPART", 10);
        $VALUES = (new .VALUES[] {
            SAVE_TO_SD, EXPORT, CANCEL_CONFIRM, CHOOSE_PIC_FOR_LAYER, CHOOSE_PIC_FOR_ADD_PHOTO, CROP_IMG_FOR_LAYER, CROP_IMAGE_FOR_ADD_PHOTO, SELECT_BRUSH, SELECT_TEXT, SELECT_SHAPE, 
            SELECT_CLIPART
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
