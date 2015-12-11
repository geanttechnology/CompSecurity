// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            z, o, bh, am, 
//            ac, ao, av, w, 
//            ba, be, bk

public abstract class aj extends z
    implements Set
{
    public static final class a extends z.a
    {

        public final aj a()
        {
            aj aj1 = aj.a(b, a);
            b = aj1.size();
            return aj1;
        }

        public final volatile z.a a(Object obj)
        {
            super.a(obj);
            return this;
        }

        public final volatile z.b a(Iterator iterator1)
        {
            super.a(iterator1);
            return this;
        }

        public final a b(Iterator iterator1)
        {
            super.a(iterator1);
            return this;
        }

        public final z.b b(Object obj)
        {
            super.a(obj);
            return this;
        }

        public final a c(Object obj)
        {
            super.a(obj);
            return this;
        }

        public a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
        }
    }


    aj()
    {
    }

    private static int a(int i)
    {
        int k;
        if (i < 0x2ccccccc)
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
            com.google.a.a.g.a(flag, "collection too large");
            k = 0x40000000;
        }
        return k;
    }

    static aj a(int i, Object aobj[])
    {
        return b(i, aobj);
    }

    public static aj a(Iterable iterable)
    {
        if (iterable instanceof Collection)
        {
            return a((Collection)iterable);
        }
        iterable = iterable.iterator();
        if (!iterable.hasNext())
        {
            return o.a;
        }
        Object obj = iterable.next();
        if (!iterable.hasNext())
        {
            return a(obj);
        } else
        {
            return (new a()).c(obj).b(iterable).a();
        }
    }

    public static aj a(Object obj)
    {
        return new bh(obj);
    }

    public static aj a(Collection collection)
    {
        if ((collection instanceof aj) && !(collection instanceof am))
        {
            aj aj1 = (aj)collection;
            if (!aj1.e())
            {
                return aj1;
            }
        } else
        if (collection instanceof EnumSet)
        {
            collection = EnumSet.copyOf((EnumSet)collection);
            switch (collection.size())
            {
            default:
                return new ac(collection);

            case 0: // '\0'
                return o.a;

            case 1: // '\001'
                return a(ao.a(collection));
            }
        }
        collection = ((Collection) (collection.toArray()));
        return b(collection.length, collection);
    }

    private static transient aj b(int i, Object aobj[])
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
        obj = av.a(aobj[l], l);
        l1 = obj.hashCode();
        i1 = w.a(l1);
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
        return o.a;
_L3:
        return a(aobj[0]);
_L7:
        if (obj1.equals(obj)) goto _L10; else goto _L9
_L9:
        i1++;
          goto _L11
_L5:
        Arrays.fill(aobj, i, k, null);
        if (i == 1)
        {
            return new bh(aobj[0], j);
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
            aobj1 = av.b(aobj, i);
        }
        return new ba(aobj1, j, aobj2, k1);
    }

    public static aj g()
    {
        return o.a;
    }

    public static a h()
    {
        return new a();
    }

    public abstract bk a();

    boolean d_()
    {
        return false;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if ((obj instanceof aj) && d_() && ((aj)obj).d_() && hashCode() != obj.hashCode())
        {
            return false;
        } else
        {
            return be.a(this, obj);
        }
    }

    public int hashCode()
    {
        return be.a(this);
    }

    public Iterator iterator()
    {
        return a();
    }
}
