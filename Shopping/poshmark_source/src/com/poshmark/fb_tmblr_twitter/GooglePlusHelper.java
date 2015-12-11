// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import java.io.IOException;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            ExtServiceUserInfoInterface

public class GooglePlusHelper
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{
    class FetchGoogleTokenTask extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        GooglePlusHelper helper;
        final GooglePlusHelper this$0;

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
            avoid = new Bundle();
            Object obj;
            String s;
            try
            {
                obj = new Bundle();
                obj = GoogleAuthUtil.getToken(activity.getApplicationContext(), Plus.AccountApi.getAccountName(mGoogleApiClient), "oauth2:https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.login", ((Bundle) (obj)));
                s = Plus.AccountApi.getAccountName(mGoogleApiClient);
                avoid.putString("TOKEN", ((String) (obj)));
                avoid.putString("EMAIL", s);
                avoid.putBoolean("GOOGLE_SIGNUP", true);
                if (mGoogleApiClient == null || !mGoogleApiClient.isConnected())
                {
                    break MISSING_BLOCK_LABEL_155;
                }
                s = GooglePlusHelper.getInstance().getGooglePlusProfileImageUrl();
            }
            catch (UserRecoverableAuthException userrecoverableauthexception)
            {
                avoid.putBoolean("TOKEN_ERROR", true);
                return avoid;
            }
            catch (IOException ioexception)
            {
                avoid.putBoolean("TOKEN_ERROR", true);
                return avoid;
            }
            catch (GoogleAuthException googleauthexception)
            {
                avoid.putBoolean("TOKEN_ERROR", true);
                return avoid;
            }
            catch (Exception exception)
            {
                avoid.putBoolean("TOKEN_ERROR", true);
                return avoid;
            }
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_128;
            }
            avoid.putString("GOOGLE_AVATAAR_URL", s);
            Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
            mGoogleApiClient.disconnect();
            GoogleAuthUtil.invalidateToken(activity.getApplicationContext(), ((String) (obj)));
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "GooglePlusHelper$FetchGoogleTokenTask#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "GooglePlusHelper$FetchGoogleTokenTask#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Bundle bundle)
        {
            if (bundle != null && !bundle.getBoolean("TOKEN_ERROR", false))
            {
                callback.success(bundle);
                return;
            }
            if (fragment != null)
            {
                fragment.hideProgressDialog();
            }
            bundle = new PMApiError(null, null, 200, PMErrorType.GOOGLE_PLUS_LOGIN_ERROR);
            callback.error(bundle);
        }

        protected volatile void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "GooglePlusHelper$FetchGoogleTokenTask#onPostExecute", null);
_L1:
            onPostExecute((Bundle)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "GooglePlusHelper$FetchGoogleTokenTask#onPostExecute", null);
              goto _L1
        }

        public FetchGoogleTokenTask()
        {
            this$0 = GooglePlusHelper.this;
            super();
        }
    }

    private static class SingletonHolder
    {

        public static final GooglePlusHelper INSTANCE = new GooglePlusHelper();


        private SingletonHolder()
        {
        }
    }


    public static int GP_REQUEST = 998;
    PMActivity activity;
    ExtServiceUserInfoInterface callback;
    PMFragment fragment;
    private GoogleApiClient mGoogleApiClient;
    private boolean mLogoutInProgress;

    private GooglePlusHelper()
    {
        mLogoutInProgress = false;
    }


    public static GooglePlusHelper getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private void loadUserAccountInfo()
    {
        FetchGoogleTokenTask fetchgoogletokentask = new FetchGoogleTokenTask();
        Void avoid[] = new Void[0];
        if (!(fetchgoogletokentask instanceof AsyncTask))
        {
            fetchgoogletokentask.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)fetchgoogletokentask, avoid);
            return;
        }
    }

    public static void showGoogleLinkError(PMApiError pmapierror, PMFragment pmfragment)
    {
        showGoogleLinkError(pmapierror, pmfragment, com.poshmark.ui.model.ActionErrorContext.Severity.LOW);
    }

    public static void showGoogleLinkError(PMApiError pmapierror, PMFragment pmfragment, com.poshmark.ui.model.ActionErrorContext.Severity severity)
    {
        if (pmapierror.pmErrorType == PMErrorType.EXTERNAL_ID_TAKEN_ERROR)
        {
            pmfragment.showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_GOOGLE, null, severity, null, pmfragment.getString(0x7f0600de)));
            return;
        } else
        {
            pmfragment.showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_GOOGLE, pmfragment.getString(0x7f0600df), severity));
            return;
        }
    }

    public String getGooglePlusProfileImageUrl()
    {
        Object obj = null;
        String s = obj;
        if (mGoogleApiClient != null)
        {
            s = obj;
            if (mGoogleApiClient.isConnected())
            {
                Person person = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
                s = obj;
                if (person != null)
                {
                    s = person.getImage().getUrl();
                }
            }
        }
        return s;
    }

    public void handleResultFromActivity(int i, int j, Intent intent)
    {
        if (i == GP_REQUEST && j == -1)
        {
            if (!mGoogleApiClient.isConnecting())
            {
                mGoogleApiClient.connect();
            }
        } else
        if (fragment != null)
        {
            fragment.hideProgressDialog();
            return;
        }
    }

    public void link(PMFragment pmfragment, ExtServiceUserInfoInterface extserviceuserinfointerface)
    {
        activity = (PMActivity)pmfragment.getActivity();
        fragment = pmfragment;
        callback = extserviceuserinfointerface;
        mGoogleApiClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(activity)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API, null).addScope(Plus.SCOPE_PLUS_LOGIN).addScope(new Scope("https://www.googleapis.com/auth/userinfo.email")).build();
        pmfragment.showProgressDialogWithMessage("");
        mGoogleApiClient.connect();
    }

    public void logout()
    {
    }

    public void onConnected(Bundle bundle)
    {
        if (!mLogoutInProgress)
        {
            loadUserAccountInfo();
            return;
        }
        if (fragment != null)
        {
            fragment.hideProgressDialog();
        }
        logout();
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        if (!connectionresult.hasResolution())
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (mLogoutInProgress) goto _L2; else goto _L1
_L1:
        connectionresult.startResolutionForResult(activity, GP_REQUEST);
_L3:
        return;
        connectionresult;
        mGoogleApiClient.connect();
        return;
_L2:
        mLogoutInProgress = false;
        return;
        if (fragment != null)
        {
            fragment.hideProgressDialog();
            return;
        }
          goto _L3
    }

    public void onConnectionSuspended(int i)
    {
        if (fragment != null)
        {
            fragment.hideProgressDialog();
        }
    }


}
