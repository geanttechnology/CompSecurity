// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.AsyncTask;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.notifications.PMNotificationManager;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            TwitterHelper

class verifier extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final TwitterHelper this$0;
    private String verifier;

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
        TraceMachine.enterMethod(_nr_trace, "TwitterHelper$TwitterAsyncGetTokenSecretTask#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "TwitterHelper$TwitterAsyncGetTokenSecretTask#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = TwitterHelper.access$000(TwitterHelper.this).getOAuthAccessToken(TwitterHelper.access$100(TwitterHelper.this), verifier);
            TwitterHelper.access$000(TwitterHelper.this).setOAuthAccessToken(avoid);
            Bundle bundle = new Bundle();
            bundle.putString("TOKEN", avoid.getToken());
            bundle.putString("SECRET", avoid.getTokenSecret());
            bundle.putString("USER_ID", Long.toString(avoid.getUserId()));
            bundle.putString("USER_NAME", avoid.getScreenName());
            PMNotificationManager.fireNotification("com.poshmark.intents.TWITTER_LOGIN_OK", bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    public (String s)
    {
        this$0 = TwitterHelper.this;
        super();
        verifier = s;
    }
}
