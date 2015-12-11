// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinTargetingData;
import java.io.PrintWriter;
import java.io.StringWriter;

// Referenced classes of package com.applovin.impl.sdk:
//            bu, ci, cj, bw, 
//            k, o, x, f, 
//            bc, PostbackServiceImpl, c, ba, 
//            m, av, br, bt

public class AppLovinSdkImpl extends AppLovinSdk
{

    public static final String FULL_VERSION = "6.0.1";
    private String a;
    private AppLovinSdkSettings b;
    private Context c;
    private AppLovinLogger d;
    private cj e;
    private bu f;
    private o g;
    private bw h;
    private x i;
    private c j;
    private ba k;
    private m l;
    private f m;
    private bc n;
    private PostbackServiceImpl o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;

    public AppLovinSdkImpl()
    {
        p = true;
        q = false;
        r = false;
        s = false;
        t = false;
    }

    private static boolean i()
    {
        return !android.os.Build.VERSION.RELEASE.startsWith("1.") && !android.os.Build.VERSION.RELEASE.startsWith("2.0") && !android.os.Build.VERSION.RELEASE.startsWith("2.1");
    }

    cj a()
    {
        return e;
    }

    Object a(bt bt)
    {
        return f.a(bt);
    }

    void a(boolean flag)
    {
        p = false;
        q = flag;
        r = true;
    }

    bw b()
    {
        return h;
    }

    c c()
    {
        return j;
    }

    ba d()
    {
        return k;
    }

    boolean e()
    {
        return p;
    }

    boolean f()
    {
        return r;
    }

    void g()
    {
        p = true;
        e.a(new ci(this), 0L);
    }

    public AppLovinAdService getAdService()
    {
        return m;
    }

    public Context getApplicationContext()
    {
        return c;
    }

    public o getConnectionManager()
    {
        return g;
    }

    public x getFileManager()
    {
        return i;
    }

    public AppLovinLogger getLogger()
    {
        return d;
    }

    public AppLovinNativeAdService getNativeAdService()
    {
        return n;
    }

    public PostbackServiceImpl getPostbackService()
    {
        return o;
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

    public bu getSettingsManager()
    {
        return f;
    }

    public AppLovinTargetingData getTargetingData()
    {
        return l;
    }

    void h()
    {
        f.d();
        f.b();
        h.a();
    }

    public boolean hasCriticalErrors()
    {
        return s || t;
    }

    protected void initialize(String s1, AppLovinSdkSettings applovinsdksettings, Context context)
    {
        a = s1;
        b = applovinsdksettings;
        c = context;
        context = new k();
        d = context;
        f = new bu(this);
        e = new cj(this);
        g = new o(this);
        h = new bw(this);
        i = new x(this);
        m = new f(this);
        n = new bc(this);
        o = new PostbackServiceImpl(this);
        j = new c(this);
        k = new ba(this);
        l = new m(this);
        if (!i())
        {
            s = true;
            Log.e("AppLovinSdk", "Unable to initalize AppLovin SDK: Android SDK version has to be at least level 8");
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (s1.length() >= 1)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        t = true;
        Log.e("AppLovinSdk", "Unable to find AppLovin SDK key. Please add     meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
        s1 = new StringWriter();
        (new Throwable("")).printStackTrace(new PrintWriter(s1));
        s1 = s1.toString();
        Log.e("AppLovinSdk", (new StringBuilder()).append("Called with an invalid SDK key from: ").append(s1).toString());
        if (!hasCriticalErrors())
        {
            context.a(f);
            if (applovinsdksettings instanceof av)
            {
                context.a(((av)applovinsdksettings).a());
            }
            f.c();
            if (((Boolean)f.a(br.b)).booleanValue())
            {
                f.a(applovinsdksettings);
                f.b();
            }
            g();
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
        return q;
    }

    public void setPluginVersion(String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("No version specified");
        } else
        {
            f.a(br.F, s1);
            f.b();
            return;
        }
    }
}
