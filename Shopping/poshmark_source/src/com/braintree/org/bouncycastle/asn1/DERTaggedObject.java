// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1TaggedObject, DERSequence, DEREncodable, DERObject, 
//            DEROutputStream

public class DERTaggedObject extends ASN1TaggedObject
{

    private static final byte ZERO_BYTES[] = new byte[0];

    public DERTaggedObject(int i)
    {
        super(false, i, new DERSequence());
    }

    public DERTaggedObject(int i, DEREncodable derencodable)
    {
        super(i, derencodable);
    }

    public DERTaggedObject(boolean flag, int i, DEREncodable derencodable)
    {
        super(flag, i, derencodable);
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        if (!empty)
        {
            byte abyte0[] = obj.getDERObject().getEncoded("DER");
            if (explicit)
            {
                deroutputstream.writeEncoded(160, tagNo, abyte0);
                return;
            }
            char c;
            if ((abyte0[0] & 0x20) != 0)
            {
                c = '\240';
            } else
            {
                c = '\200';
            }
            deroutputstream.writeTag(c, tagNo);
            deroutputstream.write(abyte0, 1, abyte0.length - 1);
            return;
        } else
        {
            deroutputstream.writeEncoded(160, tagNo, ZERO_BYTES);
            return;
        }
    }

}
