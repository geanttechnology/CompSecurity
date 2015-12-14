// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinTargetingData;
import java.io.PrintWriter;
import java.io.StringWriter;

// Referenced classes of package com.applovin.impl.sdk:
//            bz, cp, cq, cb, 
//            k, o, y, r, 
//            AppLovinAdServiceImpl, bd, PostbackServiceImpl, EventServiceImpl, 
//            bm, b, bb, m, 
//            aw, bw, by

public class AppLovinSdkImpl extends AppLovinSdk
{

    private String a;
    private AppLovinSdkSettings b;
    private Context c;
    private AppLovinLogger d;
    private cq e;
    private bz f;
    private o g;
    private cb h;
    private y i;
    private b j;
    private bb k;
    private r l;
    private m m;
    private AppLovinAdServiceImpl n;
    private bd o;
    private PostbackServiceImpl p;
    private EventServiceImpl q;
    private bm r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;

    public AppLovinSdkImpl()
    {
        s = true;
        t = false;
        u = false;
        v = false;
        w = false;
    }

    private static boolean h()
    {
        return !android.os.Build.VERSION.RELEASE.startsWith("1.") && !android.os.Build.VERSION.RELEASE.startsWith("2.0") && !android.os.Build.VERSION.RELEASE.startsWith("2.1");
    }

    cq a()
    {
        return e;
    }

    Object a(by by)
    {
        return f.a(by);
    }

    void a(AppLovinSdkSettings applovinsdksettings)
    {
        s = true;
        e.a(new cp(this, applovinsdksettings), 0L);
    }

    void a(boolean flag)
    {
        s = false;
        t = flag;
        u = true;
    }

    cb b()
    {
        return h;
    }

    b c()
    {
        return j;
    }

    bb d()
    {
        return k;
    }

    boolean e()
    {
        return s;
    }

    boolean f()
    {
        return u;
    }

    void g()
    {
        f.d();
        f.b();
        h.a();
    }

    public AppLovinAdService getAdService()
    {
        return n;
    }

    public Context getApplicationContext()
    {
        return c;
    }

    public o getConnectionManager()
    {
        return g;
    }

    public r getDataCollector()
    {
        return l;
    }

    public AppLovinEventService getEventService()
    {
        return q;
    }

    public y getFileManager()
    {
        return i;
    }

    public AppLovinLogger getLogger()
    {
        return d;
    }

    public AppLovinNativeAdService getNativeAdService()
    {
        return o;
    }

    public bm getPersistentPostbackManager()
    {
        return r;
    }

    public PostbackServiceImpl getPostbackService()
    {
        return p;
    }

    public volatile AppLovinPostbackService getPostbackService()
    {
        return getPostbackService();
    }

    public String getSdkKey()
    {
        return a;
    }

    public AppLovinSdkSettings getSettings()
    {
        return b;
    }

    public bz getSettingsManager()
    {
        return f;
    }

    public AppLovinTargetingData getTargetingData()
    {
        return m;
    }

    public boolean hasCriticalErrors()
    {
        return v || w;
    }

    protected void initialize(String s1, AppLovinSdkSettings applovinsdksettings, Context context)
    {
        a = s1;
        b = applovinsdksettings;
        c = context;
        context = new k();
        d = context;
        f = new bz(this);
        e = new cq(this);
        g = new o(this);
        h = new cb(this);
        i = new y(this);
        l = new r(this);
        n = new AppLovinAdServiceImpl(this);
        o = new bd(this);
        p = new PostbackServiceImpl(this);
        q = new EventServiceImpl(this);
        r = new bm(this);
        j = new b(this);
        k = new bb(this);
        m = new m(this);
        if (!h())
        {
            v = true;
            Log.e("AppLovinSdk", "Unable to initalize AppLovin SDK: Android SDK version has to be at least level 8");
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        if (s1.length() >= 1)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        w = true;
        Log.e("AppLovinSdk", "Unable to find AppLovin SDK key. Please add     meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
        s1 = new StringWriter();
        (new Throwable("")).printStackTrace(new PrintWriter(s1));
        s1 = s1.toString();
        Log.e("AppLovinSdk", (new StringBuilder()).append("Called with an invalid SDK key from: ").append(s1).toString());
        if (!hasCriticalErrors())
        {
            context.a(f);
            if (applovinsdksettings instanceof aw)
            {
                context.a(((aw)applovinsdksettings).a());
            }
            a(applovinsdksettings);
            return;
        }
        try
        {
            a(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e("AppLovinSdk", "Failed to load AppLovin SDK, ad serving will be disabled", s1);
        }
        a(false);
        return;
    }

    public void initializeSdk()
    {
    }

    public boolean isEnabled()
    {
        return t;
    }

    public void setPluginVersion(String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("No version specified");
        } else
        {
            f.a(bw.F, s1);
            f.b();
            return;
        }
    }
}
