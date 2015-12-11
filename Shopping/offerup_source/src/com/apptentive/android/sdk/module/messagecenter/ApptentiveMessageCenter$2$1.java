// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter;

import com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter:
//            MessageManager, ApptentiveMessageCenter

class this._cls0
    implements Runnable
{

    final llToBottom this$0;

    public void run()
    {
        java.util.List list = MessageManager.getMessages(context);
        ApptentiveMessageCenter.messageCenterView.setMessages(list);
        ApptentiveMessageCenter.scrollToBottom();
    }

    Q()
    {
        this$0 = this._cls0.this;
        super();
    }
}
