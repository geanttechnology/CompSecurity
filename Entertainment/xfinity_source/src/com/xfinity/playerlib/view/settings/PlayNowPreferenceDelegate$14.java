// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.PreferenceScreen;
import android.util.Log;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.downloads.DownloadServiceException;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate, ButtonPreference

class istener extends DefaultTaskExecutionListener
{

    final PlayNowPreferenceDelegate this$0;
    final PlayerUserSettings val$settings;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        try
        {
            PlayNowPreferenceDelegate.access$2100(PlayNowPreferenceDelegate.this, (Exception)taskexecutionexception.getCause());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TaskExecutionException taskexecutionexception)
        {
            Log.e("Settings", "Failed to show Alert Dialog for Unregister Failure!");
        }
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    public void onPostExecute(Void void1)
    {
        void1 = val$settings.getDeviceRegistration().getDeviceId();
        void1 = (ButtonPreference)PlayNowPreferenceDelegate.access$2000(PlayNowPreferenceDelegate.this, void1);
        try
        {
            PlayNowPreferenceDelegate.access$400(PlayNowPreferenceDelegate.this).deleteAllContent();
            val$settings.setDeviceRegistration(null);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            PlayNowPreferenceDelegate.access$2100(PlayNowPreferenceDelegate.this, void1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            Log.e("Settings", "Failed to show Alert Dialog for Unregister Success!");
            return;
        }
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        PlayNowPreferenceDelegate.access$1300(PlayNowPreferenceDelegate.this).removePreference(void1);
        void1 = new android.app.ePreference(PlayNowPreferenceDelegate.access$200(PlayNowPreferenceDelegate.this));
        void1.e("Device has been unregistered").e("Device Unregistration").veButton(PlayNowPreferenceDelegate.access$200(PlayNowPreferenceDelegate.this).getString(com.xfinity.playerlib.ceDelegate), new android.content.DialogInterface.OnClickListener() {

            final PlayNowPreferenceDelegate._cls14 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$1 = PlayNowPreferenceDelegate._cls14.this;
                super();
            }
        });
        void1._mth14().show();
        return;
    }

    _cls1.this._cls1()
    {
        this$0 = final_playnowpreferencedelegate;
        val$settings = PlayerUserSettings.this;
        super();
    }
}
