// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.View;
import android.widget.ImageView;
import co.vine.android.player.OnListVideoClickListener;
import co.vine.android.player.SdkVideoView;

// Referenced classes of package co.vine.android.widget:
//            GenericFeedViewHolder

public class FeedViewHolder extends GenericFeedViewHolder
{

    public OnListVideoClickListener listener;
    public ImageView videoImage;
    public SdkVideoView videoView;

    public FeedViewHolder(View view)
    {
        super(view);
        videoImage = (ImageView)view.findViewById(0x7f0a012b);
    }

    public View getViewForVideoImage()
    {
        return videoImage;
    }
}
