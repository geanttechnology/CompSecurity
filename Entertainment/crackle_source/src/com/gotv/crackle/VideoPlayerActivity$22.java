// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.Log;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class val.mediaItem
    implements com.gotv.crackle.data.Listener
{

    final VideoPlayerActivity this$0;
    final DetailsProvider val$detailsProvider;
    final MediaDetailsItem val$mediaItem;

    public void onDataFailed(String s, String s1)
    {
        Log.w(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), "Failed to get channel data to load next media in playlist");
    }

    public void onDataSuccess(String s)
    {
        VideoPlayerActivity.access$802(VideoPlayerActivity.this, val$detailsProvider.getNextMediaIdAfter(VideoPlayerActivity.access$3700(VideoPlayerActivity.this)));
        if (VideoPlayerActivity.access$800(VideoPlayerActivity.this) == null && val$mediaItem.getRootChannel().equalsIgnoreCase("movies"))
        {
            VideoPlayerActivity.access$6500(VideoPlayerActivity.this, val$mediaItem);
        }
    }

    questListener()
    {
        this$0 = final_videoplayeractivity;
        val$detailsProvider = detailsprovider;
        val$mediaItem = MediaDetailsItem.this;
        super();
    }
}
