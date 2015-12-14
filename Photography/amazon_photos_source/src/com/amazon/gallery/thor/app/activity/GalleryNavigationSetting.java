// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


public final class GalleryNavigationSetting extends Enum
{

    private static final GalleryNavigationSetting $VALUES[];
    public static final GalleryNavigationSetting BACK;
    public static final GalleryNavigationSetting ICON;
    public static final GalleryNavigationSetting LEFT;
    public static final GalleryNavigationSetting NONE;

    private GalleryNavigationSetting(String s, int i)
    {
        super(s, i);
    }

    public static GalleryNavigationSetting valueOf(String s)
    {
        return (GalleryNavigationSetting)Enum.valueOf(com/amazon/gallery/thor/app/activity/GalleryNavigationSetting, s);
    }

    public static GalleryNavigationSetting[] values()
    {
        return (GalleryNavigationSetting[])$VALUES.clone();
    }

    static 
    {
        ICON = new GalleryNavigationSetting("ICON", 0);
        LEFT = new GalleryNavigationSetting("LEFT", 1);
        NONE = new GalleryNavigationSetting("NONE", 2);
        BACK = new GalleryNavigationSetting("BACK", 3);
        $VALUES = (new GalleryNavigationSetting[] {
            ICON, LEFT, NONE, BACK
        });
    }
}
