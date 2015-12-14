// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import bm;
import ev;
import ex;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            h

final class h extends Thread
{

    private String a;
    private int b;
    private  c;
    private  d;
    private  e;
    private boolean f;
    private Vector g;
    private ex h;
    private boolean i;
    private h j;

    static boolean a(h h1)
    {
        return h1.f;
    }

    public final  a(f f1)
    {
        Object obj;
        if (f)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = .a;
        Object obj1 = com.nuance.nmsp.client.sdk.oem.h.a(j);
        obj1;
        JVM INSTR monitorenter ;
        if (g != null) goto _L2; else goto _L1
_L1:
        f1 = .b;
        obj = "SocketReadThread: queue is null!!";
_L3:
        if (com.nuance.nmsp.client.sdk.oem.h.a().b())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().b("addNewJob() notifying");
        }
        com.nuance.nmsp.client.sdk.oem.h.a(j).notify();
        obj1;
        JVM INSTR monitorexit ;
        if (com.nuance.nmsp.client.sdk.oem.h.a().e() && obj != null)
        {
            com.nuance.nmsp.client.sdk.oem.h.a().e(obj);
        }
        return f1;
_L2:
        g.addElement(f1);
        f1 = ((g) (obj));
        obj = null;
          goto _L3
        f1;
        throw f1;
        if (com.nuance.nmsp.client.sdk.oem.h.a().e())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().e("SocketReadThread is already stopping!");
        }
        return .b;
    }

    public final void a()
    {
        synchronized (com.nuance.nmsp.client.sdk.oem.h.a(j))
        {
            f = true;
            g.removeAllElements();
            g = null;
            com.nuance.nmsp.client.sdk.oem.h.a(j).notify();
        }
    }

    public final void b()
    {
        String s = null;
        Object obj = com.nuance.nmsp.client.sdk.oem.h.a(j);
        obj;
        JVM INSTR monitorenter ;
        if (g != null) goto _L2; else goto _L1
_L1:
        s = "SocketReadThread.cleanPendingJobs(): queue is null!!";
_L4:
        obj;
        JVM INSTR monitorexit ;
        if (com.nuance.nmsp.client.sdk.oem.h.a().e() && s != null)
        {
            com.nuance.nmsp.client.sdk.oem.h.a().e(s);
        }
        return;
_L2:
        g.removeAllElements();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void run()
    {
        if (com.nuance.nmsp.client.sdk.oem.h.a().b())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().b((new StringBuilder("Open Socket connection on host:- [")).append(a).append("] and port[").append(b).append("]").toString());
        }
        Object obj;
        if (!i)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        obj = ev.a(a, b, h);
_L1:
        if (!((Socket) (obj)).isConnected())
        {
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e("SocketReadThread NETWORK_ERROR. !sock.isConnected()");
            }
            com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
                com.nuance.nmsp.client.sdk.oem.h.b(), c, .b, null, null
            });
            return;
        }
        break MISSING_BLOCK_LABEL_532;
        try
        {
            obj = new Socket(a, b);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((UnknownHostException) (obj)).getMessage()).append("]").toString());
            }
            com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
                com.nuance.nmsp.client.sdk.oem.h.b(), c, .b, null, null
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((IOException) (obj)).getMessage()).append("]").toString());
            }
            com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
                com.nuance.nmsp.client.sdk.oem.h.b(), c, .b, null, null
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((SecurityException) (obj)).getMessage()).append("]").toString());
            }
            com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
                com.nuance.nmsp.client.sdk.oem.h.b(), c, .b, null, null
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((Throwable) (obj)).getMessage()).append("]").toString());
            }
            com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
                com.nuance.nmsp.client.sdk.oem.h.b(), c, .b, null, null
            });
            return;
        }
          goto _L1
        Object obj1;
        Object obj2;
        try
        {
            if (i)
            {
                ((SSLSocket)obj).setUseClientMode(true);
            }
            ((Socket) (obj)).setTcpNoDelay(true);
            ((Socket) (obj)).setKeepAlive(true);
            ((Socket) (obj)).setSoLinger(true, 40);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("Set Socket Option Exception - [")).append(obj1.getClass().getName()).append("] Message - [").append(((Exception) (obj1)).getMessage()).append("]").toString());
            }
        }
        try
        {
            obj1 = ((Socket) (obj)).getInputStream();
            obj2 = ((Socket) (obj)).getOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            IOException ioexception1;
            Exception exception;
            g g1;
            try
            {
                ((Socket) (obj)).close();
            }
            catch (IOException ioexception) { }
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("Set Socket Option Exception - [")).append(obj1.getClass().getName()).append("] Message - [").append(((IOException) (obj1)).getMessage()).append("]").toString());
            }
            com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
                com.nuance.nmsp.client.sdk.oem.h.b(), c, .b, null, null
            });
            return;
        }
        obj = new <init>(((Socket) (obj)), d, ((InputStream) (obj1)), ((java.io.OutputStream) (obj2)), this);
        com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
            com.nuance.nmsp.client.sdk.oem.h.b(), c, .a, obj, null
        });
        if (f) goto _L3; else goto _L2
