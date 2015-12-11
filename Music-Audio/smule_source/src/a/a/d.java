// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

// Referenced classes of package a.a:
//            f, ff, cy, cj, 
//            fh, ds, af, eq, 
//            fv, en, ck, fu

public final class d extends SocketImpl
    implements f
{

    private static Field a;
    private static Field b;
    private static Field c;
    private static Field d;
    private static Method e[];
    private static boolean f;
    private static Throwable g;
    private final Queue h = new LinkedList();
    private eq i;
    private ds j;
    private SocketImpl k;
    private fu l;
    private fv m;

    public d(eq eq1, ds ds1, SocketImpl socketimpl)
    {
        if (eq1 == null)
        {
            throw new NullPointerException("dispatch was null");
        }
        if (socketimpl == null)
        {
            throw new NullPointerException("delegate was null");
        } else
        {
            i = eq1;
            j = ds1;
            k = socketimpl;
            f();
            return;
        }
    }

    private cj a(boolean flag)
    {
        cj cj1 = new cj();
        InetAddress inetaddress = getInetAddress();
        if (inetaddress != null)
        {
            cj1.a(inetaddress);
        }
        int i1 = getPort();
        if (i1 > 0)
        {
            cj1.a(i1);
        }
        if (flag)
        {
            cj1.a(fh.a);
        }
        if (j != null)
        {
            cj1.j = j.a();
        }
        if (af.b())
        {
            cj1.a(af.a());
        }
        return cj1;
    }

    private transient Object a(int i1, Object aobj[])
    {
        try
        {
            a.set(k, address);
            b.set(k, fd);
            c.setInt(k, localport);
            d.setInt(k, port);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new cy(((Throwable) (aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new cy(((Throwable) (aobj)));
        }
        aobj = ((Object []) (e[i1].invoke(k, aobj)));
        f();
        return ((Object) (aobj));
        aobj;
        throw new cy(((Throwable) (aobj)));
        aobj;
        f();
        throw aobj;
        aobj;
        throw new cy(((Throwable) (aobj)));
        aobj;
        Throwable throwable = ((InvocationTargetException) (aobj)).getTargetException();
        if (throwable != null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        throw new cy(((Throwable) (aobj)));
        if (throwable instanceof Exception)
        {
            throw (Exception)throwable;
        }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        } else
        {
            throw new cy(throwable);
        }
        aobj;
        throw new cy(((Throwable) (aobj)));
        aobj;
        throw new cy(((Throwable) (aobj)));
    }

    private transient Object b(int i1, Object aobj[])
    {
        try
        {
            aobj = ((Object []) (a(i1, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new cy(((Throwable) (aobj)));
        }
        return ((Object) (aobj));
    }

    private transient Object c(int i1, Object aobj[])
    {
        try
        {
            aobj = ((Object []) (a(i1, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new cy(((Throwable) (aobj)));
        }
        return ((Object) (aobj));
    }

    public static boolean c()
    {
        return f;
    }

    public static Throwable d()
    {
        return g;
    }

    public static void e()
    {
        if (!f)
        {
            throw new cy(g);
        }
        Object obj = new SocketImpl() {

            protected final void accept(SocketImpl socketimpl)
            {
            }

            protected final int available()
            {
                return 0;
            }

            protected final void bind(InetAddress inetaddress, int i1)
            {
            }

            protected final void close()
            {
            }

            protected final void connect(String s, int i1)
            {
            }

            protected final void connect(InetAddress inetaddress, int i1)
            {
            }

            protected final void connect(SocketAddress socketaddress, int i1)
            {
            }

            protected final void create(boolean flag)
            {
            }

            protected final FileDescriptor getFileDescriptor()
            {
                return null;
            }

            protected final InetAddress getInetAddress()
            {
                return null;
            }

            protected final InputStream getInputStream()
            {
                return null;
            }

            protected final int getLocalPort()
            {
                return 0;
            }

            public final Object getOption(int i1)
            {
                return null;
            }

            protected final OutputStream getOutputStream()
            {
                return null;
            }

            protected final int getPort()
            {
                return 0;
            }

            protected final void listen(int i1)
            {
            }

            protected final void sendUrgentData(int i1)
            {
            }

            public final void setOption(int i1, Object obj2)
            {
            }

            protected final void setPerformancePreferences(int i1, int j1, int k1)
            {
            }

            protected final void shutdownInput()
            {
            }

            protected final void shutdownOutput()
            {
            }

            protected final boolean supportsUrgentData()
            {
                return false;
            }

            public final String toString()
            {
                return null;
            }

        };
        obj = new d(new eq(new Executor() {

            public final void execute(Runnable runnable)
            {
            }

        }), null, ((SocketImpl) (obj)));
        Object obj1 = new Object();
        try
        {
            ((d) (obj)).setOption(0, obj1);
            ((d) (obj)).getOption(0);
            ((d) (obj)).sendUrgentData(0);
            ((d) (obj)).listen(0);
            ((d) (obj)).getOutputStream();
            ((d) (obj)).getInputStream();
            ((d) (obj)).create(false);
            ((d) (obj)).connect(((SocketAddress) (null)), 0);
            ((d) (obj)).connect(((InetAddress) (null)), 0);
            ((d) (obj)).connect(((String) (null)), 0);
            ((d) (obj)).close();
            ((d) (obj)).bind(null, 0);
            ((d) (obj)).available();
            ((d) (obj)).accept(((SocketImpl) (obj)));
            ((d) (obj)).getFileDescriptor();
            ((d) (obj)).getInetAddress();
            ((d) (obj)).getLocalPort();
            ((d) (obj)).getPort();
            ((d) (obj)).setPerformancePreferences(0, 0, 0);
            ((d) (obj)).shutdownInput();
            ((d) (obj)).shutdownOutput();
            ((d) (obj)).supportsUrgentData();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
        catch (cy cy1)
        {
            throw cy1;
        }
        catch (Throwable throwable)
        {
            throw new cy(throwable);
        }
    }

    private void f()
    {
        try
        {
            address = (InetAddress)a.get(k);
            fd = (FileDescriptor)b.get(k);
            localport = c.getInt(k);
            port = d.getInt(k);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new cy(illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new cy(illegalaccessexception);
        }
    }

    public final cj a()
    {
        return a(true);
    }

    public final void a(cj cj1)
    {
        synchronized (h)
        {
            h.add(cj1);
        }
    }

    public final void accept(SocketImpl socketimpl)
    {
        c(0, new Object[] {
            socketimpl
        });
    }

    public final int available()
    {
        Integer integer = (Integer)c(1, new Object[0]);
        if (integer == null)
        {
            throw new cy("Received a null Integer");
        } else
        {
            return integer.intValue();
        }
    }

    public final cj b()
    {
        cj cj1;
        synchronized (h)
        {
            cj1 = (cj)h.poll();
        }
        return cj1;
    }

    public final void bind(InetAddress inetaddress, int i1)
    {
        c(2, new Object[] {
            inetaddress, Integer.valueOf(i1)
        });
    }

    public final void close()
    {
        c(3, new Object[0]);
        try
        {
            if (m != null)
            {
                m.d();
            }
            return;
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            en.a(throwable);
        }
    }

    public final void connect(String s, int i1)
    {
        try
        {
            c(6, new Object[] {
                s, Integer.valueOf(i1)
            });
            return;
        }
        catch (IOException ioexception)
        {
            if (s != null)
            {
                try
                {
                    cj cj1 = a(false);
                    cj1.b();
                    cj1.c();
                    cj1.e();
                    cj1.b(s);
                    cj1.a(i1);
                    cj1.a(ioexception);
                    i.a(cj1, ck.i);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw s;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    en.a(s);
                }
            }
        }
        throw ioexception;
    }

    public final void connect(InetAddress inetaddress, int i1)
    {
        try
        {
            c(4, new Object[] {
                inetaddress, Integer.valueOf(i1)
            });
            return;
        }
        catch (IOException ioexception)
        {
            if (inetaddress != null)
            {
                try
                {
                    cj cj1 = a(false);
                    cj1.b();
                    cj1.c();
                    cj1.e();
                    cj1.a(inetaddress);
                    cj1.a(i1);
                    cj1.a(ioexception);
                    i.a(cj1, ck.i);
                }
                // Misplaced declaration of an exception variable
                catch (InetAddress inetaddress)
                {
                    throw inetaddress;
                }
                // Misplaced declaration of an exception variable
                catch (InetAddress inetaddress)
                {
                    en.a(inetaddress);
                }
            }
        }
        throw ioexception;
    }

    public final void connect(SocketAddress socketaddress, int i1)
    {
        try
        {
            c(5, new Object[] {
                socketaddress, Integer.valueOf(i1)
            });
            return;
        }
        catch (IOException ioexception)
        {
            if (socketaddress != null)
            {
                try
                {
                    if (socketaddress instanceof InetSocketAddress)
                    {
                        cj cj1 = a(false);
                        socketaddress = (InetSocketAddress)socketaddress;
                        cj1.b();
                        cj1.c();
                        cj1.e();
                        cj1.a(socketaddress.getAddress());
                        cj1.a(socketaddress.getPort());
                        cj1.a(ioexception);
                        i.a(cj1, ck.i);
                    }
                }
                // Misplaced declaration of an exception variable
                catch (SocketAddress socketaddress)
                {
                    throw socketaddress;
                }
                // Misplaced declaration of an exception variable
                catch (SocketAddress socketaddress)
                {
                    en.a(socketaddress);
                }
            }
        }
        throw ioexception;
    }

    public final void create(boolean flag)
    {
        c(7, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public final FileDescriptor getFileDescriptor()
    {
        return (FileDescriptor)b(8, new Object[0]);
    }

    public final InetAddress getInetAddress()
    {
        return (InetAddress)b(9, new Object[0]);
    }

    public final InputStream getInputStream()
    {
        Object obj;
        obj = (InputStream)c(10, new Object[0]);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        fv fv1;
        if (m != null && m.a(((InputStream) (obj))))
        {
            return m;
        }
        m = new fv(this, ((InputStream) (obj)), i);
        fv1 = m;
        return fv1;
        obj;
        throw obj;
        Throwable throwable;
        throwable;
        en.a(throwable);
        return ((InputStream) (obj));
    }

    public final int getLocalPort()
    {
        return ((Integer)b(11, new Object[0])).intValue();
    }

    public final Object getOption(int i1)
    {
        return k.getOption(i1);
    }

    public final OutputStream getOutputStream()
    {
        Object obj;
        obj = (OutputStream)c(12, new Object[0]);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        fu fu1;
        if (l != null && l.a(((OutputStream) (obj))))
        {
            return l;
        }
        l = new fu(this, ((OutputStream) (obj)));
        fu1 = l;
        return fu1;
        obj;
        throw obj;
        Throwable throwable;
        throwable;
        en.a(throwable);
        return ((OutputStream) (obj));
    }

    public final int getPort()
    {
        return ((Integer)b(13, new Object[0])).intValue();
    }

    public final void listen(int i1)
    {
        c(14, new Object[] {
            Integer.valueOf(i1)
        });
    }

    public final void sendUrgentData(int i1)
    {
        c(15, new Object[] {
            Integer.valueOf(i1)
        });
    }

    public final void setOption(int i1, Object obj)
    {
        k.setOption(i1, obj);
    }

    public final void setPerformancePreferences(int i1, int j1, int k1)
    {
        b(16, new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1)
        });
    }

    public final void shutdownInput()
    {
        c(17, new Object[0]);
    }

    public final void shutdownOutput()
    {
        c(18, new Object[0]);
    }

    public final boolean supportsUrgentData()
    {
        return ((Boolean)b(19, new Object[0])).booleanValue();
    }

    public final String toString()
    {
        return k.toString();
    }

    static 
    {
        e = new Method[20];
        f = false;
        g = null;
        Object obj;
        AccessibleObject aaccessibleobject[];
        a = java/net/SocketImpl.getDeclaredField("address");
        b = java/net/SocketImpl.getDeclaredField("fd");
        c = java/net/SocketImpl.getDeclaredField("localport");
        d = java/net/SocketImpl.getDeclaredField("port");
        obj = a;
        aaccessibleobject = new AccessibleObject[3];
        aaccessibleobject[0] = b;
        aaccessibleobject[1] = c;
        aaccessibleobject[2] = d;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        ((AccessibleObject) (obj)).setAccessible(true);
        if (aaccessibleobject.length > 0)
        {
            ff.a(aaccessibleobject);
        }
        e[0] = java/net/SocketImpl.getDeclaredMethod("accept", new Class[] {
            java/net/SocketImpl
        });
        e[1] = java/net/SocketImpl.getDeclaredMethod("available", new Class[0]);
        e[2] = java/net/SocketImpl.getDeclaredMethod("bind", new Class[] {
            java/net/InetAddress, Integer.TYPE
        });
        e[3] = java/net/SocketImpl.getDeclaredMethod("close", new Class[0]);
        e[4] = java/net/SocketImpl.getDeclaredMethod("connect", new Class[] {
            java/net/InetAddress, Integer.TYPE
        });
        e[5] = java/net/SocketImpl.getDeclaredMethod("connect", new Class[] {
            java/net/SocketAddress, Integer.TYPE
        });
        e[6] = java/net/SocketImpl.getDeclaredMethod("connect", new Class[] {
            java/lang/String, Integer.TYPE
        });
        e[7] = java/net/SocketImpl.getDeclaredMethod("create", new Class[] {
            Boolean.TYPE
        });
        e[8] = java/net/SocketImpl.getDeclaredMethod("getFileDescriptor", new Class[0]);
        e[9] = java/net/SocketImpl.getDeclaredMethod("getInetAddress", new Class[0]);
        e[10] = java/net/SocketImpl.getDeclaredMethod("getInputStream", new Class[0]);
        e[11] = java/net/SocketImpl.getDeclaredMethod("getLocalPort", new Class[0]);
        e[12] = java/net/SocketImpl.getDeclaredMethod("getOutputStream", new Class[0]);
        e[13] = java/net/SocketImpl.getDeclaredMethod("getPort", new Class[0]);
        e[14] = java/net/SocketImpl.getDeclaredMethod("listen", new Class[] {
            Integer.TYPE
        });
        e[15] = java/net/SocketImpl.getDeclaredMethod("sendUrgentData", new Class[] {
            Integer.TYPE
        });
        e[16] = java/net/SocketImpl.getDeclaredMethod("setPerformancePreferences", new Class[] {
            Integer.TYPE, Integer.TYPE, Integer.TYPE
        });
        e[17] = java/net/SocketImpl.getDeclaredMethod("shutdownInput", new Class[0]);
        e[18] = java/net/SocketImpl.getDeclaredMethod("shutdownOutput", new Class[0]);
        e[19] = java/net/SocketImpl.getDeclaredMethod("supportsUrgentData", new Class[0]);
        ff.a(e);
        f = true;
        return;
        Object obj1;
        obj1;
        f = false;
        g = ((Throwable) (obj1));
        return;
        obj1;
        int i1;
        f = false;
        i1 = 0;
_L3:
        if (i1 >= 20)
        {
            break MISSING_BLOCK_LABEL_688;
        }
        if (e[i1] != null) goto _L2; else goto _L1
_L1:
        g = new cy((new StringBuilder("Bad method: ")).append(i1).toString(), ((Throwable) (obj1)));
        return;
_L2:
        i1++;
          goto _L3
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
        f = false;
        obj1 = "unknown";
        if (a != null) goto _L5; else goto _L4
_L4:
        obj1 = "address";
_L7:
        g = new cy((new StringBuilder("No such field: ")).append(((String) (obj1))).toString(), nosuchfieldexception);
        return;
_L5:
        if (b == null)
        {
            obj1 = "fd";
        } else
        if (c == null)
        {
            obj1 = "localport";
        } else
        if (d == null)
        {
            obj1 = "port";
        }
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        f = false;
        g = ((Throwable) (obj1));
        return;
        i1 = 20;
          goto _L1
    }
}
