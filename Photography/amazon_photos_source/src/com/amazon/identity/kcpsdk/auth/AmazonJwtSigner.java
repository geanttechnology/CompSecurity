// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.util.Base64;
import com.amazon.identity.auth.device.framework.AmazonKeyStoreCaller;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
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
//            JwtSigner, AmazonJWTHelper

public final class AmazonJwtSigner extends JwtSigner
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/AmazonJwtSigner.getName();
    private final Object mAmazonKeyStore;
    private final String mExponent;
    private final String mHMAC;
    private final String mModulus;

    public AmazonJwtSigner(Object obj)
    {
        byte abyte2[];
        mAmazonKeyStore = obj;
        try
        {
            abyte2 = (byte[])mAmazonKeyStore.getClass().getMethod("getPubkey", new Class[0]).invoke(mAmazonKeyStore, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            AmazonJWTHelper.recordErrorMetric(obj.getClass().getSimpleName());
            throw new UnsupportedOperationException(((Throwable) (obj)));
        }
        if (abyte2 == null)
        {
            AmazonJWTHelper.recordErrorMetric("NoKeyAvailable");
            throw new UnsupportedOperationException("AmazonKeyStore returned null public key");
        }
        RSAPublicKey rsapublickey;
        int i;
        obj = new X509EncodedKeySpec(abyte2);
        rsapublickey = (RSAPublicKey)KeyFactoryUtils.getKeyFactoryForAlgorithm("RSA").generatePublic(((java.security.spec.KeySpec) (obj)));
        obj = rsapublickey.getModulus().toByteArray();
        i = obj.length;
        if (i != 256) goto _L2; else goto _L1
_L2:
        byte abyte1[] = new byte[256];
        if (obj[0] != 0) goto _L4; else goto _L3
_L3:
        System.arraycopy(obj, 1, abyte1, (256 - i) + 1, i - 1);
          goto _L5
_L4:
        System.arraycopy(obj, 0, abyte1, 256 - i, i);
          goto _L5
_L1:
        try
        {
            byte abyte0[] = new byte[32];
            System.arraycopy(abyte2, abyte2.length - 32, abyte0, 0, 32);
            mHMAC = Base64.encodeToString(abyte0, 10);
            mModulus = Base64.encodeToString(((byte []) (obj)), 10);
            mExponent = rsapublickey.getPublicExponent().toString();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            AmazonJWTHelper.recordErrorMetric(obj.getClass().getSimpleName());
        }
        throw new UnsupportedOperationException(((Throwable) (obj)));
_L5:
        obj = abyte1;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public static AmazonJwtSigner getInstanceIfAvailable(Tracer tracer)
    {
        tracer = ((Tracer) (AmazonKeyStoreCaller.getAmzonKeyStoreInstance(tracer)));
        if (tracer == null)
        {
            tracer = TAG;
            AmazonJWTHelper.recordErrorMetric("NoKeyStore");
            return null;
        }
        try
        {
            tracer = new AmazonJwtSigner(tracer);
        }
        // Misplaced declaration of an exception variable
        catch (Tracer tracer)
        {
            MAPLog.w(TAG, "Failed to construct AmazonJwtSigner", tracer);
            return null;
        }
        return tracer;
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

    void printJwt(String s)
    {
        String s1 = TAG;
        (new StringBuilder("The TrustZone JWT is ")).append(s).toString();
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
