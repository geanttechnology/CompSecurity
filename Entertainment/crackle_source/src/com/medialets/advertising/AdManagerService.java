// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.medialets.analytics.MMAnalyticsManager;
import java.lang.reflect.Field;

// Referenced classes of package com.medialets.advertising:
//            k, l, a, AdManager, 
//            DataSource, h, ac, ag

public final class AdManagerService extends Service
    implements com.medialets.analytics.MMAnalyticsManager.AnalyticsListener
{
    public class AdBinder extends Binder
    {

        private AdManagerService a;

        public AdManagerService getService()
        {
            return a;
        }

        public AdBinder()
        {
            a = AdManagerService.this;
            super();
        }
    }


    Runnable a;
    private IBinder b;
    private String c;
    private String d;
    private boolean e;
    private DataSource f;
    private ag g;
    private boolean h;
    private Handler i;
    private MMAnalyticsManager j;
    private boolean k;
    private boolean l;
    private Runnable m;

    public AdManagerService()
    {
        b = new AdBinder();
        h = false;
        i = new Handler();
        k = false;
        l = false;
        a = new k(this);
        m = new l(this);
    }

    static boolean a(AdManagerService admanagerservice)
    {
        return admanagerservice.k;
    }

    static MMAnalyticsManager b(AdManagerService admanagerservice)
    {
        return admanagerservice.j;
    }

    static Handler c(AdManagerService admanagerservice)
    {
        return admanagerservice.i;
    }

    public final MMAnalyticsManager getAnalyticsManager()
    {
        return j;
    }

    public final String getApplicationId()
    {
        return c;
    }

    public final String getApplicationVersion()
    {
        return d;
    }

    protected final ag getDataStore()
    {
        return g;
    }

    public final IBinder onBind(Intent intent)
    {
        com.medialets.advertising.a.d("Bind attempt on the service.");
        k = true;
        return b;
    }

    protected final void onConnected()
    {
        com.medialets.advertising.a.d("Bound to the service.");
        k = true;
        AdManager admanager = AdManager.getInstance();
        if (!h && !l && admanager.mShouldSync)
        {
            l = true;
            long l1 = getSharedPreferences("medialets.prefs", 0).getLong("last.sync", -1L);
            if (System.currentTimeMillis() - l1 > 30000L)
            {
                (new a(g)).a();
                admanager.onSyncStarted();
                f.a();
                h = true;
            }
        }
        j.resume();
    }

    public final void onCreate()
    {
        Object obj;
        Object obj1;
        com.medialets.advertising.a.d("SDK Initialized (version: 2.2.11.0)");
        obj1 = AdManager.getInstance();
        obj = ((AdManager) (obj1)).getCurrentActivity().getPackageName();
        c = ((AdManager) (obj1)).a;
        d = ((AdManager) (obj1)).b;
        e = ((AdManager) (obj1)).mUseTestServers;
        com.medialets.advertising.a.a((new StringBuilder()).append("Initializing app settings. AdManager settings: ApplicationId: ").append(c).append(" ApplicationVersion: ").append(d).append(" UseTestServers: ").append(e).toString());
        obj1 = getPackageManager().getServiceInfo(new ComponentName(getApplicationContext(), com/medialets/advertising/AdManagerService), 128).metaData;
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        com.medialets.advertising.a.a("Checking service meta-data in AndroidManifest.xml");
        if (c == null && ((Bundle) (obj1)).containsKey("com.medialets.advertising.ApplicationId"))
        {
            c = ((Bundle) (obj1)).get("com.medialets.advertising.ApplicationId").toString();
            com.medialets.advertising.a.a((new StringBuilder()).append("Found: com.medialets.advertising.ApplicationId value: ").append(c).toString());
        }
        if (d == null && ((Bundle) (obj1)).containsKey("com.medialets.advertising.ApplicationVersion"))
        {
            d = ((Bundle) (obj1)).get("com.medialets.advertising.ApplicationVersion").toString();
            com.medialets.advertising.a.a((new StringBuilder()).append("Found: com.medialets.advertising.ApplicationVersion value: ").append(d).toString());
        }
        if (!e && ((Bundle) (obj1)).containsKey("com.medialets.advertising.UseTestServers"))
        {
            e = ((Bundle) (obj1)).getBoolean("com.medialets.advertising.UseTestServers", false);
            com.medialets.advertising.a.a((new StringBuilder()).append("Found: com.medialets.advertising.UseTestServers value: ").append(e).toString());
        }
_L8:
        obj1 = Class.forName((new StringBuilder()).append(((String) (obj))).append(".R$string").toString());
        if (c == null)
        {
            c = getString(((Class) (obj1)).getField("app_id").getInt(null));
            com.medialets.advertising.a.a((new StringBuilder()).append("Checking for 'app_id' in strings.xml, found: ").append(c).toString());
        }
        if (!e)
        {
            e = (new Boolean(getString(((Class) (obj1)).getField("use_test_servers").getInt(null)))).booleanValue();
            com.medialets.advertising.a.a((new StringBuilder()).append("Checking for 'use_test_servers' in strings.xml, found: ").append(e).toString());
        }
        if (d != null) goto _L4; else goto _L3
_L3:
        Field afield[] = ((Class) (obj1)).getFields();
        int i1 = 0;
_L9:
        if (i1 >= afield.length) goto _L6; else goto _L5
_L5:
        if (afield[i1].getName().equals("app_version"))
        {
            d = getString(afield[i1].getInt(null));
        }
          goto _L7
_L2:
        com.medialets.advertising.a.a("No service meta-data found in AndroidManifest.xml, checking strings.xml");
          goto _L8
        obj;
        com.medialets.advertising.a.c((new StringBuilder()).append("Error initializing app settings: ").append(((Exception) (obj)).toString()).toString());
_L4:
        com.medialets.advertising.a.a((new StringBuilder()).append("Using app id: ").append(c).append(" and version: ").append(d).toString());
        com.medialets.advertising.a.a((new StringBuilder()).append("Use test servers enabled: ").append(e).toString());
        j = MMAnalyticsManager.sharedInstance(this);
        g = new h(this);
        f = new ac(this, g);
        if (e)
        {
            f.a("http://beta.medialytics.com/ad");
            j.useTestServers();
        }
        j.start(c, d, false);
        j.setAnalyticsListener(this);
        return;
_L6:
        com.medialets.advertising.a.a((new StringBuilder()).append("Checking for 'app_version' in strings.xml, found: ").append(d).toString());
        if (d == null)
        {
            com.medialets.advertising.a.a("Last effort, using versionName from AndroidManifest.xml for ApplicationVersion");
            d = getPackageManager().getPackageInfo(((String) (obj)), 0).versionName;
        }
        if (true) goto _L4; else goto _L7
_L7:
        i1++;
          goto _L9
    }

    public final void onDestroy()
    {
        super.onDestroy();
        if (!k)
        {
            j.stop();
        }
        com.medialets.advertising.a.a("AdManagerService has been terminated.");
    }

    public final void onPostComplete()
    {
    }

    public final void onStart(Intent intent, int i1)
    {
    }

    protected final void onSyncCompleted()
    {
        h = false;
        getSharedPreferences("medialets.prefs", 0).edit().putLong("last.sync", System.currentTimeMillis()).commit();
    }

    public final boolean onUnbind(Intent intent)
    {
        com.medialets.advertising.a.d("Unbind attempt on the service.");
        k = false;
        f.b();
        return false;
    }

    protected final void runCleanSync()
    {
        AdManager.getInstance().onSyncStarted();
        g.a();
        f.a();
        h = true;
    }

    protected final void runSync()
    {
        AdManager.getInstance().onSyncStarted();
        f.a();
        h = true;
    }

    protected final void setApplicationId(String s)
    {
        c = s;
    }

    protected final void setApplicationVersion(String s)
    {
        d = s;
    }

    protected final void setDataSource(DataSource datasource)
    {
        f = datasource;
    }

    protected final void stopRunning()
    {
        com.medialets.advertising.a.d("Unbind attempt on the service.");
        k = false;
        i.postDelayed(m, 15000L);
    }

    public final void useTestServers()
    {
        e = true;
    }

    // Unreferenced inner class com/medialets/advertising/k
    final class k
        implements Runnable
    {

        private AdManagerService a;

        public final void run()
        {
            com.medialets.advertising.a.d((new StringBuilder()).append("Checking if we are bound: ").append(AdManagerService.a(a)).toString());
            if (!AdManagerService.a(a))
            {
                AdManagerService.b(a).stop();
            }
        }

            k()
            {
                a = AdManagerService.this;
                super();
            }
    }


    // Unreferenced inner class com/medialets/advertising/l
    final class l
        implements Runnable
    {

        private AdManagerService a;

        public final void run()
        {
            if (!AdManagerService.a(a))
            {
                com.medialets.advertising.a.d("Pausing the service.");
                AdManagerService.b(a).pause();
                AdManagerService.c(a).postDelayed(a.a, 30000L);
                return;
            } else
            {
                AdManagerService.b(a).resume();
                return;
            }
        }

            l()
            {
                a = AdManagerService.this;
                super();
            }
    }

}
