// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import aa;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import ap;
import at;
import au;
import cq;
import cr;
import cs;
import ct;
import cu;
import cv;
import java.util.ArrayList;
import p;
import q;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView

public class ActionMenuPresenter extends aa
    implements android.support.v4.view.ActionProvider.SubUiVisibilityListener
{

    public final cv g = new cv(this);
    public int h;
    private View i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private final SparseBooleanArray t = new SparseBooleanArray();
    private View u;
    private cu v;
    private cq w;
    private cs x;
    private cr y;

    public ActionMenuPresenter(Context context)
    {
        super(context, android.support.v7.appcompat.R.layout.abc_action_menu_layout, android.support.v7.appcompat.R.layout.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuitem)
    {
        ViewGroup viewgroup = (ViewGroup)f;
        if (viewgroup != null) goto _L2; else goto _L1
_L1:
        View view = null;
_L6:
        return view;
_L2:
        int i1;
        int j1;
        j1 = viewgroup.getChildCount();
        i1 = 0;
_L7:
        if (i1 >= j1) goto _L4; else goto _L3
_L3:
        View view1;
        view1 = viewgroup.getChildAt(i1);
        if (!(view1 instanceof au))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = view1;
        if (((au)view1).getItemData() == menuitem) goto _L6; else goto _L5
_L5:
        i1++;
          goto _L7
_L4:
        return null;
    }

    public static cq a(ActionMenuPresenter actionmenupresenter, cq cq1)
    {
        actionmenupresenter.w = cq1;
        return cq1;
    }

    public static cs a(ActionMenuPresenter actionmenupresenter, cs cs1)
    {
        actionmenupresenter.x = cs1;
        return cs1;
    }

    public static cu a(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.v;
    }

    public static cu a(ActionMenuPresenter actionmenupresenter, cu cu1)
    {
        actionmenupresenter.v = cu1;
        return cu1;
    }

    public static cs b(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.x;
    }

    public static MenuBuilder c(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.c;
    }

    public static View d(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.i;
    }

    public static at e(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.f;
    }

    public static MenuBuilder f(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.c;
    }

    public static at g(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.f;
    }

    public static cq h(ActionMenuPresenter actionmenupresenter)
    {
        return actionmenupresenter.w;
    }

    public View a(MenuItemImpl menuitemimpl, View view, ViewGroup viewgroup)
    {
        View view1 = menuitemimpl.getActionView();
        if (view1 == null || menuitemimpl.m())
        {
            view1 = super.a(menuitemimpl, view, viewgroup);
        }
        byte byte0;
        if (menuitemimpl.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        menuitemimpl = (ActionMenuView)viewgroup;
        view = view1.getLayoutParams();
        if (!menuitemimpl.checkLayoutParams(view))
        {
            view1.setLayoutParams(menuitemimpl.generateLayoutParams(view));
        }
        return view1;
    }

    public at a(ViewGroup viewgroup)
    {
        viewgroup = super.a(viewgroup);
        ((ActionMenuView)viewgroup).setPresenter(this);
        return viewgroup;
    }

    public void a(int i1, boolean flag)
    {
        l = i1;
        p = flag;
        q = true;
    }

    public void a(Context context, MenuBuilder menubuilder)
    {
        super.a(context, menubuilder);
        menubuilder = context.getResources();
        context = q.a(context);
        if (!k)
        {
            j = context.b();
        }
        if (!q)
        {
            l = context.c();
        }
        if (!o)
        {
            n = context.a();
        }
        int i1 = l;
        if (j)
        {
            if (i == null)
            {
                i = new ct(this, a);
                int j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                i.measure(j1, j1);
            }
            i1 -= i.getMeasuredWidth();
        } else
        {
            i = null;
        }
        m = i1;
        s = (int)(56F * menubuilder.getDisplayMetrics().density);
        u = null;
    }

    public void a(Configuration configuration)
    {
        if (!o)
        {
            n = b.getResources().getInteger(android.support.v7.appcompat.R.integer.abc_max_action_buttons);
        }
        if (c != null)
        {
            c.b(true);
        }
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        e();
        super.a(menubuilder, flag);
    }

    public void a(MenuItemImpl menuitemimpl, au au1)
    {
        au1.initialize(menuitemimpl, 0);
        menuitemimpl = (ActionMenuView)f;
        au1 = (ActionMenuItemView)au1;
        au1.setItemInvoker(menuitemimpl);
        if (y == null)
        {
            y = new cr(this);
        }
        au1.setPopupCallback(y);
    }

    public void a(ActionMenuView actionmenuview)
    {
        f = actionmenuview;
        actionmenuview.initialize(c);
    }

    public void a(boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = false;
        Object obj = (ViewGroup)((View)f).getParent();
        if (obj != null)
        {
            p.a(((ViewGroup) (obj)));
        }
        super.a(flag);
        ((View)f).requestLayout();
        if (c != null)
        {
            obj = c.k();
            int k1 = ((ArrayList) (obj)).size();
            for (int i1 = 0; i1 < k1; i1++)
            {
                ActionProvider actionprovider = ((MenuItemImpl)((ArrayList) (obj)).get(i1)).getSupportActionProvider();
                if (actionprovider != null)
                {
                    actionprovider.setSubUiVisibilityListener(this);
                }
            }

        }
        int j1;
        if (c != null)
        {
            obj = c.l();
        } else
        {
            obj = null;
        }
        j1 = ((flag2) ? 1 : 0);
        if (j)
        {
            j1 = ((flag2) ? 1 : 0);
            if (obj != null)
            {
                j1 = ((ArrayList) (obj)).size();
                if (j1 == 1)
                {
                    if (!((MenuItemImpl)((ArrayList) (obj)).get(0)).isActionViewExpanded())
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                } else
                if (j1 > 0)
                {
                    j1 = ((flag1) ? 1 : 0);
                } else
                {
                    j1 = 0;
                }
            }
        }
        if (j1 == 0) goto _L2; else goto _L1
_L1:
        if (i == null)
        {
            i = new ct(this, a);
        }
        obj = (ViewGroup)i.getParent();
        if (obj != f)
        {
            if (obj != null)
            {
                ((ViewGroup) (obj)).removeView(i);
            }
            obj = (ActionMenuView)f;
            ((ActionMenuView) (obj)).addView(i, ((ActionMenuView) (obj)).generateOverflowButtonLayoutParams());
        }
_L4:
        ((ActionMenuView)f).setOverflowReserved(j);
        return;
_L2:
        if (i != null && i.getParent() == f)
        {
            ((ViewGroup)f).removeView(i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a(int i1, MenuItemImpl menuitemimpl)
    {
        return menuitemimpl.i();
    }

    public boolean a(SubMenuBuilder submenubuilder)
    {
        if (!submenubuilder.hasVisibleItems())
        {
            return false;
        }
        Object obj;
        for (obj = submenubuilder; ((SubMenuBuilder) (obj)).s() != c; obj = (SubMenuBuilder)((SubMenuBuilder) (obj)).s()) { }
        View view = a(((SubMenuBuilder) (obj)).getItem());
        obj = view;
        if (view == null)
        {
            if (i == null)
            {
                return false;
            }
            obj = i;
        }
        h = submenubuilder.getItem().getItemId();
        w = new cq(this, b, submenubuilder);
        w.a(((View) (obj)));
        w.a();
        super.a(submenubuilder);
        return true;
    }

    public boolean a(ViewGroup viewgroup, int i1)
    {
        if (viewgroup.getChildAt(i1) == i)
        {
            return false;
        } else
        {
            return super.a(viewgroup, i1);
        }
    }

    public void b(int i1)
    {
        n = i1;
        o = true;
    }

    public void b(boolean flag)
    {
        j = flag;
        k = true;
    }

    public boolean b()
    {
        ArrayList arraylist;
        ViewGroup viewgroup;
        int k1;
        int l1;
        int l3;
        int l4;
        int i5;
label0:
        {
            arraylist = c.i();
            l4 = arraylist.size();
            int i1 = n;
            l3 = m;
            i5 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            viewgroup = (ViewGroup)f;
            l1 = 0;
            int i2 = 0;
            boolean flag = false;
            k1 = 0;
            while (k1 < l4) 
            {
                MenuItemImpl menuitemimpl = (MenuItemImpl)arraylist.get(k1);
                if (menuitemimpl.k())
                {
                    l1++;
                } else
                if (menuitemimpl.j())
                {
                    i2++;
                } else
                {
                    flag = true;
                }
                if (r && menuitemimpl.isActionViewExpanded())
                {
                    i1 = 0;
                }
                k1++;
            }
            k1 = i1;
            if (!j)
            {
                break label0;
            }
            if (!flag)
            {
                k1 = i1;
                if (l1 + i2 <= i1)
                {
                    break label0;
                }
            }
            k1 = i1 - 1;
        }
        k1 -= l1;
        SparseBooleanArray sparsebooleanarray = t;
        sparsebooleanarray.clear();
        int j1 = 0;
        int k2;
        boolean flag1;
        int j3;
        int k3;
        if (p)
        {
            j1 = l3 / s;
            l1 = s;
            int j2 = s;
            j3 = (l3 % l1) / j1 + j2;
        } else
        {
            j3 = 0;
        }
        k3 = 0;
        flag1 = false;
        l1 = j1;
        j1 = k1;
        k2 = l3;
        k1 = ((flag1) ? 1 : 0);
        while (k3 < l4) 
        {
            MenuItemImpl menuitemimpl1 = (MenuItemImpl)arraylist.get(k3);
            int l2;
            if (menuitemimpl1.k())
            {
                View view = a(menuitemimpl1, u, viewgroup);
                if (u == null)
                {
                    u = view;
                }
                int i4;
                if (p)
                {
                    l2 = l1 - ActionMenuView.measureChildForCells(view, j3, l1, i5, 0);
                } else
                {
                    view.measure(i5, i5);
                    l2 = l1;
                }
                l1 = view.getMeasuredWidth();
                if (k1 == 0)
                {
                    k1 = l1;
                }
                i4 = menuitemimpl1.getGroupId();
                if (i4 != 0)
                {
                    sparsebooleanarray.put(i4, true);
                }
                menuitemimpl1.d(true);
                k2 -= l1;
                l1 = j1;
                j1 = k2;
            } else
            if (menuitemimpl1.j())
            {
                int j5 = menuitemimpl1.getGroupId();
                boolean flag3 = sparsebooleanarray.get(j5);
                boolean flag2;
                if ((j1 > 0 || flag3) && k2 > 0 && (!p || l1 > 0))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    View view1 = a(menuitemimpl1, u, viewgroup);
                    if (u == null)
                    {
                        u = view1;
                    }
                    int j4;
                    if (p)
                    {
                        l2 = ActionMenuView.measureChildForCells(view1, j3, l1, i5, 0);
                        if (l2 == 0)
                        {
                            flag2 = false;
                        }
                        l1 -= l2;
                    } else
                    {
                        view1.measure(i5, i5);
                    }
                    l2 = view1.getMeasuredWidth();
                    j4 = k2 - l2;
                    k2 = k1;
                    if (k1 == 0)
                    {
                        k2 = l2;
                    }
                    if (p)
                    {
                        if (j4 >= 0)
                        {
                            k1 = 1;
                        } else
                        {
                            k1 = 0;
                        }
                        flag2 &= k1;
                        k1 = k2;
                        l2 = l1;
                        k2 = j4;
                        l1 = k1;
                        k1 = l2;
                    } else
                    {
                        if (j4 + k2 > 0)
                        {
                            k1 = 1;
                        } else
                        {
                            k1 = 0;
                        }
                        flag2 &= k1;
                        k1 = l1;
                        l1 = k2;
                        k2 = j4;
                    }
                } else
                {
                    int i3 = k1;
                    k1 = l1;
                    l1 = i3;
                }
                if (flag2 && j5 != 0)
                {
                    sparsebooleanarray.put(j5, true);
                } else
                if (flag3)
                {
                    sparsebooleanarray.put(j5, false);
                    int k4 = 0;
                    while (k4 < k3) 
                    {
                        MenuItemImpl menuitemimpl2 = (MenuItemImpl)arraylist.get(k4);
                        l2 = j1;
                        if (menuitemimpl2.getGroupId() == j5)
                        {
                            l2 = j1;
                            if (menuitemimpl2.i())
                            {
                                l2 = j1 + 1;
                            }
                            menuitemimpl2.d(false);
                        }
                        k4++;
                        j1 = l2;
                    }
                }
                l2 = j1;
                if (flag2)
                {
                    l2 = j1 - 1;
                }
                menuitemimpl1.d(flag2);
                j1 = k2;
                k2 = l2;
                l2 = k1;
                k1 = l1;
                l1 = k2;
            } else
            {
                menuitemimpl1.d(false);
                l2 = k2;
                k2 = j1;
                j1 = l2;
                l2 = l1;
                l1 = k2;
            }
            i4 = k3 + 1;
            k3 = l1;
            l1 = l2;
            k2 = j1;
            j1 = k3;
            k3 = i4;
        }
        return true;
    }

    public void c(boolean flag)
    {
        r = flag;
    }

    public boolean c()
    {
        if (j && !g() && c != null && f != null && x == null && !c.l().isEmpty())
        {
            x = new cs(this, new cu(this, b, c, i, true));
            ((View)f).post(x);
            super.a(null);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean d()
    {
        if (x != null && f != null)
        {
            ((View)f).removeCallbacks(x);
            x = null;
            return true;
        }
        cu cu1 = v;
        if (cu1 != null)
        {
            cu1.e();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean e()
    {
        return d() | f();
    }

    public boolean f()
    {
        if (w != null)
        {
            w.e();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean g()
    {
        return v != null && v.f();
    }

    public boolean h()
    {
        return x != null || g();
    }

    public boolean i()
    {
        return j;
    }

    public void onSubUiVisibilityChanged(boolean flag)
    {
        if (flag)
        {
            super.a(null);
            return;
        } else
        {
            c.a(false);
            return;
        }
    }
}
