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

public class f
    implements co
{

    final ActionBarActivityDelegateBase a;
    private co b;

    public f(ActionBarActivityDelegateBase actionbaractivitydelegatebase, co co1)
    {
        a = actionbaractivitydelegatebase;
        super();
        b = co1;
    }

    public void a(cn cn)
    {
        b.a(cn);
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
            catch (cn cn) { }
        }
        a.g = null;
    }

    public boolean a(cn cn, Menu menu)
    {
        return b.a(cn, menu);
    }

    public boolean a(cn cn, MenuItem menuitem)
    {
        return b.a(cn, menuitem);
    }

    public boolean b(cn cn, Menu menu)
    {
        return b.b(cn, menu);
    }
}
