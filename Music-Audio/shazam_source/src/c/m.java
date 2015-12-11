// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package c:
//            n, o, t, r, 
//            d, s, e, a, 
//            c, u, p, q

public final class m
{

    private static final Logger a = Logger.getLogger(c/m.getName());

    private m()
    {
    }

    public static d a(r r)
    {
        if (r == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            return new n(r);
        }
    }

    public static e a(s s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return new o(s);
        }
    }

    private static r a(OutputStream outputstream)
    {
        return a(outputstream, new t());
    }

    private static r a(OutputStream outputstream, t t1)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        if (t1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new r(t1, outputstream) {

                final t a;
                final OutputStream b;

                public final void a_(c c1, long l)
                {
                    u.a(c1.b, 0L, l);
                    do
                    {
                        if (l <= 0L)
                        {
                            break;
                        }
                        a.f();
                        p p1 = c1.a;
                        int i = (int)Math.min(l, p1.c - p1.b);
                        b.write(p1.a, p1.b, i);
                        p1.b = p1.b + i;
                        long l1 = l - (long)i;
                        c1.b = c1.b - (long)i;
                        l = l1;
                        if (p1.b == p1.c)
                        {
                            c1.a = p1.a();
                            q.a(p1);
                            l = l1;
                        }
                    } while (true);
                }

                public final void close()
                {
                    b.close();
                }

                public final void flush()
                {
                    b.flush();
                }

                public final String toString()
                {
                    return (new StringBuilder("sink(")).append(b).append(")").toString();
                }

                public final t w_()
                {
                    return a;
                }

            
            {
                a = t1;
                b = outputstream;
                super();
            }
            };
        }
    }

    public static r a(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            a a1 = c(socket);
            return new a._cls1(a1, a(socket.getOutputStream(), ((t) (a1))));
        }
    }

    public static s a(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(((InputStream) (new FileInputStream(file))), new t());
        }
    }

    private static s a(InputStream inputstream, t t1)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("in == null");
        }
        if (t1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new s(t1, inputstream) {

                final t a;
                final InputStream b;

                public final long a(c c1, long l)
                {
                    if (l < 0L)
                    {
                        throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
                    }
                    if (l == 0L)
                    {
                        return 0L;
                    }
                    a.f();
                    p p1 = c1.e(1);
                    int i = (int)Math.min(l, 2048 - p1.c);
                    i = b.read(p1.a, p1.c, i);
                    if (i == -1)
                    {
                        return -1L;
                    } else
                    {
                        p1.c = p1.c + i;
                        c1.b = c1.b + (long)i;
                        return (long)i;
                    }
                }

                public final void close()
                {
                    b.close();
                }

                public final String toString()
                {
                    return (new StringBuilder("source(")).append(b).append(")").toString();
                }

                public final t w_()
                {
                    return a;
                }

            
            {
                a = t1;
                b = inputstream;
                super();
            }
            };
        }
    }

    static Logger a()
    {
        return a;
    }

    public static r b(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(new FileOutputStream(file));
        }
    }

    public static s b(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            a a1 = c(socket);
            return new a._cls2(a1, a(socket.getInputStream(), a1));
        }
    }

    private static a c(Socket socket)
    {
        return new a(socket) {

            final Socket a;

            protected final void a()
            {
                try
                {
                    a.close();
                    return;
                }
                catch (Exception exception)
                {
                    m.a().log(Level.WARNING, (new StringBuilder("Failed to close timed out socket ")).append(a).toString(), exception);
                }
            }

            
            {
                a = socket;
                super();
            }
        };
    }

    public static r c(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(new FileOutputStream(file, true));
        }
    }

}
