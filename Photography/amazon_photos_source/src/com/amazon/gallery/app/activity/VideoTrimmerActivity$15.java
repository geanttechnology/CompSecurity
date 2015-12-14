// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import com.amazon.gallery.framework.gallery.video.player.VideoQuality;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

static class uality
{

    static final int $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality = new int[VideoQuality.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._360P.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._480P.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._720P.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._AUTO.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
