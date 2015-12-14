// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;


public final class DownloadType extends Enum
{

    private static final DownloadType $VALUES[];
    public static final DownloadType Cache;
    public static final DownloadType Normal;

    private DownloadType(String s, int i)
    {
        super(s, i);
    }

    public static DownloadType valueOf(String s)
    {
        return (DownloadType)Enum.valueOf(com/amazon/gallery/framework/network/download/DownloadType, s);
    }

    public static DownloadType[] values()
    {
        return (DownloadType[])$VALUES.clone();
    }

    static 
    {
        Cache = new DownloadType("Cache", 0);
        Normal = new DownloadType("Normal", 1);
        $VALUES = (new DownloadType[] {
            Cache, Normal
        });
    }
}
