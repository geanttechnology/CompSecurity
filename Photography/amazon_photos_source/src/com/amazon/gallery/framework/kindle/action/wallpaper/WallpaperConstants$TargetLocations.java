// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action.wallpaper;


// Referenced classes of package com.amazon.gallery.framework.kindle.action.wallpaper:
//            WallpaperConstants

public static final class key extends Enum
{

    private static final LOCKSCREEN $VALUES[];
    public static final LOCKSCREEN HOME;
    public static final LOCKSCREEN LOCKSCREEN;
    public final String key;

    public static key valueOf(String s)
    {
        return (key)Enum.valueOf(com/amazon/gallery/framework/kindle/action/wallpaper/WallpaperConstants$TargetLocations, s);
    }

    public static key[] values()
    {
        return (key[])$VALUES.clone();
    }

    static 
    {
        HOME = new <init>("HOME", 0, "home");
        LOCKSCREEN = new <init>("LOCKSCREEN", 1, "lockscreen");
        $VALUES = (new .VALUES[] {
            HOME, LOCKSCREEN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        key = s1;
    }
}
