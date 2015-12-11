// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.GenericIPCSender;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.auth.device.framework.Value;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            VersionUtils, MAPLog

public final class CentralApkUtils
{
    public static final class CentralApkDescription
    {

        public final String mPackageName;
        public final Integer mVersion;

        public CentralApkDescription(String s, Integer integer)
        {
            mPackageName = s;
            mVersion = integer;
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/utils/CentralApkUtils.getName();
    private static AtomicReference sCentralApkInfo = new AtomicReference(null);

    private CentralApkUtils()
    {
    }

    public static CentralApkDescription getCentralApkInfo(Context context)
    {
        if (sCentralApkInfo.get() == null)
        {
            ProviderInfo providerinfo = (new TrustedPackageManager(context)).getAmazonOwnedContentProvider(GenericIPCSender.GENERIC_IPC_URI, 0);
            if (providerinfo != null)
            {
                context = VersionUtils.getAmazonPackageVersion(context, providerinfo.packageName);
                MAPLog.i(TAG, String.format("Retrieved central APK info from package manager using content provider %s. The package name is : %s and version is: %d.", new Object[] {
                    GenericIPCSender.GENERIC_IPC_URI, providerinfo.packageName, context
                }));
                sCentralApkInfo.compareAndSet(null, new Value(new CentralApkDescription(providerinfo.packageName, context)));
            } else
            {
                Object obj = retriveSSOAuthenticatorInfo(context);
                if (obj != null)
                {
                    obj = ((AuthenticatorDescription) (obj)).packageName;
                    context = VersionUtils.getAmazonPackageVersion(context, ((String) (obj)));
                    MAPLog.i(TAG, String.format("Retrieved central APK info from account manager using account authenticator. The package name is: %s and version is: %d.", new Object[] {
                        obj, context
                    }));
                    sCentralApkInfo.compareAndSet(null, new Value(new CentralApkDescription(((String) (obj)), context)));
                } else
                {
                    MAPLog.i(TAG, "No central apk detected. This should be a 3P device.");
                    sCentralApkInfo.compareAndSet(null, new Value(null));
                }
            }
        }
        return (CentralApkDescription)((Value)sCentralApkInfo.get()).getValue();
    }

    public static boolean hasCentralAPK(Context context)
    {
        return getCentralApkInfo(context) != null;
    }

    public static boolean isAmazonAuthenticatorPresent(Context context)
    {
        return retriveSSOAuthenticatorInfo(context) != null;
    }

    private static boolean isCurrentPackageTheCentral(Context context, CentralApkDescription centralapkdescription)
    {
        context = context.getPackageName();
        centralapkdescription = centralapkdescription.mPackageName;
        boolean flag = TextUtils.equals(context, centralapkdescription);
        if (!flag)
        {
            String s = TAG;
            String.format("Current package: %s and Authenticator owner's package: %s are different", new Object[] {
                context, centralapkdescription
            });
        }
        return flag;
    }

    public static boolean isRunningInCentralAPK(Context context)
    {
        CentralApkDescription centralapkdescription = getCentralApkInfo(context);
        if (centralapkdescription == null)
        {
            MAPLog.i(TAG, "Cannot find amazon authenticator. If this is 1P device, this is a bug!");
            return false;
        } else
        {
            return isCurrentPackageTheCentral(context, centralapkdescription);
        }
    }

    public static boolean isRunningInCentralApkOrNoCentral(Context context)
    {
        CentralApkDescription centralapkdescription = getCentralApkInfo(context);
        if (centralapkdescription == null)
        {
            return true;
        } else
        {
            return isCurrentPackageTheCentral(context, centralapkdescription);
        }
    }

    private static AuthenticatorDescription retriveSSOAuthenticatorInfo(Context context)
    {
        AuthenticatorDescription aauthenticatordescription[] = AccountManager.get(context).getAuthenticatorTypes();
        int j = aauthenticatordescription.length;
        AuthenticatorDescription authenticatordescription;
        boolean flag;
        for (int i = 0; i < j; i++)
        {
            authenticatordescription = aauthenticatordescription[i];
            if (!"com.amazon.account".equals(authenticatordescription.type))
            {
                flag = false;
            } else
            if (!(new TrustedPackageManager(context)).isTrustedPackage(authenticatordescription.packageName))
            {
                MAPLog.e(TAG, (new StringBuilder("Account Manager account type match but central package signature check failed! This probably means someone is squatting or a platform bug in the signature check. The account authenticator's package name is: ")).append(authenticatordescription.packageName).toString());
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                MAPLog.i(TAG, String.format("SSO was found in package %s", new Object[] {
                    authenticatordescription.packageName
                }));
                return authenticatordescription;
            }
        }

        MAPLog.i(TAG, "Cannot find amazon authenticator. returning null");
        return null;
    }

}
