// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Handler;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            ConversationActivity, VineWebSocketClient

class this._cls0
    implements Runnable
{

    final ConversationActivity this$0;

    public void run()
    {
        if (ConversationActivity.access$200(ConversationActivity.this) == null)
        {
            ConversationActivity.access$700(ConversationActivity.this);
        }
        Object obj = ConversationActivity.access$200(ConversationActivity.this);
        if (obj != null && !((VineWebSocketClient) (obj)).isConnecting() && !((VineWebSocketClient) (obj)).isConnected())
        {
            ((VineWebSocketClient) (obj)).connect();
            obj = ConversationActivity.this;
            long l;
            if (ConversationActivity.access$800(ConversationActivity.this) < 16000L)
            {
                l = ConversationActivity.access$800(ConversationActivity.this) * 2L;
            } else
            {
                l = ConversationActivity.access$800(ConversationActivity.this);
            }
            ConversationActivity.access$802(((ConversationActivity) (obj)), l);
            ConversationActivity.access$500(ConversationActivity.this).postDelayed(ConversationActivity.access$400(ConversationActivity.this), ConversationActivity.access$800(ConversationActivity.this));
            SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Posted reconnect with delay=").append(ConversationActivity.access$800(ConversationActivity.this)).append("ms").toString());
        }
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
