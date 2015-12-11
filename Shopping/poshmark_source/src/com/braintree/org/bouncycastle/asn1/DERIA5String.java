// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERString, ASN1TaggedObject, ASN1OctetString, 
//            DEROutputStream, DERObject

public class DERIA5String extends ASN1Object
    implements DERString
{

    String string;

    public DERIA5String(String s)
    {
        this(s, false);
    }

    public DERIA5String(String s, boolean flag)
    {
        if (s == null)
        {
            throw new NullPointerException("string cannot be null");
        }
        if (flag && !isIA5String(s))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        } else
        {
            string = s;
            return;
        }
    }

    public DERIA5String(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        string = new String(ac);
    }

    public static DERIA5String getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERIA5String))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERIA5String(((ASN1OctetString)asn1taggedobject).getOctets());
        }
    }

    public static DERIA5String getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERIA5String))
        {
            return (DERIA5String)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    public static boolean isIA5String(String s)
    {
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) > '\177')
            {
                return false;
            }
        }

        return true;
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERIA5String))
        {
            return false;
        } else
        {
            derobject = (DERIA5String)derobject;
            return getString().equals(derobject.getString());
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(22, getOctets());
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
