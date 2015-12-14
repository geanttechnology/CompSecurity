// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.media.MediaPlayer;

// Referenced classes of package com.facebook.ads:
//            VideoAdActivity

class o
    implements android.media.MediaPlayer.OnCompletionListener
{

    final VideoAdActivity a;

    o(VideoAdActivity videoadactivity)
    {
        a = videoadactivity;
        super();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        VideoAdActivity.access$1100(a, VideoAdActivity.a.e);
        VideoAdActivity.access$300(a);
    }
}
