// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import com.shazam.android.view.media.MediaPlayerView;

// Referenced classes of package com.shazam.android.activities:
//            VideoPlayerActivity

final class a
    implements Runnable
{

    final VideoPlayerActivity a;

    public final void run()
    {
        VideoPlayerActivity.a(a);
        VideoPlayerActivity.b(a).start();
    }

    _cls9(VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }
}
