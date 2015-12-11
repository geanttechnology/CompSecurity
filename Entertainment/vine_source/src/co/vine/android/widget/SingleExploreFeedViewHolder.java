// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.View;
import co.vine.android.player.OldSdkVideoView;

// Referenced classes of package co.vine.android.widget:
//            GenericFeedViewHolder

public class SingleExploreFeedViewHolder extends GenericFeedViewHolder
{

    public final OldSdkVideoView videoView;

    public SingleExploreFeedViewHolder(View view)
    {
        super(view);
        videoView = (OldSdkVideoView)view.findViewById(0x7f0a0075);
    }

    public View getViewForVideoImage()
    {
        return videoView;
    }
}
