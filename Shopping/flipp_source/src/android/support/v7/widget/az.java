// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            bi, RecyclerView, bf, an, 
//            a, d, f, aq, 
//            ay, bg, av, bj

public final class az
{

    final ArrayList a = new ArrayList();
    ArrayList b;
    final ArrayList c = new ArrayList();
    final List d;
    int e;
    ay f;
    bg g;
    final RecyclerView h;

    public az(RecyclerView recyclerview)
    {
        h = recyclerview;
        super();
        b = null;
        d = Collections.unmodifiableList(a);
        e = 2;
    }

    private bi a(long l, int i)
    {
        for (int j = a.size() - 1; j >= 0; j--)
        {
            bi bi1 = (bi)a.get(j);
            if (bi1.d != l || bi1.f())
            {
                continue;
            }
            if (i == bi1.e)
            {
                bi1.a(32);
                if (bi1.m() && !h.m.i)
                {
                    bi1.a(2, 14);
                }
                return bi1;
            }
            a.remove(j);
            h.removeDetachedView(bi1.a, false);
            b(bi1.a);
        }

        for (int k = c.size() - 1; k >= 0; k--)
        {
            bi bi2 = (bi)c.get(k);
            if (bi2.d != l)
            {
                continue;
            }
            if (i == bi2.e)
            {
                c.remove(k);
                return bi2;
            }
            c(k);
        }

        return null;
    }

    private void a(ViewGroup viewgroup, boolean flag)
    {
        for (int i = viewgroup.getChildCount() - 1; i >= 0; i--)
        {
            View view = viewgroup.getChildAt(i);
            if (view instanceof ViewGroup)
            {
                a((ViewGroup)view, true);
            }
        }

        if (!flag)
        {
            return;
        }
        if (viewgroup.getVisibility() == 4)
        {
            viewgroup.setVisibility(0);
            viewgroup.setVisibility(4);
            return;
        } else
        {
            int j = viewgroup.getVisibility();
            viewgroup.setVisibility(4);
            viewgroup.setVisibility(j);
            return;
        }
    }

    private void c(bi bi1)
    {
        if (RecyclerView.u(h) != null)
        {
            RecyclerView.u(h);
        }
        if (RecyclerView.g(h) != null)
        {
            RecyclerView.g(h);
        }
        if (h.m != null)
        {
            h.m.a(bi1);
        }
    }

    private bi d(int i)
    {
        boolean flag;
        int k;
label0:
        {
            flag = false;
            if (b != null)
            {
                k = b.size();
                if (k != 0)
                {
                    break label0;
                }
            }
            return null;
        }
        for (int j = 0; j < k; j++)
        {
            bi bi1 = (bi)b.get(j);
            if (!bi1.f() && bi1.c() == i)
            {
                bi1.a(32);
                return bi1;
            }
        }

        if (RecyclerView.g(h).b)
        {
            i = h.b.a(i, 0);
            if (i > 0 && i < RecyclerView.g(h).a())
            {
                long l = RecyclerView.g(h).b(i);
                for (i = ((flag) ? 1 : 0); i < k; i++)
                {
                    bi bi2 = (bi)b.get(i);
                    if (!bi2.f() && bi2.d == l)
                    {
                        bi2.a(32);
                        return bi2;
                    }
                }

            }
        }
        return null;
    }

