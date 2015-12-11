// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.j;
import com.offerup.android.a.ad;
import com.offerup.android.activities.k;
import com.offerup.android.b.a;
import com.offerup.android.dto.User;
import com.offerup.android.views.NonScrollListView;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.utils:
//            ay, y, z, ba, 
//            ab, ad, af, ah, 
//            aj

public final class x
{

    private DrawerLayout a;
    private k b;
    private com.offerup.android.activities.a c;
    private ay d;
    private Object e;
    private String f;
    private ad g;
    private boolean h;

    public x(k k1, com.offerup.android.activities.a a1, String s)
    {
        b = k1;
        f = s;
        c = a1;
        d = new ay(k1);
        e = new y(this, k1);
        com.offerup.android.b.a.getNonUIInstance().register(e);
    }

    static ad a(x x1)
    {
        return x1.g;
    }

    static boolean b(x x1)
    {
        return x1.h;
    }

    static k c(x x1)
    {
        return x1.b;
    }

    static DrawerLayout d(x x1)
    {
        return x1.a;
    }

    static com.offerup.android.activities.a e(x x1)
    {
        return x1.c;
    }

    static ay f(x x1)
    {
        return x1.d;
    }

    public final void a()
    {
        h = false;
    }

    public final boolean a(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 16908332: 
            if (a != null)
            {
                com.offerup.android.tracker.a.b("ou_actionbar_hamburger_click");
                a.b(0x800003);
                return true;
            } else
            {
                b.onBackPressed();
                return true;
            }

        case 2131755730: 
            com.offerup.android.tracker.a.d(f);
            c.c();
            return true;

        case 2131755753: 
            com.offerup.android.tracker.a.b("ou_actionbar_mylocation_click");
            c.b();
            return true;

        case 2131755752: 
            d.b();
            return true;
        }
    }

    public final void b()
    {
        int i = j.a().T();
        ActionBar actionbar = b.getSupportActionBar();
        if (i <= 0)
        {
            i = 0x7f020015;
        } else
        if (i == 1)
        {
            i = 0x7f020012;
        } else
        if (i == 2)
        {
            i = 0x7f020013;
        } else
        {
            i = 0x7f020014;
        }
        actionbar.setHomeAsUpIndicator(i);
    }

    public final void c()
    {
        h = true;
        a = (DrawerLayout)b.findViewById(0x7f100093);
        NavigationView navigationview = (NavigationView)b.findViewById(0x7f100096);
        String as[] = b.getResources().getStringArray(0x7f0f0002);
        View view = b.findViewById(0x7f1001d4);
        TextView textview = (TextView)navigationview.findViewById(0x7f100298);
        TextView textview1 = (TextView)navigationview.findViewById(0x7f100299);
        Object obj = (NonScrollListView)navigationview.findViewById(0x7f100294);
        g = new ad(b.getApplicationContext(), b.c());
        ((NonScrollListView) (obj)).setOnItemClickListener(new z(this, as));
        ((NonScrollListView) (obj)).setAdapter(g);
        View view1 = b.findViewById(0x7f10028f);
        obj = b.findViewById(0x7f10028d);
        if (!com.offerup.android.utils.ba.a())
        {
            view1.setVisibility(8);
            ((View) (obj)).setVisibility(0);
            ((TextView)navigationview.findViewById(0x7f10028e)).setOnClickListener(new ab(this));
        } else
        {
            view1.setVisibility(0);
            ((View) (obj)).setVisibility(8);
            obj = (ImageView)navigationview.findViewById(0x7f100290);
            TextView textview2 = (TextView)navigationview.findViewById(0x7f100291);
            User user = j.a().t();
            if (StringUtils.isNotEmpty(user.getEmail()) && StringUtils.isNotEmpty(user.getFirstName()))
            {
                textview2.setText(user.getFirstName());
                if (StringUtils.isNotEmpty(user.getAvatarSquare()))
                {
                    Picasso.with(b).load(user.getAvatarLarge()).into(((ImageView) (obj)));
                }
            }
        }
        if (j.a().p())
        {
            textview.setVisibility(0);
            textview.setOnClickListener(new com.offerup.android.utils.ad(this));
        } else
        {
            textview.setVisibility(8);
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            navigationview.findViewById(0x7f1001d2).setVisibility(0);
        }
        textview1.setOnClickListener(new af(this));
        if (com.offerup.android.utils.ba.a())
        {
            view1.setOnClickListener(new ah(this));
        }
        view.setOnClickListener(new aj(this));
        b.supportInvalidateOptionsMenu();
    }

    public final void d()
    {
        com.offerup.android.b.a.getNonUIInstance().unregister(e);
    }

    public final void e()
    {
        if (a != null && a.c(0x800003))
        {
            a.a();
        }
    }

    public final void f()
    {
        if (a != null && a.c(0x800003))
        {
            a.a();
            return;
        } else
        {
            c.m();
            b.finish();
            return;
        }
    }

    public final boolean g()
    {
        return a != null && a.c(0x800003);
    }

    public final void h()
    {
        if (a != null)
        {
            com.offerup.android.tracker.a.b("ou_actionbar_hamburger_click");
            a.b(0x800003);
        }
    }
}
