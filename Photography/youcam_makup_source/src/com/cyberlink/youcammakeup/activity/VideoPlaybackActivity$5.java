// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            VideoPlaybackActivity

class a
    implements Runnable
{

    final VideoPlaybackActivity a;

    public void run()
    {
        VideoPlaybackActivity.c(a).setSelection(VideoPlaybackActivity.e(a));
    }

    orizontalGridView(VideoPlaybackActivity videoplaybackactivity)
    {
        a = videoplaybackactivity;
        super();
    }
}
