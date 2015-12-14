// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

// Referenced classes of package myobfuscated.br:
//            d

final class it>
    implements Runnable
{

    private ByteBuffer a;
    private RandomAccessFile b;
    private Runnable c;

    public final void run()
    {
        d.a(a, b);
        if (c != null)
        {
            c.run();
        }
    }

    File(ByteBuffer bytebuffer, RandomAccessFile randomaccessfile, Runnable runnable)
    {
        a = bytebuffer;
        b = randomaccessfile;
        c = runnable;
        super();
    }
}
