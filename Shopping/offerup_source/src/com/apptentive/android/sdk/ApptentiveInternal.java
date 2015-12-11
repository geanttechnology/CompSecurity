// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.rating.IRatingProvider;
import com.apptentive.android.sdk.module.rating.impl.GooglePlayRatingProvider;
import com.apptentive.android.sdk.module.survey.OnSurveyFinishedListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk:
//            Log

public class ApptentiveInternal
{

    static final String APPTENTIVE_PUSH_EXTRA_KEY = "apptentive";
    static final String PARSE_PUSH_EXTRA_KEY = "com.parse.Data";
    public static final String PUSH_ACTION = "action";
    private static OnSurveyFinishedListener onSurveyFinishedListener;
    private static String pushCallbackActivityName;
    private static IRatingProvider ratingProvider;
    private static Map ratingProviderArgs;

    public ApptentiveInternal()
    {
    }

    static String getApptentivePushNotificationData(Intent intent)
    {
label0:
        {
            String s = null;
            if (intent != null)
            {
                Log.v("Got an Intent.", new Object[0]);
                if (!intent.hasExtra("com.parse.Data"))
                {
                    break label0;
                }
                intent = intent.getStringExtra("com.parse.Data");
                Log.v("Got a Parse Push.", new Object[0]);
                try
                {
                    s = (new JSONObject(intent)).optString("apptentive", null);
                }
                catch (JSONException jsonexception)
                {
                    Log.e("Corrupt Parse String Extra: %s", new Object[] {
                        intent
                    });
                    return null;
                }
            }
            return s;
        }
        Log.v("Got a non-Parse push.", new Object[0]);
        return intent.getStringExtra("apptentive");
    }

    static String getApptentivePushNotificationData(Bundle bundle)
    {
        if (bundle != null)
        {
            return bundle.getString("apptentive");
        } else
        {
            return null;
        }
    }

    public static OnSurveyFinishedListener getOnSurveyFinishedListener()
    {
        return onSurveyFinishedListener;
    }

    public static String getPushCallbackActivityName()
    {
        return pushCallbackActivityName;
    }

    public static IRatingProvider getRatingProvider()
    {
        if (ratingProvider == null)
        {
            ratingProvider = new GooglePlayRatingProvider();
        }
        return ratingProvider;
    }

    public static Map getRatingProviderArgs()
    {
        return ratingProviderArgs;
    }

    public static void onAppLaunch(Activity activity)
    {
        EngagementModule.engageInternal(activity, com.apptentive.android.sdk.model.Event.EventLabel.app__launch.getLabelName());
    }

    public static void putRatingProviderArg(String s, String s1)
    {
        if (ratingProviderArgs == null)
        {
            ratingProviderArgs = new HashMap();
        }
        ratingProviderArgs.put(s, s1);
    }

    public static void setMinimumLogLevel(Log.Level level)
    {
        Log.overrideLogLevel(level);
    }

    public static void setOnSurveyFinishedListener(OnSurveyFinishedListener onsurveyfinishedlistener)
    {
        onSurveyFinishedListener = onsurveyfinishedlistener;
    }

    static boolean setPendingPushNotification(Context context, String s)
    {
        boolean flag = false;
        if (s != null)
        {
            Log.d("Saving Apptentive push notification data.", new Object[0]);
            context.getSharedPreferences("APPTENTIVE", 0).edit().putString("pendingPushNotification", s).commit();
            flag = true;
        }
        return flag;
    }

    public static void setPushCallbackActivity(Class class1)
    {
        pushCallbackActivityName = class1.getName();
        Log.d("Setting push callback activity name to %s", new Object[] {
            pushCallbackActivityName
        });
    }

    public static void setRatingProvider(IRatingProvider iratingprovider)
    {
        ratingProvider = iratingprovider;
    }
}
