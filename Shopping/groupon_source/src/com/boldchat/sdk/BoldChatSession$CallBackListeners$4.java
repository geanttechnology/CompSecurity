// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.Form;
import com.boldchat.visitor.api.UnavailableForm;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatState, BoldChatViewManager

class val.unavailableForm
    implements val.unavailableForm
{

    final _cls1 this$1;
    final UnavailableForm val$unavailableForm;

    public void onFormSubmit(Form form)
    {
        BoldChatSession.access$500(_fld0).setState(BoldChatState.UnavailableChatSending);
        BoldChatSession.access$400().submitUnavailableEmail(val$unavailableForm);
        BoldChatSession.access$2900(_fld0, BoldChatState.Finished, BoldChatSession.access$600(_fld0, "api#unavailable#emailed"), BoldChatSession.access$600(_fld0, "api#chat#close"), null, new BoldChatFormView.SubmitListener() {

            final BoldChatSession.CallBackListeners._cls4 this$2;

            public void onFormSubmit(Form form1)
            {
                closeChat();
            }

            
            {
                this$2 = BoldChatSession.CallBackListeners._cls4.this;
                super();
            }
        });
    }

    _cls1.this._cls2()
    {
        this$1 = final__pcls2;
        val$unavailableForm = UnavailableForm.this;
        super();
    }
}
