// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.util.SparseArray;
import co.vine.android.api.VinePost;
import co.vine.android.player.SdkVideoView;
import co.vine.android.player.VideoViewInterface;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.widget:
//            FeedAdapter, FeedViewHolder

class 
    implements co.vine.android.player.face.OnErrorListener
{

    final FeedAdapter this$0;
    final int val$position;
    final FeedViewHolder val$tag;
    final SdkVideoView val$view;

    public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
    {
        SLog.d("Got error, try recycling it more aggressively: {}, {}", Integer.valueOf(i), Integer.valueOf(j));
        FeedAdapter.access$202(FeedAdapter.this, FeedAdapter.access$300(FeedAdapter.this) - 1);
        FeedAdapter.access$402(FeedAdapter.this, true);
        releaseOtherPlayers(val$view);
        if (!val$view.retryOpenVideo(false))
        {
            SLog.e("Replay video using videoLowUrl.");
            FeedAdapter.access$500(FeedAdapter.this).remove(val$position);
            if (val$tag.post != null && val$tag.post.videoLowURL != null)
            {
                val$tag.post.videoUrl = val$tag.post.videoLowURL;
                val$tag.post.videoLowURL = null;
                val$view.setReportOpenError(true);
                if (FeedAdapter.access$000(FeedAdapter.this) == val$position)
                {
                    stopCurrentPlayer();
                }
                play(val$position);
            }
        }
        return true;
    }

    ()
    {
        this$0 = final_feedadapter;
        val$view = sdkvideoview;
        val$position = i;
        val$tag = FeedViewHolder.this;
        super();
    }
}
