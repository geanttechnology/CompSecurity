// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.livechat.LiveChatUtil;

// Referenced classes of package com.groupon.view:
//            LiveChatView

private class <init>
    implements android.view.ner
{

    final LiveChatView this$0;

    public void onClick(View view)
    {
        getContext().startActivity(LiveChatView.access$800(LiveChatView.this).newLiveChatIntent());
        LiveChatView.access$1000(LiveChatView.this).logClick("", "live_chat_click", LiveChatView.access$900(LiveChatView.this).channel.toString(), new LiveChatExtraInfo(LiveChatView.access$900(LiveChatView.this).pageId, LiveChatView.access$900(LiveChatView.this).dealId), Logger.NULL_NST_FIELD);
    }

    private ()
    {
        this$0 = LiveChatView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
