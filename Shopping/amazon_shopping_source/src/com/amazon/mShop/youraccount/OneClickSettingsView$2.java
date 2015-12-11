// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.widget.CompoundButton;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.util.ConfigUtils;

// Referenced classes of package com.amazon.mShop.youraccount:
//            OneClickSettingsView

class this._cls0
    implements android.widget.dChangeListener
{

    final OneClickSettingsView this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag != OneClickSettingsView.access$000(OneClickSettingsView.this).isOneClickStatusEnabled())
        {
            OneClickSettingsView.access$100(OneClickSettingsView.this, flag);
            if (!flag && ConfigUtils.isDigitalContentEnabled())
            {
                (new com.amazon.mShop.er(getContext())).setTitle(com.amazon.mShop.android.lib.ings_pop_up_title).setMessage(com.amazon.mShop.android.lib.ings_pop_up_message).setNeutralButton(com.amazon.mShop.android.lib.n, null).create().show();
            }
        }
    }

    r()
    {
        this$0 = OneClickSettingsView.this;
        super();
    }
}
