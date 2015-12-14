// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class aw
    implements bo
{

    public Context a;
    public Context b;
    public MenuBuilder c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    public bq f;
    private bp g;
    private int h;
    private int i;
    private int j;

    public aw(Context context, int k, int l)
    {
        a = context;
        d = LayoutInflater.from(context);
        h = k;
        i = l;
    }

    public View a(MenuItemImpl menuitemimpl, View view, ViewGroup viewgroup)
    {
        if (view instanceof br)
        {
            view = (br)view;
        } else
        {
            view = b(viewgroup);
        }
        a(menuitemimpl, ((br) (view)));
        return (View)view;
    }

    public bp a()
    {
        return g;
    }

    public bq a(ViewGroup viewgroup)
    {
        if (f == null)
        {
            f = (bq)d.inflate(h, viewgroup, false);
            f.initialize(c);
            a(true);
        }
        return f;
    }

    public void a(int k)
    {
        j = k;
    }

    public void a(Context context, MenuBuilder menubuilder)
    {
        b = context;
        e = LayoutInflater.from(b);
        c = menubuilder;
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        if (g != null)
        {
            g.a(menubuilder, flag);
        }
    }

    public abstract void a(MenuItemImpl menuitemimpl, br br1);

    protected void a(View view, int k)
    {
        ViewGroup viewgroup = (ViewGroup)view.getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(view);
        }
        ((ViewGroup)f).addView(view, k);
    }

    public void a(bp bp1)
    {
        g = bp1;
    }

    public void a(boolean flag)
    {
        ViewGroup viewgroup = (ViewGroup)f;
        if (viewgroup != null)
        {
            int l;
            if (c != null)
            {
                c.j();
                ArrayList arraylist = c.i();
                int j1 = arraylist.size();
                int i1 = 0;
                int k = 0;
                do
                {
                    l = k;
                    if (i1 >= j1)
                    {
                        break;
                    }
                    MenuItemImpl menuitemimpl1 = (MenuItemImpl)arraylist.get(i1);
                    if (a(k, menuitemimpl1))
                    {
                        View view = viewgroup.getChildAt(k);
                        MenuItemImpl menuitemimpl;
                        View view1;
                        if (view instanceof br)
                        {
                            menuitemimpl = ((br)view).getItemData();
                        } else
                        {
                            menuitemimpl = null;
                        }
                        view1 = a(menuitemimpl1, view, viewgroup);
                        if (menuitemimpl1 != menuitemimpl)
                        {
                            view1.setPressed(false);
                            ViewCompat.jumpDrawablesToCurrentState(view1);
                        }
                        if (view1 != view)
                        {
                            a(view1, k);
                        }
                        k++;
                    }
                    i1++;
                } while (true);
            } else
            {
                l = 0;
            }
            while (l < viewgroup.getChildCount()) 
            {
                if (!a(viewgroup, l))
                {
                    l++;
                }
            }
        }
    }

    public boolean a(int k, MenuItemImpl menuitemimpl)
    {
        return true;
    }

    public boolean a(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public boolean a(SubMenuBuilder submenubuilder)
    {
        if (g != null)
        {
            return g.a(submenubuilder);
        } else
        {
            return false;
        }
    }

    public boolean a(ViewGroup viewgroup, int k)
    {
        viewgroup.removeViewAt(k);
        return true;
    }

    public br b(ViewGroup viewgroup)
    {
        return (br)d.inflate(i, viewgroup, false);
    }

    public boolean b()
    {
        return false;
    }

    public boolean b(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }
}
