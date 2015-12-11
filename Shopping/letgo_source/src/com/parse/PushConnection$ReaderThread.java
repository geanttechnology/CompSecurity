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
//            PushConnection, PushRouter, PLog, ParseIOUtils

private class stopped extends Thread
{

    private final Socket socket;
    private boolean stopped;
    final PushConnection this$0;

    private void runReaderLoop(BufferedReader bufferedreader)
    {
_L5:
        Object obj = bufferedreader.readLine();
        Object obj1;
        JSONException jsonexception;
        try
        {
            PushConnection.access$1100(PushConnection.this).set(SystemClock.elapsedRealtime());
        }
        catch (IOException ioexception) { }
        if (obj == null)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        obj = null;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_18;
_L1:
        obj1 = new JSONTokener(((String) (obj)));
        obj1 = new JSONObject(((JSONTokener) (obj1)));
        obj = obj1;
_L4:
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
        jsonexception;
        PLog.e("com.parse.PushConnection", (new StringBuilder()).append("bad json: ").append(((String) (obj))).toString(), jsonexception);
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
          goto _L5
    }

    public void run()
    {
        Object obj2;
        Object obj3;
        obj3 = null;
        obj2 = null;
        Object obj = socket.getInputStream();
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj1 = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj))));
        runReaderLoop(((BufferedReader) (obj1)));
_L9:
        ParseIOUtils.closeQuietly(((java.io.Closeable) (obj1)));
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
_L4:
        this;
        JVM INSTR monitorenter ;
        if (!stopped)
        {
            PushConnection.access$300(PushConnection.this).alEvent(ROR);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        obj = null;
        obj1 = obj2;
_L7:
        ParseIOUtils.closeQuietly(((java.io.Closeable) (obj1)));
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        obj = null;
        obj2 = obj3;
_L6:
        ParseIOUtils.closeQuietly(((java.io.Closeable) (obj2)));
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw obj1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        obj1;
        obj2 = obj3;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        obj2 = obj1;
        obj1 = exception1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        obj1 = obj2;
          goto _L7
        IOException ioexception;
        ioexception;
          goto _L7
_L2:
        obj1 = null;
        if (true) goto _L9; else goto _L8
_L8:
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
