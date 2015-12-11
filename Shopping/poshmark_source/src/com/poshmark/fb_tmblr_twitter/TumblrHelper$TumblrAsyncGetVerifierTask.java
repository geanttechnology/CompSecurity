// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.AsyncTask;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.OAuthLoginFragment;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            TumblrHelper, ExtServiceConnectInterface

class activity extends AsyncTask
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
        if (service == ER)
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

    public (PMActivity pmactivity)
    {
        this$0 = TumblrHelper.this;
        super();
        activity = pmactivity;
    }
}
