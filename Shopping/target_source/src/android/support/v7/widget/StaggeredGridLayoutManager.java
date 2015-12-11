// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.d;
import android.support.v4.view.a.m;
import android.support.v4.view.ai;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            x, t, ac, RecyclerView

public class StaggeredGridLayoutManager extends RecyclerView.h
{
    static class LazySpanLookup
    {

        int a[];
        List b;

        private void c(int i1, int j1)
        {
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
        }

        private void d(int i1, int j1)
        {
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
        }

        private int g(int i1)
        {
            int j1;
            int k1;
            if (b == null)
            {
                return -1;
            }
            FullSpanItem fullspanitem = f(i1);
            if (fullspanitem != null)
            {
                b.remove(fullspanitem);
            }
            k1 = b.size();
            j1 = 0;
_L3:
            if (j1 >= k1)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            if (((FullSpanItem)b.get(j1)).a < i1) goto _L2; else goto _L1
_L1:
            if (j1 != -1)
            {
                FullSpanItem fullspanitem1 = (FullSpanItem)b.get(j1);
                b.remove(j1);
                return fullspanitem1.a;
            } else
            {
                return -1;
            }
_L2:
            j1++;
              goto _L3
            j1 = -1;
              goto _L1
        }

        int a(int i1)
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

        public FullSpanItem a(int i1, int j1, int k1, boolean flag)
        {
            if (b != null) goto _L2; else goto _L1
_L1:
            FullSpanItem fullspanitem = null;
_L6:
            return fullspanitem;
_L2:
            int l1;
            int i2;
            i2 = b.size();
            l1 = 0;
_L9:
            if (l1 >= i2) goto _L4; else goto _L3
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
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            fullspanitem = fullspanitem1;
            if (fullspanitem1.d) goto _L6; else goto _L8
_L8:
            l1++;
              goto _L9
_L4:
            return null;
        }

        void a()
        {
            if (a != null)
            {
                Arrays.fill(a, -1);
            }
            b = null;
        }

        void a(int i1, int j1)
        {
            if (a == null || i1 >= a.length)
            {
                return;
            } else
            {
                e(i1 + j1);
                System.arraycopy(a, i1 + j1, a, i1, a.length - i1 - j1);
                Arrays.fill(a, a.length - j1, a.length, -1);
                c(i1, j1);
                return;
            }
        }

        void a(int i1, c c1)
        {
            e(i1);
            a[i1] = c1.d;
        }

        public void a(FullSpanItem fullspanitem)
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

        int b(int i1)
        {
            while (a == null || i1 >= a.length) 
            {
                return -1;
            }
            int j1 = g(i1);
            if (j1 == -1)
            {
                Arrays.fill(a, i1, a.length, -1);
                return a.length;
            } else
            {
                Arrays.fill(a, i1, j1 + 1, -1);
                return j1 + 1;
            }
        }

        void b(int i1, int j1)
        {
            if (a == null || i1 >= a.length)
            {
                return;
            } else
            {
                e(i1 + j1);
                System.arraycopy(a, i1, a, i1 + j1, a.length - i1 - j1);
                Arrays.fill(a, i1, i1 + j1, -1);
                d(i1, j1);
                return;
            }
        }

        int c(int i1)
        {
            if (a == null || i1 >= a.length)
            {
                return -1;
            } else
            {
                return a[i1];
            }
        }

        int d(int i1)
        {
            int j1;
            for (j1 = a.length; j1 <= i1; j1 *= 2) { }
            return j1;
        }

        void e(int i1)
        {
            if (a == null)
            {
                a = new int[Math.max(i1, 10) + 1];
                Arrays.fill(a, -1);
            } else
            if (i1 >= a.length)
            {
                int ai1[] = a;
                a = new int[d(i1)];
                System.arraycopy(ai1, 0, a, 0, ai1.length);
                Arrays.fill(a, ai1.length, a.length, -1);
                return;
            }
        }

        public FullSpanItem f(int i1)
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

    static class LazySpanLookup.FullSpanItem
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public LazySpanLookup.FullSpanItem a(Parcel parcel)
            {
                return new LazySpanLookup.FullSpanItem(parcel);
            }

            public LazySpanLookup.FullSpanItem[] a(int i1)
            {
                return new LazySpanLookup.FullSpanItem[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        int a;
        int b;
        int c[];
        boolean d;

        int a(int i1)
        {
            if (c == null)
            {
                return 0;
            } else
            {
                return c[i1];
            }
        }

        public int describeContents()
        {
            return 0;
        }

        public String toString()
        {
            return (new StringBuilder()).append("FullSpanItem{mPosition=").append(a).append(", mGapDir=").append(b).append(", mHasUnwantedGapAfter=").append(d).append(", mGapPerSpan=").append(Arrays.toString(c)).append('}').toString();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeInt(a);
            parcel.writeInt(b);
            if (d)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
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
            boolean flag = true;
            super();
            a = parcel.readInt();
            b = parcel.readInt();
            int i1;
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            d = flag;
            i1 = parcel.readInt();
            if (i1 > 0)
            {
                c = new int[i1];
                parcel.readIntArray(c);
            }
        }
    }

    static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
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

        void a()
        {
            d = null;
            c = 0;
            e = 0;
            f = null;
            g = null;
        }

        void b()
        {
            d = null;
            c = 0;
            a = -1;
            b = -1;
        }

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

    private class a
    {

        int a;
        int b;
        boolean c;
        boolean d;
        final StaggeredGridLayoutManager e;

        void a()
        {
            a = -1;
            b = 0x80000000;
            c = false;
            d = false;
        }

        void a(int i1)
        {
            if (c)
            {
                b = e.a.d() - i1;
                return;
            } else
            {
                b = e.a.c() + i1;
                return;
            }
        }

        void b()
        {
            int i1;
            if (c)
            {
                i1 = e.a.d();
            } else
            {
                i1 = e.a.c();
            }
            b = i1;
        }
    }

    public static class b extends RecyclerView.i
    {

        c e;
        boolean f;

        public final int a()
        {
            if (e == null)
            {
                return -1;
            } else
            {
                return e.d;
            }
        }

        public b(int i1, int j1)
        {
            super(i1, j1);
        }

        public b(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
        }

        public b(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }

        public b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
        }
    }

