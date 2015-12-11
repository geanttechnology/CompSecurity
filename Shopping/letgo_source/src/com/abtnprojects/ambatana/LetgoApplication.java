// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.aic;
import android.support.v7.aik;
import android.support.v7.aiw;
import android.support.v7.aji;
import android.support.v7.alt;
import android.support.v7.alz;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dw;
import android.support.v7.gh;
import android.support.v7.gi;
import android.support.v7.ij;
import android.support.v7.iu;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.location.e;
import com.abtnprojects.ambatana.location.f;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.receivers.AmbatanaBroadcastPushReceiver;
import com.abtnprojects.ambatana.services.AppUpdateService;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.kahuna.sdk.i;
import com.kahuna.sdk.k;
import com.newrelic.agent.android.NewRelic;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;

// Referenced classes of package com.abtnprojects.ambatana:
//            e

public class LetgoApplication extends Application
{

    public static f a = null;
    private static Context b;

    public LetgoApplication()
    {
    }

    public static void a(Activity activity, du du1)
    {
        com/abtnprojects/ambatana/LetgoApplication;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = com.abtnprojects.ambatana.location.e.a(activity, du1, a(activity));
            a.a();
        }
        com/abtnprojects/ambatana/LetgoApplication;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    private static boolean a(Activity activity)
    {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity) == 0;
    }

    public static void d()
    {
        android.support.v7.ail ail = com.abtnprojects.ambatana.e.a(e());
        aik.a().a(ail);
    }

    public static android.support.v7.ail.a e()
    {
        return (new android.support.v7.ail.a(b)).a(new aji(b, 7000, 25000)).a().a(new aic()).a(0x6400000).a(aiw.b);
    }

    public static void f()
    {
        aqo.a("Will start fetching location", new Object[0]);
        if (a != null)
        {
            a.c();
        }
    }

    public static void g()
    {
        if (a != null)
        {
            a.d();
        }
    }

    public static boolean h()
    {
        return a == null || a.f();
    }

    public static CurrentUserLocation i()
    {
        if (a == null)
        {
            return null;
        } else
        {
            return a.e();
        }
    }

    protected void a()
    {
        (new gh()).a(this);
    }

    protected void b()
    {
        NewRelic.withApplicationToken("AA5e0ef7e470389e809fe5158faa45f29d4538e2b3").start(this);
    }

    protected void c()
    {
        alt.a(this, new alz[] {
            new Crashlytics()
        });
        aqo.a(new ij());
    }

    public void onCreate()
    {
        super.onCreate();
        c();
        b = getApplicationContext();
        b();
        a();
        Parse.initialize(this, "fMjDVvxiMjuSxciNF67JrB9XQLm6mLuvQ2pjIniu", "VcGL3kgBEqleDz77pPEwd48SROpMu15XVosoqdbv");
        ParseUser.enableAutomaticUser();
        k.i().a(this, "9188e3c6b7cf47acb94a10ab027a08f3", "914431496661");
        k.i().f();
        k.i().h();
        k.i().a(com/abtnprojects/ambatana/receivers/AmbatanaBroadcastPushReceiver);
        ParsePush.subscribeInBackground("", new SaveCallback() {

            final LetgoApplication a;

            public void done(ParseException parseexception)
            {
                if (parseexception != null)
                {
                    aqo.b(parseexception, "Error subscribing to parse push", new Object[0]);
                }
                try
                {
                    parseexception = ParseInstallation.getCurrentInstallation();
                    parseexception.put("GCMSenderId", "914431496661");
                    parseexception.saveInBackground(new SaveCallback(this) {

                        final _cls1 a;

                        public void done(ParseException parseexception)
                        {
                            if (parseexception != null)
                            {
                                aqo.b(parseexception, "Error saving parse installation", new Object[0]);
                            }
                        }

                        public volatile void done(Throwable throwable)
                        {
                            done((ParseException)throwable);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ParseException parseexception)
                {
                    aqo.b(parseexception, "Error saving current installation", new Object[0]);
                }
            }

            public volatile void done(Throwable throwable)
            {
                done((ParseException)throwable);
            }

            
            {
                a = LetgoApplication.this;
                super();
            }
        });
        Object obj = ParseUser.getCurrentUser();
        if (iu.c(((ParseUser) (obj))))
        {
            (new gh()).a(((ParseUser) (obj)));
        }
        com.facebook.k.a(getApplicationContext(), 538);
        ParseFacebookUtils.initialize(getApplicationContext(), 538);
        d();
        obj = new dw(b, new AddressMapper());
        CurrentUserLocation.getInstance().updateLocationData(((du) (obj)).b());
        AppUpdateService.a(getApplicationContext());
        aqo.a("onCreate end", new Object[0]);
    }

}
