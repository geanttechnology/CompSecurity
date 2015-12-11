// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import co.vine.android.api.VinePost;
import co.vine.android.player.SdkVideoView;
import co.vine.android.player.VideoViewInterface;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.widget:
//            FeedAdapter, FeedViewHolder

class 
    implements co.vine.android.player.face.OnPreparedListener
{

    final FeedAdapter this$0;
    final FeedViewHolder val$tag;

    public void onPrepared(VideoViewInterface videoviewinterface)
    {
        if (videoviewinterface.getPlayingPosition() == FeedAdapter.access$000(FeedAdapter.this))
        {
            FeedAdapter.access$100(FeedAdapter.this, videoviewinterface, val$tag.post.postId);
        } else
        {
            SLog.e("This video should not be played: {}, {}.", Integer.valueOf(videoviewinterface.getPlayingPosition()), Integer.valueOf(FeedAdapter.access$000(FeedAdapter.this)));
        }
        endLoadingTimeProfiling();
        val$tag.videoView.setVisibility(0);
    }

    ()
    {
        this$0 = final_feedadapter;
        val$tag = FeedViewHolder.this;
        super();
    }
}
