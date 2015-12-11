// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

public final class kn extends gs
    implements dn
{

    View c;
    kt d;
    ko e;
    kq f;
    final cm g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final SparseBooleanArray m;
    private View n;
    private kp o;

    public final View a(gv gv1, View view, ViewGroup viewgroup)
    {
        View view1 = gv1.getActionView();
        if (view1 == null || gv1.h())
        {
            view1 = super.a(gv1, view, viewgroup);
        }
        byte byte0;
        if (gv1.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        gv1 = (ActionMenuView)viewgroup;
        view = view1.getLayoutParams();
        if (!gv1.checkLayoutParams(view))
        {
            view1.setLayoutParams(gv1.a(view));
        }
        return view1;
    }

    public final void a(Context context, gt gt1)
    {
        boolean flag;
        flag = true;
        super.a(context, gt1);
        gt1 = context.getResources();
        context = new gn(context);
        break MISSING_BLOCK_LABEL_23;
        int i1;
        if (android.os.Build.VERSION.SDK_INT < 19 && ek.a(ViewConfiguration.get(((gn) (context)).a)))
        {
            flag = false;
        }
        h = flag;
        i = ((gn) (context)).a.getResources().getDisplayMetrics().widthPixels / 2;
        k = ((gn) (context)).a.getResources().getInteger(0x7f0e0008);
        i1 = i;
        if (h)
        {
            if (c == null)
            {
                c = new kr(this, null);
                int j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                c.measure(j1, j1);
            }
            i1 -= c.getMeasuredWidth();
        } else
        {
            c = null;
        }
        j = i1;
        l = (int)(56F * gt1.getDisplayMetrics().density);
        n = null;
        return;
    }

    public final void a(gt gt1, boolean flag)
    {
        c();
        boolean flag2;
        if (e != null)
        {
            e.c();
            boolean flag1 = true;
        } else
        {
            flag2 = false;
        }
        super.a(gt1, flag);
    }

    public final void a(gv gv1, ha ha1)
    {
        ha1.a(gv1, 0);
        gv1 = (ActionMenuItemView)ha1;
        gv1.a = null;
        if (o == null)
        {
            o = new kp(this);
        }
        gv1.b = o;
    }

    public final void a(boolean flag)
    {
        throw new NullPointerException();
    }

    public final boolean a()
    {
        ArrayList arraylist = b.d();
        int k5 = arraylist.size();
        int j5 = k;
        int j4 = j;
        int l5 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i1 = 0;
        int k1 = 0;
        int j1 = 0;
        int l1 = 0;
        while (l1 < k5) 
        {
            gv gv1 = (gv)arraylist.get(l1);
            int k3;
            if (gv1.g())
            {
                int j3 = k1;
                k1 = i1 + 1;
                i1 = j1;
                j1 = j3;
            } else
            if (gv1.f())
            {
                int l3 = i1;
                i1 = j1;
                j1 = k1 + 1;
                k1 = l3;
            } else
            {
                boolean flag = true;
                j1 = k1;
                k1 = i1;
                i1 = ((flag) ? 1 : 0);
            }
            k3 = l1 + 1;
            l1 = k1;
            k1 = j1;
            j1 = i1;
            i1 = l1;
            l1 = k3;
        }
        SparseBooleanArray sparsebooleanarray;
        int i4;
        if (h && (j1 != 0 || i1 + k1 > j5))
        {
            j1 = j5 - 1;
        } else
        {
            j1 = j5;
        }
        sparsebooleanarray = m;
        sparsebooleanarray.clear();
        i4 = 0;
        k1 = j4;
        i1 = j1 - i1;
        j1 = 0;
        while (i4 < k5) 
        {
            gv gv2 = (gv)arraylist.get(i4);
            int j2;
            if (gv2.g())
            {
                View view = a(gv2, n, null);
                if (n == null)
                {
                    n = view;
                }
                view.measure(l5, l5);
                int i2 = view.getMeasuredWidth();
                if (j1 == 0)
                {
                    j1 = i2;
                }
                int k4 = gv2.getGroupId();
                if (k4 != 0)
                {
                    sparsebooleanarray.put(k4, true);
                }
                gv2.c(true);
                i2 = k1 - i2;
                k1 = i1;
                i1 = i2;
            } else
            if (gv2.f())
            {
                j5 = gv2.getGroupId();
                boolean flag2 = sparsebooleanarray.get(j5);
                boolean flag1;
                if ((i1 > 0 || flag2) && k1 > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    View view1 = a(gv2, n, null);
                    if (n == null)
                    {
                        n = view1;
                    }
                    view1.measure(l5, l5);
                    int l4 = view1.getMeasuredWidth();
                    int k2 = k1 - l4;
                    if (j1 == 0)
                    {
                        j1 = l4;
                    }
                    if (k2 + j1 > 0)
                    {
                        k1 = 1;
                    } else
                    {
                        k1 = 0;
                    }
                    flag1 = k1 & flag1;
                    k1 = k2;
                }
                if (flag1 && j5 != 0)
                {
                    sparsebooleanarray.put(j5, true);
                } else
                if (flag2)
                {
                    sparsebooleanarray.put(j5, false);
                    int i5 = 0;
                    while (i5 < i4) 
                    {
                        gv gv3 = (gv)arraylist.get(i5);
                        int l2 = i1;
                        if (gv3.getGroupId() == j5)
                        {
                            l2 = i1;
                            if (gv3.e())
                            {
                                l2 = i1 + 1;
                            }
                            gv3.c(false);
                        }
                        i5++;
                        i1 = l2;
                    }
                }
                k2 = i1;
                if (flag1)
                {
                    k2 = i1 - 1;
                }
                gv2.c(flag1);
                i1 = k1;
                k1 = k2;
            } else
            {
                gv2.c(false);
                int i3 = k1;
                k1 = i1;
                i1 = i3;
            }
            i4++;
            j2 = k1;
            k1 = i1;
            i1 = j2;
        }
        return true;
    }

    public final boolean a(hb hb1)
    {
        if (!hb1.hasVisibleItems())
        {
            return false;
        }
        Object obj;
        for (obj = hb1; ((hb) (obj)).h != b; obj = (hb)((hb) (obj)).h) { }
        ((hb) (obj)).getItem();
        obj = null;
        if (true)
        {
            if (c == null)
            {
                return false;
            }
            obj = c;
        }
        hb1.getItem().getItemId();
        e = new ko(this, a, hb1);
        e.b = ((View) (obj));
        if (!e.b())
        {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        } else
        {
            super.a(hb1);
            return true;
        }
    }

    public final boolean b()
    {
        if (h)
        {
            gt gt1;
            boolean flag;
            if (d != null && d.d())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                gt1 = b;
            }
        }
        return false;
    }

    public final boolean c()
    {
        Object obj = f;
        obj = d;
        if (obj != null)
        {
            ((gw) (obj)).c();
            return true;
        } else
        {
            return false;
        }
    }
}
