// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class ahm
{

    public static final int a[];

    static 
    {
        a = new int[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.values().length];
        try
        {
            a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Image.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Maoboli.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Normal.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Youhua.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_3D.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_Normal.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
