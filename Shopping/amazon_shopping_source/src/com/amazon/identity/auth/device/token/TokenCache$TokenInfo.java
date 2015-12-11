// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenCache

private class mDecryptedToken
{

    private String mDecryptedToken;
    private String mEncryptedToken;
    private PrivateKey mRSAPrivateKey;
    final TokenCache this$0;

    public String getDecryptedToken()
    {
        return mDecryptedToken;
    }

    public String getEncryptedToken()
    {
        return mEncryptedToken;
    }

    public PrivateKey getTokenAsRSAPrivateKey()
        throws InvalidKeySpecException
    {
        if (mRSAPrivateKey == null)
        {
            mRSAPrivateKey = parseRSAPrivateKey(mDecryptedToken);
        }
        return mRSAPrivateKey;
    }

    public (String s)
    {
        this(s, decryptToken(s));
    }

    public en(String s, String s1)
    {
        this$0 = TokenCache.this;
        super();
        mEncryptedToken = s;
        mDecryptedToken = s1;
    }
}
