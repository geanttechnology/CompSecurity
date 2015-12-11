// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v7.internal.view.menu:
//            c, d

public class i extends android.support.v7.internal.view.menu.c
    implements MenuItem
{
    class a extends android.support.v4.view.d
    {

        final ActionProvider a;
        final i b;

        public View a()
        {
            return a.onCreateActionView();
        }

        public void a(SubMenu submenu)
        {
            a.onPrepareSubMenu(b.a(submenu));
        }

        public boolean d()
        {
            return a.onPerformDefaultAction();
        }

        public boolean e()
        {
            return a.hasSubMenu();
        }

        public a(Context context, ActionProvider actionprovider)
        {
            b = i.this;
            super(context);
            a = actionprovider;
        }
    }

    static class b extends FrameLayout
        implements android.support.v7.d.b
    {

        final CollapsibleActionView a;

        public void a()
        {
            a.onActionViewExpanded();
        }

        public void b()
        {
            a.onActionViewCollapsed();
        }

        View c()
        {
            return (View)a;
        }

        b(View view)
        {
            super(view.getContext());
            a = (CollapsibleActionView)view;
            addView(view);
        }
    }

    private class c extends android.support.v7.internal.view.menu.d
        implements android.support.v4.view.q.e
    {

        final i a;

        public boolean a(MenuItem menuitem)
        {
            return ((android.view.MenuItem.OnActionExpandListener)b).onMenuItemActionExpand(a.a(menuitem));
        }

        public boolean b(MenuItem menuitem)
        {
            return ((android.view.MenuItem.OnActionExpandListener)b).onMenuItemActionCollapse(a.a(menuitem));
        }

        c(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
        {
            a = i.this;
            super(onactionexpandlistener);
        }
    }

    private class d extends android.support.v7.internal.view.menu.d
        implements android.view.MenuItem.OnMenuItemClickListener
    {

        final i a;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            return ((android.view.MenuItem.OnMenuItemClickListener)b).onMenuItemClick(a.a(menuitem));
        }

        d(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
        {
            a = i.this;
            super(onmenuitemclicklistener);
        }
    }


    private Method c;

    i(Context context, android.support.v4.c.a.b b1)
    {
        super(context, b1);
    }

    a a(ActionProvider actionprovider)
    {
        return new a(a, actionprovider);
    }

    public void a(boolean flag)
    {
        try
        {
            if (c == null)
            {
                c = ((android.support.v4.c.a.b)b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] {
                    Boolean.TYPE
                });
            }
            c.invoke(b, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        }
        catch (Exception exception)
        {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", exception);
        }
    }

    public boolean collapseActionView()
    {
        return ((android.support.v4.c.a.b)b).collapseActionView();
    }

    public boolean expandActionView()
    {
        return ((android.support.v4.c.a.b)b).expandActionView();
    }

    public ActionProvider getActionProvider()
    {
        android.support.v4.view.d d1 = ((android.support.v4.c.a.b)b).a();
        if (d1 instanceof a)
        {
            return ((a)d1).a;
        } else
        {
            return null;
        }
    }

    public View getActionView()
    {
        View view1 = ((android.support.v4.c.a.b)b).getActionView();
        View view = view1;
        if (view1 instanceof b)
        {
            view = ((b)view1).c();
        }
        return view;
    }

    public char getAlphabeticShortcut()
    {
        return ((android.support.v4.c.a.b)b).getAlphabeticShortcut();
    }

    public int getGroupId()
    {
        return ((android.support.v4.c.a.b)b).getGroupId();
    }

    public Drawable getIcon()
    {
        return ((android.support.v4.c.a.b)b).getIcon();
    }

    public Intent getIntent()
    {
        return ((android.support.v4.c.a.b)b).getIntent();
    }

    public int getItemId()
    {
        return ((android.support.v4.c.a.b)b).getItemId();
    }

    public android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return ((android.support.v4.c.a.b)b).getMenuInfo();
    }

    public char getNumericShortcut()
    {
        return ((android.support.v4.c.a.b)b).getNumericShortcut();
    }

    public int getOrder()
    {
        return ((android.support.v4.c.a.b)b).getOrder();
    }

    public SubMenu getSubMenu()
    {
        return a(((android.support.v4.c.a.b)b).getSubMenu());
    }

    public CharSequence getTitle()
    {
        return ((android.support.v4.c.a.b)b).getTitle();
    }

    public CharSequence getTitleCondensed()
    {
        return ((android.support.v4.c.a.b)b).getTitleCondensed();
    }

    public boolean hasSubMenu()
    {
        return ((android.support.v4.c.a.b)b).hasSubMenu();
    }

    public boolean isActionViewExpanded()
    {
        return ((android.support.v4.c.a.b)b).isActionViewExpanded();
    }

    public boolean isCheckable()
    {
        return ((android.support.v4.c.a.b)b).isCheckable();
    }

    public boolean isChecked()
    {
        return ((android.support.v4.c.a.b)b).isChecked();
    }

    public boolean isEnabled()
    {
        return ((android.support.v4.c.a.b)b).isEnabled();
    }

    public boolean isVisible()
    {
        return ((android.support.v4.c.a.b)b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionprovider)
    {
        android.support.v4.c.a.b b1 = (android.support.v4.c.a.b)b;
        if (actionprovider != null)
        {
            actionprovider = a(actionprovider);
        } else
        {
            actionprovider = null;
        }
        b1.a(actionprovider);
        return this;
    }

    public MenuItem setActionView(int j)
    {
        ((android.support.v4.c.a.b)b).setActionView(j);
        View view = ((android.support.v4.c.a.b)b).getActionView();
        if (view instanceof CollapsibleActionView)
        {
            ((android.support.v4.c.a.b)b).setActionView(new b(view));
        }
        return this;
    }

    public MenuItem setActionView(View view)
    {
        Object obj = view;
        if (view instanceof CollapsibleActionView)
        {
            obj = new b(view);
        }
        ((android.support.v4.c.a.b)b).setActionView(((View) (obj)));
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c1)
    {
        ((android.support.v4.c.a.b)b).setAlphabeticShortcut(c1);
        return this;
    }

    public MenuItem setCheckable(boolean flag)
    {
        ((android.support.v4.c.a.b)b).setCheckable(flag);
        return this;
    }

    public MenuItem setChecked(boolean flag)
    {
        ((android.support.v4.c.a.b)b).setChecked(flag);
        return this;
    }

    public MenuItem setEnabled(boolean flag)
    {
        ((android.support.v4.c.a.b)b).setEnabled(flag);
        return this;
    }

    public MenuItem setIcon(int j)
    {
        ((android.support.v4.c.a.b)b).setIcon(j);
        return this;
    }

    public MenuItem setIcon(Drawable drawable)
    {
        ((android.support.v4.c.a.b)b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent)
    {
        ((android.support.v4.c.a.b)b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c1)
    {
        ((android.support.v4.c.a.b)b).setNumericShortcut(c1);
        return this;
    }

    public MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        android.support.v4.c.a.b b1 = (android.support.v4.c.a.b)b;
        if (onactionexpandlistener != null)
        {
            onactionexpandlistener = new c(onactionexpandlistener);
        } else
        {
            onactionexpandlistener = null;
        }
        b1.a(onactionexpandlistener);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        android.support.v4.c.a.b b1 = (android.support.v4.c.a.b)b;
        if (onmenuitemclicklistener != null)
        {
            onmenuitemclicklistener = new d(onmenuitemclicklistener);
        } else
        {
            onmenuitemclicklistener = null;
        }
        b1.setOnMenuItemClickListener(onmenuitemclicklistener);
        return this;
    }

    public MenuItem setShortcut(char c1, char c2)
    {
        ((android.support.v4.c.a.b)b).setShortcut(c1, c2);
        return this;
    }

    public void setShowAsAction(int j)
    {
        ((android.support.v4.c.a.b)b).setShowAsAction(j);
    }

    public MenuItem setShowAsActionFlags(int j)
    {
        ((android.support.v4.c.a.b)b).setShowAsActionFlags(j);
        return this;
    }

    public MenuItem setTitle(int j)
    {
        ((android.support.v4.c.a.b)b).setTitle(j);
        return this;
    }

    public MenuItem setTitle(CharSequence charsequence)
    {
        ((android.support.v4.c.a.b)b).setTitle(charsequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charsequence)
    {
        ((android.support.v4.c.a.b)b).setTitleCondensed(charsequence);
        return this;
    }

    public MenuItem setVisible(boolean flag)
    {
        return ((android.support.v4.c.a.b)b).setVisible(flag);
    }
}
