// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
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
//            DataStorage, DataStorageFactory, CentralLocalDataStorage, AbstractTokenEncryptor, 
//            AccountTransaction

public class BackwardsCompatiableDataStorage extends DataStorage
{

    private static final String TAG = com/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage.getName();
    private final Context mContext;
    private final boolean mIsUsingNewCentralLocalDataStorage;
    private final PlatformWrapper mPlatform;
    private final DataStorage mStorage;

    public BackwardsCompatiableDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mIsUsingNewCentralLocalDataStorage = mStorage instanceof CentralLocalDataStorage;
    }

    public BackwardsCompatiableDataStorage(Context context, DataStorage datastorage)
    {
        mContext = ServiceWrappingContext.create(context);
        mStorage = datastorage;
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mIsUsingNewCentralLocalDataStorage = mStorage instanceof CentralLocalDataStorage;
    }

    private boolean areTokensThatAreHistoricallyInUserdata(String s)
    {
        return BackwardsCompatiabilityHelper.isADcpOnlyToken(s) || BackwardsCompatiabilityHelper.isEncryptedTokenInUserData(s);
    }

    private String encryptUserDataIfNeccesary(AbstractTokenEncryptor abstracttokenencryptor, String s, String s1)
    {
        if (!BackwardsCompatiabilityHelper.isEncryptedTokenInUserData(s))
        {
            return s1;
        } else
        {
            return abstracttokenencryptor.encryptToken(s1);
        }
    }

    private String encryptedDCPOnlyTokenIfNeccesary(String s, String s1)
    {
        if (!BackwardsCompatiabilityHelper.isADcpOnlyToken(s))
        {
            return s1;
        } else
        {
            return (new DCPOnlyTokenEncryptor(mContext)).encryptToken(s1);
        }
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        Map map = accounttransaction.getUserData();
        if (!mIsUsingNewCentralLocalDataStorage)
        {
            final String encryptKey = AESCipher.generateAesSecureStorageKey();
            map.put("com.amazon.dcp.sso.property.encryptKey", encryptKey);
            java.util.Map.Entry entry;
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); entry.setValue(encryptedDCPOnlyTokenIfNeccesary((String)entry.getKey(), (String)entry.getValue())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            encryptKey = new AbstractTokenEncryptor() {

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
            java.util.Map.Entry entry1;
            for (Iterator iterator1 = map.entrySet().iterator(); iterator1.hasNext(); entry1.setValue(encryptUserDataIfNeccesary(encryptKey, (String)entry1.getKey(), (String)entry1.getValue())))
            {
                entry1 = (java.util.Map.Entry)iterator1.next();
            }

        }
        HashMap hashmap = new HashMap();
        if (accounttransaction.getTokens() != null)
        {
            for (Iterator iterator2 = accounttransaction.getTokens().entrySet().iterator(); iterator2.hasNext();)
            {
                java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                if (areTokensThatAreHistoricallyInUserdata((String)entry2.getKey()))
                {
                    map.put(entry2.getKey(), entry2.getValue());
                } else
                {
                    hashmap.put(entry2.getKey(), entry2.getValue());
                }
            }

        }
        return mStorage.addAccount(s, new AccountTransaction(accounttransaction.getDirectedId(), map, hashmap), datapropogationcallback);
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

    public String getDirectedId(String s)
    {
        return mStorage.getDirectedId(s);
    }

    public String getDisplayName(String s)
    {
        return mStorage.getDisplayName(s);
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
            s = new AccountTokenEncryptor(mContext, s);
        } else
        {
            s = new DCPOnlyTokenEncryptor(mContext);
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
            return (new AccountTokenEncryptor(mContext, s)).decryptToken(s3);
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
        mStorage.setData(accounttransaction);
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
            s2 = encryptedDCPOnlyTokenIfNeccesary(s1, encryptUserDataIfNeccesary(new AccountTokenEncryptor(mContext, s), s1, s2));
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
