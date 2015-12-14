// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;


public final class I extends Enum
{

    private static final ADD_DRAWABLE $VALUES[];
    public static final ADD_DRAWABLE ADD_DRAWABLE;
    public static final ADD_DRAWABLE FREE_CROP;
    public static final ADD_DRAWABLE LASSO;
    public static final ADD_DRAWABLE SHAPE;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/socialin/android/photo/select/SelectionDrawController$DRAW_MODE, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        FREE_CROP = new <init>("FREE_CROP", 0);
        LASSO = new <init>("LASSO", 1);
        SHAPE = new <init>("SHAPE", 2);
        ADD_DRAWABLE = new <init>("ADD_DRAWABLE", 3);
        $VALUES = (new .VALUES[] {
            FREE_CROP, LASSO, SHAPE, ADD_DRAWABLE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
