// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.text.style.ClickableSpan;
import android.view.View;
import com.boldchat.visitor.api.Chat;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatState, BoldChatViewManager

private class mUrl extends ClickableSpan
{

    private String mUrl;
    final BoldChatSession this$0;

    public void onClick(View view)
    {
        if ("#cancel_queue".equals(mUrl))
        {
            BoldChatSession.access$2200(BoldChatSession.this).Running();
            BoldChatSession.access$500(BoldChatSession.this).setState(BoldChatState.ChatEnding);
            if (BoldChatSession.access$400() != null)
            {
                BoldChatSession.access$400().getUnavailableForm(BoldChatSession.access$1700(BoldChatSession.this));
            }
        }
    }

    public (String s)
    {
        this$0 = BoldChatSession.this;
        super();
        mUrl = s;
    }
}
