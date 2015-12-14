// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.info;


public final class _cls9 extends Enum
{

    private static final FACE_MEIXIN $VALUES[];
    public static final FACE_MEIXIN FACE_CHEEK;
    public static final FACE_MEIXIN FACE_ERE;
    public static final FACE_MEIXIN FACE_EYE;
    public static final FACE_MEIXIN FACE_MEIXIN;
    public static final FACE_MEIXIN FACE_MOUSTACHE;
    public static final FACE_MEIXIN FACE_MOUTH;
    public static final FACE_MEIXIN FACE_NOSE;
    public static final FACE_MEIXIN GENERAL;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/fotoable/sketch/info/TTieZhiInfo$TIEZHIFACETYPE, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        GENERAL = new <init>("GENERAL", 0);
        FACE_EYE = new <init>("FACE_EYE", 1);
        FACE_ERE = new <init>("FACE_ERE", 2);
        FACE_MOUTH = new <init>("FACE_MOUTH", 3);
        FACE_NOSE = new <init>("FACE_NOSE", 4);
        FACE_CHEEK = new <init>("FACE_CHEEK", 5);
        FACE_MOUSTACHE = new <init>("FACE_MOUSTACHE", 6);
        FACE_MEIXIN = new <init>("FACE_MEIXIN", 7);
        $VALUES = (new .VALUES[] {
            GENERAL, FACE_EYE, FACE_ERE, FACE_MOUTH, FACE_NOSE, FACE_CHEEK, FACE_MOUSTACHE, FACE_MEIXIN
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
