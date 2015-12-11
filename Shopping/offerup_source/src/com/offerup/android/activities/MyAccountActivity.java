// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.b.a;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.jumio.netverify.sdk.NetverifySDK;
import com.offerup.android.g.u;
import com.offerup.android.g.w;
import com.offerup.android.network.b;
import com.offerup.android.utils.ay;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Referenced classes of package com.offerup.android.activities:
//            k, dc, db, cz, 
//            da, cy, a, ProfileImageActivity, 
//            de, cv, cw, cx, 
//            dd

public class MyAccountActivity extends k
    implements w
{

    private View a;
    private View b;
    private View c;
    private View d;
    private TextView j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private Toolbar r;
    private ay s;
    private u t;
    private boolean u;

    public MyAccountActivity()
    {
    }

    static void a(MyAccountActivity myaccountactivity)
    {
        android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(myaccountactivity);
        builder.setTitle(myaccountactivity.getString(0x7f090151)).setMessage(myaccountactivity.getString(0x7f090150)).setCancelable(false).setPositiveButton(myaccountactivity.getString(0x7f09014f), new dc(myaccountactivity)).setNegativeButton(myaccountactivity.getString(0x7f0900da), new db(myaccountactivity));
        com.offerup.android.utils.n.a(builder);
    }

    static boolean a(MyAccountActivity myaccountactivity, boolean flag)
    {
        myaccountactivity.u = false;
        return false;
    }

    static void b(MyAccountActivity myaccountactivity)
    {
        myaccountactivity.m();
    }

    private void f()
    {
        switch (ba.c())
        {
        default:
            com.b.a.a.g.a(this, new Throwable("TruYou status received is not recognized."));
            return;

        case 0: // '\0'
            if (!NetverifySDK.isSupportedPlatform())
            {
                k.setVisibility(8);
                return;
            } else
            {
                l.setVisibility(0);
                m.setVisibility(0);
                n.setVisibility(8);
                o.setVisibility(8);
                l.setOnClickListener(new cz(this));
                m.setOnClickListener(new da(this));
                return;
            }

        case 1: // '\001'
            n.setVisibility(0);
            l.setVisibility(8);
            m.setVisibility(8);
            o.setVisibility(8);
            return;

        case 2: // '\002'
            o.setVisibility(0);
            n.setVisibility(8);
            l.setVisibility(8);
            m.setVisibility(8);
            return;
        }
    }

    private void g()
    {
        if (e.b() && e.p())
        {
            c.setVisibility(0);
            d.setVisibility(0);
            c.setOnClickListener(new cy(this));
            return;
        } else
        {
            c.setVisibility(8);
            d.setVisibility(8);
            return;
        }
    }

    private void m()
    {
        com.offerup.android.dto.User user = e.t();
        if (!u)
        {
            t.a(ba.a(user));
            u = true;
        }
        f();
        g();
    }

    private boolean n()
    {
        int i;
        try
        {
            AppOpsManager appopsmanager = (AppOpsManager)getApplicationContext().getSystemService("appops");
            Object obj = getApplicationContext().getApplicationInfo();
            String s1 = getApplicationContext().getPackageName();
            i = ((ApplicationInfo) (obj)).uid;
            obj = Class.forName(android/app/AppOpsManager.getName());
            i = ((Integer)((Class) (obj)).getMethod("checkOpNoThrow", new Class[] {
                Integer.TYPE, Integer.TYPE, java/lang/String
            }).invoke(appopsmanager, new Object[] {
                Integer.valueOf(((Integer)((Class) (obj)).getDeclaredField("OP_POST_NOTIFICATION").get(java/lang/Integer)).intValue()), Integer.valueOf(i), s1
            })).intValue();
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
            return false;
        }
        return i == 0;
    }

    public final void a()
    {
        com.offerup.android.activities.a a1 = f;
        Intent intent = new Intent(a1.a, com/offerup/android/activities/ProfileImageActivity);
        a1.a.startActivityForResult(intent, 6);
    }

    protected final void a(ActionBar actionbar)
    {
        super.a(actionbar);
        if (actionbar != null)
        {
            actionbar.setHomeAsUpIndicator(0x7f020015);
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    final String b()
    {
        return "my_account";
    }

    public final boolean d()
    {
        return true;
    }

    public final int e()
    {
        return 0x7f11000e;
    }

    protected void onActivityResult(int i, int i1, Intent intent)
    {
        super.onActivityResult(i, i1, intent);
        if (i == 6)
        {
            t.a(ba.a(e.t()));
            u = true;
            return;
        } else
        {
            g = ProgressDialog.show(this, "", getString(0x7f0901b1));
            com.offerup.android.network.b.c(new de(this));
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        super.onCreate(bundle);
        setContentView(0x7f040029);
        s = new ay(this);
        a = findViewById(0x7f1000f5);
        b = findViewById(0x7f1000f8);
        c = findViewById(0x7f1000f6);
        d = findViewById(0x7f1000f7);
        j = (TextView)findViewById(0x7f1000fa);
        k = findViewById(0x7f1000ed);
        p = findViewById(0x7f1000f2);
        l = findViewById(0x7f1000ee);
        m = findViewById(0x7f1000ef);
        n = findViewById(0x7f1000f0);
        o = findViewById(0x7f1000f1);
        q = findViewById(0x7f1000f9);
        r = (Toolbar)findViewById(0x7f100094);
        setSupportActionBar(r);
        a(getSupportActionBar());
        com.b.a.a.j.a().t();
        t = new u();
        getSupportFragmentManager().a().a(0x7f1000ec, t).b();
        f();
        j.setTextColor(android.support.v4.b.a.b(getApplicationContext(), 0x7f0e00e9));
        obj = "";
        bundle = ((Bundle) (obj));
        PackageInfo packageinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        bundle = ((Bundle) (obj));
        obj = packageinfo.versionName;
        bundle = ((Bundle) (obj));
        int i;
        try
        {
            i = packageinfo.versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.b.a.a.g.a(this, ((Throwable) (obj)));
            i = 0;
            obj = bundle;
        }
        if ("PROD".equalsIgnoreCase("prod"))
        {
            j.setText(String.format(getString(0x7f0901c8), new Object[] {
                obj, Integer.valueOf(i % 10000)
            }));
        } else
        if ("US".equalsIgnoreCase("prod"))
        {
            j.setText(String.format(getString(0x7f0901c3), new Object[] {
                obj, Integer.valueOf(i % 10000)
            }));
        } else
        {
            j.setText(String.format(getString(0x7f0901be), new Object[] {
                "https://offerupnow.com/", obj, Integer.valueOf(i % 10000)
            }));
        }
        q.setOnClickListener(new cv(this));
        a.setOnClickListener(new cw(this));
        b.setOnClickListener(new cx(this));
        g();
        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755752: 
            com.offerup.android.tracker.a.b("MyAccount_Invite-Button_click");
            break;
        }
        s.c();
        return true;
    }

    protected void onPostResume()
    {
        super.onPostResume();
        m();
    }

    protected void onResume()
    {
        super.onResume();
        if (!ba.a())
        {
            f.a();
        }
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            flag = true;
        } else
        {
            flag = n();
        }
        if (!flag)
        {
            p.setVisibility(0);
            p.setOnClickListener(new dd(this));
            return;
        } else
        {
            p.setVisibility(8);
            p.setOnClickListener(null);
            return;
        }
    }
}
