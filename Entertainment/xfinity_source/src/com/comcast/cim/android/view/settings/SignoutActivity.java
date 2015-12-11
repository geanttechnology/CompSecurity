// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.model.user.UserManager;

public class SignoutActivity extends BaseActivity
{

    private LaunchStrategy launchStrategy;
    private UserManager userManager;

    public SignoutActivity()
    {
        userManager = CALContainer.getInstance().getUserManager();
        launchStrategy = CALContainer.getInstance().getLaunchStrategy();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new AlertDialog(this) {

            final SignoutActivity this$0;

            public boolean onSearchRequested()
            {
                return false;
            }

            
            {
                this$0 = SignoutActivity.this;
                super(context);
            }
        };
        bundle.setMessage("Are you sure you want to sign out?");
        bundle.setButton(-1, "Yes", new android.content.DialogInterface.OnClickListener() {

            final SignoutActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                userManager.signOutUser();
                launchStrategy.restartAppFlow(SignoutActivity.this);
                finish();
            }

            
            {
                this$0 = SignoutActivity.this;
                super();
            }
        });
        bundle.setButton(-2, "No", new android.content.DialogInterface.OnClickListener() {

            final SignoutActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = SignoutActivity.this;
                super();
            }
        });
        bundle.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final SignoutActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = SignoutActivity.this;
                super();
            }
        });
        bundle.show();
    }


}
