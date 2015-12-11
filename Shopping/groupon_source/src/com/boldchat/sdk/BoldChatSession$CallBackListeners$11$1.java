// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.Form;
import com.boldchat.visitor.api.UnavailableForm;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatState

class this._cls2
    implements this._cls2
{

    final this._cls2 this$2;

    public void onFormSubmit(Form form)
    {
        closeChat();
    }

    l.unavailableForm()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/boldchat/sdk/BoldChatSession$CallBackListeners$11

/* anonymous class */
    class BoldChatSession.CallBackListeners._cls11
        implements BoldChatFormView.SubmitListener
    {

        final BoldChatSession.CallBackListeners this$1;
        final UnavailableForm val$unavailableForm;

        public void onFormSubmit(Form form)
        {
            BoldChatSession.access$400().submitUnavailableEmail(unavailableForm);
            BoldChatSession.access$2900(this$0, BoldChatState.Finished, BoldChatSession.access$600(this$0, "api#unavailable#emailed"), BoldChatSession.access$600(this$0, "api#chat#close"), null, new BoldChatSession.CallBackListeners._cls11._cls1());
        }

            
            {
                this$1 = final_callbacklisteners;
                unavailableForm = UnavailableForm.this;
                super();
            }
    }

}
