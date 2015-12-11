// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1EncodableVector, ASN1Encodable, ASN1ParsingException, 
//            DEREncodable, DERObject, DEROutputStream, ASN1InputStream

public class DERApplicationSpecific extends ASN1Object
{

    private final boolean isConstructed;
    private final byte octets[];
    private final int tag;

    public DERApplicationSpecific(int i, ASN1EncodableVector asn1encodablevector)
    {
        tag = i;
        isConstructed = true;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        i = 0;
        while (i != asn1encodablevector.size()) 
        {
            try
            {
                bytearrayoutputstream.write(((ASN1Encodable)asn1encodablevector.get(i)).getEncoded());
            }
            // Misplaced declaration of an exception variable
            catch (ASN1EncodableVector asn1encodablevector)
            {
                throw new ASN1ParsingException((new StringBuilder()).append("malformed object: ").append(asn1encodablevector).toString(), asn1encodablevector);
            }
            i++;
        }
        octets = bytearrayoutputstream.toByteArray();
    }

    public DERApplicationSpecific(int i, DEREncodable derencodable)
        throws IOException
    {
        this(true, i, derencodable);
    }

    public DERApplicationSpecific(int i, byte abyte0[])
    {
        this(false, i, abyte0);
    }

    public DERApplicationSpecific(boolean flag, int i, DEREncodable derencodable)
        throws IOException
    {
        derencodable = derencodable.getDERObject().getDEREncoded();
        isConstructed = flag;
        tag = i;
        if (flag)
        {
            octets = derencodable;
            return;
        } else
        {
            i = getLengthOfLength(derencodable);
            byte abyte0[] = new byte[derencodable.length - i];
            System.arraycopy(derencodable, i, abyte0, 0, abyte0.length);
            octets = abyte0;
            return;
        }
    }

    DERApplicationSpecific(boolean flag, int i, byte abyte0[])
    {
        isConstructed = flag;
        tag = i;
        octets = abyte0;
    }

    private int getLengthOfLength(byte abyte0[])
    {
        int i;
        for (i = 2; (abyte0[i - 1] & 0x80) != 0; i++) { }
        return i;
    }

    private byte[] replaceTagNumber(int i, byte abyte0[])
        throws IOException
    {
        byte byte0 = abyte0[0];
        int j = 1;
        if ((byte0 & 0x1f) == 31)
        {
            int l = 0;
            j = 1 + 1;
            int i1 = abyte0[1] & 0xff;
            int k = i1;
            if ((i1 & 0x7f) == 0)
            {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
            while (k >= 0 && (k & 0x80) != 0) 
            {
                l = (l | k & 0x7f) << 7;
                k = abyte0[j] & 0xff;
                j++;
            }
        }
        byte abyte1[] = new byte[(abyte0.length - j) + 1];
        System.arraycopy(abyte0, j, abyte1, 1, abyte1.length - 1);
        abyte1[0] = (byte)i;
        return abyte1;
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (derobject instanceof DERApplicationSpecific)
        {
            if (isConstructed == ((DERApplicationSpecific) (derobject = (DERApplicationSpecific)derobject)).isConstructed && tag == ((DERApplicationSpecific) (derobject)).tag && Arrays.areEqual(octets, ((DERApplicationSpecific) (derobject)).octets))
            {
                return true;
            }
        }
        return false;
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        int i = 64;
        if (isConstructed)
        {
            i = 0x40 | 0x20;
        }
        deroutputstream.writeEncoded(i, tag, octets);
    }

    public int getApplicationTag()
    {
        return tag;
    }

    public byte[] getContents()
    {
        return octets;
    }

    public DERObject getObject()
        throws IOException
    {
        return (new ASN1InputStream(getContents())).readObject();
    }

    public DERObject getObject(int i)
        throws IOException
    {
        if (i >= 31)
        {
            throw new IOException("unsupported tag number");
        }
        byte abyte0[] = getEncoded();
        byte abyte1[] = replaceTagNumber(i, abyte0);
        if ((abyte0[0] & 0x20) != 0)
        {
            abyte1[0] = (byte)(abyte1[0] | 0x20);
        }
        return (new ASN1InputStream(abyte1)).readObject();
    }

    public int hashCode()
    {
        boolean flag;
        if (isConstructed)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag ^ tag ^ Arrays.hashCode(octets);
    }

    public boolean isConstructed()
    {
        return isConstructed;
    }
}
