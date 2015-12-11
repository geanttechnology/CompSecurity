// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.f;
import java.io.FilterOutputStream;
import java.io.OutputStream;

// Referenced classes of package com.a.a:
//            j, f

final class k extends FilterOutputStream
{

    final com.a.a.f a;
    final f b;
    final j c;

    k(j j1, OutputStream outputstream, com.a.a.f f1, f f2)
    {
        c = j1;
        a = f1;
        b = f2;
        super(outputstream);
    }

    public final void close()
    {
label0:
        {
            synchronized (c.a)
            {
                if (!j.a(c))
                {
                    break label0;
                }
            }
            return;
        }
        j.b(c);
        f.b(c.a);
        f1;
        JVM INSTR monitorexit ;
        super.close();
        b.a();
        return;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void write(byte abyte0[], int i, int l)
    {
        out.write(abyte0, i, l);
    }
}
