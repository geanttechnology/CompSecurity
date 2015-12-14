// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.connectivity;


// Referenced classes of package com.amazon.gallery.framework.network.connectivity:
//            NetworkConnectivity

public static final class  extends Enum
{

    private static final MOBILE_UPLOAD $VALUES[];
    public static final MOBILE_UPLOAD CMS;
    public static final MOBILE_UPLOAD DOWNLOAD_FOREGROUND;
    public static final MOBILE_UPLOAD METRICS_UPLOAD;
    public static final MOBILE_UPLOAD MOBILE_UPLOAD;
    public static final MOBILE_UPLOAD POLLING_SYNC_FOREGROUND;
    public static final MOBILE_UPLOAD PREFETCH_BACKGROUND;
    public static final MOBILE_UPLOAD PREFETCH_FOREGROUND;
    public static final MOBILE_UPLOAD STATECHANGE_SYNC_FOREGROUND;
    public static final MOBILE_UPLOAD SYNC_BACKGROUND;
    public static final MOBILE_UPLOAD WIFI_ONLY_UPLOAD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/connectivity/NetworkConnectivity$NetworkOperationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CMS = new <init>("CMS", 0);
        PREFETCH_BACKGROUND = new <init>("PREFETCH_BACKGROUND", 1);
        PREFETCH_FOREGROUND = new <init>("PREFETCH_FOREGROUND", 2);
        DOWNLOAD_FOREGROUND = new <init>("DOWNLOAD_FOREGROUND", 3);
        METRICS_UPLOAD = new <init>("METRICS_UPLOAD", 4);
        SYNC_BACKGROUND = new <init>("SYNC_BACKGROUND", 5);
        STATECHANGE_SYNC_FOREGROUND = new <init>("STATECHANGE_SYNC_FOREGROUND", 6);
        POLLING_SYNC_FOREGROUND = new <init>("POLLING_SYNC_FOREGROUND", 7);
        WIFI_ONLY_UPLOAD = new <init>("WIFI_ONLY_UPLOAD", 8);
        MOBILE_UPLOAD = new <init>("MOBILE_UPLOAD", 9);
        $VALUES = (new .VALUES[] {
            CMS, PREFETCH_BACKGROUND, PREFETCH_FOREGROUND, DOWNLOAD_FOREGROUND, METRICS_UPLOAD, SYNC_BACKGROUND, STATECHANGE_SYNC_FOREGROUND, POLLING_SYNC_FOREGROUND, WIFI_ONLY_UPLOAD, MOBILE_UPLOAD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
