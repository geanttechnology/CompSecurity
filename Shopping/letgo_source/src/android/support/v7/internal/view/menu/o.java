// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.af;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

// Referenced classes of package android.support.v7.internal.view.menu:
//            c

class o extends c
    implements Menu
{

    o(Context context, af af1)
    {
        super(context, af1);
    }

    public MenuItem add(int i)
    {
        return a(((af)b).add(i));
    }

    public MenuItem add(int i, int j, int k, int l)
    {
        return a(((af)b).add(i, j, k, l));
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence)
    {
        return a(((af)b).add(i, j, k, charsequence));
    }

    public MenuItem add(CharSequence charsequence)
    {
        return a(((af)b).add(charsequence));
    }

    public int addIntentOptions(int i, int j, int k, ComponentName componentname, Intent aintent[], Intent intent, int l, 
            MenuItem amenuitem[])
    {
        MenuItem amenuitem1[] = null;
        if (amenuitem != null)
        {
            amenuitem1 = new MenuItem[amenuitem.length];
        }
        j = ((af)b).addIntentOptions(i, j, k, componentname, aintent, intent, l, amenuitem1);
        if (amenuitem1 != null)
        {
            i = 0;
            for (k = amenuitem1.length; i < k; i++)
            {
                amenuitem[i] = a(amenuitem1[i]);
            }

        }
        return j;
    }

    public SubMenu addSubMenu(int i)
    {
        return a(((af)b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int j, int k, int l)
    {
        return a(((af)b).addSubMenu(i, j, k, l));
    }

    public SubMenu addSubMenu(int i, int j, int k, CharSequence charsequence)
    {
        return a(((af)b).addSubMenu(i, j, k, charsequence));
    }

    public SubMenu addSubMenu(CharSequence charsequence)
    {
        return a(((af)b).addSubMenu(charsequence));
    }

    public void clear()
    {
        a();
        ((af)b).clear();
    }

    public void close()
    {
        ((af)b).close();
    }

    public MenuItem findItem(int i)
    {
        return a(((af)b).findItem(i));
    }

    public MenuItem getItem(int i)
    {
        return a(((af)b).getItem(i));
    }

    public boolean hasVisibleItems()
    {
        return ((af)b).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyevent)
    {
        return ((af)b).isShortcutKey(i, keyevent);
    }

    public boolean performIdentifierAction(int i, int j)
    {
        return ((af)b).performIdentifierAction(i, j);
    }

    public boolean performShortcut(int i, KeyEvent keyevent, int j)
    {
        return ((af)b).performShortcut(i, keyevent, j);
    }

    public void removeGroup(int i)
    {
        a(i);
        ((af)b).removeGroup(i);
    }

    public void removeItem(int i)
    {
        b(i);
        ((af)b).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean flag, boolean flag1)
    {
        ((af)b).setGroupCheckable(i, flag, flag1);
    }

    public void setGroupEnabled(int i, boolean flag)
    {
        ((af)b).setGroupEnabled(i, flag);
    }

    public void setGroupVisible(int i, boolean flag)
    {
        ((af)b).setGroupVisible(i, flag);
    }

    public void setQwertyMode(boolean flag)
    {
        ((af)b).setQwertyMode(flag);
    }

    public int size()
    {
        return ((af)b).size();
    }
}
