// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

// Referenced classes of package net.tsz.afinal.core:
//            Arrays

private static class a extends AbstractList
    implements List, Serializable, RandomAccess
{

    private static final long serialVersionUID = 0xd9a43cbecd8806d2L;
    private final Object a[];

    public boolean contains(Object obj)
    {
        boolean flag1 = true;
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object aobj[];
        int i;
        int j;
        aobj = a;
        j = aobj.length;
        i = 0;
_L7:
        if (i < j) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        return flag;
_L4:
        flag = flag1;
        if (obj.equals(aobj[i])) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L2:
        obj = ((Object) (a));
        j = obj.length;
        i = 0;
_L10:
        if (i >= j) goto _L3; else goto _L8
_L8:
        flag = flag1;
        if (obj[i] == null) goto _L6; else goto _L9
_L9:
        i++;
          goto _L10
    }

    public Object get(int i)
    {
        Object obj;
        try
        {
            obj = a[i];
        }
        catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
        {
            throw arrayindexoutofboundsexception;
        }
        return obj;
    }

    public int indexOf(Object obj)
    {
        int i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        i = 0;
_L3:
        if (i < a.length) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (obj.equals(a[i]))
        {
            return i;
        }
        i++;
          goto _L3
        int j = 0;
        while (j < a.length) 
        {
            if (a[j] == null)
            {
                return j;
            }
            j++;
        }
          goto _L1
    }

    public int lastIndexOf(Object obj)
    {
        int i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        i = a.length - 1;
_L3:
        if (i >= 0) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (obj.equals(a[i]))
        {
            return i;
        }
        i--;
          goto _L3
        int j = a.length - 1;
        while (j >= 0) 
        {
            if (a[j] == null)
            {
                return j;
            }
            j--;
        }
          goto _L1
    }

    public Object set(int i, Object obj)
    {
        Object obj1 = a[i];
        a[i] = obj;
        return obj1;
    }

    public int size()
    {
        return a.length;
    }

    public Object[] toArray()
    {
        return (Object[])((Object []) (a)).clone();
    }

    public Object[] toArray(Object aobj[])
    {
        int i = size();
        Object aobj1[] = aobj;
        if (i > aobj.length)
        {
            aobj1 = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i);
        }
        System.arraycopy(((Object) (a)), 0, ((Object) (aobj1)), 0, i);
        if (i < aobj1.length)
        {
            aobj1[i] = null;
        }
        return aobj1;
    }

    ion(Object aobj[])
    {
        if (aobj == null)
        {
            throw new NullPointerException();
        } else
        {
            a = aobj;
            return;
        }
    }
}
