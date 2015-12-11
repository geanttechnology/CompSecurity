// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.twitter;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.webkit.CookieSyncManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.parse.internal.AsyncCallback;
import com.parse.oauth.OAuth1FlowDialog;
import com.parse.oauth.OAuth1FlowException;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.OAuthProvider;
import com.parse.signpost.commonshttp.CommonsHttpOAuthConsumer;
import com.parse.signpost.commonshttp.CommonsHttpOAuthProvider;
import com.parse.signpost.http.HttpParameters;
import org.apache.http.client.methods.HttpUriRequest;

public class Twitter
{

    private static final String ACCESS_TOKEN_URL = "https://api.twitter.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://api.twitter.com/oauth/authenticate";
    private static final String CALLBACK_URL = "twitter-oauth://complete";
    private static final String REQUEST_TOKEN_URL = "https://api.twitter.com/oauth/request_token";
    private static final String SCREEN_NAME_PARAM = "screen_name";
    private static final String USER_AGENT = "Parse Android SDK";
    private static final String USER_ID_PARAM = "user_id";
    private static final String VERIFIER_PARAM = "oauth_verifier";
    private String authToken;
    private String authTokenSecret;
    private String consumerKey;
    private String consumerSecret;
    private String screenName;
    private String userId;

    public Twitter(String s, String s1)
    {
        consumerKey = s;
        consumerSecret = s1;
    }

    public void authorize(final Context context, final AsyncCallback callback)
    {
        if (getConsumerKey() == null || getConsumerKey().length() == 0 || getConsumerSecret() == null || getConsumerSecret().length() == 0)
        {
            throw new IllegalStateException("Twitter must be initialized with a consumer key and secret before authorization.");
        }
        final CommonsHttpOAuthProvider provider = new CommonsHttpOAuthProvider("https://api.twitter.com/oauth/request_token", "https://api.twitter.com/oauth/access_token", "https://api.twitter.com/oauth/authenticate", AndroidHttpClient.newInstance("Parse Android SDK", context));
        final CommonsHttpOAuthConsumer consumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Loading...");
        context = new TraceFieldInterface() {

            public Trace _nr_trace;
            private Throwable error;
            final Twitter this$0;
            final AsyncCallback val$callback;
            final OAuthConsumer val$consumer;
            final Context val$context;
            final ProgressDialog val$progress;
            final OAuthProvider val$provider;

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
                TraceMachine.enterMethod(_nr_trace, "Twitter$1#doInBackground", null);
_L1:
                aobj = doInBackground((Void[])aobj);
                TraceMachine.exitMethod();
                TraceMachine.unloadTraceContext(this);
                return ((Object) (aobj));
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "Twitter$1#doInBackground", null);
                  goto _L1
            }

            protected transient String doInBackground(Void avoid[])
            {
                try
                {
                    avoid = provider.retrieveRequestToken(consumer, "twitter-oauth://complete");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    error = avoid;
                    return null;
                }
                return avoid;
            }

