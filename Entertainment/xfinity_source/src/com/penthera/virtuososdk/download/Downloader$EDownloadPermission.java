// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;


// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

public static final class  extends Enum
{

    public static final EDownloadBlockedWifi EDownloadAllowed;
    public static final EDownloadBlockedWifi EDownloadBlockedAuthentication;
    public static final EDownloadBlockedWifi EDownloadBlockedBattery;
    public static final EDownloadBlockedWifi EDownloadBlockedCell;
    public static final EDownloadBlockedWifi EDownloadBlockedHeadroom;
    public static final EDownloadBlockedWifi EDownloadBlockedPaused;
    public static final EDownloadBlockedWifi EDownloadBlockedStorage;
    public static final EDownloadBlockedWifi EDownloadBlockedWifi;
    private static final EDownloadBlockedWifi ENUM$VALUES[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/download/Downloader$EDownloadPermission, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        EDownloadAllowed = new <init>("EDownloadAllowed", 0);
        EDownloadBlockedCell = new <init>("EDownloadBlockedCell", 1);
        EDownloadBlockedBattery = new <init>("EDownloadBlockedBattery", 2);
        EDownloadBlockedHeadroom = new <init>("EDownloadBlockedHeadroom", 3);
        EDownloadBlockedStorage = new <init>("EDownloadBlockedStorage", 4);
        EDownloadBlockedPaused = new <init>("EDownloadBlockedPaused", 5);
        EDownloadBlockedAuthentication = new <init>("EDownloadBlockedAuthentication", 6);
        EDownloadBlockedWifi = new <init>("EDownloadBlockedWifi", 7);
        ENUM$VALUES = (new ENUM.VALUES[] {
            EDownloadAllowed, EDownloadBlockedCell, EDownloadBlockedBattery, EDownloadBlockedHeadroom, EDownloadBlockedStorage, EDownloadBlockedPaused, EDownloadBlockedAuthentication, EDownloadBlockedWifi
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
