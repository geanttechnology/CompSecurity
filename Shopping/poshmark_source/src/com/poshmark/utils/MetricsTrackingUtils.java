// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Activity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.data_model.models.TrackingGoal;
import com.poshmark.ui.PMActivity;
import java.util.List;

public class MetricsTrackingUtils
{

    public MetricsTrackingUtils()
    {
    }

    public static String getTrackingJson(Activity activity, String s)
    {
label0:
        {
            Object obj = null;
            Object obj1 = (PMActivity)activity;
            activity = obj;
            if (obj1 != null)
            {
                obj1 = ((PMActivity) (obj1)).getScreenNavigationStack();
                activity = obj;
                if (obj1 != null)
                {
                    activity = obj;
                    if (((List) (obj1)).size() > 0)
                    {
                        activity = new TrackingGoal(s, ((List) (obj1)));
                        s = (new GsonBuilder()).create();
                        if (s instanceof Gson)
                        {
                            break label0;
                        }
                        activity = s.toJson(activity, com/poshmark/data_model/models/TrackingGoal);
                    }
                }
            }
            return activity;
        }
        return GsonInstrumentation.toJson((Gson)s, activity, com/poshmark/data_model/models/TrackingGoal);
    }

    public static String getTrackingStackAsJson(Activity activity)
    {
        Object obj1;
label0:
        {
            Object obj = null;
            obj1 = (PMActivity)activity;
            activity = obj;
            if (obj1 != null)
            {
                obj1 = ((PMActivity) (obj1)).getScreenNavigationStack();
                activity = obj;
                if (obj1 != null)
                {
                    activity = obj;
                    if (((List) (obj1)).size() > 0)
                    {
                        activity = (new GsonBuilder()).create();
                        if (activity instanceof Gson)
                        {
                            break label0;
                        }
                        activity = activity.toJson(obj1, java/util/List);
                    }
                }
            }
            return activity;
        }
        return GsonInstrumentation.toJson((Gson)activity, obj1, java/util/List);
    }
}
