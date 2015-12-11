// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.ag;
import android.support.v4.view.a.e;
import android.support.v4.view.a.n;
import android.support.v4.view.ap;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.BitSet;

// Referenced classes of package android.support.v7.widget:
//            au, w, af, bf, 
//            az, bo, av, bi, 
//            br, RecyclerView, bl, bm, 
//            bd, bn

public final class StaggeredGridLayoutManager extends au
{

    private boolean A;
    private final Runnable B;
    af a;
    af b;
    boolean c;
    int d;
    int e;
    LazySpanLookup f;
    private int g;
    private br h[];
    private int i;
    private int j;
    private w k;
    private boolean l;
    private BitSet m;
    private int n;
    private boolean o;
    private boolean t;
    private SavedState u;
    private int v;
    private int w;
    private int x;
    private final bn y;
    private boolean z;

    private static int a(int i1, int j1, int k1)
    {
        int l1;
        if (j1 != 0 || k1 != 0)
        {
            if ((l1 = android.view.View.MeasureSpec.getMode(i1)) == 0x80000000 || l1 == 0x40000000)
            {
                return android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i1) - j1 - k1, l1);
            }
        }
        return i1;
    }

    static int a(StaggeredGridLayoutManager staggeredgridlayoutmanager)
    {
        return staggeredgridlayoutmanager.i;
    }

    static int a(StaggeredGridLayoutManager staggeredgridlayoutmanager, int i1)
    {
        return staggeredgridlayoutmanager.i(i1);
    }

    private int a(az az1, w w1, bf bf1)
    {
        class LazySpanLookup.FullSpanItem
            implements Parcelable
        {

            public static final android.os.Parcelable.Creator CREATOR = new bp();
            int a;
            int b;
            int c[];

            final int a(int l4)
            {
                if (c == null)
                {
                    return 0;
                } else
                {
                    return c[l4];
                }
            }

            public int describeContents()
            {
                return 0;
            }

            public String toString()
            {
                return (new StringBuilder("FullSpanItem{mPosition=")).append(a).append(", mGapDir=").append(b).append(", mGapPerSpan=").append(Arrays.toString(c)).append('}').toString();
            }

            public void writeToParcel(Parcel parcel, int l4)
            {
                parcel.writeInt(a);
                parcel.writeInt(b);
                if (c != null && c.length > 0)
                {
                    parcel.writeInt(c.length);
                    parcel.writeIntArray(c);
                    return;
                } else
                {
                    parcel.writeInt(0);
                    return;
                }
            }


            public LazySpanLookup.FullSpanItem()
            {
            }

            public LazySpanLookup.FullSpanItem(Parcel parcel)
            {
                a = parcel.readInt();
                b = parcel.readInt();
                int i1 = parcel.readInt();
                if (i1 > 0)
                {
                    c = new int[i1];
                    parcel.readIntArray(c);
                }
            }
        }

        Object obj;
        Object obj1;
        View view;
        bo bo1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int j4;
        m.set(0, g, true);
        int k2;
        if (w1.d == 1)
        {
            k1 = a.c() + k.a;
            l1 = k.e + k1 + a.f();
        } else
        {
            k1 = a.b() - k.a;
            l1 = k1 - k.e - a.b();
        }
        e(w1.d, l1);
        if (c)
        {
            i2 = a.c();
        } else
        {
            i2 = a.b();
        }
_L14:
        if (w1.b >= 0 && w1.b < bf1.a())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0 || m.isEmpty()) goto _L2; else goto _L1
_L1:
        view = az1.b(w1.b);
        w1.b = w1.b + w1.c;
        bo1 = (bo)view.getLayoutParams();
        if (w1.d == 1)
        {
            super.a(view, -1, false);
        } else
        {
            super.a(view, 0, false);
        }
        if (bo1.b)
        {
            if (i == 1)
            {
                a(view, v, x);
            } else
            {
                a(view, w, v);
            }
        } else
        {
            a(view, w, x);
        }
        j4 = ((av) (bo1)).c.c();
        obj = f;
        if (((LazySpanLookup) (obj)).a == null || j4 >= ((LazySpanLookup) (obj)).a.length)
        {
            i1 = -1;
        } else
        {
            i1 = ((LazySpanLookup) (obj)).a[j4];
        }
        if (i1 == -1)
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        if (j2 == 0) goto _L4; else goto _L3
_L3:
        if (!bo1.b) goto _L6; else goto _L5
_L5:
        obj = h[0];
_L9:
        obj1 = f;
        ((LazySpanLookup) (obj1)).c(j4);
        ((LazySpanLookup) (obj1)).a[j4] = ((br) (obj)).e;
