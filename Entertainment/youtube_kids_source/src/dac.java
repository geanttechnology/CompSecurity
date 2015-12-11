// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class dac
    implements Closeable
{

    public static final byte a[] = {
        0, 0
    };
    public final OutputStream b;
    public final String c;
    public boolean d;
    public final ByteBuffer e = ByteBuffer.wrap(new byte[1024]);
    private final boolean f = false;

    public dac(OutputStream outputstream, String s, boolean flag)
    {
        b = outputstream;
        c = s;
    }

    public void a(exe exe1)
    {
        int i;
        exe1 = exe1.c();
        i = exe1.length;
        e.putInt(i);
        if (f) goto _L2; else goto _L1
_L1:
        b.write(e.array(), 0, e.position());
        b.write(exe1);
        e.clear();
_L5:
        e.clear();
        return;
_L2:
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        int j;
        j = Math.min(e.remaining(), i);
        e.put(exe1, exe1.length - i, j);
        j = i - j;
        if (e.remaining() != 0)
        {
            i = j;
            if (j != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        b.write(e.array(), 0, e.position());
        e.clear();
        i = j;
        if (true) goto _L2; else goto _L3
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        exe1;
        e.clear();
        throw exe1;
    }

    public final void close()
    {
        b.close();
    }

}