_L2:
        obj2 = com.nuance.nmsp.client.sdk.oem.h.a(j);
        obj2;
        JVM INSTR monitorenter ;
_L5:
        if (f || g == null || !g.isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        if (com.nuance.nmsp.client.sdk.oem.h.a().b())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().b("socket read thread. waiting syncObj in.");
        }
        com.nuance.nmsp.client.sdk.oem.h.a(j).wait();
_L7:
        if (com.nuance.nmsp.client.sdk.oem.h.a().b())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().b("socket read thread. waiting syncObj out.");
        }
        if (true) goto _L5; else goto _L4
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        exception;
        if (!com.nuance.nmsp.client.sdk.oem.h.a().e()) goto _L7; else goto _L6
_L6:
        com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("InterruptedException ie:")).append(exception).toString());
          goto _L7
_L4:
        if (!f && g != null)
        {
            break MISSING_BLOCK_LABEL_982;
        }
        obj2;
        JVM INSTR monitorexit ;
        return;
        g1 = (g)g.elementAt(0);
        g.removeElementAt(0);
        obj2;
        JVM INSTR monitorexit ;
        if (com.nuance.nmsp.client.sdk.oem.h.a().b())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().b("socket read thread. reading socket in.");
        }
        break MISSING_BLOCK_LABEL_1409;
_L10:
        int k;
        int l;
        for (; k >= g1.b; k += l)
        {
            break MISSING_BLOCK_LABEL_1109;
        }

        l = ((InputStream) (obj1)).read(g1.a, k + 0, g1.b - k);
        if (com.nuance.nmsp.client.sdk.oem.h.a().b())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().b((new StringBuilder("socket read thread. bytesRead:")).append(l).toString());
        }
        if (l >= 0)
        {
            break MISSING_BLOCK_LABEL_1415;
        }
        if (!f)
        {
            e = .b;
        }
        if (com.nuance.nmsp.client.sdk.oem.h.a().b())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().b("socket read thread. reading socket out.");
        }
_L9:
        if (e != .a)
        {
            break MISSING_BLOCK_LABEL_1301;
        }
        com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
            com.nuance.nmsp.client.sdk.oem.h.c(), g1.c, .a, obj, g1.a, new Integer(0), new Integer(g1.b), new Integer(g1.b), g1.d
        });
        break MISSING_BLOCK_LABEL_628;
        ioexception1;
        if (com.nuance.nmsp.client.sdk.oem.h.a().e())
        {
            com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("Socket Read/Available Expception - [")).append(ioexception1.getClass().getName()).append("] Message - [").append(ioexception1.getMessage()).append("]").toString());
        }
        e = .b;
        if (true) goto _L9; else goto _L8
_L8:
        try
        {
            com.nuance.nmsp.client.sdk.oem.h.a(j, new Object[] {
                com.nuance.nmsp.client.sdk.oem.h.c(), g1.c, .b, obj, g1.a, new Integer(0), new Integer(g1.b), new Integer(0), g1.d
            });
            j.a(obj);
            break MISSING_BLOCK_LABEL_628;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (com.nuance.nmsp.client.sdk.oem.h.a().e())
            {
                com.nuance.nmsp.client.sdk.oem.h.a().e((new StringBuilder("NetworkSystemJ2me.run() ")).append(obj.getClass().getName()).append(" ").append(((Exception) (obj)).getMessage()).toString());
                return;
            }
        }
_L3:
        return;
        k = 0;
          goto _L10
    }

    public (h h1, String s, int k,  ,  1)
    {
        j = h1;
        super();
        a = null;
        c = null;
        d = null;
        e = .a;
        f = false;
        g = null;
        h = null;
        i = false;
        a = s;
        b = k;
        c = ;
        d = 1;
        g = new Vector();
    }

    public g(h h1, String s, int k, ex ex,  ,  1)
    {
        j = h1;
        super();
        a = null;
        c = null;
        d = null;
        e = .a;
        f = false;
        g = null;
        h = null;
        i = false;
        a = s;
        b = k;
        c = ;
        d = 1;
        g = new Vector();
        i = true;
        h = ex;
    }
}
