// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.parentalcontrols.ParentalControlsPin;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            ParentalControlPinFragment

public class AdultContentSettingChangeActivity extends BaseActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/common/AdultContentSettingChangeActivity);
    private final ErrorDialogFactory errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
    private TaskExecutionListener pinListener;
    private TaskExecutor pinProvider;
    private ProgressDialog progressDialog;
    private PlayNowUserManager userManager;

    public AdultContentSettingChangeActivity()
    {
        pinProvider = PlayerContainer.getInstance().getParentalControlsSettingsTaskExecutor();
        userManager = PlayerContainer.getInstance().getUserManager();
    }

    protected void onPause()
    {
        super.onPause();
        pinProvider.cancelNotificationsFor(pinListener);
        if (progressDialog != null)
        {
            progressDialog.dismiss();
        }
    }

    protected void onResume()
    {
        super.onResume();
        android.content.DialogInterface.OnCancelListener oncancellistener = new android.content.DialogInterface.OnCancelListener() {

            final AdultContentSettingChangeActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = AdultContentSettingChangeActivity.this;
                super();
            }
        };
        progressDialog = ProgressDialog.show(this, "", getResources().getString(com.xfinity.playerlib.R.string.checking_parental_controls_progress_message), true);
        pinListener = pinProvider.execute(new RetryingTaskExecutionListener(this, errorDialogFactory, oncancellistener, oncancellistener) {

            final AdultContentSettingChangeActivity this$0;
            final android.content.DialogInterface.OnCancelListener val$cancelListener;

            public void onPostExecute(ParentalControlsSettings parentalcontrolssettings)
            {
                progressDialog.dismiss();
                final ParentalControlsPin pin = parentalcontrolssettings.getParentalPin();
                final PlayerUserSettings settings = (PlayerUserSettings)userManager.getUserSettings();
                boolean flag;
                if (!settings.getWantsAdultContent())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (pin == null)
                {
                    settings.setWantsAdultContent(flag);
                    finish();
                    return;
                } else
                {
                    parentalcontrolssettings = new ParentalControlPinFragment();
                    parentalcontrolssettings.setPinValidator(flag. new com.comcast.cim.android.view.common.PinKeypadFragment.PinValidator() {

                        final _cls2 this$1;
                        final boolean val$desiredSetting;
                        final ParentalControlsPin val$pin;
                        final PlayerUserSettings val$settings;

                        public void validatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
                        {
                            boolean flag = (new ParentalControlsPin(s)).equals(pin);
                            if (flag)
                            {
                                settings.setWantsAdultContent(desiredSetting);
                                finish();
                            }
                            pinvalidationcompletedlistener.onPinValidationComplete(flag);
                        }

            
            {
                this$1 = final__pcls2;
                pin = parentalcontrolspin;
                settings = playerusersettings;
                desiredSetting = Z.this;
                super();
            }
                    });
                    parentalcontrolssettings.setOnCancelListener(cancelListener);
                    pin = getFragmentManager().beginTransaction();
                    pin.addToBackStack(null);
                    parentalcontrolssettings.show(pin, "dialog");
                    return;
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((ParentalControlsSettings)obj);
            }

            
            {
                this$0 = AdultContentSettingChangeActivity.this;
                cancelListener = oncancellistener1;
                super(final_taskexecutor, context, errordialogfactory, oncancellistener);
            }
        });
    }



}
