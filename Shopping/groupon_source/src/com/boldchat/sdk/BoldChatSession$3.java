// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.Form;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatFormView, BoldChatViewManager, BoldChatState

class val.state
    implements Runnable
{

    final BoldChatSession this$0;
    final Form val$form;
    final BoldChatState val$state;
    final String val$submit;
    final String val$submitKey;
    final ubmitListener val$submitListener;
    final String val$title;
    final String val$titleKey;

    public void run()
    {
        boolean flag = true;
        if (BoldChatSession.access$200(BoldChatSession.this) != null)
        {
            if (BoldChatSession.access$200(BoldChatSession.this).onFormShow(val$form) && true)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            BoldChatFormView boldchatformview = new BoldChatFormView(val$title, val$titleKey, val$submit, val$submitKey, val$form, val$submitListener, BoldChatSession.access$300(BoldChatSession.this), BoldChatSession.access$400());
            BoldChatSession.access$500(BoldChatSession.this).setState(val$state, boldchatformview);
        } else
        if (val$submitListener != null)
        {
            BoldChatSession.access$500(BoldChatSession.this).setState(val$state);
            val$submitListener.onFormSubmit(val$form);
            return;
        }
    }

    ubmitListener()
    {
        this$0 = final_boldchatsession;
        val$form = form1;
        val$title = s;
        val$titleKey = s1;
        val$submit = s2;
        val$submitKey = s3;
        val$submitListener = ubmitlistener;
        val$state = BoldChatState.this;
        super();
    }
}
