// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import com.appboy.Constants;
import com.appboy.services.AppboyLocationService;
import java.util.List;
import myobfuscated.d.b;
import myobfuscated.i.a;
import myobfuscated.i.d;

// Referenced classes of package bo.app:
//            cb, eg, bq, cq, 
//            ct, bx, cz

public final class bp
    implements cb
{

    private static final String a;
    private final Context b;
    private final String c;
    private final LocationManager d;
    private final bx e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private boolean j;
    private boolean k;
    private long l;
    private float m;
    private String n;

    public bp(Context context, bx bx1, b b1, eg eg1)
    {
        k = false;
        l = 0x36ee80L;
        m = 50F;
        b = context;
        c = context.getPackageName();
        e = bx1;
        d = (LocationManager)context.getSystemService("location");
        f = myobfuscated.i.d.a(context, "android.permission.ACCESS_COARSE_LOCATION");
        g = myobfuscated.i.d.a(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean flag;
        if (b1.e())
        {
            myobfuscated.i.a.a(a, "Location collection enabled via appboy.xml configuration.");
            flag = true;
        } else
        {
            myobfuscated.i.a.a(a, "Location collection disabled via appboy.xml configuration.");
            flag = false;
        }
        h = flag;
        if (eg1.a())
        {
            if (eg1.b())
            {
                myobfuscated.i.a.a(a, "Background location collection enabled via server configuration.");
                flag = true;
            } else
            {
                myobfuscated.i.a.a(a, "Background location collection disabled via server configuration.");
                flag = false;
            }
        } else
        if (b1.f())
        {
            myobfuscated.i.a.a(a, "Background location collection enabled via appboy.xml configuration.");
            flag = true;
        } else
        {
            myobfuscated.i.a.a(a, "Background location collection disabled via appboy.xml configuration.");
            flag = false;
        }
        j = flag;
        if (b.getPackageManager().queryIntentServices((new Intent()).setClass(b, com/appboy/services/AppboyLocationService), 0x10000).size() > 0)
        {
            flag = true;
        } else
        {
            myobfuscated.i.a.a(a, String.format("Appboy location service is not available. Declare <service android:name=\"com.appboy.services.AppboyLocationService\"/> in your AndroidManifest.xml to enable Appboy location service.", new Object[0]));
            flag = false;
        }
        i = flag;
        if (eg1.c() >= 0L)
        {
            l = eg1.c();
            myobfuscated.i.a.a(a, (new StringBuilder("Time interval override set via server configuration for background location collection: ")).append(l / 1000L).append("s.").toString());
        } else
        if (b1.g() > 0x493e0L)
        {
            l = b1.g();
            myobfuscated.i.a.a(a, (new StringBuilder("Time interval override set via appboy.xml configuration for background location collection: ")).append(l / 1000L).append("s.").toString());
        } else
        {
            l = 0x36ee80L;
            myobfuscated.i.a.a(a, (new StringBuilder("Time interval override set to default for background location collection: ")).append(l / 1000L).append("s.").toString());
        }
        if (eg1.d() >= 0.0F)
        {
            m = eg1.d();
            myobfuscated.i.a.a(a, (new StringBuilder("Distance threshold override set via server configuration for background location collection: ")).append(m).append("m.").toString());
        } else
        if (b1.h() > 50F)
        {
            m = b1.h();
            myobfuscated.i.a.a(a, (new StringBuilder("Distance threshold override set via appboy.xml configuration for background location collection: ")).append(m).append("m.").toString());
        } else
        {
            m = 50F;
            myobfuscated.i.a.a(a, (new StringBuilder("Distance threshold override set to default for background location collection: ")).append(m).append("m.").toString());
        }
        if (!h)
        {
            myobfuscated.i.a.a(a, "Returning null location provider. Location collection is disabled.");
            context = null;
        } else
        if (g)
        {
            myobfuscated.i.a.a(a, "Using passive provider for fine-grained location collection.");
            context = "passive";
        } else
        if (f)
        {
            context = new Criteria();
            context.setAccuracy(2);
            context.setPowerRequirement(1);
            context = d.getBestProvider(context, true);
            if (context != null)
            {
                myobfuscated.i.a.a(a, (new StringBuilder("Using ")).append(context).append(" provider for coarse-grained location collection.").toString());
            } else
            {
                myobfuscated.i.a.a(a, "Returning null location provider. No suitable location provider found.");
            }
        } else
        {
            myobfuscated.i.a.a(a, "Returning null location provider. Coarse or fine grained location permissions not found.");
            context = null;
        }
        n = context;
        context = new bq(this);
        bx1 = new IntentFilter((new StringBuilder()).append(c).append(".SINGLE_APPBOY_LOCATION_UPDATE").toString());
        b.registerReceiver(context, bx1);
        c();
    }

    private boolean a(String s)
    {
        Intent intent;
        if (!i)
        {
            myobfuscated.i.a.a(a, String.format("Appboy Location service is not available. Did not send intent to service: %s", new Object[] {
                s
            }));
            return false;
        }
        intent = (new Intent(s)).setClass(b, com/appboy/services/AppboyLocationService);
        if (!s.equals((new StringBuilder()).append(c).append(".INIT_APPBOY_LOCATION_SERVICE").toString())) goto _L2; else goto _L1
_L1:
        intent.putExtra("provider", n);
_L4:
        b.startService(intent);
        k = true;
        return true;
_L2:
        if (s.equals((new StringBuilder()).append(c).append(".REQUEST_APPBOY_LOCATION_UPDATES").toString()))
        {
            intent.putExtra("distance", m);
            intent.putExtra("time", l);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String b()
    {
        return a;
    }

    private boolean c()
    {
        if (!h)
        {
            myobfuscated.i.a.a(a, "Did not request background location updates. Location collection is disabled.");
            return false;
        }
        if (!j)
        {
            myobfuscated.i.a.a(a, "Did not request background location updates. Background location collection is disabled.");
            return false;
        }
        if (!g)
        {
            myobfuscated.i.a.a(a, "Did not request background location updates. Fine grained location permissions not found.");
            return false;
        }
        boolean flag;
        try
        {
            if (!k)
            {
                myobfuscated.i.a.a(a, "Attempting to start Appboy Location Service.");
                a((new StringBuilder()).append(c).append(".INIT_APPBOY_LOCATION_SERVICE").toString());
            }
            a((new StringBuilder()).append(c).append(".REQUEST_REMOVE_APPBOY_LOCATION_UPDATES").toString());
            flag = a((new StringBuilder()).append(c).append(".REQUEST_APPBOY_LOCATION_UPDATES").toString());
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(a, "Could not request location updates due to exception.", exception);
            return false;
        }
        return flag;
    }

    public final void a(cq cq1)
    {
        if (cq1 == null)
        {
            myobfuscated.i.a.b(a, "Could not reset background location collection interval. Server config was null.");
        } else
        {
            if (cq1.g >= 0L)
            {
                l = cq1.g;
                myobfuscated.i.a.a(a, (new StringBuilder("Time interval override reset via server configuration for background location collection: ")).append(l / 1000L).append("s.").toString());
            }
            if (cq1.h >= 0.0F)
            {
                m = cq1.h;
                myobfuscated.i.a.a(a, (new StringBuilder("Distance threshold override reset via server configuration for background location collection: ")).append(m).append("m.").toString());
            }
            if (cq1.e)
            {
                if (cq1.f)
                {
                    j = true;
                    myobfuscated.i.a.a(a, "Background location collection enabled via server configuration. Requesting location updates.");
                    c();
                    return;
                }
                j = false;
                myobfuscated.i.a.a(a, "Background location collection disabled via server configuration. Stopping any active Appboy location service.");
                if (!i)
                {
                    myobfuscated.i.a.a(a, "Did not attempt to stop service. Appboy Location service is not available.");
                    return;
                } else
                {
                    myobfuscated.i.a.a(a, "Stopping Appboy location service.");
                    cq1 = (new Intent()).setClass(b, com/appboy/services/AppboyLocationService);
                    b.stopService(cq1);
                    k = false;
                    return;
                }
            }
        }
    }

    public final boolean a()
    {
        if (!h)
        {
            myobfuscated.i.a.a(a, "Did not request single location update. Location collection is disabled.");
        } else
        {
            if (!g && !f)
            {
                myobfuscated.i.a.a(a, "Did not request single location update. Coarse or fine grained location permissions not found.");
                return false;
            }
            if (n != null)
            {
                try
                {
                    Object obj = new Intent((new StringBuilder()).append(c).append(".SINGLE_APPBOY_LOCATION_UPDATE").toString());
                    ((Intent) (obj)).putExtra("origin", "Appboy location manager");
                    obj = PendingIntent.getBroadcast(b, 0, ((Intent) (obj)), 0x8000000);
                    d.requestSingleUpdate(n, ((PendingIntent) (obj)));
                }
                catch (Exception exception)
                {
                    myobfuscated.i.a.b(a, "Failed to request single location update due to exception.", exception);
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final boolean a(cz cz)
    {
        try
        {
            cz = bo.app.ct.a(cz);
            e.a(cz);
        }
        // Misplaced declaration of an exception variable
        catch (cz cz)
        {
            myobfuscated.i.a.b(a, "Failed to log location recorded event.", cz);
            return false;
        }
        return true;
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, bo/app/bp.getName()
        });
    }
}
