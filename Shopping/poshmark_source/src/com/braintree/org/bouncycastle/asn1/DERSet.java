// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Set, ASN1EncodableVector, DEROutputStream, DEREncodable, 
//            ASN1Encodable

public class DERSet extends ASN1Set
{

    public DERSet()
    {
    }

    public DERSet(ASN1EncodableVector asn1encodablevector)
    {
        this(asn1encodablevector, true);
    }

    DERSet(ASN1EncodableVector asn1encodablevector, boolean flag)
    {
        for (int i = 0; i != asn1encodablevector.size(); i++)
        {
            addObject(asn1encodablevector.get(i));
        }

        if (flag)
        {
            sort();
        }
    }

    public DERSet(DEREncodable derencodable)
    {
        addObject(derencodable);
    }

    public DERSet(ASN1Encodable aasn1encodable[])
    {
        for (int i = 0; i != aasn1encodable.length; i++)
        {
            addObject(aasn1encodable[i]);
        }

        sort();
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DEROutputStream deroutputstream1 = new DEROutputStream(bytearrayoutputstream);
        for (Enumeration enumeration = getObjects(); enumeration.hasMoreElements(); deroutputstream1.writeObject(enumeration.nextElement())) { }
        deroutputstream1.close();
        deroutputstream.writeEncoded(49, bytearrayoutputstream.toByteArray());
    }
}