    class c
    {

        int a;
        int b;
        int c;
        final int d;
        final StaggeredGridLayoutManager e;
        private ArrayList f;

        static ArrayList a(c c1)
        {
            return c1.f;
        }

        int a(int i1)
        {
            if (a != 0x80000000)
            {
                i1 = a;
            } else
            if (f.size() != 0)
            {
                a();
                return a;
            }
            return i1;
        }

        void a()
        {
            View view = (View)f.get(0);
            b b1 = c(view);
            a = e.a.a(view);
            if (b1.f)
            {
                LazySpanLookup.FullSpanItem fullspanitem = e.f.f(b1.e());
                if (fullspanitem != null && fullspanitem.b == -1)
                {
                    a = a - fullspanitem.a(d);
                }
            }
        }

        void a(View view)
        {
            b b1 = c(view);
            b1.e = this;
            f.add(0, view);
            a = 0x80000000;
            if (f.size() == 1)
            {
                b = 0x80000000;
            }
            if (b1.c() || b1.d())
            {
                c = c + e.a.c(view);
            }
        }

        void a(boolean flag, int i1)
        {
            int j1;
            if (flag)
            {
                j1 = b(0x80000000);
            } else
            {
                j1 = a(0x80000000);
            }
            e();
            while (j1 == 0x80000000 || flag && j1 < e.a.d() || !flag && j1 > e.a.c()) 
            {
                return;
            }
            int k1 = j1;
            if (i1 != 0x80000000)
            {
                k1 = j1 + i1;
            }
            b = k1;
            a = k1;
        }

        int b()
        {
            if (a != 0x80000000)
            {
                return a;
            } else
            {
                a();
                return a;
            }
        }

        int b(int i1)
        {
            if (b != 0x80000000)
            {
                i1 = b;
            } else
            if (f.size() != 0)
            {
                c();
                return b;
            }
            return i1;
        }

        void b(View view)
        {
            b b1 = c(view);
            b1.e = this;
            f.add(view);
            b = 0x80000000;
            if (f.size() == 1)
            {
                a = 0x80000000;
            }
            if (b1.c() || b1.d())
            {
                c = c + e.a.c(view);
            }
        }

        b c(View view)
        {
            return (b)view.getLayoutParams();
        }

        void c()
        {
            View view = (View)f.get(f.size() - 1);
            b b1 = c(view);
            b = e.a.b(view);
            if (b1.f)
            {
                LazySpanLookup.FullSpanItem fullspanitem = e.f.f(b1.e());
                if (fullspanitem != null && fullspanitem.b == 1)
                {
                    int i1 = b;
                    b = fullspanitem.a(d) + i1;
                }
            }
        }

        void c(int i1)
        {
            a = i1;
            b = i1;
        }

        int d()
        {
            if (b != 0x80000000)
            {
                return b;
            } else
            {
                c();
                return b;
            }
        }

        void d(int i1)
        {
            if (a != 0x80000000)
            {
                a = a + i1;
            }
            if (b != 0x80000000)
            {
                b = b + i1;
            }
        }

        void e()
        {
            f.clear();
            f();
            c = 0;
        }

        void f()
        {
            a = 0x80000000;
            b = 0x80000000;
        }

        void g()
        {
            int i1 = f.size();
            View view = (View)f.remove(i1 - 1);
            b b1 = c(view);
            b1.e = null;
            if (b1.c() || b1.d())
            {
                c = c - e.a.c(view);
            }
            if (i1 == 1)
            {
                a = 0x80000000;
            }
            b = 0x80000000;
        }

        void h()
        {
            View view = (View)f.remove(0);
            b b1 = c(view);
            b1.e = null;
            if (f.size() == 0)
            {
                b = 0x80000000;
            }
            if (b1.c() || b1.d())
            {
                c = c - e.a.c(view);
            }
            a = 0x80000000;
        }

        public int i()
        {
            return c;
        }
    }


    x a;
    x b;
    boolean c;
    int d;
    int e;
    LazySpanLookup f;
    private int g;
    private c h[];
    private int i;
    private int j;
    private t k;
    private boolean l;
    private BitSet m;
    private int n;
    private boolean o;
    private boolean p;
    private SavedState q;
    private int r;
    private int s;
    private int t;
    private final a u;
    private boolean v;
    private boolean w;
    private final Runnable x;

