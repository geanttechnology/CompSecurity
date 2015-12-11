// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1OctetString, DEROutputStream, DEREncodable

public class DEROctetString extends ASN1OctetString
{

    public DEROctetString(DEREncodable derencodable)
    {
        super(derencodable);
    }

    public DEROctetString(byte abyte0[])
    {
        super(abyte0);
    }

    static void encode(DEROutputStream deroutputstream, byte abyte0[])
        throws IOException
    {
        deroutputstream.writeEncoded(4, abyte0);
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(4, string);
    }
}
