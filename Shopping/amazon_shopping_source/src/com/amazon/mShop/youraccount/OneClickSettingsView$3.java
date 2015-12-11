// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.view.View;
import android.widget.EditText;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.account.OneClickController;

// Referenced classes of package com.amazon.mShop.youraccount:
//            OneClickSettingsView

class val.amazonActivity
    implements android.view.kSettingsView._cls3
{

    final OneClickSettingsView this$0;
    final AmazonActivity val$amazonActivity;

    public void onClick(View view)
    {
        if (!OneClickSettingsView.access$000(OneClickSettingsView.this).isDeviceNameSet())
        {
            OneClickSettingsView.access$000(OneClickSettingsView.this).setDeviceName(OneClickSettingsView.access$200(OneClickSettingsView.this).getText().toString());
        }
        if (!OneClickSettingsView.access$000(OneClickSettingsView.this).hasServiceCallRunning())
        {
            OneClickSettingsView.access$000(OneClickSettingsView.this).doGetOneClickAddresses(OneClickSettingsView.access$300(OneClickSettingsView.this).getPopViewTaskCallback(OneClickSettingsView.access$000(OneClickSettingsView.this), val$amazonActivity, com.amazon.mShop.android.lib.ings_loading_shipping_addresses));
        }
    }

    _cls9()
    {
        this$0 = final_oneclicksettingsview;
        val$amazonActivity = AmazonActivity.this;
        super();
    }
}
