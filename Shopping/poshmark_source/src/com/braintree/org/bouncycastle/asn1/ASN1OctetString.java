// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Arrays;
import com.braintree.org.bouncycastle.util.encoders.Hex;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1OctetStringParser, DEREncodable, DERObject, 
//            ASN1TaggedObject, ASN1Sequence, BERConstructedOctetString, DEROutputStream

public abstract class ASN1OctetString extends ASN1Object
    implements ASN1OctetStringParser
{

    byte string[];

    public ASN1OctetString(DEREncodable derencodable)
    {
        try
        {
            string = derencodable.getDERObject().getEncoded("DER");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DEREncodable derencodable)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Error processing object : ").append(derencodable.toString()).toString());
        }
    }

    public ASN1OctetString(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("string cannot be null");
        } else
        {
            string = abyte0;
            return;
        }
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof ASN1OctetString))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return BERConstructedOctetString.fromSequence(ASN1Sequence.getInstance(asn1taggedobject));
        }
    }

    public static ASN1OctetString getInstance(Object obj)
    {
        if (obj == null || (obj instanceof ASN1OctetString))
        {
            return (ASN1OctetString)obj;
        }
        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof ASN1OctetString))
        {
            return false;
        } else
        {
            derobject = (ASN1OctetString)derobject;
            return Arrays.areEqual(string, ((ASN1OctetString) (derobject)).string);
        }
    }

    abstract void encode(DEROutputStream deroutputstream)
        throws IOException;

    public DERObject getLoadedObject()
    {
        return getDERObject();
    }

    public InputStream getOctetStream()
    {
        return new ByteArrayInputStream(string);
    }

    public byte[] getOctets()
    {
        return string;
    }

    public int hashCode()
    {
        return Arrays.hashCode(getOctets());
    }

    public ASN1OctetStringParser parser()
    {
        return this;
    }

    public String toString()
    {
        return (new StringBuilder()).append("#").append(new String(Hex.encode(string))).toString();
    }
}
