// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.TextView;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

class val.position
    implements co.vine.android.player.reparedListener
{

    final ConversationAdapter this$0;
    final nversationViewHolder val$holder;
    final int val$position;

    public void onPrepared(VideoViewInterface videoviewinterface)
    {
        if (!val$holder.isCurrentUser) goto _L2; else goto _L1
_L1:
        videoviewinterface.start();
        onLoadFinish(val$holder);
_L4:
        val$holder.nibs.bringToFront();
        val$holder.postNibs.bringToFront();
        return;
_L2:
        co.vine.android.util.fo fo = ConversationAdapter.access$500(ConversationAdapter.this, videoviewinterface, val$position);
        if (fo == null)
        {
            CrashUtil.log("Invalid state onPrepared.");
        } else
        if (!fo.isExpired())
        {
            if (fo.hasLoopLimit() && !fo.isExpired())
            {
                videoviewinterface.seekTo(fo.getSeekTime());
                val$holder.vanishTimerText.setVisibility(0);
                val$holder.vanishTimerText.setText(fo.getLoopsLeftForDisplay());
            }
            if (!fo.isExpired())
            {
                videoviewinterface.start();
                onLoadFinish(val$holder);
            }
        } else
        {
            ConversationAdapter.access$600(ConversationAdapter.this, videoviewinterface, val$position);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    nversationViewHolder()
    {
        this$0 = final_conversationadapter;
        val$holder = nversationviewholder;
        val$position = I.this;
        super();
    }
}
