// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ReflectionHelper;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LocalKeyValueStore, CentralAccountManagerDataStorage, AccountInfoV2, AbstractTokenEncryptor

public final class AccountManagerDataMigrationHelper
{
    private static class AccountManagerLegacyDataEncryptor extends AbstractTokenEncryptor
    {

        private final byte mEncryptionKeyBytes[];

        protected byte[] getEncryptionKey()
        {
            return mEncryptionKeyBytes;
        }

        public AccountManagerLegacyDataEncryptor(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("EncryptionKeyCannotBeNull");
            } else
            {
                mEncryptionKeyBytes = Base64.decode(s, 0);
                return;
            }
        }
    }


    static final int ACCOUNTS_COLUMNS_NUM = 4;
    static final int ACCOUNT_DISPLAY_NAME_COLUMN_INDEX = 1;
    static final int ACCOUNT_ID_COLUMN_INDEX = 0;
    static final int EXTRA_COLUMNS_NUM = 4;
    static final int ID_COLUMN_INDEX = 1;
    static final int KEY_COLUMN_INDEX = 2;
    private static final String TAG = com/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper.getName();
    static final int TOKENS_COLUMNS_NUM = 4;
    static final int VALUE_COLUMN_INDEX = 3;
    private final Context mContext;
    private final ReflectionHelper mReflectionHelper = new ReflectionHelper();

    public AccountManagerDataMigrationHelper(Context context)
    {
        mContext = context;
    }

    private boolean checkDuplicatedKeyInTwoMaps(HashMap hashmap, HashMap hashmap1)
    {
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext();)
        {
            Object obj = (java.util.Map.Entry)hashmap.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            if (hashmap1.containsKey(s) && !TextUtils.equals(((CharSequence) (obj)), (CharSequence)hashmap1.get(s)))
            {
                logAndRecordMigrationError((new StringBuilder("There's inconsistent data in two maps, the key is:")).append(s).toString(), "AccountManagerInconsistentData");
                return true;
            }
        }

        return false;
    }

    private boolean decryptTheTokenMap(HashMap hashmap, HashMap hashmap1)
    {
        hashmap1 = (String)hashmap1.get("com.amazon.dcp.sso.property.encryptKey");
        if (TextUtils.isEmpty(hashmap1))
        {
            logAndRecordMigrationError("There's no encryption key for the token. This should be an error", "AccountManagerMissingEncryptionKey");
            return false;
        }
        hashmap1 = new AccountManagerLegacyDataEncryptor(hashmap1);
        java.util.Map.Entry entry;
        String s1;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); entry.setValue(s1))
        {
            entry = (java.util.Map.Entry)hashmap.next();
            String s = (String)entry.getKey();
            s1 = (String)entry.getValue();
            if (s1 == null)
            {
                logAndRecordMigrationError((new StringBuilder("Cannot decrypt token when the value is null, the token key is: ")).append(s).toString(), "AccountManagerTokenValueIsNull");
                return false;
            }
            s1 = tryToDecryptData(hashmap1, s1);
            if (s1 == null)
            {
                logAndRecordMigrationError((new StringBuilder("Error happened when decrypting the token, the token key is: ")).append(s).toString(), "AccountManagerTokenDecryptionFail");
                return false;
            }
        }

        return true;
    }

    private boolean decryptTheUserDataMap(HashMap hashmap)
    {
        if (TextUtils.isEmpty((String)hashmap.get("com.amazon.dcp.sso.property.account.acctId")))
        {
            logAndRecordMigrationError("The directedId cannot be null, this should be an error.", "AccountManagerDirectedIdIsNull");
            return false;
        }
        Object obj = (String)hashmap.get("com.amazon.dcp.sso.property.encryptKey");
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            logAndRecordMigrationError("The userdata encryption key cannot be null, this should be an error.", "AccountManagerEncryptionKeyIsNull");
            return false;
        }
        obj = new AccountManagerLegacyDataEncryptor(((String) (obj)));
        Object obj1 = (new LocalKeyValueStore(mContext, "dcp.only.protected.store")).getValue("dcp.only.encrypt.key");
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            logAndRecordMigrationError("The dcp encryption key cannot be null, this should be an error.", "DCPOnlyEncryptionKeyIsNull");
            return false;
        }
        obj1 = new AccountManagerLegacyDataEncryptor(((String) (obj1)));
        hashmap = hashmap.entrySet().iterator();
        do
        {
            if (!hashmap.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)hashmap.next();
            String s = (String)entry.getKey();
            String s1 = (String)entry.getValue();
            if (s1 != null)
            {
                s1 = decryptUserDataIfNecessary(((AbstractTokenEncryptor) (obj)), ((AbstractTokenEncryptor) (obj1)), s, s1);
                if (s1 == null)
                {
                    logAndRecordMigrationError((new StringBuilder("Exception happened when try to decrypt the user data, the key is:")).append(s).toString(), "ExceptionHappendWhenDecryptUserData");
                    return false;
                }
                entry.setValue(s1);
            }
        } while (true);
        return true;
    }

    HashMap decryptLegacyDataAndCombineTokenMapAndUserDataMap(HashMap hashmap, HashMap hashmap1)
    {
        HashMap hashmap2 = new HashMap();
        if (isTheMapEmpty(hashmap))
        {
            logAndRecordMigrationError("There's no token map for this account Id. This should be an error.", "AccountManagerMissingTokenData");
            return null;
        }
        if (isTheMapEmpty(hashmap1))
        {
            logAndRecordMigrationError("There's no userdata map for this account Id. This should be an error.", "AccountManagerMissingUserData");
            return null;
        }
        if (!decryptTheTokenMap(hashmap, hashmap1))
        {
            return null;
        }
        hashmap2.putAll(hashmap);
        if (!decryptTheUserDataMap(hashmap1))
        {
            return null;
        } else
        {
            hashmap2.putAll(hashmap1);
            return hashmap2;
        }
    }

    String decryptUserDataIfNecessary(AbstractTokenEncryptor abstracttokenencryptor, AbstractTokenEncryptor abstracttokenencryptor1, String s, String s1)
    {
        if (s == null || abstracttokenencryptor == null || abstracttokenencryptor1 == null)
        {
            MAPLog.e(TAG, "Key is missing or dataEncrytor is null when trying to decrypt the user data");
            abstracttokenencryptor1 = null;
        } else
        {
            if (s1 == null)
            {
                abstracttokenencryptor = TAG;
                (new StringBuilder("The value of the key:")).append(s).append(" is Null").toString();
                return null;
            }
            if (BackwardsCompatiabilityHelper.isADcpOnlyToken(s))
            {
                return tryToDecryptData(abstracttokenencryptor1, s1);
            }
            abstracttokenencryptor1 = s1;
            if (BackwardsCompatiabilityHelper.isEncryptedTokenInUserData(s))
            {
                return tryToDecryptData(abstracttokenencryptor, s1);
            }
        }
        return abstracttokenencryptor1;
    }

    public List dumpDataFromAccountManager()
    {
        ArrayList arraylist = getSystemAccountManagerDataList();
        if (arraylist == null || arraylist.size() != 3)
        {
            return null;
        } else
        {
            return transformAccountManagerDataListToAccountInfoV2List((ArrayList)arraylist.get(0), (ArrayList)arraylist.get(1), (ArrayList)arraylist.get(2));
        }
    }

    String fromUTF8(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        try
        {
            abyte0 = new String(abyte0, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, "Cannot encode the given bytes as aUTF-8 string on this platform.");
            throw new RuntimeException("The encoding type UTF-8 is not supported, which should never happen.");
        }
        return abyte0;
    }

    ArrayList getSystemAccountManagerDataList()
    {
        Object obj1 = mContext.getSystemService("amazonaccountmanager");
        if (obj1 == null)
        {
            logAndRecordMigrationError("Can not get system service: AmazonAccountManager.", "canNotGetSystemServiceAmazonAccountManager");
            return null;
        }
        java.lang.reflect.Method method;
        Object obj2;
        Object obj3;
        try
        {
            obj3 = obj1.getClass().getMethod("getAmazonAccounts", new Class[] {
                Integer.TYPE
            });
            obj2 = obj1.getClass().getMethod("getAmazonAccountAuthTokens", new Class[] {
                Integer.TYPE
            });
            method = obj1.getClass().getMethod("getAmazonAccountExtras", new Class[] {
                Integer.TYPE
            });
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            logAndRecordMigrationError("Can not get system service method! This is an error!", "canNotGetAmazonAccountManagerMethod");
            return null;
        }
        if (obj3 == null || obj2 == null || method == null)
        {
            logAndRecordMigrationError("Error happened when reflecting the AmazonAccountManager method", "canNotGetAmazonAccountManagerMethod");
            return null;
        }
        Object obj = null;
        ArrayList arraylist = null;
        ArrayList arraylist1 = null;
        try
        {
            obj3 = mReflectionHelper.invoke(((java.lang.reflect.Method) (obj3)), obj1, new Object[] {
                Integer.valueOf(0)
            });
            if (obj3 instanceof ArrayList)
            {
                obj = (ArrayList)obj3;
            }
            obj2 = mReflectionHelper.invoke(((java.lang.reflect.Method) (obj2)), obj1, new Object[] {
                Integer.valueOf(0)
            });
            if (obj2 instanceof ArrayList)
            {
                arraylist = (ArrayList)obj2;
            }
            obj1 = mReflectionHelper.invoke(method, obj1, new Object[] {
                Integer.valueOf(0)
            });
            if (obj1 instanceof ArrayList)
            {
                arraylist1 = (ArrayList)obj1;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logAndRecordMigrationError("Failed to invoke function in AmazonAccountManager", "unableToInvokeFunctionInAmazonAccountManager");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logAndRecordMigrationError("Failed to invoke function in AmazonAccountManager", "unableToInvokeFunctionInAmazonAccountManager");
            return null;
        }
        if (isTheListEmpty(((List) (obj))) || isTheListEmpty(arraylist) || isTheListEmpty(arraylist1))
        {
            return null;
        } else
        {
            ArrayList arraylist2 = new ArrayList();
            arraylist2.add(obj);
            arraylist2.add(arraylist);
            arraylist2.add(arraylist1);
            return arraylist2;
        }
    }

    boolean isTheListEmpty(List list)
    {
        return list == null || list.size() == 0;
    }

    boolean isTheListFormatCorrect(List list, int i)
    {
        while (list == null || list.size() % i != 0) 
        {
            return false;
        }
        return true;
    }

    boolean isTheMapEmpty(Map map)
    {
        return map == null || map.isEmpty();
    }

    void logAndRecordMigrationError(String s, String s1)
    {
        MAPLog.e(TAG, s);
        MetricsHelper.increasePeriodicCounter(s1, new String[0]);
    }

    public void removeDataFromAccountManagerAfterMigration(String s)
    {
        if (s == null)
        {
            logAndRecordMigrationError("Cannot delete the account given directed is null!", "TryToDeleteNullDirectedAccount");
            return;
        } else
        {
            CentralAccountManagerDataStorage.getInstance(mContext).removeAccount(s);
            return;
        }
    }

    HashMap transformAccountManagerDBListToMap(ArrayList arraylist, int i)
    {
        HashMap hashmap2 = new HashMap();
        int j = 0;
        do
        {
            String s;
label0:
            {
                HashMap hashmap = hashmap2;
                if (j < arraylist.size())
                {
                    s = (String)arraylist.get(j + 1);
                    if (!TextUtils.isEmpty(s))
                    {
                        break label0;
                    }
                    logAndRecordMigrationError("Missing accountId in the list. This should be an error!", "AccountManagerMissingAccountId");
                    hashmap = null;
                }
                return hashmap;
            }
            HashMap hashmap1;
            String s1;
            String s2;
            String s3;
            if (!hashmap2.containsKey(s))
            {
                hashmap1 = new HashMap();
                hashmap2.put(s, hashmap1);
            } else
            {
                hashmap1 = (HashMap)hashmap2.get(s);
            }
            s1 = (String)arraylist.get(j + 2);
            s2 = (String)arraylist.get(j + 3);
            s3 = TAG;
            String.format("Migrate the key: %s for account_id: %s", new Object[] {
                s1, s
            });
            if (s1 == null)
            {
                logAndRecordMigrationError("There is one field missing the key!", "keyIsNullWhenParsingDataFromAccountManager");
                return null;
            }
            hashmap1.put(s1, s2);
            j += i;
        } while (true);
    }

    ArrayList transformAccountManagerDataListToAccountInfoV2List(ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2)
    {
        if (!isTheListEmpty(arraylist) && !isTheListEmpty(arraylist1) && !isTheListEmpty(arraylist2)) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "There's empty list returned by systen api. High possibility that there's no account in previous AccountManager");
        arraylist = null;
_L4:
        return arraylist;
_L2:
        if (!isTheListFormatCorrect(arraylist, 4) || !isTheListFormatCorrect(arraylist1, 4) || !isTheListFormatCorrect(arraylist2, 4))
        {
            logAndRecordMigrationError("The data list returned by platform is malformed!", "AccountManagerDataMalformed");
            return null;
        }
        HashMap hashmap = transformAccountManagerDBListToMap(arraylist1, 4);
        arraylist2 = transformAccountManagerDBListToMap(arraylist2, 4);
        arraylist = transformAccountsListToMap(arraylist);
        if (hashmap == null || arraylist2 == null || hashmap.isEmpty() || arraylist2.isEmpty() || isTheMapEmpty(arraylist))
        {
            logAndRecordMigrationError("Error Happend when transform the data list, mainly because missing some fields.", "AccountManagerMissingField");
            return null;
        }
        arraylist1 = new ArrayList();
        Iterator iterator = arraylist.entrySet().iterator();
        do
        {
            arraylist = arraylist1;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist = (java.util.Map.Entry)iterator.next();
            Object obj = (String)arraylist.getKey();
            arraylist = (String)arraylist.getValue();
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                logAndRecordMigrationError("The accountId cannot be null!", "AccountManagerAccountIdIsNull");
                return null;
            }
            if (arraylist == null)
            {
                logAndRecordMigrationError("The displayName cannot be null!", "AccountManagerDisplayNameIsNull");
                return null;
            }
            Object obj1 = (HashMap)hashmap.get(obj);
            obj = (HashMap)arraylist2.get(obj);
            if (checkDuplicatedKeyInTwoMaps(((HashMap) (obj1)), ((HashMap) (obj))))
            {
                return null;
            }
            obj = decryptLegacyDataAndCombineTokenMapAndUserDataMap(((HashMap) (obj1)), ((HashMap) (obj)));
            if (isTheMapEmpty(((Map) (obj))))
            {
                logAndRecordMigrationError("Error happens when combined the token map and user data map", "CombineAccountDataMapError");
                return null;
            }
            obj1 = (String)((HashMap) (obj)).get("com.amazon.dcp.sso.property.account.acctId");
            if (TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                logAndRecordMigrationError("The directedId cannot be null!", "AccountManagerDirectedIdIsNull");
                return null;
            }
            arraylist1.add(new AccountInfoV2(((String) (obj1)), arraylist, ((Map) (obj))));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    HashMap transformAccountsListToMap(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        int i = 0;
        do
        {
            Object obj;
label0:
            {
                obj = hashmap;
                if (i < arraylist.size())
                {
                    obj = (String)arraylist.get(i + 0);
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        break label0;
                    }
                    logAndRecordMigrationError("Missing accountId when parsing the accounts list, this should be an error.", "AccountManagerMissingIdInAccountList");
                    obj = null;
                }
                return ((HashMap) (obj));
            }
            String s = (String)arraylist.get(i + 1);
            if (s == null)
            {
                logAndRecordMigrationError("Missing display name when parsing the accounts list, this should be an error.", "AccountManagerMissingIdInAccountList");
                return null;
            }
            hashmap.put(obj, s);
            i += 4;
        } while (true);
    }

    String tryToDecryptData(AbstractTokenEncryptor abstracttokenencryptor, String s)
    {
        if (s == null || abstracttokenencryptor == null)
        {
            abstracttokenencryptor = null;
        } else
        {
            s = abstracttokenencryptor.decryptToken(s);
            abstracttokenencryptor = s;
            if (s == null)
            {
                MAPLog.w(TAG, "Could not decrypt the token. Something may be wrong with the encryption key");
                return s;
            }
        }
        return abstracttokenencryptor;
    }

}
