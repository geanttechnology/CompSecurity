// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;


// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERObjectIdentifier

public class ASN1ObjectIdentifier extends DERObjectIdentifier
{

    public ASN1ObjectIdentifier(String s)
    {
        super(s);
    }

    ASN1ObjectIdentifier(byte abyte0[])
    {
        super(abyte0);
    }

    public ASN1ObjectIdentifier branch(String s)
    {
        return new ASN1ObjectIdentifier((new StringBuilder()).append(getId()).append(".").append(s).toString());
    }
}
