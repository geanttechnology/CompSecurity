// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.attributes.CorPfmLogic;
import com.amazon.identity.auth.attributes.UserProperties;
import com.amazon.identity.auth.device.utils.ThreadUtils;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, MultipleAccountsLogic, AmazonAccountManager

class val.regData
    implements com.amazon.identity.auth.device.storage.ationCallback
{

    final AccountManagerLogic this$0;
    final String val$deviceEmail;
    final String val$deviceType;
    final String val$directedId;
    final Bundle val$regData;
    final Bundle val$userData;

    public void onSuccess()
    {
        AccountManagerLogic.access$700();
        AccountManagerLogic.access$800(AccountManagerLogic.this).invalidateCache();
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final AccountManagerLogic._cls5 this$1;

            public void run()
            {
                CorPfmLogic.notifyChange(directedId, AccountManagerLogic.access$900(this$0));
                String s = userData.getString("com.amazon.dcp.sso.property.devicename");
                UserProperties.sendDeviceNameChangedNotification(AccountManagerLogic.access$100(this$0), directedId, s);
                if (!AccountManagerLogic.access$1000(this$0).isSecondaryAmazonAccount(directedId))
                {
                    AccountManagerLogic.access$1100(this$0, deviceEmail, directedId, deviceType);
                }
            }

            
            {
                this$1 = AccountManagerLogic._cls5.this;
                super();
            }
        });
        boolean flag = val$regData.getBoolean("com.amazon.identity.auth.device.accountManager.newaccount", false);
        com.amazon.identity.auth.device.framework.ServiceWrappingContext servicewrappingcontext = AccountManagerLogic.access$100(AccountManagerLogic.this);
        MultipleAccountsLogic multipleaccountslogic = AccountManagerLogic.access$800(AccountManagerLogic.this);
        MultipleAccountPlugin multipleaccountplugin = AccountManagerLogic.access$900(AccountManagerLogic.this);
        ThreadUtils.submitToBackgroundThread(new ._cls1(servicewrappingcontext, val$directedId, multipleaccountslogic, multipleaccountplugin, flag));
    }

    _cls1.this._cls1()
    {
        this$0 = final_accountmanagerlogic;
        val$directedId = s;
        val$userData = bundle;
        val$deviceEmail = s1;
        val$deviceType = s2;
        val$regData = Bundle.this;
        super();
    }
}
