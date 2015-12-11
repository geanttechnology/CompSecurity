// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERSequence, ASN1OutputStream, BEROutputStream, DEROutputStream, 
//            ASN1EncodableVector, DEREncodable

public class BERSequence extends DERSequence
{

    public BERSequence()
    {
    }

    public BERSequence(ASN1EncodableVector asn1encodablevector)
    {
        super(asn1encodablevector);
    }

    public BERSequence(DEREncodable derencodable)
    {
        super(derencodable);
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        if ((deroutputstream instanceof ASN1OutputStream) || (deroutputstream instanceof BEROutputStream))
        {
            deroutputstream.write(48);
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
