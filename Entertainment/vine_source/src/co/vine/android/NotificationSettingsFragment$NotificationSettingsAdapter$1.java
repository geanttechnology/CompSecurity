// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import co.vine.android.api.VineNotificationSetting;

// Referenced classes of package co.vine.android:
//            NotificationSettingsFragment

class val.setting
    implements android.view.._cls1
{

    final val.setting this$1;
    final tificationSettingsViewHolder val$h;
    final VineNotificationSetting val$setting;

    public void onClick(View view)
    {
        Object obj = this._cls1.this;
        android.content.res.Resources resources = getResources();
        boolean flag;
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((this._cls1) (obj)).tSelected(resources, flag, val$h.selectionIndicator);
        obj = val$setting;
        if (view.isSelected())
        {
            view = "on";
        } else
        {
            view = "off";
        }
        obj.value = view;
    }

    tificationSettingsViewHolder()
    {
        this$1 = final_tificationsettingsviewholder;
        val$h = tificationsettingsviewholder1;
        val$setting = VineNotificationSetting.this;
        super();
    }
}
