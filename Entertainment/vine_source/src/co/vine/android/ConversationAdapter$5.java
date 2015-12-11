// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.player.SdkVideoView;
import co.vine.android.player.VideoViewInterface;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

class val.position
    implements co.vine.android.player.ompletionListener
{

    final ConversationAdapter this$0;
    final int val$position;
    final SdkVideoView val$view;

    public void onCompletion(VideoViewInterface videoviewinterface)
    {
        if (ConversationAdapter.access$600(ConversationAdapter.this, val$view, val$position))
        {
            videoviewinterface.seekTo(0);
            if (val$position != ConversationAdapter.access$800(ConversationAdapter.this))
            {
                videoviewinterface.start();
            }
        }
    }

    ace()
    {
        this$0 = final_conversationadapter;
        val$view = sdkvideoview;
        val$position = I.this;
        super();
    }
}
