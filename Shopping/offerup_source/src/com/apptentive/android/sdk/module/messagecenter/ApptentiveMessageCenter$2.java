// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter;

import android.content.Context;
import com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter:
//            ApptentiveMessageCenter

final class val.context
    implements esListener
{

    final Context val$context;

    public final void onMessagesUpdated()
    {
        class _cls1
            implements Runnable
        {

            final ApptentiveMessageCenter._cls2 this$0;

            public void run()
            {
                java.util.List list = MessageManager.getMessages(context);
                ApptentiveMessageCenter.messageCenterView.setMessages(list);
                ApptentiveMessageCenter.scrollToBottom();
            }

            _cls1()
            {
                this$0 = ApptentiveMessageCenter._cls2.this;
                super();
            }
        }

        ApptentiveMessageCenter.messageCenterView.post(new _cls1());
    }

    _cls1()
    {
        val$context = context1;
        super();
    }
}
