// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERSet, ASN1OutputStream, BEROutputStream, DEROutputStream, 
//            ASN1EncodableVector, DEREncodable

public class BERSet extends DERSet
{

    public BERSet()
    {
    }

    public BERSet(ASN1EncodableVector asn1encodablevector)
    {
        super(asn1encodablevector, false);
    }

    BERSet(ASN1EncodableVector asn1encodablevector, boolean flag)
    {
        super(asn1encodablevector, flag);
    }

    public BERSet(DEREncodable derencodable)
    {
        super(derencodable);
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        if ((deroutputstream instanceof ASN1OutputStream) || (deroutputstream instanceof BEROutputStream))
        {
            deroutputstream.write(49);
            deroutputstream.write(128);
            for (Enumeration enumeration = getObjects(); enumeration.hasMoreElements(); deroutputstream.writeObject(enumeration.nextElement())) { }
            deroutputstream.write(0);
            deroutputstream.write(0);
            return;
        } else
        {
            super.encode(deroutputstream);
            return;
        }
    }
}
