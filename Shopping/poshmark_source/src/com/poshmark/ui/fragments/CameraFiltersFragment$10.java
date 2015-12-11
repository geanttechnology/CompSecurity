// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.AsyncTask;
import android.view.View;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            CameraFiltersFragment

class this._cls0
    implements android.view.sFragment._cls10
{

    final CameraFiltersFragment this$0;

    public void onClick(View view)
    {
        currentFilter = terType.FILTER_TYPE_CLASSIC;
        view = new lyFilter(CameraFiltersFragment.this, null);
        String as[] = new String[1];
        as[0] = currentFilter.toString();
        if (!(view instanceof AsyncTask))
        {
            view.execute(as);
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)view, as);
        }
        view = CameraFiltersFragment.access$000(CameraFiltersFragment.this, currentFilter);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view);
    }

    kInstrumentation()
    {
        this$0 = CameraFiltersFragment.this;
        super();
    }
}
