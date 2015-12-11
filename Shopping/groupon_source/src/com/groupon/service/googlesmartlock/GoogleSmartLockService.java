// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.googlesmartlock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Annotation;

public class GoogleSmartLockService
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{
    public static interface Action
        extends Annotation
    {
    }

    public static interface OnCredentialsRetrievedCallback
    {

        public abstract void onCredentialResolutionRequired();

        public abstract void onCredentialsRetrieveFailed();

        public abstract void onCredentialsRetrieved(Credential credential1);
    }

    public static interface OnCredentialsSavedCallback
    {

        public abstract void onCredentialSaveCompleted(boolean flag);
    }

    private class RequestSmartLockCredentialsResultCallback
        implements ResultCallback
    {

        final GoogleSmartLockService this$0;

        public void onResult(CredentialRequestResult credentialrequestresult)
        {
            if (onCredentialsRetrievedCallback != null)
            {
                if (credentialrequestresult.getStatus().isSuccess() && credentialrequestresult.getCredential() != null)
                {
                    onCredentialsRetrievedCallback.onCredentialsRetrieved(credentialrequestresult.getCredential());
                    return;
                }
                if (credentialrequestresult.getStatus().getStatusCode() == 6)
                {
                    if (!isWaitingForGoogleSmartLockResolution && activityForCallback != null)
                    {
                        try
                        {
                            credentialrequestresult.getStatus().startResolutionForResult(activityForCallback, 10153);
                            onCredentialsRetrievedCallback.onCredentialResolutionRequired();
                            isWaitingForGoogleSmartLockResolution = true;
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (CredentialRequestResult credentialrequestresult)
                        {
                            onCredentialsRetrievedCallback.onCredentialsRetrieveFailed();
                        }
                        return;
                    }
                } else
                {
                    onCredentialsRetrievedCallback.onCredentialsRetrieveFailed();
                    return;
                }
            }
        }

        public volatile void onResult(Result result)
        {
            onResult((CredentialRequestResult)result);
        }

        private RequestSmartLockCredentialsResultCallback()
        {
            this$0 = GoogleSmartLockService.this;
            super();
        }

    }

    private class SaveSmartLockCredentialsResultCallback
        implements ResultCallback
    {

        final GoogleSmartLockService this$0;

        public volatile void onResult(Result result)
        {
            onResult((Status)result);
        }

        public void onResult(Status status)
        {
            if (onCredentialsSavedCallback != null)
            {
                if (status.isSuccess())
                {
                    onCredentialsSavedCallback.onCredentialSaveCompleted(true);
                    return;
                }
                if (status.hasResolution())
                {
                    if (!isWaitingForGoogleSmartLockResolution && activityForCallback != null)
                    {
                        try
                        {
                            status.startResolutionForResult(activityForCallback, 10154);
                            isWaitingForGoogleSmartLockResolution = true;
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Status status)
                        {
                            onCredentialsSavedCallback.onCredentialSaveCompleted(false);
                        }
                        return;
                    }
                } else
                {
                    onCredentialsSavedCallback.onCredentialSaveCompleted(false);
                    return;
                }
            }
        }

        private SaveSmartLockCredentialsResultCallback()
        {
            this$0 = GoogleSmartLockService.this;
            super();
        }

    }


    public static final int ACTION_RETRIEVE = 2;
    public static final int ACTION_SAVE = 1;
    public static final int NO_ACTION = 0;
    public static final int RETRIEVE_SMART_LOCK_CREDENTIALS = 10153;
    public static final int SAVE_SMART_LOCK_CREDENTIALS = 10154;
    private int action;
    private Activity activityForCallback;
    Context context;
    private Credential credential;
    private CredentialRequest credentialRequest;
    private boolean isWaitingForGoogleSmartLockResolution;
    private GoogleApiClient mCredentialsClient;
    private OnCredentialsRetrievedCallback onCredentialsRetrievedCallback;
    private OnCredentialsSavedCallback onCredentialsSavedCallback;

    public GoogleSmartLockService()
    {
    }

    public void getCredentialsFromIntent(Intent intent, int i)
    {
label0:
        {
            isWaitingForGoogleSmartLockResolution = false;
            if (onCredentialsRetrievedCallback != null)
            {
                if (i != -1)
                {
                    break label0;
                }
                onCredentialsRetrievedCallback.onCredentialsRetrieved((Credential)intent.getParcelableExtra("com.google.android.gms.credentials.Credential"));
            }
            return;
        }
        onCredentialsRetrievedCallback.onCredentialsRetrieveFailed();
    }

    public void handleSaveCredentialActivityResult(int i)
    {
        boolean flag = false;
        isWaitingForGoogleSmartLockResolution = false;
        if (onCredentialsSavedCallback != null)
        {
            OnCredentialsSavedCallback oncredentialssavedcallback = onCredentialsSavedCallback;
            if (i == -1)
            {
                flag = true;
            }
            oncredentialssavedcallback.onCredentialSaveCompleted(flag);
        }
    }

    public void init()
    {
        mCredentialsClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(Auth.CREDENTIALS_API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        isWaitingForGoogleSmartLockResolution = false;
    }

    public boolean isWaitingForGoogleSmartLockResolution()
    {
        return isWaitingForGoogleSmartLockResolution;
    }

    public void onConnected(Bundle bundle)
    {
        if (action != 1) goto _L2; else goto _L1
_L1:
        Auth.CredentialsApi.save(mCredentialsClient, credential).setResultCallback(new SaveSmartLockCredentialsResultCallback());
_L4:
        action = 0;
        return;
_L2:
        if (action == 2)
        {
            Auth.CredentialsApi.request(mCredentialsClient, credentialRequest).setResultCallback(new RequestSmartLockCredentialsResultCallback());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        if (action != 1 || onCredentialsSavedCallback == null) goto _L2; else goto _L1
_L1:
        onCredentialsSavedCallback.onCredentialSaveCompleted(false);
_L4:
        action = 0;
        return;
_L2:
        if (action == 2 && onCredentialsRetrievedCallback != null)
        {
            onCredentialsRetrievedCallback.onCredentialsRetrieveFailed();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onConnectionSuspended(int i)
    {
        if (action != 1 || onCredentialsSavedCallback == null) goto _L2; else goto _L1
_L1:
        onCredentialsSavedCallback.onCredentialSaveCompleted(false);
_L4:
        action = 0;
        return;
_L2:
        if (action == 2 && onCredentialsRetrievedCallback != null)
        {
            onCredentialsRetrievedCallback.onCredentialsRetrieveFailed();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void resetCallbacks()
    {
        onCredentialsRetrievedCallback = null;
        onCredentialsSavedCallback = null;
        activityForCallback = null;
    }

    public void retrieveSmartLockCredentials()
    {
        if (onCredentialsRetrievedCallback != null)
        {
            action = 2;
            credentialRequest = (new com.google.android.gms.auth.api.credentials.CredentialRequest.Builder()).setSupportsPasswordLogin(true).build();
            if (!mCredentialsClient.isConnected())
            {
                if (!mCredentialsClient.isConnecting())
                {
                    mCredentialsClient.connect();
                    return;
                }
            } else
            {
                Auth.CredentialsApi.request(mCredentialsClient, credentialRequest).setResultCallback(new RequestSmartLockCredentialsResultCallback());
                return;
            }
        }
    }

    public void saveCredentialsToSmartLock(String s, String s1, String s2)
    {
        if (onCredentialsSavedCallback != null)
        {
            action = 1;
            credential = (new com.google.android.gms.auth.api.credentials.Credential.Builder(s)).setPassword(s1).setName(s2).build();
            if (!mCredentialsClient.isConnected())
            {
                if (!mCredentialsClient.isConnecting())
                {
                    mCredentialsClient.connect();
                    return;
                }
            } else
            {
                action = 0;
                Auth.CredentialsApi.save(mCredentialsClient, credential).setResultCallback(new SaveSmartLockCredentialsResultCallback());
                return;
            }
        }
    }

    public void setActivityForCallback(Activity activity)
    {
        activityForCallback = activity;
    }

    public void setOnCredentialSavedCallback(OnCredentialsSavedCallback oncredentialssavedcallback)
    {
        onCredentialsSavedCallback = oncredentialssavedcallback;
    }

    public void setOnCredentialsRetrievedCallback(OnCredentialsRetrievedCallback oncredentialsretrievedcallback)
    {
        onCredentialsRetrievedCallback = oncredentialsretrievedcallback;
    }




/*
    static boolean access$302(GoogleSmartLockService googlesmartlockservice, boolean flag)
    {
        googlesmartlockservice.isWaitingForGoogleSmartLockResolution = flag;
        return flag;
    }

*/


}
