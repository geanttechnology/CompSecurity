// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.ViewActivity;
import com.apptentive.android.sdk.model.CodePointStore;
import com.apptentive.android.sdk.model.Event;
import com.apptentive.android.sdk.model.EventManager;
import com.apptentive.android.sdk.model.ExtendedData;
import com.apptentive.android.sdk.module.engagement.interaction.InteractionManager;
import com.apptentive.android.sdk.module.engagement.interaction.model.Interaction;
import com.apptentive.android.sdk.module.metric.MetricModule;
import java.util.Map;

public class EngagementModule
{

    public EngagementModule()
    {
    }

    public static boolean doEngage(Activity activity, String s)
    {
        s = InteractionManager.getApplicableInteraction(activity.getApplicationContext(), s);
        if (s != null)
        {
            CodePointStore.storeInteractionForCurrentAppVersion(activity, s.getId());
            launchInteraction(activity, s);
            return true;
        } else
        {
            Log.d("No interaction to show.", new Object[0]);
            return false;
        }
    }

    private static String encodeEventLabelPart(String s)
    {
        return s.replace("%", "%25").replace("/", "%2F").replace("#", "%23");
    }

    public static transient boolean engage(Activity activity, String s, String s1, String s2, String s3, String s4, Map map, ExtendedData aextendeddata[])
    {
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorenter ;
        boolean flag;
        s = generateEventLabel(s, s1, s3);
        Log.d("engage(%s)", new Object[] {
            s
        });
        CodePointStore.storeCodePointForCurrentAppVersion(activity.getApplicationContext(), s);
        EventManager.sendEvent(activity.getApplicationContext(), new Event(s, s2, s4, map, aextendeddata));
        flag = doEngage(activity, s);
_L2:
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorexit ;
        return flag;
        s;
        MetricModule.sendError(activity.getApplicationContext(), s, null, null);
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        activity;
        throw activity;
    }

    public static boolean engageInternal(Activity activity, Interaction interaction, String s)
    {
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorenter ;
        boolean flag = engage(activity, "com.apptentive", interaction.getType().name(), interaction.getId(), s, null, null, null);
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorexit ;
        return flag;
        activity;
        throw activity;
    }

    public static boolean engageInternal(Activity activity, Interaction interaction, String s, String s1)
    {
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorenter ;
        boolean flag = engage(activity, "com.apptentive", interaction.getType().name(), interaction.getId(), s, s1, null, null);
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorexit ;
        return flag;
        activity;
        throw activity;
    }

    public static boolean engageInternal(Activity activity, String s)
    {
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorenter ;
        boolean flag = engage(activity, "com.apptentive", "app", null, s, null, null, null);
        com/apptentive/android/sdk/module/engagement/EngagementModule;
        JVM INSTR monitorexit ;
        return flag;
        activity;
        throw activity;
    }

    public static String generateEventLabel(String s, String s1, String s2)
    {
        return String.format("%s#%s#%s", new Object[] {
            encodeEventLabelPart(s), encodeEventLabelPart(s1), encodeEventLabelPart(s2)
        });
    }

    public static void launchInteraction(Activity activity, Interaction interaction)
    {
        if (interaction != null)
        {
            Log.i("Launching interaction: %s", new Object[] {
                interaction.getType().toString()
            });
            Intent intent = new Intent();
            intent.setClass(activity, com/apptentive/android/sdk/ViewActivity);
            intent.putExtra("activityContent", com.apptentive.android.sdk.module.ActivityContent.Type.INTERACTION.toString());
            intent.putExtra("interaction", interaction.toString());
            activity.startActivity(intent);
            activity.overridePendingTransition(com.apptentive.android.sdk.R.anim.slide_up_in, 0);
        }
    }

    private static boolean willShowInteraction(Context context, String s)
    {
        return InteractionManager.getApplicableInteraction(context, s) != null;
    }

    public static boolean willShowInteraction(Context context, String s, String s1, String s2)
    {
        return willShowInteraction(context, generateEventLabel(s, s1, s2));
    }
}
