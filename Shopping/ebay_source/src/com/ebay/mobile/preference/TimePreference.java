// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import com.ebay.common.Preferences;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.PreferencesActivity;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.util.ContentSyncManager;
import java.util.Locale;

public class TimePreference extends DialogPreference
{

    public static final String DEFAULT_END_HOUR = "0800";
    public static final String DEFAULT_START_HOUR = "2200";
    private Button buttonPositive;
    private TextView errorText;
    private String otherTime;
    private boolean startTime;
    private TimePicker timePicker;

    public TimePreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setDialogIcon(null);
    }

    private void enableOrDisablePositiveButton(String s)
    {
        if (s.equals(otherTime))
        {
            errorText.setVisibility(0);
            buttonPositive.setEnabled(false);
            return;
        } else
        {
            errorText.setVisibility(8);
            buttonPositive.setEnabled(true);
            return;
        }
    }

    private String makeStringTime(TimePicker timepicker)
    {
        return String.format(Locale.getDefault(), "%02d%02d", new Object[] {
            timepicker.getCurrentHour(), timepicker.getCurrentMinute()
        });
    }

    private boolean saveSettings()
    {
        NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(getContext());
        String s = MyApp.getPrefs().getCurrentUser();
        String s1 = makeStringTime(timePicker);
        if (s1.equals(otherTime))
        {
            if (getContext() instanceof PreferencesActivity)
            {
                ((DialogManager)((PreferencesActivity)getContext()).getShim(com/ebay/common/view/util/DialogManager)).showDynamicAlertDialog(getContext().getString(0x7f0708c9), getContext().getString(0x7f0708c8), false);
            }
            return false;
        }
        if (startTime)
        {
            notificationpreferencemanager.setUserQuietTimeStart(s, s1);
            ContentSyncManager.notifyUpdate(s1, "QUIET_START");
        } else
        {
            notificationpreferencemanager.setUserQuietTimeEnd(s, s1);
            ContentSyncManager.notifyUpdate(s1, "QUIET_END");
        }
        return true;
    }

    public void onBindDialogView(View view)
    {
        String s;
        NotificationPreferenceManager notificationpreferencemanager;
        super.onBindDialogView(view);
        timePicker = (TimePicker)view.findViewById(0x7f100828);
        errorText = (TextView)view.findViewById(0x7f100135);
        s = MyApp.getPrefs().getCurrentUser();
        notificationpreferencemanager = new NotificationPreferenceManager(getContext());
        if (!notificationpreferencemanager.isUserQuietTimeEnabled(s)) goto _L2; else goto _L1
_L1:
        if (!startTime) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = notificationpreferencemanager.getQuietStartTimeLocal(s);
        view = ((View) (obj));
        if (obj == null)
        {
            view = "2200";
        }
        otherTime = notificationpreferencemanager.getQuietEndTimeLocal(s);
        obj = view;
        if (otherTime == null)
        {
            otherTime = "0800";
            obj = view;
        }
_L6:
        view = android.provider.Settings.System.getString(getContext().getContentResolver(), "time_12_24");
        timePicker.setIs24HourView(Boolean.valueOf("24".equals(view)));
        timePicker.setCurrentHour(Integer.valueOf(Integer.parseInt(((String) (obj)).substring(0, 2))));
        timePicker.setCurrentMinute(Integer.valueOf(Integer.parseInt(((String) (obj)).substring(2))));
_L2:
        return;
_L4:
        obj = notificationpreferencemanager.getQuietEndTimeLocal(s);
        view = ((View) (obj));
        if (obj == null)
        {
            view = "0800";
        }
        otherTime = notificationpreferencemanager.getQuietStartTimeLocal(s);
        obj = view;
        if (otherTime == null)
        {
            otherTime = "2200";
            obj = view;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            saveSettings();
        }
    }

    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder)
    {
        super.onPrepareDialogBuilder(builder);
        builder.setIcon(null);
    }

    public void setStartTime(boolean flag)
    {
        startTime = flag;
    }

    public void showDialog(Bundle bundle)
    {
        super.showDialog(bundle);
        buttonPositive = ((AlertDialog)getDialog()).getButton(-1);
        enableOrDisablePositiveButton(makeStringTime(timePicker));
        timePicker.setOnTimeChangedListener(new android.widget.TimePicker.OnTimeChangedListener() {

            final TimePreference this$0;

            public void onTimeChanged(TimePicker timepicker, int i, int j)
            {
                enableOrDisablePositiveButton(makeStringTime(timepicker));
            }

            
            {
                this$0 = TimePreference.this;
                super();
            }
        });
    }


}
