// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.b.h;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import b.a.a;
import com.apptentive.android.sdk.Apptentive;
import com.b.a.a.g;
import com.b.a.a.j;
import com.facebook.appevents.AppEventsLogger;
import com.leanplum.LeanplumActivityHelper;
import com.offerup.android.network.b;
import com.offerup.android.service.ApplicationStartupService;
import com.offerup.android.service.ServerStatusService;
import com.offerup.android.utils.av;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.c;
import com.offerup.android.utils.m;
import com.offerup.android.utils.n;
import com.offerup.android.utils.x;
import com.urbanairship.analytics.Analytics;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            u, v, m, r, 
//            s, t, n, o, 
//            p, q, a, TermsOfServiceActivity, 
//            l, w, x

public abstract class k extends AppCompatActivity
{

    private static Calendar d;
    private static long j;
    private static long k;
    private AlertDialog a;
    private boolean b;
    private com.offerup.android.activities.x c;
    j e;
    com.offerup.android.activities.a f;
    ProgressDialog g;
    protected boolean h;
    protected x i;
    private Map l;
    private LeanplumActivityHelper m;

    public k()
    {
        b = false;
        l = new HashMap();
    }

    static Calendar a(Calendar calendar)
    {
        d = calendar;
        return calendar;
    }

    private void a()
    {
        try
        {
            if (a != null && a.isShowing())
            {
                a.dismiss();
            }
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    static void a(k k1)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.offerup"));
        intent.setFlags(0x50080000);
        k1.startActivity(intent);
    }

    static void a(k k1, int i1)
    {
        k1.b(i1);
    }

    private boolean a(Activity activity)
    {
        android.content.Context context = activity.getApplicationContext();
        boolean flag = true;
        try
        {
            av.a(getApplicationContext());
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
            flag = false;
        }
        try
        {
            com.offerup.android.utils.c.a(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.b.a.a.g.a(this, activity);
            flag = false;
        }
        try
        {
            AppEventsLogger.activateApp(context, getString(0x7f0900c8));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.b.a.a.g.a(this, activity);
            return false;
        }
        return flag;
    }

    static boolean a(k k1, Activity activity)
    {
        return k1.a(activity);
    }

    private void b(int i1)
    {
        a();
        a = null;
        if (i1 == 0)
        {
            return;
        }
        android.app.AlertDialog.Builder builder = n.c(this);
        j j1 = com.b.a.a.j.a();
        a a1 = b.a.a.b(m.a);
        switch (i1)
        {
        default:
            return;

        case 1: // '\001'
            builder.setTitle("Upgrade Available");
            builder.setMessage("Would you like to upgrade to the latest version of OfferUp?");
            builder.setPositiveButton("Update", new u(this));
            builder.setNeutralButton("Skip", new v(this, j1));
            builder.setNegativeButton("Later", new com.offerup.android.activities.m(this, j1, a1));
            a = builder.create();
            a.show();
            return;

        case 3: // '\003'
            builder.setTitle("Please Upgrade");
            builder.setMessage("In order to provide you with the best experience, please upgrade this app.");
            builder.setPositiveButton("Upgrade Now", new r(this));
            a = builder.create();
            a.show();
            return;

        case 2: // '\002'
            builder.setTitle("Upgrade Available");
            i1 = a1.a(new a(j1.d()));
            break;
        }
        String s1;
        if (i1 > 1)
        {
            s1 = String.format("This app will stop working in %1$d days.", new Object[] {
                Integer.valueOf(i1)
            });
        } else
        if (i1 == 1)
        {
            s1 = "This app will stop working tomorrow.";
        } else
        {
            s1 = "This app will stop working today.";
        }
        builder.setMessage((new StringBuilder()).append(s1).append(" \nWould you like to upgrade?").toString());
        builder.setPositiveButton("Upgrade Now", new s(this));
        builder.setNegativeButton("Later", new t(this, j1, a1));
        a = builder.create();
        a.show();
    }

    private LeanplumActivityHelper f()
    {
        if (m == null)
        {
            m = new LeanplumActivityHelper(this);
        }
        return m;
    }

    public final void a(int i1)
    {
        i();
        try
        {
            g = ProgressDialog.show(this, "", getString(i1), false, false);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    protected final transient void a(AsyncTask asynctask, Object aobj[])
    {
label0:
        {
label1:
            {
                if (asynctask != null)
                {
                    if (!android.support.v4.e.a.b(this))
                    {
                        break label0;
                    }
                    String s1 = asynctask.getClass().getSimpleName();
                    if (l.containsKey(s1))
                    {
                        AsyncTask asynctask1 = (AsyncTask)l.get(s1);
                        if (asynctask1.getStatus() != android.os.AsyncTask.Status.FINISHED)
                        {
                            asynctask1.cancel(true);
                        }
                    }
                    l.put(s1, asynctask);
                    if (aobj == null || aobj.length <= 0)
                    {
                        break label1;
                    }
                    asynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
                }
                return;
            }
            asynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[1]);
            return;
        }
        a(false, asynctask, aobj);
    }

    protected void a(ActionBar actionbar)
    {
        if (actionbar != null)
        {
            actionbar.setHomeButtonEnabled(true);
            actionbar.setDisplayShowHomeEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setDisplayUseLogoEnabled(true);
            actionbar.setElevation(0.0F);
            actionbar.setLogo(0x7f02001a);
            actionbar.setDisplayShowTitleEnabled(false);
        }
    }

    protected final void a(String s1, String s2)
    {
        i();
        android.app.AlertDialog.Builder builder = n.c(this);
        builder.setTitle(s1);
        builder.setMessage(s2);
        builder.setNeutralButton("OK", new com.offerup.android.activities.n(this));
        n.a(builder);
    }

    public void a(boolean flag)
    {
        com.b.a.a.g.a(getClass().getSimpleName(), "In base class of trackingLibrariesInitialized");
        if (StringUtils.isNotEmpty(b()))
        {
            com.offerup.android.tracker.a.a(b());
        }
    }

    protected final transient void a(boolean flag, AsyncTask asynctask, Object aobj[])
    {
        android.app.AlertDialog.Builder builder;
        try
        {
            builder = n.c(this);
        }
        // Misplaced declaration of an exception variable
        catch (AsyncTask asynctask)
        {
            Log.e(com/offerup/android/activities/k.getSimpleName(), Log.getStackTraceString(asynctask));
            return;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        builder.setTitle(getString(0x7f09017d));
        builder.setMessage(getString(0x7f09017b));
_L3:
        if (asynctask != null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        builder.setNeutralButton("OK", new o(this));
_L4:
        n.a(builder);
        return;
_L2:
        builder.setTitle(getString(0x7f090178));
        builder.setMessage(getString(0x7f090176));
          goto _L3
        builder.setNegativeButton(getString(0x7f090175), new p(this));
        builder.setPositiveButton(getString(0x7f090177), new q(this, asynctask, aobj, builder));
          goto _L4
    }

    abstract String b();

    public int c()
    {
        return -1;
    }

    public boolean d()
    {
        return false;
    }

    public int e()
    {
        return 0x7f110003;
    }

    protected void h()
    {
        TextView textview = (TextView)findViewById(0x7f100222);
        if (textview != null)
        {
            textview.setTypeface(Typeface.createFromAsset(getAssets(), "segoesc.ttf"));
        }
    }

    public final void i()
    {
        try
        {
            if (g != null && g.isShowing())
            {
                g.dismiss();
            }
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    protected boolean j()
    {
        if (ba.a() && !e.r())
        {
            com.offerup.android.activities.a a1 = f;
            Intent intent = new Intent(a1.a, com/offerup/android/activities/TermsOfServiceActivity);
            a1.a.startActivity(intent);
            return true;
        } else
        {
            return false;
        }
    }

    public final void k()
    {
        super.onBackPressed();
    }

    protected final void l()
    {
        if (h)
        {
            com.offerup.android.tracker.a.b(this, b());
        } else
        {
            com.offerup.android.tracker.a.a(this, b());
        }
        h = false;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 2)
        {
            if (j1 == -1)
            {
                if (intent != null)
                {
                    startActivity(intent);
                }
            } else
            if (intent != null && getComponentName().equals(intent.getComponent()))
            {
                String s1 = "You must be logged in to view this activity";
                if (intent.hasExtra("login_failed_dialog_message_intent_key"))
                {
                    s1 = intent.getStringExtra("login_failed_dialog_message_intent_key");
                }
                intent = n.c(this);
                intent.setNeutralButton("OK", new l(this));
                intent.setMessage(s1);
                n.a(intent);
                return;
            }
        }
    }

    public void onBackPressed()
    {
        l();
        if (d())
        {
            i.f();
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
        e = com.b.a.a.j.a();
        f = new com.offerup.android.activities.a(this);
        a(getSupportActionBar());
        if (d())
        {
            i = new x(this, f, b());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(e(), menu);
        return true;
    }

    protected void onDestroy()
    {
        if (d())
        {
            i.d();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag;
        if (d())
        {
            flag = i.a(menuitem);
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            switch (menuitem.getItemId())
            {
            default:
                return false;

            case 16908332: 
                onBackPressed();
                return true;

            case 2131755730: 
                com.offerup.android.tracker.a.d(b());
                break;
            }
            f.c();
            return true;
        } else
        {
            return flag;
        }
    }

    public void onPause()
    {
        a();
        if (l != null && l.size() > 0)
        {
            for (Iterator iterator = l.values().iterator(); iterator.hasNext(); iterator.remove())
            {
                AsyncTask asynctask = (AsyncTask)iterator.next();
                if (asynctask.getStatus() != android.os.AsyncTask.Status.FINISHED)
                {
                    asynctask.cancel(true);
                }
            }

        }
        if (b)
        {
            android.support.v4.b.h.a(this).a(c);
            b = false;
        }
        i();
        try
        {
            f().onPause();
        }
        catch (Throwable throwable)
        {
            com.b.a.a.g.a(this, throwable);
        }
        if (d())
        {
            i.a();
        }
        super.onPause();
    }

    protected void onPostResume()
    {
        super.onPostResume();
        if (d())
        {
            i.c();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (d())
        {
            i.b();
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        super.onResume();
        Calendar calendar = Calendar.getInstance();
        int i1;
        long l1;
        if (d == null || d.get(6) != calendar.get(6))
        {
            d = calendar;
            startService(new Intent(getApplicationContext(), com/offerup/android/service/ApplicationStartupService));
            a(new w(this, this), new Object[0]);
        } else
        {
            a(true);
        }
        l1 = calendar.getTimeInMillis();
        if (ba.a() && l1 > 0x1b7740L + j)
        {
            j = l1;
            com.offerup.android.network.b.a(this, getApplicationContext());
        }
        if (l1 > 0x6ddd00L + k)
        {
            startService(new Intent(getApplicationContext(), com/offerup/android/service/ServerStatusService));
            k = l1;
        }
        if (!b)
        {
            if (c == null)
            {
                c = new com.offerup.android.activities.x(this, (byte)0);
            }
            android.support.v4.b.h.a(this).a(c, new IntentFilter("com.offerup.android.service.ServerStatusService"));
            b = true;
        }
        i1 = com.b.a.a.j.a().c();
        if (i1 > 0)
        {
            b(i1);
        }
        try
        {
            f().onResume();
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
        if (!j());
    }

    public void onStart()
    {
        super.onStart();
        try
        {
            Apptentive.onStart(this);
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
        try
        {
            Analytics.activityStarted(this);
            return;
        }
        catch (Throwable throwable)
        {
            com.b.a.a.g.a(this, throwable);
        }
    }

    public void onStop()
    {
        try
        {
            Apptentive.onStop(this);
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
        try
        {
            f().onStop();
        }
        catch (Exception exception1)
        {
            com.b.a.a.g.a(this, exception1);
        }
        try
        {
            Analytics.activityStopped(this);
        }
        catch (Throwable throwable)
        {
            com.b.a.a.g.a(this, throwable);
        }
        super.onStop();
    }
}
