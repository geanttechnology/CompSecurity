// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class ar
{

    final ap a;
    private Menu b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private CharSequence l;
    private CharSequence m;
    private int n;
    private char o;
    private char p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private String w;
    private String x;
    private String y;
    private ActionProvider z;

    public ar(ap ap1, Menu menu)
    {
        a = ap1;
        super();
        b = menu;
        a();
    }

    private char a(String s1)
    {
        if (s1 == null)
        {
            return '\0';
        } else
        {
            return s1.charAt(0);
        }
    }

    static ActionProvider a(ar ar1)
    {
        return ar1.z;
    }

    private Object a(String s1, Class aclass[], Object aobj[])
    {
        try
        {
            aclass = ((Class []) (ap.a(a).getClassLoader().loadClass(s1).getConstructor(aclass).newInstance(aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Class aclass[])
        {
            Log.w("SupportMenuInflater", (new StringBuilder()).append("Cannot instantiate class: ").append(s1).toString(), aclass);
            return null;
        }
        return aclass;
    }

    private void a(MenuItem menuitem)
    {
        boolean flag = true;
        Object obj = menuitem.setChecked(r).setVisible(s).setEnabled(t);
        boolean flag1;
        if (q >= 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((MenuItem) (obj)).setCheckable(flag1).setTitleCondensed(m).setIcon(n).setAlphabeticShortcut(o).setNumericShortcut(p);
        if (u >= 0)
        {
            MenuItemCompat.setShowAsAction(menuitem, u);
        }
        if (y != null)
        {
            if (ap.a(a).isRestricted())
            {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuitem.setOnMenuItemClickListener(new aq(ap.c(a), y));
        }
        if (menuitem instanceof MenuItemImpl)
        {
            obj = (MenuItemImpl)menuitem;
        }
        if (q >= 2)
        {
            if (menuitem instanceof MenuItemImpl)
            {
                ((MenuItemImpl)menuitem).a(true);
            } else
            if (menuitem instanceof bf)
            {
                ((bf)menuitem).a(true);
            }
        }
        if (w != null)
        {
            MenuItemCompat.setActionView(menuitem, (View)a(w, ap.b(), ap.d(a)));
        } else
        {
            flag = false;
        }
        if (v > 0)
        {
            if (!flag)
            {
                MenuItemCompat.setActionView(menuitem, v);
            } else
            {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        if (z != null)
        {
            MenuItemCompat.setActionProvider(menuitem, z);
        }
    }

    public void a()
    {
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = true;
        h = true;
    }

    public void a(AttributeSet attributeset)
    {
        attributeset = ap.a(a).obtainStyledAttributes(attributeset, ab.MenuGroup);
        c = attributeset.getResourceId(ab.MenuGroup_android_id, 0);
        d = attributeset.getInt(ab.MenuGroup_android_menuCategory, 0);
        e = attributeset.getInt(ab.MenuGroup_android_orderInCategory, 0);
        f = attributeset.getInt(ab.MenuGroup_android_checkableBehavior, 0);
        g = attributeset.getBoolean(ab.MenuGroup_android_visible, true);
        h = attributeset.getBoolean(ab.MenuGroup_android_enabled, true);
        attributeset.recycle();
    }

    public void b()
    {
        i = true;
        a(b.add(c, j, k, l));
    }

    public void b(AttributeSet attributeset)
    {
        boolean flag = true;
        attributeset = ap.a(a).obtainStyledAttributes(attributeset, ab.MenuItem);
        j = attributeset.getResourceId(ab.MenuItem_android_id, 0);
        k = attributeset.getInt(ab.MenuItem_android_menuCategory, d) & 0xffff0000 | attributeset.getInt(ab.MenuItem_android_orderInCategory, e) & 0xffff;
        l = attributeset.getText(ab.MenuItem_android_title);
        m = attributeset.getText(ab.MenuItem_android_titleCondensed);
        n = attributeset.getResourceId(ab.MenuItem_android_icon, 0);
        o = a(attributeset.getString(ab.MenuItem_android_alphabeticShortcut));
        p = a(attributeset.getString(ab.MenuItem_android_numericShortcut));
        int i1;
        if (attributeset.hasValue(ab.MenuItem_android_checkable))
        {
            if (attributeset.getBoolean(ab.MenuItem_android_checkable, false))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            q = i1;
        } else
        {
            q = f;
        }
        r = attributeset.getBoolean(ab.MenuItem_android_checked, false);
        s = attributeset.getBoolean(ab.MenuItem_android_visible, g);
        t = attributeset.getBoolean(ab.MenuItem_android_enabled, h);
        u = attributeset.getInt(ab.MenuItem_showAsAction, -1);
        y = attributeset.getString(ab.MenuItem_android_onClick);
        v = attributeset.getResourceId(ab.MenuItem_actionLayout, 0);
        w = attributeset.getString(ab.MenuItem_actionViewClass);
        x = attributeset.getString(ab.MenuItem_actionProviderClass);
        if (x != null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        if (i1 != 0 && v == 0 && w == null)
        {
            z = (ActionProvider)a(x, ap.a(), ap.b(a));
        } else
        {
            if (i1 != 0)
            {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            z = null;
        }
        attributeset.recycle();
        i = false;
    }

    public SubMenu c()
    {
        i = true;
        SubMenu submenu = b.addSubMenu(c, j, k, l);
        a(submenu.getItem());
        return submenu;
    }

    public boolean d()
    {
        return i;
    }
}
