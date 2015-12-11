// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.AppInfo;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.EnvConfig;
import java.io.IOException;
import java.util.Date;

// Referenced classes of package com.poshmark.utils:
//            GCMUtils

public class cntx extends AsyncTask
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

    public g(Context context)
    {
        this$0 = GCMUtils.this;
        super();
        retryCount = 3;
        cntx = context;
    }
}
