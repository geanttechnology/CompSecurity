// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import co.vine.android.api.VinePost;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.LoopManager;

// Referenced classes of package co.vine.android.widget:
//            FeedAdapter, FeedViewHolder, CounterView

class 
    implements co.vine.android.player.face.OnCompletionListener
{

    final FeedAdapter this$0;
    final FeedViewHolder val$tag;

    public void onCompletion(VideoViewInterface videoviewinterface)
    {
        videoviewinterface.seekTo(0);
        FeedAdapter.access$100(FeedAdapter.this, videoviewinterface, val$tag.post.postId);
        videoviewinterface = FeedAdapter.access$600(FeedAdapter.this, FeedAdapter.access$000(FeedAdapter.this));
        if (videoviewinterface != null)
        {
            val$tag.counterView.adjustExtraCount(LoopManager.getLocalLoopCount(((VinePost) (videoviewinterface)).postId));
            val$tag.counterView.invalidateCounterUI();
        }
        FlurryUtils.trackVineLoopWatched();
    }

    ()
    {
        this$0 = final_feedadapter;
        val$tag = FeedViewHolder.this;
        super();
    }
}
