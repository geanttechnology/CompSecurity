// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.widget.CompoundButton;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.SocialOnAPI;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleSettingsActivity, FacebookHelperActivity

class this._cls0
    implements android.widget.geListener
{

    final MyCrackleSettingsActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            compoundbutton = new Intent(MyCrackleSettingsActivity.this, com/gotv/crackle/FacebookHelperActivity);
            compoundbutton.putExtra("REQUEST_TYPE", 0);
            startActivity(compoundbutton);
        } else
        {
            compoundbutton = CrackleAccountManager.getUserID();
            if (compoundbutton != null)
            {
                MyCrackleSettingsActivity.access$000(MyCrackleSettingsActivity.this).updateSocialSettings(MyCrackleSettingsActivity.this, compoundbutton, false, true);
                return;
            }
        }
    }

    Listener()
    {
        this$0 = MyCrackleSettingsActivity.this;
        super();
    }
}
