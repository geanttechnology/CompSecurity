// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

abstract class bl
{

    final bk a;

    private bl(bk bk1)
    {
        a = bk1;
        super();
    }

    bl(bk bk1, byte byte0)
    {
        this(bk1);
    }

    abstract InputStream a();

    final InputStream a(URLConnection urlconnection)
    {
        a.b(urlconnection);
        Object obj;
        try
        {
            obj = a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.a(urlconnection, ((Exception) (obj)));
            throw obj;
        }
        if (obj == null)
        {
            return null;
        } else
        {
            return new InputStream(((InputStream) (obj)), urlconnection) {

                private InputStream a;
                private URLConnection b;
                private bl c;

                private void a(int i)
                {
                    if (i == -1)
                    {
                        c.a.d(b);
                        return;
                    } else
                    {
                        bk.a(c.a, b, i);
                        return;
                    }
                }

                public final void close()
                {
                    c.a.d(b);
                    a.close();
                }

                public final int read()
                {
                    int i;
                    try
                    {
                        i = a.read();
                        a(i);
                    }
                    catch (IOException ioexception)
                    {
                        c.a.a(b, ioexception);
                        throw ioexception;
                    }
                    return i;
                }

                public final int read(byte abyte0[])
                {
                    int i;
                    try
                    {
                        i = a.read(abyte0);
                        a(i);
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[])
                    {
                        c.a.a(b, abyte0);
                        throw abyte0;
                    }
                    return i;
                }

                public final int read(byte abyte0[], int i, int j)
                {
                    try
                    {
                        i = a.read(abyte0, i, j);
                        a(i);
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[])
                    {
                        c.a.a(b, abyte0);
                        throw abyte0;
                    }
                    return i;
                }

            
            {
                c = bl.this;
                a = inputstream;
                b = urlconnection;
                super();
            }
            };
        }
    }
}
