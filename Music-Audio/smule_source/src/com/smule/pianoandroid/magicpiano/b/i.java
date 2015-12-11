// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.android.c.u;
import com.smule.android.c.w;
import com.smule.android.f.h;
import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.core.b;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.LocalizationManager;
import com.smule.android.network.managers.PurchasesManager;
import com.smule.android.network.managers.a.d;
import com.smule.android.network.managers.a.e;
import com.smule.android.network.managers.ac;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.al;
import com.smule.android.network.managers.am;
import com.smule.android.network.managers.ar;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.e.a;
import com.smule.pianoandroid.e.f;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.suggestions.c;
import com.smule.pianoandroid.synths.SoundPoolSynth;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.s;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class i extends AsyncTask
{

    private static final String a = com/smule/pianoandroid/magicpiano/b/i.getName();
    private static am d = new am() {

        public String a()
        {
            return "store.minipiano_android";
        }

    };
    private static al e = new al() {

        public boolean a()
        {
            return true;
        }

        public boolean b()
        {
            return false;
        }

        public int c()
        {
            return -1;
        }

        public String d()
        {
            return null;
        }

    };
    private static boolean f = false;
    private static int g = 10;
    private Activity b;
    private Observer c;

    public i(Activity activity)
    {
        b = activity;
    }

    static Activity a(i l)
    {
        return l.b;
    }

    public static void a()
    {
        aa.c(a, "preInit called");
        w.b("app_time");
        android.content.Context context = MagicApplication.getContext();
        LocalizationManager.a().a(new e());
        LocalizationManager.a().a(new d());
        ak.a().b();
        ak.a().a(MagicApplication.getLoader(), false, d, e);
        com.smule.android.network.managers.i.a().a(context, false);
        com.smule.android.network.managers.d.a().a(context);
        ac.a();
        com.smule.pianoandroid.magicpiano.suggestions.c.a().a(context);
        s.a().a(context);
        o.a(context);
        com.smule.pianoandroid.e.i.a().a(context);
        SoundPoolSynth.prepareResources(context);
        b();
        PianoCoreBridge.initResources(context);
        MagicApplication.getLoader().a("UserManager.userLoggedIn", false, "USER_LOGGED_IN_EVENT").a();
        MagicApplication.getInstance().checkForUpgrade();
        com.smule.pianoandroid.magicpiano.ac.a();
        com.smule.android.network.managers.e.a().a(context);
        com.smule.pianoandroid.e.f.a().b();
        d();
        h();
        g();
        f();
        i();
        j();
        e();
        c();
        com.smule.android.network.core.b.a(new Runnable() {

            public void run()
            {
                com.smule.android.network.core.b.a().a(true);
            }

        });
    }

    static Observer b(i l)
    {
        return l.c;
    }

    public static void b()
    {
        com.smule.pianoandroid.a.w.a();
        com.smule.pianoandroid.e.c.a().a(MagicApplication.getHelper());
        com.smule.pianoandroid.e.c.a().a(MagicApplication.getLoader());
        com.smule.pianoandroid.e.d.a().a(MagicApplication.getContext());
        com.smule.pianoandroid.e.a.a();
        com.smule.pianoandroid.magicpiano.a.g.a().b();
        com.smule.pianoandroid.e.e.a();
        com.smule.pianoandroid.e.d.a();
        com.smule.pianoandroid.magicpiano.a.e.a();
        Observer observer = new Observer() {

            public void update(Observable observable, Object obj)
            {
                MagicApplication.getInstance().showToast(MagicApplication.getInstance().getResources().getString(0x7f0c0230), 1);
            }

        };
        com.smule.android.f.h.a().a("game.data.error", observer);
    }

    public static void c()
    {
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", new Observer() {

            public void update(Observable observable, Object obj)
            {
                if ("SONGBOOK_SYNCED_ACTION".equals((String)((Map)obj).get("ACTION")))
                {
                    com.smule.pianoandroid.search.c.a();
                }
            }

        });
    }

    public static void d()
    {
        MagicApplication.getLoader().a("InitAppTask.OP_NETWORK_CONNECTED", null, new k() {

            boolean a;

            static k a(_cls13 _pcls13)
            {
                return _pcls13.h;
            }

            public void a(j j1)
            {
                if (!r.a(MagicApplication.getContext()) && a)
                {
                    j1.b(h);
                }
                a = false;
                r.b(MagicApplication.getContext(), new Runnable(this, j1) {

                    final j a;
                    final _cls13 b;

                    public void run()
                    {
                        a.b(com.smule.pianoandroid.magicpiano.b._cls13.a(b));
                    }

            
            {
                b = _pcls13;
                a = j1;
                super();
            }
                });
            }

            
            {
                a = true;
            }
        }).a();
    }

    public static void e()
    {
        MagicApplication.getLoader().a("InitAppTask.OP_TRIM_CACHE", null, new k() {

            public void a(j j1)
            {
                com.smule.pianoandroid.utils.g.a((new StringBuilder()).append(com.smule.android.f.n.b(MagicApplication.getContext())).append("/cache/").toString(), 20, 0);
                com.smule.pianoandroid.utils.g.a((new StringBuilder()).append(com.smule.android.f.n.b(MagicApplication.getContext())).append("globe_cache").toString(), 0, 1);
                j1.b(h);
            }

        }).a();
    }

    public static void f()
    {
        MagicApplication.getLoader().a("InitAppTask.OP_RELOAD_SONGBOOK", Arrays.asList(new String[] {
            "StoreManager.loadStore", "InitAppTask.OP_NETWORK_CONNECTED"
        }), new k() {

            static k a(_cls15 _pcls15)
            {
                return _pcls15.h;
            }

            public void a(j j1)
            {
                ak.a().a(new Runnable(this, j1) {

                    final j a;
                    final _cls15 b;

                    public void run()
                    {
                        if (ak.a().e().size() <= 0)
                        {
                            ak.a().c();
                        }
                        a.b(com.smule.pianoandroid.magicpiano.b._cls15.a(b));
                    }

            
            {
                b = _pcls15;
                a = j1;
                super();
            }
                });
            }

        }).a();
    }

    public static void g()
    {
        MagicApplication.getLoader().a("InitAppTask.OP_LOCALIZE_SETTINGS", Arrays.asList(new String[] {
            "InitAppTask.OP_LOAD_SETTINGS"
        }), new k() {

            static k a(_cls2 _pcls2)
            {
                return _pcls2.h;
            }

            public void a(j j1)
            {
                LocalizationManager.a().a(new Runnable(this, j1) {

                    final j a;
                    final _cls2 b;

                    public void run()
                    {
                        a.b(com.smule.pianoandroid.magicpiano.b._cls2.a(b));
                    }

            
            {
                b = _pcls2;
                a = j1;
                super();
            }
                });
            }

        });
    }

    public static void h()
    {
        MagicApplication.getLoader().a("UserManager.userLoggedIn", null, new k() {

            boolean a;

            static k a(_cls3 _pcls3)
            {
                return _pcls3.h;
            }

            public void a(j j1)
            {
                Observer observer = new Observer(this, j1) {

                    final j a;
                    final _cls3 b;

                    public void update(Observable observable, Object obj)
                    {
                        a.b(com.smule.pianoandroid.magicpiano.b._cls3.a(b));
                    }

            
            {
                b = _pcls3;
                a = j1;
                super();
            }
                };
                if (a && !r.a(MagicApplication.getContext()))
                {
                    j1.b(h);
                }
                a = false;
                com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", observer);
                com.smule.android.f.h.a().a("USER_RE_LOGGED_IN_EVENT", observer);
            }

            
            {
                a = true;
            }
        });
        MagicApplication.getLoader().a("InitAppTask.OP_LOAD_SETTINGS", Arrays.asList(new String[] {
            "UserManager.userLoggedIn", "InitAppTask.OP_NETWORK_CONNECTED"
        }), new k() {

            static k a(_cls4 _pcls4)
            {
                return _pcls4.h;
            }

            public void a(j j1)
            {
                com.smule.android.network.managers.a.a(MagicApplication.getContext()).a(new Runnable(this, j1) {

                    final j a;
                    final _cls4 b;

                    public void run()
                    {
                        if (!com.smule.android.network.managers.a.a().a("piandroid.notifications", "localNotificationsEnabled", true))
                        {
                            com.smule.pianoandroid.e.f.a().c();
                        }
                        a.b(com.smule.pianoandroid.magicpiano.b._cls4.a(b));
                    }

            
            {
                b = _pcls4;
                a = j1;
                super();
            }
                });
            }

        }).a();
    }

    private static void i()
    {
        MagicApplication.getLoader().a("InitAppTask.OP_ENTITLEMENTS_LOADED", Arrays.asList(new String[] {
            "InitAppTask.OP_NETWORK_CONNECTED", "UserManager.userLoggedIn"
        }), new k() {

            static k a(_cls5 _pcls5)
            {
                return _pcls5.h;
            }

            public void a(j j1)
            {
                com.smule.android.network.managers.i.a().a(new Runnable(this, j1) {

                    final j a;
                    final _cls5 b;

                    public void run()
                    {
                        a.b(com.smule.pianoandroid.magicpiano.b._cls5.a(b));
                    }

            
            {
                b = _pcls5;
                a = j1;
                super();
            }
                });
            }

        }).a();
    }

    private static void j()
    {
        MagicApplication.getLoader().a("InitAppTask.OP_REFRESH_BALANCE", Arrays.asList(new String[] {
            "InitAppTask.OP_NETWORK_CONNECTED", "UserManager.userLoggedIn"
        }), new k() {

            static k a(_cls6 _pcls6)
            {
                return _pcls6.h;
            }

            public void a(j j1)
            {
                com.smule.android.network.managers.d.a().a(10, new Runnable(this, j1) {

                    final j a;
                    final _cls6 b;

                    public void run()
                    {
                        a.b(com.smule.pianoandroid.magicpiano.b._cls6.a(b));
                    }

            
            {
                b = _pcls6;
                a = j1;
                super();
            }
                });
            }

        }).a();
    }

    private static void k()
    {
        if (f)
        {
            return;
        } else
        {
            w.a(new u(MagicApplication.getContext(), g));
            f = true;
            return;
        }
    }

    protected transient Void a(Void avoid[])
    {
        avoid = com.smule.android.f.h.a();
        Observer observer = new Observer() {

            final i a;

            public void update(Observable observable, Object obj)
            {
                com.smule.pianoandroid.magicpiano.b.i.a(a).runOnUiThread(new Runnable(this) {

                    final _cls7 a;

                    public void run()
                    {
                        ar.a().a(com.smule.pianoandroid.magicpiano.b.i.a(a.a), true);
                        com.smule.android.f.h.a().b("APP_SETTINGS_LOADED_EVENT", com.smule.pianoandroid.magicpiano.b.i.b(a.a));
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
            }

            
            {
                a = i.this;
                super();
            }
        };
        c = observer;
        avoid.a("APP_SETTINGS_LOADED_EVENT", observer);
        n.c();
        com.smule.android.network.managers.h.a().b();
        MagicApplication.sInitialized = true;
        aa.a(a, "Initialized");
        return null;
    }

    protected void a(Void void1)
    {
        aa.a(a, "network initialization complete.");
        MagicApplication.sInitializing = false;
        k();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        aa.a(a, "network initialization error!");
        MagicApplication.sInitializing = false;
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        long l = System.currentTimeMillis();
        com.smule.android.facebook.a.a();
        aa.a(a, (new StringBuilder()).append("onPreExecute - passed MagicFacebook.getInstance at: ").append(System.currentTimeMillis() - l).toString());
        com.smule.android.notifications.a.a().b(b.getApplicationContext());
        aa.a(a, (new StringBuilder()).append("onPreExecute - passed MagicNotifications.getInstance at: ").append(System.currentTimeMillis() - l).toString());
        aa.a(a, (new StringBuilder()).append("onPreExecute - passed AdColonyHelper.checkAdColonyInitialized at: ").append(System.currentTimeMillis() - l).toString());
        PurchasesManager.a().a(b);
        aa.a(a, (new StringBuilder()).append("onPreExecute - passed StoreManager.init at: ").append(System.currentTimeMillis() - l).toString());
        com.smule.android.network.core.b.a(new Runnable() {

            final i a;

            public void run()
            {
                com.smule.android.network.managers.e.a().b();
            }

            
            {
                a = i.this;
                super();
            }
        });
    }

}
