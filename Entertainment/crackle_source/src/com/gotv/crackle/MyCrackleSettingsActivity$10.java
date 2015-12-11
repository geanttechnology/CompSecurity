// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.CompoundButton;
import com.gotv.crackle.helpers.SharedPrefsManager;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleSettingsActivity

class this._cls0
    implements android.widget.eListener
{

    final MyCrackleSettingsActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        SharedPrefsManager.setIsWatchlistNotificationEnabled(flag);
    }

    istener()
    {
        this$0 = MyCrackleSettingsActivity.this;
        super();
    }
}
