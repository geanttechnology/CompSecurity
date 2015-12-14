// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.mosaic;


public final class  extends Enum
{

    private static final Paint_Normal $VALUES[];
    public static final Paint_Normal Mosaic_Image;
    public static final Paint_Normal Mosaic_Maoboli;
    public static final Paint_Normal Mosaic_Normal;
    public static final Paint_Normal Mosaic_Youhua;
    public static final Paint_Normal Paint_3D;
    public static final Paint_Normal Paint_Normal;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/fotoproedit/activity/mosaic/MosaicInfo$MosaicMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Mosaic_Normal = new <init>("Mosaic_Normal", 0);
        Mosaic_Youhua = new <init>("Mosaic_Youhua", 1);
        Mosaic_Image = new <init>("Mosaic_Image", 2);
        Mosaic_Maoboli = new <init>("Mosaic_Maoboli", 3);
        Paint_3D = new <init>("Paint_3D", 4);
        Paint_Normal = new <init>("Paint_Normal", 5);
        $VALUES = (new .VALUES[] {
            Mosaic_Normal, Mosaic_Youhua, Mosaic_Image, Mosaic_Maoboli, Paint_3D, Paint_Normal
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
