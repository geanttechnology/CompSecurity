// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


// Referenced classes of package com.amazon.identity.auth.device.framework:
//            PregeneratedKeyPairStorage

public static final class mFormat
{

    public static final String ALGO = "algo";
    public static final String ENCODED_PRIV_KEY = "encoded_priv_key";
    public static final String ENCODED_PUB_KEY = "encoded_pub_key";
    public static final String FORMAT = "format";
    private final String mAlgo;
    private final String mEncodedPrivateKey;
    private final String mEncodedPublicKey;
    private final String mFormat;

    public String getAlgo()
    {
        return mAlgo;
    }

    public String getEncodedPrivateKey()
    {
        return mEncodedPrivateKey;
    }

    public String getEncodedPublicKey()
    {
        return mEncodedPublicKey;
    }

    public String getFormat()
    {
        return mFormat;
    }

    public (String s, String s1, String s2, String s3)
    {
        mAlgo = s;
        mEncodedPublicKey = s1;
        mEncodedPrivateKey = s2;
        mFormat = s3;
    }
}
