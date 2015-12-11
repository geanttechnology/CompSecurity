// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.preference.PreferenceScreen;
import android.view.View;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.downloads.RegisteredDevice;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            ButtonPreference, PlayNowPreferenceDelegate

class val.button
    implements android.view.referenceDelegate._cls12._cls1
{

    final is._cls0 this$1;
    final ButtonPreference val$button;

    public void onClick(View view)
    {
        val$button.showProgress();
        PlayNowPreferenceDelegate.access$1400(_fld0);
    }

    tener()
    {
        this$1 = final_tener;
        val$button = ButtonPreference.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12

/* anonymous class */
    class PlayNowPreferenceDelegate._cls12 extends DefaultTaskExecutionListener
    {

        final PlayNowPreferenceDelegate this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            taskexecutionexception = PlayNowPreferenceDelegate.access$1500(PlayNowPreferenceDelegate.this, (Exception)taskexecutionexception.getCause());
            taskexecutionexception.setPositiveButton(com.xfinity.playerlib.R.string.dlg_btn_try_again, new PlayNowPreferenceDelegate._cls12._cls4()).setNegativeButton(com.xfinity.playerlib.R.string.dlg_btn_cancel, new PlayNowPreferenceDelegate._cls12._cls3()).setOnCancelListener(new PlayNowPreferenceDelegate._cls12._cls2());
            taskexecutionexception.create().show();
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((List)obj);
        }

        public void onPostExecute(List list)
        {
            PlayNowPreferenceDelegate.access$1102(PlayNowPreferenceDelegate.this, list);
            Object obj = PlayNowPreferenceDelegate.access$1200(PlayNowPreferenceDelegate.this, com.xfinity.playerlib.R.string.settings_manage_devices_loading_key);
            if (obj != null)
            {
                PlayNowPreferenceDelegate.access$1300(PlayNowPreferenceDelegate.this).removePreference(((android.preference.Preference) (obj)));
            }
            obj = ((PlayerUserSettings)PlayNowPreferenceDelegate.access$900(PlayNowPreferenceDelegate.this).getUserSettings()).getDeviceRegistration();
            ButtonPreference buttonpreference;
            for (list = list.iterator(); list.hasNext(); PlayNowPreferenceDelegate.access$1300(PlayNowPreferenceDelegate.this).addPreference(buttonpreference))
            {
                RegisteredDevice registereddevice = (RegisteredDevice)list.next();
                buttonpreference = new ButtonPreference(PlayNowPreferenceDelegate.access$200(PlayNowPreferenceDelegate.this), null);
                buttonpreference.setKey(registereddevice.getDeviceId());
                buttonpreference.setTitleText(registereddevice.getDeviceName());
                if (obj != null && registereddevice.getDeviceId().equals(((DeviceRegistration) (obj)).getDeviceId()))
                {
                    Resources resources = PlayNowPreferenceDelegate.access$1300(PlayNowPreferenceDelegate.this).getContext().getResources();
                    buttonpreference.setTitleText(resources.getString(com.xfinity.playerlib.R.string.settings_dl_devices_this_device));
                    buttonpreference.setRightButtonText(resources.getString(com.xfinity.playerlib.R.string.settings_dl_devices_remove));
                    buttonpreference.setRightButtonClickListener(buttonpreference. new PlayNowPreferenceDelegate._cls12._cls1());
                }
            }

        }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }

        // Unreferenced inner class com/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2

/* anonymous class */
        class PlayNowPreferenceDelegate._cls12._cls2
            implements android.content.DialogInterface.OnCancelListener
        {

            final PlayNowPreferenceDelegate._cls12 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface = PlayNowPreferenceDelegate.access$1600(this$0, PlayNowPreferenceDelegate.access$200(this$0).getString(com.xfinity.playerlib.R.string.settings_manage_devices_loading_key));
                if (dialoginterface != null)
                {
                    PlayNowPreferenceDelegate.access$1300(this$0).removePreference(dialoginterface);
                }
            }

                    
                    {
                        this$1 = PlayNowPreferenceDelegate._cls12.this;
                        super();
                    }
        }


        // Unreferenced inner class com/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$3

/* anonymous class */
        class PlayNowPreferenceDelegate._cls12._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlayNowPreferenceDelegate._cls12 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

                    
                    {
                        this$1 = PlayNowPreferenceDelegate._cls12.this;
                        super();
                    }
        }


        // Unreferenced inner class com/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$4

/* anonymous class */
        class PlayNowPreferenceDelegate._cls12._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final PlayNowPreferenceDelegate._cls12 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                PlayNowPreferenceDelegate.access$1800(this$0).execute(PlayNowPreferenceDelegate.access$1700(this$0));
            }

                    
                    {
                        this$1 = PlayNowPreferenceDelegate._cls12.this;
                        super();
                    }
        }

    }

}
