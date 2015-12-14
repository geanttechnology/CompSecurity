// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class axi
{

    public static final int a[];
    public static final int b[];

    static 
    {
        b = new int[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.values().length];
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.CENTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.LEFT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.TOP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.BOTTOM.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.LEFTTOP.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.LEFTBOTTOM.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.RIGHTTOP.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            b[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.RIGHTBOTTOM.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        a = new int[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.values().length];
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.GENERAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_EYE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_ERE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_NOSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_MOUTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_CHEEK.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_MOUSTACHE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.fotoable.sketch.info.TTieZhiInfo.TIEZHIFACETYPE.FACE_MEIXIN.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
