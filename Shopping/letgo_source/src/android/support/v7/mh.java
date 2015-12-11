// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            mf, xu

class mh
    implements mf
{

    private xu a;
    private byte b[];
    private final int c;

    public mh(int i)
    {
        c = i;
        a();
    }

    public void a()
    {
        b = new byte[c];
        a = xu.a(b);
    }

    public void a(int i, long l)
        throws IOException
    {
        a.a(i, l);
    }

    public void a(int i, String s)
        throws IOException
    {
        a.a(i, s);
    }

    public byte[] b()
        throws IOException
    {
        int i = a.a();
        if (i < 0)
        {
            throw new IOException();
        }
        if (i == 0)
        {
            return b;
        } else
        {
            byte abyte0[] = new byte[b.length - i];
            System.arraycopy(b, 0, abyte0, 0, abyte0.length);
            return abyte0;
        }
    }
}
