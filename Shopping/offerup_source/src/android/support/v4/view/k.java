// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            l, m

public abstract class k
{

    private l a;
    private m b;

    public k(Context context)
    {
    }

    public abstract View a();

    public View a(MenuItem menuitem)
    {
        return a();
    }

    public final void a(l l1)
    {
        a = l1;
    }

    public void a(m m)
    {
        if (b != null)
        {
            Log.w("ActionProvider(support)", (new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ")).append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?").toString());
        }
        b = m;
    }

    public void a(SubMenu submenu)
    {
    }

    public final void a(boolean flag)
    {
        if (a != null)
        {
            a.onSubUiVisibilityChanged(flag);
        }
    }

    public boolean b()
    {
        return false;
    }

    public boolean c()
    {
        return true;
    }

    public boolean d()
    {
        return false;
    }

    public boolean e()
    {
        return false;
    }

    public final void f()
    {
        b = null;
        a = null;
    }
}
