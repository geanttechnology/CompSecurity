// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            yh, yd

static class g
{

    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Map h;

    public static g a(InputStream inputstream)
        throws IOException
    {
        g g1 = new <init>();
        if (yh.a(inputstream) != 0x20150306)
        {
            throw new IOException();
        }
        g1.b = yh.c(inputstream);
        g1.c = yh.c(inputstream);
        if (g1.c.equals(""))
        {
            g1.c = null;
        }
        g1.d = yh.b(inputstream);
        g1.e = yh.b(inputstream);
        g1.f = yh.b(inputstream);
        g1.g = yh.b(inputstream);
        g1.h = yh.d(inputstream);
        return g1;
    }

    public h a(byte abyte0[])
    {
        h h1 = new <init>();
        h1.a = abyte0;
        h1.b = c;
        h1.c = d;
        h1.d = e;
        h1.e = f;
        h1.f = g;
        h1.g = h;
        return h1;
    }

    public boolean a(OutputStream outputstream)
    {
        yh.a(outputstream, 0x20150306);
        yh.a(outputstream, b);
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        String s = "";
_L1:
        try
        {
            yh.a(outputstream, s);
            yh.a(outputstream, d);
            yh.a(outputstream, e);
            yh.a(outputstream, f);
            yh.a(outputstream, g);
            yh.a(h, outputstream);
            outputstream.flush();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            yd.b("%s", new Object[] {
                outputstream.toString()
            });
            return false;
        }
        return true;
        s = c;
          goto _L1
    }

    private ()
    {
    }

    public (String s,  )
    {
        b = s;
        a = .a.length;
        c = .b;
        d = .c;
        e = .d;
        f = .e;
        g = .f;
        h = .g;
    }
}