_L12:
        if (w1.d == 1)
        {
            int l2;
            int k3;
            int i4;
            int k4;
            boolean flag;
            if (bo1.b)
            {
                i1 = h(i2);
            } else
            {
                i1 = ((br) (obj)).b(i2);
            }
            j1 = i1 + a.c(view);
            if (j2 == 0 || !bo1.b)
            {
                break MISSING_BLOCK_LABEL_1795;
            }
            obj1 = new LazySpanLookup.FullSpanItem();
            obj1.c = new int[g];
            for (k2 = 0; k2 < g; k2++)
            {
                ((LazySpanLookup.FullSpanItem) (obj1)).c[k2] = i1 - h[k2].b(i1);
            }

            obj1.b = -1;
            obj1.a = j4;
            f.a(((LazySpanLookup.FullSpanItem) (obj1)));
            l2 = j1;
            j1 = i1;
            i1 = l2;
        } else
        {
            int i3;
            if (bo1.b)
            {
                i1 = g(i2);
            } else
            {
                i1 = ((br) (obj)).a(i2);
            }
            i3 = a.c(view);
            if (j2 != 0 && bo1.b)
            {
                obj1 = new LazySpanLookup.FullSpanItem();
                obj1.c = new int[g];
                for (j1 = 0; j1 < g; j1++)
                {
                    ((LazySpanLookup.FullSpanItem) (obj1)).c[j1] = h[j1].a(i1) - i1;
                }

                obj1.b = 1;
                obj1.a = j4;
                f.a(((LazySpanLookup.FullSpanItem) (obj1)));
            }
            j1 = i1 - i3;
        }
          goto _L7
_L6:
        i1 = w1.d;
        if (i == 0)
        {
            if (i1 == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag != c)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        } else
        {
            if (i1 == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag == c)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag == s())
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        }
        if (i1 != 0)
        {
            i1 = g - 1;
            j1 = -1;
            l2 = -1;
        } else
        {
            i1 = 0;
            j1 = g;
            l2 = 1;
        }
        if (w1.d != 1)
        {
            break MISSING_BLOCK_LABEL_750;
        }
        obj1 = null;
        i4 = 0x7fffffff;
        k4 = a.b();
        k3 = i1;
        i1 = i4;
        obj = obj1;
        if (k3 == j1) goto _L9; else goto _L8
_L8:
        obj = h[k3];
        i4 = ((br) (obj)).b(k4);
        int j3;
        int l3;
        if (i4 < i1)
        {
            i1 = i4;
        } else
        {
            obj = obj1;
        }
        k3 += l2;
        obj1 = obj;
        break MISSING_BLOCK_LABEL_615;
        obj1 = null;
        i4 = 0x80000000;
        k4 = a.c();
        k3 = i1;
        i1 = i4;
_L11:
        obj = obj1;
        if (k3 == j1) goto _L9; else goto _L10
_L10:
        obj = h[k3];
        i4 = ((br) (obj)).a(k4);
        if (i4 > i1)
        {
            i1 = i4;
        } else
        {
            obj = obj1;
        }
        k3 += l2;
        obj1 = obj;
          goto _L11
          goto _L9
_L4:
        obj = h[i1];
          goto _L12
_L7:
        if (bo1.b && w1.c == -1 && j2 != 0)
        {
            z = true;
        }
        bo1.a = ((br) (obj));
        if (w1.d == 1)
        {
            if (bo1.b)
            {
                for (j2 = g - 1; j2 >= 0; j2--)
                {
                    h[j2].b(view);
                }

            } else
            {
                bo1.a.b(view);
            }
        } else
        if (bo1.b)
        {
            j2 = g - 1;
            while (j2 >= 0) 
            {
                h[j2].a(view);
                j2--;
            }
        } else
        {
            bo1.a.a(view);
        }
        if (bo1.b)
        {
            j2 = b.b();
        } else
        {
            j2 = ((br) (obj)).e * j + b.b();
        }
        j3 = b.c(view) + j2;
        if (i == 1)
        {
            b(view, j2, j1, j3, i1);
        } else
        {
            b(view, j1, j2, i1, j3);
        }
        if (bo1.b)
        {
            e(k.d, l1);
        } else
        {
            a(((br) (obj)), k.d, l1);
        }
        if (k.d != -1)
        {
            break MISSING_BLOCK_LABEL_1530;
        }
        j3 = ((br) (obj)).a();
        i1 = h[0].a(j3);
        for (j1 = 1; j1 < g; j1++)
        {
            j2 = h[j1].a(j3);
            if (j2 > i1)
            {
                i1 = j2;
            }
        }

        j2 = Math.max(k1, i1);
        j3 = a.d();
        l3 = a.b();
        i1 = j() - 1;
_L16:
        if (i1 < 0) goto _L14; else goto _L13
_L13:
        obj = c(i1);
        if (a.a(((View) (obj))) <= j2 + (j3 - l3)) goto _L14; else goto _L15
_L15:
        obj1 = (bo)((View) (obj)).getLayoutParams();
        if (((bo) (obj1)).b)
        {
            for (j1 = 0; j1 < g; j1++)
            {
                h[j1].d();
            }

        } else
        {
            ((bo) (obj1)).a.d();
        }
        a(((View) (obj)), az1);
        i1--;
          goto _L16
        j3 = ((br) (obj)).b();
        i1 = h[0].b(j3);
        for (j1 = 1; j1 < g; j1++)
        {
            j2 = h[j1].b(j3);
            if (j2 < i1)
            {
                i1 = j2;
            }
        }

        j1 = Math.min(k1, i1);
        j2 = a.d();
        j3 = a.b();
_L19:
        if (j() <= 0) goto _L14; else goto _L17
_L17:
        obj = c(0);
        if (a.b(((View) (obj))) >= j1 - (j2 - j3)) goto _L14; else goto _L18
_L18:
        obj1 = (bo)((View) (obj)).getLayoutParams();
        if (((bo) (obj1)).b)
        {
            for (i1 = 0; i1 < g; i1++)
            {
                h[i1].e();
            }

        } else
        {
            ((bo) (obj1)).a.e();
        }
        a(((View) (obj)), az1);
          goto _L19
