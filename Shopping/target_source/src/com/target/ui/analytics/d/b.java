// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.d;

import com.newrelic.agent.android.NewRelic;
import com.target.ui.analytics.d;
import com.target.ui.util.c.a;
import com.target.ui.util.q;
import de.greenrobot.event.EventBus;
import java.util.Map;

public class b
{

    private static final String LOG_TAG = com/target/ui/analytics/d/b.getSimpleName();
    private static b sInstance;

    public b()
    {
        com.target.ui.util.c.a.a().register(this);
    }

    public static void a()
    {
        sInstance = new b();
    }

    private void a(String s, Map map)
    {
        q.d(LOG_TAG, (new StringBuilder()).append("Reporting event with name: ").append(s).toString());
        NewRelic.recordEvent(s, map);
    }

    public void onHighProfileHandledErrorEvent(com.target.ui.analytics.b.b b1)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put("high_profile_handled_error_name", b1.mEventName);
        a1.put("high_profile_handled_error_stack_trace", b1.mStackTrace);
        d.a(a1, "high_profile_handled_error_info1", b1.mExtraInfoField1);
        d.a(a1, "high_profile_handled_error_info2", b1.mExtraInfoField2);
        d.a(a1, "high_profile_handled_error_info3", b1.mExtraInfoField3);
        d.a(a1, "high_profile_handled_error_info4", b1.mExtraInfoField4);
        d.a(a1, "high_profile_handled_error_info5", b1.mExtraInfoField5);
        a("HighProfileHandledError", a1);
    }

}
