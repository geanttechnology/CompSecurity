// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.utils.CentralApkUtils;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication, AccountManagerLogic, AccountManagerDefinition

public final class AccountManagerImplementationFactory
{

    public static AccountManagerDefinition getAccountManagerImplementation(Context context)
    {
        if (CentralApkUtils.hasCentralAPK(context))
        {
            return (CentralAccountManagerCommunication)context.getSystemService("sso_map_account_manager_communicator");
        } else
        {
            return AccountManagerLogic.getInstance(context);
        }
    }
}
