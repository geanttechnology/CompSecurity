// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.d.a:
//            x, ak

final class ah
{

    final String a;
    int b;
    ak c;
    long d;
    List e;
    private byte f;
    private AtomicInteger g;

    ah(ah ah1, long l)
    {
        this(ah1.a, ah1.f, l);
        c = ah1.c;
        d = ah1.d;
    }

    ah(String s, byte byte0, long l)
    {
        e = new ArrayList();
        g = new AtomicInteger(0);
        b = g.incrementAndGet();
        a = s;
        f = byte0;
        e.add(new x((byte)1, l));
    }

    final long a()
    {
        return ((x)e.get(0)).b;
    }

    final void a(x x1)
    {
        e.add(x1);
    }

    final void a(DataOutput dataoutput)
    {
        dataoutput.writeShort(b);
        dataoutput.writeUTF(a);
        dataoutput.writeByte(f);
        if (c == null)
        {
            dataoutput.writeLong(0L);
            dataoutput.writeLong(0L);
            dataoutput.writeByte(0);
        } else
        {
            dataoutput.writeLong(c.a);
            dataoutput.writeLong(c.e);
            byte abyte0[] = c.g;
            dataoutput.writeByte(abyte0.length);
            dataoutput.write(abyte0);
        }
        dataoutput.writeShort(e.size());
        x x1;
        for (Iterator iterator = e.iterator(); iterator.hasNext(); dataoutput.writeLong(x1.b))
        {
            x1 = (x)iterator.next();
            dataoutput.writeByte(x1.a);
        }

    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder("{hook: ")).append(a).append(", ad: ").append(c.d).append(", transitions: [").toString());
        for (Iterator iterator = e.iterator(); iterator.hasNext(); stringbuilder.append(","))
        {
            stringbuilder.append((x)iterator.next());
        }

        stringbuilder.append("]}");
        return stringbuilder.toString();
    }
}
