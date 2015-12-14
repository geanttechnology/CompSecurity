// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;


public final class A extends Enum
{

    private static final MediaSortMode_Date $VALUES[];
    public static final MediaSortMode_Date MediaSortMode_Date;
    public static final MediaSortMode_Date MediaSortMode_DefaultFolder;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/fotoable/photoselector/MediaStorePhotosDB$MediaSortMode, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        MediaSortMode_DefaultFolder = new <init>("MediaSortMode_DefaultFolder", 0);
        MediaSortMode_Date = new <init>("MediaSortMode_Date", 1);
        $VALUES = (new .VALUES[] {
            MediaSortMode_DefaultFolder, MediaSortMode_Date
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
