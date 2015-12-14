// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.OutputStream;

public class aik extends aij
{

    private final byte a[];
    private final String b;

    public aik(byte abyte0[], String s)
    {
        this(abyte0, "application/octet-stream", s);
    }

    public aik(byte abyte0[], String s, String s1)
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
