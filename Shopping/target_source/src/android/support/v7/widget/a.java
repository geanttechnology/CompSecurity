// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            w

class android.support.v7.widget.a
    implements w.a
{
    static interface a
    {

        public abstract RecyclerView.t a(int i);

        public abstract void a(int i, int j);

        public abstract void a(b b1);

        public abstract void b(int i, int j);

        public abstract void b(b b1);

        public abstract void c(int i, int j);

        public abstract void d(int i, int j);

        public abstract void e(int i, int j);
    }

    static class b
    {

        int a;
        int b;
        int c;

        String a()
        {
            switch (a)
            {
            default:
                return "??";

            case 0: // '\0'
                return "add";

            case 1: // '\001'
                return "rm";

            case 2: // '\002'
                return "up";

            case 3: // '\003'
                return "mv";
            }
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (b)obj;
                if (a != ((b) (obj)).a)
                {
                    return false;
                }
                if (a != 3 || Math.abs(c - b) != 1 || c != ((b) (obj)).b || b != ((b) (obj)).c)
                {
                    if (c != ((b) (obj)).c)
                    {
                        return false;
                    }
                    if (b != ((b) (obj)).b)
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        public int hashCode()
        {
            return (a * 31 + b) * 31 + c;
        }

        public String toString()
        {
            return (new StringBuilder()).append("[").append(a()).append(",s:").append(b).append("c:").append(c).append("]").toString();
        }

        b(int i, int j, int k)
        {
            a = i;
            b = j;
            c = k;
        }
    }


    final ArrayList a;
    final ArrayList b;
    final a c;
    Runnable d;
    final boolean e;
    final w f;
    private android.support.v4.f.i.a g;

    android.support.v7.widget.a(a a1)
    {
        this(a1, false);
    }

    android.support.v7.widget.a(a a1, boolean flag)
    {
        g = new android.support.v4.f.i.b(30);
        a = new ArrayList();
        b = new ArrayList();
        c = a1;
        e = flag;
        f = new w(this);
    }

    private void b(b b1)
    {
        g(b1);
    }

    private void c(b b1)
    {
        int i1 = b1.b;
        int j = b1.b + b1.c;
        byte byte0 = -1;
        int i = b1.b;
        int l = 0;
        while (i < j) 
        {
            if (c.a(i) != null || c(i))
            {
                b b2;
                int k;
                boolean flag;
                if (byte0 == 0)
                {
                    e(b(1, i1, l));
                    k = 1;
                } else
                {
                    k = 0;
                }
                byte0 = 1;
            } else
            {
                if (byte0 == 1)
                {
                    g(b(1, i1, l));
                    byte0 = 1;
                } else
                {
                    byte0 = 0;
                }
                flag = false;
                k = byte0;
                byte0 = flag;
            }
            if (k != 0)
            {
                k = i - l;
                i = j - l;
                j = 1;
            } else
            {
                l++;
                k = i;
                i = j;
                j = l;
            }
            l = j;
            j = i;
            i = k + 1;
        }
        b2 = b1;
        if (l != b1.c)
        {
            a(b1);
            b2 = b(1, i1, l);
        }
        if (byte0 == 0)
        {
            e(b2);
            return;
        } else
        {
            g(b2);
            return;
        }
    }

    private boolean c(int i)
    {
        int l = b.size();
label0:
        for (int j = 0; j < l; j++)
        {
            b b1 = (b)b.get(j);
            if (b1.a == 3)
            {
                if (a(b1.c, j + 1) == i)
                {
                    return true;
                }
                continue;
            }
            if (b1.a != 0)
            {
                continue;
            }
            int i1 = b1.b;
            int j1 = b1.c;
            int k = b1.b;
            do
            {
                if (k >= i1 + j1)
                {
                    continue label0;
                }
                if (a(k, j + 1) == i)
                {
                    return true;
                }
                k++;
            } while (true);
        }

        return false;
    }

    private void d(b b1)
    {
        int k = b1.b;
        int l1 = b1.b;
        int i2 = b1.c;
        int i = b1.b;
        int k1 = -1;
        int j = 0;
        while (i < l1 + i2) 
        {
            int l;
            if (c.a(i) != null || c(i))
            {
                l = j;
                int i1 = k;
                if (k1 == 0)
                {
                    e(b(2, k, j));
                    l = 0;
                    i1 = i;
                }
                k = i1;
                j = 1;
            } else
            {
                l = j;
                int j1 = k;
                if (k1 == 1)
                {
                    g(b(2, k, j));
                    l = 0;
                    j1 = i;
                }
                k = j1;
                j = 0;
            }
            i++;
            l++;
            k1 = j;
            j = l;
        }
        b b2 = b1;
        if (j != b1.c)
        {
            a(b1);
            b2 = b(2, k, j);
        }
        if (k1 == 0)
        {
            e(b2);
            return;
        } else
        {
            g(b2);
            return;
        }
    }

    private int e(int i, int j)
    {
        int l = b.size() - 1;
        do
        {
            if (l >= 0)
            {
                b b1 = (b)b.get(l);
                int k;
                if (b1.a == 3)
                {
                    int i1;
                    if (b1.b < b1.c)
                    {
                        i1 = b1.b;
                        k = b1.c;
                    } else
                    {
                        i1 = b1.c;
                        k = b1.b;
                    }
                    if (i >= i1 && i <= k)
                    {
                        if (i1 == b1.b)
                        {
                            if (j == 0)
                            {
                                b1.c = b1.c + 1;
                            } else
                            if (j == 1)
                            {
                                b1.c = b1.c - 1;
                            }
                            i++;
                        } else
                        {
                            if (j == 0)
                            {
                                b1.b = b1.b + 1;
                            } else
                            if (j == 1)
                            {
                                b1.b = b1.b - 1;
                            }
                            i--;
                        }
                    } else
                    if (i < b1.b)
                    {
                        if (j == 0)
                        {
                            b1.b = b1.b + 1;
                            b1.c = b1.c + 1;
                        } else
                        if (j == 1)
                        {
                            b1.b = b1.b - 1;
                            b1.c = b1.c - 1;
                        }
                    }
                    k = i;
                } else
                if (b1.b <= i)
                {
                    if (b1.a == 0)
                    {
                        k = i - b1.c;
                    } else
                    {
                        k = i;
                        if (b1.a == 1)
                        {
                            k = i + b1.c;
                        }
                    }
                } else
                if (j == 0)
                {
                    b1.b = b1.b + 1;
                    k = i;
                } else
                {
                    k = i;
                    if (j == 1)
                    {
                        b1.b = b1.b - 1;
                        k = i;
                    }
                }
                l--;
                i = k;
                continue;
            }
            j = b.size() - 1;
            while (j >= 0) 
            {
                b b2 = (b)b.get(j);
                if (b2.a == 3)
                {
                    if (b2.c == b2.b || b2.c < 0)
                    {
                        b.remove(j);
                        a(b2);
                    }
                } else
                if (b2.c <= 0)
                {
                    b.remove(j);
                    a(b2);
                }
                j--;
            }
            return i;
        } while (true);
    }

    private void e(b b1)
    {
        int j;
        int j1;
        if (b1.a == 0 || b1.a == 3)
        {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        j1 = e(b1.b, b1.a);
        j = b1.b;
        b1.a;
        JVM INSTR tableswitch 1 2: default 72
    //                   1 187
    //                   2 99;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("op should be remove or update.").append(b1).toString());
_L3:
        int k = 1;
_L8:
        int l;
        int i1;
        i1 = 1;
        l = 1;
_L7:
        int k1;
        if (l >= b1.c)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        k1 = e(b1.b + k * l, b1.a);
        b1.a;
        JVM INSTR tableswitch 1 2: default 164
    //                   1 212
    //                   2 193;
           goto _L4 _L5 _L6
_L4:
        int i = 0;
_L9:
        if (i != 0)
        {
            i = i1 + 1;
        } else
        {
            b b2 = b(b1.a, j1, i1);
            a(b2, j);
            a(b2);
            i = j;
            if (b1.a == 2)
            {
                i = j + i1;
            }
            i1 = 1;
            j1 = k1;
            j = i;
            i = i1;
        }
        l++;
        i1 = i;
          goto _L7
_L2:
        k = 0;
          goto _L8
_L6:
        if (k1 == j1 + 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
          goto _L9
_L5:
        if (k1 == j1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
          goto _L9
        a(b1);
        if (i1 > 0)
        {
            b1 = b(b1.a, j1, i1);
            a(b1, j);
            a(b1);
        }
        return;
          goto _L7
    }

    private void f(b b1)
    {
        g(b1);
    }

    private void g(b b1)
    {
        b.add(b1);
        switch (b1.a)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown update op type for ").append(b1).toString());

        case 0: // '\0'
            c.d(b1.b, b1.c);
            return;

        case 3: // '\003'
            c.e(b1.b, b1.c);
            return;

        case 1: // '\001'
            c.b(b1.b, b1.c);
            return;

        case 2: // '\002'
            c.c(b1.b, b1.c);
            return;
        }
    }

    int a(int i)
    {
        return a(i, 0);
    }

    int a(int i, int j)
    {
        int l;
        int i1;
        i1 = b.size();
        l = j;
        j = i;
_L5:
        i = j;
        if (l >= i1) goto _L2; else goto _L1
_L1:
        b b1 = (b)b.get(l);
        if (b1.a != 3) goto _L4; else goto _L3
_L3:
        if (b1.b == j)
        {
            i = b1.c;
        } else
        {
            int k = j;
            if (b1.b < j)
            {
                k = j - 1;
            }
            i = k;
            if (b1.c <= k)
            {
                i = k + 1;
            }
        }
_L7:
        l++;
        j = i;
          goto _L5
_L4:
        i = j;
        if (b1.b > j) goto _L7; else goto _L6
_L6:
        if (b1.a != 1)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (j >= b1.b + b1.c) goto _L9; else goto _L8
_L8:
        i = -1;
_L2:
        return i;
_L9:
        i = j - b1.c;
          goto _L7
        i = j;
        if (b1.a == 0)
        {
            i = j + b1.c;
        }
          goto _L7
    }

    void a()
    {
        a(((List) (a)));
        a(((List) (b)));
    }

    public void a(b b1)
    {
        if (!e)
        {
            g.a(b1);
        }
    }

    void a(b b1, int i)
    {
        c.a(b1);
        switch (b1.a)
        {
        default:
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");

        case 1: // '\001'
            c.a(i, b1.c);
            return;

        case 2: // '\002'
            c.c(i, b1.c);
            break;
        }
    }

    void a(List list)
    {
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            a((b)list.get(i));
        }

        list.clear();
    }

    boolean a(int i, int j, int k)
    {
        boolean flag = true;
        if (i == j)
        {
            return false;
        }
        if (k != 1)
        {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        a.add(b(3, i, j));
        if (a.size() != 1)
        {
            flag = false;
        }
        return flag;
    }

    public int b(int i)
    {
        int j;
        int l;
        int i1;
        i1 = a.size();
        l = 0;
        j = i;
_L8:
        i = j;
        if (l >= i1) goto _L2; else goto _L1
_L1:
        b b1;
        b1 = (b)a.get(l);
        i = j;
        b1.a;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 85
    //                   1 105
    //                   2 74
    //                   3 142;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_142;
_L6:
        break; /* Loop/switch isn't completed */
_L3:
        i = j;
_L9:
        l++;
        j = i;
          goto _L8
_L4:
        i = j;
        if (b1.b <= j)
        {
            i = j + b1.c;
        }
          goto _L9
_L5:
        i = j;
        if (b1.b > j) goto _L9; else goto _L10
_L10:
        if (b1.b + b1.c <= j) goto _L12; else goto _L11
_L11:
        i = -1;
_L2:
        return i;
_L12:
        i = j - b1.c;
          goto _L9
        if (b1.b == j)
        {
            i = b1.c;
        } else
        {
            int k = j;
            if (b1.b < j)
            {
                k = j - 1;
            }
            i = k;
            if (b1.c <= k)
            {
                i = k + 1;
            }
        }
          goto _L9
    }

    public b b(int i, int j, int k)
    {
        b b1 = (b)g.a();
        if (b1 == null)
        {
            return new b(i, j, k);
        } else
        {
            b1.a = i;
            b1.b = j;
            b1.c = k;
            return b1;
        }
    }

    void b()
    {
        int i;
        int j;
        f.a(a);
        j = a.size();
        i = 0;
_L7:
        b b1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        b1 = (b)a.get(i);
        b1.a;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 95
    //                   1 103
    //                   2 111
    //                   3 119;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_119;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L8:
        if (d != null)
        {
            d.run();
        }
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        f(b1);
          goto _L8
_L3:
        c(b1);
          goto _L8
_L4:
        d(b1);
          goto _L8
        b(b1);
          goto _L8
        a.clear();
        return;
    }

    boolean b(int i, int j)
    {
        a.add(b(2, i, j));
        return a.size() == 1;
    }

    void c()
    {
        int j = b.size();
        for (int i = 0; i < j; i++)
        {
            c.b((b)b.get(i));
        }

        a(b);
    }

    boolean c(int i, int j)
    {
        a.add(b(0, i, j));
        return a.size() == 1;
    }

    boolean d()
    {
        return a.size() > 0;
    }

    boolean d(int i, int j)
    {
        a.add(b(1, i, j));
        return a.size() == 1;
    }

    void e()
    {
        int i;
        int j;
        c();
        j = a.size();
        i = 0;
_L7:
        b b1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        b1 = (b)a.get(i);
        b1.a;
        JVM INSTR tableswitch 0 3: default 64
    //                   0 87
    //                   1 117
    //                   2 147
    //                   3 177;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_177;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L8:
        if (d != null)
        {
            d.run();
        }
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        c.b(b1);
        c.d(b1.b, b1.c);
          goto _L8
_L3:
        c.b(b1);
        c.a(b1.b, b1.c);
          goto _L8
_L4:
        c.b(b1);
        c.c(b1.b, b1.c);
          goto _L8
        c.b(b1);
        c.e(b1.b, b1.c);
          goto _L8
        a(a);
        return;
    }
}
