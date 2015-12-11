// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.i;
import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package b.a.a.e:
//            c, d, g

final class f extends i
{

    private final long d[];
    private final int e[];
    private final int f[];
    private final String g[];
    private final d h;

    private f(String s, long al[], int ai[], int ai1[], String as[], d d1)
    {
        super(s);
        d = al;
        e = ai;
        f = ai1;
        g = as;
        h = d1;
    }

    static f a(DataInput datainput, String s)
    {
        Object obj;
        long al[];
        int ai[];
        int ai1[];
        String as[];
        int k;
        int i1;
        int j1;
        i1 = datainput.readUnsignedShort();
        obj = new String[i1];
        for (int j = 0; j < i1; j++)
        {
            obj[j] = datainput.readUTF();
        }

        j1 = datainput.readInt();
        al = new long[j1];
        ai = new int[j1];
        ai1 = new int[j1];
        as = new String[j1];
        k = 0;
_L2:
        int l;
        if (k >= j1)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        al[k] = b.a.a.e.c.a(datainput);
        ai[k] = (int)b.a.a.e.c.a(datainput);
        ai1[k] = (int)b.a.a.e.c.a(datainput);
        if (i1 < 256)
        {
            try
            {
                l = datainput.readUnsignedByte();
            }
            // Misplaced declaration of an exception variable
            catch (DataInput datainput)
            {
                throw new IOException("Invalid encoding");
            }
            break MISSING_BLOCK_LABEL_204;
        }
        l = datainput.readUnsignedShort();
        break MISSING_BLOCK_LABEL_204;
        obj = null;
        if (datainput.readBoolean())
        {
            obj = new d(s, (int)b.a.a.e.c.a(datainput), b.a.a.e.g.a(datainput), b.a.a.e.g.a(datainput));
        }
        return new f(s, al, ai, ai1, as, ((d) (obj)));
        as[k] = obj[l];
        k++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String a(long l)
    {
        long al[] = d;
        int j = Arrays.binarySearch(al, l);
        if (j >= 0)
        {
            return g[j];
        }
        j = ~j;
        if (j < al.length)
        {
            if (j > 0)
            {
                return g[j - 1];
            } else
            {
                return "UTC";
            }
        }
        if (h == null)
        {
            return g[j - 1];
        } else
        {
            return h.a(l);
        }
    }

    public final int b(long l)
    {
        long al[] = d;
        int j = Arrays.binarySearch(al, l);
        if (j >= 0)
        {
            return e[j];
        }
        j = ~j;
        if (j < al.length)
        {
            if (j > 0)
            {
                return e[j - 1];
            } else
            {
                return 0;
            }
        }
        if (h == null)
        {
            return e[j - 1];
        } else
        {
            return h.b(l);
        }
    }

    public final boolean c()
    {
        return false;
    }

    public final long e(long l)
    {
        long al[] = d;
        int j = Arrays.binarySearch(al, l);
        long l1;
        if (j >= 0)
        {
            j++;
        } else
        {
            j = ~j;
        }
        if (j < al.length)
        {
            l1 = al[j];
        } else
        {
            l1 = l;
            if (h != null)
            {
                long l3 = al[al.length - 1];
                long l2 = l;
                if (l < l3)
                {
                    l2 = l3;
                }
                return h.e(l2);
            }
        }
        return l1;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof f))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = (f)obj;
        if (!super.c.equals(((i) (obj)).c) || !Arrays.equals(d, ((f) (obj)).d) || !Arrays.equals(g, ((f) (obj)).g) || !Arrays.equals(e, ((f) (obj)).e) || !Arrays.equals(f, ((f) (obj)).f))
        {
            break; /* Loop/switch isn't completed */
        }
        if (h != null) goto _L4; else goto _L3
_L3:
        if (((f) (obj)).h == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (!h.equals(((f) (obj)).h)) goto _L5; else goto _L6
_L6:
        return true;
        return false;
    }

    public final long f(long l)
    {
        long al[];
        int j;
        al = d;
        j = Arrays.binarySearch(al, l);
        if (j < 0) goto _L2; else goto _L1
_L1:
        long l1;
        l1 = l;
        if (l > 0x8000000000000000L)
        {
            l1 = l - 1L;
        }
_L4:
        return l1;
_L2:
        j = ~j;
        if (j >= al.length)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = l;
        if (j > 0)
        {
            long l2 = al[j - 1];
            l1 = l;
            if (l2 > 0x8000000000000000L)
            {
                return l2 - 1L;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (h != null)
        {
            l1 = h.f(l);
            if (l1 < l)
            {
                return l1;
            }
        }
        long l3 = al[j - 1];
        l1 = l;
        if (l3 > 0x8000000000000000L)
        {
            return l3 - 1L;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }
}
