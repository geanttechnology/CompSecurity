// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import bm;
import bn;
import bp;
import cz;
import d;
import ev;
import ex;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Vector;
import javax.net.ssl.SSLSocket;

public class h
    implements bn.b, bp
{
    static final class a
    {

        Socket a;
        bp.a b;
        InputStream c;
        OutputStream d;
        Object e;
        c f;

        public a(Socket socket, bp.a a1, InputStream inputstream, OutputStream outputstream, c c1)
        {
            c = null;
            d = null;
            e = null;
            f = null;
            a = socket;
            b = a1;
            e = null;
            c = inputstream;
            d = outputstream;
            f = c1;
        }
    }

    final class b
    {

        byte a[];
        int b;
        bp.e c;
        Object d;

        public b(byte abyte0[], int i, bp.e e1, Object obj)
        {
            a = abyte0;
            b = i;
            c = e1;
            d = obj;
        }
    }

    final class c extends Thread
    {

        private String a;
        private int b;
        private bp.d c;
        private bp.a d;
        private bp.c e;
        private boolean f;
        private Vector g;
        private ex h;
        private boolean i;
        private h j;

        static boolean a(c c1)
        {
            return c1.f;
        }

        public final bp.c a(b b1)
        {
            Object obj;
            if (f)
            {
                break MISSING_BLOCK_LABEL_106;
            }
            obj = bp.c.a;
            Object obj1 = h.a(j);
            obj1;
            JVM INSTR monitorenter ;
            if (g != null) goto _L2; else goto _L1
_L1:
            b1 = bp.c.b;
            obj = "SocketReadThread: queue is null!!";
_L3:
            if (h.a().b())
            {
                h.a().b("addNewJob() notifying");
            }
            h.a(j).notify();
            obj1;
            JVM INSTR monitorexit ;
            if (h.a().e() && obj != null)
            {
                h.a().e(obj);
            }
            return b1;
_L2:
            g.addElement(b1);
            b1 = ((b) (obj));
            obj = null;
              goto _L3
            b1;
            throw b1;
            if (h.a().e())
            {
                h.a().e("SocketReadThread is already stopping!");
            }
            return bp.c.b;
        }

        public final void a()
        {
            synchronized (h.a(j))
            {
                f = true;
                g.removeAllElements();
                g = null;
                h.a(j).notify();
            }
        }

        public final void b()
        {
            String s = null;
            Object obj = h.a(j);
            obj;
            JVM INSTR monitorenter ;
            if (g != null) goto _L2; else goto _L1
_L1:
            s = "SocketReadThread.cleanPendingJobs(): queue is null!!";
_L4:
            obj;
            JVM INSTR monitorexit ;
            if (h.a().e() && s != null)
            {
                h.a().e(s);
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
            if (h.a().b())
            {
                h.a().b((new StringBuilder("Open Socket connection on host:- [")).append(a).append("] and port[").append(b).append("]").toString());
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
                if (h.a().e())
                {
                    h.a().e("SocketReadThread NETWORK_ERROR. !sock.isConnected()");
                }
                h.a(j, new Object[] {
                    h.b(), c, bp.c.b, null, null
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
                if (h.a().e())
                {
                    h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((UnknownHostException) (obj)).getMessage()).append("]").toString());
                }
                h.a(j, new Object[] {
                    h.b(), c, bp.c.b, null, null
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (h.a().e())
                {
                    h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((IOException) (obj)).getMessage()).append("]").toString());
                }
                h.a(j, new Object[] {
                    h.b(), c, bp.c.b, null, null
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (h.a().e())
                {
                    h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((SecurityException) (obj)).getMessage()).append("]").toString());
                }
                h.a(j, new Object[] {
                    h.b(), c, bp.c.b, null, null
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (h.a().e())
                {
                    h.a().e((new StringBuilder("Open Streams Exception - [")).append(obj.getClass().getName()).append("] Message - [").append(((Throwable) (obj)).getMessage()).append("]").toString());
                }
                h.a(j, new Object[] {
                    h.b(), c, bp.c.b, null, null
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
                if (h.a().e())
                {
                    h.a().e((new StringBuilder("Set Socket Option Exception - [")).append(obj1.getClass().getName()).append("] Message - [").append(((Exception) (obj1)).getMessage()).append("]").toString());
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
                b b1;
                try
                {
                    ((Socket) (obj)).close();
                }
                catch (IOException ioexception) { }
                if (h.a().e())
                {
                    h.a().e((new StringBuilder("Set Socket Option Exception - [")).append(obj1.getClass().getName()).append("] Message - [").append(((IOException) (obj1)).getMessage()).append("]").toString());
                }
                h.a(j, new Object[] {
                    h.b(), c, bp.c.b, null, null
                });
                return;
            }
            obj = new a(((Socket) (obj)), d, ((InputStream) (obj1)), ((OutputStream) (obj2)), this);
            h.a(j, new Object[] {
                h.b(), c, bp.c.a, obj, null
            });
            if (f) goto _L3; else goto _L2
_L2:
            obj2 = h.a(j);
            obj2;
            JVM INSTR monitorenter ;
_L5:
            if (f || g == null || !g.isEmpty())
            {
                break; /* Loop/switch isn't completed */
            }
            if (h.a().b())
            {
                h.a().b("socket read thread. waiting syncObj in.");
            }
            h.a(j).wait();
_L7:
            if (h.a().b())
            {
                h.a().b("socket read thread. waiting syncObj out.");
            }
            if (true) goto _L5; else goto _L4
            obj;
            obj2;
            JVM INSTR monitorexit ;
            throw obj;
            exception;
            if (!h.a().e()) goto _L7; else goto _L6
_L6:
            h.a().e((new StringBuilder("InterruptedException ie:")).append(exception).toString());
              goto _L7
_L4:
            if (!f && g != null)
            {
                break MISSING_BLOCK_LABEL_982;
            }
            obj2;
            JVM INSTR monitorexit ;
            return;
            b1 = (b)g.elementAt(0);
            g.removeElementAt(0);
            obj2;
            JVM INSTR monitorexit ;
            if (h.a().b())
            {
                h.a().b("socket read thread. reading socket in.");
            }
            break MISSING_BLOCK_LABEL_1409;
_L10:
            int k;
            int l;
            for (; k >= b1.b; k += l)
            {
                break MISSING_BLOCK_LABEL_1109;
            }

            l = ((InputStream) (obj1)).read(b1.a, k + 0, b1.b - k);
            if (h.a().b())
            {
                h.a().b((new StringBuilder("socket read thread. bytesRead:")).append(l).toString());
            }
            if (l >= 0)
            {
                break MISSING_BLOCK_LABEL_1415;
            }
            if (!f)
            {
                e = bp.c.b;
            }
            if (h.a().b())
            {
                h.a().b("socket read thread. reading socket out.");
            }
_L9:
            if (e != bp.c.a)
            {
                break MISSING_BLOCK_LABEL_1301;
            }
            h.a(j, new Object[] {
                h.c(), b1.c, bp.c.a, obj, b1.a, new Integer(0), new Integer(b1.b), new Integer(b1.b), b1.d
            });
            break MISSING_BLOCK_LABEL_628;
            ioexception1;
            if (h.a().e())
            {
                h.a().e((new StringBuilder("Socket Read/Available Expception - [")).append(ioexception1.getClass().getName()).append("] Message - [").append(ioexception1.getMessage()).append("]").toString());
            }
            e = bp.c.b;
            if (true) goto _L9; else goto _L8
_L8:
            try
            {
                h.a(j, new Object[] {
                    h.c(), b1.c, bp.c.b, obj, b1.a, new Integer(0), new Integer(b1.b), new Integer(0), b1.d
                });
                j.a(obj);
                break MISSING_BLOCK_LABEL_628;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (h.a().e())
                {
                    h.a().e((new StringBuilder("NetworkSystemJ2me.run() ")).append(obj.getClass().getName()).append(" ").append(((Exception) (obj)).getMessage()).toString());
                    return;
                }
            }
_L3:
            return;
            k = 0;
              goto _L10
        }

        public c(String s, int k, bp.d d1, bp.a a1)
        {
            j = h.this;
            super();
            a = null;
            c = null;
            d = null;
            e = bp.c.a;
            f = false;
            g = null;
            h = null;
            i = false;
            a = s;
            b = k;
            c = d1;
            d = a1;
            g = new Vector();
        }

        public c(String s, int k, ex ex1, bp.d d1, bp.a a1)
        {
            j = h.this;
            super();
            a = null;
            c = null;
            d = null;
            e = bp.c.a;
            f = false;
            g = null;
            h = null;
            i = false;
            a = s;
            b = k;
            c = d1;
            d = a1;
            g = new Vector();
            i = true;
            h = ex1;
        }
    }


    private static final bm a = d.a(com/nuance/nmsp/client/sdk/oem/h);
    private static final Integer c = new Integer(0);
    private static final Integer d = new Integer(1);
    private static final Integer e = new Integer(2);
    private static final Integer f = new Integer(3);
    private bn b;
    private Object g;

    public h(bn bn1)
    {
        b = null;
        g = new Object();
        b = bn1;
    }

    static bm a()
    {
        return a;
    }

    static Object a(h h1)
    {
        return h1.g;
    }

    static void a(h h1, Object aobj[])
    {
        h1.a(aobj);
    }

    private void a(Object aobj[])
    {
        bn bn1 = b;
        Object obj = b.b();
        b.a();
        bn1.a(((Object) (aobj)), this, obj);
    }

    static Integer b()
    {
        return c;
    }

    static Integer c()
    {
        return e;
    }

    public final bp.c a(Object obj, bp.b b1, byte abyte0[], int i, bp.e e1, Object obj1)
    {
        if (b1 != bp.b.a)
        {
            if (a.e())
            {
                a.e("Blackberry NetworkSystem only supports NETWORK_READ_FULL");
            }
            return bp.c.b;
        }
        obj = (a)obj;
        if (((a) (obj)).f != null)
        {
            if (!c.a(((a) (obj)).f))
            {
                b1 = new b(abyte0, i, e1, obj1);
                return ((a) (obj)).f.a(b1);
            }
            if (a.e())
            {
                a.e("socket read thread is stopping");
            }
            return bp.c.b;
        }
        if (a.b())
        {
            a.b("SOCKET READ ERROR: socket read thread is null");
        }
        return bp.c.b;
    }

    public final bp.c a(Object obj, byte abyte0[], int i, bp.f f1, Object obj1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("socketWrite(bufferLen:")).append(i).append(") start").toString());
        }
        Object obj2 = (a)obj;
        if (((a) (obj2)).a == null || ((a) (obj2)).d == null)
        {
            return bp.c.b;
        }
        obj2 = ((a) (obj2)).d;
        try
        {
            ((OutputStream) (obj2)).write(abyte0, 0, i);
            ((OutputStream) (obj2)).flush();
        }
        catch (Exception exception)
        {
            if (a.e())
            {
                a.e((new StringBuilder("Socket Write Exception - [")).append(exception.getClass().getName()).append("] Message - [").append(exception.getMessage()).append("]").toString());
            }
            a(new Object[] {
                f, f1, bp.c.b, obj, abyte0, new Integer(0), new Integer(i), new Integer(0), obj1
            });
            a(obj);
            return bp.c.b;
        }
        a(new Object[] {
            f, f1, bp.c.a, obj, abyte0, new Integer(0), new Integer(i), new Integer(i), obj1
        });
        if (a.b())
        {
            a.b((new StringBuilder("socketWrite(bufferLen:")).append(i).append(") end").toString());
        }
        return bp.c.a;
    }

    public final void a(Object obj)
    {
        a a1 = (a)obj;
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            synchronized (g)
            {
                if (a1.f != null)
                {
                    break label0;
                }
            }
            return;
        }
        if (c.a(a1.f))
        {
            break MISSING_BLOCK_LABEL_222;
        }
        a1.f.a();
        a1.f = null;
        boolean flag = true;
_L3:
        obj1;
        JVM INSTR monitorexit ;
        if (a1.a != null && flag)
        {
            try
            {
                a1.c.close();
                a1.c = null;
                a1.a.close();
                a1.a = null;
            }
            catch (Throwable throwable)
            {
                if (a.e())
                {
                    a.e((new StringBuilder("Socket Close Expception - [")).append(throwable.getClass().getName()).append("] Message - [").append(throwable.getMessage()).append("]").toString());
                }
                a(new Object[] {
                    d, a1.b, bp.c.b, obj, null
                });
                return;
            }
            a(new Object[] {
                d, a1.b, bp.c.a, obj, null
            });
            return;
        }
          goto _L1
        flag = false;
          goto _L3
    }

    public final void a(Object obj, Object obj1)
    {
        obj = ((Object) ((Object[])obj));
        if (obj[0] == c)
        {
            ((bp.d)obj[1]).a((bp.c)obj[2], obj[3]);
        } else
        {
            if (obj[0] == d)
            {
                ((bp.a)obj[1]).a();
                return;
            }
            if (obj[0] == e)
            {
                ((bp.e)obj[1]).a((bp.c)obj[2], obj[3], (byte[])obj[4], ((Integer)obj[6]).intValue(), ((Integer)obj[7]).intValue(), obj[8]);
                return;
            }
            if (obj[0] == f)
            {
                ((bp.f)obj[1]).a((bp.c)obj[2], obj[3], ((Integer)obj[6]).intValue(), ((Integer)obj[7]).intValue(), obj[8]);
                return;
            }
        }
    }

    public final void a(String s, int i, bp.d d1, bp.a a1)
    {
        s = new c(s, i, d1, a1);
        try
        {
            s.start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (a.e())
        {
            a.e((new StringBuilder("Open Socket Exception - [")).append(s.getClass().getName()).append("] Message - [").append(s.getMessage()).append("]").toString());
        }
        a(new Object[] {
            c, d1, bp.c.b, null, null
        });
    }

    public final void a(String s, int i, Vector vector, bp.d d1, bp.a a1)
    {
        ex ex1 = new ex();
        vector = vector.elements();
        do
        {
            if (!vector.hasMoreElements())
            {
                break;
            }
            cz cz1 = (cz)vector.nextElement();
            if (cz1.a().equals("SSL_SelfSigned_Cert") && ((new String(cz1.b())).equals("TRUE") || (new String(cz1.b())).equals("true")))
            {
                ex1.a = true;
            }
            if (cz1.a().equals("SSL_Cert_Summary"))
            {
                ex1.b = new String(cz1.b());
            }
            if (cz1.a().equals("SSL_Cert_Data"))
            {
                ex1.c = new String(cz1.b());
            }
        } while (true);
        s = new c(s, i, ex1, d1, a1);
        try
        {
            s.start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (a.e())
        {
            a.e((new StringBuilder("Open Socket Exception - [")).append(s.getClass().getName()).append("] Message - [").append(s.getMessage()).append("]").toString());
        }
        a(new Object[] {
            c, d1, bp.c.b, null, null
        });
    }

    public final void b(Object obj)
    {
        a a1 = (a)obj;
        if (a1.f != null)
        {
            a1.f.b();
            return;
        }
        if (a.b())
        {
            a.b("SOCKET WRITE ERROR: socket read thread is null");
        }
        a(obj);
    }

}
