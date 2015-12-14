// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;

import com.socialin.android.brushlib.util.b;
import com.socialin.android.d;
import java.io.IOException;
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
        com.socialin.android.brushlib.util.b.b(a, b);
        try
        {
            b.close();
        }
        catch (IOException ioexception)
        {
            d.b(myobfuscated.br.d.b(), new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
            });
        }
        if (c != null)
        {
            c.run();
        }
        return;
        Exception exception;
        exception;
        try
        {
            b.close();
        }
        catch (IOException ioexception1)
        {
            d.b(myobfuscated.br.d.b(), new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(ioexception1.getMessage()).toString()
            });
        }
        if (c != null)
        {
            c.run();
        }
        throw exception;
    }

    File(ByteBuffer bytebuffer, RandomAccessFile randomaccessfile, Runnable runnable)
    {
        a = bytebuffer;
        b = randomaccessfile;
        c = runnable;
        super();
    }
}
