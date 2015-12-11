// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.authentication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.cim.model.user.UserManager;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import java.util.ArrayList;
import java.util.List;

public class PlayNowSignoutActivity extends Activity
{

    private PlayerAndroidDevice androidDevice;
    private LaunchStrategy launchStrategy;
    private PlayerDownloadServiceManager playerDownloadServiceManager;
    private UserManager userManager;

    public PlayNowSignoutActivity()
    {
        userManager = PlayerContainer.getInstance().getUserManager();
        launchStrategy = PlayerContainer.getInstance().getLaunchStrategy();
        playerDownloadServiceManager = PlayerContainer.getInstance().getDownloadServiceManager();
        androidDevice = PlayerContainer.getInstance().getAndroidDevice();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (androidDevice.isKindle())
        {
            getWindow().addFlags(1024);
        }
        Object obj = new Bundle();
        ((Bundle) (obj)).putString("title", getString(com.xfinity.playerlib.R.string.settings_signout_title));
        ((Bundle) (obj)).putString("description", getString(com.xfinity.playerlib.R.string.settings_signout_message));
        bundle = CALDialogFragment.newInstance("inputPromptDlg");
        bundle.addArguments(((Bundle) (obj)));
        obj = new ArrayList();
        ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getString(com.xfinity.playerlib.R.string.dlg_btn_yes), new android.content.DialogInterface.OnClickListener() {

            final PlayNowSignoutActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                try
                {
                    if (playerDownloadServiceManager != null)
                    {
                        playerDownloadServiceManager.deleteAllContent();
                    }
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface) { }
                userManager.signOutUser();
                launchStrategy.restartAppFlow(PlayNowSignoutActivity.this);
                finish();
            }

            
            {
                this$0 = PlayNowSignoutActivity.this;
                super();
            }
        }));
        ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_no), new android.content.DialogInterface.OnClickListener() {

            final PlayNowSignoutActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = PlayNowSignoutActivity.this;
                super();
            }
        }));
        bundle.setButtonList(((List) (obj)));
        bundle.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final PlayNowSignoutActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = PlayNowSignoutActivity.this;
                super();
            }
        });
        bundle.show(getFragmentManager(), "caldialogfragment");
    }



}
