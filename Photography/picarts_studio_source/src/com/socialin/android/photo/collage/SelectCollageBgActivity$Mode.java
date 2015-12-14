// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;


public final class  extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER DRAWING;
    public static final OTHER OTHER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/collage/SelectCollageBgActivity$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAWING = new <init>("DRAWING", 0);
        OTHER = new <init>("OTHER", 1);
        $VALUES = (new .VALUES[] {
            DRAWING, OTHER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
