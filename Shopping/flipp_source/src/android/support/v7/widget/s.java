// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.e;
import android.support.v4.view.a.n;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import java.util.Arrays;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager, t, v, bf, 
//            az, u, au, av, 
//            RecyclerView, aa, z, af, 
//            bi, y

public final class s extends LinearLayoutManager
{

    static final int a = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
    int b;
    int c;
    View d[];
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    public v g;
    final Rect h = new Rect();

    public s(int i)
    {
        b = -1;
        g = new t();
        if (i != b)
        {
            if (i <= 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Span count should be at least 1. Provided ")).append(i).toString());
            }
            b = i;
            g.a.clear();
        }
    }

    private static int a(int i, int j, int k)
    {
        int l;
        if (j != 0 || k != 0)
        {
            if ((l = android.view.View.MeasureSpec.getMode(i)) == 0x80000000 || l == 0x40000000)
            {
                return android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i) - j - k, l);
            }
        }
        return i;
    }

    private int a(az az1, bf bf1, int i)
    {
        if (!bf1.i)
        {
            return g.c(i, b);
        }
        int j = az1.a(i);
        if (j == -1)
        {
            Log.w("GridLayoutManager", (new StringBuilder("Cannot find span size for pre layout position. ")).append(i).toString());
            return 0;
        } else
        {
            return g.c(j, b);
        }
    }

    private void a(az az1, bf bf1, int i, int j, boolean flag)
    {
        int k;
        int l;
        byte byte0;
        if (flag)
        {
            k = 1;
            boolean flag1 = false;
            l = i;
            i = ((flag1) ? 1 : 0);
        } else
        {
            i--;
            k = -1;
            l = -1;
        }
        if (this.i == 1 && g())
        {
            byte0 = -1;
            j--;
        } else
        {
            byte0 = 1;
            j = 0;
        }
        while (i != l) 
        {
            View view = d[i];
            u u1 = (u)view.getLayoutParams();
            u.a(u1, b(az1, bf1, a(view)));
            if (byte0 == -1 && u.b(u1) > 1)
            {
                u.b(u1, j - (u.b(u1) - 1));
            } else
            {
                u.b(u1, j);
            }
            j += u.b(u1) * byte0;
            i += k;
        }
    }

    private void a(View view, int i, int j)
    {
        Object obj = h;
        if (super.q == null)
        {
            ((Rect) (obj)).set(0, 0, 0, 0);
        } else
        {
            ((Rect) (obj)).set(super.q.d(view));
        }
        obj = (av)view.getLayoutParams();
        view.measure(a(i, ((av) (obj)).leftMargin + h.left, ((av) (obj)).rightMargin + h.right), a(j, ((av) (obj)).topMargin + h.top, ((av) (obj)).bottomMargin + h.bottom));
    }

    private int b(az az1, bf bf1, int i)
    {
        int j;
        if (!bf1.i)
        {
            j = g.a(i);
        } else
        {
            int l = e.get(i, -1);
            j = l;
            if (l == -1)
            {
                int k = az1.a(i);
                if (k == -1)
                {
                    Log.w("GridLayoutManager", (new StringBuilder("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:")).append(i).toString());
                    return 1;
                } else
                {
                    return g.a(k);
                }
            }
        }
        return j;
    }

    private static int g(int i)
    {
        if (i < 0)
        {
            return a;
        } else
        {
            return android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        }
    }

    public final int a(az az1, bf bf1)
    {
        if (i == 0)
        {
            return b;
        }
        if (bf1.a() <= 0)
        {
            return 0;
        } else
        {
            return a(az1, bf1, bf1.a() - 1);
        }
    }

    public final av a(Context context, AttributeSet attributeset)
    {
        return new u(context, attributeset);
    }

    public final av a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new u((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new u(layoutparams);
        }
    }

    public final void a()
    {
        g.a.clear();
    }

    public final void a(int i, int j)
    {
        g.a.clear();
    }

    final void a(az az1, bf bf1, aa aa1, z z1)
    {
        int i;
        int k;
        int j2;
        boolean flag3;
        boolean flag;
        int k1;
        if (aa1.e == 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag = false;
        k1 = 0;
        i = b;
        j2 = ((flag) ? 1 : 0);
        k = k1;
        if (flag3) goto _L2; else goto _L1
_L1:
        j2 = aa1.d;
        if (bf1.i) goto _L4; else goto _L3
_L3:
        i = g.b(j2, b);
_L7:
        i += b(az1, bf1, aa1.d);
        k = k1;
        j2 = ((flag) ? 1 : 0);
_L2:
        if (j2 >= b || !aa1.a(bf1) || i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k1 = aa1.d;
        int l = b(az1, bf1, k1);
        if (l > b)
        {
            throw new IllegalArgumentException((new StringBuilder("Item at position ")).append(k1).append(" requires ").append(l).append(" spans but GridLayoutManager has only ").append(b).append(" spans.").toString());
        }
        i -= l;
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        View view = aa1.a(az1);
        if (view == null)
        {
            break; /* Loop/switch isn't completed */
        }
        k += l;
        d[j2] = view;
        j2++;
        continue; /* Loop/switch isn't completed */
_L4:
        k = f.get(j2, -1);
        i = k;
        if (k == -1)
        {
            i = az1.a(j2);
            if (i == -1)
            {
                Log.w("GridLayoutManager", (new StringBuilder("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:")).append(j2).toString());
                i = 0;
            } else
            {
                i = g.b(i, b);
            }
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L5
_L5:
        if (j2 == 0)
        {
            z1.b = true;
            return;
        }
        a(az1, bf1, j2, k, flag3);
        k = 0;
        int j = 0;
        while (k < j2) 
        {
            View view1 = d[k];
            u u1;
            int i1;
            if (aa1.j == null)
            {
                if (flag3)
                {
                    super.a(view1, -1, false);
                } else
                {
                    super.a(view1, 0, false);
                }
            } else
            if (flag3)
            {
                super.a(view1, -1, true);
            } else
            {
                super.a(view1, 0, true);
            }
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(b(az1, bf1, a(view1)) * c, 0x40000000);
            u1 = (u)view1.getLayoutParams();
            if (this.i == 1)
            {
                a(view1, i1, g(u1.height));
            } else
            {
                a(view1, g(u1.width), i1);
            }
            i1 = this.j.c(view1);
            if (i1 > j)
            {
                j = i1;
            }
            k++;
        }
        int j1 = g(j);
        k = 0;
        while (k < j2) 
        {
            View view2 = d[k];
            if (this.j.c(view2) != j)
            {
                int l1 = android.view.View.MeasureSpec.makeMeasureSpec(b(az1, bf1, a(view2)) * c, 0x40000000);
                if (this.i == 1)
                {
                    a(view2, l1, j1);
                } else
                {
                    a(view2, j1, l1);
                }
            }
            k++;
        }
        z1.a = j;
        int i2 = 0;
        int k2;
        int l2;
        boolean flag2;
        if (this.i == 1)
        {
            if (aa1.f == -1)
            {
                i2 = aa1.b;
                j1 = 0;
                boolean flag1 = false;
                k = i2 - j;
                j = ((flag1) ? 1 : 0);
            } else
            {
                k = aa1.b;
                i2 = k + j;
                j = 0;
                j1 = 0;
            }
        } else
        if (aa1.f == -1)
        {
            j1 = aa1.b;
            j = j1 - j;
            k = 0;
        } else
        {
            k2 = aa1.b;
            k = 0;
            j1 = j + k2;
            j = k2;
        }
        flag2 = false;
        k2 = k;
        l2 = j;
        j = ((flag2) ? 1 : 0);
        k = j1;
        j1 = l2;
        while (j < j2) 
        {
            az1 = d[j];
            bf1 = (u)az1.getLayoutParams();
            if (this.i == 1)
            {
                j1 = m() + c * u.a(bf1);
                k = this.j.d(az1) + j1;
            } else
            {
                i2 = n();
                k2 = c * u.a(bf1) + i2;
                i2 = this.j.d(az1) + k2;
            }
            a(((View) (az1)), ((u) (bf1)).leftMargin + j1, ((u) (bf1)).topMargin + k2, k - ((u) (bf1)).rightMargin, i2 - ((u) (bf1)).bottomMargin);
            if (((av) (bf1)).c.m() || ((av) (bf1)).c.k())
            {
                z1.c = true;
            }
            z1.d = z1.d | az1.isFocusable();
            j++;
        }
        Arrays.fill(d, null);
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void a(az az1, bf bf1, View view, e e1)
    {
        boolean flag2 = false;
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (!(layoutparams instanceof u))
        {
            super.a(view, e1);
            return;
        }
        view = (u)layoutparams;
        int i = a(az1, bf1, ((av) (view)).c.c());
        if (this.i == 0)
        {
            int j = ((u) (view)).a;
            int l = ((u) (view)).b;
            boolean flag;
            if (b > 1 && ((u) (view)).b == b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            e1.a(n.a(j, l, i, 1, flag));
            return;
        }
        int k = ((u) (view)).a;
        int i1 = ((u) (view)).b;
        boolean flag1 = flag2;
        if (b > 1)
        {
            flag1 = flag2;
            if (((u) (view)).b == b)
            {
                flag1 = true;
            }
        }
        e1.a(n.a(i, 1, k, i1, flag1));
    }

    final void a(bf bf1, y y1)
    {
        super.a(bf1, y1);
        int i;
        if (super.i == 1)
        {
            i = k() - o() - m();
        } else
        {
            i = l() - p() - n();
        }
        c = i / b;
        if (bf1.a() > 0 && !bf1.i)
        {
            for (i = g.b(y1.a, b); i > 0 && y1.a > 0; i = g.b(y1.a, b))
            {
                y1.a = y1.a - 1;
            }

        }
        if (d == null || d.length != b)
        {
            d = new View[b];
        }
    }

    public final boolean a(av av1)
    {
        return av1 instanceof u;
    }

    public final int b(az az1, bf bf1)
    {
        if (i == 1)
        {
            return b;
        }
        if (bf1.a() <= 0)
        {
            return 0;
        } else
        {
            return a(az1, bf1, bf1.a() - 1);
        }
    }

    public final av b()
    {
        return new u();
    }

    public final void b(int i, int j)
    {
        g.a.clear();
    }

    public final void c(int i, int j)
    {
        g.a.clear();
    }

    public final void c(az az1, bf bf1)
    {
        if (bf1.i)
        {
            int j = j();
            for (int i = 0; i < j; i++)
            {
                u u1 = (u)c(i).getLayoutParams();
                int k = ((av) (u1)).c.c();
                e.put(k, u1.b);
                f.put(k, u1.a);
            }

        }
        super.c(az1, bf1);
        e.clear();
        f.clear();
    }

    public final boolean c()
    {
        return n == null;
    }

    public final void d(int i, int j)
    {
        g.a.clear();
    }

}
