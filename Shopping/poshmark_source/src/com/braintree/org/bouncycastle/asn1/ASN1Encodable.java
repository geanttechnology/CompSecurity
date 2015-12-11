// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DEREncodable, DERObject, ASN1OutputStream, DEROutputStream

public abstract class ASN1Encodable
    implements DEREncodable
{

    public static final String BER = "BER";
    public static final String DER = "DER";

    public ASN1Encodable()
    {
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof DEREncodable))
        {
            return false;
        } else
        {
            obj = (DEREncodable)obj;
            return toASN1Object().equals(((DEREncodable) (obj)).getDERObject());
        }
    }

    public byte[] getDEREncoded()
    {
        byte abyte0[];
        try
        {
            abyte0 = getEncoded("DER");
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return abyte0;
    }

    public DERObject getDERObject()
    {
        return toASN1Object();
    }

    public byte[] getEncoded()
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        (new ASN1OutputStream(bytearrayoutputstream)).writeObject(this);
        return bytearrayoutputstream.toByteArray();
    }

    public byte[] getEncoded(String s)
        throws IOException
    {
        if (s.equals("DER"))
        {
            s = new ByteArrayOutputStream();
            (new DEROutputStream(s)).writeObject(this);
            return s.toByteArray();
        } else
        {
            return getEncoded();
        }
    }

    public int hashCode()
    {
        return toASN1Object().hashCode();
    }

    public abstract DERObject toASN1Object();
}
