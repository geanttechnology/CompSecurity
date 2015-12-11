// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.OAuthLoginFragment;
import com.poshmark.utils.InvalidShareCallerException;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterHelper
    implements PMNotificationListener
{
    class TwitterAsyncGetTokenSecretTask extends AsyncTask
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
                avoid = mTwitter.getOAuthAccessToken(mReqToken, verifier);
                mTwitter.setOAuthAccessToken(avoid);
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

        public TwitterAsyncGetTokenSecretTask(String s)
        {
            this$0 = TwitterHelper.this;
            super();
            verifier = s;
        }
    }

    class TwitterAsyncGetVerifierTask extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        private PMActivity activity;
        final TwitterHelper this$0;

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
            TraceMachine.enterMethod(_nr_trace, "TwitterHelper$TwitterAsyncGetVerifierTask#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "TwitterHelper$TwitterAsyncGetVerifierTask#doInBackground", null);
              goto _L1
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                mTwitter = (new TwitterFactory()).getInstance();
                mTwitter.setOAuthConsumer(TwitterConsumerKey, TwitterConsumerSecret);
                mReqToken = mTwitter.getOAuthRequestToken("http://localhost");
                avoid = new Bundle();
                avoid.putString("URL", mReqToken.getAuthenticationURL());
                avoid.putString("ANALYTICS_PAGE_NAME", "twitter_login_screen");
                activity.launchFragment(avoid, com/poshmark/ui/fragments/OAuthLoginFragment, null);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                return null;
            }
            return null;
        }

        public TwitterAsyncGetVerifierTask(PMActivity pmactivity)
        {
            this$0 = TwitterHelper.this;
            super();
            activity = pmactivity;
        }
    }


    private static final String CALLBACK_URL = "http://localhost";
    public static final String SERVICE_ID = "tw";
    String TwitterConsumerKey;
    String TwitterConsumerSecret;
    String TwitterOAuthURL;
    private RequestToken mReqToken;
    private Twitter mTwitter;

    public TwitterHelper()
    {
        mTwitter = null;
        TwitterOAuthURL = "https://api.twitter.com/oauth/";
        TwitterConsumerKey = "kTbA6j5Zi0yX8LS6wT3yHg";
        TwitterConsumerSecret = "koq93pMZSIBsG5U3zOsinGzPU0moy8nt8sbMaGvL68";
    }

    public void handleNotification(Intent intent)
    {
        Void avoid[];
label0:
        {
            if (intent.getAction().equals("com.poshmark.intents.OAUTH_REPONSE_OK"))
            {
                intent = new TwitterAsyncGetTokenSecretTask(intent.getBundleExtra("RESULT").getString("oauth_verifier"));
                avoid = new Void[0];
                if (intent instanceof AsyncTask)
                {
                    break label0;
                }
                intent.execute(avoid);
            }
            return;
        }
        AsyncTaskInstrumentation.execute((AsyncTask)intent, avoid);
    }

    public void login(Object obj)
        throws InvalidShareCallerException
    {
        if (obj instanceof Activity)
        {
            obj = new TwitterAsyncGetVerifierTask((PMActivity)obj);
            Void avoid[] = new Void[0];
            if (!(obj instanceof AsyncTask))
            {
                ((TwitterAsyncGetVerifierTask) (obj)).execute(avoid);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
                return;
            }
        }
        if (obj instanceof Fragment)
        {
            obj = new TwitterAsyncGetVerifierTask((PMActivity)((Fragment)obj).getActivity());
            Void avoid1[] = new Void[0];
            if (!(obj instanceof AsyncTask))
            {
                ((TwitterAsyncGetVerifierTask) (obj)).execute(avoid1);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid1);
                return;
            }
        } else
        {
            throw new InvalidShareCallerException();
        }
    }

    public void logout()
    {
        if (mTwitter != null)
        {
            mTwitter.shutdown();
        }
    }



/*
    static Twitter access$002(TwitterHelper twitterhelper, Twitter twitter)
    {
        twitterhelper.mTwitter = twitter;
        return twitter;
    }

*/



/*
    static RequestToken access$102(TwitterHelper twitterhelper, RequestToken requesttoken)
    {
        twitterhelper.mReqToken = requesttoken;
        return requesttoken;
    }

*/
}
