// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.media.MediaPlayer;

// Referenced classes of package com.aio.downloader.activity:
//            VideoViewActivity

class this._cls0
    implements android.media.tionListener
{

    final VideoViewActivity this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        finish();
    }

    ()
    {
        this$0 = VideoViewActivity.this;
        super();
    }
}
