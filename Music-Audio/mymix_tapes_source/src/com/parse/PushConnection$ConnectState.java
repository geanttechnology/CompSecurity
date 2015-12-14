// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PushConnection, PushRouter, Parse

public class lastDelay extends lastDelay
{

    private long lastDelay;
    final PushConnection this$0;

    private long nextDelay()
    {
        return Math.min(Math.max(15000L, (long)((double)lastDelay * (1.5D + Math.random() * 0.5D))), 0x493e0L);
    }

    private boolean sendHandshake(Socket socket)
    {
        boolean flag = false;
        Object obj = PushRouter.getPushRequestJSONAsync();
        try
        {
            ((Task) (obj)).waitForCompletion();
        }
        catch (InterruptedException interruptedexception)
        {
            Parse.logE("com.parse.PushConnection", "Unexpected interruption when waiting for handshake to be sent", interruptedexception);
        }
        obj = (JSONObject)((Task) (obj)).getResult();
        if (obj != null)
        {
            flag = PushConnection.access$700(socket, ((JSONObject) (obj)).toString());
        }
        return flag;
    }

    public NAsync runState()
    {
        Object obj1;
        Socket socket;
        boolean flag1;
        flag1 = false;
        socket = new Socket();
        obj1 = null;
        InetSocketAddress inetsocketaddress = new InetSocketAddress(PushConnection.access$400(PushConnection.this), PushConnection.access$500(PushConnection.this));
        Object obj;
        boolean flag;
        flag = flag1;
        obj = obj1;
        if (inetsocketaddress == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        socket.connect(inetsocketaddress, 40000);
        socket.setKeepAlive(true);
        socket.setTcpNoDelay(true);
        flag = sendHandshake(socket);
        obj = obj1;
_L1:
        if (obj != null)
        {
            Parse.logI("com.parse.PushConnection", (new StringBuilder()).append("Failed to connect to push server due to ").append(obj).toString());
        }
        if (!flag)
        {
            PushConnection.access$600(socket);
            return new e(PushConnection.this, nextDelay());
        } else
        {
            return new e(PushConnection.this, socket);
        }
        obj;
        flag = flag1;
          goto _L1
        obj;
        flag = flag1;
          goto _L1
    }

    public e(long l)
    {
        this$0 = PushConnection.this;
        super(PushConnection.this);
        lastDelay = l;
    }
}
