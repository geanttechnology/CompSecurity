// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;

// Referenced classes of package com.helpshift.app:
//            e

public class d
    implements Menu
{

    private Resources a;
    private ArrayList b;

    public d(Context context)
    {
        a = context.getResources();
        b = new ArrayList();
    }

    private static int a(ArrayList arraylist, int i)
    {
        for (int j = arraylist.size() - 1; j >= 0; j--)
        {
            if (((MenuItem)arraylist.get(j)).getOrder() <= i)
            {
                return j + 1;
            }
        }

        return 0;
    }

    private MenuItem a(int i, int j, CharSequence charsequence)
    {
        charsequence = new e(this, i, j, charsequence);
        b.add(a(b, j), charsequence);
        return charsequence;
    }

    private void b(int i)
    {
        if (i < 0 || i >= b.size())
        {
            return;
        } else
        {
            b.remove(i);
            return;
        }
    }

    public int a(int i)
    {
        int k = size();
        for (int j = 0; j < k; j++)
        {
            if (((e)b.get(j)).getItemId() == i)
            {
                return j;
            }
        }

        return -1;
    }

    public Resources a()
    {
        return a;
    }

    public MenuItem add(int i)
    {
        return a(0, 0, a().getString(i));
    }

    public MenuItem add(int i, int j, int k, int l)
    {
        return a(j, k, a().getString(l));
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence)
    {
        return a(j, k, charsequence);
    }

    public MenuItem add(CharSequence charsequence)
    {
        return a(0, 0, charsequence);
    }

    public int addIntentOptions(int i, int j, int k, ComponentName componentname, Intent aintent[], Intent intent, int l, 
            MenuItem amenuitem[])
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public SubMenu addSubMenu(int i)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public SubMenu addSubMenu(int i, int j, int k, int l)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public SubMenu addSubMenu(int i, int j, int k, CharSequence charsequence)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public SubMenu addSubMenu(CharSequence charsequence)
    {
        return null;
    }

    public void clear()
    {
        b.clear();
    }

    public void close()
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public MenuItem findItem(int i)
    {
        int k = size();
        for (int j = 0; j < k; j++)
        {
            e e1 = (e)b.get(j);
            if (e1.getItemId() == i)
            {
                return e1;
            }
        }

        return null;
    }

    public MenuItem getItem(int i)
    {
        return (MenuItem)b.get(i);
    }

    public boolean hasVisibleItems()
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public boolean isShortcutKey(int i, KeyEvent keyevent)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public boolean performIdentifierAction(int i, int j)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public boolean performShortcut(int i, KeyEvent keyevent, int j)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public void removeGroup(int i)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public void removeItem(int i)
    {
        b(a(i));
    }

    public void setGroupCheckable(int i, boolean flag, boolean flag1)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public void setGroupEnabled(int i, boolean flag)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public void setGroupVisible(int i, boolean flag)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public void setQwertyMode(boolean flag)
    {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    public int size()
    {
        return b.size();
    }
}
