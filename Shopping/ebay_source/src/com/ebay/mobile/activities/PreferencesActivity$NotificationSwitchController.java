// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.widget.CompoundButton;
import android.widget.Switch;
import com.ebay.mobile.notifications.NotificationPreferenceManager;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

public class register extends register
{

    final PreferencesActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        notificationPrefs.setEventEnabled(userId, "ALLNOTIFICATIONS", flag);
        toggleAllNotifications(flag);
    }

    public volatile void register()
    {
        super.gister();
    }

    public volatile void unregister()
    {
        super.register();
    }

    public Q(Switch switch1)
    {
        this$0 = PreferencesActivity.this;
        super(switch1);
        switch1.setChecked(getNotificationsEnabled());
        switch1.setEnabled(true);
        register();
    }
}
