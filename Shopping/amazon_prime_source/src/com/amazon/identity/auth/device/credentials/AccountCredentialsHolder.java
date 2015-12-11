// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.credentials;

import android.content.Context;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.storage.AnonymousCredentialsStore;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.credentials:
//            AccountCredentials, AmazonAccountCredentials

public final class AccountCredentialsHolder
{

    private static final AccountCredentials NULL_CREDENTIALS = new AccountCredentials() {

        public String getPrivateKey()
        {
            return null;
        }

        public String getToken()
        {
            return null;
        }

        public boolean isStale$faab209()
        {
            return true;
        }

    };
    private static AccountCredentials sMainCredentials = null;
    private static Map sSecondaryCredentials = new HashMap();

    public static AccountCredentials getCredentialsForAccount(Context context, String s)
    {
        com/amazon/identity/auth/device/credentials/AccountCredentialsHolder;
        JVM INSTR monitorenter ;
        Object obj = new AmazonAccountManager(context);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!((AmazonAccountManager) (obj)).isDevicePrimaryAmazonAccount(s)) goto _L3; else goto _L2
_L2:
        context = getInstance(context);
_L5:
        com/amazon/identity/auth/device/credentials/AccountCredentialsHolder;
        JVM INSTR monitorexit ;
        return context;
_L3:
        Context context1;
        obj = (AccountCredentials)sSecondaryCredentials.get(s);
        context1 = context.getApplicationContext();
        context = ((Context) (obj));
        if (validCredentials$212872d0(((AccountCredentials) (obj))))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = AmazonAccountCredentials.createFromContextForAccount(context1, s);
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        context = NULL_CREDENTIALS;
        continue; /* Loop/switch isn't completed */
        sSecondaryCredentials.put(s, context);
        if (true) goto _L5; else goto _L4
_L4:
        context;
        throw context;
    }

    public static AccountCredentials getInstance(Context context)
    {
        com/amazon/identity/auth/device/credentials/AccountCredentialsHolder;
        JVM INSTR monitorenter ;
        context = context.getApplicationContext();
        if (!validCredentials$212872d0(sMainCredentials)) goto _L2; else goto _L1
_L1:
        context = sMainCredentials;
_L4:
        com/amazon/identity/auth/device/credentials/AccountCredentialsHolder;
        JVM INSTR monitorexit ;
        return context;
_L2:
        AmazonAccountCredentials amazonaccountcredentials;
        amazonaccountcredentials = AmazonAccountCredentials.createFromContext(context);
        sMainCredentials = amazonaccountcredentials;
        if (amazonaccountcredentials != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        sMainCredentials = (new AnonymousCredentialsStore(context)).getCredentials();
        context = sMainCredentials;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    private static boolean validCredentials$212872d0(AccountCredentials accountcredentials)
    {
        return accountcredentials != null && !accountcredentials.isStale$faab209();
    }

}
