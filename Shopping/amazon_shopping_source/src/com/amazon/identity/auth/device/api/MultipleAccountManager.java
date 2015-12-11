// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.MultipleAccountsCommunication;
import com.amazon.identity.auth.device.framework.AndroidUser;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit

public final class MultipleAccountManager
{
    public static abstract class AccountMappingType
    {

        private final String mType;
        private final String mValue;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (AccountMappingType)obj;
                if (!TextUtils.equals(mType, ((AccountMappingType) (obj)).mType) || !TextUtils.equals(mValue, ((AccountMappingType) (obj)).mValue))
                {
                    return false;
                }
            }
            return true;
        }

        public String getAccountMappingType()
        {
            return mType;
        }

        public String getAccountMappingValue()
        {
            return mValue;
        }

        public int hashCode()
        {
            int j = 0;
            int i;
            if (mType == null)
            {
                i = 0;
            } else
            {
                i = mType.hashCode();
            }
            if (mValue != null)
            {
                j = mValue.hashCode();
            }
            return (i + 31) * 31 + j;
        }

        AccountMappingType(String s, String s1)
        {
            mType = s;
            mValue = s1;
        }
    }

    public static class CustomKeyMappingType extends AccountMappingType
    {

        public static boolean isSupportedOnThisPlatform(Context context)
        {
            return ((PlatformWrapper)ServiceWrappingContext.create(context).getSystemService("sso_platform")).isFullMAPR5();
        }

        public CustomKeyMappingType(String s)
        {
            super("com.amazon.dcp.sso.property.account.extratokens.custom_keys", s);
        }
    }

    public static class PackageMappingType extends AccountMappingType
    {

        public static PackageMappingType createCurrentPackageMapping(Context context)
        {
            return new PackageMappingType(context.getPackageName());
        }

        public static boolean isSupportedOnThisPlatform(Context context)
        {
            return ((PlatformWrapper)ServiceWrappingContext.create(context).getSystemService("sso_platform")).isFullMAPR5();
        }

        public PackageMappingType(String s)
        {
            super("com.amazon.dcp.sso.property.account.extratokens.account_packages", s);
        }
    }

    public static class PrimaryUserMappingType extends AccountMappingType
    {

        public static PrimaryUserMappingType createPrimaryMappingForProfile(int i)
        {
            return new PrimaryUserMappingType(i);
        }

        public static boolean isSupportedOnThisPlatform(Context context)
        {
            return true;
        }

        public PrimaryUserMappingType()
        {
            this(AndroidUser.getMyUserId());
        }

        private PrimaryUserMappingType(int i)
        {
            super("com.amazon.dcp.sso.property.account.extratokens.account_profiles", Integer.toString(i));
        }

    }

    public static class ProfileMappingType extends PrimaryUserMappingType
    {

        public static ProfileMappingType createCurrentProfile(Context context)
        {
            return new ProfileMappingType(0);
        }

        public static ProfileMappingType createCurrentViewableProfile(Context context)
        {
            return new ProfileMappingType(0);
        }

        public static boolean isSupportedOnThisPlatform(Context context)
        {
            MAPLog.e(MultipleAccountManager.TAG, "ProfileMappingType is deprecated. Please use PrimaryUserMappingType instead");
            return false;
        }

        public ProfileMappingType(int i)
        {
            super(i);
        }
    }

    public static class SessionUserMappingType extends AccountMappingType
    {

        public static boolean isSupportedOnThisPlatform(Context context)
        {
            context = (PlatformWrapper)ServiceWrappingContext.create(context).getSystemService("sso_platform");
            return context.isFullMAPR5() || context.unSecureCheckHasServiceWithAction("com.amazon.dcp.sso.action.central.session.user.change");
        }

        public SessionUserMappingType()
        {
            super("com.amazon.dcp.sso.property.sessionuser", "true");
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/api/MultipleAccountManager.getName();
    private final Context mContext;
    private final MultipleAccountsCommunication mMultipleAccountsCommunication;

    public MultipleAccountManager(Context context)
    {
        MAPInit.getInstance(context).initialize();
        mContext = ServiceWrappingContext.create(context);
        mMultipleAccountsCommunication = new MultipleAccountsCommunication(mContext);
    }

    public boolean doesAccountHaveMapping(String s, AccountMappingType accountmappingtype)
    {
        return mMultipleAccountsCommunication.doesAccountHaveMapping(s, accountmappingtype);
    }

    public transient String getAccountForMapping(AccountMappingType aaccountmappingtype[])
    {
        return mMultipleAccountsCommunication.getAccountForMapping(aaccountmappingtype);
    }

    public transient boolean removeAccountMappings(String s, AccountMappingType aaccountmappingtype[])
    {
        return mMultipleAccountsCommunication.removeAccountMappings(s, aaccountmappingtype);
    }

    public transient boolean setAccountMappings(String s, AccountMappingType aaccountmappingtype[])
    {
        return mMultipleAccountsCommunication.setAccountMappings(s, aaccountmappingtype);
    }


}
