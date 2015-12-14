// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;


public final class  extends Enum
{

    private static final VECTOR $VALUES[];
    public static final VECTOR RASTER;
    public static final VECTOR VECTOR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/lensflare/LensFlareFactory$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RASTER = new <init>("RASTER", 0);
        VECTOR = new <init>("VECTOR", 1);
        $VALUES = (new .VALUES[] {
            RASTER, VECTOR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
