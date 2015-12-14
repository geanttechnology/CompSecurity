// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;


final class  extends Enum
{

    private static final LANDSCAPE $VALUES[];
    public static final LANDSCAPE LANDSCAPE;
    public static final LANDSCAPE PORTRAIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/draw/dialog/SelectCanvasSizeDialog$ImageOrientation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PORTRAIT = new <init>("PORTRAIT", 0);
        LANDSCAPE = new <init>("LANDSCAPE", 1);
        $VALUES = (new .VALUES[] {
            PORTRAIT, LANDSCAPE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
