// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.g;

import java.util.Map;

// Referenced classes of package android.support.v4.g:
//            c, a

public class l
{

    private static Object c[];
    private static int d;
    private static Object e[];
    private static int f;
    Object a[];
    int b;
    private int g[];

    public l()
    {
        g = c.a;
        a = c.b;
        b = 0;
    }

    public l(int i)
    {
        e(10);
        b = 0;
    }

    private int a()
    {
        int i1 = b;
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        return i;
_L2:
        int k;
        int j = android.support.v4.g.c.a(g, i1, 0);
        i = j;
        if (j >= 0)
        {
            i = j;
            if (a[j << 1] != null)
            {
                for (k = j + 1; k < i1 && g[k] == 0; k++)
                {
                    if (a[k << 1] == null)
                    {
                        return k;
                    }
                }

                j--;
label0:
                do
                {
label1:
                    {
                        if (j < 0 || g[j] != 0)
                        {
                            break label1;
                        }
                        i = j;
                        if (a[j << 1] == null)
                        {
                            break label0;
                        }
                        j--;
                    }
                } while (true);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return ~k;
    }

    private int a(Object obj, int i)
    {
        int j1 = b;
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i1;
        int k = android.support.v4.g.c.a(g, j1, i);
        j = k;
        if (k >= 0)
        {
            j = k;
            if (!obj.equals(a[k << 1]))
            {
                for (i1 = k + 1; i1 < j1 && g[i1] == i; i1++)
                {
                    if (obj.equals(a[i1 << 1]))
                    {
                        return i1;
                    }
                }

                k--;
label0:
                do
                {
label1:
                    {
                        if (k < 0 || g[k] != i)
                        {
                            break label1;
                        }
                        j = k;
                        if (obj.equals(a[k << 1]))
                        {
                            break label0;
                        }
                        k--;
                    }
                } while (true);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return ~i1;
    }

    private static void a(int ai[], Object aobj[], int i)
    {
        if (ai.length != 8) goto _L2; else goto _L1
_L1:
        android/support/v4/g/a;
        JVM INSTR monitorenter ;
        if (f < 10)
        {
            aobj[0] = ((Object) (e));
            break MISSING_BLOCK_LABEL_24;
        }
          goto _L3
_L8:
        e = aobj;
        f++;
_L3:
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        return;
        ai;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        throw ai;
_L2:
        if (ai.length != 4) goto _L5; else goto _L4
_L4:
        android/support/v4/g/a;
        JVM INSTR monitorenter ;
        if (d >= 10) goto _L7; else goto _L6
_L6:
        aobj[0] = ((Object) (c));
        aobj[1] = ai;
        i = (i << 1) - 1;
        break MISSING_BLOCK_LABEL_134;
_L9:
        c = aobj;
        d++;
_L7:
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        return;
        ai;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        throw ai;
        aobj[1] = ai;
        i = (i << 1) - 1;
        while (i >= 2) 
        {
            aobj[i] = null;
            i--;
        }
          goto _L8
_L5:
        return;
        while (i >= 2) 
        {
            aobj[i] = null;
            i--;
        }
          goto _L9
    }

    private void e(int i)
    {
        if (i != 8) goto _L2; else goto _L1
_L1:
        android/support/v4/g/a;
        JVM INSTR monitorenter ;
        Object aobj[];
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        aobj = e;
        a = aobj;
        e = (Object[])aobj[0];
        g = (int[])aobj[1];
        aobj[1] = null;
        aobj[0] = null;
        f--;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        return;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
_L4:
        g = new int[i];
        a = new Object[i << 1];
        return;
        Exception exception;
        exception;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (i != 4) goto _L4; else goto _L3
_L3:
        android/support/v4/g/a;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        exception = ((Exception) (c));
        a = exception;
        c = (Object[])exception[0];
        g = (int[])exception[1];
        exception[1] = null;
        exception[0] = null;
        d--;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        return;
        exception;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
        throw exception;
        android/support/v4/g/a;
        JVM INSTR monitorexit ;
          goto _L4
    }

    public final int a(Object obj)
    {
        if (obj == null)
        {
            return a();
        } else
        {
            return a(obj, obj.hashCode());
        }
    }

    public final Object a(int i, Object obj)
    {
        i = (i << 1) + 1;
        Object obj1 = a[i];
        a[i] = obj;
        return obj1;
    }

    public final void a(int i)
    {
        if (g.length < i)
        {
            int ai[] = g;
            Object aobj[] = a;
            e(i);
            if (b > 0)
            {
                System.arraycopy(ai, 0, g, 0, b);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (a)), 0, b << 1);
            }
            a(ai, aobj, b);
        }
    }

    final int b(Object obj)
    {
        Object aobj[];
        int i;
        boolean flag;
        int j;
        i = 1;
        flag = true;
        j = b << 1;
        aobj = a;
        if (obj != null) goto _L2; else goto _L1
_L1:
        for (i = ((flag) ? 1 : 0); i < j; i += 2)
        {
            if (aobj[i] == null)
            {
                return i >> 1;
            }
        }

          goto _L3
_L4:
        i += 2;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj.equals(aobj[i]))
        {
            return i >> 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public final Object b(int i)
    {
        return a[i << 1];
    }

    public final Object c(int i)
    {
        return a[(i << 1) + 1];
    }

    public void clear()
    {
        if (b != 0)
        {
            a(g, a, b);
            g = c.a;
            a = c.b;
            b = 0;
        }
    }

    public boolean containsKey(Object obj)
    {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj)
    {
        return b(obj) >= 0;
    }

    public final Object d(int i)
    {
        int j = 8;
        Object obj = a[(i << 1) + 1];
        if (b <= 1)
        {
            a(g, a, b);
            g = c.a;
            a = c.b;
            b = 0;
        } else
        if (g.length > 8 && b < g.length / 3)
        {
            if (b > 8)
            {
                j = b + (b >> 1);
            }
            int ai[] = g;
            Object aobj[] = a;
            e(j);
            b = b - 1;
            if (i > 0)
            {
                System.arraycopy(ai, 0, g, 0, i);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (a)), 0, i << 1);
            }
            if (i < b)
            {
                System.arraycopy(ai, i + 1, g, i, b - i);
                System.arraycopy(((Object) (aobj)), i + 1 << 1, ((Object) (a)), i << 1, b - i << 1);
                return obj;
            }
        } else
        {
            b = b - 1;
            if (i < b)
            {
                System.arraycopy(g, i + 1, g, i, b - i);
                System.arraycopy(((Object) (a)), i + 1 << 1, ((Object) (a)), i << 1, b - i << 1);
            }
            a[b << 1] = null;
            a[(b << 1) + 1] = null;
            return obj;
        }
        return obj;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int i;
        if (!(obj instanceof Map))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = (Map)obj;
        if (size() != ((Map) (obj)).size())
        {
            return false;
        }
        i = 0;
_L4:
        Object obj1;
        Object obj2;
        Object obj3;
        if (i >= b)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = b(i);
        obj2 = c(i);
        obj3 = ((Map) (obj)).get(obj1);
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (!((Map) (obj)).containsKey(obj1))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        break MISSING_BLOCK_LABEL_106;
        boolean flag;
        try
        {
            flag = obj2.equals(obj3);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (!flag)
        {
            return false;
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        return false;
        return false;
    }

    public Object get(Object obj)
    {
        int i = a(obj);
        if (i >= 0)
        {
            return a[(i << 1) + 1];
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        int ai[] = g;
        Object aobj[] = a;
        int j1 = b;
        int i = 1;
        int j = 0;
        int k = 0;
        while (j < j1) 
        {
            Object obj = aobj[i];
            int k1 = ai[j];
            int i1;
            if (obj == null)
            {
                i1 = 0;
            } else
            {
                i1 = obj.hashCode();
            }
            k += i1 ^ k1;
            j++;
            i += 2;
        }
        return k;
    }

    public boolean isEmpty()
    {
        return b <= 0;
    }

    public Object put(Object obj, Object obj1)
    {
        int k;
        byte byte0;
        int i1;
        byte0 = 8;
        int i;
        if (obj == null)
        {
            i = a();
            k = 0;
        } else
        {
            k = obj.hashCode();
            i = a(obj, k);
        }
        if (i >= 0)
        {
            i = (i << 1) + 1;
            obj = a[i];
            a[i] = obj1;
            return obj;
        }
        i1 = ~i;
        if (b < g.length) goto _L2; else goto _L1
_L1:
        if (b < 8) goto _L4; else goto _L3
_L3:
        int j = b + (b >> 1);
_L6:
        int ai[] = g;
        Object aobj[] = a;
        e(j);
        if (g.length > 0)
        {
            System.arraycopy(ai, 0, g, 0, ai.length);
            System.arraycopy(((Object) (aobj)), 0, ((Object) (a)), 0, aobj.length);
        }
        a(ai, aobj, b);
_L2:
        if (i1 < b)
        {
            System.arraycopy(g, i1, g, i1 + 1, b - i1);
            System.arraycopy(((Object) (a)), i1 << 1, ((Object) (a)), i1 + 1 << 1, b - i1 << 1);
        }
        g[i1] = k;
        a[i1 << 1] = obj;
        a[(i1 << 1) + 1] = obj1;
        b = b + 1;
        return null;
_L4:
        j = byte0;
        if (b < 4)
        {
            j = 4;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Object remove(Object obj)
    {
        int i = a(obj);
        if (i >= 0)
        {
            return d(i);
        } else
        {
            return null;
        }
    }

    public int size()
    {
        return b;
    }

    public String toString()
    {
        if (isEmpty())
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder(b * 28);
        stringbuilder.append('{');
        int i = 0;
        while (i < b) 
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            Object obj = b(i);
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            stringbuilder.append('=');
            obj = c(i);
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            i++;
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }
}
