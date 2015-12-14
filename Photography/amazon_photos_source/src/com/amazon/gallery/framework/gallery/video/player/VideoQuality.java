// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video.player;


public final class VideoQuality extends Enum
{

    private static final VideoQuality $VALUES[];
    public static VideoQuality CURRENT_QUALITY;
    public static final VideoQuality _360P;
    public static final VideoQuality _480P;
    public static final VideoQuality _720P;
    public static final VideoQuality _AUTO;
    private final int height;
    private final int width;

    private VideoQuality(String s, int i)
    {
        super(s, i);
        width = -1;
        height = -1;
    }

    private VideoQuality(String s, int i, int j, int k)
    {
        super(s, i);
        width = j;
        height = k;
    }

    public static VideoQuality valueOf(String s)
    {
        return (VideoQuality)Enum.valueOf(com/amazon/gallery/framework/gallery/video/player/VideoQuality, s);
    }

    public static VideoQuality[] values()
    {
        return (VideoQuality[])$VALUES.clone();
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    static 
    {
        _AUTO = new VideoQuality("_AUTO", 0);
        _360P = new VideoQuality("_360P", 1, 480, 360);
        _480P = new VideoQuality("_480P", 2, 720, 480);
        _720P = new VideoQuality("_720P", 3, 1280, 720);
        $VALUES = (new VideoQuality[] {
            _AUTO, _360P, _480P, _720P
        });
        CURRENT_QUALITY = _AUTO;
    }
}
