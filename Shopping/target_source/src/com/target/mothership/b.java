// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.f.h;
import com.google.b.g;
import com.target.mothership.b.a;
import com.target.mothership.cache.d;
import com.target.mothership.services.a.a.b.a.c;
import com.target.mothership.services.apigee.c.a.u;
import com.target.mothership.services.apigee.c.b.ad;
import com.target.mothership.services.apigee.c.b.ah;
import com.target.mothership.services.apigee.c.b.ai;
import com.target.mothership.services.apigee.c.b.aj;
import com.target.mothership.services.apigee.c.b.ak;
import com.target.mothership.services.apigee.c.b.f;
import com.target.mothership.services.apigee.c.b.n;
import com.target.mothership.services.apigee.c.b.w;
import com.target.mothership.services.apigee.c.b.y;
import com.target.mothership.services.apigee.c.b.z;
import com.target.mothership.services.apigee.f.a.j;
import com.target.mothership.services.apigee.f.a.k;
import com.target.mothership.services.apigee.f.a.m;
import com.target.mothership.services.e;
import com.target.mothership.services.i;
import com.target.mothership.services.l;
import com.target.mothership.services.p;

// Referenced classes of package com.target.mothership:
//            a

public class b
{
    public static class a
    {

        private final String mAppVersion;
        private final String mDeviceBuild;
        private final String mDeviceManufacturer;
        private final String mDeviceModel;
        private final String mDeviceReleaseVersion;

        public String a()
        {
            return mAppVersion;
        }

        public String b()
        {
            return mDeviceModel;
        }

        public String c()
        {
            return mDeviceReleaseVersion;
        }

        public String d()
        {
            return mDeviceBuild;
        }

        public String e()
        {
            return mDeviceManufacturer;
        }

        a(String s, String s1, String s2, String s3, String s4)
        {
            mAppVersion = s;
            mDeviceModel = s1;
            mDeviceReleaseVersion = s2;
            mDeviceBuild = s3;
            mDeviceManufacturer = s4;
        }
    }


    public static final String TAG = com/target/mothership/b.getSimpleName();
    private static final String UNKNOWN_APP_VERSION = "VERSION_UNKNOWN";
    private static b sInstance;
    private final d mDatabaseHandler;
    private final com.target.mothership.b.b mDebugServer;
    private final a mDeviceSpec;
    private final com.google.b.f mGson = o();
    private final com.target.mothership.services.f.b.a mHostProvider;
    private final p mRequestSender;
    private final com.target.mothership.a mTGTLibraryConfig;
    private final String mUniqueDeviceId;
    private final String mUserAgent;

    private b(com.target.mothership.a a1)
    {
        mTGTLibraryConfig = a1;
        h h1 = b(a1);
        mRequestSender = (p)h1.a;
        mDebugServer = (com.target.mothership.b.b)h1.b;
        mHostProvider = a1.h();
        mDatabaseHandler = new d(mTGTLibraryConfig.b());
        mDeviceSpec = a(a1.b());
        mUserAgent = a(mDeviceSpec);
        mUniqueDeviceId = b(a1.b());
    }

