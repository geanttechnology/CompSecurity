// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.Form;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatState, BoldChatViewManager

class this._cls1
    implements this._cls1
{

    final this._cls1 this$1;

    public void onFormSubmit(Form form)
    {
        BoldChatSession.access$500(_fld0).setState(BoldChatState.PostChatSending);
        BoldChatSession.access$400().submitPostChat(form, this._cls1.this);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
