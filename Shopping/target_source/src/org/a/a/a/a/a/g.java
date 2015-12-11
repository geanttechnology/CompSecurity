// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.a.a.a.a.b.b;

// Referenced classes of package org.a.a.a.a.a:
//            d, c, e

public class g extends d
{

    private final byte a[];

    public g(String s, c c1)
    {
        super(c1);
        b.a(s, "Text");
        c1 = c1.b();
        if (c1 == null)
        {
            c1 = org.a.a.a.a.a.e.b;
        }
        a = s.getBytes(c1);
    }

    public String a()
    {
        return null;
    }

    public void a(OutputStream outputstream)
        throws IOException
    {
        b.a(outputstream, "Output stream");
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(a);
        byte abyte0[] = new byte[4096];
        do
        {
            int i = bytearrayinputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                outputstream.flush();
                return;
            }
        } while (true);
    }

    public String c()
    {
        return "8bit";
    }

    public long d()
    {
        return (long)a.length;
    }
}
