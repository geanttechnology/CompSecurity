// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.sdk.utils.OnPreChatFormSubmitListener;
import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.Form;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatState, BoldChatViewManager

class val.chat
    implements val.chat
{

    final PreChatFormSubmit this$1;
    final Chat val$chat;

    public void onFormSubmit(Form form)
    {
        BoldChatSession.access$2500(_fld0, BoldChatSession.access$600(_fld0, "api#chat#waiting_for_operator"));
        BoldChatSession.access$500(_fld0).setState(BoldChatState.PreChatSending);
        val$chat.submitPreChat(form, BoldChatSession.access$1700(_fld0));
        if (BoldChatSession.access$2600(_fld0) != null)
        {
            BoldChatSession.access$2600(_fld0).onPreChatFormSubmit();
        }
    }

    ()
    {
        this$1 = final_;
        val$chat = Chat.this;
        super();
    }
}