    private void A()
    {
        if (o() != 0 && n != 0)
        {
            int i1;
            int j1;
            if (c)
            {
                j1 = D();
                i1 = E();
            } else
            {
                j1 = E();
                i1 = D();
            }
            if (j1 == 0 && f() != null)
            {
                f.a();
                y();
                k();
                return;
            }
            if (v)
            {
                LazySpanLookup.FullSpanItem fullspanitem;
                byte byte0;
                if (c)
                {
                    byte0 = -1;
                } else
                {
                    byte0 = 1;
                }
                fullspanitem = f.a(j1, i1 + 1, byte0, true);
                if (fullspanitem == null)
                {
                    v = false;
                    f.a(i1 + 1);
                    return;
                }
                LazySpanLookup.FullSpanItem fullspanitem1 = f.a(j1, fullspanitem.a, byte0 * -1, true);
                if (fullspanitem1 == null)
                {
                    f.a(fullspanitem.a);
                } else
                {
                    f.a(fullspanitem1.a + 1);
                }
                y();
                k();
                return;
            }
        }
    }

    private void B()
    {
        if (a == null)
        {
            a = android.support.v7.widget.x.a(this, i);
            b = android.support.v7.widget.x.a(this, 1 - i);
            k = new t();
        }
    }

    private void C()
    {
        boolean flag = true;
        if (i == 1 || !g())
        {
            c = l;
            return;
        }
        if (l)
        {
            flag = false;
        }
        c = flag;
    }

    private int D()
    {
        int i1 = o();
        if (i1 == 0)
        {
            return 0;
        } else
        {
            return d(g(i1 - 1));
        }
    }

    private int E()
    {
        if (o() == 0)
        {
            return 0;
        } else
        {
            return d(g(0));
        }
    }

    private int a(int i1, int j1, int k1)
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

    private int a(RecyclerView.m m1, t t1, RecyclerView.q q1)
    {
        m.set(0, g, true);
        int i2;
        int j2;
        int k2;
        if (t1.d == 1)
        {
            int i1 = a.d() + k.a;
            int k1 = k.e;
            j2 = a.g();
            i2 = i1;
            j2 = k1 + i1 + j2;
        } else
        {
            j1 = a.c() - k.a;
            l1 = k.e;
            j2 = a.c();
            i2 = j1;
            j2 = j1 - l1 - j2;
        }
        c(t1.d, j2);
        if (c)
        {
            k2 = a.d();
        } else
        {
            k2 = a.c();
        }
        do
        {
            if (t1.a(q1) && !m.isEmpty())
            {
                View view = t1.a(m1);
                b b1 = (b)view.getLayoutParams();
                int j3 = b1.e();
                int j1 = f.c(j3);
                c c1;
                int l2;
                if (j1 == -1)
                {
                    l2 = 1;
                } else
                {
                    l2 = 0;
                }
                if (l2 != 0)
                {
                    LazySpanLookup.FullSpanItem fullspanitem;
                    if (b1.f)
                    {
                        c1 = h[0];
                    } else
                    {
                        c1 = a(t1);
                    }
                    f.a(j3, c1);
                } else
                {
                    c1 = h[j1];
                }
                b1.e = c1;
                if (t1.d == 1)
                {
                    b(view);
                } else
                {
                    b(view, 0);
                }
                a(view, b1);
                if (t1.d == 1)
                {
                    int l1;
                    int i3;
                    if (b1.f)
                    {
                        j1 = m(k2);
                    } else
                    {
                        j1 = c1.b(k2);
                    }
                    i3 = j1 + a.c(view);
                    LazySpanLookup.FullSpanItem fullspanitem1;
                    if (l2 != 0 && b1.f)
                    {
                        fullspanitem = a(j1);
                        fullspanitem.b = -1;
                        fullspanitem.a = j3;
                        f.a(fullspanitem);
                        l1 = j1;
                    } else
                    {
                        l1 = j1;
                    }
                } else
                {
                    if (b1.f)
                    {
                        j1 = l(k2);
                    } else
                    {
                        j1 = c1.a(k2);
                    }
                    l1 = j1 - a.c(view);
                    if (l2 != 0 && b1.f)
                    {
                        fullspanitem1 = b(j1);
                        fullspanitem1.b = 1;
                        fullspanitem1.a = j3;
                        f.a(fullspanitem1);
                    }
                    i3 = j1;
                }
                if (b1.f && t1.c == -1)
                {
                    if (l2 != 0)
                    {
                        v = true;
                    } else
                    {
                        if (t1.d == 1)
                        {
                            if (!j())
                            {
                                j1 = 1;
                            } else
                            {
                                j1 = 0;
                            }
                        } else
                        if (!z())
                        {
                            j1 = 1;
                        } else
                        {
                            j1 = 0;
                        }
                        if (j1 != 0)
                        {
                            fullspanitem1 = f.f(j3);
                            if (fullspanitem1 != null)
                            {
                                fullspanitem1.d = true;
                            }
                            v = true;
                        }
                    }
                }
                a(view, b1, t1);
                if (b1.f)
                {
                    j1 = b.c();
                } else
                {
                    j1 = c1.d;
                    l2 = j;
                    j1 = b.c() + j1 * l2;
                }
                l2 = j1 + b.c(view);
                if (i == 1)
                {
                    b(view, j1, l1, l2, i3);
                } else
                {
                    b(view, l1, j1, i3, l2);
                }
                if (b1.f)
                {
                    c(k.d, j2);
                } else
                {
                    a(c1, k.d, j2);
                }
                a(m1, k, c1, i2);
                continue;
            }
            if (k.d == -1)
            {
                return Math.max(0, (i2 - l(a.c())) + k.a);
            }
            return Math.max(0, (m(a.d()) - i2) + k.a);
        } while (true);
    }

