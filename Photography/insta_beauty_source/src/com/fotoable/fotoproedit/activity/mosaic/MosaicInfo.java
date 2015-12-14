// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.mosaic;


public class MosaicInfo
{

    public MosaicMode a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public MosaicInfo()
    {
        a = MosaicMode.Mosaic_Maoboli;
        b = "";
        c = "";
        d = "";
        f = "";
    }

    private class MosaicMode extends Enum
    {

        private static final MosaicMode $VALUES[];
        public static final MosaicMode Mosaic_Image;
        public static final MosaicMode Mosaic_Maoboli;
        public static final MosaicMode Mosaic_Normal;
        public static final MosaicMode Mosaic_Youhua;
        public static final MosaicMode Paint_3D;
        public static final MosaicMode Paint_Normal;

        public static MosaicMode valueOf(String s)
        {
            return (MosaicMode)Enum.valueOf(com/fotoable/fotoproedit/activity/mosaic/MosaicInfo$MosaicMode, s);
        }

        public static MosaicMode[] values()
        {
            return (MosaicMode[])$VALUES.clone();
        }

        static 
        {
            Mosaic_Normal = new MosaicMode("Mosaic_Normal", 0);
            Mosaic_Youhua = new MosaicMode("Mosaic_Youhua", 1);
            Mosaic_Image = new MosaicMode("Mosaic_Image", 2);
            Mosaic_Maoboli = new MosaicMode("Mosaic_Maoboli", 3);
            Paint_3D = new MosaicMode("Paint_3D", 4);
            Paint_Normal = new MosaicMode("Paint_Normal", 5);
            $VALUES = (new MosaicMode[] {
                Mosaic_Normal, Mosaic_Youhua, Mosaic_Image, Mosaic_Maoboli, Paint_3D, Paint_Normal
            });
        }

        private MosaicMode(String s, int i)
        {
            super(s, i);
        }
    }

}
