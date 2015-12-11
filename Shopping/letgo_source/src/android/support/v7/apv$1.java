// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.OutputStream;

// Referenced classes of package android.support.v7:
//            apv

class t> extends OutputStream
{

    final apv a;

    public void close()
    {
    }

    public void flush()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append(this).append(".outputStream()").toString();
    }

    public void write(int i)
    {
        a.a((byte)i);
    }

    public void write(byte abyte0[], int i, int j)
    {
        a.b(abyte0, i, j);
    }

    (apv apv1)
    {
        a = apv1;
        super();
    }
}
