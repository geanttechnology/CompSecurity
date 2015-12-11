// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Strings;
import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERString, ASN1TaggedObject, ASN1OctetString, 
//            DEROutputStream, DERObject

public class DERUTF8String extends ASN1Object
    implements DERString
{

    String string;

    public DERUTF8String(String s)
    {
        string = s;
    }

    public DERUTF8String(byte abyte0[])
    {
        try
        {
            string = Strings.fromUTF8ByteArray(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException("UTF8 encoding invalid");
        }
    }

    public static DERUTF8String getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERUTF8String))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERUTF8String(ASN1OctetString.getInstance(asn1taggedobject).getOctets());
        }
    }

    public static DERUTF8String getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERUTF8String))
        {
            return (DERUTF8String)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERUTF8String))
        {
            return false;
        } else
        {
            derobject = (DERUTF8String)derobject;
            return getString().equals(derobject.getString());
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(12, Strings.toUTF8ByteArray(string));
    }

    public String getString()
    {
        return string;
    }

    public int hashCode()
    {
        return getString().hashCode();
    }

    public String toString()
    {
        return string;
    }
}
