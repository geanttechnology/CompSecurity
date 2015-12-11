// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.f.j;
import android.support.v7.d.a;
import android.support.v7.internal.view.menu.n;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class d extends ActionMode
{
    public static class a
        implements android.support.v7.d.a.a
    {

        final android.view.ActionMode.Callback a;
        final Context b;
        final ArrayList c = new ArrayList();
        final j d = new j();

        private Menu a(Menu menu)
        {
            Menu menu2 = (Menu)d.get(menu);
            Menu menu1 = menu2;
            if (menu2 == null)
            {
                menu1 = n.a(b, (android.support.v4.c.a.a)menu);
                d.put(menu, menu1);
            }
            return menu1;
        }

        private ActionMode b(android.support.v7.d.a a1)
        {
            int k = c.size();
            for (int i = 0; i < k; i++)
            {
                d d1 = (d)c.get(i);
                if (d1 != null && d1.b == a1)
                {
                    return d1;
                }
            }

            a1 = new d(b, a1);
            c.add(a1);
            return a1;
        }

        public void a(android.support.v7.d.a a1)
        {
            a.onDestroyActionMode(b(a1));
        }

        public void a(d d1)
        {
            c.add(d1);
        }

        public boolean a(android.support.v7.d.a a1, Menu menu)
        {
            return a.onCreateActionMode(b(a1), a(menu));
        }

        public boolean a(android.support.v7.d.a a1, MenuItem menuitem)
        {
            return a.onActionItemClicked(b(a1), n.a(b, (b)menuitem));
        }

        public boolean b(android.support.v7.d.a a1, Menu menu)
        {
            return a.onPrepareActionMode(b(a1), a(menu));
        }

        public a(Context context, android.view.ActionMode.Callback callback)
        {
            b = context;
            a = callback;
        }
    }


    final Context a;
    final android.support.v7.d.a b;

    public d(Context context, android.support.v7.d.a a1)
    {
        a = context;
        b = a1;
    }

    public void finish()
    {
        b.c();
    }

    public View getCustomView()
    {
        return b.i();
    }

    public Menu getMenu()
    {
        return n.a(a, (android.support.v4.c.a.a)b.b());
    }

    public MenuInflater getMenuInflater()
    {
        return b.a();
    }

    public CharSequence getSubtitle()
    {
        return b.g();
    }

    public Object getTag()
    {
        return b.j();
    }

    public CharSequence getTitle()
    {
        return b.f();
    }

    public boolean getTitleOptionalHint()
    {
        return b.k();
    }

    public void invalidate()
    {
        b.d();
    }

    public boolean isTitleOptional()
    {
        return b.h();
    }

    public void setCustomView(View view)
    {
        b.a(view);
    }

    public void setSubtitle(int i)
    {
        b.b(i);
    }

    public void setSubtitle(CharSequence charsequence)
    {
        b.a(charsequence);
    }

    public void setTag(Object obj)
    {
        b.a(obj);
    }

    public void setTitle(int i)
    {
        b.a(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        b.b(charsequence);
    }

    public void setTitleOptionalHint(boolean flag)
    {
        b.a(flag);
    }
}
