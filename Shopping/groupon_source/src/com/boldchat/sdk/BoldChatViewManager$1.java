// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;


// Referenced classes of package com.boldchat.sdk:
//            BoldChatViewManager, BoldChatFormView, BoldChatState

class val.form
    implements Runnable
{

    final BoldChatViewManager this$0;
    final BoldChatFormView val$form;
    final BoldChatState val$newState;

    public void run()
    {
        BoldChatViewManager.access$000(BoldChatViewManager.this, val$newState, val$form);
    }

    ()
    {
        this$0 = final_boldchatviewmanager;
        val$newState = boldchatstate;
        val$form = BoldChatFormView.this;
        super();
    }
}
