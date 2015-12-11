// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.os.Bundle;
import com.apptentive.android.sdk.ApptentiveInternal;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.Configuration;
import com.apptentive.android.sdk.module.engagement.interaction.model.AppStoreRatingInteraction;
import com.apptentive.android.sdk.module.rating.IRatingProvider;
import com.apptentive.android.sdk.module.rating.InsufficientRatingArgumentsException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            InteractionView

public class AppStoreRatingInteractionView extends InteractionView
{

    public AppStoreRatingInteractionView(AppStoreRatingInteraction appstoreratinginteraction)
    {
        super(appstoreratinginteraction);
    }

    private void displayError(final Activity activity, String s)
    {
        Log.e(s, new Object[0]);
        final AlertDialog alertDialog = (new android.app.AlertDialog.Builder(activity)).create();
        alertDialog.setTitle(activity.getString(com.apptentive.android.sdk.R.string.apptentive_oops));
        alertDialog.setMessage(s);
        alertDialog.setButton(-1, activity.getString(com.apptentive.android.sdk.R.string.apptentive_ok), new _cls1());
        alertDialog.setOnDismissListener(new _cls2());
        alertDialog.show();
    }

    public void doOnCreate(Activity activity, Bundle bundle)
    {
        Object obj;
        boolean flag;
        flag = false;
        obj = activity.getString(com.apptentive.android.sdk.R.string.apptentive_rating_error);
        bundle = ((Bundle) (obj));
        IRatingProvider iratingprovider = ApptentiveInternal.getRatingProvider();
        bundle = ((Bundle) (obj));
        String s = iratingprovider.activityNotFoundMessage(activity);
        bundle = s;
        String s1 = Configuration.load(activity).getAppDisplayName();
        bundle = s;
        obj = ApptentiveInternal.getRatingProviderArgs();
        if (obj == null) goto _L2; else goto _L1
_L1:
        bundle = s;
        obj = new HashMap(((Map) (obj)));
_L4:
        bundle = s;
        if (((Map) (obj)).containsKey("package"))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        bundle = s;
        ((Map) (obj)).put("package", activity.getPackageName());
        bundle = s;
        if (((Map) (obj)).containsKey("name"))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        bundle = s;
        ((Map) (obj)).put("name", s1);
        bundle = s;
        iratingprovider.startRating(activity, ((Map) (obj)));
        activity.finish();
        return;
_L2:
        bundle = s;
        obj = new HashMap();
        if (true) goto _L4; else goto _L3
_L3:
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        displayError(activity, bundle);
        return;
        bundle;
        flag = true;
_L6:
        if (!flag)
        {
            activity.finish();
        }
        throw bundle;
        bundle;
        Log.e(bundle.getMessage(), new Object[0]);
        displayError(activity, activity.getString(com.apptentive.android.sdk.R.string.apptentive_rating_error));
        return;
        bundle;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onBackPressed(Activity activity)
    {
        return true;
    }

    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final AppStoreRatingInteractionView this$0;
        final AlertDialog val$alertDialog;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            alertDialog.dismiss();
        }

        _cls1()
        {
            this$0 = AppStoreRatingInteractionView.this;
            alertDialog = alertdialog;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnDismissListener
    {

        final AppStoreRatingInteractionView this$0;
        final Activity val$activity;

        public void onDismiss(DialogInterface dialoginterface)
        {
            activity.finish();
        }

        _cls2()
        {
            this$0 = AppStoreRatingInteractionView.this;
            activity = activity1;
            super();
        }
    }

}
