// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.CompoundButton;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.util.LocalNotificationManager;
import java.util.HashSet;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleSettingsActivity, Application

class this._cls0
    implements android.widget.eListener
{

    final MyCrackleSettingsActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        SharedPrefsManager.setIsPushEnabled(flag);
        (new HashSet(1)).add(Application.getInstance().getLocalization().getCurrentCountryCode());
        (new LocalNotificationManager()).create2DayNotification(MyCrackleSettingsActivity.this);
    }

    ()
    {
        this$0 = MyCrackleSettingsActivity.this;
        super();
    }
}
