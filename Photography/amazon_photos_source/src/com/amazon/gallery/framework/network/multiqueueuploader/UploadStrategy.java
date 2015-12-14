// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


public final class UploadStrategy extends Enum
{

    private static final UploadStrategy $VALUES[];
    public static final UploadStrategy ALL;
    public static final UploadStrategy WIFI_ONLY;

    private UploadStrategy(String s, int i)
    {
        super(s, i);
    }

    public static UploadStrategy valueOf(String s)
    {
        return (UploadStrategy)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadStrategy, s);
    }

    public static UploadStrategy[] values()
    {
        return (UploadStrategy[])$VALUES.clone();
    }

    static 
    {
        WIFI_ONLY = new UploadStrategy("WIFI_ONLY", 0);
        ALL = new UploadStrategy("ALL", 1);
        $VALUES = (new UploadStrategy[] {
            WIFI_ONLY, ALL
        });
    }
}
