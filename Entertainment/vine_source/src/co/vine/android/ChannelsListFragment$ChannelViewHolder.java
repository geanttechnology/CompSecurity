// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.image.ImageKey;

// Referenced classes of package co.vine.android:
//            ChannelsListFragment

private class channelTitle
{

    public long channelId;
    public ImageView channelImage;
    public ImageKey channelImageKey;
    public TextView channelTitle;
    final ChannelsListFragment this$0;

    public (View view)
    {
        this$0 = ChannelsListFragment.this;
        super();
        channelImage = (ImageView)view.findViewById(0x7f0a0077);
        channelTitle = (TextView)view.findViewById(0x7f0a0078);
    }
}
