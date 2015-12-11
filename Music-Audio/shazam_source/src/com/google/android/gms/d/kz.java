// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            kv, kx, le, lc

final class kz
    implements Cloneable
{

    List a;
    private kx b;
    private Object c;

    kz()
    {
        a = new ArrayList();
    }

    private byte[] c()
    {
        byte abyte0[] = new byte[a()];
        a(kv.a(abyte0, abyte0.length));
        return abyte0;
    }

    final int a()
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        int j = b.a(c);
_L4:
        return j;
_L2:
        Iterator iterator = a.iterator();
        int i = 0;
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                continue;
            }
            le le1 = (le)iterator.next();
            j = kv.e(le1.a);
            i = le1.b.length + (j + 0) + i;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void a(kv kv1)
    {
        if (c != null)
        {
            b.a(c, kv1);
        } else
        {
            Iterator iterator = a.iterator();
            while (iterator.hasNext()) 
            {
                le le1 = (le)iterator.next();
                kv1.d(le1.a);
                kv1.a(le1.b);
            }
        }
    }

    public final kz b()
    {
        Object obj;
        int i;
        i = 0;
        obj = new kz();
        obj.b = b;
        if (a != null) goto _L2; else goto _L1
_L1:
        obj.a = null;
_L7:
        if (c == null) goto _L4; else goto _L3
_L3:
        if (!(c instanceof lc)) goto _L6; else goto _L5
_L5:
        obj.c = ((lc)c).d();
        return ((kz) (obj));
_L2:
        try
        {
            ((kz) (obj)).a.addAll(a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
          goto _L7
_L6:
        if (!(c instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj.c = ((byte[])(byte[])c).clone();
        return ((kz) (obj));
        if (!(c instanceof byte[][])) goto _L9; else goto _L8
_L8:
        Object obj1;
        Object obj2;
        obj1 = (byte[][])(byte[][])c;
        obj2 = new byte[obj1.length][];
        obj.c = obj2;
        i = 0;
_L10:
        if (i >= obj1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2[i] = (byte[])obj1[i].clone();
        i++;
        if (true) goto _L10; else goto _L4
_L9:
        if (!(c instanceof boolean[]))
        {
            break MISSING_BLOCK_LABEL_214;
        }
        obj.c = ((boolean[])(boolean[])c).clone();
        return ((kz) (obj));
        if (!(c instanceof int[]))
        {
            break MISSING_BLOCK_LABEL_243;
        }
        obj.c = ((int[])(int[])c).clone();
        return ((kz) (obj));
        if (!(c instanceof long[]))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        obj.c = ((long[])(long[])c).clone();
        return ((kz) (obj));
        if (!(c instanceof float[]))
        {
            break MISSING_BLOCK_LABEL_301;
        }
        obj.c = ((float[])(float[])c).clone();
        return ((kz) (obj));
        if (!(c instanceof double[]))
        {
            break MISSING_BLOCK_LABEL_330;
        }
        obj.c = ((double[])(double[])c).clone();
        return ((kz) (obj));
        if (!(c instanceof lc[])) goto _L4; else goto _L11
_L11:
        obj1 = (lc[])(lc[])c;
        obj2 = new lc[obj1.length];
        obj.c = obj2;
_L13:
        if (i >= obj1.length) goto _L4; else goto _L12
_L12:
        obj2[i] = obj1[i].d();
        i++;
          goto _L13
_L4:
        return ((kz) (obj));
    }

    public final Object clone()
    {
        return b();
    }

    public final boolean equals(Object obj)
    {
        boolean flag2 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag2;
            if (obj instanceof kz)
            {
                obj = (kz)obj;
                if (c != null && ((kz) (obj)).c != null)
                {
                    flag = flag2;
                    if (b == ((kz) (obj)).b)
                    {
                        if (!b.b.isArray())
                        {
                            return c.equals(((kz) (obj)).c);
                        }
                        if (c instanceof byte[])
                        {
                            return Arrays.equals((byte[])(byte[])c, (byte[])(byte[])((kz) (obj)).c);
                        }
                        if (c instanceof int[])
                        {
                            return Arrays.equals((int[])(int[])c, (int[])(int[])((kz) (obj)).c);
                        }
                        if (c instanceof long[])
                        {
                            return Arrays.equals((long[])(long[])c, (long[])(long[])((kz) (obj)).c);
                        }
                        if (c instanceof float[])
                        {
                            return Arrays.equals((float[])(float[])c, (float[])(float[])((kz) (obj)).c);
                        }
                        if (c instanceof double[])
                        {
                            return Arrays.equals((double[])(double[])c, (double[])(double[])((kz) (obj)).c);
                        }
                        if (c instanceof boolean[])
                        {
                            return Arrays.equals((boolean[])(boolean[])c, (boolean[])(boolean[])((kz) (obj)).c);
                        } else
                        {
                            return Arrays.deepEquals((Object[])(Object[])c, (Object[])(Object[])((kz) (obj)).c);
                        }
                    }
                } else
                {
                    if (a != null && ((kz) (obj)).a != null)
                    {
                        return a.equals(((kz) (obj)).a);
                    }
                    boolean flag1;
                    try
                    {
                        flag1 = Arrays.equals(c(), ((kz) (obj)).c());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new IllegalStateException(((Throwable) (obj)));
                    }
                    return flag1;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = Arrays.hashCode(c());
        }
        catch (IOException ioexception)
        {
            throw new IllegalStateException(ioexception);
        }
        return i + 527;
    }
}
