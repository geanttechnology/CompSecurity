// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.util.Base64;
import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public abstract class ITokenAuthProvider
{

    public static final String SHA256_WITH_ECDSA = "SHA256withECDSA";
    public static final String SHA256_WITH_RSA = "SHA256WithRSA";
    private static final String TAG = com/amazon/identity/kcpsdk/auth/ITokenAuthProvider.getName();
    private final Object mLock[] = new Object[0];
    private PrivateKey mParsedPrivateKey;
    private String mSignAlgo;

    public ITokenAuthProvider()
    {
    }

    private PrivateKey parseKey(String s)
    {
        KeyFactory keyfactory;
        if (s != null)
        {
            if ((keyfactory = KeyFactoryUtils.getKeyFactoryForKey(s)) != null)
            {
                try
                {
                    s = keyfactory.generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(KeyFactoryUtils.replacePrivateKeyHeaderAndFooter(s), 0)));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    MAPLog.e(TAG, (new StringBuilder("parseKey: Could not parse private key because it was invalid. Error: ")).append(s.getMessage()).toString());
                    return null;
                }
                return s;
            }
        }
        return null;
    }

    public PrivateKey getParsedPrivateKey()
    {
        PrivateKey privatekey;
        synchronized (mLock)
        {
            if (mParsedPrivateKey == null)
            {
                mParsedPrivateKey = parseKey(getPrivateKey());
            }
            privatekey = mParsedPrivateKey;
        }
        return privatekey;
    }

    public abstract String getPrivateKey();

    public String getSignAlgo()
    {
        if (mSignAlgo != null)
        {
            return mSignAlgo;
        }
        String s = getPrivateKey();
        if (s == null)
        {
            mSignAlgo = null;
        } else
        if (s.contains("-----BEGIN EC PRIVATE KEY-----"))
        {
            mSignAlgo = "SHA256withECDSA";
        } else
        {
            mSignAlgo = "SHA256WithRSA";
        }
        return mSignAlgo;
    }

    public abstract String getToken();

}