_L2:
        if (k.d == -1)
        {
            return Math.max(0, (k1 - g(a.b())) + k.a);
        } else
        {
            return Math.max(0, (h(a.c()) - k1) + k.a);
        }
        j3 = i1;
        i1 = j1;
        j1 = j3;
          goto _L7
    }

    private View a(boolean flag)
    {
        g();
        int j1 = a.b();
        int k1 = a.c();
        int l1 = j();
        for (int i1 = 0; i1 < l1; i1++)
        {
            View view = c(i1);
            if ((!flag || a.a(view) >= j1) && a.b(view) <= k1)
            {
                return view;
            }
        }

        return null;
    }

    private void a(int i1, bf bf1)
    {
        boolean flag = true;
        k.a = 0;
        k.b = i1;
        if (!i())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        int j1 = bf1.a;
        boolean flag2 = c;
        boolean flag1;
        if (j1 < i1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag2 == flag1)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        k.e = a.e();
_L1:
        k.d = -1;
        bf1 = k;
        if (c)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = -1;
        }
        bf1.c = i1;
        return;
        k.e = 0;
          goto _L1
    }

    private void a(az az1, bf bf1, boolean flag)
    {
        int i1 = h(a.c());
        i1 = a.c() - i1;
        if (i1 > 0)
        {
            i1 -= -d(-i1, az1, bf1);
            if (flag && i1 > 0)
            {
                a.a(i1);
            }
        }
    }

    private void a(br br1, int i1, int j1)
    {
        int k1 = br1.d;
        if (i1 == -1)
        {
            if (k1 + br1.a() < j1)
            {
                m.set(br1.e, false);
            }
        } else
        if (br1.b() - k1 > j1)
        {
            m.set(br1.e, false);
            return;
        }
    }

    private void a(View view, int i1, int j1)
    {
        Rect rect = q.d(view);
        bo bo1 = (bo)view.getLayoutParams();
        view.measure(a(i1, bo1.leftMargin + rect.left, bo1.rightMargin + rect.right), a(j1, bo1.topMargin + rect.top, bo1.bottomMargin + rect.bottom));
    }

    private View b(boolean flag)
    {
        g();
        int j1 = a.b();
        int k1 = a.c();
        for (int i1 = j() - 1; i1 >= 0; i1--)
        {
            View view = c(i1);
            if (a.a(view) >= j1 && (!flag || a.b(view) <= k1))
            {
                return view;
            }
        }

        return null;
    }

    private void b(int i1, int j1, int k1)
    {
        int l1;
        if (c)
        {
            l1 = t();
        } else
        {
            l1 = u();
        }
        f.b(i1);
        k1;
        JVM INSTR tableswitch 0 3: default 52
    //                   0 70
    //                   1 82
    //                   2 52
    //                   3 94;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        if (i1 + j1 > l1) goto _L6; else goto _L5
_L5:
        return;
_L2:
        f.b(i1, j1);
        continue; /* Loop/switch isn't completed */
_L3:
        f.a(i1, j1);
        continue; /* Loop/switch isn't completed */
_L4:
        f.a(i1, 1);
        f.b(j1, 1);
        continue; /* Loop/switch isn't completed */
_L6:
        if (c)
        {
            j1 = u();
        } else
        {
            j1 = t();
        }
        if (i1 > j1) goto _L5; else goto _L7
_L7:
        h();
        return;
        if (true) goto _L1; else goto _L8
_L8:
    }

    private void b(int i1, bf bf1)
    {
        boolean flag;
        flag = true;
        k.a = 0;
        k.b = i1;
        if (!i()) goto _L2; else goto _L1
_L1:
        int j1 = bf1.a;
        boolean flag2 = c;
        boolean flag1;
        if (j1 > i1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag2 == flag1) goto _L2; else goto _L3
_L3:
        k.e = a.e();
_L5:
        k.d = 1;
        bf1 = k;
        i1 = ((flag) ? 1 : 0);
        if (c)
        {
            i1 = -1;
        }
        bf1.c = i1;
        return;
_L2:
        k.e = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void b(az az1, bf bf1, boolean flag)
    {
        int i1 = g(a.b()) - a.b();
        if (i1 > 0)
        {
            i1 -= d(i1, az1, bf1);
            if (flag && i1 > 0)
            {
                a.a(-i1);
            }
        }
    }

    private static void b(View view, int i1, int j1, int k1, int l1)
    {
        bo bo1 = (bo)view.getLayoutParams();
        a(view, bo1.leftMargin + i1, bo1.topMargin + j1, k1 - bo1.rightMargin, l1 - bo1.bottomMargin);
    }

    private int d(int i1, az az1, bf bf1)
    {
        int j1 = 1;
        int k1 = -1;
        g();
        if (i1 > 0)
        {
            k.d = 1;
            w w1 = k;
            int l1;
            if (c)
            {
                j1 = k1;
            } else
            {
                j1 = 1;
            }
            w1.c = j1;
            j1 = t();
        } else
        {
            k.d = -1;
            w w2 = k;
            if (!c)
            {
                j1 = -1;
            }
            w2.c = j1;
            j1 = u();
        }
        k.b = j1 + k.c;
        l1 = Math.abs(i1);
        k.a = l1;
        w1 = k;
        if (i())
        {
            j1 = a.e();
        } else
        {
            j1 = 0;
        }
        w1.e = j1;
        k1 = a(az1, k, bf1);
        j1 = i1;
        if (l1 >= k1)
        {
            if (i1 < 0)
            {
                j1 = -k1;
            } else
            {
                j1 = k1;
            }
        }
        a.a(-j1);
        o = c;
        return j1;
    }

    private void e(int i1, int j1)
    {
        for (int k1 = 0; k1 < g; k1++)
        {
            if (!h[k1].a.isEmpty())
            {
                a(h[k1], i1, j1);
            }
        }

    }

    private int g(int i1)
    {
        int k1 = h[0].a(i1);
        for (int j1 = 1; j1 < g;)
        {
            int i2 = h[j1].a(i1);
            int l1 = k1;
            if (i2 < k1)
            {
                l1 = i2;
            }
            j1++;
            k1 = l1;
        }

        return k1;
    }

    private int g(bf bf1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        g();
        af af1 = a;
        View view;
        boolean flag;
        if (!A)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!A)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.bl.a(bf1, af1, view, b(flag), this, A, c);
    }

    private void g()
    {
        if (a == null)
        {
            a = android.support.v7.widget.af.a(this, i);
            b = android.support.v7.widget.af.a(this, 1 - i);
            k = new w();
        }
    }

    private int h(int i1)
    {
        int k1 = h[0].b(i1);
        for (int j1 = 1; j1 < g;)
        {
            int i2 = h[j1].b(i1);
            int l1 = k1;
            if (i2 > k1)
            {
                l1 = i2;
            }
            j1++;
            k1 = l1;
        }

        return k1;
    }

    private int h(bf bf1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        g();
        af af1 = a;
        View view;
        boolean flag;
        if (!A)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!A)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.bl.a(bf1, af1, view, b(flag), this, A);
    }

    private int i(int i1)
    {
        if (j() != 0) goto _L2; else goto _L1
_L1:
        if (!c) goto _L4; else goto _L3
_L3:
        return 1;
_L4:
        return -1;
_L2:
        boolean flag;
        if (i1 < u())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag != c)
        {
            return -1;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private int i(bf bf1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        g();
        af af1 = a;
        View view;
        boolean flag;
        if (!A)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!A)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return bl.b(bf1, af1, view, b(flag), this, A);
    }

    private void r()
    {
        boolean flag = true;
        if (i != 1 && s()) goto _L2; else goto _L1
_L1:
        flag = l;
_L4:
        c = flag;
        return;
_L2:
        if (l)
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean s()
    {
        return ap.h(super.q) == 1;
    }

    private int t()
    {
        int i1 = j();
        if (i1 == 0)
        {
            return 0;
        } else
        {
            return a(c(i1 - 1));
        }
    }

    private int u()
    {
        if (j() == 0)
        {
            return 0;
        } else
        {
            return a(c(0));
        }
    }

    public final int a(int i1, az az1, bf bf1)
    {
        return d(i1, az1, bf1);
    }

    public final int a(az az1, bf bf1)
    {
        if (i == 0)
        {
            return g;
        } else
        {
            return super.a(az1, bf1);
        }
    }

    public final int a(bf bf1)
    {
        return g(bf1);
    }

    public final av a(Context context, AttributeSet attributeset)
    {
        return new bo(context, attributeset);
    }

    public final av a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new bo((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new bo(layoutparams);
        }
    }

    public final void a()
    {
        f.a();
        h();
    }

    public final void a(int i1, int j1)
    {
        b(i1, j1, 0);
    }

    public final void a(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            u = (SavedState)parcelable;
            h();
        }
    }

    public final void a(RecyclerView recyclerview, int i1)
    {
        recyclerview = new bm(this, recyclerview.getContext());
        recyclerview.g = i1;
        a(((bd) (recyclerview)));
    }

    public final void a(RecyclerView recyclerview, az az1)
    {
        for (int i1 = 0; i1 < g; i1++)
        {
            h[i1].c();
        }

    }

    public final void a(az az1, bf bf1, View view, e e1)
    {
        int k1 = 1;
        int i1 = 1;
        int j1 = -1;
        az1 = view.getLayoutParams();
        if (!(az1 instanceof bo))
        {
            super.a(view, e1);
            return;
        }
        az1 = (bo)az1;
        int l1;
        if (i == 0)
        {
            l1 = az1.a();
            if (((bo) (az1)).b)
            {
                i1 = g;
            }
            byte byte0 = -1;
            k1 = i1;
            i1 = byte0;
        } else
        {
            i1 = az1.a();
            if (((bo) (az1)).b)
            {
                int i2 = g;
                l1 = -1;
                j1 = i1;
                k1 = -1;
                i1 = i2;
            } else
            {
                l1 = -1;
                j1 = i1;
                byte byte1 = -1;
                i1 = k1;
                k1 = byte1;
            }
        }
        e1.a(android.support.v4.view.a.n.a(l1, k1, j1, i1, ((bo) (az1)).b));
    }

    public final void a(AccessibilityEvent accessibilityevent)
    {
        View view;
        View view1;
label0:
        {
            super.a(accessibilityevent);
            if (j() > 0)
            {
                accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
                view = a(false);
                view1 = b(false);
                if (view != null && view1 != null)
                {
                    break label0;
                }
            }
            return;
        }
        int i1 = a(view);
        int j1 = a(view1);
        if (i1 < j1)
        {
            accessibilityevent.b(i1);
            accessibilityevent.c(j1);
            return;
        } else
        {
            accessibilityevent.b(j1);
            accessibilityevent.c(i1);
            return;
        }
    }

    public final void a(String s1)
    {
        if (u == null)
        {
            super.a(s1);
        }
    }

    public final boolean a(av av1)
    {
        return av1 instanceof bo;
    }

    public final int b(int i1, az az1, bf bf1)
    {
        return d(i1, az1, bf1);
    }

    public final int b(az az1, bf bf1)
    {
        if (i == 1)
        {
            return g;
        } else
        {
            return super.b(az1, bf1);
        }
    }

    public final int b(bf bf1)
    {
        return g(bf1);
    }

    public final av b()
    {
        return new bo();
    }

    public final void b(int i1)
    {
        if (u != null && u.a != i1)
        {
            SavedState savedstate = u;
            savedstate.d = null;
            savedstate.c = 0;
            savedstate.a = -1;
            savedstate.b = -1;
        }
        d = i1;
        e = 0x80000000;
        h();
    }

    public final void b(int i1, int j1)
    {
        b(i1, j1, 1);
    }

    public final int c(bf bf1)
    {
        return h(bf1);
    }

    public final void c(int i1, int j1)
    {
        b(i1, j1, 2);
    }

    public final void c(az az1, bf bf1)
    {
        bn bn1;
        int j1;
        g();
        bn1 = y;
        bn1.a = -1;
        bn1.b = 0x80000000;
        bn1.c = false;
        bn1.d = false;
        if (u != null)
        {
            if (u.c > 0)
            {
                if (u.c == g)
                {
                    int l1 = 0;
                    while (l1 < g) 
                    {
                        h[l1].c();
                        int l2 = u.d[l1];
                        int i1 = l2;
                        if (l2 != 0x80000000)
                        {
                            if (u.i)
                            {
                                i1 = l2 + a.c();
                            } else
                            {
                                i1 = l2 + a.b();
                            }
                        }
                        h[l1].c(i1);
                        l1++;
                    }
                } else
                {
                    SavedState savedstate = u;
                    savedstate.d = null;
                    savedstate.c = 0;
                    savedstate.e = 0;
                    savedstate.f = null;
                    savedstate.g = null;
                    u.a = u.b;
                }
            }
            t = u.j;
            boolean flag = u.h;
            a(((String) (null)));
            if (u != null && u.h != flag)
            {
                u.h = flag;
            }
            l = flag;
            h();
            r();
            int i2;
            int i3;
            if (u.a != -1)
            {
                d = u.a;
                bn1.c = u.i;
            } else
            {
                bn1.c = c;
            }
            if (u.e > 1)
            {
                f.a = u.f;
                f.b = u.g;
            }
        } else
        {
            r();
            bn1.c = c;
        }
        if (!bf1.i && d != -1) goto _L2; else goto _L1
_L1:
        j1 = 0;
_L22:
        if (j1 != 0) goto _L4; else goto _L3
_L3:
        if (!o) goto _L6; else goto _L5
_L5:
        i3 = bf1.a();
        j1 = j() - 1;
_L15:
        if (j1 < 0) goto _L8; else goto _L7
_L7:
        i2 = a(c(j1));
        if (i2 < 0 || i2 >= i3)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = i2;
_L16:
        bn1.a = j1;
        bn1.b = 0x80000000;
          goto _L4
_L2:
        if (d < 0 || d >= bf1.a())
        {
            d = -1;
            e = 0x80000000;
            j1 = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (u != null && u.a != -1 && u.c > 0) goto _L10; else goto _L9
_L9:
        view = a(d);
        if (view == null) goto _L12; else goto _L11
_L11:
        if (c)
        {
            j1 = t();
        } else
        {
            j1 = u();
        }
        bn1.a = j1;
        if (e != 0x80000000)
        {
            if (bn1.c)
            {
                bn1.b = a.c() - e - a.b(view);
            } else
            {
                bn1.b = (a.b() + e) - a.a(view);
            }
            j1 = 1;
            continue; /* Loop/switch isn't completed */
        }
        if (a.c(view) > a.e())
        {
            if (bn1.c)
            {
                j1 = a.c();
            } else
            {
                j1 = a.b();
            }
            bn1.b = j1;
        } else
        {
            j1 = a.a(view) - a.b();
            if (j1 < 0)
            {
                bn1.b = -j1;
            } else
            {
                j1 = a.c() - a.b(view);
                if (j1 < 0)
                {
                    bn1.b = j1;
                } else
                {
                    bn1.b = 0x80000000;
                }
            }
        }
_L14:
        j1 = 1;
        continue; /* Loop/switch isn't completed */
_L12:
        bn1.a = d;
        if (e == 0x80000000)
        {
            boolean flag1;
            if (i(bn1.a) == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            bn1.c = flag1;
            if (bn1.c)
            {
                j1 = bn1.e.a.c();
            } else
            {
                j1 = bn1.e.a.b();
            }
            bn1.b = j1;
        } else
        {
            j1 = e;
            if (bn1.c)
            {
                bn1.b = bn1.e.a.c() - j1;
            } else
            {
                bn1.b = j1 + bn1.e.a.b();
            }
        }
        bn1.d = true;
        continue; /* Loop/switch isn't completed */
_L10:
        bn1.b = 0x80000000;
        bn1.a = d;
        if (true) goto _L14; else goto _L13
_L13:
        j1--;
          goto _L15
_L8:
        j1 = 0;
          goto _L16
_L6:
        l3 = bf1.a();
        j4 = j();
        j2 = 0;
_L20:
        if (j2 >= j4) goto _L18; else goto _L17
_L17:
        j3 = a(c(j2));
        if (j3 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = j3;
        if (j3 < l3) goto _L16; else goto _L19
_L19:
        j2++;
          goto _L20
_L18:
        j1 = 0;
          goto _L16
_L4:
        if (u == null && (bn1.c != o || s() != t))
        {
            f.a();
            bn1.d = true;
        }
        View view;
        int j2;
        int j3;
        int l3;
        int j4;
        if (j() > 0 && (u == null || u.c <= 0))
        {
            if (bn1.d)
            {
                for (j1 = 0; j1 < g; j1++)
                {
                    h[j1].c();
                    if (bn1.b != 0x80000000)
                    {
                        h[j1].c(bn1.b);
                    }
                }

            } else
            {
                int k2 = 0;
                while (k2 < g) 
                {
                    br br1 = h[k2];
                    boolean flag2 = c;
                    int i4 = bn1.b;
                    int k1;
                    if (flag2)
                    {
                        k1 = br1.b(0x80000000);
                    } else
                    {
                        k1 = br1.a(0x80000000);
                    }
                    br1.c();
                    if (k1 != 0x80000000 && (!flag2 || k1 >= br1.f.a.c()) && (flag2 || k1 <= br1.f.a.b()))
                    {
                        int k3 = k1;
                        if (i4 != 0x80000000)
                        {
                            k3 = k1 + i4;
                        }
                        br1.c = k3;
                        br1.b = k3;
                    }
                    k2++;
                }
            }
        }
        a(az1);
        z = false;
        j = b.e() / g;
        v = android.view.View.MeasureSpec.makeMeasureSpec(b.e(), 0x40000000);
        if (i == 1)
        {
            w = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            x = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        } else
        {
            x = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            w = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        if (bn1.c)
        {
            a(bn1.a, bf1);
            a(az1, k, bf1);
            b(bn1.a, bf1);
            w w1 = k;
            w1.b = w1.b + k.c;
            a(az1, k, bf1);
        } else
        {
            b(bn1.a, bf1);
            a(az1, k, bf1);
            a(bn1.a, bf1);
            w w2 = k;
            w2.b = w2.b + k.c;
            a(az1, k, bf1);
        }
        if (j() > 0)
        {
            if (c)
            {
                a(az1, bf1, true);
                b(az1, bf1, false);
            } else
            {
                b(az1, bf1, true);
                a(az1, bf1, false);
            }
        }
        if (!bf1.i)
        {
            if (j() > 0 && d != -1 && z)
            {
                ap.a(c(0), B);
            }
            d = -1;
            e = 0x80000000;
        }
        o = bn1.c;
        t = s();
        u = null;
        return;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public final boolean c()
    {
        return u == null;
    }

    public final int d(bf bf1)
    {
        return h(bf1);
    }

    public final Parcelable d()
    {
        if (u != null)
        {
            return new SavedState(u);
        }
        SavedState savedstate = new SavedState();
        savedstate.h = l;
        savedstate.i = o;
        savedstate.j = t;
        if (f != null && f.a != null)
        {
            savedstate.f = f.a;
            savedstate.e = savedstate.f.length;
            savedstate.g = f.b;
        } else
        {
            savedstate.e = 0;
        }
        if (j() > 0)
        {
            g();
            View view;
            int i1;
            int j1;
            if (o)
            {
                i1 = t();
            } else
            {
                i1 = u();
            }
            savedstate.a = i1;
            if (c)
            {
                view = b(true);
            } else
            {
                view = a(true);
            }
            if (view == null)
            {
                i1 = -1;
            } else
            {
                i1 = a(view);
            }
            savedstate.b = i1;
            savedstate.c = g;
            savedstate.d = new int[g];
            j1 = 0;
            while (j1 < g) 
            {
                if (o)
                {
                    int k1 = h[j1].b(0x80000000);
                    i1 = k1;
                    if (k1 != 0x80000000)
                    {
                        i1 = k1 - a.c();
                    }
                } else
                {
                    int l1 = h[j1].a(0x80000000);
                    i1 = l1;
                    if (l1 != 0x80000000)
                    {
                        i1 = l1 - a.b();
                    }
                }
                savedstate.d[j1] = i1;
                j1++;
            }
        } else
        {
            savedstate.a = -1;
            savedstate.b = -1;
            savedstate.c = 0;
        }
        return savedstate;
    }

    public final void d(int i1)
    {
        super.d(i1);
        for (int j1 = 0; j1 < g; j1++)
        {
            h[j1].d(i1);
        }

    }

    public final void d(int i1, int j1)
    {
        b(i1, j1, 3);
    }

    public final int e(bf bf1)
    {
        return i(bf1);
    }

    public final void e(int i1)
    {
        super.e(i1);
        for (int j1 = 0; j1 < g; j1++)
        {
            h[j1].d(i1);
        }

    }

    public final boolean e()
    {
        return i == 0;
    }

    public final int f(bf bf1)
    {
        return i(bf1);
    }

    public final void f(int i1)
    {
        if (i1 == 0 && j() != 0 && n != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view;
        BitSet bitset;
        bo bo1;
        Object obj;
        int j1;
        int k1;
        byte byte0;
        int l1;
        byte byte1;
        int i2;
        if (c)
        {
            k1 = t();
            j1 = u();
        } else
        {
            k1 = u();
            j1 = t();
        }
        if (k1 != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = j() - 1;
        bitset = new BitSet(g);
        bitset.set(0, g, true);
        if (i == 1 && s())
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        if (c)
        {
            i1 = l1 - 1;
            l1 = -1;
        } else
        {
            i1 = 0;
        }
        if (i1 < l1)
        {
            byte1 = 1;
        } else
        {
            byte1 = -1;
        }
        i2 = i1;
_L20:
        if (i2 == l1) goto _L4; else goto _L3
_L3:
        view = c(i2);
        bo1 = (bo)view.getLayoutParams();
        if (!bitset.get(bo1.a.e)) goto _L6; else goto _L5
_L5:
        obj = bo1.a;
        if (!c) goto _L8; else goto _L7
_L7:
        if (((br) (obj)).b() >= a.c()) goto _L10; else goto _L9
_L9:
        i1 = 1;
_L14:
        if (i1 == 0) goto _L12; else goto _L11
_L11:
        if (view == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        f.a();
_L22:
        super.s = true;
        h();
        return;
_L8:
        if (((br) (obj)).a() <= a.b()) goto _L10; else goto _L13
_L13:
        i1 = 1;
          goto _L14
_L10:
        i1 = 0;
          goto _L14
_L12:
        bitset.clear(bo1.a.e);
_L6:
        if (bo1.b || i2 + byte1 == l1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = c(i2 + byte1);
        i1 = 0;
        if (!c) goto _L16; else goto _L15
_L15:
        int j2;
        int l2;
        j2 = a.b(view);
        l2 = a.b(((View) (obj)));
        if (j2 >= l2) goto _L17; else goto _L11
_L17:
        if (j2 == l2)
        {
            i1 = 1;
        }
_L19:
        if (i1 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (bo)((View) (obj)).getLayoutParams();
        int k2;
        int i3;
        if (bo1.a.e - ((bo) (obj)).a.e < 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (byte0 < 0)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (i1 == k2)
        {
            continue; /* Loop/switch isn't completed */
        }
          goto _L11
_L16:
        k2 = a.a(view);
        i3 = a.a(((View) (obj)));
        if (k2 <= i3) goto _L18; else goto _L11
_L18:
        if (k2 == i3)
        {
            i1 = 1;
        }
          goto _L19
        i2 += byte1;
          goto _L20
_L4:
        view = null;
          goto _L11
        if (!z) goto _L1; else goto _L21
_L21:
        LazySpanLookup.FullSpanItem fullspanitem;
        if (c)
        {
            i1 = -1;
        } else
        {
            i1 = 1;
        }
        fullspanitem = f.a(k1, j1 + 1, i1);
        if (fullspanitem == null)
        {
            z = false;
            f.a(j1 + 1);
            return;
        }
        LazySpanLookup.FullSpanItem fullspanitem1 = f.a(k1, fullspanitem.a, i1 * -1);
        if (fullspanitem1 == null)
        {
            f.a(fullspanitem.a);
        } else
        {
            f.a(fullspanitem1.a + 1);
        }
          goto _L22
    }

    public final boolean f()
    {
        return i == 1;
    }

    private class LazySpanLookup
    {

        int a[];
        List b;

        final int a(int i1)
        {
            if (b != null)
            {
                for (int j1 = b.size() - 1; j1 >= 0; j1--)
                {
                    if (((FullSpanItem)b.get(j1)).a >= i1)
                    {
                        b.remove(j1);
                    }
                }

            }
            return b(i1);
        }

        public final FullSpanItem a(int i1, int j1, int k1)
        {
            if (b != null) goto _L2; else goto _L1
_L1:
            FullSpanItem fullspanitem = null;
_L6:
            return fullspanitem;
_L2:
            int l1 = 0;
_L8:
            if (l1 >= b.size()) goto _L4; else goto _L3
_L3:
            FullSpanItem fullspanitem1;
            fullspanitem1 = (FullSpanItem)b.get(l1);
            if (fullspanitem1.a >= j1)
            {
                return null;
            }
            if (fullspanitem1.a < i1)
            {
                continue; /* Loop/switch isn't completed */
            }
            fullspanitem = fullspanitem1;
            if (k1 == 0) goto _L6; else goto _L5
_L5:
            fullspanitem = fullspanitem1;
            if (fullspanitem1.b == k1) goto _L6; else goto _L7
_L7:
            l1++;
              goto _L8
_L4:
            return null;
        }

        final void a()
        {
            if (a != null)
            {
                Arrays.fill(a, -1);
            }
            b = null;
        }

        final void a(int i1, int j1)
        {
            if (a != null && i1 < a.length) goto _L2; else goto _L1
_L1:
            return;
_L2:
            c(i1 + j1);
            System.arraycopy(a, i1 + j1, a, i1, a.length - i1 - j1);
            Arrays.fill(a, a.length - j1, a.length, -1);
            if (b != null)
            {
                int k1 = b.size() - 1;
                while (k1 >= 0) 
                {
                    FullSpanItem fullspanitem = (FullSpanItem)b.get(k1);
                    if (fullspanitem.a >= i1)
                    {
                        if (fullspanitem.a < i1 + j1)
                        {
                            b.remove(k1);
                        } else
                        {
                            fullspanitem.a = fullspanitem.a - j1;
                        }
                    }
                    k1--;
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public final void a(FullSpanItem fullspanitem)
        {
            if (b == null)
            {
                b = new ArrayList();
            }
            int j1 = b.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                FullSpanItem fullspanitem1 = (FullSpanItem)b.get(i1);
                if (fullspanitem1.a == fullspanitem.a)
                {
                    b.remove(i1);
                }
                if (fullspanitem1.a >= fullspanitem.a)
                {
                    b.add(i1, fullspanitem);
                    return;
                }
            }

            b.add(fullspanitem);
        }

        final int b(int i1)
        {
            if (a == null)
            {
                return -1;
            }
            if (i1 >= a.length)
            {
                return -1;
            }
            if (b == null) goto _L2; else goto _L1
_L1:
            int j1;
            int k1;
            FullSpanItem fullspanitem = d(i1);
            if (fullspanitem != null)
            {
                b.remove(fullspanitem);
            }
            k1 = b.size();
            j1 = 0;
_L6:
            if (j1 >= k1)
            {
                break MISSING_BLOCK_LABEL_175;
            }
            if (((FullSpanItem)b.get(j1)).a < i1) goto _L4; else goto _L3
_L3:
            if (j1 == -1) goto _L2; else goto _L5
_L5:
            FullSpanItem fullspanitem1 = (FullSpanItem)b.get(j1);
            b.remove(j1);
            j1 = fullspanitem1.a;
_L7:
            if (j1 == -1)
            {
                Arrays.fill(a, i1, a.length, -1);
                return a.length;
            } else
            {
                Arrays.fill(a, i1, j1 + 1, -1);
                return j1 + 1;
            }
_L4:
            j1++;
              goto _L6
_L2:
            j1 = -1;
              goto _L7
            j1 = -1;
              goto _L3
        }

        final void b(int i1, int j1)
        {
            if (a != null && i1 < a.length) goto _L2; else goto _L1
_L1:
            return;
_L2:
            c(i1 + j1);
            System.arraycopy(a, i1, a, i1 + j1, a.length - i1 - j1);
            Arrays.fill(a, i1, i1 + j1, -1);
            if (b != null)
            {
                int k1 = b.size() - 1;
                while (k1 >= 0) 
                {
                    FullSpanItem fullspanitem = (FullSpanItem)b.get(k1);
                    if (fullspanitem.a >= i1)
                    {
                        fullspanitem.a = fullspanitem.a + j1;
                    }
                    k1--;
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        final void c(int i1)
        {
            if (a == null)
            {
                a = new int[Math.max(i1, 10) + 1];
                Arrays.fill(a, -1);
            } else
            if (i1 >= a.length)
            {
                int ai[] = a;
                int j1;
                for (j1 = a.length; j1 <= i1; j1 *= 2) { }
                a = new int[j1];
                System.arraycopy(ai, 0, a, 0, ai.length);
                Arrays.fill(a, ai.length, a.length, -1);
                return;
            }
        }

        public final FullSpanItem d(int i1)
        {
            if (b != null) goto _L2; else goto _L1
_L1:
            FullSpanItem fullspanitem = null;
_L4:
            return fullspanitem;
_L2:
            int j1 = b.size() - 1;
label0:
            do
            {
label1:
                {
                    if (j1 < 0)
                    {
                        break label1;
                    }
                    FullSpanItem fullspanitem1 = (FullSpanItem)b.get(j1);
                    fullspanitem = fullspanitem1;
                    if (fullspanitem1.a == i1)
                    {
                        break label0;
                    }
                    j1--;
                }
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
            return null;
        }
    }


    private class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new bq();
        int a;
        int b;
        int c;
        int d[];
        int e;
        int f[];
        List g;
        boolean h;
        boolean i;
        boolean j;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            boolean flag = true;
            parcel.writeInt(a);
            parcel.writeInt(b);
            parcel.writeInt(c);
            if (c > 0)
            {
                parcel.writeIntArray(d);
            }
            parcel.writeInt(e);
            if (e > 0)
            {
                parcel.writeIntArray(f);
            }
            if (h)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (i)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (j)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            parcel.writeList(g);
        }


        public SavedState()
        {
        }

        SavedState(Parcel parcel)
        {
            boolean flag1 = true;
            super();
            a = parcel.readInt();
            b = parcel.readInt();
            c = parcel.readInt();
            if (c > 0)
            {
                d = new int[c];
                parcel.readIntArray(d);
            }
            e = parcel.readInt();
            if (e > 0)
            {
                f = new int[e];
                parcel.readIntArray(f);
            }
            boolean flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            h = flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = flag;
            if (parcel.readInt() == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            j = flag;
            g = parcel.readArrayList(android/support/v7/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.getClassLoader());
        }

        public SavedState(SavedState savedstate)
        {
            c = savedstate.c;
            a = savedstate.a;
            b = savedstate.b;
            d = savedstate.d;
            e = savedstate.e;
            f = savedstate.f;
            h = savedstate.h;
            i = savedstate.i;
            j = savedstate.j;
            g = savedstate.g;
        }
    }

}
