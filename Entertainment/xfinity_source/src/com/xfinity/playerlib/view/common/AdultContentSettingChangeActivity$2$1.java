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

class val.desiredSetting
    implements com.comcast.cim.android.view.common.l.desiredSetting
{

    final etedListener.onPinValidationComplete this$1;
    final boolean val$desiredSetting;
    final ParentalControlsPin val$pin;
    final PlayerUserSettings val$settings;

    public void validatePin(String s, com.comcast.cim.android.view.common.edListener edlistener)
    {
        boolean flag = (new ParentalControlsPin(s)).equals(val$pin);
        if (flag)
        {
            val$settings.setWantsAdultContent(val$desiredSetting);
            finish();
        }
        edlistener.onPinValidationComplete(flag);
    }

    l.cancelListener()
    {
        this$1 = final_cancellistener;
        val$pin = parentalcontrolspin;
        val$settings = playerusersettings;
        val$desiredSetting = Z.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2

/* anonymous class */
    class AdultContentSettingChangeActivity._cls2 extends RetryingTaskExecutionListener
    {

        final AdultContentSettingChangeActivity this$0;
        final android.content.DialogInterface.OnCancelListener val$cancelListener;

        public void onPostExecute(ParentalControlsSettings parentalcontrolssettings)
        {
            AdultContentSettingChangeActivity.access$000(AdultContentSettingChangeActivity.this).dismiss();
            final ParentalControlsPin pin = parentalcontrolssettings.getParentalPin();
            final PlayerUserSettings settings = (PlayerUserSettings)AdultContentSettingChangeActivity.access$100(AdultContentSettingChangeActivity.this).getUserSettings();
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
                parentalcontrolssettings.setPinValidator(flag. new AdultContentSettingChangeActivity._cls2._cls1());
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
                this$0 = final_adultcontentsettingchangeactivity;
                cancelListener = oncancellistener1;
                super(TaskExecutor.this, context, errordialogfactory, oncancellistener);
            }
    }

}
