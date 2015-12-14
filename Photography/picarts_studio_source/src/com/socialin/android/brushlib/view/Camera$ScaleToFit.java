// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;


public final class  extends Enum
{

    private static final CENTER $VALUES[];
    public static final CENTER CENTER;
    public static final CENTER HEIGHT;
    public static final CENTER WIDTH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/view/Camera$ScaleToFit, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        WIDTH = new <init>("WIDTH", 0);
        HEIGHT = new <init>("HEIGHT", 1);
        CENTER = new <init>("CENTER", 2);
        $VALUES = (new .VALUES[] {
            WIDTH, HEIGHT, CENTER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
