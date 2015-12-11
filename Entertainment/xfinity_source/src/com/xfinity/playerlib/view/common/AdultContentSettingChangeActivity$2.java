// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.model.parentalcontrols.ParentalControlsPin;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            AdultContentSettingChangeActivity, ParentalControlPinFragment

class val.cancelListener extends RetryingTaskExecutionListener
{

    final AdultContentSettingChangeActivity this$0;
    final android.content.gChangeActivity val$cancelListener;

    public void onPostExecute(ParentalControlsSettings parentalcontrolssettings)
    {
        AdultContentSettingChangeActivity.access$000(AdultContentSettingChangeActivity.this).dismiss();
        final ParentalControlsPin pin = parentalcontrolssettings.getParentalPin();
        final PlayerUserSettings settings = (PlayerUserSettings)AdultContentSettingChangeActivity.access$100(AdultContentSettingChangeActivity.this).getUserSettings();
        final boolean desiredSetting;
        if (!settings.getWantsAdultContent())
        {
            desiredSetting = true;
        } else
        {
            desiredSetting = false;
        }
        if (pin == null)
        {
            settings.setWantsAdultContent(desiredSetting);
            finish();
            return;
        } else
        {
            parentalcontrolssettings = new ParentalControlPinFragment();
            parentalcontrolssettings.setPinValidator(new com.comcast.cim.android.view.common.PinKeypadFragment.PinValidator() {

                final AdultContentSettingChangeActivity._cls2 this$1;
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
                this$1 = AdultContentSettingChangeActivity._cls2.this;
                pin = parentalcontrolspin;
                settings = playerusersettings;
                desiredSetting = flag;
                super();
            }
            });
            parentalcontrolssettings.setOnCancelListener(val$cancelListener);
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

    _cls1.val.desiredSetting(Context context, ErrorDialogFactory errordialogfactory, android.content.ry ry, android.content.ry ry1)
    {
        this$0 = final_adultcontentsettingchangeactivity;
        val$cancelListener = ry1;
        super(TaskExecutor.this, context, errordialogfactory, ry);
    }
}
