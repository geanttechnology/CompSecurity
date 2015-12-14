// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.widget.TintManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package android.support.v7.internal.view.menu:
//            i, z, ac

public final class m
    implements SupportMenuItem
{

    private static String F;
    private static String G;
    private static String H;
    private static String I;
    static final int a = 0;
    private static final String b = "MenuItemImpl";
    private static final int c = 3;
    private static final int t = 1;
    private static final int u = 2;
    private static final int v = 4;
    private static final int w = 8;
    private static final int x = 16;
    private static final int y = 32;
    private View A;
    private ActionProvider B;
    private android.support.v4.view.MenuItemCompat.OnActionExpandListener C;
    private boolean D;
    private android.view.ContextMenu.ContextMenuInfo E;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private CharSequence h;
    private CharSequence i;
    private Intent j;
    private char k;
    private char l;
    private Drawable m;
    private int n;
    private i o;
    private ac p;
    private Runnable q;
    private android.view.MenuItem.OnMenuItemClickListener r;
    private int s;
    private int z;

    m(i i1, int j1, int k1, int l1, int i2, CharSequence charsequence, int j2)
    {
        n = 0;
        s = 16;
        z = 0;
        D = false;
        o = i1;
        d = k1;
        e = j1;
        f = l1;
        g = i2;
        h = charsequence;
        z = j2;
    }

    static i a(m m1)
    {
        return m1.o;
    }

    public final SupportMenuItem a(int i1)
    {
        Context context = o.f();
        a(LayoutInflater.from(context).inflate(i1, new LinearLayout(context), false));
        return this;
    }

    public final SupportMenuItem a(View view)
    {
        A = view;
        B = null;
        if (view != null && view.getId() == -1 && d > 0)
        {
            view.setId(d);
        }
        o.b(this);
        return this;
    }

    public final MenuItem a(Runnable runnable)
    {
        q = runnable;
        return this;
    }

    final CharSequence a(z z1)
    {
        if (z1 != null && z1.b())
        {
            return getTitleCondensed();
        } else
        {
            return getTitle();
        }
    }

    final void a(ac ac1)
    {
        p = ac1;
        ac1.setHeaderTitle(getTitle());
    }

    final void a(android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        E = contextmenuinfo;
    }

    public final void a(boolean flag)
    {
        int i1 = s;
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        s = byte0 | i1 & -5;
    }

    public final boolean a()
    {
_L2:
        return true;
        if (r != null && r.onMenuItemClick(this) || o.a(o.q(), this)) goto _L2; else goto _L1
_L1:
        if (q != null)
        {
            q.run();
            return true;
        }
        if (j == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        o.f().startActivity(j);
        return true;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", activitynotfoundexception);
        if (B != null && B.onPerformDefaultAction()) goto _L2; else goto _L3
_L3:
        return false;
    }

    public final int b()
    {
        return g;
    }

    public final SupportMenuItem b(int i1)
    {
        setShowAsAction(i1);
        return this;
    }

    final void b(boolean flag)
    {
        int i1 = s;
        int j1 = s;
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        s = byte0 | j1 & -3;
        if (i1 != s)
        {
            o.c(false);
        }
    }

    final Runnable c()
    {
        return q;
    }

    final boolean c(boolean flag)
    {
        boolean flag1 = false;
        int i1 = s;
        int j1 = s;
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        s = byte0 | j1 & -9;
        flag = flag1;
        if (i1 != s)
        {
            flag = true;
        }
        return flag;
    }

    public final boolean collapseActionView()
    {
        if ((z & 8) != 0)
        {
            if (A == null)
            {
                return true;
            }
            if (C == null || C.onMenuItemActionCollapse(this))
            {
                return o.d(this);
            }
        }
        return false;
    }

    final char d()
    {
        if (o.c())
        {
            return l;
        } else
        {
            return k;
        }
    }

    public final void d(boolean flag)
    {
        if (flag)
        {
            s = s | 0x20;
            return;
        } else
        {
            s = s & 0xffffffdf;
            return;
        }
    }

    final String e()
    {
        char c1;
        StringBuilder stringbuilder;
        c1 = d();
        if (c1 == 0)
        {
            return "";
        }
        stringbuilder = new StringBuilder(F);
        c1;
        JVM INSTR lookupswitch 3: default 60
    //                   8: 82
    //                   10: 71
    //                   32: 93;
           goto _L1 _L2 _L3 _L4
_L1:
        stringbuilder.append(c1);
_L6:
        return stringbuilder.toString();
_L3:
        stringbuilder.append(G);
        continue; /* Loop/switch isn't completed */
_L2:
        stringbuilder.append(H);
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append(I);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void e(boolean flag)
    {
        D = flag;
        o.c(false);
    }

    public final boolean expandActionView()
    {
        while (!n() || C != null && !C.onMenuItemActionExpand(this)) 
        {
            return false;
        }
        return o.c(this);
    }

    final boolean f()
    {
        return o.d() && d() != 0;
    }

    public final boolean g()
    {
        return (s & 4) != 0;
    }

    public final android.view.ActionProvider getActionProvider()
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final View getActionView()
    {
        if (A != null)
        {
            return A;
        }
        if (B != null)
        {
            A = B.onCreateActionView(this);
            return A;
        } else
        {
            return null;
        }
    }

    public final char getAlphabeticShortcut()
    {
        return l;
    }

    public final int getGroupId()
    {
        return e;
    }

    public final Drawable getIcon()
    {
        if (m != null)
        {
            return m;
        }
        if (n != 0)
        {
            Drawable drawable = TintManager.getDrawable(o.f(), n);
            n = 0;
            m = drawable;
            return drawable;
        } else
        {
            return null;
        }
    }

    public final Intent getIntent()
    {
        return j;
    }

    public final int getItemId()
    {
        return d;
    }

    public final android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return E;
    }

    public final char getNumericShortcut()
    {
        return k;
    }

    public final int getOrder()
    {
        return f;
    }

    public final SubMenu getSubMenu()
    {
        return p;
    }

    public final ActionProvider getSupportActionProvider()
    {
        return B;
    }

    public final CharSequence getTitle()
    {
        return h;
    }

    public final CharSequence getTitleCondensed()
    {
        CharSequence charsequence;
        Object obj;
        if (i != null)
        {
            charsequence = i;
        } else
        {
            charsequence = h;
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

    public final void h()
    {
        o.b(this);
    }

    public final boolean hasSubMenu()
    {
        return p != null;
    }

    public final boolean i()
    {
        return o.r();
    }

    public final boolean isActionViewExpanded()
    {
        return D;
    }

    public final boolean isCheckable()
    {
        return (s & 1) == 1;
    }

    public final boolean isChecked()
    {
        return (s & 2) == 2;
    }

    public final boolean isEnabled()
    {
        return (s & 0x10) != 0;
    }

    public final boolean isVisible()
    {
        if (B == null || !B.overridesItemVisibility()) goto _L2; else goto _L1
_L1:
        if ((s & 8) != 0 || !B.isVisible()) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if ((s & 8) != 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final boolean j()
    {
        return (s & 0x20) == 32;
    }

    public final boolean k()
    {
        return (z & 1) == 1;
    }

    public final boolean l()
    {
        return (z & 2) == 2;
    }

    public final boolean m()
    {
        return (z & 4) == 4;
    }

    public final boolean n()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if ((z & 8) != 0)
        {
            if (A == null && B != null)
            {
                A = B.onCreateActionView(this);
            }
            flag = flag1;
            if (A != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final MenuItem setActionProvider(android.view.ActionProvider actionprovider)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final MenuItem setActionView(int i1)
    {
        return a(i1);
    }

    public final MenuItem setActionView(View view)
    {
        return a(view);
    }

    public final MenuItem setAlphabeticShortcut(char c1)
    {
        if (l == c1)
        {
            return this;
        } else
        {
            l = Character.toLowerCase(c1);
            o.c(false);
            return this;
        }
    }

    public final MenuItem setCheckable(boolean flag)
    {
        int i1 = s;
        int j1 = s;
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s = flag1 | j1 & -2;
        if (i1 != s)
        {
            o.c(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean flag)
    {
        if ((s & 4) != 0)
        {
            o.a(this);
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
            s = s | 0x10;
        } else
        {
            s = s & 0xffffffef;
        }
        o.c(false);
        return this;
    }

    public final MenuItem setIcon(int i1)
    {
        m = null;
        n = i1;
        o.c(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable)
    {
        n = 0;
        m = drawable;
        o.c(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent)
    {
        j = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c1)
    {
        if (k == c1)
        {
            return this;
        } else
        {
            k = c1;
            o.c(false);
            return this;
        }
    }

    public final MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public final MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        r = onmenuitemclicklistener;
        return this;
    }

    public final MenuItem setShortcut(char c1, char c2)
    {
        k = c1;
        l = Character.toLowerCase(c2);
        o.c(false);
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
            z = i1;
            break;
        }
        o.b(this);
    }

    public final MenuItem setShowAsActionFlags(int i1)
    {
        return b(i1);
    }

    public final SupportMenuItem setSupportActionProvider(ActionProvider actionprovider)
    {
        if (B != null)
        {
            B.setVisibilityListener(null);
        }
        A = null;
        B = actionprovider;
        o.c(true);
        if (B != null)
        {
            B.setVisibilityListener(new _cls1());
        }
        return this;
    }

    public final SupportMenuItem setSupportOnActionExpandListener(android.support.v4.view.MenuItemCompat.OnActionExpandListener onactionexpandlistener)
    {
        C = onactionexpandlistener;
        return this;
    }

    public final MenuItem setTitle(int i1)
    {
        return setTitle(((CharSequence) (o.f().getString(i1))));
    }

    public final MenuItem setTitle(CharSequence charsequence)
    {
        h = charsequence;
        o.c(false);
        if (p != null)
        {
            p.setHeaderTitle(charsequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charsequence)
    {
        i = charsequence;
        o.c(false);
        return this;
    }

    public final MenuItem setVisible(boolean flag)
    {
        if (c(flag))
        {
            o.a(this);
        }
        return this;
    }

    public final String toString()
    {
        return h.toString();
    }

    /* member class not found */
    class _cls1 {}

}
