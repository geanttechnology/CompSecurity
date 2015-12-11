// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package netswipe:
//            dr

public class ds extends dr
{

    private final byte a[];
    private final String b;

    public ds(byte abyte0[], String s, String s1)
    {
        super(s);
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("byte[] may not be null");
        } else
        {
            a = abyte0;
            b = s1;
            return;
        }
    }

    public void a(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(a);
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return null;
    }

    public String d()
    {
        return "binary";
    }

    public long e()
    {
        return (long)a.length;
    }
}