    private int a(RecyclerView.q q1)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        B();
        x x1 = a;
        View view;
        boolean flag;
        if (!w)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag, true);
        flag = flag1;
        if (!w)
        {
            flag = true;
        }
        return android.support.v7.widget.ac.a(q1, x1, view, b(flag, true), this, w, c);
    }

    private LazySpanLookup.FullSpanItem a(int i1)
    {
        LazySpanLookup.FullSpanItem fullspanitem = new LazySpanLookup.FullSpanItem();
        fullspanitem.c = new int[g];
        for (int j1 = 0; j1 < g; j1++)
        {
            fullspanitem.c[j1] = i1 - h[j1].b(i1);
        }

        return fullspanitem;
    }

    private c a(t t1)
    {
        Object obj1 = null;
        Object obj = null;
        byte byte0 = -1;
        int i1;
        int j1;
        if (o(t1.d))
        {
            i1 = g - 1;
            j1 = -1;
        } else
        {
            j1 = g;
            i1 = 0;
            byte0 = 1;
        }
        if (t1.d == 1)
        {
            int i3 = a.c();
            int i2 = 0x7fffffff;
            int k1 = i1;
            t1 = ((t) (obj));
            i1 = i2;
            do
            {
                obj = t1;
                if (k1 == j1)
                {
                    break;
                }
                obj = h[k1];
                int j2 = ((c) (obj)).b(i3);
                if (j2 < i1)
                {
                    t1 = ((t) (obj));
                    i1 = j2;
                }
                k1 += byte0;
            } while (true);
        } else
        {
            int j3 = a.d();
            int k2 = 0x80000000;
            int l1 = i1;
            t1 = obj1;
            i1 = k2;
            do
            {
                obj = t1;
                if (l1 == j1)
                {
                    break;
                }
                obj = h[l1];
                int l2 = ((c) (obj)).a(j3);
                if (l2 > i1)
                {
                    t1 = ((t) (obj));
                    i1 = l2;
                }
                l1 += byte0;
            } while (true);
        }
        return ((c) (obj));
    }

    private void a(int i1, RecyclerView.q q1)
    {
        boolean flag = true;
        k.a = 0;
        k.b = i1;
        if (m())
        {
            int j1 = q1.c();
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
                k.e = 0;
            } else
            {
                k.e = a.f();
            }
        } else
        {
            k.e = 0;
        }
        k.d = -1;
        q1 = k;
        if (c)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = -1;
        }
        q1.c = i1;
    }

    private void a(RecyclerView.m m1, int i1)
    {
        View view;
        for (; o() > 0; a(view, m1))
        {
            view = g(0);
            if (a.b(view) >= i1)
            {
                break;
            }
            b b1 = (b)view.getLayoutParams();
            if (b1.f)
            {
                for (int j1 = 0; j1 < g; j1++)
                {
                    h[j1].h();
                }

            } else
            {
                b1.e.h();
            }
        }

    }

    private void a(RecyclerView.m m1, RecyclerView.q q1, boolean flag)
    {
        int i1 = m(a.d());
        i1 = a.d() - i1;
        if (i1 > 0)
        {
            i1 -= -c(-i1, m1, q1);
            if (flag && i1 > 0)
            {
                a.a(i1);
            }
        }
    }

    private void a(RecyclerView.m m1, t t1, c c1, int i1)
    {
        if (t1.d == -1)
        {
            b(m1, Math.max(i1, k(c1.b())) + (a.e() - a.c()));
            return;
        } else
        {
            a(m1, Math.min(i1, n(c1.d())) - (a.e() - a.c()));
            return;
        }
    }

    private void a(a a1)
    {
        if (q.c > 0)
        {
            if (q.c == g)
            {
                int j1 = 0;
                while (j1 < g) 
                {
                    h[j1].e();
                    int k1 = q.d[j1];
                    int i1 = k1;
                    if (k1 != 0x80000000)
                    {
                        if (q.i)
                        {
                            i1 = k1 + a.d();
                        } else
                        {
                            i1 = k1 + a.c();
                        }
                    }
                    h[j1].c(i1);
                    j1++;
                }
            } else
            {
                q.a();
                q.a = q.b;
            }
        }
        p = q.j;
        a(q.h);
        C();
        if (q.a != -1)
        {
            d = q.a;
            a1.c = q.i;
        } else
        {
            a1.c = c;
        }
        if (q.e > 1)
        {
            f.a = q.f;
            f.b = q.g;
        }
    }

    private void a(c c1, int i1, int j1)
    {
        int k1 = c1.i();
        if (i1 == -1)
        {
            if (k1 + c1.b() < j1)
            {
                m.set(c1.d, false);
            }
        } else
        if (c1.d() - k1 > j1)
        {
            m.set(c1.d, false);
            return;
        }
    }

    private void a(View view, b b1)
    {
        if (b1.f)
        {
            if (i == 1)
            {
                b(view, r, b(b1.height, t));
                return;
            } else
            {
                b(view, b(b1.width, s), r);
                return;
            }
        }
        if (i == 1)
        {
            b(view, s, b(b1.height, t));
            return;
        } else
        {
            b(view, b(b1.width, s), t);
            return;
        }
    }

    private void a(View view, b b1, t t1)
    {
        if (t1.d == 1)
        {
            if (b1.f)
            {
                o(view);
                return;
            } else
            {
                b1.e.b(view);
                return;
            }
        }
        if (b1.f)
        {
            p(view);
            return;
        } else
        {
            b1.e.a(view);
            return;
        }
    }

    private boolean a(c c1)
    {
        return c ? c1.d() < a.d() : c1.b() > a.c();
    }

    private int b(int i1, int j1)
    {
        if (i1 < 0)
        {
            return j1;
        } else
        {
            return android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
        }
    }

    private LazySpanLookup.FullSpanItem b(int i1)
    {
        LazySpanLookup.FullSpanItem fullspanitem = new LazySpanLookup.FullSpanItem();
        fullspanitem.c = new int[g];
        for (int j1 = 0; j1 < g; j1++)
        {
            fullspanitem.c[j1] = h[j1].a(i1) - i1;
        }

        return fullspanitem;
    }

    private void b(int i1, int j1, int k1)
    {
        int l1;
        int i2;
        int j2;
        if (c)
        {
            j2 = D();
        } else
        {
            j2 = E();
        }
        if (k1 == 3)
        {
            if (i1 < j1)
            {
                i2 = j1 + 1;
                l1 = i1;
            } else
            {
                i2 = i1 + 1;
                l1 = j1;
            }
        } else
        {
            i2 = i1 + j1;
            l1 = i1;
        }
        f.b(l1);
        k1;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 111
    //                   1 123
    //                   2 72
    //                   3 135;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        if (i2 > j2) goto _L6; else goto _L5
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
            i1 = E();
        } else
        {
            i1 = D();
        }
        if (l1 > i1) goto _L5; else goto _L7
