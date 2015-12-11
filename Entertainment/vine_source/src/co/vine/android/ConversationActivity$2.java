// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Handler;
import co.vine.android.api.VineParsers;
import co.vine.android.client.AppSessionListener;
import com.edisonwang.android.slog.SLog;
import java.io.IOException;

// Referenced classes of package co.vine.android:
//            ConversationActivity

class this._cls0
    implements com.codebutler.android_websockets.r
{

    final ConversationActivity this$0;

    public void onConnect()
    {
        SLog.dWithTag("ConvActivity;RTC", "Websocket connected");
        ConversationActivity.access$500(ConversationActivity.this).removeCallbacks(ConversationActivity.access$400(ConversationActivity.this));
        mAppSessionListener.onWebSocketConnectComplete();
    }

    public void onDisconnect(int i, String s)
    {
        SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Websocket disconnected, reason=").append(s).toString());
        mAppSessionListener.onWebSocketDisconnected();
    }

    public void onError(Exception exception)
    {
        SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Websocket error=").append(exception.getMessage()).toString());
        mAppSessionListener.onWebSocketError();
    }

    public void onMessage(String s)
    {
        SLog.dWithTag("ConvActivity;RTC", String.format("Got string message: %s", new Object[] {
            s
        }));
        try
        {
            s = VineParsers.parseRTCEvent(VineParsers.createParser(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SLog.e("Failed to parse message.", s);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        mAppSessionListener.onReceiveRTCMessage(s);
    }

    public void onMessage(byte abyte0[])
    {
    }

    er()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
