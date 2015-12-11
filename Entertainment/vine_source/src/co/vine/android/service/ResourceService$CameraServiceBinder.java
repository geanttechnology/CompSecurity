// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            ResourceService

public class this._cls0 extends Handler
{

    final ResourceService this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            SLog.e((new StringBuilder()).append("Invalid request: ").append(message.what).toString());
            return;

        case 101: // 'e'
            break;
        }
        if (ResourceService.isConversationActive)
        {
            message = "co.vine.android.camera.request.conversation.state.on";
        } else
        {
            message = "co.vine.android.camera.request.conversation.state.off";
        }
        message = new Intent(message);
        message.putExtra("co.vine.android.camera.request.conversation.state.id", ResourceService.lastActiveconversationRowId);
        sendBroadcast(message, "co.vine.android.BROADCAST");
    }

    public A()
    {
        this$0 = ResourceService.this;
        super();
    }
}
