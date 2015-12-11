// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1TaggedObject, ASN1OctetString, DEROutputStream, 
//            DERObject

public class DERBoolean extends ASN1Object
{

    public static final DERBoolean FALSE = new DERBoolean(false);
    public static final DERBoolean TRUE = new DERBoolean(true);
    byte value;

    public DERBoolean(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        value = byte0;
    }

    public DERBoolean(byte abyte0[])
    {
        if (abyte0.length != 1)
        {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        } else
        {
            value = abyte0[0];
            return;
        }
    }

    public static DERBoolean getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERBoolean))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERBoolean(((ASN1OctetString)asn1taggedobject).getOctets());
        }
    }

    public static DERBoolean getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERBoolean))
        {
            return (DERBoolean)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    public static DERBoolean getInstance(boolean flag)
    {
        if (flag)
        {
            return TRUE;
        } else
        {
            return FALSE;
        }
    }

    protected boolean asn1Equals(DERObject derobject)
    {
        while (derobject == null || !(derobject instanceof DERBoolean) || value != ((DERBoolean)derobject).value) 
        {
            return false;
        }
        return true;
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(1, new byte[] {
            value
        });
    }

    public int hashCode()
    {
        return value;
    }

    public boolean isTrue()
    {
        return value != 0;
    }

    public String toString()
    {
        if (value != 0)
        {
            return "TRUE";
        } else
        {
            return "FALSE";
        }
    }

}
