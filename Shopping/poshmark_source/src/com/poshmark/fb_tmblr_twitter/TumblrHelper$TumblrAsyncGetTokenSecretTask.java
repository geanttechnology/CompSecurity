// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.AsyncTask;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.http.HttpParameters;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            TumblrHelper, ExtServiceConnectInterface

class service_type extends AsyncTask
    implements PMApiResponseHandler, TraceFieldInterface
{

    public Trace _nr_trace;
    onPostExecute service_type;
    final TumblrHelper this$0;
    private String verifier;

    private void PMlink(Bundle bundle)
    {
        if (service_type == service_type)
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
            if (service_type == service_type)
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
        if (service == PMlink)
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

    public (String s,  )
    {
        this$0 = TumblrHelper.this;
        super();
        verifier = s;
        service_type = ;
    }
}
