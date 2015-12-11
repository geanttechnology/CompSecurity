// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.util.livechat.LiveChatUtil;
import com.groupon.util.livechat.OnLiveChatSessionFinishListener;

// Referenced classes of package com.groupon.view:
//            LiveChatView

private class <init>
    implements OnLiveChatSessionFinishListener
{

    final LiveChatView this$0;

    public void onLiveChatSessionFinish()
    {
        LiveChatView.access$900(LiveChatView.this).setupLiveChatSessionWithoutUI(LiveChatView.access$1200(LiveChatView.this));
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
