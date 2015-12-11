// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERTaggedObject, BERSequence, ASN1OutputStream, BEROutputStream, 
//            DEROutputStream, ASN1OctetString, BERConstructedOctetString, ASN1Sequence, 
//            ASN1Set, DEREncodable

public class BERTaggedObject extends DERTaggedObject
{

    public BERTaggedObject(int i)
    {
        super(false, i, new BERSequence());
    }

    public BERTaggedObject(int i, DEREncodable derencodable)
    {
        super(i, derencodable);
    }

    public BERTaggedObject(boolean flag, int i, DEREncodable derencodable)
    {
        super(flag, i, derencodable);
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        if ((deroutputstream instanceof ASN1OutputStream) || (deroutputstream instanceof BEROutputStream))
        {
            deroutputstream.writeTag(160, tagNo);
            deroutputstream.write(128);
            if (!empty)
            {
                if (!explicit)
                {
                    Enumeration enumeration;
                    if (obj instanceof ASN1OctetString)
                    {
                        if (obj instanceof BERConstructedOctetString)
                        {
                            enumeration = ((BERConstructedOctetString)obj).getObjects();
                        } else
                        {
                            enumeration = (new BERConstructedOctetString(((ASN1OctetString)obj).getOctets())).getObjects();
                        }
                    } else
                    if (obj instanceof ASN1Sequence)
                    {
                        enumeration = ((ASN1Sequence)obj).getObjects();
                    } else
                    if (obj instanceof ASN1Set)
                    {
                        enumeration = ((ASN1Set)obj).getObjects();
                    } else
                    {
                        throw new RuntimeException((new StringBuilder()).append("not implemented: ").append(obj.getClass().getName()).toString());
                    }
                    for (; enumeration.hasMoreElements(); deroutputstream.writeObject(enumeration.nextElement())) { }
                } else
                {
                    deroutputstream.writeObject(obj);
                }
            }
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
