// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.actions.FacebookHelper;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.identity.snds.api.SNDSClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookHelperImpl
    implements FacebookHelper
{

    private static final String TAG = com/amazon/gallery/thor/facebook/FacebookHelperImpl.getName();
    private AuthenticationManager authenticationManager;

    public FacebookHelperImpl(AuthenticationManager authenticationmanager)
    {
        authenticationManager = authenticationmanager;
    }

    private boolean processFacebookPermissions(JSONObject jsonobject)
    {
        jsonobject = (new JSONObject(jsonobject.getJSONObject("data").getString("response"))).getJSONArray("data").getJSONObject(0);
        GLogger.d(TAG, "permissions = %s", new Object[] {
            jsonobject.toString()
        });
        if (jsonobject.has("user_photos") && jsonobject.getInt("user_photos") == 1)
        {
            return true;
        }
        try
        {
            GLogger.d(TAG, "Launching Facebook Permissions Intent", new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            GLogger.w(TAG, "Failed to parse facebook snds permissions json response ", new Object[] {
                jsonobject
            });
            return false;
        }
        return false;
    }

    public void hasPhotosPermissions(RestClient restclient, final Runnable onHasPhotoPermission, final Runnable onNoPhotosPermission)
        throws InvalidParameterException
    {
        NetworkExecutor.getInstance().executeForeground(restclient.getFacebookPermissionsOperation(), new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final FacebookHelperImpl this$0;
            final Runnable val$onHasPhotoPermission;
            final Runnable val$onNoPhotosPermission;

            public void onFailure(TerminalException terminalexception)
            {
                GLogger.w(FacebookHelperImpl.TAG, "Failed to parse facebook snds permissions json response ", new Object[] {
                    terminalexception
                });
                onNoPhotosPermission.run();
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
label0:
                {
                    if (jsonobject != null)
                    {
                        if (!processFacebookPermissions(jsonobject))
                        {
                            break label0;
                        }
                        onHasPhotoPermission.run();
                    }
                    return;
                }
                onNoPhotosPermission.run();
            }

            
            {
                this$0 = FacebookHelperImpl.this;
                onHasPhotoPermission = runnable;
                onNoPhotosPermission = runnable1;
                super();
            }
        });
    }

    public void isLinkedToFacebook(final Context context, final com.amazon.gallery.framework.gallery.actions.FacebookHelper.LinkDetectCallback callback)
    {
        final String accountId = authenticationManager.getAccountId();
        if (accountId != null)
        {
            (new AsyncTask() {

                final FacebookHelperImpl this$0;
                final String val$accountId;
                final com.amazon.gallery.framework.gallery.actions.FacebookHelper.LinkDetectCallback val$callback;
                final Context val$context;

                protected transient Boolean doInBackground(Void avoid[])
                {
                    return Boolean.valueOf((new SNDSClient(context)).isSocialNetworkAccountLinked(context, accountId, com.amazon.identity.snds.api.SNDSConstants.SocialNetworkType.FACEBOOK));
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(Boolean boolean1)
                {
                    callback.onResult(boolean1.booleanValue());
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Boolean)obj);
                }

            
            {
                this$0 = FacebookHelperImpl.this;
                context = context1;
                accountId = s;
                callback = linkdetectcallback;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            callback.onResult(false);
            return;
        }
    }

    public void launchFacebookPermissionsPage(Activity activity)
    {
        Intent intent = new Intent("com.amazon.identity.snds.action.SNDS.request_permissions");
        intent.putExtra("SNDS.type", com.amazon.identity.snds.api.SNDSConstants.SocialNetworkType.FACEBOOK.value());
        intent.putExtra("SNDS.account.directedID", authenticationManager.getAccountId());
        intent.putExtra("SNDS.permissions.csv", "user_photos");
        activity.startActivityForResult(intent, 34);
    }

    public void launchFacebookSettingsPage(Activity activity)
    {
        launchFacebookPermissionsPage(activity);
    }

    public void unlinkFacebookFlagFromDevice(Context context)
    {
        String s = authenticationManager.getAccountId();
        if (s != null)
        {
            (new SNDSClient(context)).setSocialNetworkAccountLinkStatus(context, s, com.amazon.identity.snds.api.SNDSConstants.SocialNetworkType.FACEBOOK, false);
        }
    }



}
