// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.freecrop;


public final class I extends Enum
{

    private static final Lasso $VALUES[];
    public static final Lasso FreeCrop;
    public static final Lasso Lasso;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/socialin/android/photo/freecrop/FreeCropDrawController$DrawMode, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        FreeCrop = new <init>("FreeCrop", 0);
        Lasso = new <init>("Lasso", 1);
        $VALUES = (new .VALUES[] {
            FreeCrop, Lasso
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
