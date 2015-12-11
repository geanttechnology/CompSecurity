// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.content.Context;
import com.crittercism.app.Crittercism;
import com.google.android.gms.analytics.Tracker;
import com.groupon.http.Http;
import com.groupon.provider.GaTrackerProvider;
import com.groupon.service.countryanddivision.CurrentCountryService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class Tracking
{

    private Application context;
    private CurrentCountryService currentCountryService;
    private InternetUsDateFormat internalUsDateFormat;
    private GaTrackerProvider trackerProvider;

    public Tracking()
    {
    }

    public Tracking(Application application)
    {
        context = application;
        RoboGuice.getInjector(application).injectMembers(this);
    }

    protected String toSafeLabelString(String s)
    {
        String s1 = Strings.toString(s).replaceAll("\\W+", "_");
        s = s1;
        if (s1.length() > 30)
        {
            s = s1.substring(0, 30);
        }
        return s;
    }

    public void trackEvent(String s, String s1, String s2, int i)
    {
        s = toSafeLabelString(s);
        s1 = toSafeLabelString(s1);
        s2 = toSafeLabelString(s2);
        Ln.d("Tracking Event: %s, %s, %s, %s", new Object[] {
            s, s1, s2, Integer.valueOf(i)
        });
        trackerProvider.get().send((new com.google.android.gms.analytics.HitBuilders.EventBuilder()).setCategory(s).setAction(s1).setLabel(s2).setValue(i).build());
        s = new ArrayList(Arrays.asList(new String[] {
            "category", s, "action", s1, "label", s2, "value", Strings.toString(Integer.valueOf(i)), "ts", internalUsDateFormat.format(new Date())
        }));
        (new Http(context, java/lang/String, (new StringBuilder()).append(currentCountryService.getUSBaseUrl()).append("/mobile/logs/analytic/event.gif").toString(), s.toArray()) {

            final Tracking this$0;

            protected void onException(Exception exception)
            {
            }

            transient 
            {
                this$0 = Tracking.this;
                super(context1, class1, s, aobj);
            }
        }).setAuthorizationRequired(false).execute();
    }

    public void trackPageView(String s)
    {
        Ln.d("Tracking PageView: %s", new Object[] {
            s
        });
        Tracker tracker = trackerProvider.get();
        tracker.setScreenName(s);
        tracker.send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
        Crittercism.leaveBreadcrumb(s);
    }
}