    private a a(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        String s = "VERSION_UNKNOWN";
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.target.a.a.b.a(TAG, "Unable to find the app package");
            context = s;
        }
        return new a(context, Build.MODEL, android.os.Build.VERSION.RELEASE, Build.ID, Build.MANUFACTURER);
    }

    public static b a()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("No instance of TGTServices found.  Have you called TGTServices.init()?");
        } else
        {
            return sInstance;
        }
    }

    private String a(a a1)
    {
        String s = (new StringBuilder()).append("Target/").append(a1.a()).toString();
        String s1 = (new StringBuilder()).append("Android ").append(a1.c()).toString();
        String s2 = a1.e();
        String s3 = a1.b();
        a1 = (new StringBuilder()).append("Build/").append(a1.d()).toString();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        stringbuilder.append(" ");
        stringbuilder.append('(');
        stringbuilder.append(s1);
        stringbuilder.append("; ");
        stringbuilder.append(s2);
        stringbuilder.append(" ");
        stringbuilder.append(s3);
        stringbuilder.append(" ");
        stringbuilder.append(a1);
        stringbuilder.append(')');
        return stringbuilder.toString();
    }

    static void a(com.target.mothership.a a1)
    {
        sInstance = new b(a1);
    }

    private h b(com.target.mothership.a a1)
    {
        com.target.mothership.b.b b1 = null;
        Object obj;
        Object obj1;
        if (a1.m() != null)
        {
            obj = a1.m();
        } else
        if (a1.i() == c.a.Debug)
        {
            b1 = new com.target.mothership.b.b(a1.b());
            obj = new com.target.mothership.b.a(b1, false);
        } else
        {
            obj = new e(a1.b());
        }
        obj1 = obj;
        if (a1.k())
        {
            obj1 = com.target.mothership.services.l.a(((p) (obj)));
        }
        obj = obj1;
        if (a1.n() != null)
        {
            obj = new i(a1.n(), ((p) (obj1)));
        }
        return android.support.v4.f.h.a(obj, b1);
    }

    private String b(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private com.google.b.f o()
    {
        return (new g()).a(com/target/mothership/services/apigee/g/a/a, new com.target.mothership.services.apigee.g.a.a.b()).a(com/target/mothership/services/apigee/g/a/b, new com.target.mothership.services.apigee.g.a.a()).a(com/target/mothership/services/apigee/f/a/m, new com.target.mothership.services.apigee.f.a.m.a()).a(com/target/mothership/services/apigee/f/a/e, new com.target.mothership.services.apigee.f.a.e.a()).a(com/target/mothership/services/apigee/f/a/j, new com.target.mothership.services.apigee.f.a.j.a()).a(com/target/mothership/services/apigee/f/a/a, new com.target.mothership.services.apigee.f.a.a.a()).a(com/target/mothership/services/apigee/f/a/b, new com.target.mothership.services.apigee.f.a.a()).a(com/target/mothership/services/apigee/f/a/d, new com.target.mothership.services.apigee.f.a.d.a()).a(com/target/mothership/services/apigee/c/a/u, new com.target.mothership.services.apigee.c.a.u.a()).a(com/target/mothership/services/apigee/f/a/k, new com.target.mothership.services.apigee.f.a.k.a()).a(com/target/mothership/services/apigee/c/b/a, new com.target.mothership.services.apigee.c.b.a.a()).a(com/target/mothership/services/apigee/c/b/f, new com.target.mothership.services.apigee.c.b.f.a()).a(com/target/mothership/services/apigee/c/b/ak, new com.target.mothership.services.apigee.c.b.ak.a()).a(com/target/mothership/services/apigee/c/b/z, new com.target.mothership.services.apigee.c.b.z.b()).a(com/target/mothership/services/apigee/c/b/aj, new com.target.mothership.services.apigee.c.b.aj.b()).a(com/target/mothership/services/apigee/c/b/w, new com.target.mothership.services.apigee.c.b.w.a()).a(com/target/mothership/services/apigee/c/b/m, new com.target.mothership.services.apigee.c.b.m.b()).a(com/target/mothership/services/apigee/c/b/n, new com.target.mothership.services.apigee.c.b.n.a()).a(com/target/mothership/services/apigee/c/b/ad, new com.target.mothership.services.apigee.c.b.ad.a()).a(com/target/mothership/services/apigee/c/b/ai, new com.target.mothership.services.apigee.c.b.ai.a()).a(com/target/mothership/services/apigee/c/b/ah, new com.target.mothership.services.apigee.c.b.ah.a()).a(com/target/mothership/services/apigee/f/b/n, new com.target.mothership.services.apigee.f.b.n.a()).a(com/target/mothership/services/apigee/n/b/a/b, new com.target.mothership.services.apigee.n.b.a.a()).a(com/target/mothership/services/e/h/b/a, new com.target.mothership.services.e.h.b.a.a()).a(com/target/mothership/services/a/a/b/a/c, new com.target.mothership.services.a.a.b.a.c.a()).a(com/target/mothership/services/a/a/b/a/f, new com.target.mothership.services.a.a.b.a.f.a()).a(com/target/mothership/services/apigee/f/b/j, new com.target.mothership.services.apigee.f.b.j.a()).a(com/target/mothership/services/apigee/f/b/l, new com.target.mothership.services.apigee.f.b.l.a()).a(com/target/mothership/services/apigee/f/b/k, new com.target.mothership.services.apigee.f.b.k.a()).a(com/target/mothership/services/apigee/f/b/m, new com.target.mothership.services.apigee.f.b.m.a()).a(com/target/mothership/services/apigee/j/b/c, new com.target.mothership.services.apigee.j.b.c.c()).a(com/target/mothership/services/apigee/j/b/e, new com.target.mothership.services.apigee.j.b.e.b()).a(com/target/mothership/services/apigee/c/b/y, new com.target.mothership.services.apigee.c.b.y.a()).d();
    }

    public void a(com.target.mothership.services.f.a.b b1, com.target.mothership.services.a a1)
    {
        mRequestSender.a(b1, a1, a1.c());
    }

    public void a(String s)
    {
        mRequestSender.a(s);
    }

    public com.target.mothership.services.f.b.a b()
    {
        return mHostProvider;
    }

    public String c()
    {
        return mTGTLibraryConfig.c();
    }

    public String d()
    {
        return mTGTLibraryConfig.d();
    }

    public String e()
    {
        return mTGTLibraryConfig.e();
    }

    public String f()
    {
        return mTGTLibraryConfig.f();
    }

    public String g()
    {
        return mTGTLibraryConfig.g();
    }

    public String h()
    {
        return mUserAgent;
    }

    public a i()
    {
        return mDeviceSpec;
    }

    public String j()
    {
        return mUniqueDeviceId;
    }

    public com.google.b.f k()
    {
        return mGson;
    }

    public d l()
    {
        return mDatabaseHandler;
    }

    public boolean m()
    {
        return mTGTLibraryConfig.i() == c.a.Debug;
    }

    public com.target.mothership.b.b n()
    {
        return mDebugServer;
    }

}
