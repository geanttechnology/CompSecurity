// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.AppInfo;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.EnvConfig;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMGcmReciever;
import java.io.IOException;
import java.util.Date;

// Referenced classes of package com.poshmark.utils:
//            DateUtils

public class GCMUtils
{
    public class RegisterAsyncTask extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        Context cntx;
        String pushToken;
        int retryCount;
        final GCMUtils this$0;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "GCMUtils$RegisterAsyncTask#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "GCMUtils$RegisterAsyncTask#doInBackground", null);
              goto _L1
        }

        protected transient Void doInBackground(Void avoid[])
        {
_L2:
            if (retryCount <= 0)
            {
                break MISSING_BLOCK_LABEL_90;
            }
            pushToken = GoogleCloudMessaging.getInstance(cntx).register(new String[] {
                EnvConfig.GCM_PROJECT_ID
            });
            Log.d("PM New token", pushToken);
            PMApplicationSession.GetPMSession().setGCMRegId(pushToken);
            PMApplicationSession.GetPMSession().setGCMAppVersion(AppInfo.getInstance().versionName);
            PMApplicationSession.GetPMSession().setGCMLastRegisteredTime(new Date());
            PMApplicationSession.GetPMSession().setGCMRegIdSentFlag(false);
            sendGcmPushTokenToServer();
            return null;
            avoid;
            try
            {
                Thread.sleep(1000L);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
            retryCount = retryCount - 1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public RegisterAsyncTask(Context context)
        {
            this$0 = GCMUtils.this;
            super();
            retryCount = 3;
            cntx = context;
        }
    }


    public final long GCM_TOKEN_FETCH_ALARM_TIMER_DELAY = 0x240c8400L;
    public final int GCM_TOKEN_FETCH_PENDING_INTENT_ID = 101;
    public final int PLAY_SERVICES_RESOLUTION_REQUEST = 1;

    public GCMUtils()
    {
    }

    public boolean checkPlayServices(Context context)
    {
        boolean flag = true;
        boolean flag1 = context instanceof Activity;
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (i != 0)
        {
            if (GooglePlayServicesUtil.isUserRecoverableError(i) && (context instanceof Activity))
            {
                GooglePlayServicesUtil.getErrorDialog(i, (Activity)context, 1).show();
            }
            flag = false;
        }
        return flag;
    }

    public void forceRegisterWithGCM(Context context)
    {
        registerInBackground(context);
    }

    public void registerInBackground(Context context)
    {
        context = new RegisterAsyncTask(context);
        Void avoid[] = new Void[0];
        if (!(context instanceof AsyncTask))
        {
            context.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)context, avoid);
            return;
        }
    }

    public void registerWithGCM(Context context)
    {
        String s = PMApplicationSession.GetPMSession().getGCMRegId();
        String s1 = PMApplicationSession.GetPMSession().getGCMAppVersion();
        if (s == null)
        {
            registerInBackground(context);
            setTimerForFreshGcmTokenFetch();
        } else
        {
            if (!s1.equals(AppInfo.getInstance().versionName))
            {
                registerInBackground(context);
                return;
            }
            if (!DateUtils.isDateWithinPastWindow(PMApplicationSession.GetPMSession().getGCMLastRegisteredTime(), 7L, DateUtils.TIME_UNIT.DAYS))
            {
                registerInBackground(context);
                return;
            }
            if (!PMApplicationSession.GetPMSession().getGCMRegIdSentFlag())
            {
                sendGcmPushTokenToServer();
                return;
            }
        }
    }

    public void sendGcmPushTokenToServer()
    {
        PMApi.putGCMPushToken(PMApplicationSession.GetPMSession().getGCMRegId(), new PMApiResponseHandler() {

            final GCMUtils this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    PMApplicationSession.GetPMSession().setGCMRegIdSentFlag(true);
                    return;
                } else
                {
                    PMApplicationSession.GetPMSession().setGCMRegIdSentFlag(false);
                    return;
                }
            }

            
            {
                this$0 = GCMUtils.this;
                super();
            }
        });
    }

    public void setTimerForFreshGcmTokenFetch()
    {
        Object obj = new Intent(PMApplication.getContext(), com/poshmark/notifications/PMGcmReciever);
        ((Intent) (obj)).setAction("com.poshmark.intents.FETCH_GCM_TOKEN");
        obj = PendingIntent.getBroadcast(PMApplication.getContext(), 101, ((Intent) (obj)), 0x10000000);
        ((AlarmManager)PMApplication.getContext().getSystemService("alarm")).set(0, (new Date()).getTime() + 0x240c8400L, ((PendingIntent) (obj)));
    }
}
