// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import com.crittercism.app.Crittercism;
import com.facebook.appevents.AppEventsLogger;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.e.i;
import com.smule.pianoandroid.utils.m;
import com.smule.pianoandroid.utils.o;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication, ab

public class ag extends FragmentActivity
{

    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    static final String o = com/smule/pianoandroid/magicpiano/ag.getName();
    private AlertDialog a;
    private Observer g;
    private boolean h;
    public com.smule.pianoandroid.magicpiano.registration.b p;
    protected boolean q;
    Observer r;
    Observer s;

    public ag()
    {
        q = true;
        r = new Observer() {

            final ag a;

            public void update(Observable observable, Object obj)
            {
                com.smule.android.f.h.a().b("MagicNetwork.SERVER_MAINTENANCE_EVENT", this);
                if (!ag.k())
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a.a);
                            builder.setMessage(0x7f0c0199);
                            builder.setCancelable(false);
                            builder.setPositiveButton(0x7f0c01c0, new android.content.DialogInterface.OnClickListener(this) {

                                final _cls1 a;

                                public void onClick(DialogInterface dialoginterface, int i1)
                                {
                                    ag.a(a.a.a).dismiss();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                            ag.a(a.a, builder.create());
                            ag.a(a.a).show();
                            com.smule.pianoandroid.magicpiano.ag.b(true);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }
            }

            
            {
                a = ag.this;
                super();
            }
        };
        g = new Observer() {

            final ag a;

            public void update(Observable observable, Object obj)
            {
                a.runOnUiThread(new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        if (!ag.l())
                        {
                            ag.c(true);
                            return;
                        } else
                        {
                            com.smule.pianoandroid.magicpiano.ag.b(a.a);
                            return;
                        }
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            
            {
                a = ag.this;
                super();
            }
        };
        s = new Observer() {

            final ag a;

            public void update(Observable observable, Object obj)
            {
                observable = (String)obj;
                a.runOnUiThread(new Runnable(this, observable) {

                    final String a;
                    final _cls3 b;

                    public void run()
                    {
                        b.a.c(a);
                    }

            
            {
                b = _pcls3;
                a = s1;
                super();
            }
                });
            }

            
            {
                a = ag.this;
                super();
            }
        };
        h = false;
    }

    static AlertDialog a(ag ag1)
    {
        return ag1.a;
    }

    static AlertDialog a(ag ag1, AlertDialog alertdialog)
    {
        ag1.a = alertdialog;
        return alertdialog;
    }

    private String a()
    {
        return getSharedPreferences("magic_piano_prefs", 0).getString("LAST_ACTIVITY", null);
    }

    private void b()
    {
        if (d)
        {
            return;
        } else
        {
            d = true;
            Runnable runnable = new Runnable() {

                final ag a;

                public void run()
                {
                    ag.d(false);
                }

            
            {
                a = ag.this;
                super();
            }
            };
            i.a().a(this);
            com.smule.android.network.core.b.e().post(new Runnable(runnable) {

                final Runnable a;
                final ag b;

                public void run()
                {
                    com.smule.pianoandroid.utils.o.a(b, a, new Runnable(this) {

                        final _cls5 a;

                        public void run()
                        {
                            com.smule.android.network.core.b.e().post(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    com.smule.pianoandroid.utils.o.a(a.a.b, false, a.a.a);
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                }

            
            {
                b = ag.this;
                a = runnable;
                super();
            }
            });
            return;
        }
    }

    static void b(ag ag1)
    {
        ag1.b();
    }

    static boolean b(boolean flag)
    {
        f = flag;
        return flag;
    }

    static boolean c(boolean flag)
    {
        b = flag;
        return flag;
    }

    static boolean d(boolean flag)
    {
        d = flag;
        return flag;
    }

    static boolean k()
    {
        return f;
    }

    static boolean l()
    {
        return c;
    }

    public void c(String s1)
    {
        if (h)
        {
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this, 2);
            builder.setTitle(0x7f0c02ca);
            builder.setMessage(0x7f0c02c9);
            builder.setCancelable(false);
            builder.setPositiveButton(0x7f0c02c8, new android.content.DialogInterface.OnClickListener(s1) {

                final String a;
                final ag b;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    String s2 = a;
                    dialoginterface = s2;
                    if (!s2.startsWith("http://"))
                    {
                        dialoginterface = s2;
                        if (!s2.startsWith("https://"))
                        {
                            dialoginterface = (new StringBuilder()).append("http://").append(s2).toString();
                        }
                    }
                    dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(dialoginterface));
                    b.startActivity(dialoginterface);
                }

            
            {
                b = ag.this;
                a = s1;
                super();
            }
            });
            a = builder.create();
            a.show();
            h = true;
            return;
        }
    }

    public void d(String s1)
    {
        SharedPreferences sharedpreferences = getSharedPreferences("startup_prefs", 0);
        long l1 = UserManager.n().c();
        int i1 = sharedpreferences.getInt("prev_version", -1);
        int j1 = android.os.Build.VERSION.SDK_INT;
        if (s1 == null)
        {
            s1 = "none";
        }
        s1 = (new StringBuilder()).append("Player ").append(l1).append(" had process die.").append(" restarting on activity:").append(getClass().getName()).append(", last activity:").append(s1).append(" Upgraded from app version: ").append(i1).append(", OS version: ").append(j1).toString();
        Crittercism.a(new RuntimeException(s1));
        aa.b(o, (new StringBuilder()).append("reportKilledProcess - ").append(s1).toString());
    }

    protected boolean j()
    {
        return false;
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = true;
        aa.a(o, (new StringBuilder()).append(getClass().getName()).append(".onCreate").toString());
        String s1;
        try
        {
            Class.forName("android.os.AsyncTask");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            classnotfoundexception.printStackTrace();
        }
        if (!e)
        {
            com.smule.pianoandroid.magicpiano.b.i.a();
            e = true;
        }
        if (MagicApplication.sInitialized || MagicApplication.sInitializing)
        {
            flag = false;
        }
        s1 = a();
        if (j() && !isTaskRoot())
        {
            Intent intent = getIntent();
            String s2 = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && s2 != null && s2.equals("android.intent.action.MAIN"))
            {
                finish();
            }
        }
        if (!j() && flag)
        {
            d(s1);
        }
        com.smule.android.f.h.a().a("AUTO_LOGIN_FAILED", g);
        if (flag)
        {
            (new com.smule.pianoandroid.magicpiano.b.i(this)).execute(new Void[0]);
        }
        super.onCreate(bundle);
        com.smule.android.f.h.a().a("AUTO_LOGIN_FAILED", g);
        m.a(this);
    }

    protected void onDestroy()
    {
        aa.a(o, (new StringBuilder()).append(getClass().getName()).append(".onDestroy").toString());
        if (a != null)
        {
            a.dismiss();
            a = null;
        }
        if (p != null)
        {
            p.c();
            p = null;
        }
        ab ab1 = (ab)findViewById(0x7f0a009b);
        if (ab1 != null)
        {
            ab1.e();
        }
        super.onDestroy();
        com.smule.android.f.h.a().b("AUTO_LOGIN_FAILED", g);
        m.a(this);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        ab ab1 = (ab)findViewById(0x7f0a009b);
        if (ab1 != null && ab1.a(menuitem))
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        aa.a(o, (new StringBuilder()).append(getClass().getName()).append(".onPause").toString());
        super.onPause();
        com.smule.android.f.h.a().b("MagicNetwork.UPGRADE_REQUIRED_EVENT", s);
        com.smule.android.f.h.a().b("MagicNetwork.SERVER_MAINTENANCE_EVENT", r);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        ab ab1 = (ab)findViewById(0x7f0a009b);
        if (ab1 != null)
        {
            ab1.a();
        }
    }

    protected void onResume()
    {
        aa.a(o, (new StringBuilder()).append(getClass().getName()).append(".onResume").toString());
        super.onResume();
        AppEventsLogger.activateApp(this, getResources().getString(0x7f0c00fc));
        com.smule.android.f.h.a().a("MagicNetwork.UPGRADE_REQUIRED_EVENT", s);
        com.smule.android.f.h.a().a("MagicNetwork.SERVER_MAINTENANCE_EVENT", r);
        ab ab1 = (ab)findViewById(0x7f0a009b);
        if (ab1 != null)
        {
            ab1.f();
        }
        if (b)
        {
            b();
            b = false;
        }
        c = true;
    }

    protected void onStart()
    {
        aa.a(o, (new StringBuilder()).append(getClass().getName()).append(".onStart").toString());
        super.onStart();
    }

}
