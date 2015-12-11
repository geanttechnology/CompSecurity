// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.u;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.a.a.a.b:
//            b, c, a, k

final class f
    implements b
{

    private final DataInputStream a;

    f(InputStream inputstream)
    {
        a = new DataInputStream(inputstream);
    }

    private static transient IOException a(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    public final boolean a(c c1)
    {
        boolean flag;
        boolean flag3;
        boolean flag4;
        flag = true;
        flag4 = false;
        flag3 = false;
        int i1 = a.readInt();
        int i;
        int l;
        int i2;
        i2 = a.readInt();
        l = 0xffff & i1;
        i = (i1 & 0xff000000) >> 24;
        i2 &= 0x7fffffff;
        (0xff0000 & i1) >> 16;
        JVM INSTR tableswitch 0 9: default 112
    //                   0 129
    //                   1 112
    //                   2 160
    //                   3 209
    //                   4 293
    //                   5 126
    //                   6 390
    //                   7 475
    //                   8 112
    //                   9 586;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6 _L7 _L8 _L1 _L9
_L1:
        throw new UnsupportedOperationException("TODO");
        c1;
        flag = false;
_L6:
        return flag;
_L2:
        boolean flag1 = flag3;
        if ((i & 1) != 0)
        {
            flag1 = true;
        }
        c1.a(flag1, i2, a, l);
        return true;
_L3:
        if (l != 4)
        {
            throw a("TYPE_PRIORITY length: %d != 4", new Object[] {
                Integer.valueOf(l)
            });
        }
        if (i2 == 0)
        {
            throw a("TYPE_PRIORITY streamId == 0", new Object[0]);
        } else
        {
            a.readInt();
            return true;
        }
_L4:
        if (l != 4)
        {
            throw a("TYPE_RST_STREAM length: %d != 4", new Object[] {
                Integer.valueOf(l)
            });
        }
        if (i2 == 0)
        {
            throw a("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        i = a.readInt();
        a a1 = com.a.a.a.b.a.b(i);
        if (a1 == null)
        {
            throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                Integer.valueOf(i)
            });
        } else
        {
            c1.a(i2, a1);
            return true;
        }
_L5:
        if (l % 8 != 0)
        {
            throw a("TYPE_SETTINGS length %% 8 != 0: %s", new Object[] {
                Integer.valueOf(l)
            });
        }
        if (i2 != 0)
        {
            throw a("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        k k1 = new k();
        for (i = 0; i < l; i += 8)
        {
            k1.a(a.readInt() & 0xffffff, 0, a.readInt());
        }

        c1.a(false, k1);
        return true;
_L7:
        if (l != 8)
        {
            throw a("TYPE_PING length != 8: %s", new Object[] {
                Integer.valueOf(l)
            });
        }
        if (i2 != 0)
        {
            throw a("TYPE_PING streamId != 0", new Object[0]);
        }
        l = a.readInt();
        int j1 = a.readInt();
        boolean flag2 = flag4;
        if ((i & 1) != 0)
        {
            flag2 = true;
        }
        c1.a(flag2, l, j1);
        return true;
_L8:
        if (l < 8)
        {
            throw a("TYPE_GOAWAY length < 8: %s", new Object[] {
                Integer.valueOf(l)
            });
        }
        int j = a.readInt();
        int l1 = a.readInt();
        l -= 8;
        if (com.a.a.a.b.a.b(l1) == null)
        {
            throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                Integer.valueOf(l1)
            });
        }
        if (u.a(a, l) != (long)l)
        {
            throw new IOException("TYPE_GOAWAY opaque data was truncated");
        } else
        {
            c1.a(j);
            return true;
        }
_L9:
        c1.a(i2, a.readInt() & 0x7fffffff);
        return true;
    }

    public final void close()
    {
        a.close();
    }
}
