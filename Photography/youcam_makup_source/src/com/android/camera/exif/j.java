// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;

// Referenced classes of package com.android.camera.exif:
//            n

public class j
{

    private static Charset a = Charset.forName("US-ASCII");
    private static final int b[];
    private static final SimpleDateFormat j = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    private final short c;
    private final short d;
    private boolean e;
    private int f;
    private int g;
    private Object h;
    private int i;

    j(short word0, short word1, int i1, int j1, boolean flag)
    {
        c = word0;
        d = word1;
        f = i1;
        e = flag;
        g = j1;
        h = null;
    }

    public static boolean a(int i1)
    {
        return i1 == 0 || i1 == 1 || i1 == 2 || i1 == 3 || i1 == 4;
    }

    public static boolean a(short word0)
    {
        return word0 == 1 || word0 == 2 || word0 == 3 || word0 == 4 || word0 == 5 || word0 == 7 || word0 == 9 || word0 == 10;
    }

    public static int b(short word0)
    {
        return b[word0];
    }

    private boolean b(int ai[])
    {
        boolean flag1 = false;
        int j1 = ai.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    int k1 = ai[i1];
                    if (k1 <= 65535 && k1 >= 0)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private boolean b(long al[])
    {
        boolean flag1 = false;
        int j1 = al.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    long l1 = al[i1];
                    if (l1 >= 0L && l1 <= 0xffffffffL)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private boolean b(n an[])
    {
        boolean flag1 = false;
        int j1 = an.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    n n1 = an[i1];
                    if (n1.a() >= 0L && n1.b() >= 0L && n1.a() <= 0xffffffffL && n1.b() <= 0xffffffffL)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private static String c(short word0)
    {
        switch (word0)
        {
        case 6: // '\006'
        case 8: // '\b'
        default:
            return "";

        case 1: // '\001'
            return "UNSIGNED_BYTE";

        case 2: // '\002'
            return "ASCII";

        case 3: // '\003'
            return "UNSIGNED_SHORT";

        case 4: // '\004'
            return "UNSIGNED_LONG";

        case 5: // '\005'
            return "UNSIGNED_RATIONAL";

        case 7: // '\007'
            return "UNDEFINED";

        case 9: // '\t'
            return "LONG";

        case 10: // '\n'
            return "RATIONAL";
        }
    }

    private boolean c(int ai[])
    {
        boolean flag1 = false;
        int j1 = ai.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (ai[i1] >= 0)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private boolean c(n an[])
    {
        boolean flag1 = false;
        int j1 = an.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    n n1 = an[i1];
                    if (n1.a() >= 0xffffffff80000000L && n1.b() >= 0xffffffff80000000L && n1.a() <= 0x7fffffffL && n1.b() <= 0x7fffffffL)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private boolean h(int i1)
    {
        return e && f != i1;
    }

    public int a()
    {
        return g;
    }

    protected void a(boolean flag)
    {
        e = flag;
    }

    public boolean a(byte byte0)
    {
        return a(new byte[] {
            byte0
        });
    }

    public boolean a(long l1)
    {
        return a(new long[] {
            l1
        });
    }

    public boolean a(n n1)
    {
        return a(new n[] {
            n1
        });
    }

    public boolean a(Object obj)
    {
        int i1 = 0;
        if (obj != null)
        {
            if (obj instanceof Short)
            {
                return d(((Short)obj).shortValue() & 0xffff);
            }
            if (obj instanceof String)
            {
                return a((String)obj);
            }
            if (obj instanceof int[])
            {
                return a((int[])(int[])obj);
            }
            if (obj instanceof long[])
            {
                return a((long[])(long[])obj);
            }
            if (obj instanceof n)
            {
                return a((n)obj);
            }
            if (obj instanceof n[])
            {
                return a((n[])(n[])obj);
            }
            if (obj instanceof byte[])
            {
                return a((byte[])(byte[])obj);
            }
            if (obj instanceof Integer)
            {
                return d(((Integer)obj).intValue());
            }
            if (obj instanceof Long)
            {
                return a(((Long)obj).longValue());
            }
            if (obj instanceof Byte)
            {
                return a(((Byte)obj).byteValue());
            }
            if (obj instanceof Short[])
            {
                obj = (Short[])(Short[])obj;
                int ai[] = new int[obj.length];
                i1 = 0;
                while (i1 < obj.length) 
                {
                    int k1;
                    if (obj[i1] == null)
                    {
                        k1 = 0;
                    } else
                    {
                        k1 = obj[i1].shortValue() & 0xffff;
                    }
                    ai[i1] = k1;
                    i1++;
                }
                return a(ai);
            }
            if (obj instanceof Integer[])
            {
                obj = (Integer[])(Integer[])obj;
                int ai1[] = new int[obj.length];
                i1 = 0;
                while (i1 < obj.length) 
                {
                    int l1;
                    if (obj[i1] == null)
                    {
                        l1 = 0;
                    } else
                    {
                        l1 = obj[i1].intValue();
                    }
                    ai1[i1] = l1;
                    i1++;
                }
                return a(ai1);
            }
            if (obj instanceof Long[])
            {
                obj = (Long[])(Long[])obj;
                long al[] = new long[obj.length];
                while (i1 < obj.length) 
                {
                    long l2;
                    if (obj[i1] == null)
                    {
                        l2 = 0L;
                    } else
                    {
                        l2 = obj[i1].longValue();
                    }
                    al[i1] = l2;
                    i1++;
                }
                return a(al);
            }
            if (obj instanceof Byte[])
            {
                obj = (Byte[])(Byte[])obj;
                byte abyte0[] = new byte[obj.length];
                int j1 = 0;
                while (j1 < obj.length) 
                {
                    byte byte0;
                    if (obj[j1] == null)
                    {
                        byte0 = 0;
                    } else
                    {
                        byte0 = obj[j1].byteValue();
                    }
                    abyte0[j1] = byte0;
                    j1++;
                }
                return a(abyte0);
            }
        }
        return false;
    }

    public boolean a(String s)
    {
        if (d != 2 && d != 7)
        {
            return false;
        }
        byte abyte0[] = s.getBytes(a);
        int i1;
        if (abyte0.length > 0)
        {
            s = abyte0;
            if (abyte0[abyte0.length - 1] != 0)
            {
                if (d == 7)
                {
                    s = abyte0;
                } else
                {
                    s = Arrays.copyOf(abyte0, abyte0.length + 1);
                }
            }
        } else
        {
            s = abyte0;
            if (d == 2)
            {
                s = abyte0;
                if (f == 1)
                {
                    s = new byte[1];
                    s[0] = 0;
                }
            }
        }
        i1 = s.length;
        if (h(i1))
        {
            return false;
        } else
        {
            f = i1;
            h = s;
            return true;
        }
    }

    public boolean a(byte abyte0[])
    {
        return a(abyte0, 0, abyte0.length);
    }

    public boolean a(byte abyte0[], int i1, int j1)
    {
        while (h(j1) || d != 1 && d != 7) 
        {
            return false;
        }
        h = new byte[j1];
        System.arraycopy(abyte0, i1, h, 0, j1);
        f = j1;
        return true;
    }

    public boolean a(int ai[])
    {
        int i1;
        for (i1 = 0; h(ai.length) || d != 3 && d != 9 && d != 4 || d == 3 && b(ai) || d == 4 && c(ai);)
        {
            return false;
        }

        long al[] = new long[ai.length];
        for (; i1 < ai.length; i1++)
        {
            al[i1] = ai[i1];
        }

        h = al;
        f = ai.length;
        return true;
    }

    public boolean a(long al[])
    {
        while (h(al.length) || d != 4 || b(al)) 
        {
            return false;
        }
        h = al;
        f = al.length;
        return true;
    }

    public boolean a(n an[])
    {
        while (h(an.length) || d != 5 && d != 10 || d == 5 && b(an) || d == 10 && c(an)) 
        {
            return false;
        }
        h = an;
        f = an.length;
        return true;
    }

    public short b()
    {
        return c;
    }

    protected void b(int i1)
    {
        g = i1;
    }

    protected void b(byte abyte0[])
    {
        b(abyte0, 0, abyte0.length);
    }

    protected void b(byte abyte0[], int i1, int j1)
    {
        if (d != 7 && d != 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get BYTE value from ").append(c(d)).toString());
        }
        Object obj = h;
        int k1 = j1;
        if (j1 > f)
        {
            k1 = f;
        }
        System.arraycopy(obj, 0, abyte0, i1, k1);
    }

    public short c()
    {
        return d;
    }

    protected void c(int i1)
    {
        f = i1;
    }

    public int d()
    {
        return e() * b(c());
    }

    public boolean d(int i1)
    {
        return a(new int[] {
            i1
        });
    }

    public int e()
    {
        return f;
    }

    protected long e(int i1)
    {
        if (h instanceof long[])
        {
            return ((long[])(long[])h)[i1];
        }
        if (h instanceof byte[])
        {
            return (long)((byte[])(byte[])h)[i1];
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get integer value from ").append(c(d)).toString());
        }
    }

    public boolean equals(Object obj)
    {
_L2:
        return false;
        if (obj == null || !(obj instanceof j)) goto _L2; else goto _L1
_L1:
        obj = (j)obj;
        if (((j) (obj)).c != c || ((j) (obj)).f != f || ((j) (obj)).d != d)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (h == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((j) (obj)).h == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(h instanceof long[]))
        {
            break; /* Loop/switch isn't completed */
        }
        if (((j) (obj)).h instanceof long[])
        {
            return Arrays.equals((long[])(long[])h, (long[])(long[])((j) (obj)).h);
        }
        if (true) goto _L2; else goto _L3
_L3:
        if (!(h instanceof n[]))
        {
            break; /* Loop/switch isn't completed */
        }
        if (((j) (obj)).h instanceof n[])
        {
            return Arrays.equals((n[])(n[])h, (n[])(n[])((j) (obj)).h);
        }
        if (true) goto _L2; else goto _L4
_L4:
        if (h instanceof byte[])
        {
            if (((j) (obj)).h instanceof byte[])
            {
                return Arrays.equals((byte[])(byte[])h, (byte[])(byte[])((j) (obj)).h);
            }
        } else
        {
            return h.equals(((j) (obj)).h);
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (((j) (obj)).h != null) goto _L2; else goto _L6
_L6:
        return true;
    }

    protected n f(int i1)
    {
        if (d != 10 && d != 5)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get RATIONAL value from ").append(c(d)).toString());
        } else
        {
            return ((n[])(n[])h)[i1];
        }
    }

    public boolean f()
    {
        return h != null;
    }

    protected void g(int i1)
    {
        i = i1;
    }

    public int[] g()
    {
        while (h == null || !(h instanceof long[])) 
        {
            return null;
        }
        long al[] = (long[])(long[])h;
        int ai[] = new int[al.length];
        for (int i1 = 0; i1 < al.length; i1++)
        {
            ai[i1] = (int)al[i1];
        }

        return ai;
    }

    public Object h()
    {
        return h;
    }

    public String i()
    {
        if (h == null)
        {
            return "";
        }
        if (h instanceof byte[])
        {
            if (d == 2)
            {
                return new String((byte[])(byte[])h, a);
            } else
            {
                return Arrays.toString((byte[])(byte[])h);
            }
        }
        if (h instanceof long[])
        {
            if (((long[])(long[])h).length == 1)
            {
                return String.valueOf(((long[])(long[])h)[0]);
            } else
            {
                return Arrays.toString((long[])(long[])h);
            }
        }
        if (h instanceof Object[])
        {
            if (((Object[])(Object[])h).length == 1)
            {
                Object obj = ((Object[])(Object[])h)[0];
                if (obj == null)
                {
                    return "";
                } else
                {
                    return obj.toString();
                }
            } else
            {
                return Arrays.toString((Object[])(Object[])h);
            }
        } else
        {
            return h.toString();
        }
    }

    protected byte[] j()
    {
        return (byte[])(byte[])h;
    }

    protected int k()
    {
        return i;
    }

    protected boolean l()
    {
        return e;
    }

    public String toString()
    {
        return (new StringBuilder()).append(String.format("tag id: %04X\n", new Object[] {
            Short.valueOf(c)
        })).append("ifd id: ").append(g).append("\ntype: ").append(c(d)).append("\ncount: ").append(f).append("\noffset: ").append(i).append("\nvalue: ").append(i()).append("\n").toString();
    }

    static 
    {
        b = new int[11];
        b[1] = 1;
        b[2] = 1;
        b[3] = 2;
        b[4] = 4;
        b[5] = 8;
        b[7] = 1;
        b[9] = 4;
        b[10] = 8;
    }
}
