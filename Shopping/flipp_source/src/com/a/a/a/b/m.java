// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.u;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.InflaterInputStream;

// Referenced classes of package com.a.a.a.b:
//            b, n, o, k, 
//            c, a

final class m
    implements b
{

    final DataInputStream a;
    int b;
    private final DataInputStream c = new DataInputStream(new InflaterInputStream(new n(this), new o(this)));
    private final boolean d;

    m(InputStream inputstream, boolean flag)
    {
        a = new DataInputStream(inputstream);
        d = flag;
    }

    private static transient IOException a(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    private String a()
    {
        int i = c.readInt();
        byte abyte0[] = new byte[i];
        u.a(c, abyte0);
        return new String(abyte0, 0, i, "UTF-8");
    }

    private List a(int i)
    {
        boolean flag;
        int j;
        flag = false;
        b = b + i;
        try
        {
            j = c.readInt();
        }
        catch (DataFormatException dataformatexception)
        {
            throw new IOException(dataformatexception.getMessage());
        }
        if (j * 2 >= 0)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        Logger.getLogger(getClass().getName()).warning((new StringBuilder("numberOfPairs < 0: ")).append(j).toString());
        throw a("numberOfPairs < 0", new Object[0]);
        ArrayList arraylist = new ArrayList(j * 2);
        i = ((flag) ? 1 : 0);
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        String s = a();
        String s1 = a();
        if (s.length() == 0)
        {
            throw a("name.length == 0", new Object[0]);
        }
        arraylist.add(s);
        arraylist.add(s1);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (b != 0)
        {
            Logger.getLogger(getClass().getName()).warning((new StringBuilder("compressedLimit > 0: ")).append(b).toString());
        }
        return arraylist;
    }

    private void a(c c1, int i, int j)
    {
        boolean flag = true;
        int l = a.readInt();
        if (j != l * 8 + 4)
        {
            throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] {
                Integer.valueOf(j), Integer.valueOf(l)
            });
        }
        k k1 = new k();
        for (j = 0; j < l; j++)
        {
            int i1 = a.readInt();
            k1.a(i1 & 0xffffff, (0xff000000 & i1) >>> 24, a.readInt());
        }

        if ((i & 1) == 0)
        {
            flag = false;
        }
        c1.a(flag, k1);
    }

    public final boolean a(c c1)
    {
        boolean flag;
        boolean flag5;
        boolean flag7;
        boolean flag8;
        flag7 = false;
        flag8 = false;
        flag5 = false;
        flag = true;
        int i2 = a.readInt();
        int l1;
        int j2;
        j2 = a.readInt();
        int i;
        if ((0x80000000 & i2) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        l1 = (0xff000000 & j2) >>> 24;
        j2 &= 0xffffff;
        if (i == 0) goto _L2; else goto _L1
        c1;
        flag = false;
_L3:
        return flag;
_L1:
        i = (0x7fff0000 & i2) >>> 16;
        if (i != 3)
        {
            throw new ProtocolException((new StringBuilder("version != 3: ")).append(i).toString());
        }
        switch (i2 & 0xffff)
        {
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        default:
            throw new IOException("Unexpected frame");

        case 1: // '\001'
            int j = a.readInt();
            a.readInt();
            i2 = a.readShort();
            List list = a(j2 - 10);
            boolean flag1;
            if ((l1 & 1) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((l1 & 2) != 0)
            {
                flag5 = true;
            }
            c1.a(flag5, flag1, j & 0x7fffffff, (0xe000 & i2) >>> 13, i2 & 0xff, list);
            return true;

        case 2: // '\002'
            int l = a.readInt();
            List list1 = a(j2 - 4);
            boolean flag2 = flag7;
            if ((l1 & 1) != 0)
            {
                flag2 = true;
            }
            c1.a(flag2, l & 0x7fffffff, list1);
            return true;

        case 3: // '\003'
            if (j2 != 8)
            {
                throw a("TYPE_RST_STREAM length: %d != 8", new Object[] {
                    Integer.valueOf(j2)
                });
            }
            int i1 = a.readInt();
            l1 = a.readInt();
            a a1 = com.a.a.a.b.a.a(l1);
            if (a1 == null)
            {
                throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                    Integer.valueOf(l1)
                });
            } else
            {
                c1.a(i1 & 0x7fffffff, a1);
                return true;
            }

        case 4: // '\004'
            a(c1, l1, j2);
            return true;

        case 5: // '\005'
            if (j2 != 0)
            {
                throw a("TYPE_NOOP length: %d != 0", new Object[] {
                    Integer.valueOf(j2)
                });
            }
            break;

        case 6: // '\006'
            if (j2 != 4)
            {
                throw a("TYPE_PING length: %d != 4", new Object[] {
                    Integer.valueOf(j2)
                });
            }
            int j1 = a.readInt();
            boolean flag6 = d;
            boolean flag3;
            if (j1 % 2 == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag6 == flag3)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            c1.a(flag3, j1, 0);
            return true;

        case 7: // '\007'
            if (j2 != 8)
            {
                throw a("TYPE_GOAWAY length: %d != 8", new Object[] {
                    Integer.valueOf(j2)
                });
            }
            int k1 = a.readInt();
            l1 = a.readInt();
            if (com.a.a.a.b.a.c(l1) == null)
            {
                throw a("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                    Integer.valueOf(l1)
                });
            } else
            {
                c1.a(k1 & 0x7fffffff);
                return true;
            }

        case 8: // '\b'
            c1.a(a.readInt() & 0x7fffffff, a(j2 - 4));
            return true;

        case 9: // '\t'
            if (j2 != 8)
            {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] {
                    Integer.valueOf(j2)
                });
            } else
            {
                c1.a(a.readInt() & 0x7fffffff, a.readInt() & 0x7fffffff);
                return true;
            }

        case 16: // '\020'
            u.a(a, j2);
            throw new UnsupportedOperationException("TODO");
        }
        if (true) goto _L3; else goto _L2
_L2:
        boolean flag4 = flag8;
        if ((l1 & 1) != 0)
        {
            flag4 = true;
        }
        c1.a(flag4, i2 & 0x7fffffff, a, j2);
        return true;
    }

    public final void close()
    {
        u.a(a, c);
    }
}
