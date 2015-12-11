// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package a.a:
//            ft, fe, ff, en, 
//            cz, fd, fs, e, 
//            cy, d, fw, c, 
//            eq, ds

public final class fc
{

    public static final ft a;
    public static fe b;
    private static final List c;
    private e d;
    private c e;
    private c f;
    private fs g;
    private eq h;
    private ds i;
    private fe j;
    private ft k;

    public fc(eq eq, ds ds)
    {
        j = b;
        k = a;
        h = eq;
        i = ds;
    }

    private static void a(String s, Throwable throwable)
    {
        synchronized (c)
        {
            c.add(throwable);
        }
        en.c(s);
    }

    private static void a(javax.net.ssl.SSLSocketFactory sslsocketfactory)
    {
        SSLSocketFactory sslsocketfactory1 = SSLSocketFactory.getSocketFactory();
        ff.a(org/apache/http/conn/ssl/SSLSocketFactory, javax/net/ssl/SSLSocketFactory).set(sslsocketfactory1, sslsocketfactory);
    }

    private static boolean a(SocketImplFactory socketimplfactory)
    {
        Field field;
        try
        {
            field = ff.a(java/net/Socket, java/net/SocketImplFactory);
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a("Unable to install OPTIMZ for http connections", ((Throwable) (socketimplfactory)));
            return false;
        }
        try
        {
            field.setAccessible(true);
            field.set(null, socketimplfactory);
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a("Unable to install OPTIMZ for http connections", ((Throwable) (socketimplfactory)));
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a("Unable to install OPTIMZ for http connections", ((Throwable) (socketimplfactory)));
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a("Unable to install OPTIMZ for http connections", ((Throwable) (socketimplfactory)));
            return false;
        }
        return true;
    }

    public static void d()
    {
        List list = c;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); en.a((Throwable)iterator.next())) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        throw exception;
        c.clear();
        list;
        JVM INSTR monitorexit ;
    }

    private boolean e()
    {
        fd fd1 = new fd(this);
        Thread thread = new Thread(fd1);
        thread.start();
        try
        {
            thread.join();
        }
        catch (InterruptedException interruptedexception) { }
        return fd1.a();
    }

    private boolean f()
    {
        boolean flag;
        try
        {
            g = new fs(k, h, i);
            flag = g.b();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return flag;
    }

    private static javax.net.ssl.SSLSocketFactory g()
    {
        SSLSocketFactory sslsocketfactory = SSLSocketFactory.getSocketFactory();
        return (javax.net.ssl.SSLSocketFactory)ff.a(org/apache/http/conn/ssl/SSLSocketFactory, javax/net/ssl/SSLSocketFactory).get(sslsocketfactory);
    }

    private boolean h()
    {
        Object obj;
        SocketImplFactory socketimplfactory;
        obj = null;
        try
        {
            socketimplfactory = (SocketImplFactory)ff.a(ff.a(java/net/Socket, java/net/SocketImplFactory), null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a("Unable to install OPTIMZ for http connections", ((Throwable) (obj)));
            return false;
        }
        if (socketimplfactory != null) goto _L2; else goto _L1
_L1:
        obj = (SocketImpl)ff.a(ff.a(java/net/Socket, java/net/SocketImpl), new Socket());
        if (obj == null)
        {
            try
            {
                throw new cz("SocketImpl was null");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                a("Unable to install OPTIMZ for http connections", ((Throwable) (obj)));
            }
            return false;
        }
        obj = obj.getClass();
_L6:
        if (socketimplfactory == null) goto _L4; else goto _L3
_L3:
        try
        {
            obj = new e(socketimplfactory, h, i);
            a(((SocketImplFactory) (obj)));
        }
        catch (cz cz1)
        {
            a("Unable to install OPTIMZ for http connections", cz1);
            return false;
        }
        catch (IOException ioexception)
        {
            a("Unable to install OPTIMZ for http connections", ioexception);
            return false;
        }
        d = ((e) (obj));
        return true;
_L2:
        if (socketimplfactory instanceof e)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        obj = new e(((Class) (obj)), h, i);
        Socket.setSocketImplFactory(((SocketImplFactory) (obj)));
        break MISSING_BLOCK_LABEL_105;
        a("Unable to install OPTIMZ for http connections", new NullPointerException("Null SocketImpl"));
        return false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean a()
    {
        boolean flag2 = false;
        if (!a.a.d.c())
        {
            a("Unable to install OPTMZ", a.a.d.d());
        } else
        {
            boolean flag;
            boolean flag1;
            try
            {
                a.a.d.e();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                en.a(((cy) (obj)).toString(), ((Throwable) (obj)));
                return false;
            }
            flag = h() | false;
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                flag1 = flag | e();
            } else
            {
                flag1 = flag | c();
            }
            if (android.os.Build.VERSION.SDK_INT >= 17)
            {
                flag1 |= fw.a(h, i);
            }
            if (j == fe.a)
            {
                Object obj = HttpsURLConnection.getDefaultSSLSocketFactory();
                if (obj instanceof c)
                {
                    e = (c)obj;
                } else
                {
                    e = new c(((javax.net.ssl.SSLSocketFactory) (obj)), h, i);
                    HttpsURLConnection.setDefaultSSLSocketFactory(e);
                }
                return flag1 | true;
            }
            flag2 = flag1;
            if (j == fe.b)
            {
                return flag1 | f();
            }
        }
        return flag2;
    }

    public final void b()
    {
        try
        {
            javax.net.ssl.SSLSocketFactory sslsocketfactory = g();
            if (sslsocketfactory instanceof c)
            {
                a(((c)sslsocketfactory).a());
            }
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", illegalargumentexception);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", illegalaccessexception);
            return;
        }
        catch (cz cz1)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", cz1);
            return;
        }
        f = null;
    }

    public final boolean c()
    {
        Object obj;
        try
        {
            obj = g();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", ((Throwable) (obj)));
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", ((Throwable) (obj)));
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", ((Throwable) (obj)));
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", ((Throwable) (obj)));
            return false;
        }
        if (obj == null)
        {
            a("Unable to install OPTIMZ for SSL HttpClient connections", new NullPointerException("Delegate factory was null"));
        } else
        if (!(obj instanceof c))
        {
            obj = new c(((javax.net.ssl.SSLSocketFactory) (obj)), h, i);
            try
            {
                a(((javax.net.ssl.SSLSocketFactory) (obj)));
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                a("Unable to install OPTIMZ for SSL HttpClient connections", illegalargumentexception);
                return false;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                a("Unable to install OPTIMZ for SSL HttpClient connections", illegalaccessexception);
                return false;
            }
            catch (cz cz1)
            {
                a("Unable to install OPTIMZ for SSL HttpClient connections", cz1);
                return false;
            }
            f = ((c) (obj));
            return true;
        }
        return false;
    }

    static 
    {
        a = ft.b;
        b = fe.c;
        c = new LinkedList();
        URL url = new URL("https://www.google.com");
        if (((URLStreamHandler)ff.a(ff.a(java/net/URL, java/net/URLStreamHandler), url)).getClass().getName().contains("okhttp") && android.os.Build.VERSION.SDK_INT >= 19)
        {
            b = fe.a;
            break MISSING_BLOCK_LABEL_89;
        }
        try
        {
            b = fe.b;
        }
        catch (Exception exception)
        {
            b = fe.c;
        }
    }
}
