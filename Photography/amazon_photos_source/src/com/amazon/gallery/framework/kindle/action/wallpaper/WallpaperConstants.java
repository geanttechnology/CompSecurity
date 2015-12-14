// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action.wallpaper;


public final class WallpaperConstants
{
    public static final class TargetLocations extends Enum
    {

        private static final TargetLocations $VALUES[];
        public static final TargetLocations HOME;
        public static final TargetLocations LOCKSCREEN;
        public final String key;

        public static TargetLocations valueOf(String s)
        {
            return (TargetLocations)Enum.valueOf(com/amazon/gallery/framework/kindle/action/wallpaper/WallpaperConstants$TargetLocations, s);
        }

        public static TargetLocations[] values()
        {
            return (TargetLocations[])$VALUES.clone();
        }

        static 
        {
            HOME = new TargetLocations("HOME", 0, "home");
            LOCKSCREEN = new TargetLocations("LOCKSCREEN", 1, "lockscreen");
            $VALUES = (new TargetLocations[] {
                HOME, LOCKSCREEN
            });
        }

        private TargetLocations(String s, int i, String s1)
        {
            super(s, i);
            key = s1;
        }
    }

}
