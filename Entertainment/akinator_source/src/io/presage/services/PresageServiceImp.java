// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Browser;
import io.presage.Presage;
import io.presage.receivers.BootReceiver;
import io.presage.receivers.InstallReceiver;
import io.presage.services.for.e;
import io.presage.services.for.f;
import io.presage.services.for.g;
import io.presage.services.for.h;
import io.presage.services.for.i;
import io.presage.services.for.k;
import io.presage.services.for.l;
import io.presage.utils.d;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package io.presage.services:
//            AbstractPresageService, d, e

public class PresageServiceImp extends AbstractPresageService
    implements io.presage.services.d
{

    private io.presage.services.e e;
    private io.presage.services.e f;
    private io.presage.services.e g;
    private io.presage.services.e h;
    private LinkedList i;

    public PresageServiceImp()
    {
        i = new LinkedList();
    }

    private static io.presage.services.e a(String s, long l1)
    {
        if (s != null)
        {
            if (s.equals("once"))
            {
                return io.presage.services.e.a();
            }
            if (s.equals("each"))
            {
                return io.presage.services.e.a(l1).e();
            }
            if (s.equals("eachOrGreater"))
            {
                return io.presage.services.e.b(l1).e();
            }
        }
        return null;
    }

    public final void a()
    {
        Object obj = Presage.getInstance().getContext().getSharedPreferences("presage", 0);
        new StringBuilder("timing-type-check_update");
        String s = ((SharedPreferences) (obj)).getString("type", null);
        if (s != null)
        {
            f = a(s, ((SharedPreferences) (obj)).getLong("value", 1L));
        } else
        {
            f = io.presage.services.e.b(1L).f();
        }
        new StringBuilder("timing-type-config");
        s = ((SharedPreferences) (obj)).getString("type", null);
        if (s != null)
        {
            g = a(s, ((SharedPreferences) (obj)).getLong("value", 1L));
        } else
        {
            g = io.presage.services.e.b(6L).f();
        }
        new StringBuilder("timing-type-profile");
        s = ((SharedPreferences) (obj)).getString("type", null);
        if (s != null)
        {
            e = a(s, ((SharedPreferences) (obj)).getLong("value", 1L));
        } else
        {
            e = io.presage.services.e.a();
        }
        new StringBuilder("timing-type-search");
        s = ((SharedPreferences) (obj)).getString("type", null);
        if (s != null)
        {
            h = a(s, ((SharedPreferences) (obj)).getLong("value", 1L));
        } else
        {
            h = io.presage.services.e.b(3L).f();
        }
        a(((io.presage.services.for.j) (new k("profile"))), "profile", e);
        a(((io.presage.services.for.j) (new h())), "config", g);
        obj = new e("apps");
        a(((io.presage.services.for.j) (obj)), "apps", ((e) (obj)).f());
        a(((io.presage.services.for.j) (new g())), "check_update", f);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            if (d.a().a("com.android.browser"))
            {
                Object obj1 = new i(Uri.parse("content://com.android.browser/history"), "history");
                a(((io.presage.services.for.j) (obj1)), "history-browser", ((i) (obj1)).f());
                obj1 = new f(Browser.BOOKMARKS_URI, "bookmarks");
                a(((io.presage.services.for.j) (obj1)), "bookmarks-browser", ((f) (obj1)).f());
            }
            if (d.a().a("com.android.chrome"))
            {
                Object obj2 = new i(Uri.parse("content://com.android.chrome.browser/history"), "history");
                a(((io.presage.services.for.j) (obj2)), "history-chrome", ((i) (obj2)).f());
                obj2 = new f(Uri.parse("content://com.android.chrome.browser/bookmarks"), "bookmarks");
                a(((io.presage.services.for.j) (obj2)), "bookmarks-chrome", ((f) (obj2)).f());
            }
            if (d.a().a("com.sec.android.app.sbrowser"))
            {
                Object obj3 = new i(Uri.parse("content://com.sec.android.app.sbrowser.browser/history"), "history");
                a(((io.presage.services.for.j) (obj3)), "history-samsung", ((i) (obj3)).f());
                obj3 = new f(Uri.parse("content://com.sec.android.app.sbrowser.browser/bookmarks"), "bookmarks");
                a(((io.presage.services.for.j) (obj3)), "bookmarks-samsung", ((f) (obj3)).f());
            }
            a(((io.presage.services.for.j) (new l(Uri.parse("content://com.android.browser/searches"), "search"))), "search", h);
        }
    }

    public void onCreate()
    {
        super.onCreate();
        Object obj = new BootReceiver();
        IntentFilter intentfilter = new IntentFilter();
        Presage.getInstance().getPackageHelper().a(4);
        intentfilter.addAction("android.intent.action.BOOT_COMPLETED");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("io.presage.receivers.BootReceiver.RESTART_SERVICE");
        getApplicationContext().registerReceiver(((BroadcastReceiver) (obj)), intentfilter);
        i.add(obj);
        obj = new InstallReceiver();
        intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentfilter.addAction("android.intent.action.PACKAGE_FIRST_LAUNCH");
        intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentfilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentfilter.addCategory("android.intent.category.DEFAULT");
        intentfilter.addDataScheme("package");
        getApplicationContext().registerReceiver(((BroadcastReceiver) (obj)), intentfilter);
        i.add(obj);
    }

    public void onDestroy()
    {
        BroadcastReceiver broadcastreceiver;
        for (Iterator iterator = i.iterator(); iterator.hasNext(); getApplicationContext().unregisterReceiver(broadcastreceiver))
        {
            broadcastreceiver = (BroadcastReceiver)iterator.next();
        }

        super.onDestroy();
    }
}
