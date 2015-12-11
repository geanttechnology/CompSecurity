// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;


public final class ImageIdType extends Enum
{

    private static final ImageIdType $VALUES[];
    public static final ImageIdType MD5_HASH;
    public static final ImageIdType UNKNOWN;
    public static final ImageIdType ZOOM_GUID;

    private ImageIdType(String s, int i)
    {
        super(s, i);
    }

    public static ImageIdType valueOf(String s)
    {
        return (ImageIdType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/type/base/ImageIdType, s);
    }

    public static ImageIdType[] values()
    {
        return (ImageIdType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new ImageIdType("UNKNOWN", 0);
        MD5_HASH = new ImageIdType("MD5_HASH", 1);
        ZOOM_GUID = new ImageIdType("ZOOM_GUID", 2);
        $VALUES = (new ImageIdType[] {
            UNKNOWN, MD5_HASH, ZOOM_GUID
        });
    }
}
