// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.media.MediaPlayer;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.views.MediaControllerView;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class val.item
    implements Runnable
{

    final VideoPlayerActivity this$0;
    final MediaDetailsItem val$item;

    public void run()
    {
        VideoPlayerActivity.access$500(VideoPlayerActivity.this).setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final VideoPlayerActivity._cls28 this$1;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                VideoPlayerActivity.access$600(this$0).stopBufferingDetector();
                VideoPlayerActivity.access$600(this$0).stopPlayback(true);
                VideoPlayerActivity.access$7200(this$0).start();
                VideoPlayerActivity.access$200(this$0);
                VideoPlayerActivity.access$1102(this$0, false);
            }

            
            {
                this$1 = VideoPlayerActivity._cls28.this;
                super();
            }
        });
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).playVideo(val$item.getSplashVideoUrl(), 0);
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).hideControls();
    }

    _cls1.this._cls1()
    {
        this$0 = final_videoplayeractivity;
        val$item = MediaDetailsItem.this;
        super();
    }
}
