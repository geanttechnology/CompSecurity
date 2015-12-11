// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Null, DEROutputStream

public class DERNull extends ASN1Null
{

    public static final DERNull INSTANCE = new DERNull();
    byte zeroBytes[];

    public DERNull()
    {
        zeroBytes = new byte[0];
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(5, zeroBytes);
    }

}
