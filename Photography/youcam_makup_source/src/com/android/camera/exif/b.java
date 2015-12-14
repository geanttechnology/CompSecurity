// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.android.camera.exif:
//            k, j

class b
{

    private static final byte a[] = {
        65, 83, 67, 73, 73, 0, 0, 0
    };
    private static final byte b[] = {
        74, 73, 83, 0, 0, 0, 0, 0
    };
    private static final byte c[] = {
        85, 78, 73, 67, 79, 68, 69, 0
    };
    private final k d[] = new k[5];
    private byte e[];
    private ArrayList f;
    private final ByteOrder g;

    b(ByteOrder byteorder)
    {
        f = new ArrayList();
        g = byteorder;
    }

    protected j a(j j1)
    {
        if (j1 != null)
        {
            return a(j1, j1.a());
        } else
        {
            return null;
        }
    }

    protected j a(j j1, int i)
    {
        if (j1 != null && j.a(i))
        {
            return c(i).a(j1);
        } else
        {
            return null;
        }
    }

    protected j a(short word0, int i)
    {
        k k1 = d[i];
        if (k1 == null)
        {
            return null;
        } else
        {
            return k1.a(word0);
        }
    }

    protected void a(int i, byte abyte0[])
    {
        if (i < f.size())
        {
            f.set(i, abyte0);
            return;
        }
        for (int l = f.size(); l < i; l++)
        {
            f.add(null);
        }

        f.add(abyte0);
    }

    protected void a(k k1)
    {
        d[k1.c()] = k1;
    }

    protected void a(byte abyte0[])
    {
        e = abyte0;
    }

    protected byte[] a()
    {
        return e;
    }

    protected byte[] a(int i)
    {
        return (byte[])f.get(i);
    }

    protected k b(int i)
    {
        if (j.a(i))
        {
            return d[i];
        } else
        {
            return null;
        }
    }

    protected void b(short word0, int i)
    {
        k k1 = d[i];
        if (k1 == null)
        {
            return;
        } else
        {
            k1.b(word0);
            return;
        }
    }

    protected boolean b()
    {
        return e != null;
    }

    protected int c()
    {
        return f.size();
    }

    protected k c(int i)
    {
        k k2 = d[i];
        k k1 = k2;
        if (k2 == null)
        {
            k1 = new k(i);
            d[i] = k1;
        }
        return k1;
    }

    protected boolean d()
    {
        return f.size() != 0;
    }

    protected ByteOrder e()
    {
        return g;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (!(obj instanceof b)) goto _L4; else goto _L5
_L5:
        obj = (b)obj;
        flag = flag1;
        if (((b) (obj)).g != g) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (((b) (obj)).f.size() != f.size()) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (!Arrays.equals(((b) (obj)).e, e)) goto _L4; else goto _L8
_L8:
        int i = 0;
_L10:
        if (i >= f.size())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        flag = flag1;
        if (!Arrays.equals((byte[])((b) (obj)).f.get(i), (byte[])f.get(i))) goto _L4; else goto _L9
_L9:
        i++;
          goto _L10
        i = 0;
_L14:
        if (i >= 5) goto _L12; else goto _L11
_L11:
        k k1;
        k k2;
        k1 = ((b) (obj)).b(i);
        k2 = b(i);
        if (k1 == k2 || k1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!k1.equals(k2)) goto _L4; else goto _L13
_L13:
        i++;
          goto _L14
_L12:
        return true;
    }

    protected List f()
    {
        ArrayList arraylist1 = new ArrayList();
        k ak[] = d;
        int i1 = ak.length;
        for (int i = 0; i < i1; i++)
        {
            k k1 = ak[i];
            if (k1 == null)
            {
                continue;
            }
            j aj[] = k1.b();
            if (aj == null)
            {
                continue;
            }
            int j1 = aj.length;
            for (int l = 0; l < j1; l++)
            {
                arraylist1.add(aj[l]);
            }

        }

        ArrayList arraylist = arraylist1;
        if (arraylist1.size() == 0)
        {
            arraylist = null;
        }
        return arraylist;
    }

}
