// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import android.app.Activity;
import android.content.DialogInterface;
import com.comcast.cim.android.concurrent.RetryableAsyncTask;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.model.user.AuthKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.authentication:
//            UserCredentials, AuthenticationClient, AuthenticationActivity

public class AuthenticationAsyncTask extends RetryableAsyncTask
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/authentication/AuthenticationAsyncTask);
    private final AuthenticationActivity authenticationActivity;
    private AuthenticationClient authenticationClient;
    private Exception savedException;
    private UserCredentials userCredentials;

    public AuthenticationAsyncTask(AuthenticationActivity authenticationactivity, AuthenticationClient authenticationclient, InternetConnection internetconnection, ErrorDialogFactory errordialogfactory)
    {
        super(authenticationactivity, true, internetconnection, getOnCancelListener(authenticationactivity), errordialogfactory);
        savedException = null;
        authenticationClient = authenticationclient;
        authenticationActivity = authenticationactivity;
    }

    private static android.content.DialogInterface.OnCancelListener getOnCancelListener(AuthenticationActivity authenticationactivity)
    {
        return new android.content.DialogInterface.OnCancelListener(authenticationactivity) {

            final AuthenticationActivity val$activity;

            public void onCancel(DialogInterface dialoginterface)
            {
                activity.hideSigningInSpinner();
            }

            
            {
                activity = authenticationactivity;
                super();
            }
        };
    }

    protected AuthKeys doInBackgroundWrapped(String as[])
    {
        try
        {
            userCredentials = new UserCredentials(as[0], as[1]);
            as = authenticationClient.authenticate(userCredentials);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            LOG.error("Caught exception during authentication", as);
            savedException = as;
            return null;
        }
        return as;
    }

    protected volatile Object doInBackgroundWrapped(Object aobj[])
    {
        return doInBackgroundWrapped((String[])aobj);
    }

    protected RetryableAsyncTask getNewInstance(Activity activity)
    {
        return new AuthenticationAsyncTask(authenticationActivity, authenticationClient, getInternetConnection(), errorDialogFactory);
    }

    protected void onPostExecuteWrapped(AuthKeys authkeys)
    {
        if (authkeys == null || userCredentials == null || savedException != null)
        {
            authenticationActivity.onSigninFailed(savedException);
            return;
        } else
        {
            authenticationActivity.onSigninSuccess(userCredentials, authkeys);
            return;
        }
    }

    protected volatile void onPostExecuteWrapped(Object obj)
    {
        onPostExecuteWrapped((AuthKeys)obj);
    }

    protected boolean retryOnException(Exception exception)
    {
        return true;
    }

}
