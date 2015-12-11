// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class q
{
    static class a
    {

        long a;
        a b;

        private void b()
        {
            if (b == null)
            {
                b = new a();
            }
        }

        void a()
        {
            a = 0L;
            if (b != null)
            {
                b.a();
            }
        }

        void a(int i)
        {
            if (i >= 64)
            {
                b();
                b.a(i - 64);
                return;
            } else
            {
                a = a | 1L << i;
                return;
            }
        }

        void a(int i, boolean flag)
        {
            if (i >= 64)
            {
                b();
                b.a(i - 64, flag);
            } else
            {
                long l;
                long l1;
                boolean flag1;
                if ((a & 0x8000000000000000L) != 0L)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                l = (1L << i) - 1L;
                l1 = a;
                a = (~l & a) << 1 | l1 & l;
                if (flag)
                {
                    a(i);
                } else
                {
                    b(i);
                }
                if (flag1 || b != null)
                {
                    b();
                    b.a(0, flag1);
                    return;
                }
            }
        }

        void b(int i)
        {
            if (i >= 64)
            {
                if (b != null)
                {
                    b.b(i - 64);
                }
                return;
            } else
            {
                a = a & ~(1L << i);
                return;
            }
        }

        boolean c(int i)
        {
            if (i >= 64)
            {
                b();
                return b.c(i - 64);
            }
            return (a & 1L << i) != 0L;
        }

        boolean d(int i)
        {
            boolean flag1;
            if (i >= 64)
            {
                b();
                flag1 = b.d(i - 64);
            } else
            {
                long l = 1L << i;
                long l1;
                boolean flag;
                if ((a & l) != 0L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a = a & ~l;
                l--;
                l1 = a;
                a = Long.rotateRight(~l & a, 1) | l1 & l;
                flag1 = flag;
                if (b != null)
                {
                    if (b.c(0))
                    {
                        a(63);
                    }
                    b.d(0);
                    return flag;
                }
            }
            return flag1;
        }

        int e(int i)
        {
            if (b == null)
            {
                if (i >= 64)
                {
                    return Long.bitCount(a);
                } else
                {
                    return Long.bitCount(a & (1L << i) - 1L);
                }
            }
            if (i < 64)
            {
                return Long.bitCount(a & (1L << i) - 1L);
            } else
            {
                return b.e(i - 64) + Long.bitCount(a);
            }
        }

        public String toString()
        {
            if (b == null)
            {
                return Long.toBinaryString(a);
            } else
            {
                return (new StringBuilder()).append(b.toString()).append("xx").append(Long.toBinaryString(a)).toString();
            }
        }

        a()
        {
            a = 0L;
        }
    }

    static interface b
    {

        public abstract int a();

        public abstract int a(View view);

        public abstract void a(int i);

        public abstract void a(View view, int i);

        public abstract void a(View view, int i, android.view.ViewGroup.LayoutParams layoutparams);

        public abstract RecyclerView.t b(View view);

        public abstract View b(int i);

        public abstract void b();

        public abstract void c(int i);
    }


    final b a;
    final a b = new a();
    final List c = new ArrayList();

    q(b b1)
    {
        a = b1;
    }

    private int e(int i)
    {
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        i = -1;
        return i;
        int j;
        int k;
        int l;
        k = a.a();
        j = i;
          goto _L1
        continue; /* Loop/switch isn't completed */
        j += l;
    }

    View a(int i, int j)
    {
        int l = c.size();
        for (int k = 0; k < l; k++)
        {
            View view = (View)c.get(k);
            RecyclerView.t t = a.b(view);
            if (t.e() == i && !t.n() && (j == -1 || t.h() == j))
            {
                return view;
            }
        }

        return null;
    }

    void a()
    {
        a.b();
        b.a();
        c.clear();
    }

    void a(int i)
    {
        i = e(i);
        View view = a.b(i);
        if (view != null)
        {
            a.a(i);
            if (b.d(i))
            {
                c.remove(view);
                return;
            }
        }
    }

    void a(View view)
    {
        int i = a.a(view);
        if (i >= 0)
        {
            a.a(i);
            if (b.d(i))
            {
                c.remove(view);
                return;
            }
        }
    }

    void a(View view, int i, android.view.ViewGroup.LayoutParams layoutparams, boolean flag)
    {
        if (i < 0)
        {
            i = a.a();
        } else
        {
            i = e(i);
        }
        a.a(view, i, layoutparams);
        b.a(i, flag);
        if (flag)
        {
            c.add(view);
        }
    }

    void a(View view, int i, boolean flag)
    {
        if (i < 0)
        {
            i = a.a();
        } else
        {
            i = e(i);
        }
        a.a(view, i);
        b.a(i, flag);
        if (flag)
        {
            c.add(view);
        }
    }

    void a(View view, boolean flag)
    {
        a(view, -1, flag);
    }

    int b()
    {
        return a.a() - c.size();
    }

    int b(View view)
    {
        int i;
        for (i = a.a(view); i == -1 || b.c(i);)
        {
            return -1;
        }

        return i - b.e(i);
    }

    View b(int i)
    {
        i = e(i);
        return a.b(i);
    }

    int c()
    {
        return a.a();
    }

    View c(int i)
    {
        return a.b(i);
    }

    boolean c(View view)
    {
        return c.contains(view);
    }

    void d(int i)
    {
        i = e(i);
        a.c(i);
        b.d(i);
    }

    void d(View view)
    {
        int i = a.a(view);
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("view is not a child, cannot hide ").append(view).toString());
        } else
        {
            b.a(i);
            c.add(view);
            return;
        }
    }

    boolean e(View view)
    {
        int i = a.a(view);
        if (i == -1)
        {
            if (!c.remove(view));
        } else
        if (b.c(i))
        {
            b.d(i);
            a.a(i);
            if (!c.remove(view))
            {
                return true;
            }
        } else
        {
            return false;
        }
        return true;
    }

    public String toString()
    {
        return (new StringBuilder()).append(b.toString()).append(", hidden list:").append(c.size()).toString();
    }
}
