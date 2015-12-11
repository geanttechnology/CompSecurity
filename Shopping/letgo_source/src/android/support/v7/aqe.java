// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package android.support.v7:
//            aqf, aqg, aql, apt, 
//            aqj, apw, aqk, apx, 
//            apv, aqm, aqh, aqi

public final class aqe
{

    private static final Logger a = Logger.getLogger(android/support/v7/aqe.getName());

    private aqe()
    {
    }

    public static apw a(aqj aqj)
    {
        if (aqj == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            return new aqf(aqj);
        }
    }

    public static apx a(aqk aqk)
    {
        if (aqk == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return new aqg(aqk);
        }
    }

    public static aqj a(OutputStream outputstream)
    {
        return a(outputstream, new aql());
    }

    private static aqj a(OutputStream outputstream, aql aql1)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        if (aql1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new aqj(aql1, outputstream) {

                final aql a;
                final OutputStream b;

                public void close()
                    throws IOException
                {
                    b.close();
                }

                public void flush()
                    throws IOException
                {
                    b.flush();
                }

                public aql timeout()
                {
                    return a;
                }

                public String toString()
                {
                    return (new StringBuilder()).append("sink(").append(b).append(")").toString();
                }

                public void write(apv apv1, long l)
                    throws IOException
                {
                    aqm.a(apv1.b, 0L, l);
                    do
                    {
                        if (l <= 0L)
                        {
                            break;
                        }
                        a.throwIfReached();
                        aqh aqh1 = apv1.a;
                        int i = (int)Math.min(l, aqh1.c - aqh1.b);
                        b.write(aqh1.a, aqh1.b, i);
                        aqh1.b = aqh1.b + i;
                        long l1 = l - (long)i;
                        apv1.b = apv1.b - (long)i;
                        l = l1;
                        if (aqh1.b == aqh1.c)
                        {
                            apv1.a = aqh1.a();
                            aqi.a(aqh1);
                            l = l1;
                        }
                    } while (true);
                }

            
            {
                a = aql1;
                b = outputstream;
                super();
            }
            };
        }
    }

    public static aqj a(Socket socket)
        throws IOException
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            apt apt1 = c(socket);
            return apt1.sink(a(socket.getOutputStream(), ((aql) (apt1))));
        }
    }

    public static aqk a(File file)
        throws FileNotFoundException
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(((InputStream) (new FileInputStream(file))));
        }
    }

    public static aqk a(InputStream inputstream)
    {
        return a(inputstream, new aql());
    }

    private static aqk a(InputStream inputstream, aql aql1)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("in == null");
        }
        if (aql1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new aqk(aql1, inputstream) {

                final aql a;
                final InputStream b;

                public void close()
                    throws IOException
                {
                    b.close();
                }

                public long read(apv apv1, long l)
                    throws IOException
                {
                    if (l < 0L)
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
                    }
                    if (l == 0L)
                    {
                        return 0L;
                    }
                    a.throwIfReached();
                    aqh aqh1 = apv1.d(1);
                    int i = (int)Math.min(l, 2048 - aqh1.c);
                    i = b.read(aqh1.a, aqh1.c, i);
                    if (i == -1)
                    {
                        return -1L;
                    } else
                    {
                        aqh1.c = aqh1.c + i;
                        apv1.b = apv1.b + (long)i;
                        return (long)i;
                    }
                }

                public aql timeout()
                {
                    return a;
                }

                public String toString()
                {
                    return (new StringBuilder()).append("source(").append(b).append(")").toString();
                }

            
            {
                a = aql1;
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

    public static aqj b(File file)
        throws FileNotFoundException
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(new FileOutputStream(file));
        }
    }

    public static aqk b(Socket socket)
        throws IOException
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            apt apt1 = c(socket);
            return apt1.source(a(socket.getInputStream(), apt1));
        }
    }

    private static apt c(Socket socket)
    {
        return new apt(socket) {

            final Socket a;

            protected void timedOut()
            {
                try
                {
                    a.close();
                    return;
                }
                catch (Exception exception)
                {
                    aqe.a().log(Level.WARNING, (new StringBuilder()).append("Failed to close timed out socket ").append(a).toString(), exception);
                }
            }

            
            {
                a = socket;
                super();
            }
        };
    }

    public static aqj c(File file)
        throws FileNotFoundException
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
