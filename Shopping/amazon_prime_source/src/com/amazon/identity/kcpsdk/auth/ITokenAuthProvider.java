// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

public abstract class ITokenAuthProvider
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/ITokenAuthProvider.getName();
    private final Object mLock[] = new Object[0];
    private PrivateKey mParsedPrivateKey;
    private String mSignAlgo;

    public ITokenAuthProvider()
    {
    }

    public PrivateKey getParsedPrivateKey()
    {
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        PrivateKey privatekey = mParsedPrivateKey;
        if (privatekey != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        mParsedPrivateKey = KeyFactoryUtils.getPrivateKey(getPrivateKey());
_L1:
        privatekey = mParsedPrivateKey;
        aobj;
        JVM INSTR monitorexit ;
        return privatekey;
        Object obj;
        obj;
        MAPLog.e(TAG, (new StringBuilder("parseKey: Could not parse private key because it was invalid. Error: ")).append(((InvalidKeySpecException) (obj)).getMessage()).toString());
          goto _L1
        obj;
        aobj;
        JVM INSTR monitorexit ;
        throw obj;
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
