// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Sequence, ASN1EncodableVector, DEROutputStream, DEREncodable, 
//            ASN1Encodable

public class DERSequence extends ASN1Sequence
{

    public DERSequence()
    {
    }

    public DERSequence(ASN1EncodableVector asn1encodablevector)
    {
        for (int i = 0; i != asn1encodablevector.size(); i++)
        {
            addObject(asn1encodablevector.get(i));
        }

    }

    public DERSequence(DEREncodable derencodable)
    {
        addObject(derencodable);
    }

    public DERSequence(ASN1Encodable aasn1encodable[])
    {
        for (int i = 0; i != aasn1encodable.length; i++)
        {
            addObject(aasn1encodable[i]);
        }

    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DEROutputStream deroutputstream1 = new DEROutputStream(bytearrayoutputstream);
        for (Enumeration enumeration = getObjects(); enumeration.hasMoreElements(); deroutputstream1.writeObject(enumeration.nextElement())) { }
        deroutputstream1.close();
        deroutputstream.writeEncoded(48, bytearrayoutputstream.toByteArray());
    }
}
