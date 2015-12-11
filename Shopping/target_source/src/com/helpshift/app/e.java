// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package com.helpshift.app:
//            d

public class e
    implements MenuItem
{

    private d a;
    private final int b;
    private final int c;
    private CharSequence d;
    private CharSequence e;
    private Drawable f;
    private int g;
    private boolean h;
    private View i;
    private android.support.v4.view.q.e j;
    private boolean k;
    private com.helpshift.j.c.b l;

    public e(d d1, int i1, int j1, CharSequence charsequence)
    {
        i = null;
        j = null;
        l = null;
        a = d1;
        b = i1;
        c = j1;
        d = charsequence;
    }

    public MenuItem a(com.helpshift.j.c.b b1)
    {
        l = b1;
        return this;
    }

    public boolean collapseActionView()
    {
        k = false;
        return true;
    }

    public boolean expandActionView()
    {
        k = true;
        return true;
    }

    public ActionProvider getActionProvider()
    {
        return null;
    }

    public View getActionView()
    {
        return i;
    }

    public char getAlphabeticShortcut()
    {
        return '\0';
    }

    public int getGroupId()
    {
        return 0;
    }

    public Drawable getIcon()
    {
        if (f != null)
        {
            return f;
        }
        if (g != 0)
        {
            return a.a().getDrawable(g);
        } else
        {
            return null;
        }
    }

    public Intent getIntent()
    {
        return null;
    }

    public int getItemId()
    {
        return b;
    }

    public android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return null;
    }

    public char getNumericShortcut()
    {
        return '\0';
    }

    public int getOrder()
    {
        return c;
    }

    public SubMenu getSubMenu()
    {
        return null;
    }

    public CharSequence getTitle()
    {
        return d;
    }

    public CharSequence getTitleCondensed()
    {
        return e;
    }

    public boolean hasSubMenu()
    {
        return false;
    }

    public boolean isActionViewExpanded()
    {
        return k;
    }

    public boolean isCheckable()
    {
        return false;
    }

    public boolean isChecked()
    {
        return false;
    }

    public boolean isEnabled()
    {
        return false;
    }

    public boolean isVisible()
    {
        return h;
    }

    public MenuItem setActionProvider(ActionProvider actionprovider)
    {
        return this;
    }

    public MenuItem setActionView(int i1)
    {
        return this;
    }

    public MenuItem setActionView(View view)
    {
        i = view;
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c1)
    {
        return this;
    }

    public MenuItem setCheckable(boolean flag)
    {
        return this;
    }

    public MenuItem setChecked(boolean flag)
    {
        return this;
    }

    public MenuItem setEnabled(boolean flag)
    {
        return this;
    }

    public MenuItem setIcon(int i1)
    {
        f = null;
        g = i1;
        return this;
    }

    public MenuItem setIcon(Drawable drawable)
    {
        g = 0;
        f = drawable;
        return this;
    }

    public MenuItem setIntent(Intent intent)
    {
        return this;
    }

    public MenuItem setNumericShortcut(char c1)
    {
        return this;
    }

    public MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        return this;
    }

    public MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        return this;
    }

    public MenuItem setShortcut(char c1, char c2)
    {
        return this;
    }

    public void setShowAsAction(int i1)
    {
    }

    public MenuItem setShowAsActionFlags(int i1)
    {
        return this;
    }

    public MenuItem setTitle(int i1)
    {
        d = a.a().getString(i1);
        return this;
    }

    public MenuItem setTitle(CharSequence charsequence)
    {
        d = charsequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charsequence)
    {
        e = charsequence;
        return this;
    }

    public MenuItem setVisible(boolean flag)
    {
        h = flag;
        if (l != null)
        {
            l.a(flag);
        }
        return this;
    }
}
