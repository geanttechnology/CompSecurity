// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.view.View;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatHistory

private class <init>
    implements android.view.ner
{

    final BoldChatSession this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            BoldChatSession.access$1200(BoldChatSession.this).scrollToBottom();
        }
    }

    private ()
    {
        this$0 = BoldChatSession.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
