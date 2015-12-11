// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.q;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import com.helpshift.l;
import com.helpshift.s;
import com.helpshift.x;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.app:
//            b

public class c extends b
{

    private MenuItem b;
    private boolean c;
    private String d;
    private l e;
    private s f;

    public c(Activity activity)
    {
        super(activity);
        b = null;
        c = false;
    }

    private boolean a()
    {
        if (TextUtils.isEmpty(d))
        {
            d = a.getResources().getString(com.helpshift.b.g.aa);
        }
        return !d.equals("phone");
    }

    private boolean b()
    {
        Boolean boolean1;
        if (e == null || f == null)
        {
            e = new l(a);
            f = e.a;
        }
        boolean1 = Boolean.valueOf(false);
        boolean flag = f.r().optBoolean("enableDialogUIForTablets");
        boolean1 = Boolean.valueOf(flag);
_L2:
        return boolean1.booleanValue();
        JSONException jsonexception;
        jsonexception;
        x.b("HelpShiftDebug", "isDialogUIForTabletsEnabled : ", jsonexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void c(boolean flag)
    {
        if (b != null)
        {
            b.setVisible(flag);
        }
    }

    private boolean c()
    {
        return a.getIntent().getExtras().getBoolean("isRoot", false);
    }

    private boolean d()
    {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }

    public void a(int i)
    {
        a.requestWindowFeature(i);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        if (d())
        {
            menuinflater.inflate(com.helpshift.b.e.f, menu);
            b = menu.findItem(0x102000d);
            c(c);
        }
    }

    public void a(MenuItem menuitem)
    {
        if (menuitem.getActionView() instanceof SearchView)
        {
            q.c(menuitem);
        }
    }

    public void a(MenuItem menuitem, com.helpshift.j.a a1)
    {
        menuitem.setOnActionExpandListener(new android.view.MenuItem.OnActionExpandListener(a1) {

            final com.helpshift.j.a a;
            final c b;

            public boolean onMenuItemActionCollapse(MenuItem menuitem1)
            {
                return a.f();
            }

            public boolean onMenuItemActionExpand(MenuItem menuitem1)
            {
                return a.e();
            }

            
            {
                b = c.this;
                a = a1;
                super();
            }
        });
    }

    public void a(MenuItem menuitem, com.helpshift.j.c c1)
    {
        menuitem = menuitem.getActionView();
        if (menuitem instanceof SearchView)
        {
            ((SearchView)menuitem).setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener(c1) {

                final com.helpshift.j.c a;
                final c b;

                public boolean onQueryTextChange(String s1)
                {
                    return a.c(s1);
                }

                public boolean onQueryTextSubmit(String s1)
                {
                    return a.b(s1);
                }

            
            {
                b = c.this;
                a = c2;
                super();
            }
            });
        }
    }

    public void a(MenuItem menuitem, String s1)
    {
        menuitem = menuitem.getActionView();
        if (menuitem instanceof SearchView)
        {
            ((SearchView)menuitem).setQueryHint(s1);
        }
    }

    public void a(String s1)
    {
        a.getActionBar().setTitle(s1);
    }

    public void a(boolean flag)
    {
        if (a() && b())
        {
            a.getActionBar().setIcon(0x106000d);
            ActionBar actionbar = a.getActionBar();
            if (!c())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            actionbar.setDisplayHomeAsUpEnabled(flag);
            return;
        } else
        {
            a.getActionBar().setDisplayHomeAsUpEnabled(flag);
            return;
        }
    }

    public String b(MenuItem menuitem)
    {
        menuitem = menuitem.getActionView();
        if (menuitem instanceof SearchView)
        {
            return ((SearchView)menuitem).getQuery().toString();
        } else
        {
            return "";
        }
    }

    public void b(int i)
    {
        a.getActionBar().setNavigationMode(i);
    }

    public void b(boolean flag)
    {
        c = flag;
        if (d())
        {
            c(flag);
            return;
        } else
        {
            a.setProgressBarIndeterminateVisibility(flag);
            return;
        }
    }

    public void c(int i)
    {
        a.getActionBar().setIcon(i);
    }

    public void c(MenuItem menuitem)
    {
        if (menuitem.getActionView() != null)
        {
            menuitem.getActionView().clearFocus();
        }
    }
}
