// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERString, ASN1TaggedObject, ASN1OctetString, 
//            DEROutputStream, ASN1OutputStream, DERObject

public class DERUniversalString extends ASN1Object
    implements DERString
{

    private static final char table[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };
    private byte string[];

    public DERUniversalString(byte abyte0[])
    {
        string = abyte0;
    }

    public static DERUniversalString getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERUniversalString))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERUniversalString(((ASN1OctetString)asn1taggedobject).getOctets());
        }
    }

    public static DERUniversalString getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERUniversalString))
        {
            return (DERUniversalString)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERUniversalString))
        {
            return false;
        } else
        {
            return getString().equals(((DERUniversalString)derobject).getString());
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(28, getOctets());
    }

    public byte[] getOctets()
    {
        return string;
    }

    public String getString()
    {
        Object obj = new StringBuffer("#");
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ASN1OutputStream asn1outputstream = new ASN1OutputStream(bytearrayoutputstream);
        byte abyte0[];
        try
        {
            asn1outputstream.writeObject(this);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("internal error encoding BitString");
        }
        abyte0 = bytearrayoutputstream.toByteArray();
        for (int i = 0; i != abyte0.length; i++)
        {
            ((StringBuffer) (obj)).append(table[abyte0[i] >>> 4 & 0xf]);
            ((StringBuffer) (obj)).append(table[abyte0[i] & 0xf]);
        }

        return ((StringBuffer) (obj)).toString();
    }

    public int hashCode()
    {
        return getString().hashCode();
    }

    public String toString()
    {
        return getString();
    }

}
