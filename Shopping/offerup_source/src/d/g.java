// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.OutputStream;

// Referenced classes of package d:
//            f

final class g extends OutputStream
{

    private f a;

    g(f f1)
    {
        a = f1;
        super();
    }

    public final void close()
    {
    }

    public final void flush()
    {
    }

    public final String toString()
    {
        return (new StringBuilder()).append(this).append(".outputStream()").toString();
    }

    public final void write(int i)
    {
        a.a((byte)i);
    }

    public final void write(byte abyte0[], int i, int j)
    {
        a.b(abyte0, i, j);
    }
}
