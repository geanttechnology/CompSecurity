// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

// Referenced classes of package d:
//            ac, r, a, s, 
//            u, w, t, aa, 
//            ab, i, j

public final class q
{

    private static final Logger a = Logger.getLogger(d/q.getName());

    private q()
    {
    }

    private static aa a(OutputStream outputstream)
    {
        return a(outputstream, new ac());
    }

    private static aa a(OutputStream outputstream, ac ac1)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        if (ac1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new r(ac1, outputstream);
        }
    }

    public static aa a(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            a a1 = c(socket);
            return a1.sink(a(socket.getOutputStream(), ((ac) (a1))));
        }
    }

    public static ab a(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(((InputStream) (new FileInputStream(file))), new ac());
        }
    }

    private static ab a(InputStream inputstream, ac ac1)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("in == null");
        }
        if (ac1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new s(ac1, inputstream);
        }
    }

    public static i a(aa aa)
    {
        if (aa == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            return new u(aa);
        }
    }

    public static j a(ab ab)
    {
        if (ab == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return new w(ab);
        }
    }

    static Logger a()
    {
        return a;
    }

    public static aa b(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(new FileOutputStream(file));
        }
    }

    public static ab b(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            a a1 = c(socket);
            return a1.source(a(socket.getInputStream(), a1));
        }
    }

    private static a c(Socket socket)
    {
        return new t(socket);
    }

    public static aa c(File file)
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
