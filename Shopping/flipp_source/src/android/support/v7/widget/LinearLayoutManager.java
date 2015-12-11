// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.ag;
import android.support.v4.view.ap;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            au, y, af, aa, 
//            z, bf, av, bi, 
//            bl, x, RecyclerView, bd, 
//            az, d

public class LinearLayoutManager extends au
{

    private aa a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    int i;
    af j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final y o;

    public LinearLayoutManager()
    {
        this((byte)0);
    }

    private LinearLayoutManager(byte byte0)
    {
        c = false;
        k = false;
        d = false;
        e = true;
        l = -1;
        m = 0x80000000;
        n = null;
        o = new y(this);
        a(((String) (null)));
        if (1 != i)
        {
            i = 1;
            j = null;
            h();
        }
        a(((String) (null)));
        if (c)
        {
            c = false;
            h();
        }
    }

    private int a(int i1, az az1, bf bf1, boolean flag)
    {
        int j1 = j.c() - i1;
        if (j1 > 0)
        {
            int k1 = -d(-j1, az1, bf1);
            j1 = k1;
            if (flag)
            {
                i1 = j.c() - (i1 + k1);
                j1 = k1;
                if (i1 > 0)
                {
                    j.a(i1);
                    j1 = k1 + i1;
                }
            }
            return j1;
        } else
        {
            return 0;
        }
    }

