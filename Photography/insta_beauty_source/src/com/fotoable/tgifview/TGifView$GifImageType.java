// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.tgifview;


public final class nativeInt extends Enum
{

    private static final COVER $VALUES[];
    public static final COVER COVER;
    public static final COVER SYNC_DECODER;
    public static final COVER WAIT_FINISH;
    final int nativeInt;

    public static nativeInt valueOf(String s)
    {
        return (nativeInt)Enum.valueOf(com/fotoable/tgifview/TGifView$GifImageType, s);
    }

    public static nativeInt[] values()
    {
        return (nativeInt[])$VALUES.clone();
    }

    static 
    {
        WAIT_FINISH = new <init>("WAIT_FINISH", 0, 0);
        SYNC_DECODER = new <init>("SYNC_DECODER", 1, 1);
        COVER = new <init>("COVER", 2, 2);
        $VALUES = (new .VALUES[] {
            WAIT_FINISH, SYNC_DECODER, COVER
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        nativeInt = j;
    }
}
