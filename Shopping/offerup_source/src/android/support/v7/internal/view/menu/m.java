// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.d.a.b;
import android.support.v4.view.ar;
import android.support.v4.view.k;
import android.support.v7.internal.widget.TintManager;
import android.util.Log;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package android.support.v7.internal.view.menu:
//            i, n, aa, ac

public final class m
    implements b
{

    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char i;
    private Drawable j;
    private int k;
    private i l;
    private ac m;
    private android.view.MenuItem.OnMenuItemClickListener n;
    private int o;
    private int p;
    private View q;
    private k r;
    private ar s;
    private boolean t;
    private android.view.ContextMenu.ContextMenuInfo u;

    m(i i1, int j1, int k1, int l1, int i2, CharSequence charsequence, int j2)
    {
        k = 0;
        o = 16;
        p = 0;
        t = false;
        l = i1;
        a = k1;
        b = j1;
        c = l1;
        d = i2;
        e = charsequence;
        p = j2;
    }

    private b a(View view)
    {
        q = view;
        r = null;
        if (view != null && view.getId() == -1 && a > 0)
        {
            view.setId(a);
        }
        l.i();
        return this;
    }

    static i a(m m1)
    {
        return m1.l;
    }

    public final b a(ar ar1)
    {
        s = ar1;
        return this;
    }

    public final b a(k k1)
    {
        if (r != null)
        {
            r.f();
        }
        q = null;
        r = k1;
        l.b(true);
        if (r != null)
        {
            r.a(new n(this));
        }
        return this;
    }

    public final k a()
    {
        return r;
    }

    final CharSequence a(aa aa1)
    {
        if (aa1 != null && aa1.a())
        {
            return getTitleCondensed();
        } else
        {
            return getTitle();
        }
    }

    public final void a(ac ac1)
    {
        m = ac1;
        ac1.setHeaderTitle(getTitle());
    }

    public final void a(boolean flag)
    {
        int i1 = o;
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        o = byte0 | i1 & -5;
    }

    final void b(boolean flag)
    {
        int i1 = o;
        int j1 = o;
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        o = byte0 | j1 & -3;
        if (i1 != o)
        {
            l.b(false);
        }
    }

    public final boolean b()
    {
_L2:
        return true;
        if (n != null && n.onMenuItemClick(this) || l.a(l.n(), this)) goto _L2; else goto _L1
_L1:
        if (g == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        l.d().startActivity(g);
        return true;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", activitynotfoundexception);
        if (r != null && r.d()) goto _L2; else goto _L3
_L3:
        return false;
    }

    public final int c()
    {
        return d;
    }

    final boolean c(boolean flag)
    {
        boolean flag1 = false;
        int i1 = o;
        int j1 = o;
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        o = byte0 | j1 & -9;
        flag = flag1;
        if (i1 != o)
        {
            flag = true;
        }
        return flag;
    }

    public final boolean collapseActionView()
    {
        if ((p & 8) != 0)
        {
            if (q == null)
            {
                return true;
            }
            if (s == null || s.b(this))
            {
                return l.b(this);
            }
        }
        return false;
    }

    final char d()
    {
        if (l.b())
        {
            return i;
        } else
        {
            return h;
        }
    }

    public final void d(boolean flag)
    {
        if (flag)
        {
            o = o | 0x20;
            return;
        } else
        {
            o = o & 0xffffffdf;
            return;
        }
    }

    public final void e(boolean flag)
    {
        t = flag;
        l.b(false);
    }

    final boolean e()
    {
        return l.c() && d() != 0;
    }

    public final boolean expandActionView()
    {
        while (!m() || s != null && !s.a(this)) 
        {
            return false;
        }
        return l.a(this);
    }

    public final boolean f()
    {
        return (o & 4) != 0;
    }

    public final void g()
    {
        l.i();
    }

    public final ActionProvider getActionProvider()
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final View getActionView()
    {
        if (q != null)
        {
            return q;
        }
        if (r != null)
        {
            q = r.a(this);
            return q;
        } else
        {
            return null;
        }
    }

    public final char getAlphabeticShortcut()
    {
        return i;
    }

    public final int getGroupId()
    {
        return b;
    }

    public final Drawable getIcon()
    {
        if (j != null)
        {
            return j;
        }
        if (k != 0)
        {
            Drawable drawable = TintManager.getDrawable(l.d(), k);
            k = 0;
            j = drawable;
            return drawable;
        } else
        {
            return null;
        }
    }

    public final Intent getIntent()
    {
        return g;
    }

    public final int getItemId()
    {
        return a;
    }

    public final android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return u;
    }

    public final char getNumericShortcut()
    {
        return h;
    }

    public final int getOrder()
    {
        return c;
    }

    public final SubMenu getSubMenu()
    {
        return m;
    }

    public final CharSequence getTitle()
    {
        return e;
    }

    public final CharSequence getTitleCondensed()
    {
        CharSequence charsequence;
        Object obj;
        if (f != null)
        {
            charsequence = f;
        } else
        {
            charsequence = e;
        }
        obj = charsequence;
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            obj = charsequence;
            if (charsequence != null)
            {
                obj = charsequence;
                if (!(charsequence instanceof String))
                {
                    obj = charsequence.toString();
                }
            }
        }
        return ((CharSequence) (obj));
    }

    public final boolean h()
    {
        i i1 = l;
        return false;
    }

    public final boolean hasSubMenu()
    {
        return m != null;
    }

    public final boolean i()
    {
        return (o & 0x20) == 32;
    }

    public final boolean isActionViewExpanded()
    {
        return t;
    }

    public final boolean isCheckable()
    {
        return (o & 1) == 1;
    }

    public final boolean isChecked()
    {
        return (o & 2) == 2;
    }

    public final boolean isEnabled()
    {
        return (o & 0x10) != 0;
    }

    public final boolean isVisible()
    {
        if (r == null || !r.b()) goto _L2; else goto _L1
_L1:
        if ((o & 8) != 0 || !r.c()) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if ((o & 8) != 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final boolean j()
    {
        return (p & 1) == 1;
    }

    public final boolean k()
    {
        return (p & 2) == 2;
    }

    public final boolean l()
    {
        return (p & 4) == 4;
    }

    public final boolean m()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if ((p & 8) != 0)
        {
            if (q == null && r != null)
            {
                q = r.a(this);
            }
            flag = flag1;
            if (q != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final MenuItem setActionProvider(ActionProvider actionprovider)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final MenuItem setActionView(int i1)
    {
        Context context = l.d();
        a(LayoutInflater.from(context).inflate(i1, new LinearLayout(context), false));
        return this;
    }

    public final MenuItem setActionView(View view)
    {
        return a(view);
    }

    public final MenuItem setAlphabeticShortcut(char c1)
    {
        if (i == c1)
        {
            return this;
        } else
        {
            i = Character.toLowerCase(c1);
            l.b(false);
            return this;
        }
    }

    public final MenuItem setCheckable(boolean flag)
    {
        int i1 = o;
        int j1 = o;
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        o = flag1 | j1 & -2;
        if (i1 != o)
        {
            l.b(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean flag)
    {
        if ((o & 4) != 0)
        {
            l.a(this);
            return this;
        } else
        {
            b(flag);
            return this;
        }
    }

    public final MenuItem setEnabled(boolean flag)
    {
        if (flag)
        {
            o = o | 0x10;
        } else
        {
            o = o & 0xffffffef;
        }
        l.b(false);
        return this;
    }

    public final MenuItem setIcon(int i1)
    {
        j = null;
        k = i1;
        l.b(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable)
    {
        k = 0;
        j = drawable;
        l.b(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent)
    {
        g = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c1)
    {
        if (h == c1)
        {
            return this;
        } else
        {
            h = c1;
            l.b(false);
            return this;
        }
    }

    public final MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public final MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        n = onmenuitemclicklistener;
        return this;
    }

    public final MenuItem setShortcut(char c1, char c2)
    {
        h = c1;
        i = Character.toLowerCase(c2);
        l.b(false);
        return this;
    }

    public final void setShowAsAction(int i1)
    {
        switch (i1 & 3)
        {
        default:
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            p = i1;
            break;
        }
        l.i();
    }

    public final MenuItem setShowAsActionFlags(int i1)
    {
        setShowAsAction(i1);
        return this;
    }

    public final MenuItem setTitle(int i1)
    {
        return setTitle(((CharSequence) (l.d().getString(i1))));
    }

    public final MenuItem setTitle(CharSequence charsequence)
    {
        e = charsequence;
        l.b(false);
        if (m != null)
        {
            m.setHeaderTitle(charsequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charsequence)
    {
        f = charsequence;
        l.b(false);
        return this;
    }

    public final MenuItem setVisible(boolean flag)
    {
        if (c(flag))
        {
            l.h();
        }
        return this;
    }

    public final String toString()
    {
        return e.toString();
    }
}
