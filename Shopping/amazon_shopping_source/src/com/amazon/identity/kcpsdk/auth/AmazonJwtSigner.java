// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            JwtSigner, AmazonJWTHelper, HmacJwtSigner

public final class AmazonJwtSigner extends JwtSigner
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/AmazonJwtSigner.getName();
    private final Object mAmazonKeyStore;
    private final String mExponent;
    private final String mHMAC;
    private final String mModulus;

    public AmazonJwtSigner(Object obj)
    {
        mAmazonKeyStore = obj;
        try
        {
            obj = (byte[])mAmazonKeyStore.getClass().getMethod("getPubkey", new Class[0]).invoke(mAmazonKeyStore, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            AmazonJWTHelper.recordErrorMetric(obj.getClass().getSimpleName());
            throw new UnsupportedOperationException(((Throwable) (obj)));
        }
        if (obj == null)
        {
            AmazonJWTHelper.recordErrorMetric("NoKeyAvailable");
            throw new UnsupportedOperationException("AmazonKeyStore returned null public key");
        }
        try
        {
            Object obj1 = new X509EncodedKeySpec(((byte []) (obj)));
            obj1 = (RSAPublicKey)KeyFactoryUtils.getKeyFactoryForAlgorithm("RSA").generatePublic(((java.security.spec.KeySpec) (obj1)));
            byte abyte0[] = integerToOctetString(((RSAPublicKey) (obj1)).getModulus());
            byte abyte1[] = new byte[32];
            System.arraycopy(obj, obj.length - 32, abyte1, 0, 32);
            mHMAC = Base64.encodeToString(abyte1, 10);
            mModulus = Base64.encodeToString(abyte0, 10);
            mExponent = ((RSAPublicKey) (obj1)).getPublicExponent().toString();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            AmazonJWTHelper.recordErrorMetric(obj.getClass().getSimpleName());
        }
        throw new UnsupportedOperationException(((Throwable) (obj)));
    }

    public static AmazonJwtSigner getInstanceIfAvailable()
    {
        Object obj;
        try
        {
            obj = Class.forName("amazon.security.AmazonKeyStore");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = TAG;
            return null;
        }
        try
        {
            obj = ((Class) (obj)).getMethod("getAmznInstance", new Class[0]).invoke(null, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            AmazonJWTHelper.recordErrorMetric(obj.getClass().getSimpleName());
            MAPLog.w(TAG, "Error getting AmazonKeyStore", ((Throwable) (obj)));
            return null;
        }
        if (obj == null)
        {
            obj = TAG;
            AmazonJWTHelper.recordErrorMetric("NoKeyStore");
            return null;
        }
        try
        {
            obj = new AmazonJwtSigner(obj);
        }
        catch (Exception exception)
        {
            MAPLog.w(TAG, "Failed to construct AmazonJwtSigner", exception);
            return null;
        }
        return ((AmazonJwtSigner) (obj));
    }

    public static JwtSigner getSigner(PlatformSettings platformsettings, SSODeviceInfo ssodeviceinfo, Tracer tracer)
    {
        String s = platformsettings.getSettingString("jwt_impl", "ds");
        platformsettings = TAG;
        (new StringBuilder("Found jwt_impl=")).append(s).toString();
        platformsettings = null;
        if ("tz".equals(s))
        {
            AmazonJwtSigner amazonjwtsigner = getInstanceIfAvailable();
            platformsettings = amazonjwtsigner;
            if (amazonjwtsigner != null)
            {
                platformsettings = amazonjwtsigner;
                if (tracer != null)
                {
                    tracer.incrementCounter("JWT:TrustZone");
                    platformsettings = amazonjwtsigner;
                }
            }
        }
        PlatformSettings platformsettings1 = platformsettings;
        if (platformsettings == null)
        {
            platformsettings1 = platformsettings;
            if (!"off".equals(s))
            {
                ssodeviceinfo = ssodeviceinfo.getDeviceSecret();
                platformsettings1 = platformsettings;
                if (!TextUtils.isEmpty(ssodeviceinfo))
                {
                    platformsettings = new HmacJwtSigner(ssodeviceinfo);
                    platformsettings1 = platformsettings;
                    if (tracer != null)
                    {
                        tracer.incrementCounter("JWT:HMAC");
                        platformsettings1 = platformsettings;
                    }
                }
            }
        }
        return platformsettings1;
    }

    static byte[] integerToOctetString(BigInteger biginteger)
    {
        biginteger = biginteger.toByteArray();
        int i = biginteger.length;
        if (i == 256)
        {
            return biginteger;
        }
        byte abyte0[] = new byte[256];
        if (biginteger[0] == 0)
        {
            System.arraycopy(biginteger, 1, abyte0, (256 - i) + 1, i - 1);
        } else
        {
            System.arraycopy(biginteger, 0, abyte0, 256 - i, i);
        }
        return abyte0;
    }

    void addHeaderFields(JSONObject jsonobject)
        throws JSONException
    {
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("kty", "RSA");
        jsonobject1.put("n", mModulus);
        jsonobject1.put("e", mExponent);
        jsonobject1.put("mac", mHMAC);
        jsonobject.put("alg", "PS256");
        jsonobject.put("jwk", jsonobject1);
    }

    byte[] sign(byte abyte0[])
    {
        try
        {
            abyte0 = MessageDigest.getInstance("SHA-256").digest(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new UnsupportedOperationException(abyte0);
        }
        try
        {
            abyte0 = (byte[])mAmazonKeyStore.getClass().getMethod("sign", new Class[] {
                [B
            }).invoke(mAmazonKeyStore, new Object[] {
                abyte0
            });
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            AmazonJWTHelper.recordErrorMetric(abyte0.getClass().getSimpleName());
            throw new UnsupportedOperationException(abyte0);
        }
        if (abyte0 == null)
        {
            AmazonJWTHelper.recordErrorMetric("NullSignature");
            throw new UnsupportedOperationException("AmazonKeyStore returned null signature");
        } else
        {
            return abyte0;
        }
    }

}
