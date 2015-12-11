// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction;

import android.content.Context;
import android.content.SharedPreferences;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.comm.ApptentiveClient;
import com.apptentive.android.sdk.comm.ApptentiveHttpResponse;
import com.apptentive.android.sdk.module.engagement.interaction.model.Interaction;
import com.apptentive.android.sdk.module.engagement.interaction.model.Interactions;
import com.apptentive.android.sdk.module.engagement.interaction.model.InteractionsPayload;
import com.apptentive.android.sdk.module.engagement.interaction.model.Targets;
import com.apptentive.android.sdk.util.Util;
import java.util.Map;
import org.json.JSONException;

public class InteractionManager
{

    private static Interactions interactions;
    private static Boolean pollForInteractions;
    private static Targets targets;

    public InteractionManager()
    {
    }

    public static void asyncFetchAndStoreInteractions(final Context context)
    {
        if (!isPollForInteractions(context))
        {
            Log.v("Interaction polling is disabled.", new Object[0]);
            return;
        }
        if (hasCacheExpired(context))
        {
            Log.d("Interaction cache has expired. Fetching new interactions.", new Object[0]);
            _cls1 _lcls1 = new _cls1();
            _lcls1.setUncaughtExceptionHandler(new _cls2());
            _lcls1.setName("Apptentive-FetchInteractions");
            _lcls1.start();
            return;
        } else
        {
            Log.d("Interaction cache has not expired. Using existing interactions.", new Object[0]);
            return;
        }
    }

    public static void clear(Context context)
    {
        context = context.getSharedPreferences("APPTENTIVE", 0);
        context.edit().remove("interactions").commit();
        context.edit().remove("targets").commit();
        interactions = null;
        targets = null;
    }

    private static void fetchAndStoreInteractions(Context context)
    {
        Object obj = ApptentiveClient.getInteractions();
        if (obj != null && ((ApptentiveHttpResponse) (obj)).isSuccessful())
        {
            String s = ((ApptentiveHttpResponse) (obj)).getContent();
            Integer integer = Util.parseCacheControlHeader((String)((ApptentiveHttpResponse) (obj)).getHeaders().get("Cache-Control"));
            obj = integer;
            if (integer == null)
            {
                obj = Integer.valueOf(28800);
            }
            updateCacheExpiration(context, ((Integer) (obj)).intValue());
            storeInteractionsPayloadString(context, s);
        }
    }

    public static Interaction getApplicableInteraction(Context context, String s)
    {
        Targets targets1 = getTargets(context);
        if (targets1 != null)
        {
            s = targets1.getApplicableInteraction(context, s);
            if (s != null)
            {
                return getInteractions(context).getInteraction(s);
            }
        }
        return null;
    }

    public static Interactions getInteractions(Context context)
    {
        if (interactions == null)
        {
            loadInteractions(context);
        }
        return interactions;
    }

    public static Targets getTargets(Context context)
    {
        if (targets == null)
        {
            loadTargets(context);
        }
        return targets;
    }

    private static boolean hasCacheExpired(Context context)
    {
        boolean flag = false;
        if (context.getSharedPreferences("APPTENTIVE", 0).getLong("interactionsCacheExpiration", 0L) < System.currentTimeMillis())
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isPollForInteractions(Context context)
    {
        if (pollForInteractions == null)
        {
            pollForInteractions = Boolean.valueOf(context.getSharedPreferences("APPTENTIVE", 0).getBoolean("pollForInteractions", true));
        }
        return pollForInteractions.booleanValue();
    }

    private static Interactions loadInteractions(Context context)
    {
        context = context.getSharedPreferences("APPTENTIVE", 0).getString("interactions", null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        context = new Interactions(context);
        return context;
        context;
        Log.w("Exception creating Interactions object.", context, new Object[0]);
        return null;
    }

    private static Targets loadTargets(Context context)
    {
        context = context.getSharedPreferences("APPTENTIVE", 0).getString("targets", null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        context = new Targets(context);
        return context;
        context;
        Log.w("Exception creating Targets object.", context, new Object[0]);
        return null;
    }

    private static void saveInteractions(Context context)
    {
        context.getSharedPreferences("APPTENTIVE", 0).edit().putString("interactions", interactions.toString()).commit();
    }

    private static void saveTargets(Context context)
    {
        context.getSharedPreferences("APPTENTIVE", 0).edit().putString("targets", targets.toString()).commit();
    }

    public static void setPollForInteractions(Context context, boolean flag)
    {
        pollForInteractions = Boolean.valueOf(flag);
        context.getSharedPreferences("APPTENTIVE", 0).edit().putBoolean("pollForInteractions", flag).commit();
    }

    public static void storeInteractionsPayloadString(Context context, String s)
    {
        Object obj;
        obj = new InteractionsPayload(s);
        s = ((InteractionsPayload) (obj)).getInteractions();
        obj = ((InteractionsPayload) (obj)).getTargets();
        if (s != null && obj != null)
        {
            try
            {
                interactions = s;
                targets = ((Targets) (obj));
                saveInteractions(context);
                saveTargets(context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("Invalid InteractionsPayload received.", new Object[0]);
            }
            break MISSING_BLOCK_LABEL_64;
        }
        Log.e("Unable to save payloads.", new Object[0]);
        return;
    }

    private static void updateCacheExpiration(Context context, long l)
    {
        long l1 = System.currentTimeMillis();
        context.getSharedPreferences("APPTENTIVE", 0).edit().putLong("interactionsCacheExpiration", l1 + 1000L * l).commit();
    }


    private class _cls1 extends Thread
    {

        final Context val$context;

        public final void run()
        {
            InteractionManager.fetchAndStoreInteractions(context);
        }

        _cls1()
        {
            context = context1;
            super();
        }
    }


    private class _cls2
        implements Thread.UncaughtExceptionHandler
    {

        final Context val$context;

        public final void uncaughtException(Thread thread, Throwable throwable)
        {
            Log.w("UncaughtException in InteractionManager.", throwable, new Object[0]);
            MetricModule.sendError(context.getApplicationContext(), throwable, null, null);
        }

        _cls2()
        {
            context = context1;
            super();
        }
    }

}
