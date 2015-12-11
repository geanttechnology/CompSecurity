// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

// Referenced classes of package com.helpshift.app:
//            c, ActionBarHelperBase

public abstract class b
{

    protected Activity a;

    public b(Activity activity)
    {
        a = activity;
    }

    public static b a(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new c(activity);
        } else
        {
            return new ActionBarHelperBase(activity);
        }
    }

    public MenuInflater a(MenuInflater menuinflater)
    {
        return menuinflater;
    }

    public abstract void a(int i);

    public void a(Bundle bundle)
    {
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public abstract void a(MenuItem menuitem);

    public abstract void a(MenuItem menuitem, com.helpshift.j.c.a a1);

    public abstract void a(MenuItem menuitem, com.helpshift.j.c.c c1);

    public void a(MenuItem menuitem, String s)
    {
    }

    public abstract void a(String s);

    public abstract void a(boolean flag);

    public abstract String b(MenuItem menuitem);

    public abstract void b(int i);

    public void b(Bundle bundle)
    {
    }

    public abstract void b(boolean flag);

    public void c(int i)
    {
    }

    public abstract void c(MenuItem menuitem);
}
