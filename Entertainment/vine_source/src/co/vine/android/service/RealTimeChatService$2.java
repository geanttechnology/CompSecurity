// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Handler;
import com.codebutler.android_websockets.WebSocketClient;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            RealTimeChatService

class this._cls0
    implements Runnable
{

    final RealTimeChatService this$0;

    public void run()
    {
        if (RealTimeChatService.access$300(RealTimeChatService.this) != null && !RealTimeChatService.access$400(RealTimeChatService.this))
        {
            RealTimeChatService.access$300(RealTimeChatService.this).connect();
            RealTimeChatService realtimechatservice = RealTimeChatService.this;
            long l;
            if (RealTimeChatService.access$200(RealTimeChatService.this) < 16000L)
            {
                l = RealTimeChatService.access$200(RealTimeChatService.this) * 2L;
            } else
            {
                l = RealTimeChatService.access$200(RealTimeChatService.this);
            }
            RealTimeChatService.access$202(realtimechatservice, l);
            RealTimeChatService.access$600(RealTimeChatService.this).postDelayed(RealTimeChatService.access$500(RealTimeChatService.this), RealTimeChatService.access$200(RealTimeChatService.this));
            SLog.dWithTag("RTCService", (new StringBuilder()).append("Posted reconnect with delay=").append(RealTimeChatService.access$200(RealTimeChatService.this)).append("ms").toString());
        }
    }

    ent()
    {
        this$0 = RealTimeChatService.this;
        super();
    }
}
