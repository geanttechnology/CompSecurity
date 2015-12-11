// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.control.account.SignOutController;
import com.amazon.mShop.control.account.SignOutSubscriber;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;

public class LogoutActivity extends AmazonActivity
    implements android.view.View.OnClickListener, SignOutSubscriber
{

    private Button logoutButton;
    private String mRefMarker;
    private SignOutController signOutController;
    private TextView signedInAsText;
    private TaskCallback taskCallback;

    public LogoutActivity()
    {
    }

    private void setSignedInAsText(View view)
    {
        signedInAsText = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.you_are_signed_in_as_label);
        Object obj = User.getUser();
        if (obj != null)
        {
            obj = TextUtils.htmlEncode(((User) (obj)).getFullName());
            view = String.format(view.getResources().getString(com.amazon.mShop.android.lib.R.string.sign_out_you_are_signed_in_as), new Object[] {
                obj
            });
            signedInAsText.setText(Html.fromHtml(view));
        } else
        {
            signedInAsText.setText("");
        }
        signedInAsText.requestFocus();
    }

    public void onClick(View view)
    {
        SearchActivity.setPreviousSearchTerm("");
        if (!signOutController.hasServiceCallRunning())
        {
            view = null;
            if (MShopPushNotificationUtils.isPushNotificationAvailable())
            {
                view = PushNotificationManager.getInstance().getNewNotificationTarget(null);
            }
            signOutController.signOut(taskCallback, view);
        }
        if (!Util.isEmpty(mRefMarker))
        {
            RefMarkerObserver.logRefMarker(mRefMarker);
        }
        RefMarkerObserver.logRefMarker("sign_out");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        signOutController = new SignOutController(this);
        taskCallback = (new TaskCallbackFactory(this)).getFinishTaskCallback(signOutController, this, com.amazon.mShop.android.lib.R.string.sign_out_in_progress);
        setTitle(com.amazon.mShop.android.lib.R.string.sign_out_title);
        mRefMarker = getIntent().getStringExtra("REFMARKER");
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        Log.e("Amazon.LogoutActivity", (new StringBuilder()).append("error: ").append(exception).toString());
        AmazonErrorUtils.reportMShopServerError(this, null, getCurrentView(), exception);
    }

    protected void onResume()
    {
        super.onResume();
        setTitle(getString(com.amazon.mShop.android.lib.R.string.sign_out_title));
    }

    public void onSignOutComplete(String s)
    {
        if (s == null)
        {
            setResult(-1);
            if (ActivityUtils.isSignInPrompt())
            {
                AppUtils.restartApp();
                return;
            } else
            {
                ActivityUtils.startHomeActivity(this);
                return;
            }
        } else
        {
            UIUtils.alert(this, s);
            return;
        }
    }

    protected void onStart()
    {
        super.onStart();
        View view = View.inflate(this, com.amazon.mShop.android.lib.R.layout.logout, null);
        pushView(view);
        logoutButton = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.logout_button);
        logoutButton.setOnClickListener(this);
        setSignedInAsText(view);
    }

    protected void onStop()
    {
        super.onStop();
    }
}