_L7:
        k();
        return;
        if (true) goto _L1; else goto _L8
_L8:
    }

    private void b(int i1, RecyclerView.q q1)
    {
        boolean flag = true;
        k.a = 0;
        k.b = i1;
        if (m())
        {
            int j1 = q1.c();
            boolean flag2 = c;
            boolean flag1;
            if (j1 > i1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag2 == flag1)
            {
                k.e = 0;
            } else
            {
                k.e = a.f();
            }
        } else
        {
            k.e = 0;
        }
        k.d = 1;
        q1 = k;
        i1 = ((flag) ? 1 : 0);
        if (c)
        {
            i1 = -1;
        }
        q1.c = i1;
    }

    private void b(RecyclerView.m m1, int i1)
    {
        int j1 = o() - 1;
        do
        {
            if (j1 < 0)
            {
                break;
            }
            View view = g(j1);
            if (a.a(view) <= i1)
            {
                break;
            }
            b b1 = (b)view.getLayoutParams();
            if (b1.f)
            {
                for (int k1 = 0; k1 < g; k1++)
                {
                    h[k1].g();
                }

            } else
            {
                b1.e.g();
            }
            a(view, m1);
            j1--;
        } while (true);
    }

    private void b(RecyclerView.m m1, RecyclerView.q q1, boolean flag)
    {
        int i1 = l(a.c()) - a.c();
        if (i1 > 0)
        {
            i1 -= c(i1, m1, q1);
            if (flag && i1 > 0)
            {
                a.a(-i1);
            }
        }
    }

    private void b(View view, int i1, int j1)
    {
        Rect rect = mRecyclerView.h(view);
        b b1 = (b)view.getLayoutParams();
        view.measure(a(i1, b1.leftMargin + rect.left, b1.rightMargin + rect.right), a(j1, b1.topMargin + rect.top, b1.bottomMargin + rect.bottom));
    }

    private void b(View view, int i1, int j1, int k1, int l1)
    {
        b b1 = (b)view.getLayoutParams();
        a(view, i1 + b1.leftMargin, j1 + b1.topMargin, k1 - b1.rightMargin, l1 - b1.bottomMargin);
    }

    private void c(int i1, int j1)
    {
        int k1 = 0;
        while (k1 < g) 
        {
            if (!android.support.v7.widget.c.a(h[k1]).isEmpty())
            {
                a(h[k1], i1, j1);
            }
            k1++;
        }
    }

    private boolean c(RecyclerView.q q1, a a1)
    {
        int i1;
        if (o)
        {
            i1 = r(q1.e());
        } else
        {
            i1 = q(q1.e());
        }
        a1.a = i1;
        a1.b = 0x80000000;
        return true;
    }

    private int h(RecyclerView.q q1)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        B();
        x x1 = a;
        View view;
        boolean flag;
        if (!w)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag, true);
        flag = flag1;
        if (!w)
        {
            flag = true;
        }
        return android.support.v7.widget.ac.a(q1, x1, view, b(flag, true), this, w);
    }

    private int i(RecyclerView.q q1)
    {
        boolean flag1 = false;
        if (o() == 0)
        {
            return 0;
        }
        B();
        x x1 = a;
        View view;
        boolean flag;
        if (!w)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag, true);
        flag = flag1;
        if (!w)
        {
            flag = true;
        }
        return ac.b(q1, x1, view, b(flag, true), this, w);
    }

    private int k(int i1)
    {
        int k1 = h[0].a(i1);
        for (int j1 = 1; j1 < g;)
        {
            int i2 = h[j1].a(i1);
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

    private int l(int i1)
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

    private int m(int i1)
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

    private int n(int i1)
    {
        int k1 = h[0].b(i1);
        for (int j1 = 1; j1 < g;)
        {
            int i2 = h[j1].b(i1);
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

    private void o(View view)
    {
        for (int i1 = g - 1; i1 >= 0; i1--)
        {
            h[i1].b(view);
        }

    }

    private boolean o(int i1)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (i1 == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag == c) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        boolean flag1;
        if (i1 == -1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 == c)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 != g())
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private int p(int i1)
    {
        byte byte0 = -1;
        if (o() == 0)
        {
            return !c ? -1 : 1;
        }
        boolean flag;
        if (i1 < E())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag != c)
        {
            i1 = byte0;
        } else
        {
            i1 = 1;
        }
        return i1;
    }

    private void p(View view)
    {
        for (int i1 = g - 1; i1 >= 0; i1--)
        {
            h[i1].a(view);
        }

    }

    private int q(int i1)
    {
        int k1 = o();
        for (int j1 = 0; j1 < k1; j1++)
        {
            int l1 = d(g(j1));
            if (l1 >= 0 && l1 < i1)
            {
                return l1;
            }
        }

        return 0;
    }

    private int r(int i1)
    {
        for (int j1 = o() - 1; j1 >= 0; j1--)
        {
            int k1 = d(g(j1));
            if (k1 >= 0 && k1 < i1)
            {
                return k1;
            }
        }

        return 0;
    }

    public int a(int i1, RecyclerView.m m1, RecyclerView.q q1)
    {
        return c(i1, m1, q1);
    }

    public int a(RecyclerView.m m1, RecyclerView.q q1)
    {
        if (i == 0)
        {
            return g;
        } else
        {
            return super.a(m1, q1);
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

    View a(boolean flag, boolean flag1)
    {
        B();
        int j1 = a.c();
        int k1 = a.d();
        int l1 = o();
        View view = null;
        for (int i1 = 0; i1 < l1; i1++)
        {
            View view1 = g(i1);
            if (a.b(view1) > k1)
            {
                continue;
            }
            if (!flag || a.a(view1) >= j1)
            {
                return view1;
            }
            if (flag1 && view == null)
            {
                view = view1;
            }
        }

        return view;
    }

    public void a(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            q = (SavedState)parcelable;
            k();
        }
    }

    public void a(RecyclerView.m m1, RecyclerView.q q1, View view, d d1)
    {
        m1 = view.getLayoutParams();
        if (!(m1 instanceof b))
        {
            super.a(view, d1);
            return;
        }
        m1 = (b)m1;
        if (i == 0)
        {
            int k1 = m1.a();
            int i1;
            if (((b) (m1)).f)
            {
                i1 = g;
            } else
            {
                i1 = 1;
            }
            d1.c(android.support.v4.view.a.d.j.a(k1, i1, -1, -1, ((b) (m1)).f, false));
            return;
        }
        int l1 = m1.a();
        int j1;
        if (((b) (m1)).f)
        {
            j1 = g;
        } else
        {
            j1 = 1;
        }
        d1.c(android.support.v4.view.a.d.j.a(-1, -1, l1, j1, ((b) (m1)).f, false));
    }

    void a(RecyclerView.q q1, a a1)
    {
        while (b(q1, a1) || c(q1, a1)) 
        {
            return;
        }
        a1.b();
        a1.a = 0;
    }

    public void a(RecyclerView recyclerview)
    {
        f.a();
        k();
    }

    public void a(RecyclerView recyclerview, int i1, int j1)
    {
        b(i1, j1, 0);
    }

    public void a(RecyclerView recyclerview, int i1, int j1, int k1)
    {
        b(i1, j1, 3);
    }

    public void a(RecyclerView recyclerview, RecyclerView.m m1)
    {
        for (int i1 = 0; i1 < g; i1++)
        {
            h[i1].e();
        }

    }

    public void a(AccessibilityEvent accessibilityevent)
    {
        View view;
        View view1;
label0:
        {
            super.a(accessibilityevent);
            if (o() > 0)
            {
                accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
                view = a(false, true);
                view1 = b(false, true);
                if (view != null && view1 != null)
                {
                    break label0;
                }
            }
            return;
        }
        int i1 = d(view);
        int j1 = d(view1);
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

    public void a(String s1)
    {
        if (q == null)
        {
            super.a(s1);
        }
    }

    public void a(boolean flag)
    {
        a(((String) (null)));
        if (q != null && q.h != flag)
        {
            q.h = flag;
        }
        l = flag;
        k();
    }

    public boolean a(RecyclerView.i i1)
    {
        return i1 instanceof b;
    }

    public int b(int i1, RecyclerView.m m1, RecyclerView.q q1)
    {
        return c(i1, m1, q1);
    }

    public int b(RecyclerView.m m1, RecyclerView.q q1)
    {
        if (i == 1)
        {
            return g;
        } else
        {
            return super.b(m1, q1);
        }
    }

    public int b(RecyclerView.q q1)
    {
        return a(q1);
    }

    View b(boolean flag, boolean flag1)
    {
        B();
        int j1 = a.c();
        int k1 = a.d();
        View view = null;
        for (int i1 = o() - 1; i1 >= 0; i1--)
        {
            View view1 = g(i1);
            if (a.a(view1) < j1)
            {
                continue;
            }
            if (!flag || a.b(view1) <= k1)
            {
                return view1;
            }
            if (flag1 && view == null)
            {
                view = view1;
            }
        }

        return view;
    }

    public void b(RecyclerView recyclerview, int i1, int j1)
    {
        b(i1, j1, 1);
    }

    public boolean b()
    {
        return q == null;
    }

    boolean b(RecyclerView.q q1, a a1)
    {
        boolean flag = false;
        if (q1.a() || d == -1)
        {
            return false;
        }
        if (d < 0 || d >= q1.e())
        {
            d = -1;
            e = 0x80000000;
            return false;
        }
        if (q == null || q.a == -1 || q.c < 1)
        {
            q1 = c(d);
            if (q1 != null)
            {
                int i1;
                if (c)
                {
                    i1 = D();
                } else
                {
                    i1 = E();
                }
                a1.a = i1;
                if (e != 0x80000000)
                {
                    if (a1.c)
                    {
                        a1.b = a.d() - e - a.b(q1);
                        return true;
                    } else
                    {
                        a1.b = (a.c() + e) - a.a(q1);
                        return true;
                    }
                }
                if (a.c(q1) > a.f())
                {
                    if (a1.c)
                    {
                        i1 = a.d();
                    } else
                    {
                        i1 = a.c();
                    }
                    a1.b = i1;
                    return true;
                }
                i1 = a.a(q1) - a.c();
                if (i1 < 0)
                {
                    a1.b = -i1;
                    return true;
                }
                i1 = a.d() - a.b(q1);
                if (i1 < 0)
                {
                    a1.b = i1;
                    return true;
                } else
                {
                    a1.b = 0x80000000;
                    return true;
                }
            }
            a1.a = d;
            if (e == 0x80000000)
            {
                if (p(a1.a) == 1)
                {
                    flag = true;
                }
                a1.c = flag;
                a1.b();
            } else
            {
                a1.a(e);
            }
            a1.d = true;
            return true;
        } else
        {
            a1.b = 0x80000000;
            a1.a = d;
            return true;
        }
    }

    int c(int i1, RecyclerView.m m1, RecyclerView.q q1)
    {
        int j1 = 1;
        int k1 = -1;
        B();
        if (i1 > 0)
        {
            k.d = 1;
            t t1 = k;
            if (c)
            {
                j1 = k1;
            } else
            {
                j1 = 1;
            }
            t1.c = j1;
            j1 = D();
        } else
        {
            k.d = -1;
            t t2 = k;
            if (!c)
            {
                j1 = -1;
            }
            t2.c = j1;
            j1 = E();
        }
        k.b = j1 + k.c;
        k1 = Math.abs(i1);
        k.a = k1;
        t1 = k;
        if (m())
        {
            j1 = a.f();
        } else
        {
            j1 = 0;
        }
        t1.e = j1;
        j1 = a(m1, k, q1);
        if (k1 >= j1)
        {
            if (i1 < 0)
            {
                i1 = -j1;
            } else
            {
                i1 = j1;
            }
        }
        a.a(-i1);
        o = c;
        return i1;
    }

    public int c(RecyclerView.q q1)
    {
        return a(q1);
    }

    public Parcelable c()
    {
        if (q != null)
        {
            return new SavedState(q);
        }
        SavedState savedstate = new SavedState();
        savedstate.h = l;
        savedstate.i = o;
        savedstate.j = p;
        if (f != null && f.a != null)
        {
            savedstate.f = f.a;
            savedstate.e = savedstate.f.length;
            savedstate.g = f.b;
        } else
        {
            savedstate.e = 0;
        }
        if (o() > 0)
        {
            B();
            int i1;
            int j1;
            if (o)
            {
                i1 = D();
            } else
            {
                i1 = E();
            }
            savedstate.a = i1;
            savedstate.b = i();
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
                        i1 = k1 - a.d();
                    }
                } else
                {
                    int l1 = h[j1].a(0x80000000);
                    i1 = l1;
                    if (l1 != 0x80000000)
                    {
                        i1 = l1 - a.c();
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

    public void c(RecyclerView.m m1, RecyclerView.q q1)
    {
        B();
        a a1 = u;
        a1.a();
        if (q != null)
        {
            a(a1);
        } else
        {
            C();
            a1.c = c;
        }
        a(q1, a1);
        if (q == null && (a1.c != o || g() != p))
        {
            f.a();
            a1.d = true;
        }
        if (o() > 0 && (q == null || q.c < 1))
        {
            if (a1.d)
            {
                for (int i1 = 0; i1 < g; i1++)
                {
                    h[i1].e();
                    if (a1.b != 0x80000000)
                    {
                        h[i1].c(a1.b);
                    }
                }

            } else
            {
                for (int j1 = 0; j1 < g; j1++)
                {
                    h[j1].a(c, a1.b);
                }

            }
        }
        a(m1);
        v = false;
        h();
        if (a1.c)
        {
            a(a1.a, q1);
            a(m1, k, q1);
            b(a1.a, q1);
            t t1 = k;
            t1.b = t1.b + k.c;
            a(m1, k, q1);
        } else
        {
            b(a1.a, q1);
            a(m1, k, q1);
            a(a1.a, q1);
            t t2 = k;
            t2.b = t2.b + k.c;
            a(m1, k, q1);
        }
        if (o() > 0)
        {
            if (c)
            {
                a(m1, q1, true);
                b(m1, q1, false);
            } else
            {
                b(m1, q1, true);
                a(m1, q1, false);
            }
        }
        if (!q1.a())
        {
            if (o() > 0 && d != -1 && v)
            {
                ai.a(g(0), x);
            }
            d = -1;
            e = 0x80000000;
        }
        o = a1.c;
        p = g();
        q = null;
    }

    public void c(RecyclerView recyclerview, int i1, int j1)
    {
        b(i1, j1, 2);
    }

    public int d(RecyclerView.q q1)
    {
        return h(q1);
    }

    public void d(int i1)
    {
        if (q != null && q.a != i1)
        {
            q.b();
        }
        d = i1;
        e = 0x80000000;
        k();
    }

    public boolean d()
    {
        return i == 0;
    }

    public int e(RecyclerView.q q1)
    {
        return h(q1);
    }

    public boolean e()
    {
        return i == 1;
    }

    public int f(RecyclerView.q q1)
    {
        return i(q1);
    }

    View f()
    {
        BitSet bitset;
        View view;
        b b1;
        byte byte0;
        int k1;
        byte byte1;
        int l1;
        k1 = o() - 1;
        bitset = new BitSet(g);
        bitset.set(0, g, true);
        int i1;
        if (i == 1 && g())
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        if (c)
        {
            i1 = k1 - 1;
            k1 = -1;
        } else
        {
            i1 = 0;
        }
        if (i1 < k1)
        {
            byte1 = 1;
        } else
        {
            byte1 = -1;
        }
        l1 = i1;
_L3:
        if (l1 == k1)
        {
            break; /* Loop/switch isn't completed */
        }
        view = g(l1);
        b1 = (b)view.getLayoutParams();
        if (bitset.get(b1.e.d))
        {
            if (a(b1.e))
            {
                return view;
            }
            bitset.clear(b1.e.d);
        }
          goto _L1
_L5:
        l1 += byte1;
        if (true) goto _L3; else goto _L2
_L1:
        if (b1.f || l1 + byte1 == k1) goto _L5; else goto _L4
_L4:
        int j1;
        Object obj = g(l1 + byte1);
        if (c)
        {
            j1 = a.b(view);
            int i2 = a.b(((View) (obj)));
            if (j1 < i2)
            {
                return view;
            }
            if (j1 != i2)
            {
                break MISSING_BLOCK_LABEL_352;
            }
            j1 = 1;
        } else
        {
            j1 = a.a(view);
            j2 = a.a(((View) (obj)));
            if (j1 > j2)
            {
                return view;
            }
            if (j1 != j2)
            {
                break MISSING_BLOCK_LABEL_352;
            }
            j1 = 1;
        }
_L6:
        if (j1 != 0)
        {
            obj = (b)((View) (obj)).getLayoutParams();
            int j2;
            if (b1.e.d - ((b) (obj)).e.d < 0)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            if (byte0 < 0)
            {
                j2 = 1;
            } else
            {
                j2 = 0;
            }
            if (j1 != j2)
            {
                return view;
            }
        }
          goto _L5
_L2:
        return null;
        j1 = 0;
          goto _L6
    }

    public int g(RecyclerView.q q1)
    {
        return i(q1);
    }

    boolean g()
    {
        return n() == 1;
    }

    void h()
    {
        j = b.f() / g;
        r = android.view.View.MeasureSpec.makeMeasureSpec(b.f(), 0x40000000);
        if (i == 1)
        {
            s = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            t = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            return;
        } else
        {
            t = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            s = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            return;
        }
    }

    public void h(int i1)
    {
        super.h(i1);
        for (int j1 = 0; j1 < g; j1++)
        {
            h[j1].d(i1);
        }

    }

    int i()
    {
        View view;
        if (c)
        {
            view = b(true, true);
        } else
        {
            view = a(true, true);
        }
        if (view == null)
        {
            return -1;
        } else
        {
            return d(view);
        }
    }

    public void i(int i1)
    {
        super.i(i1);
        for (int j1 = 0; j1 < g; j1++)
        {
            h[j1].d(i1);
        }

    }

    public void j(int i1)
    {
        if (i1 == 0)
        {
            A();
        }
    }

    boolean j()
    {
        boolean flag1 = true;
        int j1 = h[0].b(0x80000000);
        int i1 = 1;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < g)
                {
                    if (h[i1].b(0x80000000) == j1)
                    {
                        break label0;
                    }
                    flag = false;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    boolean z()
    {
        boolean flag1 = true;
        int j1 = h[0].a(0x80000000);
        int i1 = 1;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < g)
                {
                    if (h[i1].a(0x80000000) == j1)
                    {
                        break label0;
                    }
                    flag = false;
                }
                return flag;
            }
            i1++;
        } while (true);
    }
}
