// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.m;
import com.a.a.a.u;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;

// Referenced classes of package com.a.a.a.b:
//            d, l, a

final class p
    implements d
{

    private final DataOutputStream a;
    private final ByteArrayOutputStream b = new ByteArrayOutputStream();
    private final DataOutputStream c;
    private final boolean d;

    p(OutputStream outputstream, boolean flag)
    {
        a = new DataOutputStream(outputstream);
        d = flag;
        outputstream = new Deflater();
        outputstream.setDictionary(l.a);
        c = new DataOutputStream(m.a().a(b, outputstream));
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
    }

    public final void a(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        a.writeInt(0x80030009);
        a.writeInt(8);
        a.writeInt(i);
        a.writeInt(j);
        a.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(int i, a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a1.p == -1)
        {
            throw new IllegalArgumentException();
        }
        break MISSING_BLOCK_LABEL_23;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        a.writeInt(0x80030003);
        a.writeInt(8);
        a.writeInt(0x7fffffff & i);
        a.writeInt(a1.p);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(boolean flag, int i)
    {
        boolean flag2 = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag3 = d;
        Exception exception;
        boolean flag1;
        if (i % 2 == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
          goto _L1
_L7:
        if (flag == flag1) goto _L3; else goto _L2
_L2:
        throw new IllegalArgumentException("payload != reply");
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L5:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L3:
        a.writeInt(0x80030006);
        a.writeInt(4);
        a.writeInt(i);
        a.flush();
        this;
        JVM INSTR monitorexit ;
        return;
_L1:
        if (flag3 == flag1) goto _L5; else goto _L4
_L4:
        flag1 = flag2;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void a(boolean flag, int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
        b.reset();
        int j = list.size() / 2;
        c.writeInt(j);
        String s;
        for (list = list.iterator(); list.hasNext(); c.write(s.getBytes("UTF-8")))
        {
            s = (String)list.next();
            c.writeInt(s.length());
        }

        break MISSING_BLOCK_LABEL_89;
        list;
        throw list;
        int k;
        c.flush();
        k = b.size();
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a.writeInt(0x80030001);
        a.writeInt(((flag1 | false) & 0xff) << 24 | k + 10 & 0xffffff);
        a.writeInt(0x7fffffff & i);
        a.writeInt(0);
        a.writeShort(0);
        b.writeTo(a);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(boolean flag, int i, byte abyte0[], int j)
    {
        int k = 0;
        this;
        JVM INSTR monitorenter ;
        if (flag)
        {
            k = 1;
        }
        a.writeInt(0x7fffffff & i);
        a.writeInt((k & 0xff) << 24 | 0xffffff & j);
        a.write(abyte0, 0, j);
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        a.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(int i, a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a1.q == -1)
        {
            throw new IllegalArgumentException();
        }
        break MISSING_BLOCK_LABEL_23;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        a.writeInt(0x80030007);
        a.writeInt(8);
        a.writeInt(i);
        a.writeInt(a1.q);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void close()
    {
        u.a(a, c);
    }
}
