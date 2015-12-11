// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatViewManager

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (BoldChatSession.access$100(_fld0) != null)
        {
            BoldChatSession.access$100(_fld0).chatSessionStarted();
        }
        if (BoldChatSession.access$500(_fld0).getMessageInputField() != null)
        {
            BoldChatSession.access$500(_fld0).getMessageInputField().setHint(BoldChatSession.access$600(_fld0, "api#chat#send_message"));
        }
        if (BoldChatSession.access$500(_fld0).getEndChatMenuItem() != null)
        {
            BoldChatSession.access$500(_fld0).getEndChatMenuItem().setTitle(BoldChatSession.access$600(_fld0, "api#chat#end"));
        }
        if (BoldChatSession.access$500(_fld0).getEndButton() != null)
        {
            BoldChatSession.access$500(_fld0).getEndButton().setText(BoldChatSession.access$600(_fld0, "api#chat#end"));
        }
    }

    ner()
    {
        this$1 = this._cls1.this;
        super();
    }
}
