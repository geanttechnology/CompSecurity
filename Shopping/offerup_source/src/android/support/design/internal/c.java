// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.m;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.design.internal:
//            d, b, NavigationMenuItemView

final class c extends BaseAdapter
{

    private final ArrayList a = new ArrayList();
    private m b;
    private ColorDrawable c;
    private boolean d;
    private b e;

    c(b b1)
    {
        e = b1;
        super();
        b();
    }

    private void a(int j, int k)
    {
        for (; j < k; j++)
        {
            m m1 = ((d)a.get(j)).d();
            if (m1.getIcon() != null)
            {
                continue;
            }
            if (c == null)
            {
                c = new ColorDrawable(0x106000d);
            }
            m1.setIcon(c);
        }

    }

    private void b()
    {
        int j;
        int k;
        int l;
        int i2;
        int k2;
        if (d)
        {
            return;
        }
        d = true;
        a.clear();
        l = -1;
        k2 = android.support.design.internal.b.g(e).j().size();
        i2 = 0;
        k = 0;
        j = 0;
_L5:
        if (i2 >= k2) goto _L2; else goto _L1
_L1:
        m m1;
        m1 = (m)android.support.design.internal.b.g(e).j().get(i2);
        if (m1.isChecked())
        {
            a(m1);
        }
        if (m1.isCheckable())
        {
            m1.a(false);
        }
        if (!m1.hasSubMenu()) goto _L4; else goto _L3
_L3:
        SubMenu submenu = m1.getSubMenu();
        if (submenu.hasVisibleItems())
        {
            if (i2 != 0)
            {
                a.add(android.support.design.internal.d.a(android.support.design.internal.b.h(e), 0));
            }
            a.add(android.support.design.internal.d.a(m1));
            int l2 = a.size();
            int i3 = submenu.size();
            int j2 = 0;
            boolean flag;
            boolean flag1;
            for (flag = false; j2 < i3; flag = flag1)
            {
                m m2 = (m)submenu.getItem(j2);
                flag1 = flag;
                if (m2.isVisible())
                {
                    flag1 = flag;
                    if (!flag)
                    {
                        flag1 = flag;
                        if (m2.getIcon() != null)
                        {
                            flag1 = true;
                        }
                    }
                    if (m2.isCheckable())
                    {
                        m2.a(false);
                    }
                    if (m1.isChecked())
                    {
                        a(m1);
                    }
                    a.add(android.support.design.internal.d.a(m2));
                }
                j2++;
            }

            if (flag)
            {
                a(l2, a.size());
            }
        }
        int i1 = k;
        k = l;
        l = j;
        j = i1;
_L6:
        i2++;
        int j1 = k;
        k = j;
        j = l;
        l = j1;
          goto _L5
_L4:
        int k1;
        int l1 = m1.getGroupId();
        if (l1 != l)
        {
            k = a.size();
            if (m1.getIcon() != null)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            k1 = j;
            l = k;
            if (i2 == 0)
            {
                break MISSING_BLOCK_LABEL_527;
            }
            a.add(android.support.design.internal.d.a(android.support.design.internal.b.h(e), android.support.design.internal.b.h(e)));
            k++;
        } else
        {
            k1 = k;
            l = j;
            if (k != 0)
            {
                break MISSING_BLOCK_LABEL_527;
            }
            k1 = k;
            l = j;
            if (m1.getIcon() == null)
            {
                break MISSING_BLOCK_LABEL_527;
            }
            a(j, a.size());
            l = 1;
            k = j;
            j = l;
        }
_L7:
        if (j != 0 && m1.getIcon() == null)
        {
            m1.setIcon(0x106000d);
        }
        a.add(android.support.design.internal.d.a(m1));
        k1 = l1;
        l = k;
        k = k1;
          goto _L6
_L2:
        d = false;
        return;
        j = k1;
        k = l;
          goto _L7
    }

    public final Bundle a()
    {
        Bundle bundle = new Bundle();
        if (b != null)
        {
            bundle.putInt("android:menu:checked", b.getItemId());
        }
        return bundle;
    }

    public final d a(int j)
    {
        return (d)a.get(j);
    }

    public final void a(Bundle bundle)
    {
        int j = bundle.getInt("android:menu:checked", 0);
        if (j != 0)
        {
            d = true;
            bundle = a.iterator();
            do
            {
                if (!bundle.hasNext())
                {
                    break;
                }
                m m1 = ((d)bundle.next()).d();
                if (m1 == null || m1.getItemId() != j)
                {
                    continue;
                }
                a(m1);
                break;
            } while (true);
            d = false;
            b();
        }
    }

    public final void a(m m1)
    {
        if (b == m1 || !m1.isCheckable())
        {
            return;
        }
        if (b != null)
        {
            b.setChecked(false);
        }
        b = m1;
        m1.setChecked(true);
    }

    public final void a(boolean flag)
    {
        d = flag;
    }

    public final boolean areAllItemsEnabled()
    {
        return false;
    }

    public final int getCount()
    {
        return a.size();
    }

    public final Object getItem(int j)
    {
        return a(j);
    }

    public final long getItemId(int j)
    {
        return (long)j;
    }

    public final int getItemViewType(int j)
    {
        d d1 = a(j);
        if (d1.a())
        {
            return 2;
        }
        return !d1.d().hasSubMenu() ? 0 : 1;
    }

    public final View getView(int j, View view, ViewGroup viewgroup)
    {
        d d1 = a(j);
        getItemViewType(j);
        JVM INSTR tableswitch 0 2: default 40
    //                   0 42
    //                   1 176
    //                   2 212;
           goto _L1 _L2 _L3 _L4
_L1:
        return view;
_L2:
        if (view == null)
        {
            view = android.support.design.internal.b.a(e).inflate(0x7f040075, viewgroup, false);
        }
        NavigationMenuItemView navigationmenuitemview = (NavigationMenuItemView)view;
        navigationmenuitemview.setIconTintList(android.support.design.internal.b.b(e));
        if (android.support.design.internal.b.c(e))
        {
            navigationmenuitemview.setTextAppearance(navigationmenuitemview.getContext(), android.support.design.internal.b.d(e));
        }
        if (android.support.design.internal.b.e(e) != null)
        {
            navigationmenuitemview.setTextColor(android.support.design.internal.b.e(e));
        }
        if (android.support.design.internal.b.f(e) != null)
        {
            viewgroup = android.support.design.internal.b.f(e).getConstantState().newDrawable();
        } else
        {
            viewgroup = null;
        }
        navigationmenuitemview.setBackgroundDrawable(viewgroup);
        navigationmenuitemview.a(d1.d(), 0);
        return view;
_L3:
        if (view == null)
        {
            view = android.support.design.internal.b.a(e).inflate(0x7f040078, viewgroup, false);
        }
        ((TextView)view).setText(d1.d().getTitle());
        return view;
_L4:
        View view1 = view;
        if (view == null)
        {
            view1 = android.support.design.internal.b.a(e).inflate(0x7f040077, viewgroup, false);
        }
        view1.setPadding(0, d1.b(), 0, d1.c());
        view = view1;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final int getViewTypeCount()
    {
        return 3;
    }

    public final boolean isEnabled(int j)
    {
        return a(j).e();
    }

    public final void notifyDataSetChanged()
    {
        b();
        super.notifyDataSetChanged();
    }
}
