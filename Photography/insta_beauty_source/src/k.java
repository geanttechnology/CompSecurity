// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.internal.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

public class k
    implements ef
{

    final ActionBarActivityDelegateBase a;
    private ef b;

    public k(ActionBarActivityDelegateBase actionbaractivitydelegatebase, ef ef1)
    {
        a = actionbaractivitydelegatebase;
        super();
        b = ef1;
    }

    public void a(ee ee)
    {
        b.a(ee);
        if (a.i != null)
        {
            a.a.getWindow().getDecorView().removeCallbacks(a.j);
            a.i.dismiss();
        } else
        if (a.h != null)
        {
            a.h.setVisibility(8);
            if (a.h.getParent() != null)
            {
                ViewCompat.requestApplyInsets((View)a.h.getParent());
            }
        }
        if (a.h != null)
        {
            a.h.removeAllViews();
        }
        if (a.a != null)
        {
            try
            {
                a.a.b(a.g);
            }
            // Misplaced declaration of an exception variable
            catch (ee ee) { }
        }
        a.g = null;
    }

    public boolean a(ee ee, Menu menu)
    {
        return b.a(ee, menu);
    }

    public boolean a(ee ee, MenuItem menuitem)
    {
        return b.a(ee, menuitem);
    }

    public boolean b(ee ee, Menu menu)
    {
        return b.b(ee, menu);
    }
}
