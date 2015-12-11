// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import org.java_websocket.WebSocketImpl;

// Referenced classes of package org.java_websocket.client:
//            WebSocketClient

private class <init>
    implements Runnable
{

    final WebSocketClient this$0;

    public void run()
    {
        Thread.currentThread().setName("WebsocketWriteThread");
        try
        {
            for (; !Thread.interrupted(); WebSocketClient.access$200(WebSocketClient.this).flush())
            {
                ByteBuffer bytebuffer = (ByteBuffer)WebSocketClient.access$100(WebSocketClient.this).outQueue.take();
                WebSocketClient.access$200(WebSocketClient.this).write(bytebuffer.array(), 0, bytebuffer.limit());
            }

        }
        catch (IOException ioexception)
        {
            WebSocketClient.access$100(WebSocketClient.this).eot();
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    private ()
    {
        this$0 = WebSocketClient.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
