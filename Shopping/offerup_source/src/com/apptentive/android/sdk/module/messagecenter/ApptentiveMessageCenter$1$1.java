// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter;

import com.apptentive.android.sdk.model.TextMessage;
import com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter:
//            ApptentiveMessageCenter

class val.message
    implements Runnable
{

    final val.message this$0;
    final TextMessage val$message;

    public void run()
    {
        ApptentiveMessageCenter.messageCenterView.addMessage(val$message);
    }

    Q()
    {
        this$0 = final_q;
        val$message = TextMessage.this;
        super();
    }
}
