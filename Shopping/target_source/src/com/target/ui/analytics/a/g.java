// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.content.Context;
import com.b.a.a.e;
import com.target.a.a.a;
import com.target.ui.analytics.b.d;
import com.target.ui.analytics.f;
import de.greenrobot.event.EventBus;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            h

public class g
{

    private static final String DEV_PREPEND = "";
    private static final String TAG = com/target/ui/analytics/a/g.getSimpleName();
    private static g sInstance;
    private final com.target.ui.analytics.a mAdvertisingIdProvider;
    private volatile a.a mCachedPreviousScreen;
    private final Context mContext;
    private final h mEventAdapterSubPub = new h();
    private final f mLifecycleMetricsTracker;
    private final e mTracker;

    private g(a a1)
    {
        mContext = a1.a();
        mTracker = com.b.a.a.a.a(a1.a()).a("1MxJP5F");
        mTracker.a(false);
        mLifecycleMetricsTracker = new f(a1);
        mAdvertisingIdProvider = new com.target.ui.analytics.a(a1);
    }

    static g a()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("please call AnalyticsController.init() before calling getInstance()");
        } else
        {
            return sInstance;
        }
    }

    public static void a(a a1)
    {
        sInstance = new g(a1);
        com.target.ui.util.c.a.a().register(sInstance.mEventAdapterSubPub);
    }

    void a(a.a a1)
    {
        mCachedPreviousScreen = a1;
    }

    void a(String s, Map map)
    {
        s = (new StringBuilder()).append("").append(s).toString();
        String s1 = (String)map.get("screenName");
        if (s1 != null)
        {
            com.target.ui.util.c.a.a().post(new d(s1));
        }
        mTracker.a(s, map);
    }

    Context b()
    {
        return mContext;
    }

    f c()
    {
        return mLifecycleMetricsTracker;
    }

    com.target.ui.analytics.a d()
    {
        return mAdvertisingIdProvider;
    }

    a.a e()
    {
        return mCachedPreviousScreen;
    }

}
