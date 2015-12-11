// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Arrays;
import java.io.IOException;
import java.math.BigInteger;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1TaggedObject, ASN1OctetString, DEROutputStream, 
//            DERObject

public class DEREnumerated extends ASN1Object
{

    byte bytes[];

    public DEREnumerated(int i)
    {
        bytes = BigInteger.valueOf(i).toByteArray();
    }

    public DEREnumerated(BigInteger biginteger)
    {
        bytes = biginteger.toByteArray();
    }

    public DEREnumerated(byte abyte0[])
    {
        bytes = abyte0;
    }

    public static DEREnumerated getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DEREnumerated))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DEREnumerated(((ASN1OctetString)asn1taggedobject).getOctets());
        }
    }

    public static DEREnumerated getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DEREnumerated))
        {
            return (DEREnumerated)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DEREnumerated))
        {
            return false;
        } else
        {
            derobject = (DEREnumerated)derobject;
            return Arrays.areEqual(bytes, ((DEREnumerated) (derobject)).bytes);
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(10, bytes);
    }

    public BigInteger getValue()
    {
        return new BigInteger(bytes);
    }

    public int hashCode()
    {
        return Arrays.hashCode(bytes);
    }
}
