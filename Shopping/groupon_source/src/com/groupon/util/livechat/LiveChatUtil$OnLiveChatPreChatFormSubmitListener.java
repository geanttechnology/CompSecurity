// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.livechat;

import com.boldchat.sdk.utils.OnPreChatFormSubmitListener;
import com.groupon.Channel;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.util.livechat:
//            LiveChatUtil

private class <init>
    implements OnPreChatFormSubmitListener
{

    final LiveChatUtil this$0;

    public void onPreChatFormSubmit()
    {
        LiveChatUtil.access$100(LiveChatUtil.this).logClick("", "start_chat_click", channel.toString(), new LiveChatExtraInfo(pageId, dealId), Logger.NULL_NST_FIELD);
    }

    private ()
    {
        this$0 = LiveChatUtil.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
