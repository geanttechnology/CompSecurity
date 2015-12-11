// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.support.v7.internal.view.menu.n;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7:
//            cj, af, ba, ag

public class cd extends ActionMode
{
    public static class a
        implements cj.a
    {

        final android.view.ActionMode.Callback a;
        final Context b;
        final ArrayList c = new ArrayList();
        final ba d = new ba();

        private Menu a(Menu menu)
        {
            Menu menu2 = (Menu)d.get(menu);
            Menu menu1 = menu2;
            if (menu2 == null)
            {
                menu1 = n.a(b, (af)menu);
                d.put(menu, menu1);
            }
            return menu1;
        }

        private ActionMode b(cj cj1)
        {
            int j = c.size();
            for (int i = 0; i < j; i++)
            {
                cd cd1 = (cd)c.get(i);
                if (cd1 != null && cd1.b == cj1)
                {
                    return cd1;
                }
            }

            cj1 = new cd(b, cj1);
            c.add(cj1);
            return cj1;
        }

        public void a(cd cd1)
        {
            c.add(cd1);
        }

        public void a(cj cj1)
        {
            a.onDestroyActionMode(b(cj1));
        }

        public boolean a(cj cj1, Menu menu)
        {
            return a.onCreateActionMode(b(cj1), a(menu));
        }

        public boolean a(cj cj1, MenuItem menuitem)
        {
            return a.onActionItemClicked(b(cj1), n.a(b, (ag)menuitem));
        }

        public boolean b(cj cj1, Menu menu)
        {
            return a.onPrepareActionMode(b(cj1), a(menu));
        }

        public a(Context context, android.view.ActionMode.Callback callback)
        {
            b = context;
            a = callback;
        }
    }


    final Context a;
    final cj b;

    public cd(Context context, cj cj1)
    {
        a = context;
        b = cj1;
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
        return n.a(a, (af)b.b());
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
