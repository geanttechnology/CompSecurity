// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.ag;
import android.support.v7.ck;
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

        public boolean hasSubMenu()
        {
            return a.hasSubMenu();
        }

        public View onCreateActionView()
        {
            return a.onCreateActionView();
        }

        public boolean onPerformDefaultAction()
        {
            return a.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu submenu)
        {
            a.onPrepareSubMenu(b.a(submenu));
        }

        public a(Context context, ActionProvider actionprovider)
        {
            b = i.this;
            super(context);
            a = actionprovider;
        }
    }

    static class b extends FrameLayout
        implements ck
    {

        final CollapsibleActionView a;

        View a()
        {
            return (View)a;
        }

        public void onActionViewCollapsed()
        {
            a.onActionViewCollapsed();
        }

        public void onActionViewExpanded()
        {
            a.onActionViewExpanded();
        }

        b(View view)
        {
            super(view.getContext());
            a = (CollapsibleActionView)view;
            addView(view);
        }
    }

    private class c extends android.support.v7.internal.view.menu.d
        implements android.support.v4.view.r.e
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

    i(Context context, ag ag1)
    {
        super(context, ag1);
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
                c = ((ag)b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] {
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
        return ((ag)b).collapseActionView();
    }

    public boolean expandActionView()
    {
        return ((ag)b).expandActionView();
    }

    public ActionProvider getActionProvider()
    {
        android.support.v4.view.d d1 = ((ag)b).a();
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
        View view1 = ((ag)b).getActionView();
        View view = view1;
        if (view1 instanceof b)
        {
            view = ((b)view1).a();
        }
        return view;
    }

    public char getAlphabeticShortcut()
    {
        return ((ag)b).getAlphabeticShortcut();
    }

    public int getGroupId()
    {
        return ((ag)b).getGroupId();
    }

    public Drawable getIcon()
    {
        return ((ag)b).getIcon();
    }

    public Intent getIntent()
    {
        return ((ag)b).getIntent();
    }

    public int getItemId()
    {
        return ((ag)b).getItemId();
    }

    public android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return ((ag)b).getMenuInfo();
    }

    public char getNumericShortcut()
    {
        return ((ag)b).getNumericShortcut();
    }

    public int getOrder()
    {
        return ((ag)b).getOrder();
    }

    public SubMenu getSubMenu()
    {
        return a(((ag)b).getSubMenu());
    }

    public CharSequence getTitle()
    {
        return ((ag)b).getTitle();
    }

    public CharSequence getTitleCondensed()
    {
        return ((ag)b).getTitleCondensed();
    }

    public boolean hasSubMenu()
    {
        return ((ag)b).hasSubMenu();
    }

    public boolean isActionViewExpanded()
    {
        return ((ag)b).isActionViewExpanded();
    }

    public boolean isCheckable()
    {
        return ((ag)b).isCheckable();
    }

    public boolean isChecked()
    {
        return ((ag)b).isChecked();
    }

    public boolean isEnabled()
    {
        return ((ag)b).isEnabled();
    }

    public boolean isVisible()
    {
        return ((ag)b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionprovider)
    {
        ag ag1 = (ag)b;
        if (actionprovider != null)
        {
            actionprovider = a(actionprovider);
        } else
        {
            actionprovider = null;
        }
        ag1.a(actionprovider);
        return this;
    }

    public MenuItem setActionView(int j)
    {
        ((ag)b).setActionView(j);
        View view = ((ag)b).getActionView();
        if (view instanceof CollapsibleActionView)
        {
            ((ag)b).setActionView(new b(view));
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
        ((ag)b).setActionView(((View) (obj)));
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c1)
    {
        ((ag)b).setAlphabeticShortcut(c1);
        return this;
    }

    public MenuItem setCheckable(boolean flag)
    {
        ((ag)b).setCheckable(flag);
        return this;
    }

    public MenuItem setChecked(boolean flag)
    {
        ((ag)b).setChecked(flag);
        return this;
    }

    public MenuItem setEnabled(boolean flag)
    {
        ((ag)b).setEnabled(flag);
        return this;
    }

    public MenuItem setIcon(int j)
    {
        ((ag)b).setIcon(j);
        return this;
    }

    public MenuItem setIcon(Drawable drawable)
    {
        ((ag)b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent)
    {
        ((ag)b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c1)
    {
        ((ag)b).setNumericShortcut(c1);
        return this;
    }

    public MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        ag ag1 = (ag)b;
        if (onactionexpandlistener != null)
        {
            onactionexpandlistener = new c(onactionexpandlistener);
        } else
        {
            onactionexpandlistener = null;
        }
        ag1.a(onactionexpandlistener);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        ag ag1 = (ag)b;
        if (onmenuitemclicklistener != null)
        {
            onmenuitemclicklistener = new d(onmenuitemclicklistener);
        } else
        {
            onmenuitemclicklistener = null;
        }
        ag1.setOnMenuItemClickListener(onmenuitemclicklistener);
        return this;
    }

    public MenuItem setShortcut(char c1, char c2)
    {
        ((ag)b).setShortcut(c1, c2);
        return this;
    }

    public void setShowAsAction(int j)
    {
        ((ag)b).setShowAsAction(j);
    }

    public MenuItem setShowAsActionFlags(int j)
    {
        ((ag)b).setShowAsActionFlags(j);
        return this;
    }

    public MenuItem setTitle(int j)
    {
        ((ag)b).setTitle(j);
        return this;
    }

    public MenuItem setTitle(CharSequence charsequence)
    {
        ((ag)b).setTitle(charsequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charsequence)
    {
        ((ag)b).setTitleCondensed(charsequence);
        return this;
    }

    public MenuItem setVisible(boolean flag)
    {
        return ((ag)b).setVisible(flag);
    }
}
