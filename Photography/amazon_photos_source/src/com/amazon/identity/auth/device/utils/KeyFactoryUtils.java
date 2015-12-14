// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.util.PlatformUtils;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog, Platform

public final class KeyFactoryUtils
{

    private static final String KEY_HEADERS_FOOTERS[] = {
        "-----BEGIN RSA PRIVATE KEY-----", "-----END RSA PRIVATE KEY-----", "-----BEGIN EC PRIVATE KEY-----", "-----END EC PRIVATE KEY-----", "-----BEGIN PRIVATE KEY-----", "-----END PRIVATE KEY-----"
    };
    private static final String TAG = com/amazon/identity/auth/device/utils/KeyFactoryUtils.getName();

    private KeyFactoryUtils()
    {
    }

    public static KeyFactory getKeyFactoryForAlgorithm(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            MAPLog.e(TAG, "The algorithm cannot be null");
            throw new IllegalArgumentException("The algorithm cannot be null");
        }
        KeyFactory keyfactory = KeyFactory.getInstance(s, "BC");
        return keyfactory;
        Object obj;
        obj;
        MAPLog.e(TAG, (new StringBuilder("getKeyFactory: Could not get private key because there was no ")).append(s).append(" algorithm").toString(), ((Throwable) (obj)));
        MetricsHelper.incrementCounter((new StringBuilder("MAPKeyFactoryGenerationError:BouncyCastleMissing:Algorithm:")).append(s).append(":SystemVersion:").append(android.os.Build.VERSION.SDK_INT).toString(), new String[0]);
_L2:
        return null;
        obj;
        MAPLog.e(TAG, "The device doesn't contain BouncyCastle Provider, try using the default.", ((Throwable) (obj)));
        MetricsHelper.incrementCounter((new StringBuilder("MAPKeyFactoryGenerationError:MissingBouncyCastle:Algorithm:")).append(s).append(":SystemVersion:").append(android.os.Build.VERSION.SDK_INT).toString(), new String[0]);
        obj = KeyFactory.getInstance(s);
        return ((KeyFactory) (obj));
        obj;
        MAPLog.e(TAG, "getKeyFactory: Could not get private key because there was no RSA algorithm", ((Throwable) (obj)));
        MetricsHelper.incrementCounter((new StringBuilder("MAPKeyFactoryGenerationError:DefaultProviderNotSupportAlgorithm:Algorithm:")).append(s).append(":SystemVersion:").append(android.os.Build.VERSION.SDK_INT).toString(), new String[0]);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static PrivateKey getPrivateKey(String s)
        throws InvalidKeySpecException
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        KeyFactory keyfactory = getKeyFactoryForAlgorithm("RSA");
        if (keyfactory == null)
        {
            MAPLog.w(TAG, "Failed to create keyFactory for the input key");
            return null;
        }
        Object obj = TAG;
        (new StringBuilder("Key Factory created using the algorithm as ")).append(keyfactory.getAlgorithm()).toString();
        obj = new PKCS8EncodedKeySpec(Base64.decode(replacePrivateKeyHeaderAndFooter(s).getBytes(), 0));
        try
        {
            s = keyfactory.generatePrivate(((java.security.spec.KeySpec) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            String s1 = TAG;
            try
            {
                obj = getKeyFactoryForAlgorithm("EC").generatePrivate(((java.security.spec.KeySpec) (obj)));
            }
            catch (InvalidKeySpecException invalidkeyspecexception)
            {
                MAPLog.e(TAG, (new StringBuilder("Failed to create private key using the original algo: ")).append(keyfactory.getAlgorithm()).toString(), s);
                MAPLog.e(TAG, "Failed to create private key when retried using algo: EC", invalidkeyspecexception);
                throw s;
            }
            return ((PrivateKey) (obj));
        }
        return s;
    }

    public static void recordDMSCredentialErrorAndCallDeregisterIfNecessary(Context context, String s)
    {
        boolean flag;
        if (TextUtils.equals(s, "SSO Currently does not have credentials"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && !PlatformUtils.isAmazonDevice(context))
        {
            s = Platform.getDeviceAttribute(context, DeviceAttribute.CentralDeviceType);
            MAPLog.e(TAG, "Central DMS token or DMS private key get corrupted, MAP is going to deregister device to clean the state");
            MetricsHelper.incrementCounter((new StringBuilder("DMSCredentialCorrupted:DeviceType:")).append(s).append(":SYSTEM_VERSION:").append(android.os.Build.VERSION.SDK_INT).toString(), new String[0]);
            context = new MAPAccountManager(context);
            try
            {
                context.deregisterDevice(null).get();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = context.getErrorBundle();
                MAPLog.e(TAG, (new StringBuilder("Error deregister the device when DMS private-key/DMS token got corrupted or missing. Error code:")).append(context.getInt("com.amazon.dcp.sso.ErrorCode")).append(" Error message is:").append(context.getString("com.amazon.dcp.sso.ErrorMessage")).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MAPLog.e(TAG, "InterruptedException! Error deregister the device when DMS private-key/DMS token got corrupted or missing. ", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MAPLog.e(TAG, "ExecutionException! Error deregister the device when DMS private-key/DMS token got corrupted or missing.", context);
            }
            MAPLog.i(TAG, "Successfully deregister the device when DMS private-key/DMS token got corrupted or missing.");
        }
    }

    public static String replacePrivateKeyHeaderAndFooter(String s)
    {
        if (s == null)
        {
            return null;
        }
        String as[] = KEY_HEADERS_FOOTERS;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            s = s.replace(as[i], "");
        }

        return s.trim();
    }

}
