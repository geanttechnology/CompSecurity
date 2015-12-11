// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.a.au;
import com.offerup.android.dto.Item;
import com.offerup.android.g.u;
import com.offerup.android.g.w;
import com.offerup.android.network.UserRelationService;
import com.offerup.android.network.UserService;
import com.offerup.android.network.o;
import com.offerup.android.tracker.d;
import com.offerup.android.utils.am;
import com.offerup.android.utils.av;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.c;
import com.offerup.android.utils.n;
import e.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.activities:
//            k, ij, ii, if, 
//            ig, ih, ik, is, 
//            in, io, ip, a

public class UserDetailActivity extends k
    implements w
{

    private StaggeredGridLayoutManager a;
    private RecyclerView b;
    private au c;
    private TextView d;
    private TextView j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private TextView p;
    private String q;
    private boolean r;
    private boolean s;
    private boolean t;
    private long u;
    private String v;
    private u w;
    private Toolbar x;
    private boolean y;
    private boolean z;

    public UserDetailActivity()
    {
        y = false;
    }

    static String a(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.v;
    }

    static String a(UserDetailActivity userdetailactivity, String s1)
    {
        userdetailactivity.v = s1;
        return s1;
    }

    private void a(Intent intent)
    {
        a(intent.getExtras());
    }

    private void a(Bundle bundle)
    {
        u = bundle.getLong("userId", 0L);
        y = bundle.getBoolean("activity_started_externally");
    }

    static void a(UserDetailActivity userdetailactivity, List list)
    {
        try
        {
            userdetailactivity.c.a();
            userdetailactivity.c.a(list);
            userdetailactivity.c.notifyDataSetChanged();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            com.b.a.a.g.a(userdetailactivity, list);
        }
    }

    static boolean a(UserDetailActivity userdetailactivity, boolean flag)
    {
        userdetailactivity.t = flag;
        return flag;
    }

    static long b(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.u;
    }

    static String b(UserDetailActivity userdetailactivity, String s1)
    {
        userdetailactivity.q = s1;
        return s1;
    }

    static void b(UserDetailActivity userdetailactivity, boolean flag)
    {
        if (flag)
        {
            userdetailactivity.d.setVisibility(0);
            userdetailactivity.j.setVisibility(8);
            userdetailactivity.s = false;
            return;
        } else
        {
            userdetailactivity.j.setVisibility(0);
            userdetailactivity.d.setVisibility(8);
            userdetailactivity.s = true;
            return;
        }
    }

    static boolean c(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.t;
    }

    static TextView d(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.p;
    }

    static void e(UserDetailActivity userdetailactivity)
    {
        userdetailactivity.g();
    }

    static u f(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.w;
    }

    private void f()
    {
        if (u > 0L && com.b.a.a.j.a().n() == u)
        {
            r = true;
        }
        a(0x7f09013c);
        long l1 = u;
        Object obj = com.offerup.android.network.o.e(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor())).getUsersListedItems(l1);
        l1 = u;
        e.a.a(((a) (obj)), com.offerup.android.network.o.e(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor())).getUserInformation(l1), new ij(this)).b(e.g.j.b()).a(e.a.b.a.a()).b(new ii(this));
        obj = getLayoutInflater().inflate(0x7f0400d6, null);
        j = (TextView)((View) (obj)).findViewById(0x7f1002c7);
        d = (TextView)((View) (obj)).findViewById(0x7f1002c8);
        w = new u();
        getSupportFragmentManager().a().a(0x7f1000ec, w).b();
        AppBarLayout appbarlayout = (AppBarLayout)findViewById(0x7f10014d);
        appbarlayout.a(new if(this, (CollapsingToolbarLayout)findViewById(0x7f10014e)));
        appbarlayout.setExpanded(true);
        k = findViewById(0x7f1002c9);
        l = findViewById(0x7f1002ca);
        m = findViewById(0x7f1002d0);
        n = findViewById(0x7f1002cf);
        o = findViewById(0x7f1002ce);
        p = (TextView)findViewById(0x7f1002cb);
        p = (TextView)findViewById(0x7f1002cb);
        b = (RecyclerView)findViewById(0x7f100150);
        a = new StaggeredGridLayoutManager(getResources().getInteger(0x7f0d0003), 1);
        b.setLayoutManager(a);
        b.setHasFixedSize(true);
        ((View) (obj)).setLayoutParams(a.generateDefaultLayoutParams());
        c = new au(this, new ArrayList());
        c.a(((View) (obj)));
        b.setAdapter(c);
        if (!ba.a())
        {
            d.setVisibility(8);
            j.setVisibility(8);
            return;
        }
        if (r)
        {
            d.setVisibility(8);
            j.setVisibility(8);
            return;
        } else
        {
            n();
            j.setOnClickListener(new ig(this));
            d.setOnClickListener(new ih(this));
            return;
        }
    }

    private void g()
    {
        if (t)
        {
            k.setVisibility(0);
            k.setOnClickListener(new ik(this));
            return;
        } else
        {
            k.setVisibility(8);
            k.setOnClickListener(null);
            n.setOnClickListener(null);
            return;
        }
    }

    static boolean g(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.z;
    }

    static void h(UserDetailActivity userdetailactivity)
    {
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(userdetailactivity, 0x7f050018);
        userdetailactivity.l.setVisibility(0);
        userdetailactivity.m.setVisibility(0);
        userdetailactivity.l.setAnimation(animation);
        userdetailactivity.m.setAnimation(animation);
        userdetailactivity.z = true;
    }

    static View i(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.o;
    }

    static void j(UserDetailActivity userdetailactivity)
    {
        userdetailactivity.m();
    }

    static View k(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.n;
    }

    static void l(UserDetailActivity userdetailactivity)
    {
        userdetailactivity.o();
    }

    private void m()
    {
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, 0x7f050019);
        l.setVisibility(8);
        m.setVisibility(8);
        l.setAnimation(animation);
        m.setAnimation(animation);
        z = false;
    }

    static boolean m(UserDetailActivity userdetailactivity)
    {
        return userdetailactivity.s;
    }

    private void n()
    {
        if (u > 0L && ba.a())
        {
            com.offerup.android.network.o.b(com.offerup.android.network.o.c(Executors.newCachedThreadPool())).getUserRelationship(u, new is(this, (byte)0));
        }
    }

    private void o()
    {
        if (!android.support.v4.e.a.b(this))
        {
            android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.b(this);
            builder.setPositiveButton(getString(0x7f090177), new in(this));
            builder.setNegativeButton(getString(0x7f090175), new io(this));
            com.offerup.android.utils.n.a(builder);
            return;
        } else
        {
            g = ProgressDialog.show(this, "", "Please wait");
            long l1 = u;
            ip ip1 = new ip(this, (byte)0);
            com.offerup.android.network.o.b(com.offerup.android.network.o.c(Executors.newCachedThreadPool())).createReport("user", l1, ip1);
            return;
        }
    }

    public final void a()
    {
    }

    protected final void a(ActionBar actionbar)
    {
        super.a(actionbar);
        if (actionbar != null)
        {
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    final String b()
    {
        return "profile_not_self";
    }

    public final void b(int i1)
    {
        f.a((Item)c.a(i1), "profile_not_self");
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (z)
        {
            int ai1[] = new int[2];
            int ai[] = new int[2];
            Rect rect1 = new Rect(ai1[0], ai1[1], ai1[0] + l.getWidth(), ai1[1] + l.getHeight());
            l.getGlobalVisibleRect(rect1);
            Rect rect = new Rect(ai[0], ai[1], ai[0] + k.getWidth(), ai[1] + k.getHeight());
            k.getGlobalVisibleRect(rect);
            if (!rect1.contains((int)motionevent.getRawX(), (int)motionevent.getRawY()) && !rect.contains((int)motionevent.getRawX(), (int)motionevent.getRawY()))
            {
                m();
            }
        }
        return super.dispatchTouchEvent(motionevent);
    }

    public final int e()
    {
        return !r ? 0x7f110012 : 0x7f110013;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 545)
        {
            q = null;
            n();
        }
    }

    public void onBackPressed()
    {
        com.offerup.android.tracker.a.b("UserProfile_Back-Button_click");
        if (y)
        {
            l();
            y = false;
            f.d();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040040);
        x = (Toolbar)findViewById(0x7f100094);
        setSupportActionBar(x);
        a(getSupportActionBar());
        if (bundle != null)
        {
            a(bundle);
        } else
        {
            a(getIntent());
        }
        f();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        if (a != null)
        {
            a.scrollToPositionWithOffset(0, 0);
        }
        List list = getSupportFragmentManager().d();
        if (list != null && list.size() > 0)
        {
            int i1 = 0;
            while (i1 < list.size()) 
            {
                try
                {
                    Fragment fragment = (Fragment)list.get(i1);
                    getSupportFragmentManager().a().a(fragment).b();
                }
                catch (Exception exception)
                {
                    com.b.a.a.g.a(this, exception);
                }
                i1++;
            }
        }
        r = false;
        u = 0L;
        q = null;
        v = null;
        y = false;
        if (c != null && c.getItemCount() > 0)
        {
            c.a();
            c.notifyDataSetChanged();
        }
        a(intent);
        f();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        d d1;
        long l1;
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755759: 
            f.e();
            return true;

        case 2131755758: 
            menuitem = getApplicationContext();
            d1 = d.b;
            l1 = u;
            break;
        }
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("content_type", d1.toString().toLowerCase());
            jsonobject.put("content_id", String.valueOf(l1));
            av.a("UserProfile_ReportUser-Button_click", jsonobject);
            com.offerup.android.utils.c.a(menuitem, "UserProfile_ReportUser-Button_click");
            am.a("UserProfile_ReportUser-Button_click", jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (MenuItem menuitem)
        {
            com.b.a.a.g.a("ReportingTracker", menuitem);
        }
        if (StringUtils.isNotEmpty(q))
        {
            f.b(q, u);
            return true;
        } else
        {
            o();
            return true;
        }
    }

    protected void onPostResume()
    {
        super.onPostResume();
        g();
    }
}
