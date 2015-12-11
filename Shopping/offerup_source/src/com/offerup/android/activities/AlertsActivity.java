// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.e.a;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.bi;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.b.b;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;
import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.activities:
//            k, d, e, a, 
//            f

public class AlertsActivity extends k
    implements bi
{

    ListView a;
    com.offerup.android.a.a b;
    SwipeRefreshLayout c;
    int d;
    private Toolbar j;

    public AlertsActivity()
    {
    }

    static void a(AlertsActivity alertsactivity, boolean flag)
    {
        try
        {
            android.app.AlertDialog.Builder builder = n.c(alertsactivity);
            builder.setTitle(alertsactivity.getString(0x7f09017d));
            builder.setMessage(alertsactivity.getString(0x7f09017b));
            builder.setNegativeButton(alertsactivity.getString(0x7f090175), new d(alertsactivity));
            builder.setPositiveButton(alertsactivity.getString(0x7f090177), new e(alertsactivity, builder));
            n.a(builder);
            return;
        }
        catch (Exception exception)
        {
            g.a(alertsactivity, exception);
        }
    }

    private void b(boolean flag)
    {
        if (!ba.a())
        {
            f.a();
            return;
        }
        i();
        if (c.a())
        {
            c.setRefreshing(false);
        }
        if (flag || d == 0)
        {
            g = ProgressDialog.show(this, "", "Fetching your alerts");
        }
        android.support.v4.e.a.a(new f(this, (byte)0));
    }

    private void f()
    {
        try
        {
            e.k(0);
            supportInvalidateOptionsMenu();
            ((NotificationManager)getSystemService("notification")).cancel(101);
            return;
        }
        catch (Exception exception)
        {
            g.a(this, exception);
        }
    }

    public final void a()
    {
        f();
        b(true);
    }

    protected final void a(ActionBar actionbar)
    {
        super.a(actionbar);
        if (actionbar != null)
        {
            actionbar.setHomeAsUpIndicator(0x7f020015);
            actionbar.setTitle(getString(0x7f0900b2));
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(true);
        }
    }

    final String b()
    {
        return "alert";
    }

    public final int c()
    {
        return 2;
    }

    public void chatEventAvailable(b b1)
    {
        b(true);
    }

    public final boolean d()
    {
        return true;
    }

    public final int e()
    {
        return 0x7f110000;
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        if (i == 12)
        {
            f();
            b(true);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040019);
        a = (ListView)findViewById(0x7f100092);
        c = (SwipeRefreshLayout)findViewById(0x7f100091);
        c.setOnRefreshListener(this);
        c.setColorSchemeResources(new int[] {
            0x7f0e0050
        });
        j = (Toolbar)findViewById(0x7f100094);
        setSupportActionBar(j);
        a(getSupportActionBar());
    }

    public void onPause()
    {
        com.offerup.android.b.a.getInstance().unregister(this);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        f();
        com.offerup.android.b.a.getInstance().register(this);
        h();
        b(false);
    }
}
