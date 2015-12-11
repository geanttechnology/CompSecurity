// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.io.Serializable;
import java.util.Random;

// Referenced classes of package com.google.a.b:
//            m, g

final class i extends m
    implements g, Serializable
{

    public i()
    {
    }

    private long d()
    {
        long l = e;
        m.a aa[] = d;
        long l1 = l;
        if (aa != null)
        {
            int k = aa.length;
            int j = 0;
            do
            {
                l1 = l;
                if (j >= k)
                {
                    break;
                }
                m.a a1 = aa[j];
                l1 = l;
                if (a1 != null)
                {
                    l1 = l + a1.a;
                }
                j++;
                l = l1;
            } while (true);
        }
        return l1;
    }

    final long a(long l, long l1)
    {
        return l + l1;
    }

    public final void a()
    {
        a(1L);
    }

    public final void a(long l)
    {
        m.a aa[] = d;
        if (aa != null) goto _L2; else goto _L1
_L1:
        long l1 = e;
        if (b(l1, l1 + l)) goto _L3; else goto _L2
_L2:
        Object obj;
        boolean flag1;
        boolean flag2;
        flag2 = true;
        obj = (int[])a.get();
        flag1 = flag2;
        if (obj == null) goto _L5; else goto _L4
_L4:
        flag1 = flag2;
        if (aa == null) goto _L5; else goto _L6
_L6:
        int j;
        j = aa.length;
        flag1 = flag2;
        if (j <= 0) goto _L5; else goto _L7
_L7:
        m.a a1;
        a1 = aa[j - 1 & obj[0]];
        flag1 = flag2;
        if (a1 == null) goto _L5; else goto _L8
_L8:
        l1 = a1.a;
        flag1 = a1.a(l1, l1 + l);
        if (flag1) goto _L3; else goto _L5
_L5:
        Object obj1;
        int i1;
        int j1;
        boolean flag;
        int k1;
        if (obj == null)
        {
            ThreadLocal threadlocal = m.a;
            obj = new int[1];
            threadlocal.set(obj);
            int k = m.b.nextInt();
            j = k;
            if (k == 0)
            {
                j = 1;
            }
            obj[0] = j;
        } else
        {
            j = obj[0];
        }
        j1 = 0;
        i1 = j;
        j = j1;
_L17:
        threadlocal = super.d;
        if (threadlocal == null) goto _L10; else goto _L9
_L9:
        j1 = threadlocal.length;
        if (j1 <= 0) goto _L10; else goto _L11
_L11:
        obj1 = threadlocal[j1 - 1 & i1];
        if (obj1 != null) goto _L13; else goto _L12
_L12:
        if (super.f != 0) goto _L15; else goto _L14
_L14:
        threadlocal = new m.a(l);
        if (super.f != 0 || !b()) goto _L15; else goto _L16
_L16:
        flag = false;
        obj1 = super.d;
        j1 = ((flag) ? 1 : 0);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        k1 = obj1.length;
        j1 = ((flag) ? 1 : 0);
        if (k1 > 0)
        {
            k1 = k1 - 1 & i1;
            j1 = ((flag) ? 1 : 0);
            if (obj1[k1] == null)
            {
                obj1[k1] = threadlocal;
                j1 = 1;
            }
        }
        super.f = 0;
        if (j1 == 0) goto _L17; else goto _L3
_L3:
        return;
        obj;
        super.f = 0;
        throw obj;
_L15:
        j = 0;
_L18:
        i1 = i1 << 13 ^ i1;
        i1 ^= i1 >>> 17;
        i1 ^= i1 << 5;
        obj[0] = i1;
        break; /* Loop/switch isn't completed */
_L13:
label0:
        {
            if (flag1)
            {
                break label0;
            }
            flag1 = true;
        }
          goto _L18
        l1 = ((m.a) (obj1)).a;
        if (((m.a) (obj1)).a(l1, a(l1, l))) goto _L3; else goto _L19
_L19:
        if (j1 >= m.c || super.d != threadlocal)
        {
            j = 0;
        } else
        {
            if (j != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            j = 1;
        }
          goto _L18
        if (super.f != 0 || !b()) goto _L18; else goto _L20
_L20:
        if (super.d != threadlocal) goto _L22; else goto _L21
_L21:
        m.a aa1[] = new m.a[j1 << 1];
        j = 0;
        break MISSING_BLOCK_LABEL_619;
_L23:
        super.d = aa1;
_L22:
        super.f = 0;
        j = 0;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        super.f = 0;
        throw exception;
_L10:
        if (super.f != 0 || super.d != threadlocal || !b())
        {
            break MISSING_BLOCK_LABEL_593;
        }
        j1 = 0;
        if (super.d != threadlocal)
        {
            break MISSING_BLOCK_LABEL_572;
        }
        threadlocal = new m.a[2];
        threadlocal[i1 & 1] = new m.a(l);
        super.d = threadlocal;
        j1 = 1;
        super.f = 0;
        if (j1 != 0) goto _L3; else goto _L17
        exception;
        super.f = 0;
        throw exception;
        long l2 = super.e;
        if (b(l2, a(l2, l)))
        {
            return;
        }
          goto _L17
        while (j < j1) 
        {
            aa1[j] = threadlocal[j];
            j++;
        }
          goto _L23
    }

    public final double doubleValue()
    {
        return (double)d();
    }

    public final float floatValue()
    {
        return (float)d();
    }

    public final int intValue()
    {
        return (int)d();
    }

    public final long longValue()
    {
        return d();
    }

    public final String toString()
    {
        return Long.toString(d());
    }
}