            protected volatile void onPostExecute(Object obj)
            {
                TraceMachine.enterMethod(_nr_trace, "Twitter$1#onPostExecute", null);
_L1:
                onPostExecute((String)obj);
                TraceMachine.exitMethod();
                return;
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "Twitter$1#onPostExecute", null);
                  goto _L1
            }

            protected void onPostExecute(String s)
            {
                super.onPostExecute(s);
                if (error == null)
                {
                    break MISSING_BLOCK_LABEL_33;
                }
                callback.onFailure(error);
                progress.dismiss();
                return;
                CookieSyncManager.createInstance(context);
                (new OAuth1FlowDialog(context, s, "twitter-oauth://complete", "api.twitter", new com.parse.oauth.OAuth1FlowDialog.FlowResultHandler() {

                    final _cls1 this$1;

                    public void onCancel()
                    {
                        callback.onCancel();
                    }

                    public void onComplete(String s)
                    {
                        CookieSyncManager.getInstance().sync();
                        s = Uri.parse(s).getQueryParameter("oauth_verifier");
                        if (s == null)
                        {
                            callback.onCancel();
                            return;
                        }
                        s = s. new TraceFieldInterface() {

                            public Trace _nr_trace;
                            private Throwable error;
                            final _cls1 this$2;
                            final String val$verifier;

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

                            protected transient HttpParameters doInBackground(Void avoid[])
                            {
                                try
                                {
                                    provider.retrieveAccessToken(consumer, verifier);
                                }
                                // Misplaced declaration of an exception variable
                                catch (Void avoid[])
                                {
                                    error = avoid;
                                }
                                return provider.getResponseParameters();
                            }

                            protected volatile Object doInBackground(Object aobj[])
                            {
                                TraceMachine.enterMethod(_nr_trace, "Twitter$1$1$1#doInBackground", null);
_L1:
                                aobj = doInBackground((Void[])aobj);
                                TraceMachine.exitMethod();
                                TraceMachine.unloadTraceContext(this);
                                return ((Object) (aobj));
                                NoSuchFieldError nosuchfielderror;
                                nosuchfielderror;
                                TraceMachine.enterMethod(null, "Twitter$1$1$1#doInBackground", null);
                                  goto _L1
                            }

                            protected void onPostExecute(HttpParameters httpparameters)
                            {
                                super.onPostExecute(httpparameters);
                                if (error == null)
                                {
                                    break MISSING_BLOCK_LABEL_45;
                                }
                                callback.onFailure(error);
                                progress.dismiss();
                                return;
                                setAuthToken(consumer.getToken());
                                setAuthTokenSecret(consumer.getTokenSecret());
                                setScreenName(httpparameters.getFirst("screen_name"));
                                setUserId(httpparameters.getFirst("user_id"));
                                callback.onSuccess(_fld0);
                                progress.dismiss();
                                return;
                                httpparameters;
                                callback.onFailure(httpparameters);
                                progress.dismiss();
                                return;
                                httpparameters;
                                progress.dismiss();
                                throw httpparameters;
                            }

                            protected volatile void onPostExecute(Object obj)
                            {
                                TraceMachine.enterMethod(_nr_trace, "Twitter$1$1$1#onPostExecute", null);
_L1:
                                onPostExecute((HttpParameters)obj);
                                TraceMachine.exitMethod();
                                return;
                                NoSuchFieldError nosuchfielderror;
                                nosuchfielderror;
                                TraceMachine.enterMethod(null, "Twitter$1$1$1#onPostExecute", null);
                                  goto _L1
                            }

                            protected void onPreExecute()
                            {
                                super.onPreExecute();
                                progress.show();
                            }

            
            {
                this$2 = final__pcls1;
                verifier = String.this;
                super();
            }
                        };
                        Void avoid[] = new Void[0];
                        if (!(s instanceof AsyncTask))
                        {
                            s.execute(avoid);
                            return;
                        } else
                        {
                            AsyncTaskInstrumentation.execute((AsyncTask)s, avoid);
                            return;
                        }
                    }

                    public void onError(int i, String s, String s1)
                    {
                        callback.onFailure(new OAuth1FlowException(i, s, s1));
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                })).show();
                progress.dismiss();
                return;
                s;
                progress.dismiss();
                throw s;
            }

            protected void onPreExecute()
            {
                super.onPreExecute();
                progress.show();
            }

            
            {
                this$0 = Twitter.this;
                callback = asynccallback;
                context = context1;
                provider = oauthprovider;
                consumer = oauthconsumer;
                progress = progressdialog;
                super();
            }
        };
        callback = new Void[0];
        if (!(context instanceof AsyncTask))
        {
            context.execute(callback);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)context, callback);
            return;
        }
    }

    public String getAuthToken()
    {
        return authToken;
    }

    public String getAuthTokenSecret()
    {
        return authTokenSecret;
    }

    public String getConsumerKey()
    {
        return consumerKey;
    }

    public String getConsumerSecret()
    {
        return consumerSecret;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setAuthToken(String s)
    {
        authToken = s;
    }

    public void setAuthTokenSecret(String s)
    {
        authTokenSecret = s;
    }

    public Twitter setConsumerKey(String s)
    {
        consumerKey = s;
        return this;
    }

    public Twitter setConsumerSecret(String s)
    {
        consumerSecret = s;
        return this;
    }

    public void setScreenName(String s)
    {
        screenName = s;
    }

    public void setUserId(String s)
    {
        userId = s;
    }

    public void signRequest(HttpUriRequest httpurirequest)
    {
        CommonsHttpOAuthConsumer commonshttpoauthconsumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
        commonshttpoauthconsumer.setTokenWithSecret(getAuthToken(), getAuthTokenSecret());
        try
        {
            commonshttpoauthconsumer.sign(httpurirequest);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            throw new RuntimeException(httpurirequest);
        }
    }
}
