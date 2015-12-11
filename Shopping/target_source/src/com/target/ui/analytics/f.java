// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.target.a.a.a;
import com.target.ui.util.g;
import com.target.ui.util.j;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class f
{
    private class a
        implements android.app.Application.ActivityLifecycleCallbacks
    {

        final f this$0;

        public void onActivityCreated(Activity activity, Bundle bundle)
        {
        }

        public void onActivityDestroyed(Activity activity)
        {
        }

        public void onActivityPaused(Activity activity)
        {
            f.c(f.this).execute(new c());
        }

        public void onActivityResumed(Activity activity)
        {
            f.c(f.this).execute(new d());
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
        {
        }

        public void onActivityStarted(Activity activity)
        {
        }

        public void onActivityStopped(Activity activity)
        {
        }

        private a()
        {
            this$0 = f.this;
            super();
        }

    }

    private abstract class b
        implements Runnable
    {

        final long submittedTime;
        final f this$0;

        abstract void a();

        boolean a(int i, TimeUnit timeunit, long l)
        {
            long l1 = timeunit.toMillis(i);
            return submittedTime > l1 + l;
        }

        public void run()
        {
            try
            {
                a();
                return;
            }
            catch (Exception exception)
            {
                com.target.a.a.b.a(f.c(), "Error while trying to perform lifecycle metrics work: ", exception);
            }
        }

        private b()
        {
            this$0 = f.this;
            super();
            submittedTime = System.currentTimeMillis();
        }

    }

    private class c extends b
    {

        final f this$0;

        void a()
        {
            com.target.ui.analytics.f.a(f.this, "latestAppNoLongerVisibleTimestamp", submittedTime);
        }

        private c()
        {
            this$0 = f.this;
            super();
        }

    }

    private class d extends b
    {

        final f this$0;

        private int a(String s)
        {
            return b(com.target.ui.analytics.f.a(f.this).getLong(s, 0L));
        }

        private void a(long l)
        {
            if (!com.target.ui.analytics.f.a(f.this).contains("firstLaunchFollowingInitialInstallTimestamp"))
            {
                com.target.ui.analytics.f.a(f.this, "firstLaunchFollowingInitialInstallTimestamp", l);
            }
            f.b(f.this, "totalAppLaunchCount");
            f.b(f.this, "appLaunchesThisVersion");
        }

        private boolean a(int i, TimeUnit timeunit, String s)
        {
            return a(i, timeunit, g.a(com.target.ui.analytics.f.a(f.this).getLong(s, 0L)));
        }

        private int b(long l)
        {
            long l1 = System.currentTimeMillis();
            return (int)TimeUnit.MILLISECONDS.toDays(l1 - l);
        }

        private boolean b()
        {
            long l = com.target.ui.analytics.f.a(f.this).getLong("latestAppNoLongerVisibleTimestamp", 0L);
            return a(3, TimeUnit.MINUTES, l) || d();
        }

        private void c()
        {
            com.target.ui.analytics.f.a(f.this, "appLaunchesThisVersion");
            com.target.ui.analytics.f.a(f.this, "daysEngagementCountThisVersion");
            com.target.ui.analytics.f.a(f.this, "lastRecordedAppVersion", j.a(f.b(f.this)));
        }

        private boolean d()
        {
            boolean flag = false;
            int i = com.target.ui.analytics.f.a(f.this).getInt("lastRecordedAppVersion", 0);
            if (j.a(f.b(f.this)) != i)
            {
                flag = true;
            }
            return flag;
        }

        private void e()
        {
            if (!a(1, TimeUnit.DAYS, "latestDayEngagementCountIncrementedTimestamp"))
            {
                return;
            }
            if (a(30, TimeUnit.DAYS, "latestMonthEngagementCountResetTimestamp"))
            {
                com.target.ui.analytics.f.a(f.this, "daysEngagementCountThisMonth");
                com.target.ui.analytics.f.a(f.this, "latestMonthEngagementCountResetTimestamp", submittedTime);
            }
            com.target.ui.analytics.f.a(f.this, "latestDayEngagementCountIncrementedTimestamp", submittedTime);
            f.b(f.this, "daysEngagementCount");
            f.b(f.this, "daysEngagementCountThisVersion");
            f.b(f.this, "daysEngagementCountThisMonth");
        }

        private void f()
        {
            PackageInfo packageinfo = j.b(f.b(f.this));
            com.target.ui.analytics.b.c.b().d(a("firstLaunchFollowingInitialInstallTimestamp")).f(b(packageinfo.lastUpdateTime)).e(a("latestAppNoLongerVisibleTimestamp")).a(com.target.ui.analytics.f.a(f.this).getInt("daysEngagementCount", 0)).c(com.target.ui.analytics.f.a(f.this).getInt("daysEngagementCountThisVersion", 0)).b(com.target.ui.analytics.f.a(f.this).getInt("daysEngagementCountThisMonth", 0)).a().a();
        }

        void a()
        {
            if (!b())
            {
                return;
            }
            com.target.ui.analytics.f.a(f.this, "latestSessionStartTimestamp", submittedTime);
            if (d())
            {
                c();
            }
            a(submittedTime);
            e();
            f();
        }

        private d()
        {
            this$0 = f.this;
            super();
        }

    }


    private static final String LOG_TAG = com/target/ui/analytics/f.getSimpleName();
    private static final String PREFS_BUCKET_NAME = "analyticsSharedPrefs";
    private static final int SESSION_TIMEOUT_MINUTES = 3;
    private final Context mContext;
    private final Executor mExecutor = Executors.newSingleThreadExecutor();
    private final SharedPreferences mPrefs;

    public f(com.target.a.a.a a1)
    {
        mContext = a1.a();
        mPrefs = mContext.getSharedPreferences("analyticsSharedPrefs", 0);
        ((Application)mContext).registerActivityLifecycleCallbacks(new a());
    }

    static SharedPreferences a(f f1)
    {
        return f1.mPrefs;
    }

    static void a(f f1, String s)
    {
        f1.b(s);
    }

    static void a(f f1, String s, int i)
    {
        f1.a(s, i);
    }

    static void a(f f1, String s, long l)
    {
        f1.a(s, l);
    }

    private void a(String s)
    {
        a(s, mPrefs.getInt(s, 0) + 1);
    }

    private void a(String s, int i)
    {
        mPrefs.edit().putInt(s, i).apply();
    }

    private void a(String s, long l)
    {
        mPrefs.edit().putLong(s, l).apply();
    }

    static Context b(f f1)
    {
        return f1.mContext;
    }

    static void b(f f1, String s)
    {
        f1.a(s);
    }

    private void b(String s)
    {
        a(s, 0);
    }

    static String c()
    {
        return LOG_TAG;
    }

    static Executor c(f f1)
    {
        return f1.mExecutor;
    }

    public int a()
    {
        return mPrefs.getInt("totalAppLaunchCount", 0);
    }

    public int b()
    {
        return mPrefs.getInt("appLaunchesThisVersion", 0);
    }

}
