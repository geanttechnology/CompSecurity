// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERObject, ASN1InputStream, DEREncodable, DEROutputStream

public abstract class ASN1Object extends DERObject
{

    public ASN1Object()
    {
    }

    public static ASN1Object fromByteArray(byte abyte0[])
        throws IOException
    {
        abyte0 = new ASN1InputStream(abyte0);
        try
        {
            abyte0 = (ASN1Object)abyte0.readObject();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IOException("cannot recognise object in stream");
        }
        return abyte0;
    }

    abstract boolean asn1Equals(DERObject derobject);

    abstract void encode(DEROutputStream deroutputstream)
        throws IOException;

    public final boolean equals(Object obj)
    {
        while (this == obj || (obj instanceof DEREncodable) && asn1Equals(((DEREncodable)obj).getDERObject())) 
        {
            return true;
        }
        return false;
    }

    public abstract int hashCode();
}
