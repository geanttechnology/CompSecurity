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
import android.support.v4.view.a.f;
import android.support.v4.view.w;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            u, RecyclerView, w, m, 
//            r

public final class LinearLayoutManager extends RecyclerView.i
{
    static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        int a;
        int b;
        boolean c;

        final boolean a()
        {
            return a >= 0;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeInt(a);
            parcel.writeInt(b);
            if (c)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
        }


        public SavedState()
        {
        }

        SavedState(Parcel parcel)
        {
            boolean flag = true;
            super();
            a = parcel.readInt();
            b = parcel.readInt();
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            c = flag;
        }

        public SavedState(SavedState savedstate)
        {
            a = savedstate.a;
            b = savedstate.b;
            c = savedstate.c;
        }
    }

    final class a
    {

        int a;
        int b;
        boolean c;
        final LinearLayoutManager d;

        final void a()
        {
            int i1;
            if (c)
            {
                i1 = d.b.c();
            } else
            {
                i1 = d.b.b();
            }
            b = i1;
        }

        public final void a(View view)
        {
            if (c)
            {
                b = d.b.b(view) + d.b.a();
            } else
            {
                b = d.b.a(view);
            }
            a = android.support.v7.widget.LinearLayoutManager.a(view);
        }

        public final String toString()
        {
            return (new StringBuilder("AnchorInfo{mPosition=")).append(a).append(", mCoordinate=").append(b).append(", mLayoutFromEnd=").append(c).append('}').toString();
        }

        a()
        {
            d = LinearLayoutManager.this;
            super();
        }
    }

    protected static final class b
    {

        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b()
        {
        }
    }

    static final class c
    {

        boolean a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        boolean i;
        int j;
        List k;

        public final void a(RecyclerView.u u1)
        {
            int l1 = k.size();
            RecyclerView.u u2 = null;
            int i1 = 0x7fffffff;
            for (int j1 = 0; j1 < l1; j1++)
            {
                RecyclerView.u u3 = (RecyclerView.u)k.get(j1);
                if (u3 == u1 || u3.m())
                {
                    continue;
                }
                int k1 = (u3.c() - d) * e;
                if (k1 < 0 || k1 >= i1)
                {
                    continue;
                }
                u2 = u3;
                if (k1 == 0)
                {
                    break;
                }
                u2 = u3;
                i1 = k1;
            }

            if (u2 == null)
            {
                i1 = -1;
            } else
            {
                i1 = u2.c();
            }
            d = i1;
        }

        c()
        {
            a = true;
            h = 0;
            i = false;
            k = null;
        }
    }


    int a;
    u b;
    boolean c;
    int d;
    int e;
    SavedState f;
    final a g;
    private c m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;

    public LinearLayoutManager()
    {
        this((byte)0);
    }

    private LinearLayoutManager(byte byte0)
    {
        o = false;
        c = false;
        p = false;
        q = true;
        d = -1;
        e = 0x80000000;
        f = null;
        g = new a();
        a(((String) (null)));
        if (1 != a)
        {
            a = 1;
            b = null;
            g();
        }
        a(((String) (null)));
        if (o)
        {
            o = false;
            g();
        }
    }

    private int a(int i1, RecyclerView.n n1, RecyclerView.r r1, boolean flag)
    {
        int j1 = b.c() - i1;
        if (j1 > 0)
        {
            int k1 = -d(-j1, n1, r1);
            j1 = k1;
            if (flag)
            {
                i1 = b.c() - (i1 + k1);
                j1 = k1;
                if (i1 > 0)
                {
                    b.a(i1);
                    j1 = k1 + i1;
                }
            }
            return j1;
        } else
        {
            return 0;
        }
    }

    private int a(RecyclerView.n n1, c c1, RecyclerView.r r1, boolean flag)
    {
        b b1;
        int l1;
        int j3;
        j3 = c1.c;
        if (c1.g != 0x80000000)
        {
            if (c1.c < 0)
            {
                c1.g = c1.g + c1.c;
            }
            a(n1, c1);
        }
        int i1 = c1.c;
        l1 = c1.h;
        b1 = new b();
        l1 = i1 + l1;
_L11:
        if (l1 <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        int k1;
        int i2;
        if (c1.d >= 0 && c1.d < r1.a())
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (k1 == 0) goto _L2; else goto _L3
_L3:
        b1.a = 0;
        b1.b = false;
        b1.c = false;
        b1.d = false;
        if (c1.k == null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        i2 = c1.k.size();
        k1 = 0;
_L8:
        if (k1 >= i2) goto _L5; else goto _L4
_L4:
        obj = (RecyclerView.u)c1.k.get(k1);
        if (((RecyclerView.u) (obj)).m() || c1.d != ((RecyclerView.u) (obj)).c()) goto _L7; else goto _L6
_L6:
        c1.a(((RecyclerView.u) (obj)));
        obj = ((RecyclerView.u) (obj)).a;
_L9:
        if (obj == null)
        {
            b1.b = true;
        } else
        {
            RecyclerView.j j1 = (RecyclerView.j)((View) (obj)).getLayoutParams();
            int k2;
            int l2;
            int i3;
            if (c1.k == null)
            {
                boolean flag3 = c;
                RecyclerView.j j2;
                Rect rect;
                int k3;
                boolean flag1;
                if (c1.f == -1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag3 == flag1)
                {
                    super.a(((View) (obj)), -1, false);
                } else
                {
                    super.a(((View) (obj)), 0, false);
                }
            } else
            {
                boolean flag4 = c;
                boolean flag2;
                if (c1.f == -1)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag4 == flag2)
                {
                    super.a(((View) (obj)), -1, true);
                } else
                {
                    super.a(((View) (obj)), 0, true);
                }
            }
            j2 = (RecyclerView.j)((View) (obj)).getLayoutParams();
            rect = super.i.e(((View) (obj)));
            k1 = rect.left;
            k2 = rect.right;
            l2 = rect.top;
            i3 = rect.bottom;
            ((View) (obj)).measure(android.support.v7.widget.RecyclerView.i.a(k(), k1 + k2 + 0 + (m() + o() + j2.leftMargin + j2.rightMargin), j2.width, c()), android.support.v7.widget.RecyclerView.i.a(l(), i3 + l2 + 0 + (n() + p() + j2.topMargin + j2.bottomMargin), j2.height, d()));
            b1.a = b.c(((View) (obj)));
            if (a == 1)
            {
                if (t())
                {
                    k2 = k() - o();
                    k1 = k2 - b.d(((View) (obj)));
                } else
                {
                    k1 = m();
                    k2 = b.d(((View) (obj))) + k1;
                }
                if (c1.f == -1)
                {
                    i3 = c1.b;
                    l2 = c1.b;
                    k3 = b1.a;
                    l2 -= k3;
                } else
                {
                    l2 = c1.b;
                    i3 = c1.b + b1.a;
                }
            } else
            {
                l2 = n();
                i3 = l2 + b.d(((View) (obj)));
                if (c1.f == -1)
                {
                    k2 = c1.b;
                    k1 = c1.b - b1.a;
                } else
                {
                    k1 = c1.b;
                    k2 = c1.b + b1.a;
                }
            }
            a(((View) (obj)), k1 + j1.leftMargin, l2 + j1.topMargin, k2 - j1.rightMargin, i3 - j1.bottomMargin);
            if (j1.a.m() || j1.a.k())
            {
                b1.c = true;
            }
            b1.d = ((View) (obj)).isFocusable();
        }
        if (!b1.b)
        {
            c1.b = c1.b + b1.a * c1.f;
            if (!b1.c || m.k != null || !r1.j)
            {
                c1.c = c1.c - b1.a;
                k1 = l1 - b1.a;
            } else
            {
                k1 = l1;
            }
            if (c1.g != 0x80000000)
            {
                c1.g = c1.g + b1.a;
                if (c1.c < 0)
                {
                    c1.g = c1.g + c1.c;
                }
                a(n1, c1);
            }
            if (!flag || !b1.d)
            {
                break MISSING_BLOCK_LABEL_947;
            }
        }
_L2:
        return j3 - c1.c;
_L7:
        k1++;
          goto _L8
_L5:
        obj = null;
          goto _L9
        obj = n1.a(c1.d);
        c1.d = c1.d + c1.e;
          goto _L9
        l1 = k1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private View a(int i1, int j1, int k1)
    {
        View view1;
label0:
        {
            View view3;
label1:
            {
                View view = null;
                u();
                int i2 = b.b();
                int j2 = b.c();
                int l1;
                if (j1 > i1)
                {
                    l1 = 1;
                } else
                {
                    l1 = -1;
                }
                view1 = null;
                while (i1 != j1) 
                {
                    View view2 = c(i1);
                    int k2 = a(view2);
                    if (k2 >= 0 && k2 < k1)
                    {
                        if (((RecyclerView.j)view2.getLayoutParams()).a.m())
                        {
                            if (view1 == null)
                            {
                                view1 = view2;
                            }
                        } else
                        {
                            if (b.a(view2) < j2)
                            {
                                view3 = view2;
                                if (b.b(view2) >= i2)
                                {
                                    break label1;
                                }
                            }
                            if (view == null)
                            {
                                view = view2;
                            }
                        }
                    }
                    i1 += l1;
                }
                if (view == null)
                {
                    break label0;
                }
                view3 = view;
            }
            return view3;
        }
        return view1;
    }

    private View a(int i1, int j1, boolean flag)
    {
        u();
        int k1 = b.b();
        int l1 = b.c();
        View view;
        byte byte0;
        if (j1 > i1)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        view = null;
        for (; i1 != j1; i1 += byte0)
        {
            View view1 = c(i1);
            int i2 = b.a(view1);
            int j2 = b.b(view1);
            if (i2 >= l1 || j2 <= k1)
            {
                continue;
            }
            if (!flag || i2 >= k1 && j2 <= l1)
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

    private View a(boolean flag)
    {
        if (c)
        {
            return a(j() - 1, -1, flag);
        } else
        {
            return a(0, j(), flag);
        }
    }

    private void a(int i1, int j1, boolean flag, RecyclerView.r r1)
    {
        byte byte0 = -1;
        boolean flag1 = true;
        m.h = g(r1);
        m.f = i1;
        if (i1 == 1)
        {
            r1 = m;
            r1.h = ((c) (r1)).h + b.f();
            r1 = w();
            c c1 = m;
            if (c)
            {
                i1 = byte0;
            } else
            {
                i1 = 1;
            }
            c1.e = i1;
            m.d = a(((View) (r1))) + m.e;
            m.b = b.b(r1);
            i1 = b.b(r1) - b.c();
        } else
        {
            r1 = v();
            c c2 = m;
            c2.h = c2.h + b.b();
            c2 = m;
            if (c)
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = -1;
            }
            c2.e = i1;
            m.d = a(((View) (r1))) + m.e;
            m.b = b.a(r1);
            i1 = -b.a(r1) + b.b();
        }
        m.c = j1;
        if (flag)
        {
            r1 = m;
            r1.c = ((c) (r1)).c - i1;
        }
        m.g = i1;
    }

    private void a(a a1)
    {
        e(a1.a, a1.b);
    }

    private void a(RecyclerView.n n1, int i1, int j1)
    {
        if (i1 != j1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k1;
        k1 = i1;
        if (j1 <= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        j1--;
        while (j1 >= i1) 
        {
            a(j1, n1);
            j1--;
        }
        if (true) goto _L1; else goto _L3
_L3:
        while (k1 > j1) 
        {
            a(k1, n1);
            k1--;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(RecyclerView.n n1, c c1)
    {
        if (c1.a) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (c1.f != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        int i1 = c1.g;
        int j2 = j();
        if (i1 >= 0)
        {
            int l2 = b.d() - i1;
            if (c)
            {
                int j1 = 0;
                while (j1 < j2) 
                {
                    c1 = c(j1);
                    if (b.a(c1) < l2)
                    {
                        a(n1, 0, j1);
                        return;
                    }
                    j1++;
                }
            } else
            {
                int k1 = j2 - 1;
                while (k1 >= 0) 
                {
                    c1 = c(k1);
                    if (b.a(c1) < l2)
                    {
                        a(n1, j2 - 1, k1);
                        return;
                    }
                    k1--;
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        int k2;
        int i3;
        k2 = c1.g;
        if (k2 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i3 = j();
        if (!c)
        {
            break; /* Loop/switch isn't completed */
        }
        int l1 = i3 - 1;
        while (l1 >= 0) 
        {
            c1 = c(l1);
            if (b.b(c1) > k2)
            {
                a(n1, i3 - 1, l1);
                return;
            }
            l1--;
        }
        if (true) goto _L1; else goto _L4
_L4:
        int i2 = 0;
        while (i2 < i3) 
        {
            c1 = c(i2);
            if (b.b(c1) > k2)
            {
                a(n1, 0, i2);
                return;
            }
            i2++;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private int b(int i1, RecyclerView.n n1, RecyclerView.r r1, boolean flag)
    {
        int j1 = i1 - b.b();
        if (j1 > 0)
        {
            int k1 = -d(j1, n1, r1);
            j1 = k1;
            if (flag)
            {
                i1 = (i1 + k1) - b.b();
                j1 = k1;
                if (i1 > 0)
                {
                    b.a(-i1);
                    j1 = k1 - i1;
                }
            }
            return j1;
        } else
        {
            return 0;
        }
    }

    private View b(boolean flag)
    {
        if (c)
        {
            return a(0, j(), flag);
        } else
        {
            return a(j() - 1, -1, flag);
        }
    }

    private void b(a a1)
    {
        f(a1.a, a1.b);
    }

    private int d(int i1, RecyclerView.n n1, RecyclerView.r r1)
    {
        if (j() == 0 || i1 == 0)
        {
            return 0;
        }
        m.a = true;
        u();
        int j1;
        int k1;
        int l1;
        if (i1 > 0)
        {
            j1 = 1;
        } else
        {
            j1 = -1;
        }
        k1 = Math.abs(i1);
        a(j1, k1, true, r1);
        l1 = m.g + a(n1, m, r1, false);
        if (l1 < 0)
        {
            return 0;
        }
        if (k1 > l1)
        {
            i1 = j1 * l1;
        }
        b.a(-i1);
        m.j = i1;
        return i1;
    }

    private void e(int i1, int j1)
    {
        m.c = b.c() - j1;
        c c1 = m;
        int k1;
        if (c)
        {
            k1 = -1;
        } else
        {
            k1 = 1;
        }
        c1.e = k1;
        m.d = i1;
        m.f = 1;
        m.b = j1;
        m.g = 0x80000000;
    }

    private void f(int i1, int j1)
    {
        m.c = j1 - b.b();
        m.d = i1;
        c c1 = m;
        if (c)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        c1.e = i1;
        m.f = -1;
        m.b = j1;
        m.g = 0x80000000;
    }

    private int g(RecyclerView.r r1)
    {
        int i1 = 0;
        boolean flag;
        if (r1.a != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i1 = b.e();
        }
        return i1;
    }

    private int h(RecyclerView.r r1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        u();
        u u1 = b;
        View view;
        boolean flag;
        if (!q)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!q)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.w.a(r1, u1, view, b(flag), this, q, c);
    }

    private int i(RecyclerView.r r1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        u();
        u u1 = b;
        View view;
        boolean flag;
        if (!q)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!q)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.w.a(r1, u1, view, b(flag), this, q);
    }

    private int j(RecyclerView.r r1)
    {
        boolean flag1 = true;
        if (j() == 0)
        {
            return 0;
        }
        u();
        u u1 = b;
        View view;
        boolean flag;
        if (!q)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = a(flag);
        if (!q)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return android.support.v7.widget.w.b(r1, u1, view, b(flag), this, q);
    }

    private View k(RecyclerView.r r1)
    {
        if (c)
        {
            return m(r1);
        } else
        {
            return n(r1);
        }
    }

    private View l(RecyclerView.r r1)
    {
        if (c)
        {
            return n(r1);
        } else
        {
            return m(r1);
        }
    }

    private View m(RecyclerView.r r1)
    {
        return a(0, j(), r1.a());
    }

    private View n(RecyclerView.r r1)
    {
        return a(j() - 1, -1, r1.a());
    }

    private void s()
    {
        boolean flag = true;
        if (a != 1 && t()) goto _L2; else goto _L1
_L1:
        flag = o;
_L4:
        c = flag;
        return;
_L2:
        if (o)
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean t()
    {
        return android.support.v4.view.w.h(super.i) == 1;
    }

    private void u()
    {
        if (m == null)
        {
            m = new c();
        }
        if (b == null)
        {
            b = android.support.v7.widget.u.a(this, a);
        }
    }

    private View v()
    {
        int i1;
        if (c)
        {
            i1 = j() - 1;
        } else
        {
            i1 = 0;
        }
        return c(i1);
    }

    private View w()
    {
        int i1;
        if (c)
        {
            i1 = 0;
        } else
        {
            i1 = j() - 1;
        }
        return c(i1);
    }

    public final int a(int i1, RecyclerView.n n1, RecyclerView.r r1)
    {
        if (a == 1)
        {
            return 0;
        } else
        {
            return d(i1, n1, r1);
        }
    }

    public final int a(RecyclerView.r r1)
    {
        return h(r1);
    }

    public final RecyclerView.j a()
    {
        return new RecyclerView.j(-2);
    }

    public final View a(int i1)
    {
        int j1 = j();
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        View view = null;
_L4:
        return view;
_L2:
        View view1;
        int k1 = i1 - a(c(0));
        if (k1 < 0 || k1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        view1 = c(k1);
        view = view1;
        if (a(view1) == i1) goto _L4; else goto _L3
_L3:
        return super.a(i1);
    }

    public final void a(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            f = (SavedState)parcelable;
            g();
        }
    }

    public final void a(RecyclerView.n n1, RecyclerView.r r1)
    {
        Object obj;
        Object obj1;
        int i1;
        int k1;
        int l1;
        int i2;
        if (f != null && f.a())
        {
            d = f.a;
        }
        u();
        m.a = false;
        s();
        obj = g;
        obj.a = -1;
        obj.b = 0x80000000;
        obj.c = false;
        g.c = c ^ p;
        obj1 = g;
        RecyclerView.j j1;
        int j2;
        if (r1.j || d == -1)
        {
            i1 = 0;
        } else
        if (d < 0 || d >= r1.a())
        {
            d = -1;
            e = 0x80000000;
            i1 = 0;
        } else
        {
label0:
            {
                obj1.a = d;
                if (f == null || !f.a())
                {
                    break label0;
                }
                obj1.c = f.c;
                if (((a) (obj1)).c)
                {
                    obj1.b = b.c() - f.b;
                } else
                {
                    obj1.b = b.b() + f.b;
                }
                i1 = 1;
            }
        }
_L8:
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        if (j() == 0)
        {
            break MISSING_BLOCK_LABEL_1694;
        }
        boolean flag;
        if (super.i == null)
        {
            obj = null;
        } else
        {
            obj = super.i.getFocusedChild();
            if (obj == null || super.h.a(((View) (obj))))
            {
                obj = null;
            }
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        j1 = (RecyclerView.j)((View) (obj)).getLayoutParams();
        if (!j1.a.m() && j1.a.c() >= 0 && j1.a.c() < r1.a())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L4; else goto _L5
_L5:
        k1 = ((a) (obj1)).d.b.a();
        if (k1 >= 0)
        {
            ((a) (obj1)).a(((View) (obj)));
        } else
        {
            obj1.a = a(((View) (obj)));
            if (((a) (obj1)).c)
            {
                i1 = ((a) (obj1)).d.b.c() - k1 - ((a) (obj1)).d.b.b(((View) (obj)));
                obj1.b = ((a) (obj1)).d.b.c() - i1;
                if (i1 > 0)
                {
                    k1 = ((a) (obj1)).d.b.c(((View) (obj)));
                    l1 = ((a) (obj1)).b;
                    i2 = ((a) (obj1)).d.b.b();
                    k1 = l1 - k1 - (Math.min(((a) (obj1)).d.b.a(((View) (obj))) - i2, 0) + i2);
                    if (k1 < 0)
                    {
                        l1 = ((a) (obj1)).b;
                        obj1.b = Math.min(i1, -k1) + l1;
                    }
                }
            } else
            {
                l1 = ((a) (obj1)).d.b.a(((View) (obj)));
                i1 = l1 - ((a) (obj1)).d.b.b();
                obj1.b = l1;
                if (i1 > 0)
                {
                    i2 = ((a) (obj1)).d.b.c(((View) (obj)));
                    int k2 = ((a) (obj1)).d.b.c();
                    int i3 = ((a) (obj1)).d.b.b(((View) (obj)));
                    k1 = ((a) (obj1)).d.b.c() - Math.min(0, k2 - k1 - i3) - (l1 + i2);
                    if (k1 < 0)
                    {
                        obj1.b = ((a) (obj1)).b - Math.min(i1, -k1);
                    }
                }
            }
        }
        i1 = 1;
_L11:
        if (i1 == 0)
        {
            ((a) (obj1)).a();
            if (p)
            {
                i1 = r1.a() - 1;
            } else
            {
                i1 = 0;
            }
            obj1.a = i1;
        }
_L2:
        i1 = g(r1);
        if (m.j >= 0)
        {
            k1 = 0;
        } else
        {
            k1 = i1;
            i1 = 0;
        }
        l1 = k1 + b.b();
        i2 = i1 + b.f();
        i1 = i2;
        k1 = l1;
        if (r1.j)
        {
            i1 = i2;
            k1 = l1;
            if (d != -1)
            {
                i1 = i2;
                k1 = l1;
                if (e != 0x80000000)
                {
                    obj = a(d);
                    i1 = i2;
                    k1 = l1;
                    if (obj != null)
                    {
                        if (c)
                        {
                            i1 = b.c() - b.b(((View) (obj))) - e;
                        } else
                        {
                            i1 = b.a(((View) (obj)));
                            k1 = b.b();
                            i1 = e - (i1 - k1);
                        }
                        if (i1 > 0)
                        {
                            k1 = l1 + i1;
                            i1 = i2;
                        } else
                        {
                            i1 = i2 - i1;
                            k1 = l1;
                        }
                    }
                }
            }
        }
        a(n1);
        m.i = r1.j;
        if (g.c)
        {
            b(g);
            m.h = k1;
            a(n1, m, r1, false);
            i2 = m.b;
            j2 = m.d;
            k1 = i1;
            if (m.c > 0)
            {
                k1 = i1 + m.c;
            }
            a(g);
            m.h = k1;
            obj = m;
            obj.d = ((c) (obj)).d + m.e;
            a(n1, m, r1, false);
            l1 = m.b;
            int l2;
            int j3;
            int k3;
            int l3;
            boolean flag1;
            if (m.c > 0)
            {
                i1 = m.c;
                f(j2, i2);
                m.h = i1;
                a(n1, m, r1, false);
                i1 = m.b;
            } else
            {
                i1 = i2;
            }
            k1 = i1;
            i1 = l1;
        } else
        {
            a(g);
            m.h = i1;
            a(n1, m, r1, false);
            l1 = m.b;
            l2 = m.d;
            i1 = k1;
            if (m.c > 0)
            {
                i1 = k1 + m.c;
            }
            b(g);
            m.h = i1;
            obj = m;
            obj.d = ((c) (obj)).d + m.e;
            a(n1, m, r1, false);
            i2 = m.b;
            i1 = l1;
            k1 = i2;
            if (m.c > 0)
            {
                i1 = m.c;
                e(l2, l1);
                m.h = i1;
                a(n1, m, r1, false);
                i1 = m.b;
                k1 = i2;
            }
        }
        if (j() > 0)
        {
            if (c ^ p)
            {
                l1 = a(i1, n1, r1, true);
                i2 = k1 + l1;
                k1 = b(i2, n1, r1, false);
                i2 += k1;
                l1 = i1 + l1 + k1;
            } else
            {
                l1 = b(k1, n1, r1, true);
                i1 += l1;
                l2 = a(i1, n1, r1, false);
                i2 = k1 + l1 + l2;
                l1 = i1 + l2;
            }
        } else
        {
            l1 = i1;
            i2 = k1;
        }
        if (r1.l && j() != 0 && !r1.j && f())
        {
            i1 = 0;
            k1 = 0;
            obj = n1.d;
            k3 = ((List) (obj)).size();
            l3 = a(c(0));
            l2 = 0;
            while (l2 < k3) 
            {
                obj1 = (RecyclerView.u)((List) (obj)).get(l2);
                if (!((RecyclerView.u) (obj1)).m())
                {
                    if (((RecyclerView.u) (obj1)).c() < l3)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1 != c)
                    {
                        j3 = -1;
                    } else
                    {
                        j3 = 1;
                    }
                    if (j3 == -1)
                    {
                        j3 = b.c(((RecyclerView.u) (obj1)).a) + i1;
                        i1 = k1;
                        k1 = j3;
                    } else
                    {
                        j3 = b.c(((RecyclerView.u) (obj1)).a) + k1;
                        k1 = i1;
                        i1 = j3;
                    }
                } else
                {
                    j3 = i1;
                    i1 = k1;
                    k1 = j3;
                }
                j3 = k1;
                l2++;
                k1 = i1;
                i1 = j3;
            }
            m.k = ((List) (obj));
            if (i1 > 0)
            {
                f(a(v()), i2);
                m.h = i1;
                m.c = 0;
                m.a(null);
                a(n1, m, r1, false);
            }
            if (k1 > 0)
            {
                e(a(w()), l1);
                m.h = k1;
                m.c = 0;
                m.a(null);
                a(n1, m, r1, false);
            }
            m.k = null;
        }
        if (!r1.j)
        {
            d = -1;
            e = 0x80000000;
            n1 = b;
            n1.b = n1.e();
        }
        n = p;
        f = null;
        return;
        if (e != 0x80000000)
        {
            break MISSING_BLOCK_LABEL_1144;
        }
        obj = a(d);
        if (obj == null) goto _L7; else goto _L6
_L6:
        if (b.c(((View) (obj))) > b.e())
        {
            ((a) (obj1)).a();
        } else
        if (b.a(((View) (obj))) - b.b() < 0)
        {
            obj1.b = b.b();
            obj1.c = false;
        } else
        {
label1:
            {
                if (b.c() - b.b(((View) (obj))) >= 0)
                {
                    break label1;
                }
                obj1.b = b.c();
                obj1.c = true;
            }
        }
_L10:
        i1 = 1;
          goto _L8
        if (((a) (obj1)).c)
        {
            i1 = b.b(((View) (obj))) + b.a();
        } else
        {
            i1 = b.a(((View) (obj)));
        }
        obj1.b = i1;
_L9:
        i1 = 1;
          goto _L8
_L7:
        if (j() > 0)
        {
            i1 = a(c(0));
            if (d < i1)
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
            obj1.c = flag;
        }
        ((a) (obj1)).a();
          goto _L9
        obj1.c = c;
        if (c)
        {
            obj1.b = b.c() - e;
        } else
        {
            obj1.b = b.b() + e;
        }
          goto _L10
_L4:
        if (n != p)
        {
            break MISSING_BLOCK_LABEL_1694;
        }
        if (((a) (obj1)).c)
        {
            obj = k(r1);
        } else
        {
            obj = l(r1);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1694;
        }
        ((a) (obj1)).a(((View) (obj)));
        if (!r1.j && f())
        {
            if (b.a(((View) (obj))) >= b.c() || b.b(((View) (obj))) < b.b())
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                if (((a) (obj1)).c)
                {
                    i1 = b.c();
                } else
                {
                    i1 = b.b();
                }
                obj1.b = i1;
            }
        }
        i1 = 1;
          goto _L11
        i1 = 0;
          goto _L11
    }

    public final void a(RecyclerView recyclerview)
    {
        recyclerview = new r(recyclerview.getContext()) {

            final LinearLayoutManager a;

            public final PointF a(int i1)
            {
                boolean flag = true;
                boolean flag1 = false;
                LinearLayoutManager linearlayoutmanager = a;
                if (linearlayoutmanager.j() == 0)
                {
                    return null;
                }
                if (i1 < android.support.v7.widget.LinearLayoutManager.a(linearlayoutmanager.c(0)))
                {
                    flag1 = true;
                }
                i1 = ((flag) ? 1 : 0);
                if (flag1 != linearlayoutmanager.c)
                {
                    i1 = -1;
                }
                if (linearlayoutmanager.a == 0)
                {
                    return new PointF(i1, 0.0F);
                } else
                {
                    return new PointF(0.0F, i1);
                }
            }

            
            {
                a = LinearLayoutManager.this;
                super(context);
            }
        };
        recyclerview.g = 0;
        a(((RecyclerView.q) (recyclerview)));
    }

    public final void a(RecyclerView recyclerview, RecyclerView.n n1)
    {
        super.a(recyclerview, n1);
        if (r)
        {
            c(n1);
            n1.a();
        }
    }

    public final void a(AccessibilityEvent accessibilityevent)
    {
        int i1 = -1;
        super.a(accessibilityevent);
        if (j() > 0)
        {
            accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
            accessibilityevent.b(e());
            View view = a(j() - 1, -1, false);
            if (view != null)
            {
                i1 = a(view);
            }
            accessibilityevent.c(i1);
        }
    }

    public final void a(String s1)
    {
        if (f == null)
        {
            super.a(s1);
        }
    }

    public final int b(int i1, RecyclerView.n n1, RecyclerView.r r1)
    {
        if (a == 0)
        {
            return 0;
        } else
        {
            return d(i1, n1, r1);
        }
    }

    public final int b(RecyclerView.r r1)
    {
        return h(r1);
    }

    public final Parcelable b()
    {
        if (f != null)
        {
            return new SavedState(f);
        }
        SavedState savedstate = new SavedState();
        if (j() > 0)
        {
            u();
            boolean flag = n ^ c;
            savedstate.c = flag;
            if (flag)
            {
                View view = w();
                savedstate.b = b.c() - b.b(view);
                savedstate.a = a(view);
                return savedstate;
            } else
            {
                View view1 = v();
                savedstate.a = a(view1);
                savedstate.b = b.a(view1) - b.b();
                return savedstate;
            }
        } else
        {
            savedstate.a = -1;
            return savedstate;
        }
    }

    public final void b(int i1)
    {
        d = i1;
        e = 0x80000000;
        if (f != null)
        {
            f.a = -1;
        }
        g();
    }

    public final int c(RecyclerView.r r1)
    {
        return i(r1);
    }

    public final View c(int i1, RecyclerView.n n1, RecyclerView.r r1)
    {
        s();
        if (j() != 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        i1;
        JVM INSTR lookupswitch 6: default 72
    //                   1: 180
    //                   2: 185
    //                   17: 228
    //                   33: 190
    //                   66: 246
    //                   130: 209;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        i1 = 0x80000000;
_L10:
        if (i1 != 0x80000000)
        {
            u();
            View view;
            if (i1 == -1)
            {
                view = l(r1);
            } else
            {
                view = k(r1);
            }
            if (view != null)
            {
                u();
                a(i1, (int)(0.33F * (float)b.e()), false, r1);
                m.g = 0x80000000;
                m.a = false;
                a(n1, m, r1, true);
                if (i1 == -1)
                {
                    n1 = v();
                } else
                {
                    n1 = w();
                }
                if (n1 != view && n1.isFocusable())
                {
                    return n1;
                }
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        i1 = -1;
          goto _L10
_L5:
        i1 = 1;
          goto _L10
_L7:
        if (a == 1)
        {
            i1 = -1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
_L9:
        if (a == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
_L6:
        if (a == 0)
        {
            i1 = -1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
_L8:
        if (a == 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
    }

    public final boolean c()
    {
        return a == 0;
    }

    public final int d(RecyclerView.r r1)
    {
        return i(r1);
    }

    public final boolean d()
    {
        return a == 1;
    }

    public final int e()
    {
        View view = a(0, j(), false);
        if (view == null)
        {
            return -1;
        } else
        {
            return a(view);
        }
    }

    public final int e(RecyclerView.r r1)
    {
        return j(r1);
    }

    public final int f(RecyclerView.r r1)
    {
        return j(r1);
    }

    public final boolean f()
    {
        return f == null && n == p;
    }
}
