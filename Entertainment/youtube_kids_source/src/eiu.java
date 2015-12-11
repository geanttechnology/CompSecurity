// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class eiu extends ehr
    implements Set
{

    private static final int a = (int)Math.floor(751619276.79999995D);

    eiu()
    {
    }

    private static int a(int i)
    {
        int k;
        if (i < a)
        {
            int j = Integer.highestOneBit(i - 1) << 1;
            do
            {
                k = j;
                if ((double)j * 0.69999999999999996D >= (double)i)
                {
                    break;
                }
                j <<= 1;
            } while (true);
        } else
        {
            boolean flag;
            if (i < 0x40000000)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.a(flag, "collection too large");
            k = 0x40000000;
        }
        return k;
    }

    private static transient eiu a(int i, Object aobj[])
    {
        int k = i;
_L13:
        k;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 136
    //                   1 140;
           goto _L1 _L2 _L3
_L1:
        Object aobj2[];
        int j;
        int l;
        int j1;
        int k1;
        j1 = a(k);
        aobj2 = new Object[j1];
        k1 = j1 - 1;
        l = 0;
        i = 0;
        j = 0;
_L8:
        if (l >= k) goto _L5; else goto _L4
_L4:
        Object obj;
        int i1;
        int l1;
        obj = eka.a(aobj[l], l);
        l1 = obj.hashCode();
        i1 = ehl.a(l1);
_L11:
        Object obj1;
        int i2;
        i2 = i1 & k1;
        obj1 = aobj2[i2];
        if (obj1 != null) goto _L7; else goto _L6
_L6:
        i1 = i + 1;
        aobj[i] = obj;
        aobj2[i2] = obj;
        j += l1;
        i = i1;
_L10:
        l++;
          goto _L8
_L2:
        return ehg.a;
_L3:
        return b(aobj[0]);
_L7:
        if (obj1.equals(obj)) goto _L10; else goto _L9
_L9:
        i1++;
          goto _L11
_L5:
        Arrays.fill(aobj, i, k, null);
        if (i == 1)
        {
            return new ekz(aobj[0], j);
        }
        if (j1 == a(i))
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        if (true) goto _L13; else goto _L12
_L12:
        Object aobj1[] = aobj;
        if (i < aobj.length)
        {
            aobj1 = eka.b(aobj, i);
        }
        return new ekr(aobj1, j, aobj2, k1);
    }

    public static eiu a(Object aobj[])
    {
        switch (aobj.length)
        {
        default:
            return a(aobj.length, (Object[])((Object []) (aobj)).clone());

        case 0: // '\0'
            return ehg.a;

        case 1: // '\001'
            return b(aobj[0]);
        }
    }

    public static eiu b(Object obj)
    {
        return new ekz(obj);
    }

    public static eiu g()
    {
        return ehg.a;
    }

    public abstract elm b();

    boolean d()
    {
        return false;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if ((obj instanceof eiu) && d() && ((eiu)obj).d() && hashCode() != obj.hashCode())
        {
            return false;
        } else
        {
            return a.a(this, obj);
        }
    }

    public int hashCode()
    {
        return a.c(this);
    }

    public Iterator iterator()
    {
        return b();
    }

    Object writeReplace()
    {
        return new eix(toArray());
    }

}
