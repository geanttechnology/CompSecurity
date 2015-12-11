// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

public final class gv
    implements cj
{

    final int a;
    public gt b;
    int c;
    public int d;
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
    private hb o;
    private android.view.MenuItem.OnMenuItemClickListener p;
    private View q;
    private dm r;
    private boolean s;
    private android.view.ContextMenu.ContextMenuInfo t;

    gv(gt gt1, int i1, int j1, int k1, int l1, CharSequence charsequence, int i2)
    {
        n = 0;
        c = 16;
        d = 0;
        s = false;
        b = gt1;
        e = j1;
        f = i1;
        g = k1;
        a = l1;
        h = charsequence;
        d = i2;
    }

    private cj a(View view)
    {
        q = view;
        r = null;
        if (view != null && view.getId() == -1 && e > 0)
        {
            view.setId(e);
        }
        b.c();
        return this;
    }

    public final CharSequence a(ha ha1)
    {
        if (ha1 != null && ha1.a())
        {
            return getTitleCondensed();
        } else
        {
            return getTitle();
        }
    }

    final void a(hb hb1)
    {
        o = hb1;
        hb1.setHeaderTitle(getTitle());
    }

    final void a(boolean flag)
    {
        int i1 = c;
        int j1 = c;
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        c = byte0 | j1 & -3;
        if (i1 != c)
        {
            b.b(false);
        }
    }

    public final boolean a()
    {
        while (p != null && p.onMenuItemClick(this) || b.a(b.g(), this)) 
        {
            return true;
        }
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        b.a.startActivity(j);
        return true;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", activitynotfoundexception);
        return false;
    }

    public final char b()
    {
        if (b.a())
        {
            return l;
        } else
        {
            return k;
        }
    }

    final boolean b(boolean flag)
    {
        boolean flag1 = false;
        int i1 = c;
        int j1 = c;
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        c = byte0 | j1 & -9;
        flag = flag1;
        if (i1 != c)
        {
            flag = true;
        }
        return flag;
    }

    public final void c(boolean flag)
    {
        if (flag)
        {
            c = c | 0x20;
            return;
        } else
        {
            c = c & 0xffffffdf;
            return;
        }
    }

    public final boolean c()
    {
        return b.b() && b() != 0;
    }

    public final boolean collapseActionView()
    {
        if ((d & 8) == 0)
        {
            return false;
        }
        if (q == null)
        {
            return true;
        } else
        {
            return b.b(this);
        }
    }

    public final boolean d()
    {
        return (c & 4) != 0;
    }

    public final boolean e()
    {
        return (c & 0x20) == 32;
    }

    public final boolean expandActionView()
    {
        if (!h())
        {
            return false;
        } else
        {
            return b.a(this);
        }
    }

    public final boolean f()
    {
        return (d & 1) == 1;
    }

    public final boolean g()
    {
        return (d & 2) == 2;
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
        return f;
    }

    public final Drawable getIcon()
    {
        if (m != null)
        {
            return m;
        }
        if (n != 0)
        {
            Drawable drawable = hy.a(b.a, n);
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
        return e;
    }

    public final android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return t;
    }

    public final char getNumericShortcut()
    {
        return k;
    }

    public final int getOrder()
    {
        return g;
    }

    public final SubMenu getSubMenu()
    {
        return o;
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

    public final boolean h()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if ((d & 8) != 0)
        {
            View view = q;
            flag = flag1;
            if (q != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final boolean hasSubMenu()
    {
        return o != null;
    }

    public final boolean isActionViewExpanded()
    {
        return s;
    }

    public final boolean isCheckable()
    {
        return (c & 1) == 1;
    }

    public final boolean isChecked()
    {
        return (c & 2) == 2;
    }

    public final boolean isEnabled()
    {
        return (c & 0x10) != 0;
    }

    public final boolean isVisible()
    {
        return (c & 8) == 0;
    }

    public final MenuItem setActionProvider(ActionProvider actionprovider)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final MenuItem setActionView(int i1)
    {
        Context context = b.a;
        a(LayoutInflater.from(context).inflate(i1, new LinearLayout(context), false));
        return this;
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
            b.b(false);
            return this;
        }
    }

    public final MenuItem setCheckable(boolean flag)
    {
        int i1 = c;
        int j1 = c;
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        c = flag1 | j1 & -2;
        if (i1 != c)
        {
            b.b(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean flag)
    {
        if ((c & 4) != 0)
        {
            gt gt1 = b;
            int j1 = getGroupId();
            int k1 = gt1.b.size();
            int i1 = 0;
            while (i1 < k1) 
            {
                gv gv1 = (gv)gt1.b.get(i1);
                if (gv1.getGroupId() == j1 && gv1.d() && gv1.isCheckable())
                {
                    if (gv1 == this)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    gv1.a(flag);
                }
                i1++;
            }
        } else
        {
            a(flag);
        }
        return this;
    }

    public final MenuItem setEnabled(boolean flag)
    {
        if (flag)
        {
            c = c | 0x10;
        } else
        {
            c = c & 0xffffffef;
        }
        b.b(false);
        return this;
    }

    public final MenuItem setIcon(int i1)
    {
        m = null;
        n = i1;
        b.b(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable)
    {
        n = 0;
        m = drawable;
        b.b(false);
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
            b.b(false);
            return this;
        }
    }

    public final MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public final MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        p = onmenuitemclicklistener;
        return this;
    }

    public final MenuItem setShortcut(char c1, char c2)
    {
        k = c1;
        l = Character.toLowerCase(c2);
        b.b(false);
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
            d = i1;
            break;
        }
        b.c();
    }

    public final MenuItem setShowAsActionFlags(int i1)
    {
        setShowAsAction(i1);
        return this;
    }

    public final MenuItem setTitle(int i1)
    {
        return setTitle(((CharSequence) (b.a.getString(i1))));
    }

    public final MenuItem setTitle(CharSequence charsequence)
    {
        h = charsequence;
        b.b(false);
        if (o != null)
        {
            o.setHeaderTitle(charsequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charsequence)
    {
        i = charsequence;
        if (charsequence == null)
        {
            charsequence = h;
        }
        b.b(false);
        return this;
    }

    public final MenuItem setVisible(boolean flag)
    {
        if (b(flag))
        {
            gt gt1 = b;
            gt1.c = true;
            gt1.b(true);
        }
        return this;
    }

    public final String toString()
    {
        return h.toString();
    }
}
