// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.bouncycastle.jcajce.provider.digest:
//            DigestAlgorithmProvider, MD5

public class rovider extends DigestAlgorithmProvider
{

    private static final String PREFIX = org/bouncycastle/jcajce/provider/digest/MD5.getName();

    public void configure(ConfigurableProvider configurableprovider)
    {
        configurableprovider.addAlgorithm("MessageDigest.MD5", (new StringBuilder()).append(PREFIX).append("$Digest").toString());
        configurableprovider.addAlgorithm((new StringBuilder()).append("Alg.Alias.MessageDigest.").append(PKCSObjectIdentifiers.md5).toString(), "MD5");
        addHMACAlgorithm(configurableprovider, "MD5", (new StringBuilder()).append(PREFIX).append("$HashMac").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        addHMACAlias(configurableprovider, "MD5", IANAObjectIdentifiers.hmacMD5);
    }


    public rovider()
    {
    }
}
