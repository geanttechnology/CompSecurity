// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codebutler.android_websockets;

import android.util.Log;
import java.io.IOException;
import java.net.Socket;

// Referenced classes of package com.codebutler.android_websockets:
//            WebSocketClient

class this._cls0
    implements Runnable
{

    final WebSocketClient this$0;

    public void run()
    {
        try
        {
            WebSocketClient.access$400(WebSocketClient.this).close();
            Log.d("RTC", "WebSocket disconnected");
            WebSocketClient.access$402(WebSocketClient.this, null);
            return;
        }
        catch (IOException ioexception)
        {
            Log.d("WebSocketClient", "Error while disconnecting", ioexception);
            WebSocketClient.access$1000(WebSocketClient.this).onError(ioexception);
            return;
        }
    }

    stener()
    {
        this$0 = WebSocketClient.this;
        super();
    }
}