    private int a(az az1, aa aa1, bf bf1, boolean flag)
    {
        int k1 = aa1.c;
        if (aa1.g != 0x80000000)
        {
            if (aa1.c < 0)
            {
                aa1.g = aa1.g + aa1.c;
            }
            a(az1, aa1);
        }
        int i1 = aa1.c + aa1.h;
        z z1 = new z();
label0:
        do
        {
            int j1;
            do
            {
label1:
                {
                    if (i1 <= 0 || !aa1.a(bf1))
                    {
                        break label0;
                    }
                    z1.a = 0;
                    z1.b = false;
                    z1.c = false;
                    z1.d = false;
                    a(az1, bf1, aa1, z1);
                    if (z1.b)
                    {
                        break label0;
                    }
                    aa1.b = aa1.b + z1.a * aa1.f;
                    if (z1.c && a.j == null)
                    {
                        j1 = i1;
                        if (bf1.i)
                        {
                            break label1;
                        }
                    }
                    aa1.c = aa1.c - z1.a;
                    j1 = i1 - z1.a;
                }
                if (aa1.g != 0x80000000)
                {
                    aa1.g = aa1.g + z1.a;
                    if (aa1.c < 0)
                    {
                        aa1.g = aa1.g + aa1.c;
                    }
                    a(az1, aa1);
                }
                i1 = j1;
            } while (!flag);
            i1 = j1;
        } while (!z1.d);
        return k1 - aa1.c;
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
                s();
                int i2 = j.b();
                int j2 = j.c();
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
                        if (((av)view2.getLayoutParams()).c.m())
                        {
                            if (view1 == null)
                            {
                                view1 = view2;
                            }
                        } else
                        {
                            if (j.a(view2) < j2)
                            {
                                view3 = view2;
                                if (j.b(view2) >= i2)
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

    private void a(int i1, int j1, boolean flag, bf bf1)
    {
        byte byte0 = -1;
        boolean flag1 = true;
        a.h = g(bf1);
        a.f = i1;
        if (i1 == 1)
        {
            bf1 = a;
            bf1.h = ((aa) (bf1)).h + j.f();
            bf1 = u();
            aa aa1 = a;
            if (k)
            {
                i1 = byte0;
            } else
            {
                i1 = 1;
            }
            aa1.e = i1;
            a.d = a(((View) (bf1))) + a.e;
            a.b = j.b(bf1);
            i1 = j.b(bf1) - j.c();
        } else
        {
            bf1 = t();
            aa aa2 = a;
            aa2.h = aa2.h + j.b();
            aa2 = a;
            if (k)
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = -1;
            }
            aa2.e = i1;
            a.d = a(((View) (bf1))) + a.e;
            a.b = j.a(bf1);
            i1 = -j.a(bf1) + j.b();
        }
        a.c = j1;
        if (flag)
        {
            bf1 = a;
            bf1.c = ((aa) (bf1)).c - i1;
        }
        a.g = i1;
    }

    private void a(az az1, int i1, int j1)
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
            a(j1, az1);
            j1--;
        }
        if (true) goto _L1; else goto _L3
_L3:
        while (k1 > j1) 
        {
            a(k1, az1);
            k1--;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(az az1, aa aa1)
    {
        if (aa1.a) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (aa1.f != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        int i1 = aa1.g;
        int j2 = j();
        if (i1 >= 0)
        {
            int l2 = j.d() - i1;
            if (k)
            {
                int j1 = 0;
                while (j1 < j2) 
                {
                    aa1 = c(j1);
                    if (j.a(aa1) < l2)
                    {
                        a(az1, 0, j1);
                        return;
                    }
                    j1++;
                }
            } else
            {
                int k1 = j2 - 1;
                while (k1 >= 0) 
                {
                    aa1 = c(k1);
                    if (j.a(aa1) < l2)
                    {
                        a(az1, j2 - 1, k1);
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
        k2 = aa1.g;
        if (k2 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i3 = j();
        if (!k)
        {
            break; /* Loop/switch isn't completed */
        }
        int l1 = i3 - 1;
        while (l1 >= 0) 
        {
            aa1 = c(l1);
            if (j.b(aa1) > k2)
            {
                a(az1, i3 - 1, l1);
                return;
            }
            l1--;
        }
        if (true) goto _L1; else goto _L4
_L4:
        int i2 = 0;
        while (i2 < i3) 
        {
            aa1 = c(i2);
            if (j.b(aa1) > k2)
            {
                a(az1, 0, i2);
                return;
            }
            i2++;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void a(y y1)
    {
        e(y1.a, y1.b);
    }

    private int b(int i1, az az1, bf bf1, boolean flag)
    {
        int j1 = i1 - j.b();
        if (j1 > 0)
        {
            int k1 = -d(j1, az1, bf1);
            j1 = k1;
            if (flag)
            {
                i1 = (i1 + k1) - j.b();
                j1 = k1;
                if (i1 > 0)
                {
                    j.a(-i1);
                    j1 = k1 - i1;
                }
            }
            return j1;
        } else
        {
            return 0;
        }
    }

    private void b(y y1)
    {
        f(y1.a, y1.b);
    }

    private int d(int i1, az az1, bf bf1)
    {
        if (j() == 0 || i1 == 0)
        {
            return 0;
        }
        a.a = true;
        s();
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
        a(j1, k1, true, bf1);
        l1 = a.g + a(az1, a, bf1, false);
        if (l1 < 0)
        {
            return 0;
        }
        if (k1 > l1)
        {
            i1 = j1 * l1;
        }
        j.a(-i1);
        return i1;
    }

    private void e(int i1, int j1)
    {
        a.c = j.c() - j1;
        aa aa1 = a;
        int k1;
        if (k)
        {
            k1 = -1;
        } else
        {
            k1 = 1;
        }
        aa1.e = k1;
        a.d = i1;
        a.f = 1;
        a.b = j1;
        a.g = 0x80000000;
    }

    private void f(int i1, int j1)
    {
        a.c = j1 - j.b();
        a.d = i1;
        aa aa1 = a;
        if (k)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        aa1.e = i1;
        a.f = -1;
        a.b = j1;
        a.g = 0x80000000;
    }

    private int g(bf bf1)
    {
        int i1 = 0;
        boolean flag;
        if (bf1.a != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i1 = j.e();
        }
        return i1;
    }

    private View g(int i1)
    {
        return a(0, j(), i1);
    }

    private View g(int i1, int j1)
    {
        s();
        int k1 = j.b();
        int l1 = j.c();
        byte byte0;
        if (j1 > i1)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        for (; i1 != j1; i1 += byte0)
        {
            View view = c(i1);
            int i2 = j.a(view);
            int j2 = j.b(view);
            if (i2 < l1 && j2 > k1)
            {
                return view;
            }
        }

        return null;
    }

    private int h(bf bf1)
    {
        if (j() == 0)
        {
            return 0;
        } else
        {
            s();
            return android.support.v7.widget.bl.a(bf1, j, t(), u(), this, e, k);
        }
    }

    private View h(int i1)
    {
        return a(j() - 1, -1, i1);
    }

    private int i(bf bf1)
    {
        if (j() == 0)
        {
            return 0;
        } else
        {
            s();
            return android.support.v7.widget.bl.a(bf1, j, t(), u(), this, e);
        }
    }

    private int j(bf bf1)
    {
        if (j() == 0)
        {
            return 0;
        } else
        {
            s();
            return bl.b(bf1, j, t(), u(), this, e);
        }
    }

    private View k(bf bf1)
    {
        if (k)
        {
            return g(bf1.a());
        } else
        {
            return h(bf1.a());
        }
    }

    private View l(bf bf1)
    {
        if (k)
        {
            return h(bf1.a());
        } else
        {
            return g(bf1.a());
        }
    }

    private void r()
    {
        boolean flag = true;
        if (i != 1 && g()) goto _L2; else goto _L1
_L1:
        flag = c;
_L4:
        k = flag;
        return;
_L2:
        if (c)
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void s()
    {
        if (a == null)
        {
            a = new aa();
        }
        if (j == null)
        {
            j = android.support.v7.widget.af.a(this, i);
        }
    }

    private View t()
    {
        int i1;
        if (k)
        {
            i1 = j() - 1;
        } else
        {
            i1 = 0;
        }
        return c(i1);
    }

    private View u()
    {
        int i1;
        if (k)
        {
            i1 = 0;
        } else
        {
            i1 = j() - 1;
        }
        return c(i1);
    }

    public final int a(int i1, az az1, bf bf1)
    {
        if (i == 1)
        {
            return 0;
        } else
        {
            return d(i1, az1, bf1);
        }
    }

    public final int a(bf bf1)
    {
        return h(bf1);
    }

    public final View a(int i1)
    {
        int j1 = j();
        if (j1 != 0)
        {
            if ((i1 -= a(c(0))) >= 0 && i1 < j1)
            {
                return c(i1);
            }
        }
        return null;
    }

    public final void a(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            n = (SavedState)parcelable;
            h();
        }
    }

    public final void a(RecyclerView recyclerview, int i1)
    {
        recyclerview = new x(this, recyclerview.getContext());
        recyclerview.g = i1;
        a(((bd) (recyclerview)));
    }

    public final void a(RecyclerView recyclerview, az az1)
    {
        super.a(recyclerview, az1);
        if (f)
        {
            c(az1);
            az1.a();
        }
    }

    void a(az az1, bf bf1, aa aa1, z z1)
    {
        az1 = aa1.a(az1);
        if (az1 == null)
        {
            z1.b = true;
            return;
        }
        bf1 = (av)az1.getLayoutParams();
        int i1;
        int j1;
        int k1;
        int l1;
        if (aa1.j == null)
        {
            boolean flag2 = k;
            av av1;
            Rect rect;
            boolean flag;
            if (aa1.f == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag2 == flag)
            {
                super.a(az1, -1, false);
            } else
            {
                super.a(az1, 0, false);
            }
        } else
        {
            boolean flag3 = k;
            boolean flag1;
            if (aa1.f == -1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag3 == flag1)
            {
                super.a(az1, -1, true);
            } else
            {
                super.a(az1, 0, true);
            }
        }
        av1 = (av)az1.getLayoutParams();
        rect = super.q.d(az1);
        i1 = rect.left;
        j1 = rect.right;
        k1 = rect.top;
        l1 = rect.bottom;
        az1.measure(android.support.v7.widget.au.a(k(), i1 + j1 + 0 + (m() + o() + av1.leftMargin + av1.rightMargin), av1.width, e()), android.support.v7.widget.au.a(l(), l1 + k1 + 0 + (n() + p() + av1.topMargin + av1.bottomMargin), av1.height, f()));
        z1.a = j.c(az1);
        if (i == 1)
        {
            if (g())
            {
                i1 = k() - o();
                j1 = i1 - j.d(az1);
            } else
            {
                j1 = m();
                i1 = j.d(az1) + j1;
            }
            if (aa1.f == -1)
            {
                k1 = aa1.b;
                l1 = aa1.b - z1.a;
            } else
            {
                l1 = aa1.b;
                k1 = aa1.b;
                int i2 = z1.a;
                k1 += i2;
            }
        } else
        {
            l1 = n();
            k1 = j.d(az1) + l1;
            if (aa1.f == -1)
            {
                i1 = aa1.b;
                j1 = aa1.b - z1.a;
            } else
            {
                j1 = aa1.b;
                i1 = aa1.b + z1.a;
            }
        }
        a(((View) (az1)), j1 + ((av) (bf1)).leftMargin, l1 + ((av) (bf1)).topMargin, i1 - ((av) (bf1)).rightMargin, k1 - ((av) (bf1)).bottomMargin);
        if (((av) (bf1)).c.m() || ((av) (bf1)).c.k())
        {
            z1.c = true;
        }
        z1.d = az1.isFocusable();
    }

    void a(bf bf1, y y1)
    {
    }

    public final void a(AccessibilityEvent accessibilityevent)
    {
        byte byte0 = -1;
        super.a(accessibilityevent);
        if (j() > 0)
        {
            accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
            View view = g(0, j());
            int i1;
            if (view == null)
            {
                i1 = -1;
            } else
            {
                i1 = a(view);
            }
            accessibilityevent.b(i1);
            view = g(j() - 1, -1);
            if (view == null)
            {
                i1 = byte0;
            } else
            {
                i1 = a(view);
            }
            accessibilityevent.c(i1);
        }
    }

    public final void a(String s1)
    {
        if (n == null)
        {
            super.a(s1);
        }
    }

    public final int b(int i1, az az1, bf bf1)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            return d(i1, az1, bf1);
        }
    }

    public final int b(bf bf1)
    {
        return h(bf1);
    }

    public av b()
    {
        return new av(-2, -2);
    }

    public final void b(int i1)
    {
        l = i1;
        m = 0x80000000;
        if (n != null)
        {
            n.a = -1;
        }
        h();
    }

    public final int c(bf bf1)
    {
        return i(bf1);
    }

    public final View c(int i1, az az1, bf bf1)
    {
        r();
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
            s();
            View view;
            if (i1 == -1)
            {
                view = l(bf1);
            } else
            {
                view = k(bf1);
            }
            if (view != null)
            {
                s();
                a(i1, (int)(0.33F * (float)j.e()), false, bf1);
                a.g = 0x80000000;
                a.a = false;
                a(az1, a, bf1, true);
                if (i1 == -1)
                {
                    az1 = t();
                } else
                {
                    az1 = u();
                }
                if (az1 != view && az1.isFocusable())
                {
                    return az1;
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
        if (i == 1)
        {
            i1 = -1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
_L9:
        if (i == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
_L6:
        if (i == 0)
        {
            i1 = -1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
_L8:
        if (i == 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0x80000000;
        }
          goto _L10
    }

    public void c(az az1, bf bf1)
    {
        Object obj;
        y y1;
        int i1;
        int j1;
        int k1;
        int k2;
        boolean flag;
        if (n != null && n.a())
        {
            l = n.a;
        }
        s();
        a.a = false;
        r();
        obj = o;
        obj.a = -1;
        obj.b = 0x80000000;
        obj.c = false;
        o.c = k ^ d;
        y1 = o;
        av av1;
        if (bf1.i || l == -1)
        {
            i1 = 0;
        } else
        if (l < 0 || l >= bf1.a())
        {
            l = -1;
            m = 0x80000000;
            i1 = 0;
        } else
        {
label0:
            {
                y1.a = l;
                if (n == null || !n.a())
                {
                    break label0;
                }
                y1.c = n.c;
                if (y1.c)
                {
                    y1.b = j.c() - n.b;
                } else
                {
                    y1.b = j.b() + n.b;
                }
                i1 = 1;
            }
        }
_L8:
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        if (j() == 0)
        {
            break MISSING_BLOCK_LABEL_1333;
        }
        if (super.q == null)
        {
            obj = null;
        } else
        {
            obj = super.q.getFocusedChild();
            if (obj == null || super.p.c.contains(obj))
            {
                obj = null;
            }
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        av1 = (av)((View) (obj)).getLayoutParams();
        if (!av1.c.m() && av1.c.c() >= 0 && av1.c.c() < bf1.a())
        {
            y1.a(((View) (obj)));
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L4; else goto _L5
_L5:
        i1 = 1;
_L11:
        if (i1 == 0)
        {
            y1.a();
            if (d)
            {
                i1 = bf1.a() - 1;
            } else
            {
                i1 = 0;
            }
            y1.a = i1;
        }
_L2:
        i1 = g(bf1);
        if (bf1.a < o.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag == k)
        {
            k1 = 0;
            j1 = i1;
        } else
        {
            j1 = 0;
            k1 = i1;
        }
        k1 += j.b();
        k2 = j1 + j.f();
        i1 = k2;
        j1 = k1;
        if (bf1.i)
        {
            i1 = k2;
            j1 = k1;
            if (l != -1)
            {
                i1 = k2;
                j1 = k1;
                if (m != 0x80000000)
                {
                    obj = a(l);
                    i1 = k2;
                    j1 = k1;
                    if (obj != null)
                    {
                        if (k)
                        {
                            i1 = j.c() - j.b(((View) (obj))) - m;
                        } else
                        {
                            i1 = j.a(((View) (obj)));
                            j1 = j.b();
                            i1 = m - (i1 - j1);
                        }
                        if (i1 > 0)
                        {
                            j1 = k1 + i1;
                            i1 = k2;
                        } else
                        {
                            i1 = k2 - i1;
                            j1 = k1;
                        }
                    }
                }
            }
        }
        a(bf1, o);
        a(az1);
        a.i = bf1.i;
        if (o.c)
        {
            b(o);
            a.h = j1;
            a(az1, a, bf1, false);
            k1 = a.b;
            j1 = i1;
            if (a.c > 0)
            {
                j1 = i1 + a.c;
            }
            a(o);
            a.h = j1;
            obj = a;
            obj.d = ((aa) (obj)).d + a.e;
            a(az1, a, bf1, false);
            i1 = a.b;
            j1 = k1;
        } else
        {
            a(o);
            a.h = i1;
            a(az1, a, bf1, false);
            int l1 = a.b;
            i1 = j1;
            if (a.c > 0)
            {
                i1 = j1 + a.c;
            }
            b(o);
            a.h = i1;
            aa aa1 = a;
            aa1.d = aa1.d + a.e;
            a(az1, a, bf1, false);
            j1 = a.b;
            i1 = l1;
        }
        if (j() > 0)
        {
            if (k ^ d)
            {
                k1 = a(i1, az1, bf1, true);
                j1 += k1;
                k2 = b(j1, az1, bf1, false);
                j1 += k2;
                i1 = i1 + k1 + k2;
            } else
            {
                int i2 = b(j1, az1, bf1, true);
                i1 += i2;
                int l2 = a(i1, az1, bf1, false);
                j1 = j1 + i2 + l2;
                i1 += l2;
            }
        }
        if (bf1.k && j() != 0 && !bf1.i && c())
        {
            int i3 = 0;
            int j2 = 0;
            List list = az1.d;
            int k3 = list.size();
            int l3 = a(c(0));
            int j3 = 0;
            while (j3 < k3) 
            {
                bi bi1 = (bi)list.get(j3);
                byte byte0;
                boolean flag1;
                if (bi1.c() < l3)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1 != k)
                {
                    byte0 = -1;
                } else
                {
                    byte0 = 1;
                }
                if (byte0 == -1)
                {
                    i3 = j.c(bi1.a) + i3;
                } else
                {
                    j2 = j.c(bi1.a) + j2;
                }
                j3++;
            }
            a.j = list;
            if (i3 > 0)
            {
                f(a(t()), j1);
                a.h = i3;
                a.c = 0;
                aa aa2 = a;
                i3 = aa2.d;
                if (k)
                {
                    j1 = 1;
                } else
                {
                    j1 = -1;
                }
                aa2.d = j1 + i3;
                a(az1, a, bf1, false);
            }
            if (j2 > 0)
            {
                e(a(u()), i1);
                a.h = j2;
                a.c = 0;
                aa2 = a;
                j1 = aa2.d;
                if (k)
                {
                    i1 = -1;
                } else
                {
                    i1 = 1;
                }
                aa2.d = i1 + j1;
                a(az1, a, bf1, false);
            }
            a.j = null;
        }
        if (!bf1.i)
        {
            l = -1;
            m = 0x80000000;
            az1 = j;
            az1.b = az1.e();
        }
        b = d;
        n = null;
        return;
        if (m != 0x80000000)
        {
            break MISSING_BLOCK_LABEL_1085;
        }
        obj = a(l);
        if (obj == null) goto _L7; else goto _L6
_L6:
        if (j.c(((View) (obj))) > j.e())
        {
            y1.a();
        } else
        if (j.a(((View) (obj))) - j.b() < 0)
        {
            y1.b = j.b();
            y1.c = false;
        } else
        {
label1:
            {
                if (j.c() - j.b(((View) (obj))) >= 0)
                {
                    break label1;
                }
                y1.b = j.c();
                y1.c = true;
            }
        }
_L10:
        i1 = 1;
          goto _L8
        if (y1.c)
        {
            i1 = j.b(((View) (obj))) + j.a();
        } else
        {
            i1 = j.a(((View) (obj)));
        }
        y1.b = i1;
_L9:
        i1 = 1;
          goto _L8
_L7:
        if (j() > 0)
        {
            i1 = a(c(0));
            if (l < i1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag == k)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            y1.c = flag;
        }
        y1.a();
          goto _L9
        y1.c = k;
        if (k)
        {
            y1.b = j.c() - m;
        } else
        {
            y1.b = j.b() + m;
        }
          goto _L10
_L4:
        if (b != d)
        {
            break MISSING_BLOCK_LABEL_1333;
        }
        if (y1.c)
        {
            obj = k(bf1);
        } else
        {
            obj = l(bf1);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1333;
        }
        y1.a(((View) (obj)));
        if (!bf1.i && c())
        {
            if (j.a(((View) (obj))) >= j.c() || j.b(((View) (obj))) < j.b())
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                if (y1.c)
                {
                    i1 = j.c();
                } else
                {
                    i1 = j.b();
                }
                y1.b = i1;
            }
        }
        i1 = 1;
          goto _L11
        i1 = 0;
          goto _L11
    }

    public boolean c()
    {
        return n == null && b == d;
    }

    public final int d(bf bf1)
    {
        return i(bf1);
    }

    public final Parcelable d()
    {
        if (n != null)
        {
            return new SavedState(n);
        }
        SavedState savedstate = new SavedState();
        if (j() > 0)
        {
            s();
            boolean flag = b ^ k;
            savedstate.c = flag;
            if (flag)
            {
                View view = u();
                savedstate.b = j.c() - j.b(view);
                savedstate.a = a(view);
                return savedstate;
            } else
            {
                View view1 = t();
                savedstate.a = a(view1);
                savedstate.b = j.a(view1) - j.b();
                return savedstate;
            }
        } else
        {
            savedstate.a = -1;
            return savedstate;
        }
    }

    public final int e(bf bf1)
    {
        return j(bf1);
    }

    public final boolean e()
    {
        return i == 0;
    }

    public final int f(bf bf1)
    {
        return j(bf1);
    }

    public final boolean f()
    {
        return i == 1;
    }

    protected final boolean g()
    {
        return ap.h(super.q) == 1;
    }

    private class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new ab();
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

}
