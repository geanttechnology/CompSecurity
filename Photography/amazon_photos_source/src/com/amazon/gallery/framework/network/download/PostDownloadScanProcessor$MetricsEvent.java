// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;


// Referenced classes of package com.amazon.gallery.framework.network.download:
//            PostDownloadScanProcessor

public static final class  extends Enum
{

    private static final DownloadPhoto $VALUES[];
    public static final DownloadPhoto DownloadPhoto;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/download/PostDownloadScanProcessor$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DownloadPhoto = new <init>("DownloadPhoto", 0);
        $VALUES = (new .VALUES[] {
            DownloadPhoto
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
