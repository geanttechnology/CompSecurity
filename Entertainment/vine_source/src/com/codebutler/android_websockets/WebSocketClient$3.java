// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codebutler.android_websockets;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

// Referenced classes of package com.codebutler.android_websockets:
//            WebSocketClient

class val.frame
    implements Runnable
{

    final WebSocketClient this$0;
    final byte val$frame[];

    public void run()
    {
        Object obj = WebSocketClient.access$1200(WebSocketClient.this);
        obj;
        JVM INSTR monitorenter ;
        if (WebSocketClient.access$400(WebSocketClient.this) == null)
        {
            throw new IOException((new StringBuilder()).append("Socket not connected while trying to write: ").append(Arrays.toString(val$frame)).toString());
        }
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            WebSocketClient.access$1000(WebSocketClient.this).onError(((Exception) (obj)));
        }
        return;
        OutputStream outputstream = WebSocketClient.access$400(WebSocketClient.this).getOutputStream();
        outputstream.write(val$frame);
        outputstream.flush();
        obj;
        JVM INSTR monitorexit ;
    }

    stener()
    {
        this$0 = final_websocketclient;
        val$frame = _5B_B.this;
        super();
    }
}
