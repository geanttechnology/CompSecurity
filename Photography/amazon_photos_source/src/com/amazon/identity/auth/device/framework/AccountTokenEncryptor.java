// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.accounts.Account;
import android.util.Base64;
import com.amazon.identity.auth.device.storage.AbstractTokenEncryptor;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext

public class AccountTokenEncryptor extends AbstractTokenEncryptor
{

    private static final String TAG = com/amazon/identity/auth/device/framework/AccountTokenEncryptor.getName();
    private final DataStorage mDataStorage;
    private final String mDirectedId;

    public AccountTokenEncryptor(ServiceWrappingContext servicewrappingcontext, Account account)
    {
        this(servicewrappingcontext.getDataStorage(), BackwardsCompatiabilityHelper.getDirectedId(servicewrappingcontext, account));
    }

    public AccountTokenEncryptor(DataStorage datastorage, String s)
    {
        mDataStorage = datastorage;
        mDirectedId = s;
    }

    protected byte[] getEncryptionKey()
    {
        if (mDataStorage == null)
        {
            return null;
        }
        String s = mDataStorage.getUserData(mDirectedId, "com.amazon.dcp.sso.property.encryptKey");
        if (s == null)
        {
            MAPLog.e(TAG, "The current account does not have an encryption key. This is probably because it is not registered.");
            return null;
        } else
        {
            return Base64.decode(s, 0);
        }
    }

}
