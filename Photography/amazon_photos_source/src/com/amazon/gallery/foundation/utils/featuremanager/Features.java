// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.featuremanager;


// Referenced classes of package com.amazon.gallery.foundation.utils.featuremanager:
//            FeatureName

public final class Features extends Enum
    implements FeatureName
{

    private static final Features $VALUES[];
    public static final Features CMS;
    public static final Features CONTEXT_BAR;
    public static final Features DEVICE_CAPABILITIES;
    public static final Features FTUE;
    public static final Features HEADER_ACTION_BAR;
    public static final Features HIDE;
    public static final Features PLATFORM_DOWNLOAD_MANAGER;
    public static final Features REWIND;
    public static final Features SHARE_ALBUM;
    public static final Features SOFT_KEY_BAR;
    public static final Features VIDEO;
    public static final Features WHISPER_PLAY;

    private Features(String s, int i)
    {
        super(s, i);
    }

    public static Features valueOf(String s)
    {
        return (Features)Enum.valueOf(com/amazon/gallery/foundation/utils/featuremanager/Features, s);
    }

    public static Features[] values()
    {
        return (Features[])$VALUES.clone();
    }

    public String getName()
    {
        return toString();
    }

    static 
    {
        VIDEO = new Features("VIDEO", 0);
        WHISPER_PLAY = new Features("WHISPER_PLAY", 1);
        CMS = new Features("CMS", 2);
        HEADER_ACTION_BAR = new Features("HEADER_ACTION_BAR", 3);
        FTUE = new Features("FTUE", 4);
        CONTEXT_BAR = new Features("CONTEXT_BAR", 5);
        DEVICE_CAPABILITIES = new Features("DEVICE_CAPABILITIES", 6);
        PLATFORM_DOWNLOAD_MANAGER = new Features("PLATFORM_DOWNLOAD_MANAGER", 7);
        SOFT_KEY_BAR = new Features("SOFT_KEY_BAR", 8);
        HIDE = new Features("HIDE", 9);
        SHARE_ALBUM = new Features("SHARE_ALBUM", 10);
        REWIND = new Features("REWIND", 11);
        $VALUES = (new Features[] {
            VIDEO, WHISPER_PLAY, CMS, HEADER_ACTION_BAR, FTUE, CONTEXT_BAR, DEVICE_CAPABILITIES, PLATFORM_DOWNLOAD_MANAGER, SOFT_KEY_BAR, HIDE, 
            SHARE_ALBUM, REWIND
        });
    }
}
