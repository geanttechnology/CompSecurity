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

class this._cls1
    implements android.media.istener
{

    final is._cls0 this$1;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        VideoPlayerActivity.access$600(_fld0).stopBufferingDetector();
        VideoPlayerActivity.access$600(_fld0).stopPlayback(true);
        VideoPlayerActivity.access$7200(_fld0).start();
        VideoPlayerActivity.access$200(_fld0);
        VideoPlayerActivity.access$1102(_fld0, false);
    }

    l.item()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$28

/* anonymous class */
    class VideoPlayerActivity._cls28
        implements Runnable
    {

        final VideoPlayerActivity this$0;
        final MediaDetailsItem val$item;

        public void run()
        {
            VideoPlayerActivity.access$500(VideoPlayerActivity.this).setOnCompletionListener(new VideoPlayerActivity._cls28._cls1());
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).playVideo(item.getSplashVideoUrl(), 0);
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).hideControls();
        }

            
            {
                this$0 = final_videoplayeractivity;
                item = MediaDetailsItem.this;
                super();
            }
    }

}
