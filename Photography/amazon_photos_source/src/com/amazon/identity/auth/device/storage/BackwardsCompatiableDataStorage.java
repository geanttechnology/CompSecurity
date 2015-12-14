// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.util.Base64;
import com.amazon.identity.auth.device.framework.AESCipher;
import com.amazon.identity.auth.device.framework.AccountTokenEncryptor;
import com.amazon.identity.auth.device.framework.DCPOnlyTokenEncryptor;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, CentralLocalDataStorage, AbstractTokenEncryptor, AccountTransaction

public class BackwardsCompatiableDataStorage extends DataStorage
{

    private static final String TAG = com/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage.getName();
    private final DCPOnlyTokenEncryptor mDcpOnlyTokenEncryptor;
    private final boolean mIsUsingNewCentralLocalDataStorage;
    private final PlatformWrapper mPlatform;
    private final DataStorage mStorage;

    public BackwardsCompatiableDataStorage(ServiceWrappingContext servicewrappingcontext)
    {
        this(servicewrappingcontext, servicewrappingcontext.getDataStorage());
    }

    public BackwardsCompatiableDataStorage(ServiceWrappingContext servicewrappingcontext, DataStorage datastorage)
    {
        this(datastorage, (PlatformWrapper)servicewrappingcontext.getSystemService("sso_platform"), new DCPOnlyTokenEncryptor(servicewrappingcontext));
    }

    BackwardsCompatiableDataStorage(DataStorage datastorage, PlatformWrapper platformwrapper, DCPOnlyTokenEncryptor dcponlytokenencryptor)
    {
        mStorage = datastorage;
        mPlatform = platformwrapper;
        mDcpOnlyTokenEncryptor = dcponlytokenencryptor;
        mIsUsingNewCentralLocalDataStorage = mStorage instanceof CentralLocalDataStorage;
    }

    private boolean areTokensThatAreHistoricallyInUserdata(String s)
    {
        return BackwardsCompatiabilityHelper.isADcpOnlyToken(s) || BackwardsCompatiabilityHelper.isEncryptedTokenInUserData(s);
    }

    private String encryptUserDataIfNeccesary(AbstractTokenEncryptor abstracttokenencryptor, String s, String s1)
    {
        if (BackwardsCompatiabilityHelper.isEncryptedTokenInUserData(s))
        {
            abstracttokenencryptor = abstracttokenencryptor.encryptToken(s1);
        } else
        {
            abstracttokenencryptor = s1;
            if (BackwardsCompatiabilityHelper.isADcpOnlyToken(s))
            {
                return mDcpOnlyTokenEncryptor.encryptToken(s1);
            }
        }
        return abstracttokenencryptor;
    }

    private AccountTransaction rewriteAccountTransaction(AccountTransaction accounttransaction, AbstractTokenEncryptor abstracttokenencryptor)
    {
        HashMap hashmap = new HashMap(accounttransaction.getUserData());
        HashMap hashmap1 = new HashMap();
        for (Iterator iterator = accounttransaction.getTokens().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (areTokensThatAreHistoricallyInUserdata((String)entry.getKey()))
            {
                hashmap.put(entry.getKey(), entry.getValue());
            } else
            {
                hashmap1.put(entry.getKey(), entry.getValue());
            }
        }

        if (abstracttokenencryptor != null)
        {
            java.util.Map.Entry entry1;
            for (Iterator iterator1 = hashmap.entrySet().iterator(); iterator1.hasNext(); entry1.setValue(encryptUserDataIfNeccesary(abstracttokenencryptor, (String)entry1.getKey(), (String)entry1.getValue())))
            {
                entry1 = (java.util.Map.Entry)iterator1.next();
            }

        }
        return new AccountTransaction(accounttransaction.getDirectedId(), hashmap, hashmap1);
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        final String encryptKey;
        AbstractTokenEncryptor abstracttokenencryptor;
        if (!mIsUsingNewCentralLocalDataStorage)
        {
            encryptKey = AESCipher.generateAesSecureStorageKey();
            abstracttokenencryptor = new AbstractTokenEncryptor() {

                final BackwardsCompatiableDataStorage this$0;
                final String val$encryptKey;

                protected byte[] getEncryptionKey()
                {
                    return Base64.decode(encryptKey, 0);
                }

            
            {
                this$0 = BackwardsCompatiableDataStorage.this;
                encryptKey = s;
                super();
            }
            };
        } else
        {
            abstracttokenencryptor = null;
            encryptKey = null;
        }
        accounttransaction = rewriteAccountTransaction(accounttransaction, abstracttokenencryptor);
        if (encryptKey != null)
        {
            accounttransaction.setUserData("com.amazon.dcp.sso.property.encryptKey", encryptKey);
        }
        return mStorage.addAccount(s, accounttransaction, datapropogationcallback);
    }

