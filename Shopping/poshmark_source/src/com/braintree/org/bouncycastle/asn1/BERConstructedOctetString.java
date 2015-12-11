// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DEROctetString, DEREncodable, ASN1Sequence, ASN1OutputStream, 
//            BEROutputStream, DEROutputStream, DERObject

public class BERConstructedOctetString extends DEROctetString
{

    private static final int MAX_LENGTH = 1000;
    private Vector octs;

    public BERConstructedOctetString(DEREncodable derencodable)
    {
        super(derencodable.getDERObject());
    }

    public BERConstructedOctetString(DERObject derobject)
    {
        super(derobject);
    }

    public BERConstructedOctetString(Vector vector)
    {
        super(toBytes(vector));
        octs = vector;
    }

    public BERConstructedOctetString(byte abyte0[])
    {
        super(abyte0);
    }

    public static BERConstructedOctetString fromSequence(ASN1Sequence asn1sequence)
    {
        Vector vector = new Vector();
        for (asn1sequence = asn1sequence.getObjects(); asn1sequence.hasMoreElements(); vector.addElement(asn1sequence.nextElement())) { }
        return new BERConstructedOctetString(vector);
    }

    private Vector generateOcts()
    {
        Vector vector = new Vector();
        int i = 0;
        while (i < string.length) 
        {
            byte abyte0[];
            int j;
            if (i + 1000 > string.length)
            {
                j = string.length;
            } else
            {
                j = i + 1000;
            }
            abyte0 = new byte[j - i];
            System.arraycopy(string, i, abyte0, 0, abyte0.length);
            vector.addElement(new DEROctetString(abyte0));
            i += 1000;
        }
        return vector;
    }

    private static byte[] toBytes(Vector vector)
    {
        Object obj = new ByteArrayOutputStream();
        int i = 0;
        while (i != vector.size()) 
        {
            try
            {
                ((ByteArrayOutputStream) (obj)).write(((DEROctetString)vector.elementAt(i)).getOctets());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(vector.elementAt(i).getClass().getName()).append(" found in input should only contain DEROctetString").toString());
            }
            // Misplaced declaration of an exception variable
            catch (Vector vector)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("exception converting octets ").append(vector.toString()).toString());
            }
            i++;
        }
        return ((ByteArrayOutputStream) (obj)).toByteArray();
    }

    public void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        if ((deroutputstream instanceof ASN1OutputStream) || (deroutputstream instanceof BEROutputStream))
        {
            deroutputstream.write(36);
            deroutputstream.write(128);
            for (Enumeration enumeration = getObjects(); enumeration.hasMoreElements(); deroutputstream.writeObject(enumeration.nextElement())) { }
            deroutputstream.write(0);
            deroutputstream.write(0);
            return;
        } else
        {
            super.encode(deroutputstream);
            return;
        }
    }

    public Enumeration getObjects()
    {
        if (octs == null)
        {
            return generateOcts().elements();
        } else
        {
            return octs.elements();
        }
    }

    public byte[] getOctets()
    {
        return string;
    }
}
