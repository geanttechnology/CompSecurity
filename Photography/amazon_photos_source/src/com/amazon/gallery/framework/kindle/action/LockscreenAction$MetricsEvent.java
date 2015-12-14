// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;


// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            LockscreenAction

public static final class  extends Enum
{

    private static final WallpaperSetFailure $VALUES[];
    public static final WallpaperSetFailure LockscreenMultiSelectClicked;
    public static final WallpaperSetFailure LockscreenSetFailure;
    public static final WallpaperSetFailure LockscreenSetSuccessfully;
    public static final WallpaperSetFailure LockscreenSingleViewClicked;
    public static final WallpaperSetFailure WallpaperSetFailure;
    public static final WallpaperSetFailure WallpaperSetSuccessfully;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/action/LockscreenAction$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LockscreenMultiSelectClicked = new <init>("LockscreenMultiSelectClicked", 0);
        LockscreenSingleViewClicked = new <init>("LockscreenSingleViewClicked", 1);
        LockscreenSetSuccessfully = new <init>("LockscreenSetSuccessfully", 2);
        LockscreenSetFailure = new <init>("LockscreenSetFailure", 3);
        WallpaperSetSuccessfully = new <init>("WallpaperSetSuccessfully", 4);
        WallpaperSetFailure = new <init>("WallpaperSetFailure", 5);
        $VALUES = (new .VALUES[] {
            LockscreenMultiSelectClicked, LockscreenSingleViewClicked, LockscreenSetSuccessfully, LockscreenSetFailure, WallpaperSetSuccessfully, WallpaperSetFailure
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
