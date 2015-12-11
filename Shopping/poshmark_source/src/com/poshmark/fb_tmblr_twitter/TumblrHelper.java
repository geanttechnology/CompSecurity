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
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.OAuthLoginFragment;
import com.poshmark.utils.InvalidShareCallerException;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.http.HttpParameters;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            TwitterConsts, TumblrConsts, ExtServiceConnectInterface

public class TumblrHelper
    implements PMNotificationListener
{
    public static final class EXTERNAL_SERVICE_TYPE extends Enum
    {

        private static final EXTERNAL_SERVICE_TYPE $VALUES[];
        public static final EXTERNAL_SERVICE_TYPE TUMBLR;
        public static final EXTERNAL_SERVICE_TYPE TWITTER;

        public static EXTERNAL_SERVICE_TYPE valueOf(String s)
        {
            return (EXTERNAL_SERVICE_TYPE)Enum.valueOf(com/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE, s);
        }

        public static EXTERNAL_SERVICE_TYPE[] values()
        {
            return (EXTERNAL_SERVICE_TYPE[])$VALUES.clone();
        }

        static 
        {
            TWITTER = new EXTERNAL_SERVICE_TYPE("TWITTER", 0);
            TUMBLR = new EXTERNAL_SERVICE_TYPE("TUMBLR", 1);
            $VALUES = (new EXTERNAL_SERVICE_TYPE[] {
                TWITTER, TUMBLR
            });
        }

        private EXTERNAL_SERVICE_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    class TumblrAsyncGetTokenSecretTask extends AsyncTask
        implements PMApiResponseHandler, TraceFieldInterface
    {

        public Trace _nr_trace;
        EXTERNAL_SERVICE_TYPE service_type;
        final TumblrHelper this$0;
        private String verifier;

        private void PMlink(Bundle bundle)
        {
            if (service_type == EXTERNAL_SERVICE_TYPE.TUMBLR)
            {
                PMApi.tmblrLink(bundle.getString("TOKEN"), bundle.getString("SECRET"), this);
                return;
            } else
            {
                PMApi.twitterLink(bundle.getString("TOKEN"), bundle.getString("SECRET"), bundle.getString("USER_ID"), bundle.getString("USER_NAME"), this);
                return;
            }
        }

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

        protected transient Bundle doInBackground(Void avoid[])
        {
            Object obj;
            Bundle bundle;
            try
            {
                provider.retrieveAccessToken(consumer, verifier, new String[0]);
                obj = provider.getResponseParameters();
                avoid = ((HttpParameters) (obj)).getFirst("screen_name");
                obj = ((HttpParameters) (obj)).getFirst("user_id");
                bundle = new Bundle();
                bundle.putString("TOKEN", consumer.getToken());
                bundle.putString("SECRET", consumer.getTokenSecret());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            bundle.putString("USER_ID", ((String) (obj)));
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            bundle.putString("USER_NAME", avoid);
            return bundle;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "TumblrHelper$TumblrAsyncGetTokenSecretTask#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "TumblrHelper$TumblrAsyncGetTokenSecretTask#doInBackground", null);
              goto _L1
        }

        public void handleResponse(PMApiResponse pmapiresponse)
        {
            if (!pmapiresponse.hasError())
            {
                pmapiresponse = (ExternalServiceInfo)pmapiresponse.data;
                if (service_type == EXTERNAL_SERVICE_TYPE.TUMBLR)
                {
                    PMApplicationSession.GetPMSession().updateTumblrData(pmapiresponse);
                } else
                {
                    PMApplicationSession.GetPMSession().updateTwitterData(pmapiresponse);
                }
                callback.success(0, null);
                return;
            } else
            {
                callback.error(pmapiresponse.apiError);
                return;
            }
        }

        protected void onPostExecute(Bundle bundle)
        {
            if (bundle != null)
            {
                PMlink(bundle);
                return;
            }
            if (service == EXTERNAL_SERVICE_TYPE.TWITTER)
            {
                bundle = PMErrorType.TW_LOGIN_ERROR;
            } else
            {
                bundle = PMErrorType.TM_LOGIN_ERROR;
            }
            bundle = new PMApiError(null, null, 200, bundle);
            callback.error(bundle);
        }

        protected volatile void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "TumblrHelper$TumblrAsyncGetTokenSecretTask#onPostExecute", null);
_L1:
            onPostExecute((Bundle)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "TumblrHelper$TumblrAsyncGetTokenSecretTask#onPostExecute", null);
              goto _L1
        }

        public TumblrAsyncGetTokenSecretTask(String s, EXTERNAL_SERVICE_TYPE external_service_type)
        {
            this$0 = TumblrHelper.this;
            super();
            verifier = s;
            service_type = external_service_type;
        }
    }

    class TumblrAsyncGetVerifierTask extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        PMActivity activity;
        final TumblrHelper this$0;

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

        protected transient Bundle doInBackground(Void avoid[])
        {
            Bundle bundle;
            try
            {
                avoid = provider.retrieveRequestToken(consumer, "http://localhost", new String[0]);
                bundle = new Bundle();
                bundle.putString("URL", avoid);
                bundle.putString("ANALYTICS_PAGE_NAME", "tumblr_login_screen");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return bundle;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "TumblrHelper$TumblrAsyncGetVerifierTask#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "TumblrHelper$TumblrAsyncGetVerifierTask#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Bundle bundle)
        {
            if (bundle != null)
            {
                activity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/OAuthLoginFragment, null);
                return;
            }
            if (service == EXTERNAL_SERVICE_TYPE.TWITTER)
            {
                bundle = PMErrorType.TW_LOGIN_ERROR;
            } else
            {
                bundle = PMErrorType.TM_LOGIN_ERROR;
            }
            bundle = new PMApiError(null, null, 200, bundle);
            callback.error(bundle);
        }

        protected volatile void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "TumblrHelper$TumblrAsyncGetVerifierTask#onPostExecute", null);
_L1:
            onPostExecute((Bundle)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "TumblrHelper$TumblrAsyncGetVerifierTask#onPostExecute", null);
              goto _L1
        }

        public TumblrAsyncGetVerifierTask(PMActivity pmactivity)
        {
            this$0 = TumblrHelper.this;
            super();
            activity = pmactivity;
        }
    }


    private static final String CALLBACK_URL = "http://localhost";
    public static final String SERVICE_ID = "tm";
    String accessTokenUrl;
    String authorizeUrl;
    ExtServiceConnectInterface callback;
    CommonsHttpOAuthConsumer consumer;
    String consumerKey;
    String consumerSecret;
    CommonsHttpOAuthProvider provider;
    String requestUrl;
    EXTERNAL_SERVICE_TYPE service;

    public TumblrHelper()
    {
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.OAUTH_REPONSE_OK", this);
    }

    private void setServiceValues(EXTERNAL_SERVICE_TYPE external_service_type)
    {
        service = external_service_type;
        if (external_service_type == EXTERNAL_SERVICE_TYPE.TWITTER)
        {
            consumerKey = TwitterConsts.ConsumerKey.getValue();
            consumerSecret = TwitterConsts.ConsumerSecret.getValue();
            requestUrl = TwitterConsts.RequestUrl.getValue();
            accessTokenUrl = TwitterConsts.AccessTokenUrl.getValue();
            authorizeUrl = TwitterConsts.AuthorizeUrl.getValue();
            return;
        } else
        {
            consumerKey = TumblrConsts.ConsumerKey.getValue();
            consumerSecret = TumblrConsts.ConsumerSecret.getValue();
            requestUrl = TumblrConsts.RequestUrl.getValue();
            accessTokenUrl = TumblrConsts.AccessTokenUrl.getValue();
            authorizeUrl = TumblrConsts.AuthorizeUrl.getValue();
            return;
        }
    }

    public void handleNotification(Intent intent)
    {
        Void avoid[];
label0:
        {
            if (intent.getAction().equals("com.poshmark.intents.OAUTH_REPONSE_OK"))
            {
                intent = new TumblrAsyncGetTokenSecretTask(intent.getBundleExtra("RESULT").getString("oauth_verifier"), service);
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

    public void link(EXTERNAL_SERVICE_TYPE external_service_type, Object obj, ExtServiceConnectInterface extserviceconnectinterface)
        throws InvalidShareCallerException
    {
        this;
        JVM INSTR monitorenter ;
        callback = extserviceconnectinterface;
        setServiceValues(external_service_type);
        consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        provider = new CommonsHttpOAuthProvider(requestUrl, accessTokenUrl, authorizeUrl);
        if (!(obj instanceof Activity)) goto _L2; else goto _L1
_L1:
        external_service_type = new TumblrAsyncGetVerifierTask((PMActivity)obj);
        obj = new Void[0];
        if (external_service_type instanceof AsyncTask) goto _L4; else goto _L3
_L3:
        external_service_type.execute(((Object []) (obj)));
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        try
        {
            AsyncTaskInstrumentation.execute((AsyncTask)external_service_type, ((Object []) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (EXTERNAL_SERVICE_TYPE external_service_type) { }
        finally
        {
            this;
        }
          goto _L5
_L2:
        if (!(obj instanceof Fragment))
        {
            break MISSING_BLOCK_LABEL_171;
        }
        external_service_type = new TumblrAsyncGetVerifierTask((PMActivity)((Fragment)obj).getActivity());
        obj = new Void[0];
        if (external_service_type instanceof AsyncTask)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        external_service_type.execute(((Object []) (obj)));
        if (true) goto _L5; else goto _L6
_L6:
        JVM INSTR monitorexit ;
        throw external_service_type;
        AsyncTaskInstrumentation.execute((AsyncTask)external_service_type, ((Object []) (obj)));
          goto _L5
        throw new InvalidShareCallerException();
    }

    public void logout()
    {
    }
}
