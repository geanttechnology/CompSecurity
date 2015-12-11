// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.app.Activity;
import android.content.Context;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            AnalyticsService, Category, Action, Variable

public class GoogleAnalyticsService
    implements AnalyticsService
{

    private final Context context;
    PreferenceUtils preferenceUtils;
    private final Tracker tracker;

    public GoogleAnalyticsService(Tracker tracker1, Context context1)
    {
        ((InjectorApplication)context1).inject(this);
        tracker = tracker1;
        context = context1;
        setupTrackerCohorts();
    }

    private void checkIfUserSharedXTimes(Integer integer, Integer integer1)
    {
        if (integer1 == integer)
        {
            sendEvent(Category.SHARE_COUNT, Action.CLICK, integer1.toString());
        }
    }

    private String formatDate(Date date, String s, String s1)
    {
        s = new SimpleDateFormat(s);
        s.setTimeZone(TimeZone.getTimeZone(s1));
        return s.format(date);
    }

    private void setupTrackerCohorts()
    {
        String s = preferenceUtils.getString(0x7f06003e, null);
        Object obj;
        String s1;
        if (s == null)
        {
            obj = new Date();
            s = formatDate(((Date) (obj)), "yyyy-MM-dd", "GMT");
            preferenceUtils.putString(0x7f06003e, s);
        } else
        {
            try
            {
                obj = (new SimpleDateFormat("yyyy-MM-dd")).parse(s);
            }
            catch (ParseException parseexception)
            {
                parseexception = new Date();
            }
        }
        s1 = String.format("%02d", new Object[] {
            Integer.valueOf((int)Math.floor((Integer.parseInt(formatDate(((Date) (obj)), "D", "GMT")) - 1) / 7))
        });
        obj = (new StringBuilder()).append(formatDate(((Date) (obj)), "yyyy-", "GMT")).append(s1).toString();
        tracker.send(((com.google.android.gms.analytics.HitBuilders.EventBuilder)((com.google.android.gms.analytics.HitBuilders.EventBuilder)(new com.google.android.gms.analytics.HitBuilders.EventBuilder(Category.ANALYTICS.toString(), Action.INITIALIZE.toString())).setCustomDimension(2, s)).setCustomDimension(3, ((String) (obj)))).build());
    }

    public void incrementTotalShareCount(PreferenceUtils preferenceutils)
    {
        Integer integer = Integer.valueOf(preferenceutils.getInt(0x7f0600ec, 0).intValue() + 1);
        preferenceutils.putInt(0x7f0600ec, integer.intValue());
        preferenceutils = new int[13];
        PreferenceUtils _tmp = preferenceutils;
        preferenceutils[0] = 1;
        preferenceutils[1] = 5;
        preferenceutils[2] = 10;
        preferenceutils[3] = 20;
        preferenceutils[4] = 30;
        preferenceutils[5] = 40;
        preferenceutils[6] = 50;
        preferenceutils[7] = 100;
        preferenceutils[8] = 200;
        preferenceutils[9] = 300;
        preferenceutils[10] = 400;
        preferenceutils[11] = 500;
        preferenceutils[12] = 1000;
        for (int i = 0; i < preferenceutils.length; i++)
        {
            checkIfUserSharedXTimes(Integer.valueOf(preferenceutils[i]), integer);
        }

    }

    public void reportStart(Activity activity)
    {
        GoogleAnalytics.getInstance(activity.getApplication()).reportActivityStart(activity);
    }

    public void reportStop(Activity activity)
    {
        GoogleAnalytics.getInstance(activity.getApplication()).reportActivityStop(activity);
    }

    public void sendEvent(Category category, Action action, String s)
    {
        tracker.send((new com.google.android.gms.analytics.HitBuilders.EventBuilder(category.toString(), action.toString())).setLabel(s).build());
    }

    public void sendEvent(Category category, Action action, String s, long l)
    {
        tracker.send((new com.google.android.gms.analytics.HitBuilders.EventBuilder(category.toString(), action.toString())).setLabel(s).setValue(l).build());
    }

    public void sendTiming(Category category, Variable variable, long l, String s)
    {
        if (category == null)
        {
            return;
        } else
        {
            tracker.send((new com.google.android.gms.analytics.HitBuilders.TimingBuilder()).setCategory(category.toString()).setValue(l).setVariable(variable.toString()).setLabel(s).build());
            return;
        }
    }
}
