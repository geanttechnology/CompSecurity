// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.parse:
//            PushConnection, PushRouter, Parse

private class stopped extends Thread
{

    private Socket socket;
    private boolean stopped;
    final PushConnection this$0;

    private void runReaderLoop(BufferedReader bufferedreader)
    {
_L3:
        Object obj = null;
        String s = bufferedreader.readLine();
        obj = s;
        PushConnection.access$1100(PushConnection.this).set(SystemClock.elapsedRealtime());
        obj = s;
_L4:
        Object obj1;
        if (obj == null)
        {
            return;
        }
        obj1 = new JSONTokener(((String) (obj)));
        s = null;
        obj1 = new JSONObject(((JSONTokener) (obj1)));
        obj = obj1;
_L2:
        if (obj != null)
        {
            PushRouter.handlePpnsPushAsync(((JSONObject) (obj)));
        }
        this;
        JVM INSTR monitorenter ;
        if (!stopped)
        {
            break; /* Loop/switch isn't completed */
        }
        this;
        JVM INSTR monitorexit ;
        return;
        bufferedreader;
        this;
        JVM INSTR monitorexit ;
        throw bufferedreader;
        JSONException jsonexception;
        jsonexception;
        Parse.logE("com.parse.PushConnection", (new StringBuilder()).append("bad json: ").append(((String) (obj))).toString(), jsonexception);
        obj = s;
        if (true) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
          goto _L3
        IOException ioexception;
        ioexception;
          goto _L4
    }

    public void run()
    {
        BufferedReader bufferedreader = null;
        BufferedReader bufferedreader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedreader = bufferedreader1;
_L2:
        if (bufferedreader != null)
        {
            runReaderLoop(bufferedreader);
            Exception exception;
            try
            {
                bufferedreader.close();
            }
            catch (IOException ioexception) { }
        }
        this;
        JVM INSTR monitorenter ;
        if (!stopped)
        {
            PushConnection.access$300(PushConnection.this).alEvent(ROR);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        IOException ioexception1;
        ioexception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void stopReading()
    {
        this;
        JVM INSTR monitorenter ;
        stopped = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (Socket socket1)
    {
        this$0 = PushConnection.this;
        super();
        socket = socket1;
        stopped = false;
    }
}
