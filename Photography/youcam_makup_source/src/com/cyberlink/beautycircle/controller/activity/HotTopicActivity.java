// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.e;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.o;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;
import java.util.Locale;

public class HotTopicActivity extends BaseArcMenuActivity
{

    private long o;
    private String p;
    private String q;
    private long r;
    private boolean s;
    private boolean t;
    private boolean u;

    public HotTopicActivity()
    {
        p = null;
        q = null;
        r = 0L;
    }

    public void a(boolean flag)
    {
        if (u)
        {
            b().a(0xc4000000, x.a, x.k, 0);
            return;
        } else
        {
            b().a(0x80000000, x.a, 0, 0);
            return;
        }
    }

    public boolean a(MotionEvent motionevent)
    {
        return ((o)e).a(motionevent);
    }

    public String d(String s1)
    {
        s1 = null;
        if (o > 0L)
        {
            s1 = String.format(Locale.getDefault(), "ybc://discover/%d", new Object[] {
                Long.valueOf(o)
            });
        }
        return s1;
    }

    protected boolean e()
    {
        b.a(new e(p, 0L, "back", s, ((o)e).n()));
        super.e();
        return false;
    }

    public void f(String s1)
    {
        q = s1;
        a(q);
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        if (e != null)
        {
            e.onActivityResult(i, l, intent);
        }
        if (i == 48150 && l == -1 && e != null)
        {
            e.i();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_hot_topic);
        r = System.currentTimeMillis();
        Intent intent = getIntent();
        String s1;
        boolean flag;
        if (intent != null)
        {
            s1 = intent.getStringExtra("CategoryName");
        } else
        {
            s1 = null;
        }
        q = s1;
        t = intent.getBooleanExtra("LoginCheck", false);
        u = intent.getBooleanExtra("BackToBC", false);
        if (intent != null)
        {
            flag = intent.getBooleanExtra("Slide", false);
        } else
        {
            flag = false;
        }
        s = flag;
        b(q);
        if (intent != null)
        {
            o = intent.getLongExtra("CategoryId", -1L);
            p = intent.getStringExtra("CategoryType");
        }
        if (bundle == null)
        {
            e = new o();
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, e).commit();
            ((o)e).s = s;
        }
        if (u)
        {
            b().a(0xc4000000, x.a, x.k, 0);
        } else
        {
            b().a(0xe4000000, x.a, x.g, 0);
        }
        b(bundle);
        if (t)
        {
            aq.c = "how_to";
            AccountManager.a(this, new com.cyberlink.beautycircle.utility.b() {

                final HotTopicActivity a;

                public void a()
                {
                    Globals.b("Get AccountToken Fail");
                }

                public void a(String s2)
                {
                    Globals.b("Get AccountToken Success");
                }

                public void b()
                {
                    Globals.b("Get AccountToken Cancel");
                }

            
            {
                a = HotTopicActivity.this;
                super();
            }
            });
        }
    }

    protected void onPause()
    {
        super.onPause();
        long l = System.currentTimeMillis();
        long l1 = r;
        b.a(new e(p, l - l1, "PageView", s, ((o)e).n()));
    }

    protected void onResume()
    {
        super.onResume();
        r = System.currentTimeMillis();
    }

    public void onRightBtnClick(View view)
    {
        if (u)
        {
            b.a(new e(p, 0L, "button_b", s, ((o)e).n()));
            c.a(this, "");
            finish();
            return;
        } else
        {
            b.a(new e(p, 0L, "createpost", s, ((o)e).n()));
            c.a(this, o, null, null, false, null, null, p);
            return;
        }
    }
}