    private bi e(int i)
    {
        d d1;
        int k;
        boolean flag;
        int l;
        flag = false;
        l = a.size();
        for (int j = 0; j < l; j++)
        {
            bi bi1 = (bi)a.get(j);
            if (!bi1.f() && bi1.c() == i && !bi1.i() && (h.m.i || !bi1.m()))
            {
                bi1.a(32);
                return bi1;
            }
        }

        d1 = h.c;
        l = d1.c.size();
        k = 0;
_L7:
        if (k >= l) goto _L2; else goto _L1
_L1:
        Object obj;
        bi bi2;
        obj = (View)d1.c.get(k);
        bi2 = d1.a.b(((View) (obj)));
        if (bi2.c() != i || bi2.i()) goto _L4; else goto _L3
_L3:
        if (obj != null)
        {
            h.k.c(h.a(((View) (obj))));
        }
        l = c.size();
        k = ((flag) ? 1 : 0);
_L5:
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        obj = (bi)c.get(k);
        if (!((bi) (obj)).i() && ((bi) (obj)).c() == i)
        {
            c.remove(k);
            return ((bi) (obj));
        }
        break MISSING_BLOCK_LABEL_263;
_L4:
        k++;
        continue; /* Loop/switch isn't completed */
_L2:
        obj = null;
          goto _L3
        k++;
          goto _L5
        return null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final int a(int i)
    {
        if (i < 0 || i >= h.m.a())
        {
            throw new IndexOutOfBoundsException((new StringBuilder("invalid position ")).append(i).append(". State item count is ").append(h.m.a()).toString());
        }
        if (!h.m.i)
        {
            return i;
        } else
        {
            return h.b.a(i);
        }
    }

    public final void a()
    {
        a.clear();
        for (int i = c.size() - 1; i >= 0; i--)
        {
            c(i);
        }

        c.clear();
    }

    final void a(bi bi1)
    {
label0:
        {
            int i;
label1:
            {
                boolean flag1 = true;
                boolean flag = false;
                if (bi1.d() || bi1.a.getParent() != null)
                {
                    StringBuilder stringbuilder = (new StringBuilder("Scrapped or attached views may not be recycled. isScrap:")).append(bi1.d()).append(" isAttached:");
                    if (bi1.a.getParent() == null)
                    {
                        flag1 = false;
                    }
                    throw new IllegalArgumentException(stringbuilder.append(flag1).toString());
                }
                if (bi1.n())
                {
                    throw new IllegalArgumentException((new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ")).append(bi1).toString());
                }
                if (bi1.b())
                {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                }
                if (!bi1.p())
                {
                    break label0;
                }
                i = ((flag) ? 1 : 0);
                if (bi1.i())
                {
                    break label1;
                }
                if (!h.m.i)
                {
                    i = ((flag) ? 1 : 0);
                    if (bi1.m())
                    {
                        break label1;
                    }
                }
                i = ((flag) ? 1 : 0);
                if (!bi1.k())
                {
                    if (c.size() == e && !c.isEmpty())
                    {
                        for (i = 0; i < c.size() && !c(i); i++) { }
                    }
                    i = ((flag) ? 1 : 0);
                    if (c.size() < e)
                    {
                        c.add(bi1);
                        i = 1;
                    }
                }
            }
            if (i == 0)
            {
                b().a(bi1);
                c(bi1);
            }
        }
        h.m.a(bi1);
    }

    public final void a(View view)
    {
        bi bi1;
        bi1 = RecyclerView.b(view);
        if (bi1.n())
        {
            h.removeDetachedView(view, false);
        }
        if (!bi1.d()) goto _L2; else goto _L1
_L1:
        bi1.e();
_L4:
        a(bi1);
        return;
_L2:
        if (bi1.f())
        {
            bi1.g();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final ay b()
    {
        if (f == null)
        {
            f = new ay();
        }
        return f;
    }

    public final View b(int i)
    {
        boolean flag1 = true;
        if (i < 0 || i >= h.m.a())
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Invalid item position ")).append(i).append("(").append(i).append("). Item count:").append(h.m.a()).toString());
        }
        Object obj;
        Object obj1;
        View view;
        boolean flag;
        int j;
        int k;
        if (h.m.i)
        {
            obj1 = d(i);
            if (obj1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j = ((flag) ? 1 : 0);
        } else
        {
            obj1 = null;
            j = 0;
        }
        obj = obj1;
        flag = j;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj1 = e(i);
        obj = obj1;
        flag = j;
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        if (((bi) (obj1)).m())
        {
            break MISSING_BLOCK_LABEL_407;
        }
        if (((bi) (obj1)).b < 0 || ((bi) (obj1)).b >= RecyclerView.g(h).a())
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid view holder adapter position")).append(obj1).toString());
        }
        if (!h.m.i && RecyclerView.g(h).a(((bi) (obj1)).b) != ((bi) (obj1)).e)
        {
            flag = false;
        } else
        {
            if (!RecyclerView.g(h).b || ((bi) (obj1)).d == RecyclerView.g(h).b(((bi) (obj1)).b))
            {
                break MISSING_BLOCK_LABEL_407;
            }
            flag = false;
        }
_L4:
        if (!flag)
        {
            ((bi) (obj1)).a(4);
            if (((bi) (obj1)).d())
            {
                h.removeDetachedView(((bi) (obj1)).a, false);
                ((bi) (obj1)).e();
            } else
            if (((bi) (obj1)).f())
            {
                ((bi) (obj1)).g();
            }
            a(((bi) (obj1)));
            obj = null;
            flag = j;
        } else
        {
            flag = true;
            obj = obj1;
        }
_L2:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_1010;
        }
        j = h.b.a(i);
        if (j < 0 || j >= RecyclerView.g(h).a())
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid item position ")).append(i).append("(offset:").append(j).append(").state:").append(h.m.a()).toString());
        }
        break MISSING_BLOCK_LABEL_435;
        flag = true;
          goto _L4
        k = RecyclerView.g(h).a(j);
        if (!RecyclerView.g(h).b) goto _L6; else goto _L5
_L5:
        obj1 = a(RecyclerView.g(h).b(j), k);
        obj = obj1;
        if (obj1 == null) goto _L6; else goto _L7
_L7:
        obj1.b = j;
        flag = true;
_L8:
        obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (g != null)
            {
                view = g.a();
                obj = obj1;
                if (view != null)
                {
                    obj1 = h.a(view);
                    if (obj1 == null)
                    {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    }
                    obj = obj1;
                    if (((bi) (obj1)).b())
                    {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            obj = b();
            k = RecyclerView.g(h).a(j);
            obj1 = (ArrayList)((ay) (obj)).a.get(k);
            if (obj1 != null && !((ArrayList) (obj1)).isEmpty())
            {
                k = ((ArrayList) (obj1)).size() - 1;
                obj = (bi)((ArrayList) (obj1)).get(k);
                ((ArrayList) (obj1)).remove(k);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((bi) (obj)).o();
                if (RecyclerView.i() && (((bi) (obj)).a instanceof ViewGroup))
                {
                    a((ViewGroup)((bi) (obj)).a, false);
                }
            }
            obj1 = obj;
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = RecyclerView.g(h);
            obj1 = h;
            j = RecyclerView.g(h).a(j);
            obj = ((an) (obj)).a(((ViewGroup) (obj1)), j);
            obj.e = j;
        }
        obj1 = obj;
_L9:
        if (h.m.i && ((bi) (obj1)).l())
        {
            obj1.f = i;
            i = 0;
        } else
        if (!((bi) (obj1)).l() || ((bi) (obj1)).j() || ((bi) (obj1)).i())
        {
            j = h.b.a(i);
            RecyclerView.g(h).b(((bi) (obj1)), j);
            obj = ((bi) (obj1)).a;
            if (RecyclerView.s(h) != null && RecyclerView.s(h).isEnabled())
            {
                if (ap.e(((View) (obj))) == 0)
                {
                    ap.c(((View) (obj)), 1);
                }
                if (!ap.b(((View) (obj))))
                {
                    ap.a(((View) (obj)), RecyclerView.t(h).c);
                }
            }
            if (h.m.i)
            {
                obj1.f = i;
            }
            i = 1;
        } else
        {
            i = 0;
        }
        obj = ((bi) (obj1)).a.getLayoutParams();
        if (obj == null)
        {
            obj = (av)h.generateDefaultLayoutParams();
            ((bi) (obj1)).a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        } else
        if (!h.checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
        {
            obj = (av)h.generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            ((bi) (obj1)).a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        } else
        {
            obj = (av)obj;
        }
        obj.c = ((bi) (obj1));
        if (!flag || i == 0)
        {
            flag1 = false;
        }
        obj.f = flag1;
        return ((bi) (obj1)).a;
_L6:
        obj1 = obj;
          goto _L8
        obj1 = obj;
          goto _L9
    }

    final void b(bi bi1)
    {
        if (!bi1.k() || !RecyclerView.h(h) || b == null)
        {
            a.remove(bi1);
        } else
        {
            b.remove(bi1);
        }
        bi1.j = null;
        bi1.g();
    }

    final void b(View view)
    {
        view = RecyclerView.b(view);
        view.j = null;
        view.g();
        a(view);
    }

    final boolean c(int i)
    {
        bi bi1 = (bi)c.get(i);
        if (bi1.p())
        {
            b().a(bi1);
            c(bi1);
            c.remove(i);
            return true;
        } else
        {
            return false;
        }
    }
}
