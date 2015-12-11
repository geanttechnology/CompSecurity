// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class val.liveStreamBookmark
    implements android.view.bletFeaturedFragment._cls5
{

    final TabletFeaturedFragment this$0;
    final LiveStreamBookmark val$liveStreamBookmark;

    public void onClick(View view)
    {
        view = VideoPlayerActivity.createIntentForPlayer(val$liveStreamBookmark.getStreamId());
        startActivity(view);
    }

    ()
    {
        this$0 = final_tabletfeaturedfragment;
        val$liveStreamBookmark = LiveStreamBookmark.this;
        super();
    }
}
