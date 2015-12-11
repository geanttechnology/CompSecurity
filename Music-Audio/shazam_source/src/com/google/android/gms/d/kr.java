// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

// Referenced classes of package com.google.android.gms.d:
//            ks

public final class kr
{
    public static final class a
    {

        public final ks a;
        public final List b;

        public a(ks ks1, List list)
        {
            a = ks1;
            b = list;
        }
    }


    private static int a(String s, ks.a.a aa[])
    {
        int i;
        int j;
        int l;
        l = aa.length;
        i = 0;
        j = 14;
_L5:
        ks.a.a a1;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        a1 = aa[i];
        if (j != 14) goto _L2; else goto _L1
_L1:
        if (a1.a != 9 && a1.a != 2 && a1.a != 6) goto _L4; else goto _L3
_L3:
        int k = a1.a;
_L7:
        i++;
        j = k;
          goto _L5
_L4:
        k = j;
        if (a1.a == 14) goto _L7; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder("Unexpected TypedValue type: ")).append(a1.a).append(" for key ").append(s).toString());
_L2:
        k = j;
        if (a1.a == j) goto _L7; else goto _L8
_L8:
        throw new IllegalArgumentException((new StringBuilder("The ArrayList elements should all be the same type, but ArrayList with key ")).append(s).append(" contains items of type ").append(j).append(" and ").append(a1.a).toString());
        return j;
    }

    private static ks.a.a a(List list, Object obj)
    {
        ks.a.a a2;
        a2 = new ks.a.a();
        if (obj == null)
        {
            a2.a = 14;
            return a2;
        }
        a2.b = new ks.a.a.a();
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        a2.a = 2;
        a2.b.b = (String)obj;
_L8:
        return a2;
_L2:
        ArrayList arraylist;
        ks.a.a aa1[];
        int j;
        int k;
        int l;
        if (obj instanceof Integer)
        {
            a2.a = 6;
            a2.b.f = ((Integer)obj).intValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Long)
        {
            a2.a = 5;
            a2.b.e = ((Long)obj).longValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Double)
        {
            a2.a = 3;
            a2.b.c = ((Double)obj).doubleValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Float)
        {
            a2.a = 4;
            a2.b.d = ((Float)obj).floatValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Boolean)
        {
            a2.a = 8;
            a2.b.h = ((Boolean)obj).booleanValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Byte)
        {
            a2.a = 7;
            a2.b.g = ((Byte)obj).byteValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof byte[])
        {
            a2.a = 1;
            a2.b.a = (byte[])(byte[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof String[])
        {
            a2.a = 11;
            a2.b.k = (String[])(String[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof long[])
        {
            a2.a = 12;
            a2.b.l = (long[])(long[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof float[])
        {
            a2.a = 15;
            a2.b.m = (float[])(float[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Asset)
        {
            a2.a = 13;
            ks.a.a.a a1 = a2.b;
            list.add((Asset)obj);
            a1.n = list.size() - 1;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof h)
        {
            a2.a = 9;
            obj = (h)obj;
            Object obj2 = new TreeSet(((h) (obj)).a.keySet());
            ks.a aa[] = new ks.a[((TreeSet) (obj2)).size()];
            obj2 = ((TreeSet) (obj2)).iterator();
            for (int i = 0; ((Iterator) (obj2)).hasNext(); i++)
            {
                String s = (String)((Iterator) (obj2)).next();
                aa[i] = new ks.a();
                aa[i].a = s;
                aa[i].b = a(list, ((h) (obj)).a(s));
            }

            a2.b.i = aa;
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof ArrayList))
        {
            break; /* Loop/switch isn't completed */
        }
        a2.a = 10;
        arraylist = (ArrayList)obj;
        aa1 = new ks.a.a[arraylist.size()];
        obj = null;
        l = arraylist.size();
        k = 0;
        j = 14;
_L4:
        Object obj1;
        ks.a.a a3;
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_753;
        }
        obj1 = arraylist.get(k);
        a3 = a(list, obj1);
        if (a3.a != 14 && a3.a != 2 && a3.a != 6 && a3.a != 9)
        {
            throw new IllegalArgumentException((new StringBuilder("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a ")).append(obj1.getClass()).toString());
        }
        if (j != 14 || a3.a == 14)
        {
            break; /* Loop/switch isn't completed */
        }
        j = a3.a;
        obj = obj1;
_L6:
        aa1[k] = a3;
        k++;
        if (true) goto _L4; else goto _L3
_L3:
        if (a3.a == j) goto _L6; else goto _L5
_L5:
        throw new IllegalArgumentException((new StringBuilder("ArrayList elements must all be of the sameclass, but this one contains a ")).append(obj.getClass()).append(" and a ").append(obj1.getClass()).toString());
        a2.b.j = aa1;
        if (true) goto _L8; else goto _L7
_L7:
        throw new RuntimeException((new StringBuilder("newFieldValueFromValue: unexpected value ")).append(obj.getClass().getSimpleName()).toString());
    }

    public static h a(a a1)
    {
        h h1 = new h();
        ks.a aa[] = a1.a.a;
        int j = aa.length;
        for (int i = 0; i < j; i++)
        {
            ks.a a2 = aa[i];
            a(a1.b, h1, a2.a, a2.b);
        }

        return h1;
    }

    private static ArrayList a(List list, ks.a.a.a a1, int i)
    {
        ArrayList arraylist = new ArrayList(a1.j.length);
        a1 = a1.j;
        int l = a1.length;
        int j = 0;
        while (j < l) 
        {
            ks.a aa[] = a1[j];
            if (((ks.a.a) (aa)).a == 14)
            {
                arraylist.add(null);
            } else
            if (i == 9)
            {
                h h1 = new h();
                aa = ((ks.a.a) (aa)).b.i;
                int i1 = aa.length;
                for (int k = 0; k < i1; k++)
                {
                    ks.a a2 = aa[k];
                    a(list, h1, a2.a, a2.b);
                }

                arraylist.add(h1);
            } else
            if (i == 2)
            {
                arraylist.add(((ks.a.a) (aa)).b.b);
            } else
            if (i == 6)
            {
                arraylist.add(Integer.valueOf(((ks.a.a) (aa)).b.f));
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Unexpected typeOfArrayList: ")).append(i).toString());
            }
            j++;
        }
        return arraylist;
    }

    private static void a(List list, h h1, String s, ks.a.a a1)
    {
        int i = a1.a;
        if (i == 14)
        {
            h1.a(s, null);
            return;
        }
        Object obj = a1.b;
        if (i == 1)
        {
            list = ((ks.a.a.a) (obj)).a;
            h1.a.put(s, list);
            return;
        }
        if (i == 11)
        {
            list = ((ks.a.a.a) (obj)).k;
            h1.a.put(s, list);
            return;
        }
        if (i == 12)
        {
            list = ((ks.a.a.a) (obj)).l;
            h1.a.put(s, list);
            return;
        }
        if (i == 15)
        {
            list = ((ks.a.a.a) (obj)).m;
            h1.a.put(s, list);
            return;
        }
        if (i == 2)
        {
            h1.a(s, ((ks.a.a.a) (obj)).b);
            return;
        }
        if (i == 3)
        {
            double d = ((ks.a.a.a) (obj)).c;
            h1.a.put(s, Double.valueOf(d));
            return;
        }
        if (i == 4)
        {
            float f = ((ks.a.a.a) (obj)).d;
            h1.a.put(s, Float.valueOf(f));
            return;
        }
        if (i == 5)
        {
            long l = ((ks.a.a.a) (obj)).e;
            h1.a.put(s, Long.valueOf(l));
            return;
        }
        if (i == 6)
        {
            i = ((ks.a.a.a) (obj)).f;
            h1.a.put(s, Integer.valueOf(i));
            return;
        }
        if (i == 7)
        {
            byte byte0 = (byte)((ks.a.a.a) (obj)).g;
            h1.a.put(s, Byte.valueOf(byte0));
            return;
        }
        if (i == 8)
        {
            boolean flag = ((ks.a.a.a) (obj)).h;
            h1.a.put(s, Boolean.valueOf(flag));
            return;
        }
        if (i == 13)
        {
            if (list == null)
            {
                throw new RuntimeException((new StringBuilder("populateBundle: unexpected type for: ")).append(s).toString());
            } else
            {
                h1.a(s, (Asset)list.get((int)((ks.a.a.a) (obj)).n));
                return;
            }
        }
        if (i == 9)
        {
            a1 = new h();
            obj = ((ks.a.a.a) (obj)).i;
            int j = obj.length;
            for (i = 0; i < j; i++)
            {
                Object obj1 = obj[i];
                a(list, ((h) (a1)), ((ks.a) (obj1)).a, ((ks.a) (obj1)).b);
            }

            h1.a.put(s, a1);
            return;
        }
        if (i == 10)
        {
            i = a(s, ((ks.a.a.a) (obj)).j);
            list = a(list, ((ks.a.a.a) (obj)), i);
            if (i == 14)
            {
                h1.a(s, list);
                return;
            }
            if (i == 9)
            {
                h1.a.put(s, list);
                return;
            }
            if (i == 2)
            {
                h1.a(s, list);
                return;
            }
            if (i == 6)
            {
                h1.a.put(s, list);
                return;
            } else
            {
                throw new IllegalStateException((new StringBuilder("Unexpected typeOfArrayList: ")).append(i).toString());
            }
        } else
        {
            throw new RuntimeException((new StringBuilder("populateBundle: unexpected type ")).append(i).toString());
        }
    }

    public static ks.a[] a(h h1, List list)
    {
        Object obj = new TreeSet(h1.a.keySet());
        ks.a aa[] = new ks.a[((TreeSet) (obj)).size()];
        obj = ((TreeSet) (obj)).iterator();
        for (int i = 0; ((Iterator) (obj)).hasNext(); i++)
        {
            String s = (String)((Iterator) (obj)).next();
            Object obj1 = h1.a(s);
            aa[i] = new ks.a();
            aa[i].a = s;
            aa[i].b = a(list, obj1);
        }

        return aa;
    }
}
