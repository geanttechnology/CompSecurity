// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dv;
import android.support.v7.dw;
import android.support.v7.dx;
import android.support.v7.dy;
import android.support.v7.ea;
import android.support.v7.eb;
import android.support.v7.ee;
import android.support.v7.ei;
import android.support.v7.eq;
import android.support.v7.gh;
import android.support.v7.gi;
import android.support.v7.hh;
import android.support.v7.ic;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.a;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.SearchParameters;
import com.abtnprojects.ambatana.services.CurrencyService;
import com.abtnprojects.ambatana.ui.activities.chat.UserMessagesListActivity;
import com.abtnprojects.ambatana.ui.signup.MainSignUpActivity;
import com.abtnprojects.ambatana.ui.widgets.b;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import java.util.Date;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            a, SearchActivity, ProductListingActivity

public abstract class c extends com.abtnprojects.ambatana.ui.activities.a
{

    private gi n;
    private Handler o;
    private b p;
    protected du q;
    protected dv r;
    protected AlertDialog s;
    protected CharSequence t;
    protected MenuItem u;
    SearchParameters v;
    protected ParseUser w;
    protected ic x;
    Toolbar y;
    protected final Object z = new Object() {

        final c a;

        public void on(dy dy1)
        {
            a.a(dy1);
        }

        public void on(ea ea1)
        {
            a.a(ea1.a);
        }

        public void on(eb eb)
        {
            a.invalidateOptionsMenu();
        }

        public void on(ee ee1)
        {
            aqo.a("LocationChangedEvent %s", new Object[] {
                ee1.a
            });
            iv.a(a.s);
        }

        public void on(ei ei)
        {
            aqo.a("NoProvidersAvailableEvent", new Object[0]);
            a.u();
        }

        public void on(eq eq)
        {
            iv.a(a.s);
        }

            
            {
                a = c.this;
                super();
            }
    };

    public c()
    {
    }

    private void C()
    {
        if (m())
        {
            a(y());
        }
    }

    static Handler a(c c1, Handler handler)
    {
        c1.o = handler;
        return handler;
    }

    static b a(c c1)
    {
        return c1.p;
    }

    static b a(c c1, b b1)
    {
        c1.p = b1;
        return b1;
    }

    private void c(int i)
    {
        if (u != null)
        {
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u.setVisible(flag);
        }
    }

    private void l()
    {
        Toast.makeText(getApplicationContext(), getString(0x7f090072), 1).show();
    }

