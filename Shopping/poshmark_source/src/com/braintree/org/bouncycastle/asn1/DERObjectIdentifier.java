// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1TaggedObject, ASN1ObjectIdentifier, ASN1OctetString, 
//            OIDTokenizer, DEROutputStream, DERObject

public class DERObjectIdentifier extends ASN1Object
{

    String identifier;

    public DERObjectIdentifier(String s)
    {
        if (!isValidIdentifier(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("string ").append(s).append(" not an OID").toString());
        } else
        {
            identifier = s;
            return;
        }
    }

    DERObjectIdentifier(byte abyte0[])
    {
        BigInteger biginteger;
        StringBuffer stringbuffer;
        boolean flag;
        int i;
        long l;
        stringbuffer = new StringBuffer();
        l = 0L;
        biginteger = null;
        flag = true;
        i = 0;
_L10:
        BigInteger biginteger1;
        boolean flag1;
        int j;
        long l1;
        if (i == abyte0.length)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        j = abyte0[i] & 0xff;
        if (l >= 0x80000000000000L)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        l1 = 128L * l + (long)(j & 0x7f);
        biginteger1 = biginteger;
        flag1 = flag;
        l = l1;
        if ((j & 0x80) != 0) goto _L2; else goto _L1
_L1:
        flag1 = flag;
        l = l1;
        if (!flag) goto _L4; else goto _L3
_L3:
        (int)l1 / 40;
        JVM INSTR tableswitch 0 1: default 124
    //                   0 179
    //                   1 194;
           goto _L5 _L6 _L7
_L5:
        stringbuffer.append('2');
        l = l1 - 80L;
_L8:
        flag1 = false;
_L4:
        stringbuffer.append('.');
        stringbuffer.append(l);
        l = 0L;
        biginteger1 = biginteger;
_L2:
        i++;
        biginteger = biginteger1;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L6:
        stringbuffer.append('0');
        l = l1;
          goto _L8
_L7:
        stringbuffer.append('1');
        l = l1 - 40L;
          goto _L8
        biginteger1 = biginteger;
        if (biginteger == null)
        {
            biginteger1 = BigInteger.valueOf(l);
        }
        biginteger = biginteger1.shiftLeft(7).or(BigInteger.valueOf(j & 0x7f));
        biginteger1 = biginteger;
        flag1 = flag;
        if ((j & 0x80) == 0)
        {
            stringbuffer.append('.');
            stringbuffer.append(biginteger);
            biginteger1 = null;
            l = 0L;
            flag1 = flag;
        }
          goto _L2
        identifier = stringbuffer.toString();
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static DERObjectIdentifier getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        DERObject derobject = asn1taggedobject.getObject();
        if (flag || (derobject instanceof DERObjectIdentifier))
        {
            return getInstance(derobject);
        } else
        {
            return new ASN1ObjectIdentifier(ASN1OctetString.getInstance(asn1taggedobject.getObject()).getOctets());
        }
    }

    public static DERObjectIdentifier getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERObjectIdentifier))
        {
            return (DERObjectIdentifier)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    private static boolean isValidIdentifier(String s)
    {
        if (s.length() >= 3 && s.charAt(1) == '.') goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        int i = s.charAt(0);
        if (i < '0' || i > '2')
        {
            return false;
        }
        boolean flag = false;
        i = s.length() - 1;
        do
        {
            flag1 = flag;
            if (i < 2)
            {
                continue; /* Loop/switch isn't completed */
            }
            char c = s.charAt(i);
            if ('0' <= c && c <= '9')
            {
                flag = true;
            } else
            if (c == '.')
            {
                if (!flag)
                {
                    return false;
                }
                flag = false;
            } else
            {
                return false;
            }
            i--;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeField(OutputStream outputstream, long l)
        throws IOException
    {
        byte abyte0[] = new byte[9];
        int i = 8;
        for (abyte0[8] = (byte)((int)l & 0x7f); l >= 128L; abyte0[i] = (byte)((int)l & 0x7f | 0x80))
        {
            l >>= 7;
            i--;
        }

        outputstream.write(abyte0, i, 9 - i);
    }

    private void writeField(OutputStream outputstream, BigInteger biginteger)
        throws IOException
    {
        int k = (biginteger.bitLength() + 6) / 7;
        if (k == 0)
        {
            outputstream.write(0);
            return;
        }
        byte abyte0[] = new byte[k];
        for (int i = k - 1; i >= 0; i--)
        {
            abyte0[i] = (byte)(biginteger.intValue() & 0x7f | 0x80);
            biginteger = biginteger.shiftRight(7);
        }

        int j = k - 1;
        abyte0[j] = (byte)(abyte0[j] & 0x7f);
        outputstream.write(abyte0);
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERObjectIdentifier))
        {
            return false;
        } else
        {
            return identifier.equals(((DERObjectIdentifier)derobject).identifier);
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        OIDTokenizer oidtokenizer = new OIDTokenizer(identifier);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DEROutputStream deroutputstream1 = new DEROutputStream(bytearrayoutputstream);
        writeField(bytearrayoutputstream, Integer.parseInt(oidtokenizer.nextToken()) * 40 + Integer.parseInt(oidtokenizer.nextToken()));
        while (oidtokenizer.hasMoreTokens()) 
        {
            String s = oidtokenizer.nextToken();
            if (s.length() < 18)
            {
                writeField(bytearrayoutputstream, Long.parseLong(s));
            } else
            {
                writeField(bytearrayoutputstream, new BigInteger(s));
            }
        }
        deroutputstream1.close();
        deroutputstream.writeEncoded(6, bytearrayoutputstream.toByteArray());
    }

    public String getId()
    {
        return identifier;
    }

    public int hashCode()
    {
        return identifier.hashCode();
    }

    public String toString()
    {
        return getId();
    }
}
