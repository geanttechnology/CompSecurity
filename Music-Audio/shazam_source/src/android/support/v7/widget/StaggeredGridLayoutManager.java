// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            p, u, RecyclerView, w, 
//            r

public class StaggeredGridLayoutManager extends RecyclerView.i
{
    static final class LazySpanLookup
    {

        int a[];
        List b;

        final int a(int l)
        {
            if (b != null)
            {
                for (int i1 = b.size() - 1; i1 >= 0; i1--)
                {
                    if (((FullSpanItem)b.get(i1)).a >= l)
                    {
                        b.remove(i1);
                    }
                }

            }
            return b(l);
        }

        public final FullSpanItem a(int l, int i1, int j1)
        {
            if (b != null) goto _L2; else goto _L1
_L1:
            FullSpanItem fullspanitem = null;
_L6:
            return fullspanitem;
_L2:
            int k1;
            int l1;
            l1 = b.size();
            k1 = 0;
_L9:
            if (k1 >= l1) goto _L4; else goto _L3
_L3:
            FullSpanItem fullspanitem1;
            fullspanitem1 = (FullSpanItem)b.get(k1);
            if (fullspanitem1.a >= i1)
            {
                return null;
            }
            if (fullspanitem1.a < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            fullspanitem = fullspanitem1;
            if (j1 == 0) goto _L6; else goto _L5
_L5:
            fullspanitem = fullspanitem1;
            if (fullspanitem1.b == j1) goto _L6; else goto _L7
_L7:
            fullspanitem = fullspanitem1;
            if (fullspanitem1.d) goto _L6; else goto _L8
_L8:
            k1++;
              goto _L9
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

        final void a(int l, int i1)
        {
            if (a != null && l < a.length) goto _L2; else goto _L1
_L1:
            return;
_L2:
            c(l + i1);
            System.arraycopy(a, l + i1, a, l, a.length - l - i1);
            Arrays.fill(a, a.length - i1, a.length, -1);
            if (b != null)
            {
                int j1 = b.size() - 1;
                while (j1 >= 0) 
                {
                    FullSpanItem fullspanitem = (FullSpanItem)b.get(j1);
                    if (fullspanitem.a >= l)
                    {
                        if (fullspanitem.a < l + i1)
                        {
                            b.remove(j1);
                        } else
                        {
                            fullspanitem.a = fullspanitem.a - i1;
                        }
                    }
                    j1--;
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
            int i1 = b.size();
            for (int l = 0; l < i1; l++)
            {
                FullSpanItem fullspanitem1 = (FullSpanItem)b.get(l);
                if (fullspanitem1.a == fullspanitem.a)
                {
                    b.remove(l);
                }
                if (fullspanitem1.a >= fullspanitem.a)
                {
                    b.add(l, fullspanitem);
                    return;
                }
            }

            b.add(fullspanitem);
        }

        final int b(int l)
        {
            if (a == null)
            {
                return -1;
            }
            if (l >= a.length)
            {
                return -1;
            }
            if (b == null) goto _L2; else goto _L1
_L1:
            int i1;
            int j1;
            FullSpanItem fullspanitem = d(l);
            if (fullspanitem != null)
            {
                b.remove(fullspanitem);
            }
            j1 = b.size();
            i1 = 0;
_L6:
            if (i1 >= j1)
            {
                break MISSING_BLOCK_LABEL_175;
            }
            if (((FullSpanItem)b.get(i1)).a < l) goto _L4; else goto _L3
_L3:
            if (i1 == -1) goto _L2; else goto _L5
_L5:
            FullSpanItem fullspanitem1 = (FullSpanItem)b.get(i1);
            b.remove(i1);
            i1 = fullspanitem1.a;
_L7:
            if (i1 == -1)
            {
                Arrays.fill(a, l, a.length, -1);
                return a.length;
            } else
            {
                Arrays.fill(a, l, i1 + 1, -1);
                return i1 + 1;
            }
_L4:
            i1++;
              goto _L6
_L2:
            i1 = -1;
              goto _L7
            i1 = -1;
              goto _L3
        }

        final void b(int l, int i1)
        {
            if (a != null && l < a.length) goto _L2; else goto _L1
_L1:
            return;
_L2:
            c(l + i1);
            System.arraycopy(a, l, a, l + i1, a.length - l - i1);
            Arrays.fill(a, l, l + i1, -1);
            if (b != null)
            {
                int j1 = b.size() - 1;
                while (j1 >= 0) 
                {
                    FullSpanItem fullspanitem = (FullSpanItem)b.get(j1);
                    if (fullspanitem.a >= l)
                    {
                        fullspanitem.a = fullspanitem.a + i1;
                    }
                    j1--;
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        final void c(int l)
        {
            if (a == null)
            {
                a = new int[Math.max(l, 10) + 1];
                Arrays.fill(a, -1);
            } else
            if (l >= a.length)
            {
                int ai[] = a;
                int i1;
                for (i1 = a.length; i1 <= l; i1 *= 2) { }
                a = new int[i1];
                System.arraycopy(ai, 0, a, 0, ai.length);
                Arrays.fill(a, ai.length, a.length, -1);
                return;
            }
        }

        public final FullSpanItem d(int l)
        {
            if (b != null) goto _L2; else goto _L1
_L1:
            FullSpanItem fullspanitem = null;
_L4:
            return fullspanitem;
_L2:
            int i1 = b.size() - 1;
label0:
            do
            {
label1:
                {
                    if (i1 < 0)
                    {
                        break label1;
                    }
                    FullSpanItem fullspanitem1 = (FullSpanItem)b.get(i1);
                    fullspanitem = fullspanitem1;
                    if (fullspanitem1.a == l)
                    {
                        break label0;
                    }
                    i1--;
                }
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
            return null;
        }

        LazySpanLookup()
        {
        }
    }

    static class LazySpanLookup.FullSpanItem
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new LazySpanLookup.FullSpanItem(parcel);
            }

            public final volatile Object[] newArray(int l)
            {
                return new LazySpanLookup.FullSpanItem[l];
            }

        };
        int a;
        int b;
        int c[];
        boolean d;

        final int a(int l)
        {
            if (c == null)
            {
                return 0;
            } else
            {
                return c[l];
            }
        }

        public int describeContents()
        {
            return 0;
        }

        public String toString()
        {
            return (new StringBuilder("FullSpanItem{mPosition=")).append(a).append(", mGapDir=").append(b).append(", mHasUnwantedGapAfter=").append(d).append(", mGapPerSpan=").append(Arrays.toString(c)).append('}').toString();
        }

        public void writeToParcel(Parcel parcel, int l)
        {
            parcel.writeInt(a);
            parcel.writeInt(b);
            if (d)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            parcel.writeInt(l);
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
            int l;
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            d = flag;
            l = parcel.readInt();
            if (l > 0)
            {
                c = new int[l];
                parcel.readIntArray(c);
            }
        }
    }

    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int l)
            {
                return new SavedState[l];
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

        public final void a()
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

        public void writeToParcel(Parcel parcel, int l)
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
                l = 1;
            } else
            {
                l = 0;
            }
            parcel.writeInt(l);
            if (i)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            parcel.writeInt(l);
            if (j)
            {
                l = ((flag) ? 1 : 0);
            } else
            {
                l = 0;
            }
            parcel.writeInt(l);
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

    private final class a
    {

        int a;
        int b;
        boolean c;
        boolean d;
        final StaggeredGridLayoutManager e;

        private a()
        {
            e = StaggeredGridLayoutManager.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    public static final class b extends RecyclerView.j
    {

        c e;
        public boolean f;

        public final int a()
        {
            if (e == null)
            {
                return -1;
            } else
            {
                return e.e;
            }
        }

        public b(int l)
        {
            super(l);
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

    final class c
    {

        ArrayList a;
        int b;
        int c;
        int d;
        final int e;
        final StaggeredGridLayoutManager f;

        private void f()
        {
            View view = (View)a.get(0);
            b b1 = (b)view.getLayoutParams();
            b = f.b.a(view);
            if (b1.f)
            {
                LazySpanLookup.FullSpanItem fullspanitem = f.g.d(((RecyclerView.j) (b1)).a.c());
                if (fullspanitem != null && fullspanitem.b == -1)
                {
                    b = b - fullspanitem.a(e);
                }
            }
        }

        private void g()
        {
            View view = (View)a.get(a.size() - 1);
            b b1 = (b)view.getLayoutParams();
            c = f.b.b(view);
            if (b1.f)
            {
                LazySpanLookup.FullSpanItem fullspanitem = f.g.d(((RecyclerView.j) (b1)).a.c());
                if (fullspanitem != null && fullspanitem.b == 1)
                {
                    int l = c;
                    c = fullspanitem.a(e) + l;
                }
            }
        }

        final int a()
        {
            if (b != 0x80000000)
            {
                return b;
            } else
            {
                f();
                return b;
            }
        }

        final int a(int l)
        {
            if (b != 0x80000000)
            {
                l = b;
            } else
            if (a.size() != 0)
            {
                f();
                return b;
            }
            return l;
        }

        final int a(int l, int i1)
        {
            byte byte1 = -1;
            int k1 = f.b.b();
            int l1 = f.b.c();
            byte byte0;
            if (i1 > l)
            {
                byte0 = 1;
            } else
            {
                byte0 = -1;
            }
            do
            {
label0:
                {
                    int j1 = byte1;
                    if (l != i1)
                    {
                        View view = (View)a.get(l);
                        j1 = f.b.a(view);
                        int i2 = f.b.b(view);
                        if (j1 >= l1 || i2 <= k1)
                        {
                            break label0;
                        }
                        j1 = android.support.v7.widget.StaggeredGridLayoutManager.a(view);
                    }
                    return j1;
                }
                l += byte0;
            } while (true);
        }

        final void a(View view)
        {
            b b1 = (b)view.getLayoutParams();
            b1.e = this;
            a.add(0, view);
            b = 0x80000000;
            if (a.size() == 1)
            {
                c = 0x80000000;
            }
            if (((RecyclerView.j) (b1)).a.m() || ((RecyclerView.j) (b1)).a.k())
            {
                d = d + f.b.c(view);
            }
        }

        final int b()
        {
            if (c != 0x80000000)
            {
                return c;
            } else
            {
                g();
                return c;
            }
        }

        final int b(int l)
        {
            if (c != 0x80000000)
            {
                l = c;
            } else
            if (a.size() != 0)
            {
                g();
                return c;
            }
            return l;
        }

        final void b(View view)
        {
            b b1 = (b)view.getLayoutParams();
            b1.e = this;
            a.add(view);
            c = 0x80000000;
            if (a.size() == 1)
            {
                b = 0x80000000;
            }
            if (((RecyclerView.j) (b1)).a.m() || ((RecyclerView.j) (b1)).a.k())
            {
                d = d + f.b.c(view);
            }
        }

        final void c()
        {
            a.clear();
            b = 0x80000000;
            c = 0x80000000;
            d = 0;
        }

        final void c(int l)
        {
            b = l;
            c = l;
        }

        final void d()
        {
            int l = a.size();
            View view = (View)a.remove(l - 1);
            b b1 = (b)view.getLayoutParams();
            b1.e = null;
            if (((RecyclerView.j) (b1)).a.m() || ((RecyclerView.j) (b1)).a.k())
            {
                d = d - f.b.c(view);
            }
            if (l == 1)
            {
                b = 0x80000000;
            }
            c = 0x80000000;
        }

        final void d(int l)
        {
            if (b != 0x80000000)
            {
                b = b + l;
            }
            if (c != 0x80000000)
            {
                c = c + l;
            }
        }

        final void e()
        {
            View view = (View)a.remove(0);
            b b1 = (b)view.getLayoutParams();
            b1.e = null;
            if (a.size() == 0)
            {
                c = 0x80000000;
            }
            if (((RecyclerView.j) (b1)).a.m() || ((RecyclerView.j) (b1)).a.k())
            {
                d = d - f.b.c(view);
            }
            b = 0x80000000;
        }

        private c(int l)
        {
            f = StaggeredGridLayoutManager.this;
            super();
            a = new ArrayList();
            b = 0x80000000;
            c = 0x80000000;
            d = 0;
            e = l;
        }

        c(int l, byte byte0)
        {
            this(l);
        }
    }


    private final a A = new a((byte)0);
    private boolean B;
    private boolean C;
    private final Runnable D = new Runnable() {

        final StaggeredGridLayoutManager a;

        public final void run()
        {
            android.support.v7.widget.StaggeredGridLayoutManager.a(a);
        }

            
            {
                a = StaggeredGridLayoutManager.this;
                super();
            }
    };
    public int a;
    u b;
    u c;
    boolean d;
    public int e;
    public int f;
    LazySpanLookup g;
    public SavedState m;
    private c n[];
    private int o;
    private int p;
    private p q;
    private boolean r;
    private BitSet s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private final Rect z = new Rect();

    public StaggeredGridLayoutManager(int l)
    {
        a = -1;
        r = false;
        d = false;
        e = -1;
        f = 0x80000000;
        g = new LazySpanLookup();
        t = 2;
        B = false;
        C = true;
        o = 1;
        g(l);
    }

    private static int a(int l, int i1, int j1)
    {
        int k1;
        if (i1 != 0 || j1 != 0)
        {
            if ((k1 = android.view.View.MeasureSpec.getMode(l)) == 0x80000000 || k1 == 0x40000000)
            {
                return android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(l) - i1 - j1, k1);
            }
        }
        return l;
    }

    private int a(RecyclerView.n n1, p p1, RecyclerView.r r1)
    {
        Object obj;
        Object obj1;
        View view;
        b b1;
        int l;
        int i1;
        int i2;
        int j2;
        int k2;
        int j3;
        s.set(0, a, true);
        int j1;
        if (p1.d == 1)
        {
            i2 = p1.f + p1.a;
        } else
        {
            i2 = p1.e - p1.a;
        }
        f(p1.d, i2);
        if (d)
        {
            j2 = b.c();
        } else
        {
            j2 = b.b();
        }
        l = 0;
_L31:
        if (p1.b >= 0 && p1.b < r1.a())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0 || s.isEmpty()) goto _L2; else goto _L1
_L1:
        view = n1.a(p1.b);
        p1.b = p1.b + p1.c;
        b1 = (b)view.getLayoutParams();
        j3 = ((RecyclerView.j) (b1)).a.c();
        obj = g;
        if (((LazySpanLookup) (obj)).a == null || j3 >= ((LazySpanLookup) (obj)).a.length)
        {
            l = -1;
        } else
        {
            l = ((LazySpanLookup) (obj)).a[j3];
        }
        if (l == -1)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (k2 == 0) goto _L4; else goto _L3
_L3:
        if (!b1.f) goto _L6; else goto _L5
_L5:
        obj = n[0];
_L9:
        obj1 = g;
        ((LazySpanLookup) (obj1)).c(j3);
        ((LazySpanLookup) (obj1)).a[j3] = ((c) (obj)).e;
_L12:
        b1.e = ((c) (obj));
        if (p1.d == 1)
        {
            super.a(view, -1, false);
        } else
        {
            super.a(view, 0, false);
        }
        if (b1.f)
        {
            if (o == 1)
            {
                a(view, w, e(b1.height, y));
            } else
            {
                a(view, e(b1.width, x), w);
            }
        } else
        if (o == 1)
        {
            a(view, x, e(b1.height, y));
        } else
        {
            a(view, e(b1.width, x), y);
        }
        if (p1.d == 1)
        {
            int k1;
            int l2;
            int i3;
            int k3;
            boolean flag;
            if (b1.f)
            {
                l = j(j2);
            } else
            {
                l = ((c) (obj)).b(j2);
            }
            i1 = l + b.c(view);
            if (k2 == 0 || !b1.f)
            {
                break MISSING_BLOCK_LABEL_1604;
            }
            obj1 = new LazySpanLookup.FullSpanItem();
            obj1.c = new int[a];
            for (j1 = 0; j1 < a; j1++)
            {
                ((LazySpanLookup.FullSpanItem) (obj1)).c[j1] = l - n[j1].b(l);
            }

            obj1.b = -1;
            obj1.a = j3;
            g.a(((LazySpanLookup.FullSpanItem) (obj1)));
            l1 = l;
        } else
        {
            if (b1.f)
            {
                i1 = i(j2);
            } else
            {
                i1 = ((c) (obj)).a(j2);
            }
            l1 = b.c(view);
            if (k2 != 0 && b1.f)
            {
                obj1 = new LazySpanLookup.FullSpanItem();
                obj1.c = new int[a];
                for (l = 0; l < a; l++)
                {
                    ((LazySpanLookup.FullSpanItem) (obj1)).c[l] = n[l].a(i1) - i1;
                }

                obj1.b = 1;
                obj1.a = j3;
                g.a(((LazySpanLookup.FullSpanItem) (obj1)));
            }
            l1 = i1 - l1;
        }
          goto _L7
_L6:
        l = p1.d;
        if (o == 0)
        {
            if (l == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag != d)
            {
                l = 1;
            } else
            {
                l = 0;
            }
        } else
        {
            if (l == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag == d)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag == v())
            {
                l = 1;
            } else
            {
                l = 0;
            }
        }
        if (l != 0)
        {
            l = a - 1;
            k1 = -1;
            i1 = -1;
        } else
        {
            l = 0;
            k1 = a;
            i1 = 1;
        }
        if (p1.d != 1)
        {
            break MISSING_BLOCK_LABEL_671;
        }
        obj1 = null;
        i3 = 0x7fffffff;
        k3 = b.b();
        l2 = l;
        l = i3;
        obj = obj1;
        if (l2 == k1) goto _L9; else goto _L8
_L8:
        obj = n[l2];
        i3 = ((c) (obj)).b(k3);
        int l1;
        if (i3 < l)
        {
            l = i3;
        } else
        {
            obj = obj1;
        }
        l2 += i1;
        obj1 = obj;
        break MISSING_BLOCK_LABEL_536;
        obj1 = null;
        i3 = 0x80000000;
        k3 = b.c();
        l2 = l;
        l = i3;
_L11:
        obj = obj1;
        if (l2 == k1) goto _L9; else goto _L10
_L10:
        obj = n[l2];
        i3 = ((c) (obj)).a(k3);
        if (i3 > l)
        {
            l = i3;
        } else
        {
            obj = obj1;
        }
        l2 += i1;
        obj1 = obj;
          goto _L11
          goto _L9
_L4:
        obj = n[l];
          goto _L12
_L7:
        if (!b1.f || p1.c != -1) goto _L14; else goto _L13
_L13:
        if (k2 != 0) goto _L16; else goto _L15
_L15:
        if (p1.d != 1) goto _L18; else goto _L17
_L17:
        k2 = n[0].b(0x80000000);
        l = 1;
_L24:
        if (l >= a) goto _L20; else goto _L19
_L19:
        if (n[l].b(0x80000000) == k2) goto _L22; else goto _L21
_L21:
        l = 0;
_L25:
        if (l == 0)
        {
            l = 1;
        } else
        {
            l = 0;
        }
_L28:
        if (l == 0) goto _L14; else goto _L23
_L23:
        obj1 = g.d(j3);
        if (obj1 != null)
        {
            obj1.d = true;
        }
_L16:
        B = true;
          goto _L14
_L22:
        l++;
          goto _L24
_L20:
        l = 1;
          goto _L25
_L18:
        k2 = n[0].a(0x80000000);
        l = 1;
_L29:
        if (l >= a)
        {
            break MISSING_BLOCK_LABEL_1291;
        }
        if (n[l].a(0x80000000) == k2) goto _L27; else goto _L26
_L26:
        l = 0;
_L30:
        if (l == 0)
        {
            l = 1;
        } else
        {
            l = 0;
        }
          goto _L28
_L27:
        l++;
          goto _L29
        l = 1;
          goto _L30
_L14:
        if (p1.d == 1)
        {
            if (b1.f)
            {
                for (l = a - 1; l >= 0; l--)
                {
                    n[l].b(view);
                }

            } else
            {
                b1.e.b(view);
            }
        } else
        if (b1.f)
        {
            l = a - 1;
            while (l >= 0) 
            {
                n[l].a(view);
                l--;
            }
        } else
        {
            b1.e.a(view);
        }
        if (b1.f)
        {
            l = c.b();
        } else
        {
            l = ((c) (obj)).e * p + c.b();
        }
        k2 = c.c(view) + l;
        if (o == 1)
        {
            b(view, l, l1, k2, i1);
        } else
        {
            b(view, l1, l, i1, k2);
        }
        if (b1.f)
        {
            f(q.d, i2);
        } else
        {
            a(((c) (obj)), q.d, i2);
        }
        a(n1, q);
        l = 1;
          goto _L31
_L2:
        if (l == 0)
        {
            a(n1, q);
        }
        if (q.d == -1)
        {
            l = i(b.b());
            l = b.b() - l;
        } else
        {
            l = j(b.c()) - b.c();
        }
        if (l > 0)
        {
            return Math.min(p1.a, l);
        } else
        {
            return 0;
        }
        l1 = l;
          goto _L7
    }

    static int a(StaggeredGridLayoutManager staggeredgridlayoutmanager, int l)
    {
        return staggeredgridlayoutmanager.k(l);
    }

    private View a(boolean flag)
    {
        t();
        int i1 = b.b();
        int j1 = b.c();
        int k1 = j();
        View view = null;
        for (int l = 0; l < k1; l++)
        {
            View view1 = c(l);
            int l1 = b.a(view1);
            if (b.b(view1) <= i1 || l1 >= j1)
            {
                continue;
            }
            if (l1 >= i1 || !flag)
            {
                return view1;
            }
            if (view == null)
            {
                view = view1;
            }
        }

        return view;
    }

    private void a(int l, RecyclerView.r r1)
    {
        int i1;
        i1 = 0;
        q.a = 0;
        q.b = l;
        if (!i()) goto _L2; else goto _L1
_L1:
        int j1 = r1.a;
        if (j1 == -1) goto _L2; else goto _L3
_L3:
        boolean flag1 = d;
        boolean flag;
        if (j1 < l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1 == flag)
        {
            l = b.e();
        } else
        {
            i1 = b.e();
            l = 0;
        }
_L5:
        if (h())
        {
            q.e = b.b() - i1;
            q.f = l + b.c();
            return;
        } else
        {
            q.f = l + b.d();
            q.e = -i1;
            return;
        }
_L2:
        l = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void a(RecyclerView.n n1, int l)
    {
_L12:
        if (j() <= 0) goto _L2; else goto _L1
_L1:
        View view = c(0);
        if (b.b(view) > l) goto _L2; else goto _L3
_L3:
        b b1 = (b)view.getLayoutParams();
        if (!b1.f) goto _L5; else goto _L4
_L4:
        int i1 = 0;
_L9:
        if (i1 >= a) goto _L7; else goto _L6
_L6:
        if (n[i1].a.size() != 1) goto _L8; else goto _L2
_L2:
        return;
_L8:
        i1++;
          goto _L9
_L7:
        for (int j1 = 0; j1 < a; j1++)
        {
            n[j1].e();
        }

        break; /* Loop/switch isn't completed */
_L5:
        if (b1.e.a.size() == 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        b1.e.e();
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L10
_L10:
        a(view, n1);
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void a(RecyclerView.n n1, RecyclerView.r r1, boolean flag)
    {
        int l = j(b.c());
        l = b.c() - l;
        if (l > 0)
        {
            l -= -d(-l, n1, r1);
            if (flag && l > 0)
            {
                b.a(l);
            }
        }
    }

    private void a(RecyclerView.n n1, p p1)
    {
        int l1 = 1;
        int l = 1;
        if (p1.a == 0)
        {
            if (p1.d == -1)
            {
                b(n1, p1.f);
                return;
            } else
            {
                a(n1, p1.e);
                return;
            }
        }
        if (p1.d == -1)
        {
            int l2 = p1.e;
            int j3 = p1.e;
            int i1;
            for (i1 = n[0].a(j3); l < a; i1 = l1)
            {
                int j2 = n[l].a(j3);
                l1 = i1;
                if (j2 > i1)
                {
                    l1 = j2;
                }
                l++;
            }

            l = l2 - i1;
            if (l < 0)
            {
                l = p1.f;
            } else
            {
                l = p1.f - Math.min(l, p1.a);
            }
            b(n1, l);
            return;
        }
        int i3 = p1.f;
        int j1 = n[0].b(i3);
        for (l = l1; l < a;)
        {
            int k2 = n[l].b(i3);
            int i2 = j1;
            if (k2 < j1)
            {
                i2 = k2;
            }
            l++;
            j1 = i2;
        }

        l = j1 - p1.f;
        if (l < 0)
        {
            l = p1.e;
        } else
        {
            int k1 = p1.e;
            l = Math.min(l, p1.a) + k1;
        }
        a(n1, l);
    }

    private void a(c c1, int l, int i1)
    {
        int j1 = c1.d;
        if (l == -1)
        {
            if (j1 + c1.a() <= i1)
            {
                s.set(c1.e, false);
            }
        } else
        if (c1.b() - j1 >= i1)
        {
            s.set(c1.e, false);
            return;
        }
    }

    private void a(View view, int l, int i1)
    {
        Object obj = z;
        if (super.i == null)
        {
            ((Rect) (obj)).set(0, 0, 0, 0);
        } else
        {
            ((Rect) (obj)).set(super.i.e(view));
        }
        obj = (b)view.getLayoutParams();
        view.measure(a(l, ((b) (obj)).leftMargin + z.left, ((b) (obj)).rightMargin + z.right), a(i1, ((b) (obj)).topMargin + z.top, ((b) (obj)).bottomMargin + z.bottom));
    }

    static boolean a(StaggeredGridLayoutManager staggeredgridlayoutmanager)
    {
        return staggeredgridlayoutmanager.e();
    }

    static int b(StaggeredGridLayoutManager staggeredgridlayoutmanager)
    {
        return staggeredgridlayoutmanager.o;
    }

    private View b(boolean flag)
    {
        t();
        int i1 = b.b();
        int j1 = b.c();
        View view = null;
        for (int l = j() - 1; l >= 0; l--)
        {
            View view1 = c(l);
            int k1 = b.a(view1);
            int l1 = b.b(view1);
            if (l1 <= i1 || k1 >= j1)
            {
                continue;
            }
            if (l1 <= j1 || !flag)
            {
                return view1;
            }
            if (view == null)
            {
                view = view1;
            }
        }

        return view;
    }

    private void b(int l, int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        if (d)
        {
            i2 = w();
        } else
        {
            i2 = x();
        }
        if (j1 == 3)
        {
            if (l < i1)
            {
                l1 = i1 + 1;
                k1 = l;
            } else
            {
                l1 = l + 1;
                k1 = i1;
            }
        } else
        {
            l1 = l + i1;
            k1 = l;
        }
        g.b(k1);
        j1;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 111
    //                   1 123
    //                   2 72
    //                   3 135;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        if (l1 > i2) goto _L6; else goto _L5
_L5:
        return;
_L2:
        g.b(l, i1);
        continue; /* Loop/switch isn't completed */
_L3:
        g.a(l, i1);
        continue; /* Loop/switch isn't completed */
_L4:
        g.a(l, 1);
        g.b(i1, 1);
        continue; /* Loop/switch isn't completed */
_L6:
        if (d)
        {
            l = x();
        } else
        {
            l = w();
        }
        if (k1 > l) goto _L5; else goto _L7
_L7:
        g();
        return;
        if (true) goto _L1; else goto _L8
_L8:
    }

    private void b(RecyclerView.n n1, int l)
    {
        int i1 = j() - 1;
_L12:
        if (i1 < 0) goto _L2; else goto _L1
_L1:
        View view = c(i1);
        if (b.a(view) < l) goto _L2; else goto _L3
_L3:
        b b1 = (b)view.getLayoutParams();
        if (!b1.f) goto _L5; else goto _L4
_L4:
        int j1 = 0;
_L9:
        if (j1 >= a) goto _L7; else goto _L6
_L6:
        if (n[j1].a.size() != 1) goto _L8; else goto _L2
_L2:
        return;
_L8:
        j1++;
          goto _L9
_L7:
        for (int k1 = 0; k1 < a; k1++)
        {
            n[k1].d();
        }

        break; /* Loop/switch isn't completed */
_L5:
        if (b1.e.a.size() == 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        b1.e.d();
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L10
_L10:
        a(view, n1);
        i1--;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void b(RecyclerView.n n1, RecyclerView.r r1, boolean flag)
    {
        int l = i(b.b()) - b.b();
        if (l > 0)
        {
            l -= d(l, n1, r1);
            if (flag && l > 0)
            {
                b.a(-l);
            }
        }
    }

    private static void b(View view, int l, int i1, int j1, int k1)
    {
        b b1 = (b)view.getLayoutParams();
        a(view, b1.leftMargin + l, b1.topMargin + i1, j1 - b1.rightMargin, k1 - b1.bottomMargin);
    }

    private int d(int l, RecyclerView.n n1, RecyclerView.r r1)
    {
        t();
        int i1;
        int j1;
        int k1;
        if (l > 0)
        {
            i1 = 1;
            j1 = w();
        } else
        {
            i1 = -1;
            j1 = x();
        }
        a(j1, r1);
        h(i1);
        q.b = j1 + q.c;
        k1 = Math.abs(l);
        q.a = k1;
        j1 = a(n1, q, r1);
        i1 = l;
        if (k1 >= j1)
        {
            if (l < 0)
            {
                i1 = -j1;
            } else
            {
                i1 = j1;
            }
        }
        b.a(-i1);
        u = d;
        return i1;
    }

    private static int e(int l, int i1)
    {
        if (l < 0)
        {
            return i1;
        } else
        {
            return android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000);
        }
    }

    private boolean e()
    {
        if (j() == 0 || t == 0 || !super.l)
        {
            return false;
        }
        int l;
        int i1;
        if (d)
        {
            i1 = w();
            l = x();
        } else
        {
            i1 = x();
            l = w();
        }
        if (i1 == 0 && s() != null)
        {
            g.a();
            super.k = true;
            g();
            return true;
        }
        if (!B)
        {
            return false;
        }
        LazySpanLookup.FullSpanItem fullspanitem;
        byte byte0;
        if (d)
        {
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        fullspanitem = g.a(i1, l + 1, byte0);
        if (fullspanitem == null)
        {
            B = false;
            g.a(l + 1);
            return false;
        }
        LazySpanLookup.FullSpanItem fullspanitem1 = g.a(i1, fullspanitem.a, byte0 * -1);
        if (fullspanitem1 == null)
        {
            g.a(fullspanitem.a);
        } else
        {
            g.a(fullspanitem1.a + 1);
        }
        super.k = true;
        g();
        return true;
    }

    private void f(int l, int i1)
    {
        for (int j1 = 0; j1 < a; j1++)
        {
            if (!n[j1].a.isEmpty())
            {
                a(n[j1], l, i1);
            }
        }

    }

    private int g(RecyclerView.r r1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        t();
        u u1 = b;
        View view;
        boolean flag;
        if (!C)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!C)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.w.a(r1, u1, view, b(flag), this, C, d);
    }

    private void g(int l)
    {
        a(((String) (null)));
        if (l != a)
        {
            g.a();
            g();
            a = l;
            s = new BitSet(a);
            n = new c[a];
            for (l = 0; l < a; l++)
            {
                n[l] = new c(l, (byte)0);
            }

            g();
        }
    }

    private int h(RecyclerView.r r1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        t();
        u u1 = b;
        View view;
        boolean flag;
        if (!C)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!C)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.w.a(r1, u1, view, b(flag), this, C);
    }

    private void h(int l)
    {
        boolean flag = true;
        q.d = l;
        p p1 = q;
        boolean flag2 = d;
        boolean flag1;
        if (l == -1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag2 == flag1)
        {
            l = ((flag) ? 1 : 0);
        } else
        {
            l = -1;
        }
        p1.c = l;
    }

    private int i(int l)
    {
        int j1 = n[0].a(l);
        for (int i1 = 1; i1 < a;)
        {
            int l1 = n[i1].a(l);
            int k1 = j1;
            if (l1 < j1)
            {
                k1 = l1;
            }
            i1++;
            j1 = k1;
        }

        return j1;
    }

    private int i(RecyclerView.r r1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        t();
        u u1 = b;
        View view;
        boolean flag;
        if (!C)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!C)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.w.b(r1, u1, view, b(flag), this, C);
    }

    private int j(int l)
    {
        int j1 = n[0].b(l);
        for (int i1 = 1; i1 < a;)
        {
            int l1 = n[i1].b(l);
            int k1 = j1;
            if (l1 > j1)
            {
                k1 = l1;
            }
            i1++;
            j1 = k1;
        }

        return j1;
    }

    private int k(int l)
    {
        if (j() != 0) goto _L2; else goto _L1
_L1:
        if (!d) goto _L4; else goto _L3
_L3:
        return 1;
_L4:
        return -1;
_L2:
        boolean flag;
        if (l < x())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag != d)
        {
            return -1;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private View s()
    {
        BitSet bitset;
        View view;
        b b1;
        c c1;
        int l;
        byte byte0;
        int i1;
        byte byte1;
        int j1;
        l = j() - 1;
        bitset = new BitSet(a);
        bitset.set(0, a, true);
        if (o == 1 && v())
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        if (d)
        {
            i1 = -1;
        } else
        {
            i1 = l + 1;
            l = 0;
        }
        if (l < i1)
        {
            byte1 = 1;
        } else
        {
            byte1 = -1;
        }
        j1 = l;
_L9:
        if (j1 == i1) goto _L2; else goto _L1
_L1:
        view = c(j1);
        b1 = (b)view.getLayoutParams();
        if (!bitset.get(b1.e.e))
        {
            break MISSING_BLOCK_LABEL_208;
        }
        c1 = b1.e;
        if (!d) goto _L4; else goto _L3
_L3:
        if (c1.b() >= b.c()) goto _L6; else goto _L5
_L5:
        l = 1;
_L8:
        if (l != 0)
        {
            return view;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (c1.a() > b.b())
        {
            l = 1;
            continue; /* Loop/switch isn't completed */
        }
_L6:
        l = 0;
        if (true) goto _L8; else goto _L7
_L7:
        bitset.clear(b1.e.e);
        int l1;
        if (b1.f || j1 + byte1 == i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj = c(j1 + byte1);
        if (d)
        {
            l = b.b(view);
            int k1 = b.b(((View) (obj)));
            if (l < k1)
            {
                return view;
            }
            if (l != k1)
            {
                break MISSING_BLOCK_LABEL_404;
            }
            l = 1;
        } else
        {
            l = b.a(view);
            l1 = b.a(((View) (obj)));
            if (l > l1)
            {
                return view;
            }
            if (l != l1)
            {
                break MISSING_BLOCK_LABEL_404;
            }
            l = 1;
        }
_L10:
        if (l == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (b)((View) (obj)).getLayoutParams();
        if (b1.e.e - ((b) (obj)).e.e < 0)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (byte0 < 0)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (l != l1)
        {
            return view;
        }
        continue; /* Loop/switch isn't completed */
        j1 += byte1;
          goto _L9
_L2:
        return null;
        l = 0;
          goto _L10
    }

    private void t()
    {
        if (b == null)
        {
            b = android.support.v7.widget.u.a(this, o);
            c = android.support.v7.widget.u.a(this, 1 - o);
            q = new p();
        }
    }

    private void u()
    {
        boolean flag = true;
        if (o != 1 && v()) goto _L2; else goto _L1
_L1:
        flag = r;
_L4:
        d = flag;
        return;
_L2:
        if (r)
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean v()
    {
        return android.support.v4.view.w.h(super.i) == 1;
    }

    private int w()
    {
        int l = j();
        if (l == 0)
        {
            return 0;
        } else
        {
            return a(c(l - 1));
        }
    }

    private int x()
    {
        if (j() == 0)
        {
            return 0;
        } else
        {
            return a(c(0));
        }
    }

    public final int a(int l, RecyclerView.n n1, RecyclerView.r r1)
    {
        return d(l, n1, r1);
    }

    public final int a(RecyclerView.r r1)
    {
        return g(r1);
    }

    public final RecyclerView.j a()
    {
        return new b(-2);
    }

    public final RecyclerView.j a(Context context, AttributeSet attributeset)
    {
        return new b(context, attributeset);
    }

    public final RecyclerView.j a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new b((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new b(layoutparams);
        }
    }

    public final void a(int l, int i1)
    {
        b(l, i1, 0);
    }

    public final void a(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            m = (SavedState)parcelable;
            g();
        }
    }

    public final void a(RecyclerView.n n1, RecyclerView.r r1)
    {
        a a1;
        int i1;
        boolean flag1;
        flag1 = true;
        t();
        a1 = A;
        a1.a = -1;
        a1.b = 0x80000000;
        a1.c = false;
        a1.d = false;
        if (m != null)
        {
            if (m.c > 0)
            {
                if (m.c == a)
                {
                    int k1 = 0;
                    while (k1 < a) 
                    {
                        n[k1].c();
                        int k2 = m.d[k1];
                        int l = k2;
                        if (k2 != 0x80000000)
                        {
                            if (m.i)
                            {
                                l = k2 + b.c();
                            } else
                            {
                                l = k2 + b.b();
                            }
                        }
                        n[k1].c(l);
                        k1++;
                    }
                } else
                {
                    SavedState savedstate = m;
                    savedstate.d = null;
                    savedstate.c = 0;
                    savedstate.e = 0;
                    savedstate.f = null;
                    savedstate.g = null;
                    m.a = m.b;
                }
            }
            v = m.j;
            boolean flag2 = m.h;
            a(((String) (null)));
            if (m != null && m.h != flag2)
            {
                m.h = flag2;
            }
            r = flag2;
            g();
            u();
            int l1;
            int l2;
            if (m.a != -1)
            {
                e = m.a;
                a1.c = m.i;
            } else
            {
                a1.c = d;
            }
            if (m.e > 1)
            {
                g.a = m.f;
                g.b = m.g;
            }
        } else
        {
            u();
            a1.c = d;
        }
        if (!r1.j && e != -1) goto _L2; else goto _L1
_L1:
        i1 = 0;
_L30:
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        if (!u) goto _L6; else goto _L5
_L5:
        l2 = r1.a();
        i1 = j() - 1;
_L15:
        if (i1 < 0) goto _L8; else goto _L7
_L7:
        l1 = a(c(i1));
        if (l1 < 0 || l1 >= l2)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = l1;
_L16:
        a1.a = i1;
        a1.b = 0x80000000;
          goto _L4
_L2:
        if (e < 0 || e >= r1.a())
        {
            e = -1;
            f = 0x80000000;
            i1 = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (m != null && m.a != -1 && m.c > 0) goto _L10; else goto _L9
_L9:
        view = a(e);
        if (view == null) goto _L12; else goto _L11
_L11:
        if (d)
        {
            i1 = w();
        } else
        {
            i1 = x();
        }
        a1.a = i1;
        if (f != 0x80000000)
        {
            if (a1.c)
            {
                a1.b = b.c() - f - b.b(view);
            } else
            {
                a1.b = (b.b() + f) - b.a(view);
            }
            i1 = 1;
            continue; /* Loop/switch isn't completed */
        }
        if (b.c(view) > b.e())
        {
            if (a1.c)
            {
                i1 = b.c();
            } else
            {
                i1 = b.b();
            }
            a1.b = i1;
        } else
        {
            i1 = b.a(view) - b.b();
            if (i1 < 0)
            {
                a1.b = -i1;
            } else
            {
                i1 = b.c() - b.b(view);
                if (i1 < 0)
                {
                    a1.b = i1;
                } else
                {
                    a1.b = 0x80000000;
                }
            }
        }
_L14:
        i1 = 1;
        continue; /* Loop/switch isn't completed */
_L12:
        a1.a = e;
        if (f == 0x80000000)
        {
            boolean flag3;
            if (k(a1.a) == 1)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            a1.c = flag3;
            if (a1.c)
            {
                i1 = a1.e.b.c();
            } else
            {
                i1 = a1.e.b.b();
            }
            a1.b = i1;
        } else
        {
            i1 = f;
            if (a1.c)
            {
                a1.b = a1.e.b.c() - i1;
            } else
            {
                a1.b = i1 + a1.e.b.b();
            }
        }
        a1.d = true;
        continue; /* Loop/switch isn't completed */
_L10:
        a1.b = 0x80000000;
        a1.a = e;
        if (true) goto _L14; else goto _L13
_L13:
        i1--;
          goto _L15
_L8:
        i1 = 0;
          goto _L16
_L6:
        k3 = r1.a();
        i4 = j();
        i2 = 0;
_L20:
        if (i2 >= i4) goto _L18; else goto _L17
_L17:
        i3 = a(c(i2));
        if (i3 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = i3;
        if (i3 < k3) goto _L16; else goto _L19
_L19:
        i2++;
          goto _L20
_L18:
        i1 = 0;
          goto _L16
_L4:
        boolean flag;
        if (m == null && (a1.c != u || v() != v))
        {
            g.a();
            a1.d = true;
        }
        View view;
        int i2;
        int i3;
        int k3;
        int i4;
        if (j() > 0 && (m == null || m.c <= 0))
        {
            if (a1.d)
            {
                for (i1 = 0; i1 < a; i1++)
                {
                    n[i1].c();
                    if (a1.b != 0x80000000)
                    {
                        n[i1].c(a1.b);
                    }
                }

            } else
            {
                int j2 = 0;
                while (j2 < a) 
                {
                    c c1 = n[j2];
                    boolean flag4 = d;
                    int l3 = a1.b;
                    int j1;
                    if (flag4)
                    {
                        j1 = c1.b(0x80000000);
                    } else
                    {
                        j1 = c1.a(0x80000000);
                    }
                    c1.c();
                    if (j1 != 0x80000000 && (!flag4 || j1 >= c1.f.b.c()) && (flag4 || j1 <= c1.f.b.b()))
                    {
                        int j3 = j1;
                        if (l3 != 0x80000000)
                        {
                            j3 = j1 + l3;
                        }
                        c1.c = j3;
                        c1.b = j3;
                    }
                    j2++;
                }
            }
        }
        a(n1);
        B = false;
        p = c.e() / a;
        w = android.view.View.MeasureSpec.makeMeasureSpec(c.e(), 0x40000000);
        if (o == 1)
        {
            x = android.view.View.MeasureSpec.makeMeasureSpec(p, 0x40000000);
            y = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        } else
        {
            y = android.view.View.MeasureSpec.makeMeasureSpec(p, 0x40000000);
            x = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        a(a1.a, r1);
        if (a1.c)
        {
            h(-1);
            a(n1, q, r1);
            h(1);
            q.b = a1.a + q.c;
            a(n1, q, r1);
        } else
        {
            h(1);
            a(n1, q, r1);
            h(-1);
            q.b = a1.a + q.c;
            a(n1, q, r1);
        }
        if (j() > 0)
        {
            if (d)
            {
                a(n1, r1, true);
                b(n1, r1, false);
            } else
            {
                b(n1, r1, true);
                a(n1, r1, false);
            }
        }
        if (r1.j) goto _L22; else goto _L21
_L21:
        if (t == 0 || j() <= 0) goto _L24; else goto _L23
_L23:
        flag = flag1;
        if (B) goto _L26; else goto _L25
_L25:
        if (s() == null) goto _L24; else goto _L27
_L27:
        flag = flag1;
_L26:
        if (flag)
        {
            a(D);
            n1 = D;
            if (super.i != null)
            {
                android.support.v4.view.w.a(super.i, n1);
            }
        }
        e = -1;
        f = 0x80000000;
_L22:
        u = a1.c;
        v = v();
        m = null;
        return;
_L24:
        flag = false;
        if (true) goto _L26; else goto _L28
_L28:
        if (true) goto _L30; else goto _L29
_L29:
    }

    public final void a(RecyclerView recyclerview)
    {
        recyclerview = new r(recyclerview.getContext()) {

            final StaggeredGridLayoutManager a;

            public final PointF a(int l)
            {
                l = android.support.v7.widget.StaggeredGridLayoutManager.a(a, l);
                if (l == 0)
                {
                    return null;
                }
                if (android.support.v7.widget.StaggeredGridLayoutManager.b(a) == 0)
                {
                    return new PointF(l, 0.0F);
                } else
                {
                    return new PointF(0.0F, l);
                }
            }

            
            {
                a = StaggeredGridLayoutManager.this;
                super(context);
            }
        };
        recyclerview.g = 0;
        a(((RecyclerView.q) (recyclerview)));
    }

    public final void a(RecyclerView recyclerview, RecyclerView.n n1)
    {
        a(D);
        for (int l = 0; l < a; l++)
        {
            n[l].c();
        }

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
        int l = a(view);
        int i1 = a(view1);
        if (l < i1)
        {
            accessibilityevent.b(l);
            accessibilityevent.c(i1);
            return;
        } else
        {
            accessibilityevent.b(i1);
            accessibilityevent.c(l);
            return;
        }
    }

    public final void a(String s1)
    {
        if (m == null)
        {
            super.a(s1);
        }
    }

    public final boolean a(RecyclerView.j j1)
    {
        return j1 instanceof b;
    }

    public int[] a(int ai[])
    {
        int ai1[];
        int l;
        if (ai == null)
        {
            ai1 = new int[a];
        } else
        {
            ai1 = ai;
            if (ai.length < a)
            {
                throw new IllegalArgumentException((new StringBuilder("Provided int[]'s size must be more than or equal to span count. Expected:")).append(a).append(", array size:").append(ai.length).toString());
            }
        }
        l = 0;
        while (l < a) 
        {
            ai = n[l];
            int i1;
            if (((c) (ai)).f.r)
            {
                i1 = ai.a(((c) (ai)).a.size() - 1, -1);
            } else
            {
                i1 = ai.a(0, ((c) (ai)).a.size());
            }
            ai1[l] = i1;
            l++;
        }
        return ai1;
    }

    public final int b(int l, RecyclerView.n n1, RecyclerView.r r1)
    {
        return d(l, n1, r1);
    }

    public final int b(RecyclerView.n n1, RecyclerView.r r1)
    {
        if (o == 0)
        {
            return a;
        } else
        {
            return super.b(n1, r1);
        }
    }

    public final int b(RecyclerView.r r1)
    {
        return g(r1);
    }

    public final Parcelable b()
    {
        if (m != null)
        {
            return new SavedState(m);
        }
        SavedState savedstate = new SavedState();
        savedstate.h = r;
        savedstate.i = u;
        savedstate.j = v;
        if (g != null && g.a != null)
        {
            savedstate.f = g.a;
            savedstate.e = savedstate.f.length;
            savedstate.g = g.b;
        } else
        {
            savedstate.e = 0;
        }
        if (j() > 0)
        {
            t();
            View view;
            int l;
            int i1;
            if (u)
            {
                l = w();
            } else
            {
                l = x();
            }
            savedstate.a = l;
            if (d)
            {
                view = b(true);
            } else
            {
                view = a(true);
            }
            if (view == null)
            {
                l = -1;
            } else
            {
                l = a(view);
            }
            savedstate.b = l;
            savedstate.c = a;
            savedstate.d = new int[a];
            i1 = 0;
            while (i1 < a) 
            {
                if (u)
                {
                    int j1 = n[i1].b(0x80000000);
                    l = j1;
                    if (j1 != 0x80000000)
                    {
                        l = j1 - b.c();
                    }
                } else
                {
                    int k1 = n[i1].a(0x80000000);
                    l = k1;
                    if (k1 != 0x80000000)
                    {
                        l = k1 - b.b();
                    }
                }
                savedstate.d[i1] = l;
                i1++;
            }
        } else
        {
            savedstate.a = -1;
            savedstate.b = -1;
            savedstate.c = 0;
        }
        return savedstate;
    }

    public final void b(int l)
    {
        if (m != null && m.a != l)
        {
            m.a();
        }
        e = l;
        f = 0x80000000;
        g();
    }

    public final void b(int l, int i1)
    {
        b(l, i1, 1);
    }

    public final void b(View view, android.support.v4.view.a.b b1)
    {
        int j1 = 1;
        int l = 1;
        int i1 = -1;
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (!(layoutparams instanceof b))
        {
            super.a(view, b1);
            return;
        }
        view = (b)layoutparams;
        int k1;
        if (o == 0)
        {
            k1 = view.a();
            if (((b) (view)).f)
            {
                l = a;
            }
            byte byte0 = -1;
            j1 = l;
            l = byte0;
        } else
        {
            l = view.a();
            if (((b) (view)).f)
            {
                int l1 = a;
                k1 = -1;
                i1 = l;
                j1 = -1;
                l = l1;
            } else
            {
                k1 = -1;
                i1 = l;
                byte byte1 = -1;
                l = j1;
                j1 = byte1;
            }
        }
        b1.a(android.support.v4.view.a.b.j.a(k1, j1, i1, l, ((b) (view)).f));
    }

    public final int[] b(int ai[])
    {
        int ai1[];
        int l;
        if (ai == null)
        {
            ai1 = new int[a];
        } else
        {
            ai1 = ai;
            if (ai.length < a)
            {
                throw new IllegalArgumentException((new StringBuilder("Provided int[]'s size must be more than or equal to span count. Expected:")).append(a).append(", array size:").append(ai.length).toString());
            }
        }
        l = 0;
        while (l < a) 
        {
            ai = n[l];
            int i1;
            if (((c) (ai)).f.r)
            {
                i1 = ai.a(0, ((c) (ai)).a.size());
            } else
            {
                i1 = ai.a(((c) (ai)).a.size() - 1, -1);
            }
            ai1[l] = i1;
            l++;
        }
        return ai1;
    }

    public final int c(RecyclerView.n n1, RecyclerView.r r1)
    {
        if (o == 1)
        {
            return a;
        } else
        {
            return super.c(n1, r1);
        }
    }

    public final int c(RecyclerView.r r1)
    {
        return h(r1);
    }

    public final void c(int l, int i1)
    {
        b(l, i1, 2);
    }

    public final boolean c()
    {
        return o == 0;
    }

    public final int d(RecyclerView.r r1)
    {
        return h(r1);
    }

    public final void d(int l)
    {
        super.d(l);
        for (int i1 = 0; i1 < a; i1++)
        {
            n[i1].d(l);
        }

    }

    public final void d(int l, int i1)
    {
        b(l, i1, 3);
    }

    public final boolean d()
    {
        return o == 1;
    }

    public final int e(RecyclerView.r r1)
    {
        return i(r1);
    }

    public final void e(int l)
    {
        super.e(l);
        for (int i1 = 0; i1 < a; i1++)
        {
            n[i1].d(l);
        }

    }

    public final int f(RecyclerView.r r1)
    {
        return i(r1);
    }

    public final void f(int l)
    {
        if (l == 0)
        {
            e();
        }
    }

    public final boolean f()
    {
        return m == null;
    }

    public final void q()
    {
        g.a();
        g();
    }
}
