// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.a.b;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.pf.common.restart.RestartService;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            v, AboutActivity

public class TestSettingActivity extends BaseActivity
{

    private android.view.View.OnClickListener A;
    private android.view.View.OnClickListener B;
    private View a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private View f;
    private EditText g;
    private TextView h;
    private View i;
    private TextView j;
    private View k;
    private Button l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private boolean s;
    private boolean t;
    private String u;
    private String v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;
    private android.view.View.OnClickListener y;
    private android.view.View.OnClickListener z;

    public TestSettingActivity()
    {
        t = true;
        u = "Yes";
        v = "No";
        w = new android.view.View.OnClickListener() {

            final TestSettingActivity a;

            public void onClick(View view)
            {
                TestSettingActivity.a(a, TestSettingActivity.a(a).getText().toString());
                TestSettingActivity.a(a, com.cyberlink.youcammakeup.activity.TestSettingActivity.b(a, com.cyberlink.youcammakeup.activity.TestSettingActivity.b(a)));
                TestSettingActivity.a(a).setText(com.cyberlink.youcammakeup.activity.TestSettingActivity.b(a));
            }

            
            {
                a = TestSettingActivity.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            final TestSettingActivity a;

            public void onClick(View view)
            {
                TestSettingActivity.c(a, TestSettingActivity.c(a).getText().toString());
                TestSettingActivity.c(a, com.cyberlink.youcammakeup.activity.TestSettingActivity.b(a, TestSettingActivity.d(a)));
                TestSettingActivity.c(a).setText(TestSettingActivity.d(a));
            }

            
            {
                a = TestSettingActivity.this;
                super();
            }
        };
        y = new android.view.View.OnClickListener() {

            final TestSettingActivity a;

            public void onClick(View view)
            {
                TestSettingActivity.d(a, TestSettingActivity.e(a).getText().toString());
                TestSettingActivity.d(a, com.cyberlink.youcammakeup.activity.TestSettingActivity.b(a, TestSettingActivity.f(a)));
                TestSettingActivity.e(a).setText(TestSettingActivity.f(a));
            }

            
            {
                a = TestSettingActivity.this;
                super();
            }
        };
        z = new android.view.View.OnClickListener() {

            final TestSettingActivity a;

            public void onClick(View view)
            {
                a.f();
            }

            
            {
                a = TestSettingActivity.this;
                super();
            }
        };
        A = new android.view.View.OnClickListener() {

            final TestSettingActivity a;

            public void onClick(View view)
            {
                TestSettingActivity.g(a);
            }

            
            {
                a = TestSettingActivity.this;
                super();
            }
        };
        B = new android.view.View.OnClickListener() {

            final TestSettingActivity a;

            public void onClick(View view)
            {
                TestSettingActivity.h(a);
            }

            
            {
                a = TestSettingActivity.this;
                super();
            }
        };
    }

    static TextView a(TestSettingActivity testsettingactivity)
    {
        return testsettingactivity.e;
    }

    static String a(TestSettingActivity testsettingactivity, String s1)
    {
        testsettingactivity.o = s1;
        return s1;
    }

    private boolean a(String s1)
    {
        return s1 != null && s1.equals(u);
    }

    static String b(TestSettingActivity testsettingactivity)
    {
        return testsettingactivity.o;
    }

    static String b(TestSettingActivity testsettingactivity, String s1)
    {
        return testsettingactivity.b(s1);
    }

    private String b(String s1)
    {
        if (s1.equals(u))
        {
            return v;
        } else
        {
            return u;
        }
    }

    static TextView c(TestSettingActivity testsettingactivity)
    {
        return testsettingactivity.h;
    }

    static String c(TestSettingActivity testsettingactivity, String s1)
    {
        testsettingactivity.q = s1;
        return s1;
    }

    static String d(TestSettingActivity testsettingactivity)
    {
        return testsettingactivity.q;
    }

    static String d(TestSettingActivity testsettingactivity, String s1)
    {
        testsettingactivity.r = s1;
        return s1;
    }

    static TextView e(TestSettingActivity testsettingactivity)
    {
        return testsettingactivity.j;
    }

    static String f(TestSettingActivity testsettingactivity)
    {
        return testsettingactivity.r;
    }

    static void g(TestSettingActivity testsettingactivity)
    {
        testsettingactivity.l();
    }

    static void h(TestSettingActivity testsettingactivity)
    {
        testsettingactivity.o();
    }

    static void i(TestSettingActivity testsettingactivity)
    {
        testsettingactivity.m();
    }

    private void j()
    {
        u = getResources().getString(0x7f0706cb);
        v = getResources().getString(0x7f0706ca);
        a = findViewById(0x7f0c01b9);
        a.setOnClickListener(z);
        b = findViewById(0x7f0c01cb);
        b.setOnClickListener(A);
        c = (TextView)findViewById(0x7f0c01bd);
        m = com.cyberlink.youcammakeup.widgetpool.a.b.a().c();
        c.setText(m);
        d = (TextView)findViewById(0x7f0c01c0);
        n = NetworkManager.d();
        d.setText(n);
        e = (TextView)findViewById(0x7f0c01c2);
        Object obj;
        v v1;
        if (NetworkManager.e())
        {
            obj = u;
        } else
        {
            obj = v;
        }
        o = ((String) (obj));
        e.setText(o);
        f = findViewById(0x7f0c01c1);
        f.setOnClickListener(w);
        g = (EditText)findViewById(0x7f0c01c4);
        p = TestConfigHelper.h().j();
        g.setText(p);
        h = (TextView)findViewById(0x7f0c01c6);
        if (TestConfigHelper.h().k())
        {
            obj = u;
        } else
        {
            obj = v;
        }
        q = ((String) (obj));
        h.setText(q);
        i = findViewById(0x7f0c01c5);
        i.setOnClickListener(x);
        j = (TextView)findViewById(0x7f0c01c8);
        if (TestConfigHelper.h().l())
        {
            obj = u;
        } else
        {
            obj = v;
        }
        r = ((String) (obj));
        j.setText(r);
        k = findViewById(0x7f0c01c7);
        k.setOnClickListener(y);
        obj = findViewById(0x7f0c01c9);
        v1 = new v(this);
        if (v1.a())
        {
            ((View) (obj)).setOnClickListener(v1);
        } else
        {
            ((View) (obj)).setVisibility(8);
        }
        l = (Button)findViewById(0x7f0c01ca);
        l.setOnClickListener(B);
        s = TestConfigHelper.h().d();
        l.setEnabled(s);
    }

    private void k()
    {
        com.pf.common.utility.m.b("TEST_SETTING", "updateEvent");
        TestConfigHelper.h().g();
        m = com.cyberlink.youcammakeup.widgetpool.a.b.a().c();
        c.setText(m);
        n = NetworkManager.d();
        d.setText(n);
        String s1;
        if (NetworkManager.e())
        {
            s1 = u;
        } else
        {
            s1 = v;
        }
        o = s1;
        e.setText(o);
        p = TestConfigHelper.h().j();
        g.setText(p);
        if (TestConfigHelper.h().l())
        {
            s1 = u;
        } else
        {
            s1 = v;
        }
        r = s1;
        j.setText(r);
        s = TestConfigHelper.h().d();
        l.setEnabled(s);
    }

    private void l()
    {
        boolean flag = a(e.getText().toString());
        TestConfigHelper.h().a(flag);
        p = g.getText().toString();
        TestConfigHelper.h().a(p);
        flag = a(h.getText().toString());
        TestConfigHelper.h().b(flag);
        flag = a(j.getText().toString());
        TestConfigHelper.h().c(flag);
        TestConfigHelper.h().m();
        n();
    }

    private void m()
    {
        TestConfigHelper.h().f();
        n();
    }

    private void n()
    {
        Globals.d().H();
        finish();
        RestartService.a(getApplicationContext(), "New setting applied!");
    }

    private void o()
    {
        Globals.d().i().c(this);
        Object obj = getString(0x7f0706c8);
        Globals.d().i().b(x.a, ((String) (obj)));
        obj = new y(true, true, true, true, getString(0x7f0703fd), getString(0x7f0703fa));
        Globals.d().i().a(((y) (obj)));
        Globals.d().i().a(new w() {

            final TestSettingActivity a;

            public void a(boolean flag)
            {
                Globals.d().i().i(a);
                TestSettingActivity.i(a);
            }

            public void b(boolean flag)
            {
                Globals.d().i().i(a);
            }

            
            {
                a = TestSettingActivity.this;
                super();
            }
        });
    }

    public boolean e()
    {
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/AboutActivity));
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        com.pf.common.utility.m.b("TEST_SETTING", "onCreate");
        super.onCreate(bundle);
        setContentView(0x7f030020);
        j();
        t = false;
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            f();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("testSettingPage");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
        com.pf.common.utility.m.b("TEST_SETTING", "onResume");
        if (t)
        {
            k();
        }
        t = true;
    }
}
