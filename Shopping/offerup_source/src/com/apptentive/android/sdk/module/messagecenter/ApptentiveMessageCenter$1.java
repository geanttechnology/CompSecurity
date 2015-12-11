// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.FileMessage;
import com.apptentive.android.sdk.model.TextMessage;
import com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter:
//            ApptentiveMessageCenter, MessageManager

final class val.context
    implements com.apptentive.android.sdk.module.messagecenter.view.ssageListener
{

    final Context val$context;

    public final void onSendFileMessage(Uri uri)
    {
        final FileMessage message = new FileMessage();
        if (message.internalCreateStoredImage(val$context, uri.toString()))
        {
            message.setRead(true);
            message.setCustomData(ApptentiveMessageCenter.access$000());
            java.util.Map _tmp = ApptentiveMessageCenter.access$002(null);
            MessageManager.sendMessage(val$context, message);
            class _cls2
                implements Runnable
            {

                final ApptentiveMessageCenter._cls1 this$0;
                final FileMessage val$message;

                public void run()
                {
                    ApptentiveMessageCenter.messageCenterView.addMessage(message);
                }

            _cls2()
            {
                this$0 = ApptentiveMessageCenter._cls1.this;
                message = filemessage;
                super();
            }
            }

            ApptentiveMessageCenter.messageCenterView.post(new _cls2());
            ApptentiveMessageCenter.scrollToBottom();
            return;
        } else
        {
            Log.e("Unable to send file.", new Object[0]);
            Toast.makeText(ApptentiveMessageCenter.messageCenterView.getContext(), "Unable to send file.", 0).show();
            return;
        }
    }

    public final void onSendTextMessage(String s)
    {
        final TextMessage message = new TextMessage();
        message.setBody(s);
        message.setRead(true);
        message.setCustomData(ApptentiveMessageCenter.access$000());
        java.util.Map _tmp = ApptentiveMessageCenter.access$002(null);
        MessageManager.sendMessage(val$context, message);
        class _cls1
            implements Runnable
        {

            final ApptentiveMessageCenter._cls1 this$0;
            final TextMessage val$message;

            public void run()
            {
                ApptentiveMessageCenter.messageCenterView.addMessage(message);
            }

            _cls1()
            {
                this$0 = ApptentiveMessageCenter._cls1.this;
                message = textmessage;
                super();
            }
        }

        ApptentiveMessageCenter.messageCenterView.post(new _cls1());
        ApptentiveMessageCenter.scrollToBottom();
    }

    _cls1()
    {
        val$context = context1;
        super();
    }
}