    private void n()
    {
        if (!is.g(this))
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setPositiveButton(getString(0x7f090066), new android.content.DialogInterface.OnClickListener() {

                final c a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    a.startActivity(dialoginterface);
                }

            
            {
                a = c.this;
                super();
            }
            });
            s = builder.create();
            s.setTitle(getString(0x7f090069));
            s.setMessage(getString(0x7f090067));
            s.setCancelable(false);
            s.show();
        }
    }

    private boolean o()
    {
        return isFinishing() || s != null && s.isShowing();
    }

    protected void A()
    {
        Date date = new Date();
        is.a(getApplicationContext(), date.getTime());
    }

    protected void B()
    {
        ParseUser.logOutInBackground(new LogOutCallback() {

            final c a;

            public void done(ParseException parseexception)
            {
                if (parseexception == null)
                {
                    a.x.d();
                    return;
                } else
                {
                    aqo.b(parseexception, "Error trying to logout a banned user", new Object[0]);
                    return;
                }
            }

            public volatile void done(Throwable throwable)
            {
                done((ParseException)throwable);
            }

            
            {
                a = c.this;
                super();
            }
        });
    }

    protected void a(int i)
    {
        g().a(true);
    }

    protected void a(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("The delay must be a natural positive number [0-Long.MaxValue]");
        }
        if (o == null)
        {
            o = new Handler(Looper.getMainLooper());
            o.postDelayed(new Runnable() {

                final c a;

                public void run()
                {
                    if (!a.isFinishing())
                    {
                        hh hh1 = new hh(new gh(), ParseUser.getCurrentUser());
                        com.abtnprojects.ambatana.ui.activities.c.a(a, new b(a, hh1));
                        try
                        {
                            com.abtnprojects.ambatana.ui.activities.c.a(a).a(a);
                            a.A();
                        }
                        catch (android.view.WindowManager.BadTokenException badtokenexception) { }
                        com.abtnprojects.ambatana.ui.activities.c.a(a, null);
                    }
                }

            
            {
                a = c.this;
                super();
            }
            }, l1);
        }
    }

    protected void a(dy dy1)
    {
        dy1 = dy1.a();
        if (!is.g(this))
        {
            if (dy1 != null)
            {
                aqo.b("Address received %s", new Object[] {
                    dy1.toString()
                });
                q.a(dy1);
                b(dy1.getCountryCode());
            } else
            {
                aqo.b("Address received is null", new Object[0]);
            }
        }
        iv.a(s);
    }

    protected void a(CountryCurrencyInfo countrycurrencyinfo)
    {
        if (countrycurrencyinfo != null)
        {
            r.a(this, countrycurrencyinfo);
            aqo.a("onCurrencyReadyEvent : %s", new Object[] {
                countrycurrencyinfo
            });
        }
    }

    public void b(int i)
    {
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(i, null);
        android.support.v7.app.ActionBar.LayoutParams layoutparams = new android.support.v7.app.ActionBar.LayoutParams(-2, -1);
        layoutparams.gravity = 17;
        ActionBar actionbar = g();
        actionbar.a(view, layoutparams);
        actionbar.c(true);
    }

    protected void b(String s1)
    {
        Object obj = r.a(this);
        boolean flag;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((CountryCurrencyInfo) (obj)).getCountryCode();
        }
        aqo.b("savedCountryCode %s", new Object[] {
            obj
        });
        if (obj == null || !((String) (obj)).equals(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            aqo.a("will start service", new Object[0]);
            obj = new Intent(this, com/abtnprojects/ambatana/services/CurrencyService);
            ((Intent) (obj)).putExtra("country_code", s1);
            startService(((Intent) (obj)));
        }
    }

    protected void c(Intent intent)
    {
        d(intent);
    }

    protected void c(String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            ActionBar actionbar = g();
            actionbar.c(false);
            actionbar.a(s1);
            actionbar.b(true);
            return;
        } else
        {
            b(0x7f040019);
            s1 = g();
            s1.b(false);
            ((ImageView)s1.a().findViewById(0x7f100079)).setVisibility(0);
            return;
        }
    }

    protected void d(Intent intent)
    {
        if (intent == null || intent.getAction() == null)
        {
            t();
            return;
        } else
        {
            x.a(intent, ParseUser.getCurrentUser());
            return;
        }
    }

    protected void k()
    {
        setContentView(0x7f04001c);
    }

    protected abstract boolean m();

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 537 && j == -1)
        {
            c(intent);
        } else
        {
            if ((i == 2 || i == 3) && j == -1)
            {
                v = is.a(this);
                t();
                return;
            }
            if (i == 433)
            {
                switch (j)
                {
                default:
                    return;

                case -1: 
                    r();
                    return;

                case 0: // '\0'
                    aqo.b("User cancelled using location settings", new Object[0]);
                    break;
                }
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        k();
        n = new gh();
        iv.a(z);
        w = ParseUser.getCurrentUser();
        q = new dw(this, new AddressMapper());
        r = new dx();
        x = new ic(this);
        LetgoApplication.a(this, q);
        p();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110002, menu);
        u = menu.findItem(0x7f10016e);
        if (iu.c(w) && u != null)
        {
            boolean flag;
            if (com.abtnprojects.ambatana.a.a(this).a() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u.setVisible(flag);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (0x102002c == menuitem.getItemId() || 0x7f100004 == menuitem.getItemId())
        {
            onBackPressed();
            return true;
        }
        if (menuitem.getItemId() == 0x7f10016d)
        {
            startActivityForResult(new Intent(getBaseContext(), com/abtnprojects/ambatana/ui/activities/SearchActivity), 2);
        } else
        if (menuitem.getItemId() == 0x7f10016e)
        {
            startActivity(new Intent(getBaseContext(), com/abtnprojects/ambatana/ui/activities/chat/UserMessagesListActivity));
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
        return false;
    }

    protected void onPause()
    {
        super.onPause();
        iv.b(z);
        n.e(this);
    }

    protected void onResume()
    {
        super.onResume();
        iv.a(z);
        n.d(this);
        w();
        C();
    }

    protected void onStart()
    {
        super.onStart();
        n.c(this);
        iv.a(z);
    }

    protected void onStop()
    {
        super.onStop();
        n.f(this);
        if (p != null && p.isShowing())
        {
            p.dismiss();
        }
    }

    protected void p()
    {
        y = (Toolbar)findViewById(0x7f100134);
        a(y);
    }

    protected void q()
    {
        l();
        finish();
    }

    protected void r()
    {
        q = new dw(this, new AddressMapper());
        if ((!is.g(this) || q == null) && iv.b(this))
        {
            LetgoApplication.f();
        }
    }

    public CountryCurrencyInfo s()
    {
        CountryCurrencyInfo countrycurrencyinfo1 = r.a(this);
        CountryCurrencyInfo countrycurrencyinfo = countrycurrencyinfo1;
        if (countrycurrencyinfo1 == null)
        {
            countrycurrencyinfo = CountryCurrencyInfo.createDefaultCountryCurrencyInfo();
        }
        return countrycurrencyinfo;
    }

    protected void t()
    {
        startActivity(new Intent(this, com/abtnprojects/ambatana/ui/activities/ProductListingActivity));
    }

    public void u()
    {
        aqo.a("showSettingsAlertIfNeeded context is: %s", new Object[] {
            getClass().getSimpleName()
        });
        if (!isFinishing() && s != null && s.isShowing())
        {
            return;
        }
        if (!(new dw(this, new AddressMapper())).d())
        {
            n();
            return;
        } else
        {
            aqo.a("showSettingsAlertIfNeeded : user already located, not showing dialog", new Object[0]);
            return;
        }
    }

    public void v()
    {
        if (o())
        {
            return;
        } else
        {
            n();
            return;
        }
    }

    protected void w()
    {
        com.abtnprojects.ambatana.a.a(this).b();
        c(com.abtnprojects.ambatana.a.a(this).a());
    }

    protected void x()
    {
        Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/signup/MainSignUpActivity);
        Bundle bundle = new Bundle();
        bundle.putString("login_type", "posting");
        intent.putExtras(bundle);
        startActivityForResult(intent, 537);
    }

    protected long y()
    {
        return 1000L;
    }

    protected boolean z()
    {
        return is.j(getApplicationContext());
    }
}
