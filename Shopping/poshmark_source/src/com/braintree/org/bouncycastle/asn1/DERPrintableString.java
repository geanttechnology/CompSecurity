// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERString, ASN1TaggedObject, ASN1OctetString, 
//            DEROutputStream, DERObject

public class DERPrintableString extends ASN1Object
    implements DERString
{

    String string;

    public DERPrintableString(String s)
    {
        this(s, false);
    }

    public DERPrintableString(String s, boolean flag)
    {
        if (flag && !isPrintableString(s))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        } else
        {
            string = s;
            return;
        }
    }

    public DERPrintableString(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        string = new String(ac);
    }

    public static DERPrintableString getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERPrintableString))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERPrintableString(ASN1OctetString.getInstance(asn1taggedobject).getOctets());
        }
    }

    public static DERPrintableString getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERPrintableString))
        {
            return (DERPrintableString)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    public static boolean isPrintableString(String s)
    {
        int i = s.length() - 1;
        do
        {
            if (i < 0)
            {
                break;
            }
            char c = s.charAt(i);
            if (c > '\177')
            {
                return false;
            }
            if (('a' > c || c > 'z') && ('A' > c || c > 'Z') && ('0' > c || c > '9'))
            {
                switch (c)
                {
                default:
                    return false;

                case 32: // ' '
                case 39: // '\''
                case 40: // '('
                case 41: // ')'
                case 43: // '+'
                case 44: // ','
                case 45: // '-'
                case 46: // '.'
                case 47: // '/'
                case 58: // ':'
                case 61: // '='
                case 63: // '?'
                    break;
                }
            }
            i--;
        } while (true);
        return true;
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERPrintableString))
        {
            return false;
        } else
        {
            derobject = (DERPrintableString)derobject;
            return getString().equals(derobject.getString());
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(19, getOctets());
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
