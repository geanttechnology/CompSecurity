// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.google;

import android.content.Intent;
import android.support.v4.app.aa;
import android.support.v4.app.t;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.push.PushManager;

public class PlayServicesErrorActivity extends t
{

    private static final String DIALOG_TAG = "error_dialog";
    private static final int REQUEST_RESOLVE_ERROR = 1000;

    public PlayServicesErrorActivity()
    {
    }

    private void checkPlayServices()
    {
        Logger.info("Checking Google Play services.");
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (i == 0)
        {
            Logger.info("Google Play services available!");
            finish();
            return;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(i))
        {
            Logger.info((new StringBuilder("Google Play services recoverable error: ")).append(i).toString());
            ErrorDialogFragment.createInstance(i).show(getSupportFragmentManager(), "error_dialog");
            return;
        } else
        {
            Logger.error((new StringBuilder("Unrecoverable Google Play services error: ")).append(i).toString());
            finish();
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
label0:
        {
            super.onActivityResult(i, j, intent);
            if (i == 1000)
            {
                if (j != -1)
                {
                    break label0;
                }
                Logger.info("Google Play services resolution received result ok.");
                checkPlayServices();
            }
            return;
        }
        Logger.error("Google Play services resolution canceled.");
        finish();
    }

    protected void onStart()
    {
        super.onStart();
        Analytics.activityStarted(this);
        if (getSupportFragmentManager().a("error_dialog") == null)
        {
            checkPlayServices();
        }
    }

    protected void onStop()
    {
        super.onStop();
        Analytics.activityStopped(this);
        if (isFinishing() && GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0 && UAirship.shared().getPushManager().isPushEnabled())
        {
            UAirship.shared().getPushManager().updateRegistration();
        }
    }

    private class ErrorDialogFragment extends p
    {

        private static final String DIALOG_ERROR = "dialog_error";

        public static ErrorDialogFragment createInstance(int i)
        {
            ErrorDialogFragment errordialogfragment = new ErrorDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("dialog_error", i);
            errordialogfragment.setArguments(bundle);
            return errordialogfragment;
        }

        public void onCancel(DialogInterface dialoginterface)
        {
            super.onCancel(dialoginterface);
            getActivity().finish();
        }

        public Dialog onCreateDialog(Bundle bundle)
        {
            return GooglePlayServicesUtil.getErrorDialog(getArguments().getInt("dialog_error"), getActivity(), 1000);
        }

        public ErrorDialogFragment()
        {
        }
    }

}
