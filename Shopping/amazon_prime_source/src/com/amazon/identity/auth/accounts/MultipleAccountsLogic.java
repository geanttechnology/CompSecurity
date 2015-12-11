// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.auth.device.framework.Value;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.ArrayUtil;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountDefinition, AmazonAccountManager, SessionUserChanger

public class MultipleAccountsLogic
    implements MultipleAccountDefinition
{
    private static interface AccountMappingLogic
    {

        public abstract boolean isMappingCurrentlySetForAccount(String s);

        public abstract boolean isSupportedOnThisPlatform();

        public abstract List onDeregister(String s);

        public abstract List removeAndNotify(String s);

        public abstract List setAndNotify(String s);
    }

    private static class CustomKeyMappingLogic extends MetadataMappingClass
    {

        public static List constructCustomKeyMappingsForAccount(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager, String s)
        {
            Object obj = getMetadataForAccount(new BackwardsCompatiableDataStorage(servicewrappingcontext), s, "com.amazon.dcp.sso.property.account.extratokens.custom_keys");
            s = new ArrayList();
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.add(new CustomKeyMappingLogic(servicewrappingcontext, new com.amazon.identity.auth.device.api.MultipleAccountManager.CustomKeyMappingType((String)((Iterator) (obj)).next()), amazonaccountmanager))) { }
            return s;
        }

        public boolean isSupportedOnThisPlatform()
        {
            return com.amazon.identity.auth.device.api.MultipleAccountManager.CustomKeyMappingType.isSupportedOnThisPlatform(mContext);
        }

        public List notifyOfChange()
        {
            String s = mMapping.getAccountMappingValue();
            String s1 = (new StringBuilder("com.amazon.identity.action.ACCOUNT_FOR_KEY.")).append(s).toString();
            Bundle bundle = new Bundle();
            bundle.putString("account_key", s);
            return Arrays.asList(new NotificationInfo[] {
                new NotificationInfo(s1, null, bundle), new NotificationInfo("com.amazon.identity.action.ACCOUNT_FOR_KEY", null, bundle)
            });
        }

        public CustomKeyMappingLogic(ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype, AmazonAccountManager amazonaccountmanager)
        {
            super(servicewrappingcontext, accountmappingtype, amazonaccountmanager);
        }
    }

    private static class DevicePrimaryUserMappingLogic
        implements AccountMappingLogic
    {

        private final AmazonAccountManager mAmznAcctMan;
        private final Context mContext;

        public boolean isMappingCurrentlySetForAccount(String s)
        {
            return mAmznAcctMan.isDevicePrimaryAmazonAccount(s);
        }

        public boolean isSupportedOnThisPlatform()
        {
            return com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.isSupportedOnThisPlatform(mContext);
        }

        public List onDeregister(String s)
        {
            String _tmp = MultipleAccountsLogic.TAG;
            return new ArrayList();
        }

        public List removeAndNotify(String s)
        {
            MAPLog.e(MultipleAccountsLogic.TAG, "Primary user mapping cannot be removed");
            return new ArrayList();
        }

        public List setAndNotify(String s)
        {
            MAPLog.e(MultipleAccountsLogic.TAG, "Primary user mapping cannot be changed");
            return new ArrayList();
        }

        public DevicePrimaryUserMappingLogic(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager)
        {
            mContext = servicewrappingcontext;
            mAmznAcctMan = amazonaccountmanager;
        }
    }

    private static abstract class MetadataMappingClass
        implements AccountMappingLogic
    {

        private final AmazonAccountManager mAmznAcctMan;
        protected final ServiceWrappingContext mContext;
        private final BackwardsCompatiableDataStorage mDataStorage;
        protected final com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType mMapping;

        public static Set getMetadataForAccount(DataStorage datastorage, String s, String s1)
        {
            datastorage = datastorage.getUserData(s, s1);
            s = new HashSet();
            if (TextUtils.isEmpty(datastorage))
            {
                return s;
            } else
            {
                s.addAll(Arrays.asList(datastorage.split(",")));
                return s;
            }
        }

        private boolean removeMappingFromAccount(String s)
        {
            String s1 = mMapping.getAccountMappingType();
            String s2 = mMapping.getAccountMappingValue();
            Set set = getMetadataForAccount(mDataStorage, s, s1);
            String _tmp = MultipleAccountsLogic.TAG;
            set.toString();
            if (!set.contains(s2))
            {
                MAPLog.formattedWarning(MultipleAccountsLogic.TAG, "Cannot remove %s for type %s from account", new Object[] {
                    s2, s1
                });
                return false;
            } else
            {
                set.remove(s2);
                String _tmp1 = MultipleAccountsLogic.TAG;
                set.toString();
                mDataStorage.setUserData(s, s1, seralizeValues(set));
                return true;
            }
        }

        private String seralizeValues(Set set)
        {
            if (set == null)
            {
                return null;
            } else
            {
                return TextUtils.join(",", set);
            }
        }

        public boolean isMappingCurrentlySetForAccount(String s)
        {
            return getMetadataForAccount(mDataStorage, s, mMapping.getAccountMappingType()).contains(mMapping.getAccountMappingValue());
        }

        protected abstract List notifyOfChange();

        public List onDeregister(String s)
        {
            return removeAndNotify(s);
        }

        public List removeAndNotify(String s)
        {
            if (removeMappingFromAccount(s))
            {
                MAPLog.formattedInfo(MultipleAccountsLogic.TAG, "Notifying of user change of type %s removed. Account for profile %s changed.", new Object[] {
                    mMapping.getAccountMappingType(), mMapping.getAccountMappingValue()
                });
                return notifyOfChange();
            } else
            {
                MAPLog.formattedInfo(MultipleAccountsLogic.TAG, "Cannot remove mapping type %s for key %s did not change. Not notifing.", new Object[] {
                    mMapping.getAccountMappingType(), mMapping.getAccountMappingValue()
                });
                return new ArrayList();
            }
        }

        public List setAndNotify(String s)
        {
            Iterator iterator = mAmznAcctMan.getAccounts().iterator();
            boolean flag = false;
            while (iterator.hasNext()) 
            {
                String s1 = (String)iterator.next();
                if (s1.equals(s))
                {
                    String s2 = mMapping.getAccountMappingType();
                    String s3 = mMapping.getAccountMappingValue();
                    Set set = getMetadataForAccount(mDataStorage, s1, s2);
                    String _tmp = MultipleAccountsLogic.TAG;
                    set.toString();
                    boolean flag1;
                    if (set.contains(s3))
                    {
                        MAPLog.formattedWarning(MultipleAccountsLogic.TAG, "Cannot create mapping of type with value %s to account", new Object[] {
                            s2, s3
                        });
                        flag1 = false;
                    } else
                    {
                        set.add(s3);
                        String _tmp1 = MultipleAccountsLogic.TAG;
                        set.toString();
                        mDataStorage.setUserData(s1, s2, seralizeValues(set));
                        flag1 = true;
                    }
                    flag = flag1 | flag;
                } else
                {
                    removeMappingFromAccount(s1);
                }
            }
            if (flag)
            {
                MAPLog.formattedInfo(MultipleAccountsLogic.TAG, "Notifying of user change of type %s set. Account for profile %s changed.", new Object[] {
                    mMapping.getAccountMappingType(), mMapping.getAccountMappingValue()
                });
                return notifyOfChange();
            } else
            {
                MAPLog.formattedInfo(MultipleAccountsLogic.TAG, "Setting mapping type %s for key %s did not change. Not notifing.", new Object[] {
                    mMapping.getAccountMappingType(), mMapping.getAccountMappingValue()
                });
                return new ArrayList();
            }
        }

        public MetadataMappingClass(ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype, AmazonAccountManager amazonaccountmanager)
        {
            mContext = servicewrappingcontext;
            mAmznAcctMan = amazonaccountmanager;
            mDataStorage = new BackwardsCompatiableDataStorage(mContext);
            mMapping = accountmappingtype;
        }
    }

    private static class NotificationInfo
    {

        public final String action;
        public final Bundle extras;
        public final String packageName;

        public NotificationInfo(String s)
        {
            this(s, null, null);
        }

        public NotificationInfo(String s, String s1, Bundle bundle)
        {
            action = s;
            packageName = s1;
            extras = bundle;
        }
    }

    private static class PackageMappingLogic extends MetadataMappingClass
    {

        public static List constructPackageMappingsForAccount(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager, String s)
        {
            Object obj = getMetadataForAccount(new BackwardsCompatiableDataStorage(servicewrappingcontext), s, "com.amazon.dcp.sso.property.account.extratokens.account_packages");
            s = new ArrayList();
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.add(new PackageMappingLogic(servicewrappingcontext, new com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType((String)((Iterator) (obj)).next()), amazonaccountmanager))) { }
            return s;
        }

        public boolean isSupportedOnThisPlatform()
        {
            return com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType.isSupportedOnThisPlatform(mContext);
        }

        public List notifyOfChange()
        {
            return Arrays.asList(new NotificationInfo[] {
                new NotificationInfo("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED", mMapping.getAccountMappingValue(), null)
            });
        }

        public PackageMappingLogic(ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype, AmazonAccountManager amazonaccountmanager)
        {
            super(servicewrappingcontext, accountmappingtype, amazonaccountmanager);
        }
    }

    private static class ProfilePrimaryMappingLogic extends MetadataMappingClass
    {

        public static List constructProfileMappingForAccount(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager, String s)
        {
            Object obj = getMetadataForAccount(new BackwardsCompatiableDataStorage(servicewrappingcontext), s, "com.amazon.dcp.sso.property.account.extratokens.account_profiles");
            s = new ArrayList();
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                String s1 = (String)((Iterator) (obj)).next();
                Integer integer = StringConversionHelpers.toInteger(s1);
                if (integer == null)
                {
                    MAPLog.formattedError(MultipleAccountsLogic.TAG, "%s is not a valid profile id", new Object[] {
                        s1
                    });
                } else
                {
                    s.add(new ProfilePrimaryMappingLogic(servicewrappingcontext, com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(integer.intValue()), amazonaccountmanager));
                }
            }

            return s;
        }

        public boolean isSupportedOnThisPlatform()
        {
            return ((PlatformWrapper)mContext.getSystemService("sso_platform")).shouldUseProfiles();
        }

        public List notifyOfChange()
        {
            return Arrays.asList(new NotificationInfo[] {
                new NotificationInfo("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED")
            });
        }

        public ProfilePrimaryMappingLogic(ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype, AmazonAccountManager amazonaccountmanager)
        {
            super(servicewrappingcontext, accountmappingtype, amazonaccountmanager);
        }
    }

    private static class SessionUserMappingLogic
        implements AccountMappingLogic
    {

        private final AmazonAccountManager mAmznAcctMan;
        private final ServiceWrappingContext mContext;
        private final SessionUserChanger mSessionUserChanger;

        private List createChangedNotification(boolean flag)
        {
            if (flag)
            {
                return Arrays.asList(new NotificationInfo[] {
                    new NotificationInfo("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED")
                });
            } else
            {
                return new ArrayList();
            }
        }

        public boolean isMappingCurrentlySetForAccount(String s)
        {
            return mAmznAcctMan.isSessionUserAmazonAccount(s);
        }

        public boolean isSupportedOnThisPlatform()
        {
            return com.amazon.identity.auth.device.api.MultipleAccountManager.SessionUserMappingType.isSupportedOnThisPlatform(mContext);
        }

        public List onDeregister(String s)
        {
            if (!mAmznAcctMan.isSessionUserAmazonAccount(s))
            {
                MAPLog.w(MultipleAccountsLogic.TAG, "Account is not a session user, so cannot remove");
                return new ArrayList();
            }
            String _tmp = MultipleAccountsLogic.TAG;
            mSessionUserChanger.onSessionUserDeregistered(s);
            boolean flag;
            if (!mAmznAcctMan.isSessionUserAmazonAccount(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return createChangedNotification(flag);
        }

        public List removeAndNotify(String s)
        {
            if (!mAmznAcctMan.isSessionUserAmazonAccount(s))
            {
                MAPLog.w(MultipleAccountsLogic.TAG, "Account is not a session user, so cannot remove");
                return new ArrayList();
            } else
            {
                String _tmp = MultipleAccountsLogic.TAG;
                return setAndNotify(mAmznAcctMan.getDevicePrimaryAmazonAccount());
            }
        }

        public List setAndNotify(String s)
        {
            if (mAmznAcctMan.isSessionUserAmazonAccount(s))
            {
                MAPLog.w(MultipleAccountsLogic.TAG, "Account is already a session user");
                return new ArrayList();
            } else
            {
                mSessionUserChanger.changeSessionUsers(ArrayUtil.asSet(new String[] {
                    s
                }));
                return createChangedNotification(mAmznAcctMan.isSessionUserAmazonAccount(s));
            }
        }

        public SessionUserMappingLogic(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager)
        {
            mContext = servicewrappingcontext;
            mAmznAcctMan = amazonaccountmanager;
            mSessionUserChanger = new SessionUserChanger(amazonaccountmanager);
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/MultipleAccountsLogic.getName();
    private static MultipleAccountsLogic sTheOneAndOnly;
    private final Map mAccountMappingsToAccountCache = Collections.synchronizedMap(new HashMap());
    private final AmazonAccountManager mAmznAcctMan;
    private final ServiceWrappingContext mContext;
    private final PlatformWrapper mPlatform;
    private final TrustedPackageManager mTrustedPackageManager;
    private boolean mUpgradedToProfileImplementation;

    MultipleAccountsLogic(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAmznAcctMan = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mTrustedPackageManager = new TrustedPackageManager(mContext);
    }

    private transient String calculateAccountForMapping(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        Object obj = filterOutInvalidMappingsAndCreateMapplingLogic(aaccountmappingtype);
        aaccountmappingtype = mAmznAcctMan.getNonDeregisteringAmazonAccounts();
        obj = ((List) (obj)).iterator();
        String s;
label0:
        do
        {
            if (((Iterator) (obj)).hasNext())
            {
                AccountMappingLogic accountmappinglogic = (AccountMappingLogic)((Iterator) (obj)).next();
                Iterator iterator = aaccountmappingtype.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    s = (String)iterator.next();
                } while (!accountmappinglogic.isMappingCurrentlySetForAccount(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return s;
    }

    private AccountMappingLogic constructMappingLogic(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype)
    {
        if (accountmappingtype == null)
        {
            MAPLog.e(TAG, "Account Mapping Type given was null. Ignoring");
            return null;
        }
        String s = accountmappingtype.getAccountMappingType();
        if ("com.amazon.dcp.sso.property.sessionuser".equals(s))
        {
            return new SessionUserMappingLogic(mContext, mAmznAcctMan);
        }
        if ("com.amazon.dcp.sso.property.account.extratokens.account_profiles".equals(s))
        {
            if (mPlatform.shouldUseProfiles() || !Integer.toString(0).equals(accountmappingtype.getAccountMappingValue()))
            {
                upgradeToProfileImplementation();
                return new ProfilePrimaryMappingLogic(mContext, accountmappingtype, mAmznAcctMan);
            } else
            {
                return new DevicePrimaryUserMappingLogic(mContext, mAmznAcctMan);
            }
        }
        if ("com.amazon.dcp.sso.property.account.extratokens.account_packages".equals(s))
        {
            return new PackageMappingLogic(mContext, accountmappingtype, mAmznAcctMan);
        }
        if ("com.amazon.dcp.sso.property.account.extratokens.custom_keys".equals(s))
        {
            return new CustomKeyMappingLogic(mContext, accountmappingtype, mAmznAcctMan);
        }
        if ("primary_account_type".equals(s))
        {
            return new DevicePrimaryUserMappingLogic(mContext, mAmznAcctMan);
        } else
        {
            MAPLog.formattedError(TAG, "Account mapping type %s was not recongized", new Object[] {
                s
            });
            return null;
        }
    }

    private transient List filterOutInvalidMappingsAndCreateMapplingLogic(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        ArrayList arraylist = new ArrayList();
        if (aaccountmappingtype != null)
        {
            int j = aaccountmappingtype.length;
            int i = 0;
            while (i < j) 
            {
                com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype = aaccountmappingtype[i];
                AccountMappingLogic accountmappinglogic = constructMappingLogic(accountmappingtype);
                if (accountmappinglogic != null)
                {
                    if (!accountmappinglogic.isSupportedOnThisPlatform())
                    {
                        accountmappingtype.getAccountMappingType();
                    } else
                    {
                        arraylist.add(accountmappinglogic);
                    }
                }
                i++;
            }
        }
        return arraylist;
    }

    public static MultipleAccountsLogic getInstance(Context context)
    {
        com/amazon/identity/auth/accounts/MultipleAccountsLogic;
        JVM INSTR monitorenter ;
        if (sTheOneAndOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndOnly = new MultipleAccountsLogic(context.getApplicationContext());
        }
        context = sTheOneAndOnly;
        com/amazon/identity/auth/accounts/MultipleAccountsLogic;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private Set getPackagesToSendTo(String s, Set set)
    {
        if (s == null)
        {
            return set;
        } else
        {
            set = new HashSet();
            set.add(s);
            return set;
        }
    }

    private void notifyOnAccountChanged(List list)
    {
        if (list.size() != 0)
        {
            Set set1 = mTrustedPackageManager.getTrustedInstalledPackages();
            HashMap hashmap = new HashMap();
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                NotificationInfo notificationinfo = (NotificationInfo)iterator.next();
                if (notificationinfo.extras != null)
                {
                    list = new Intent(notificationinfo.action);
                    list.putExtras(notificationinfo.extras);
                    sendBroadcastToPackages(list, getPackagesToSendTo(notificationinfo.packageName, set1));
                } else
                {
                    Set set = (Set)hashmap.get(notificationinfo.action);
                    list = set;
                    if (set == null)
                    {
                        list = new HashSet();
                        hashmap.put(notificationinfo.action, list);
                    }
                    list.addAll(getPackagesToSendTo(notificationinfo.packageName, set1));
                }
            }

            list = hashmap.entrySet().iterator();
            while (list.hasNext()) 
            {
                Object obj = (java.util.Map.Entry)list.next();
                String s = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (Set)((java.util.Map.Entry) (obj)).getValue();
                sendBroadcastToPackages(new Intent(s), ((Set) (obj)));
            }
        }
    }

    private void sendBroadcastToPackages(Intent intent, Set set)
    {
        Intent intent1;
        for (set = set.iterator(); set.hasNext(); mContext.sendBroadcast(intent1, "com.amazon.dcp.sso.permission.account.changed"))
        {
            String s = (String)set.next();
            intent1 = new Intent(intent);
            intent1.setPackage(s);
        }

    }

    private void throwIfCannotWriteMultipleProfile()
    {
        if (mPlatform.isNewIdentiyMobilePlatformSSO() && !mPlatform.isRunningInCentralApk())
        {
            throw new IllegalStateException("getAccount write call cannot be called from this app on this platform");
        } else
        {
            return;
        }
    }

    private void upgradeToProfileImplementation()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mUpgradedToProfileImplementation;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s;
        ProfilePrimaryMappingLogic profileprimarymappinglogic;
label0:
        {
            mUpgradedToProfileImplementation = true;
            if (!mPlatform.shouldUseProfiles() || !mPlatform.isRunningInCentralApk())
            {
                continue; /* Loop/switch isn't completed */
            }
            s = mAmznAcctMan.getDevicePrimaryAmazonAccount();
            if (TextUtils.isEmpty(s))
            {
                continue; /* Loop/switch isn't completed */
            }
            profileprimarymappinglogic = new ProfilePrimaryMappingLogic(mContext, com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(0), mAmznAcctMan);
            Iterator iterator = mAmznAcctMan.getAccounts().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!profileprimarymappinglogic.isMappingCurrentlySetForAccount((String)iterator.next()));
            continue; /* Loop/switch isn't completed */
        }
        profileprimarymappinglogic.setAndNotify(s);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean doesAccountHaveMapping(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype)
    {
        AccountMappingLogic accountmappinglogic = constructMappingLogic(accountmappingtype);
        if (!accountmappinglogic.isSupportedOnThisPlatform())
        {
            MAPLog.formattedError(TAG, "Mapping Type %s is not supported on this platform. Ignoring", new Object[] {
                accountmappingtype.getAccountMappingType()
            });
            return false;
        } else
        {
            return accountmappinglogic.isMappingCurrentlySetForAccount(s);
        }
    }

    public transient String getAccountForMapping(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        if (!mPlatform.isRunningInCentralApk())
        {
            return calculateAccountForMapping(aaccountmappingtype);
        }
        List list;
        Value value;
        Value value1;
        if (aaccountmappingtype == null)
        {
            list = null;
        } else
        {
            list = Arrays.asList(aaccountmappingtype);
        }
        value1 = (Value)mAccountMappingsToAccountCache.get(list);
        value = value1;
        if (value1 == null)
        {
            value = new Value(calculateAccountForMapping(aaccountmappingtype));
            mAccountMappingsToAccountCache.put(list, value);
        }
        return (String)value.getValue();
    }

    public Set getListOfProfilesWhereTheAccountIsPrimary(ServiceWrappingContext servicewrappingcontext, String s)
    {
        s = MetadataMappingClass.getMetadataForAccount(new BackwardsCompatiableDataStorage(servicewrappingcontext), s, "com.amazon.dcp.sso.property.account.extratokens.account_profiles");
        servicewrappingcontext = new HashSet();
        for (s = s.iterator(); s.hasNext();)
        {
            String s1 = (String)s.next();
            try
            {
                servicewrappingcontext.add(Integer.valueOf(s1));
            }
            catch (NumberFormatException numberformatexception)
            {
                MAPLog.w(TAG, "Ignoring invalid profile id");
            }
        }

        return servicewrappingcontext;
    }

    public void invalidateCache()
    {
        mAccountMappingsToAccountCache.clear();
    }

    public boolean isAPrimaryAccount(String s)
    {
        if (!mAmznAcctMan.doesAccountExist(s))
        {
            MAPLog.e(TAG, "The account does not exist so it cannot be a primary");
        } else
        if (ProfilePrimaryMappingLogic.constructProfileMappingForAccount(mContext, mAmznAcctMan, s).size() != 0 || mAmznAcctMan.isDevicePrimaryAmazonAccount(s))
        {
            return true;
        }
        return false;
    }

    public void onDeregister(String s)
    {
        throwIfCannotWriteMultipleProfile();
        if (!mAmznAcctMan.doesAccountExist(s))
        {
            MAPLog.e(TAG, "Cannot remove all account mappings since the account doesn't exist");
            return;
        }
        Object obj = new ArrayList();
        Object obj1 = mContext;
        AmazonAccountManager amazonaccountmanager = mAmznAcctMan;
        ArrayList arraylist = new ArrayList();
        if (amazonaccountmanager.isSessionUserAmazonAccount(s))
        {
            arraylist.add(new SessionUserMappingLogic(((ServiceWrappingContext) (obj1)), amazonaccountmanager));
        }
        ((List) (obj)).addAll(arraylist);
        ((List) (obj)).addAll(ProfilePrimaryMappingLogic.constructProfileMappingForAccount(mContext, mAmznAcctMan, s));
        ((List) (obj)).addAll(PackageMappingLogic.constructPackageMappingsForAccount(mContext, mAmznAcctMan, s));
        ((List) (obj)).addAll(CustomKeyMappingLogic.constructCustomKeyMappingsForAccount(mContext, mAmznAcctMan, s));
        invalidateCache();
        obj1 = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((List) (obj1)).addAll(((AccountMappingLogic)((Iterator) (obj)).next()).onDeregister(s))) { }
        notifyOnAccountChanged(((List) (obj1)));
    }

    public transient boolean removeAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        throwIfCannotWriteMultipleProfile();
        Object obj = filterOutInvalidMappingsAndCreateMapplingLogic(aaccountmappingtype);
        if (!mAmznAcctMan.doesAccountExist(s))
        {
            MAPLog.e(TAG, "Cannot remove account mappings since it doesn't exist");
        } else
        {
            invalidateCache();
            aaccountmappingtype = new ArrayList();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); aaccountmappingtype.addAll(((AccountMappingLogic)((Iterator) (obj)).next()).removeAndNotify(s))) { }
            notifyOnAccountChanged(aaccountmappingtype);
            if (aaccountmappingtype.size() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public transient boolean setAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[])
    {
        throwIfCannotWriteMultipleProfile();
        Object obj = filterOutInvalidMappingsAndCreateMapplingLogic(aaccountmappingtype);
        if (!mAmznAcctMan.doesAccountExist(s) || mAmznAcctMan.isAccountDeregistering(s))
        {
            MAPLog.e(TAG, "Cannot set account mappings since it doesn't exist or is deregistering");
        } else
        {
            invalidateCache();
            aaccountmappingtype = new ArrayList();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); aaccountmappingtype.addAll(((AccountMappingLogic)((Iterator) (obj)).next()).setAndNotify(s))) { }
            notifyOnAccountChanged(aaccountmappingtype);
            if (aaccountmappingtype.size() > 0)
            {
                return true;
            }
        }
        return false;
    }


}
