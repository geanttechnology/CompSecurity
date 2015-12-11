// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.attributes.CorPfmLogic;
import com.amazon.identity.auth.attributes.UserProperties;
import com.amazon.identity.auth.device.utils.ThreadUtils;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, AmazonAccountManager, MultipleAccountsLogic, AccountStateBroadcasts

class this._cls1
    implements Runnable
{

    final l.deviceType this$1;

    public void run()
    {
        CorPfmLogic.notifyChange(directedId, AccountManagerLogic.access$900(_fld0));
        String s = userData.getString("com.amazon.dcp.sso.property.devicename");
        UserProperties.sendDeviceNameChangedNotification(AccountManagerLogic.access$100(_fld0), directedId, s);
        if (!AccountManagerLogic.access$1000(_fld0).isSecondaryAmazonAccount(directedId))
        {
            AccountManagerLogic.access$1100(_fld0, deviceEmail, directedId, deviceType);
        }
    }

    l.deviceType()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/auth/accounts/AccountManagerLogic$5

/* anonymous class */
    class AccountManagerLogic._cls5
        implements com.amazon.identity.auth.device.storage.DataStorage.DataPropogationCallback
    {

        final AccountManagerLogic this$0;
        final String val$deviceEmail;
        final String val$deviceType;
        final String val$directedId;
        final Bundle val$userData;

        public void onSuccess()
        {
            AccountManagerLogic.access$700();
            AccountManagerLogic.access$800(AccountManagerLogic.this).invalidateCache();
            ThreadUtils.submitToBackgroundThread(new AccountManagerLogic._cls5._cls1());
            AccountStateBroadcasts.sendAsynchronousAccountAddedNotification(AccountManagerLogic.access$100(AccountManagerLogic.this), AccountManagerLogic.access$800(AccountManagerLogic.this), AccountManagerLogic.access$900(AccountManagerLogic.this), directedId, null);
        }

            
            {
                this$0 = final_accountmanagerlogic;
                directedId = s;
                userData = bundle;
                deviceEmail = s1;
                deviceType = String.this;
                super();
            }
    }

}
