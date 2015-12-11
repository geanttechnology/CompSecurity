// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERString, ASN1TaggedObject, ASN1OctetString, 
//            DEROutputStream, DERObject

public class DERT61String extends ASN1Object
    implements DERString
{

    String string;

    public DERT61String(String s)
    {
        string = s;
    }

    public DERT61String(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        string = new String(ac);
    }

    public static DERT61String getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag)
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERT61String(ASN1OctetString.getInstance(asn1taggedobject).getOctets());
        }
    }

    public static DERT61String getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERT61String))
        {
            return (DERT61String)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERT61String))
        {
            return false;
        } else
        {
            return getString().equals(((DERT61String)derobject).getString());
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(20, getOctets());
    }

    public byte[] getOctets()
    {
        char ac[] = string.toCharArray();
        byte abyte0[] = new byte[ac.length];
        for (int i = 0; i != ac.length; i++)
        {
            abyte0[i] = (byte)ac[i];
        }

        return abyte0;
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
