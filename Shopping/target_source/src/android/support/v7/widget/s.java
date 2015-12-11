// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.d;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import java.util.Arrays;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager, x, RecyclerView

public class s extends LinearLayoutManager
{
    public static final class a extends c
    {

        public int a(int i)
        {
            return 1;
        }

        public int a(int i, int j)
        {
            return i % j;
        }

        public a()
        {
        }
    }

    public static class b extends RecyclerView.i
    {

        private int e;
        private int f;

        static int a(b b1)
        {
            return b1.e;
        }

        static int a(b b1, int i)
        {
            b1.f = i;
            return i;
        }

        static int b(b b1)
        {
            return b1.f;
        }

        static int b(b b1, int i)
        {
            b1.e = i;
            return i;
        }

        public int a()
        {
            return e;
        }

        public int b()
        {
            return f;
        }

        public b(int i, int j)
        {
            super(i, j);
            e = -1;
            f = 0;
        }

        public b(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            e = -1;
            f = 0;
        }

        public b(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            e = -1;
            f = 0;
        }

        public b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            e = -1;
            f = 0;
        }
    }

    public static abstract class c
    {

        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public abstract int a(int i);

        public int a(int i, int j)
        {
            int l1 = a(i);
            if (l1 != j) goto _L2; else goto _L1
_L1:
            return 0;
_L2:
            int l;
            int i1;
            if (!mCacheSpanIndices || mSpanIndexCache.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            i1 = b(i);
            if (i1 < 0)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            l = mSpanIndexCache.get(i1) + a(i1);
            i1++;
_L4:
            do
            {
                if (i1 >= i)
                {
                    continue; /* Loop/switch isn't completed */
                }
                int j1 = a(i1);
                int k1 = l + j1;
                if (k1 == j)
                {
                    l = 0;
                } else
                {
                    l = j1;
                    if (k1 <= j)
                    {
                        l = k1;
                    }
                }
                i1++;
            } while (true);
            if (l + l1 > j) goto _L1; else goto _L3
_L3:
            return l;
            i1 = 0;
            l = 0;
              goto _L4
        }

        public void a()
        {
            mSpanIndexCache.clear();
        }

        int b(int i)
        {
            int j = 0;
            for (int l = mSpanIndexCache.size() - 1; j <= l;)
            {
                int i1 = j + l >>> 1;
                if (mSpanIndexCache.keyAt(i1) < i)
                {
                    j = i1 + 1;
                } else
                {
                    l = i1 - 1;
                }
            }

            i = j - 1;
            if (i >= 0 && i < mSpanIndexCache.size())
            {
                return mSpanIndexCache.keyAt(i);
            } else
            {
                return -1;
            }
        }

        int b(int i, int j)
        {
            int l;
            if (!mCacheSpanIndices)
            {
                l = a(i, j);
            } else
            {
                int i1 = mSpanIndexCache.get(i, -1);
                l = i1;
                if (i1 == -1)
                {
                    j = a(i, j);
                    mSpanIndexCache.put(i, j);
                    return j;
                }
            }
            return l;
        }

        public int c(int i, int j)
        {
            int i2 = a(i);
            int j1 = 0;
            int l = 0;
            int i1 = 0;
            while (j1 < i) 
            {
                int k1 = a(j1);
                i1 += k1;
                if (i1 == j)
                {
                    i1 = l + 1;
                    l = 0;
                } else
                if (i1 > j)
                {
                    i1 = l + 1;
                    l = k1;
                } else
                {
                    int l1 = i1;
                    i1 = l;
                    l = l1;
                }
                k1 = j1 + 1;
                j1 = l;
                l = i1;
                i1 = j1;
                j1 = k1;
            }
            i = l;
            if (i1 + i2 > j)
            {
                i = l + 1;
            }
            return i;
        }

        public c()
        {
            mCacheSpanIndices = false;
        }
    }


    static final int a = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
    int b;
    int c;
    View d[];
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    c g;
    final Rect h = new Rect();

    public s(Context context, int i)
    {
        super(context);
        b = -1;
        g = new a();
        a(i);
    }

    private void A()
    {
        int j = o();
        for (int i = 0; i < j; i++)
        {
            b b1 = (b)g(i).getLayoutParams();
            int l = b1.e();
            e.put(l, b1.b());
            f.put(l, b1.a());
        }

    }

    private void B()
    {
        int i;
        if (f() == 1)
        {
            i = p() - t() - r();
        } else
        {
            i = q() - u() - s();
        }
        c = i / b;
    }

    private int a(int i, int j, int l)
    {
        int i1;
        if (j != 0 || l != 0)
        {
            if ((i1 = android.view.View.MeasureSpec.getMode(i)) == 0x80000000 || i1 == 0x40000000)
            {
                return android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i) - j - l, i1);
            }
        }
        return i;
    }

    private int a(RecyclerView.m m, RecyclerView.q q, int i)
    {
        if (!q.a())
        {
            return g.c(i, b);
        }
        int j = m.b(i);
        if (j == -1)
        {
            Log.w("GridLayoutManager", (new StringBuilder()).append("Cannot find span size for pre layout position. ").append(i).toString());
            return 0;
        } else
        {
            return g.c(j, b);
        }
    }

    private void a(LinearLayoutManager.a a1)
    {
        for (int i = g.b(a1.a, b); i > 0 && a1.a > 0; i = g.b(a1.a, b))
        {
            a1.a = a1.a - 1;
        }

    }

    private void a(RecyclerView.m m, RecyclerView.q q, int i, int j, boolean flag)
    {
        int l;
        int i1;
        byte byte0;
        if (flag)
        {
            l = 1;
            boolean flag1 = false;
            i1 = i;
            i = ((flag1) ? 1 : 0);
        } else
        {
            i--;
            l = -1;
            i1 = -1;
        }
        if (mOrientation == 1 && g())
        {
            j--;
            byte0 = -1;
        } else
        {
            j = 0;
            byte0 = 1;
        }
        while (i != i1) 
        {
            View view = d[i];
            b b1 = (b)view.getLayoutParams();
            b.a(b1, c(m, q, d(view)));
            if (byte0 == -1 && b.b(b1) > 1)
            {
                b.b(b1, j - (b.b(b1) - 1));
            } else
            {
                b.b(b1, j);
            }
            j += b.b(b1) * byte0;
            i += l;
        }
    }

    private int b(RecyclerView.m m, RecyclerView.q q, int i)
    {
        int j;
        if (!q.a())
        {
            j = g.b(i, b);
        } else
        {
            int i1 = f.get(i, -1);
            j = i1;
            if (i1 == -1)
            {
                int l = m.b(i);
                if (l == -1)
                {
                    Log.w("GridLayoutManager", (new StringBuilder()).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:").append(i).toString());
                    return 0;
                } else
                {
                    return g.b(l, b);
                }
            }
        }
        return j;
    }

    private void b(View view, int i, int j)
    {
        a(view, h);
        RecyclerView.i l = (RecyclerView.i)view.getLayoutParams();
        view.measure(a(i, l.leftMargin + h.left, l.rightMargin + h.right), a(j, l.topMargin + h.top, l.bottomMargin + h.bottom));
    }

    private int c(RecyclerView.m m, RecyclerView.q q, int i)
    {
        int j;
        if (!q.a())
        {
            j = g.a(i);
        } else
        {
            int i1 = e.get(i, -1);
            j = i1;
            if (i1 == -1)
            {
                int l = m.b(i);
                if (l == -1)
                {
                    Log.w("GridLayoutManager", (new StringBuilder()).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:").append(i).toString());
                    return 1;
                } else
                {
                    return g.a(l);
                }
            }
        }
        return j;
    }

    private int k(int i)
    {
        if (i < 0)
        {
            return a;
        } else
        {
            return android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        }
    }

    private void z()
    {
        e.clear();
        f.clear();
    }

    public int a(RecyclerView.m m, RecyclerView.q q)
    {
        if (mOrientation == 0)
        {
            return b;
        }
        if (q.e() < 1)
        {
            return 0;
        } else
        {
            return a(m, q, q.e() - 1);
        }
    }

    public RecyclerView.i a()
    {
        return new b(-2, -2);
    }

    public RecyclerView.i a(Context context, AttributeSet attributeset)
    {
        return new b(context, attributeset);
    }

    public RecyclerView.i a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new b((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new b(layoutparams);
        }
    }

    public void a(int i)
    {
        if (i == b)
        {
            return;
        }
        if (i < 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Span count should be at least 1. Provided ").append(i).toString());
        } else
        {
            b = i;
            g.a();
            return;
        }
    }

    void a(RecyclerView.m m, RecyclerView.q q, LinearLayoutManager.c c1, LinearLayoutManager.b b1)
    {
        int i;
        int l;
        int i1;
        int k2;
        boolean flag1;
        int l1;
        if (c1.e == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i1 = 0;
        l1 = 0;
        i = b;
        k2 = i1;
        l = l1;
        if (!flag1)
        {
            i = b(m, q, c1.d) + c(m, q, c1.d);
            l = l1;
            k2 = i1;
        }
_L6:
        if (k2 >= b || !c1.a(q) || i <= 0) goto _L2; else goto _L1
_L1:
        l1 = c1.d;
        i1 = c(m, q, l1);
        if (i1 > b)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Item at position ").append(l1).append(" requires ").append(i1).append(" spans but GridLayoutManager has only ").append(b).append(" spans.").toString());
        }
        i -= i1;
        if (i >= 0) goto _L3; else goto _L2
_L2:
        View view;
        if (k2 == 0)
        {
            b1.b = true;
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        if ((view = c1.a(m)) == null) goto _L2; else goto _L4
_L4:
        l += i1;
        d[k2] = view;
        k2++;
        if (true) goto _L6; else goto _L5
_L5:
        a(m, q, k2, l, flag1);
        l = 0;
        int j = 0;
        while (l < k2) 
        {
            View view1 = d[l];
            b b2;
            int j1;
            if (c1.j == null)
            {
                if (flag1)
                {
                    b(view1);
                } else
                {
                    b(view1, 0);
                }
            } else
            if (flag1)
            {
                a(view1);
            } else
            {
                a(view1, 0);
            }
            j1 = android.view.View.MeasureSpec.makeMeasureSpec(c(m, q, d(view1)) * c, 0x40000000);
            b2 = (b)view1.getLayoutParams();
            if (mOrientation == 1)
            {
                b(view1, j1, k(b2.height));
            } else
            {
                b(view1, k(b2.width), j1);
            }
            j1 = mOrientationHelper.c(view1);
            if (j1 > j)
            {
                j = j1;
            }
            l++;
        }
        int k1 = k(j);
        l = 0;
        while (l < k2) 
        {
            View view2 = d[l];
            if (mOrientationHelper.c(view2) != j)
            {
                int i2 = android.view.View.MeasureSpec.makeMeasureSpec(c(m, q, d(view2)) * c, 0x40000000);
                if (mOrientation == 1)
                {
                    b(view2, i2, k1);
                } else
                {
                    b(view2, k1, i2);
                }
            }
            l++;
        }
        b1.a = j;
        int j2 = 0;
        int l2;
        int i3;
        boolean flag;
        if (mOrientation == 1)
        {
            if (c1.f == -1)
            {
                j2 = c1.b;
                j = j2 - j;
                l = 0;
                k1 = 0;
            } else
            {
                l = c1.b;
                j2 = l + j;
                j = l;
                l = 0;
                k1 = 0;
            }
        } else
        if (c1.f == -1)
        {
            k1 = c1.b;
            l = k1;
            k1 -= j;
            j = 0;
        } else
        {
            k1 = c1.b;
            l = j + k1;
            j = 0;
        }
        flag = false;
        l2 = k1;
        i3 = j;
        k1 = ((flag) ? 1 : 0);
        j = l2;
        l2 = i3;
        while (k1 < k2) 
        {
            m = d[k1];
            q = (b)m.getLayoutParams();
            if (mOrientation == 1)
            {
                j = r();
                j = c * b.a(q) + j;
                l = mOrientationHelper.d(m) + j;
            } else
            {
                j2 = s();
                l2 = c * b.a(q) + j2;
                j2 = mOrientationHelper.d(m) + l2;
            }
            a(((View) (m)), j + ((b) (q)).leftMargin, l2 + ((b) (q)).topMargin, l - ((b) (q)).rightMargin, j2 - ((b) (q)).bottomMargin);
            if (q.c() || q.d())
            {
                b1.c = true;
            }
            b1.d = b1.d | m.isFocusable();
            k1++;
        }
        Arrays.fill(d, null);
        return;
    }

    public void a(RecyclerView.m m, RecyclerView.q q, View view, d d1)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (!(layoutparams instanceof b))
        {
            super.a(view, d1);
            return;
        }
        view = (b)layoutparams;
        int i = a(m, q, view.e());
        if (mOrientation == 0)
        {
            int j = view.a();
            int i1 = view.b();
            boolean flag;
            if (b > 1 && view.b() == b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d1.c(android.support.v4.view.a.d.j.a(j, i1, i, 1, flag, false));
            return;
        }
        int l = view.a();
        int j1 = view.b();
        boolean flag1;
        if (b > 1 && view.b() == b)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        d1.c(android.support.v4.view.a.d.j.a(i, 1, l, j1, flag1, false));
    }

    void a(RecyclerView.q q, LinearLayoutManager.a a1)
    {
        super.a(q, a1);
        B();
        if (q.e() > 0 && !q.a())
        {
            a(a1);
        }
        if (d == null || d.length != b)
        {
            d = new View[b];
        }
    }

    public void a(RecyclerView recyclerview)
    {
        g.a();
    }

    public void a(RecyclerView recyclerview, int i, int j)
    {
        g.a();
    }

    public void a(RecyclerView recyclerview, int i, int j, int l)
    {
        g.a();
    }

    public void a(c c1)
    {
        g = c1;
    }

    public boolean a(RecyclerView.i i)
    {
        return i instanceof b;
    }

    public int b(RecyclerView.m m, RecyclerView.q q)
    {
        if (mOrientation == 1)
        {
            return b;
        }
        if (q.e() < 1)
        {
            return 0;
        } else
        {
            return a(m, q, q.e() - 1);
        }
    }

    public void b(RecyclerView recyclerview, int i, int j)
    {
        g.a();
    }

    public boolean b()
    {
        return mPendingSavedState == null;
    }

    public void c(RecyclerView.m m, RecyclerView.q q)
    {
        if (q.a())
        {
            A();
        }
        super.c(m, q);
        z();
    }

    public void c(RecyclerView recyclerview, int i, int j)
    {
        g.a();
    }

}
