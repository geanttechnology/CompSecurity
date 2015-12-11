// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import co.vine.android.api.VineParsers;
import com.edisonwang.android.slog.SLog;
import java.io.IOException;

// Referenced classes of package co.vine.android.service:
//            RealTimeChatService

class this._cls0
    implements com.codebutler.android_websockets.er
{

    final RealTimeChatService this$0;

    public void onConnect()
    {
        SLog.dWithTag("RTCService", "Connected - now ready to subscribe to conversations.");
        RealTimeChatService.access$000(RealTimeChatService.this);
        RealTimeChatService.access$100(RealTimeChatService.this, 1, null);
    }

    public void onDisconnect(int i, String s)
    {
        SLog.dWithTag("RTCService", String.format("Disconnected with code=%d, reason=%s, delay=%dms", new Object[] {
            Integer.valueOf(i), s, Long.valueOf(RealTimeChatService.access$200(RealTimeChatService.this))
        }));
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        bundle.putString("reason", s);
        RealTimeChatService.access$100(RealTimeChatService.this, 5, bundle);
    }

    public void onError(Exception exception)
    {
        SLog.dWithTag("RTCService", (new StringBuilder()).append("Error: ").append(exception.getMessage()).toString());
    }

    public void onMessage(String s)
    {
        SLog.dWithTag("RTCService", String.format("Got string message: %s", new Object[] {
            s
        }));
        try
        {
            s = VineParsers.parseRTCEvent(VineParsers.createParser(s));
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("data", s);
            RealTimeChatService.access$100(RealTimeChatService.this, 9, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SLog.e("Failed to parse message.", s);
        }
    }

    public void onMessage(byte abyte0[])
    {
    }

    ent.Listener()
    {
        this$0 = RealTimeChatService.this;
        super();
    }
}
