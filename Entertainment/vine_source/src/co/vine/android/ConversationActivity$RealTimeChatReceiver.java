// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package co.vine.android:
//            ConversationActivity, VineWebSocketClient

private class <init> extends BroadcastReceiver
{

    final ConversationActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        if ("co.vine.android.service.mergeSelfNewMessage".equals(intent.getAction()))
        {
            long l = intent.getLongExtra("message_id", 0L);
            long l1 = intent.getLongExtra("conversation_id", 0L);
            if (l > 0L && l1 > 0L && ConversationActivity.access$200(ConversationActivity.this) != null)
            {
                ConversationActivity.access$200(ConversationActivity.this).alertNewPrivateMessage(l1, l);
            }
        }
    }

    private ()
    {
        this$0 = ConversationActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
