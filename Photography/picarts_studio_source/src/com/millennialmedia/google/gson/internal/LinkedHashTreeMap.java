// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            i, e, d, f, 
//            g

public final class LinkedHashTreeMap extends AbstractMap
    implements Serializable
{

    static final boolean $assertionsDisabled;
    private static final Comparator NATURAL_ORDER = new Comparator() {

        public final int compare(Object obj, Object obj1)
        {
            return ((Comparable)obj).compareTo((Comparable)obj1);
        }

    };
    Comparator comparator;
    private f entrySet;
    final i header;
    private g keySet;
    int modCount;
    int size;
    i table[];
    int threshold;

    public LinkedHashTreeMap()
    {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator comparator1)
    {
        size = 0;
        modCount = 0;
        if (comparator1 == null)
        {
            comparator1 = NATURAL_ORDER;
        }
        comparator = comparator1;
        header = new i();
        table = new i[16];
        threshold = table.length / 2 + table.length / 4;
    }

    private void doubleCapacity()
    {
        table = doubleCapacity(table);
        threshold = table.length / 2 + table.length / 4;
    }

    static i[] doubleCapacity(i ai[])
    {
        int i2 = ai.length;
        i ai1[] = new i[i2 * 2];
        e e1 = new e();
        d d1 = new d();
        d d2 = new d();
        int j1 = 0;
        do
        {
            while (j1 < i2) 
            {
                i i1 = ai[j1];
                if (i1 != null)
                {
                    e1.a(i1);
                    int l1 = 0;
                    int k1 = 0;
                    do
                    {
                        i j = e1.a();
                        if (j == null)
                        {
                            break;
                        }
                        if ((j.g & i2) == 0)
                        {
                            k1++;
                        } else
                        {
                            l1++;
                        }
                    } while (true);
                    i l;
                    if (k1 > 0 && l1 > 0)
                    {
                        d1.a(k1);
                        d2.a(l1);
                        e1.a(i1);
                        do
                        {
                            i k = e1.a();
                            if (k == null)
                            {
                                break;
                            }
                            if ((k.g & i2) == 0)
                            {
                                d1.a(k);
                            } else
                            {
                                d2.a(k);
                            }
                        } while (true);
                        i1 = d1.a();
                        l = d2.a();
                    } else
                    if (k1 > 0)
                    {
                        l = null;
                    } else
                    {
                        l = i1;
                        i1 = null;
                    }
                    ai1[j1] = i1;
                    ai1[j1 + i2] = l;
                }
                j1++;
            }
            return ai1;
        } while (true);
    }

    private boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    private void rebalance(i j, boolean flag)
    {
_L6:
        if (j == null) goto _L2; else goto _L1
_L1:
        i k;
        i l;
        int l1;
        int i2;
        int j2;
        k = j.b;
        l = j.c;
        i j1;
        if (k != null)
        {
            l1 = k.i;
        } else
        {
            l1 = 0;
        }
        if (l != null)
        {
            i2 = l.i;
        } else
        {
            i2 = 0;
        }
        j2 = l1 - i2;
        if (j2 != -2) goto _L4; else goto _L3
_L3:
        k = l.b;
        j1 = l.c;
        if (j1 != null)
        {
            l1 = j1.i;
        } else
        {
            l1 = 0;
        }
        if (k != null)
        {
            i2 = k.i;
        } else
        {
            i2 = 0;
        }
        l1 = i2 - l1;
        if (l1 == -1 || l1 == 0 && !flag)
        {
            rotateLeft(j);
        } else
        {
            if (!$assertionsDisabled && l1 != 1)
            {
                throw new AssertionError();
            }
            rotateRight(l);
            rotateLeft(j);
        }
        if (flag) goto _L2; else goto _L5
_L5:
        j = j.a;
          goto _L6
_L4:
        if (j2 != 2) goto _L8; else goto _L7
_L7:
        i i1 = k.b;
        i k1 = k.c;
        if (k1 != null)
        {
            l1 = k1.i;
        } else
        {
            l1 = 0;
        }
        if (i1 != null)
        {
            i2 = i1.i;
        } else
        {
            i2 = 0;
        }
        l1 = i2 - l1;
        if (l1 == 1 || l1 == 0 && !flag)
        {
            rotateRight(j);
        } else
        {
            if (!$assertionsDisabled && l1 != -1)
            {
                throw new AssertionError();
            }
            rotateLeft(k);
            rotateRight(j);
        }
        if (!flag) goto _L5; else goto _L2
_L2:
        return;
_L8:
        if (j2 == 0)
        {
            j.i = l1 + 1;
            if (flag)
            {
                return;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (!$assertionsDisabled && j2 != -1 && j2 != 1)
        {
            throw new AssertionError();
        }
        j.i = Math.max(l1, i2) + 1;
        if (!flag) goto _L2; else goto _L5
    }

    private void replaceInParent(i j, i k)
    {
        i l = j.a;
        j.a = null;
        if (k != null)
        {
            k.a = l;
        }
        if (l != null)
        {
            if (l.b == j)
            {
                l.b = k;
                return;
            }
            if (!$assertionsDisabled && l.c != j)
            {
                throw new AssertionError();
            } else
            {
                l.c = k;
                return;
            }
        } else
        {
            int i1 = j.g;
            int j1 = table.length;
            table[i1 & j1 - 1] = k;
            return;
        }
    }

    private void rotateLeft(i j)
    {
        boolean flag = false;
        i k = j.b;
        i l = j.c;
        i i1 = l.b;
        i j1 = l.c;
        j.c = i1;
        if (i1 != null)
        {
            i1.a = j;
        }
        replaceInParent(j, l);
        l.b = j;
        j.a = l;
        int k1;
        int l1;
        if (k != null)
        {
            k1 = k.i;
        } else
        {
            k1 = 0;
        }
        if (i1 != null)
        {
            l1 = i1.i;
        } else
        {
            l1 = 0;
        }
        j.i = Math.max(k1, l1) + 1;
        l1 = j.i;
        k1 = ((flag) ? 1 : 0);
        if (j1 != null)
        {
            k1 = j1.i;
        }
        l.i = Math.max(l1, k1) + 1;
    }

    private void rotateRight(i j)
    {
        boolean flag = false;
        i k = j.b;
        i l = j.c;
        i i1 = k.b;
        i j1 = k.c;
        j.b = j1;
        if (j1 != null)
        {
            j1.a = j;
        }
        replaceInParent(j, k);
        k.c = j;
        j.a = k;
        int k1;
        int l1;
        if (l != null)
        {
            k1 = l.i;
        } else
        {
            k1 = 0;
        }
        if (j1 != null)
        {
            l1 = j1.i;
        } else
        {
            l1 = 0;
        }
        j.i = Math.max(k1, l1) + 1;
        l1 = j.i;
        k1 = ((flag) ? 1 : 0);
        if (i1 != null)
        {
            k1 = i1.i;
        }
        k.i = Math.max(l1, k1) + 1;
    }

    private static int secondaryHash(int j)
    {
        j = j >>> 20 ^ j >>> 12 ^ j;
        return j >>> 4 ^ (j >>> 7 ^ j);
    }

    private Object writeReplace()
    {
        return new LinkedHashMap(this);
    }

    public final void clear()
    {
        Arrays.fill(table, null);
        size = 0;
        modCount = modCount + 1;
        i l = header;
        i k;
        for (i j = l.d; j != l; j = k)
        {
            k = j.d;
            j.e = null;
            j.d = null;
        }

        l.e = l;
        l.d = l;
    }

    public final boolean containsKey(Object obj)
    {
        return findByObject(obj) != null;
    }

    public final Set entrySet()
    {
        f f1 = entrySet;
        if (f1 != null)
        {
            return f1;
        } else
        {
            f f2 = new f(this);
            entrySet = f2;
            return f2;
        }
    }

    final i find(Object obj, boolean flag)
    {
        i j;
        i k;
        Object obj1;
        i ai[];
        Comparator comparator1;
        int i1;
        int j1;
        int k1;
        obj1 = null;
        comparator1 = comparator;
        ai = table;
        j1 = secondaryHash(obj.hashCode());
        k1 = j1 & ai.length - 1;
        j = ai[k1];
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        Comparable comparable;
        if (comparator1 == NATURAL_ORDER)
        {
            comparable = (Comparable)obj;
        } else
        {
            comparable = null;
        }
_L3:
        if (comparable != null)
        {
            i1 = comparable.compareTo(j.f);
        } else
        {
            i1 = comparator1.compare(obj, j.f);
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        k = j;
_L5:
        return k;
_L2:
label0:
        {
            if (i1 < 0)
            {
                k = j.b;
            } else
            {
                k = j.c;
            }
            if (k == null)
            {
                break label0;
            }
            j = k;
        }
          goto _L3
        if (!flag) goto _L5; else goto _L4
_L4:
        i l = header;
        if (j == null)
        {
            if (comparator1 == NATURAL_ORDER && !(obj instanceof Comparable))
            {
                throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
            }
            obj = new i(j, obj, j1, l, l.e);
            ai[k1] = ((i) (obj));
        } else
        {
            obj = new i(j, obj, j1, l, l.e);
            if (i1 < 0)
            {
                j.b = ((i) (obj));
            } else
            {
                j.c = ((i) (obj));
            }
            rebalance(j, true);
        }
        i1 = size;
        size = i1 + 1;
        if (i1 > threshold)
        {
            doubleCapacity();
        }
        modCount = modCount + 1;
        return ((i) (obj));
        i1 = 0;
        k = obj1;
        continue; /* Loop/switch isn't completed */
    }

    final i findByEntry(java.util.Map.Entry entry)
    {
        i j = findByObject(entry.getKey());
        boolean flag;
        if (j != null && equal(j.h, entry.getValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return j;
        } else
        {
            return null;
        }
    }

    final i findByObject(Object obj)
    {
        i j = null;
        if (obj != null)
        {
            try
            {
                j = find(obj, false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return null;
            }
        }
        return j;
    }

    public final Object get(Object obj)
    {
        obj = findByObject(obj);
        if (obj != null)
        {
            return ((i) (obj)).h;
        } else
        {
            return null;
        }
    }

    public final Set keySet()
    {
        g g1 = keySet;
        if (g1 != null)
        {
            return g1;
        } else
        {
            g g2 = new g(this);
            keySet = g2;
            return g2;
        }
    }

    public final Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            obj = find(obj, true);
            Object obj2 = ((i) (obj)).h;
            obj.h = obj1;
            return obj2;
        }
    }

    public final Object remove(Object obj)
    {
        obj = removeInternalByKey(obj);
        if (obj != null)
        {
            return ((i) (obj)).h;
        } else
        {
            return null;
        }
    }

    final void removeInternal(i j, boolean flag)
    {
        i k;
        i l;
        i i1;
        int k1;
        k1 = 0;
        if (flag)
        {
            j.e.d = j.d;
            j.d.e = j.e;
            j.e = null;
            j.d = null;
        }
        l = j.b;
        i1 = j.c;
        k = j.a;
        if (l == null || i1 == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        k = i1;
        if (l.i <= i1.i) goto _L2; else goto _L1
_L1:
        for (k = l.c; k != null; k = i1)
        {
            i1 = k.c;
            l = k;
        }

          goto _L3
_L4:
        k = l;
_L2:
        l = k.b;
        if (l != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = k;
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        removeInternal(l, false);
        k = j.b;
        int j1;
        if (k != null)
        {
            j1 = k.i;
            l.b = k;
            k.a = l;
            j.b = null;
        } else
        {
            j1 = 0;
        }
        k = j.c;
        if (k != null)
        {
            k1 = k.i;
            l.c = k;
            k.a = l;
            j.c = null;
        }
        l.i = Math.max(j1, k1) + 1;
        replaceInParent(j, l);
        return;
        if (l != null)
        {
            replaceInParent(j, l);
            j.b = null;
        } else
        if (i1 != null)
        {
            replaceInParent(j, i1);
            j.c = null;
        } else
        {
            replaceInParent(j, null);
        }
        rebalance(k, false);
        size = size - 1;
        modCount = modCount + 1;
        return;
    }

    final i removeInternalByKey(Object obj)
    {
        obj = findByObject(obj);
        if (obj != null)
        {
            removeInternal(((i) (obj)), true);
        }
        return ((i) (obj));
    }

    public final int size()
    {
        return size;
    }

    static 
    {
        boolean flag;
        if (!com/millennialmedia/google/gson/internal/LinkedHashTreeMap.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
