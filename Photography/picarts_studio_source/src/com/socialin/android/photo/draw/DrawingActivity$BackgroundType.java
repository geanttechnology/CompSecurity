// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;


final class  extends Enum
{

    private static final BACKGROUND $VALUES[];
    public static final BACKGROUND BACKGROUND;
    public static final BACKGROUND BLANK;
    public static final BACKGROUND PHOTO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$BackgroundType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BLANK = new <init>("BLANK", 0);
        PHOTO = new <init>("PHOTO", 1);
        BACKGROUND = new <init>("BACKGROUND", 2);
        $VALUES = (new .VALUES[] {
            BLANK, PHOTO, BACKGROUND
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
