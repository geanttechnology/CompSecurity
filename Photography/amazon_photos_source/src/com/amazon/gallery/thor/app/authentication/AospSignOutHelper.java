// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import com.amazon.gallery.thor.app.activity.SignInActivity;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MultipleAccountManager;
import java.lang.ref.WeakReference;

public class AospSignOutHelper
{
    private class SignOutCallback
        implements Callback
    {

        final AospSignOutHelper this$0;

        public void onError(Bundle bundle)
        {
            goToSignInActivity();
        }

        public void onSuccess(Bundle bundle)
        {
            goToSignInActivity();
        }

        private SignOutCallback()
        {
            this$0 = AospSignOutHelper.this;
            super();
        }

    }


    private WeakReference activityRef;
    private AppCompatProgressDialog progressDialog;

    public AospSignOutHelper(WeakReference weakreference)
    {
        activityRef = weakreference;
    }

    private void goToSignInActivity()
    {
        final Activity activity = (Activity)activityRef.get();
        if (activity == null)
        {
            return;
        } else
        {
            activity.runOnUiThread(new Runnable() {

                final AospSignOutHelper this$0;
                final Activity val$activity;

                public void run()
                {
                    progressDialog.dismiss();
                    Intent intent = new Intent(activity, com/amazon/gallery/thor/app/activity/SignInActivity);
                    activity.startActivity(intent);
                    activity.finish();
                }

            
            {
                this$0 = AospSignOutHelper.this;
                activity = activity1;
                super();
            }
            });
            return;
        }
    }

    private void signOut()
    {
        final Activity activity = (Activity)activityRef.get();
        if (activity == null)
        {
            return;
        } else
        {
            (new Thread() {

                final AospSignOutHelper this$0;
                final Activity val$activity;

                public void run()
                {
                    MAPAccountManager mapaccountmanager = new MAPAccountManager(activity);
                    MultipleAccountManager multipleaccountmanager = new MultipleAccountManager(activity);
                    String s = mapaccountmanager.getAccount();
                    if (multipleaccountmanager.doesAccountHaveMapping(s, com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType.createCurrentPackageMapping(activity.getApplicationContext())))
                    {
                        multipleaccountmanager.removeAccountMappings(s, new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
                            com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType.createCurrentPackageMapping(activity.getApplicationContext())
                        });
                    }
                    mapaccountmanager.deregisterAccount(s, new SignOutCallback());
                }

            
            {
                this$0 = AospSignOutHelper.this;
                activity = activity1;
                super();
            }
            }).start();
            progressDialog = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(activity)).setIndeterminate(true).setMessage(activity.getString(0x7f0e01fb)).show();
            return;
        }
    }

    public void confirmSignOut()
    {
        Activity activity = (Activity)activityRef.get();
        if (activity == null)
        {
            return;
        } else
        {
            String s = (new StringBuilder()).append(activity.getString(0x7f0e01fa)).append("\n\n").append(activity.getString(0x7f0e01f9)).toString();
            (new android.support.v7.app.AlertDialog.Builder(activity)).setMessage(s).setPositiveButton(activity.getString(0x7f0e01f7), new android.content.DialogInterface.OnClickListener() {

                final AospSignOutHelper this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    signOut();
                }

            
            {
                this$0 = AospSignOutHelper.this;
                super();
            }
            }).setNegativeButton(activity.getString(0x7f0e01f8), new android.content.DialogInterface.OnClickListener() {

                final AospSignOutHelper this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$0 = AospSignOutHelper.this;
                super();
            }
            }).setCancelable(true).create().show();
            return;
        }
    }



}
