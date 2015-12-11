// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;


public final class GifImageType extends Enum
{

    public static final GifImageType COVER;
    private static final GifImageType ENUM$VALUES[];
    public static final GifImageType SYNC_DECODER;
    public static final GifImageType WAIT_FINISH;
    final int nativeInt;

    private GifImageType(String s, int i, int j)
    {
        super(s, i);
        nativeInt = j;
    }

    public static GifImageType valueOf(String s)
    {
        return (GifImageType)Enum.valueOf(com/ant/liao/GifImageType, s);
    }

    public static GifImageType[] values()
    {
        GifImageType agifimagetype[] = ENUM$VALUES;
        int i = agifimagetype.length;
        GifImageType agifimagetype1[] = new GifImageType[i];
        System.arraycopy(agifimagetype, 0, agifimagetype1, 0, i);
        return agifimagetype1;
    }

    static 
    {
        WAIT_FINISH = new GifImageType("WAIT_FINISH", 0, 0);
        SYNC_DECODER = new GifImageType("SYNC_DECODER", 1, 1);
        COVER = new GifImageType("COVER", 2, 2);
        ENUM$VALUES = (new GifImageType[] {
            WAIT_FINISH, SYNC_DECODER, COVER
        });
    }
}