    public void expireToken(String s, String s1)
    {
        if (areTokensThatAreHistoricallyInUserdata(s1))
        {
            setUserData(s, s1, null);
            return;
        } else
        {
            mStorage.expireToken(s, s1);
            return;
        }
    }

    public Account getAccountForDirectedId(String s)
    {
        return mStorage.getAccountForDirectedId(s);
    }

    public Set getAccountNames()
    {
        return mStorage.getAccountNames();
    }

    public Set getAccounts()
    {
        return mStorage.getAccounts();
    }

    public String getDeviceData(String s, String s1)
    {
        return mStorage.getDeviceData(s, s1);
    }

    public String getDeviceSnapshot()
    {
        return mStorage.getDeviceSnapshot();
    }

    public String getToken(String s, String s1)
    {
        if (areTokensThatAreHistoricallyInUserdata(s1))
        {
            return getUserData(s, s1);
        } else
        {
            return mStorage.getToken(s, s1);
        }
    }

    public String getUndecryptedUserData(String s, String s1)
    {
        return mStorage.getUserData(s, s1);
    }

    public String getUserData(String s, String s1)
    {
        String s3 = mStorage.getUserData(s, s1);
        if (!mIsUsingNewCentralLocalDataStorage) goto _L2; else goto _L1
_L1:
        String s2 = s3;
_L4:
        return s2;
_L2:
        if (!BackwardsCompatiabilityHelper.isADcpOnlyToken(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (mPlatform.isOtter())
        {
            s = new AccountTokenEncryptor(mStorage, s);
        } else
        {
            s = mDcpOnlyTokenEncryptor;
        }
        s = s.decryptToken(s3);
        s2 = s;
        if (s == null)
        {
            MAPLog.w(TAG, "Could not decrypt tokens using expected methods.");
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s2 = s3;
        if (BackwardsCompatiabilityHelper.isEncryptedTokenInUserData(s1))
        {
            return (new AccountTokenEncryptor(mStorage, s)).decryptToken(s3);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void initialize()
    {
        mStorage.initialize();
    }

    public void removeAccount(String s)
    {
        mStorage.removeAccount(s);
    }

    public void setData(AccountTransaction accounttransaction)
    {
        Object obj;
        if (mIsUsingNewCentralLocalDataStorage)
        {
            obj = null;
        } else
        {
            obj = new AccountTokenEncryptor(mStorage, accounttransaction.getDirectedId());
        }
        mStorage.setData(rewriteAccountTransaction(accounttransaction, ((AbstractTokenEncryptor) (obj))));
    }

    public void setDeviceData(String s, String s1, String s2)
    {
        mStorage.setDeviceData(s, s1, s2);
    }

    public void setToken(String s, String s1, String s2)
    {
        if (areTokensThatAreHistoricallyInUserdata(s1))
        {
            setUserData(s, s1, s2);
            return;
        } else
        {
            mStorage.setToken(s, s1, s2);
            return;
        }
    }

    public void setUserData(String s, String s1, String s2)
    {
        if (mIsUsingNewCentralLocalDataStorage)
        {
            mStorage.setUserData(s, s1, s2);
            return;
        } else
        {
            s2 = encryptUserDataIfNeccesary(new AccountTokenEncryptor(mStorage, s), s1, s2);
            mStorage.setUserData(s, s1, s2);
            return;
        }
    }

    public void setup()
    {
        mStorage.setup();
    }

    public void syncDirtyData()
    {
        mStorage.syncDirtyData();
    }

}
