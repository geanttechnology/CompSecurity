// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.account.OneClickController;

// Referenced classes of package com.amazon.mShop.youraccount:
//            OneClickSettingsView

class val.errorMethod
    implements com.amazon.mShop.error.rorBoxActionListener
{

    final OneClickSettingsView this$0;
    final String val$errorMethod;

    public void onActionButtonClick(int i)
    {
        if (OneClickSettingsView.access$000(OneClickSettingsView.this).hasServiceCallRunning())
        {
            OneClickSettingsView.access$000(OneClickSettingsView.this).cancel();
        }
        if ("enable_one_click_v1".equals(val$errorMethod))
        {
            OneClickSettingsView.access$100(OneClickSettingsView.this, true);
        } else
        {
            if ("disable_one_click_v1".equals(val$errorMethod))
            {
                OneClickSettingsView.access$100(OneClickSettingsView.this, false);
                return;
            }
            if ("get_one_click_addresses_v21".equals(val$errorMethod))
            {
                OneClickSettingsView.access$000(OneClickSettingsView.this).doGetOneClickAddresses(OneClickSettingsView.access$300(OneClickSettingsView.this).getPopViewTaskCallback(OneClickSettingsView.access$000(OneClickSettingsView.this), OneClickSettingsView.access$500(OneClickSettingsView.this), com.amazon.mShop.android.lib.ings_loading_shipping_addresses));
                return;
            }
            if ("get_one_click_config_v21".equals(val$errorMethod))
            {
                OneClickSettingsView.access$000(OneClickSettingsView.this).doGetOneClickConfig(OneClickSettingsView.access$300(OneClickSettingsView.this).getTaskCallback(OneClickSettingsView.access$000(OneClickSettingsView.this), com.amazon.mShop.android.lib.ings_loading));
                return;
            }
            if ("set_one_click_config_v21".equals(val$errorMethod))
            {
                OneClickSettingsView.access$000(OneClickSettingsView.this).doSetOneClickConfig(OneClickSettingsView.access$300(OneClickSettingsView.this).getPopViewTaskCallback(OneClickSettingsView.access$000(OneClickSettingsView.this), OneClickSettingsView.access$500(OneClickSettingsView.this), com.amazon.mShop.android.lib.ings_saving_shipping_payment_method));
                return;
            }
        }
    }

    ActionListener()
    {
        this$0 = final_oneclicksettingsview;
        val$errorMethod = String.this;
        super();
    }
}
