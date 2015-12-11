// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.player.SdkVideoView;
import co.vine.android.player.VideoViewInterface;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

class val.view
    implements co.vine.android.player.rrorListener
{

    final ConversationAdapter this$0;
    final SdkVideoView val$view;

    public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
    {
        SLog.d("Got error, try recycling it more aggressively: {}, {}", Integer.valueOf(i), Integer.valueOf(j));
        ConversationAdapter.access$700(ConversationAdapter.this, val$view);
        val$view.retryOpenVideo(false);
        return true;
    }

    ace()
    {
        this$0 = final_conversationadapter;
        val$view = SdkVideoView.this;
        super();
    }
}
