// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.media.MediaPlayer;

// Referenced classes of package com.shazam.android.activities:
//            VideoPlayerActivity

final class a
    implements android.media.Listener
{

    final VideoPlayerActivity a;

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        mediaplayer.setOnSeekCompleteListener(a);
    }

    _cls9(VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }
}
