// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Arrays;
import java.io.IOException;
import java.math.BigInteger;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1TaggedObject, ASN1Integer, ASN1OctetString, 
//            DEROutputStream, DERObject

public class DERInteger extends ASN1Object
{

    byte bytes[];

    public DERInteger(int i)
    {
        bytes = BigInteger.valueOf(i).toByteArray();
    }

    public DERInteger(BigInteger biginteger)
    {
        bytes = biginteger.toByteArray();
    }

    public DERInteger(byte abyte0[])
    {
        bytes = abyte0;
    }

    public static DERInteger getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        DERObject derobject = asn1taggedobject.getObject();
        if (flag || (derobject instanceof DERInteger))
        {
            return getInstance(derobject);
        } else
        {
            return new ASN1Integer(ASN1OctetString.getInstance(asn1taggedobject.getObject()).getOctets());
        }
    }

    public static DERInteger getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERInteger))
        {
            return (DERInteger)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERInteger))
        {
            return false;
        } else
        {
            derobject = (DERInteger)derobject;
            return Arrays.areEqual(bytes, ((DERInteger) (derobject)).bytes);
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(2, bytes);
    }

    public BigInteger getPositiveValue()
    {
        return new BigInteger(1, bytes);
    }

    public BigInteger getValue()
    {
        return new BigInteger(bytes);
    }

    public int hashCode()
    {
        int j = 0;
        for (int i = 0; i != bytes.length; i++)
        {
            j ^= (bytes[i] & 0xff) << i % 4;
        }

        return j;
    }

    public String toString()
    {
        return getValue().toString();
    }
}
