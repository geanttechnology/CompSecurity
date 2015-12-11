// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERString, ASN1TaggedObject, ASN1OctetString, 
//            DEROutputStream, DERObject

public class DERNumericString extends ASN1Object
    implements DERString
{

    String string;

    public DERNumericString(String s)
    {
        this(s, false);
    }

    public DERNumericString(String s, boolean flag)
    {
        if (flag && !isNumericString(s))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        } else
        {
            string = s;
            return;
        }
    }

    public DERNumericString(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        string = new String(ac);
    }

    public static DERNumericString getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERNumericString))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERNumericString(ASN1OctetString.getInstance(asn1taggedobject).getOctets());
        }
    }

    public static DERNumericString getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERNumericString))
        {
            return (DERNumericString)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    public static boolean isNumericString(String s)
    {
        for (int i = s.length() - 1; i >= 0; i--)
        {
            for (char c = s.charAt(i); c > '\177' || ('0' > c || c > '9') && c != ' ';)
            {
                return false;
            }

        }

        return true;
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERNumericString))
        {
            return false;
        } else
        {
            derobject = (DERNumericString)derobject;
            return getString().equals(derobject.getString());
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(18, getOctets());
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
