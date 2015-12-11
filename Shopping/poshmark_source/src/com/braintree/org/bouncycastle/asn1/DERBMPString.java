// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERString, ASN1TaggedObject, ASN1OctetString, 
//            DEROutputStream, DERObject

public class DERBMPString extends ASN1Object
    implements DERString
{

    String string;

    public DERBMPString(String s)
    {
        string = s;
    }

    public DERBMPString(byte abyte0[])
    {
        char ac[] = new char[abyte0.length / 2];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i * 2] << 8 | abyte0[i * 2 + 1] & 0xff);
        }

        string = new String(ac);
    }

    public static DERBMPString getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERBMPString))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERBMPString(ASN1OctetString.getInstance(asn1taggedobject).getOctets());
        }
    }

    public static DERBMPString getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERBMPString))
        {
            return (DERBMPString)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    protected boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERBMPString))
        {
            return false;
        } else
        {
            derobject = (DERBMPString)derobject;
            return getString().equals(derobject.getString());
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        char ac[] = string.toCharArray();
        byte abyte0[] = new byte[ac.length * 2];
        for (int i = 0; i != ac.length; i++)
        {
            abyte0[i * 2] = (byte)(ac[i] >> 8);
            abyte0[i * 2 + 1] = (byte)ac[i];
        }

        deroutputstream.writeEncoded(30, abyte0);
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
