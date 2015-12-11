// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleSettingsActivity

class this._cls0
    implements android.view.y._cls7
{

    final MyCrackleSettingsActivity this$0;

    public void onClick(View view)
    {
        view = MyCrackleSettingsActivity.access$100(MyCrackleSettingsActivity.this);
        boolean flag;
        if (!MyCrackleSettingsActivity.access$100(MyCrackleSettingsActivity.this).isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
    }

    ()
    {
        this$0 = MyCrackleSettingsActivity.this;
        super();
    }
}
