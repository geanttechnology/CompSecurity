// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.io.Streams;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERTags, DERUnknownTag, DERBitString, DERBMPString, 
//            ASN1Boolean, ASN1Enumerated, ASN1GeneralizedTime, DERGeneralString, 
//            DERIA5String, ASN1Integer, DERNull, DERNumericString, 
//            ASN1ObjectIdentifier, DEROctetString, DERPrintableString, DERT61String, 
//            DERUniversalString, ASN1UTCTime, DERUTF8String, DERVisibleString, 
//            LimitedInputStream, ASN1EncodableVector, DefiniteLengthInputStream, DERApplicationSpecific, 
//            ASN1StreamParser, BERConstructedOctetString, LazyDERSequence, DERFactory, 
//            DERExternal, IndefiniteLengthInputStream, BERApplicationSpecificParser, BERTaggedObjectParser, 
//            BEROctetStringParser, BERSequenceParser, BERSetParser, DERExternalParser, 
//            ASN1Exception, DERObject

public class ASN1InputStream extends FilterInputStream
    implements DERTags
{

    private final boolean lazyEvaluate;
    private final int limit;

    public ASN1InputStream(InputStream inputstream)
    {
        this(inputstream, findLimit(inputstream));
    }

    public ASN1InputStream(InputStream inputstream, int i)
    {
        this(inputstream, i, false);
    }

    public ASN1InputStream(InputStream inputstream, int i, boolean flag)
    {
        super(inputstream);
        limit = i;
        lazyEvaluate = flag;
    }

    public ASN1InputStream(byte abyte0[])
    {
        this(((InputStream) (new ByteArrayInputStream(abyte0))), abyte0.length);
    }

    public ASN1InputStream(byte abyte0[], boolean flag)
    {
        this(((InputStream) (new ByteArrayInputStream(abyte0))), abyte0.length, flag);
    }

    static DERObject createPrimitiveDERObject(int i, byte abyte0[])
    {
        switch (i)
        {
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 11: // '\013'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 21: // '\025'
        case 25: // '\031'
        case 29: // '\035'
        default:
            return new DERUnknownTag(false, i, abyte0);

        case 3: // '\003'
            return DERBitString.fromOctetString(abyte0);

        case 30: // '\036'
            return new DERBMPString(abyte0);

        case 1: // '\001'
            return new ASN1Boolean(abyte0);

        case 10: // '\n'
            return new ASN1Enumerated(abyte0);

        case 24: // '\030'
            return new ASN1GeneralizedTime(abyte0);

        case 27: // '\033'
            return new DERGeneralString(abyte0);

        case 22: // '\026'
            return new DERIA5String(abyte0);

        case 2: // '\002'
            return new ASN1Integer(abyte0);

        case 5: // '\005'
            return DERNull.INSTANCE;

        case 18: // '\022'
            return new DERNumericString(abyte0);

        case 6: // '\006'
            return new ASN1ObjectIdentifier(abyte0);

        case 4: // '\004'
            return new DEROctetString(abyte0);

        case 19: // '\023'
            return new DERPrintableString(abyte0);

        case 20: // '\024'
            return new DERT61String(abyte0);

        case 28: // '\034'
            return new DERUniversalString(abyte0);

        case 23: // '\027'
            return new ASN1UTCTime(abyte0);

        case 12: // '\f'
            return new DERUTF8String(abyte0);

        case 26: // '\032'
            return new DERVisibleString(abyte0);
        }
    }

    static int findLimit(InputStream inputstream)
    {
        if (inputstream instanceof LimitedInputStream)
        {
            return ((LimitedInputStream)inputstream).getRemaining();
        }
        if (inputstream instanceof ByteArrayInputStream)
        {
            return ((ByteArrayInputStream)inputstream).available();
        } else
        {
            return 0x7fffffff;
        }
    }

    static int readLength(InputStream inputstream, int i)
        throws IOException
    {
        int j = inputstream.read();
        if (j < 0)
        {
            throw new EOFException("EOF found when length expected");
        }
        if (j == 128)
        {
            return -1;
        }
        int k = j;
        if (j > 127)
        {
            int l = j & 0x7f;
            if (l > 4)
            {
                throw new IOException((new StringBuilder()).append("DER length more than 4 bytes: ").append(l).toString());
            }
            j = 0;
            for (k = 0; k < l; k++)
            {
                int i1 = inputstream.read();
                if (i1 < 0)
                {
                    throw new EOFException("EOF found reading length");
                }
                j = (j << 8) + i1;
            }

            if (j < 0)
            {
                throw new IOException("corrupted stream - negative length found");
            }
            k = j;
            if (j >= i)
            {
                throw new IOException("corrupted stream - out of bounds length found");
            }
        }
        return k;
    }

    static int readTagNumber(InputStream inputstream, int i)
        throws IOException
    {
        int j = i & 0x1f;
        i = j;
        if (j == 31)
        {
            int k = 0;
            int l = inputstream.read();
            i = l;
            if ((l & 0x7f) == 0)
            {
                throw new IOException("corrupted stream - invalid high tag number found");
            }
            for (; i >= 0 && (i & 0x80) != 0; i = inputstream.read())
            {
                k = (k | i & 0x7f) << 7;
            }

            if (i < 0)
            {
                throw new EOFException("EOF found inside tag value.");
            }
            i = k | i & 0x7f;
        }
        return i;
    }

    ASN1EncodableVector buildDEREncodableVector(DefiniteLengthInputStream definitelengthinputstream)
        throws IOException
    {
        return (new ASN1InputStream(definitelengthinputstream)).buildEncodableVector();
    }

    ASN1EncodableVector buildEncodableVector()
        throws IOException
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        do
        {
            DERObject derobject = readObject();
            if (derobject != null)
            {
                asn1encodablevector.add(derobject);
            } else
            {
                return asn1encodablevector;
            }
        } while (true);
    }

    protected DERObject buildObject(int i, int j, int k)
        throws IOException
    {
        DefiniteLengthInputStream definitelengthinputstream;
        boolean flag;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        definitelengthinputstream = new DefiniteLengthInputStream(this, k);
        if ((i & 0x40) != 0)
        {
            return new DERApplicationSpecific(flag, j, definitelengthinputstream.toByteArray());
        }
        if ((i & 0x80) != 0)
        {
            return (new ASN1StreamParser(definitelengthinputstream)).readTaggedObject(flag, j);
        }
        if (flag)
        {
            switch (j)
            {
            default:
                return new DERUnknownTag(true, j, definitelengthinputstream.toByteArray());

            case 4: // '\004'
                return new BERConstructedOctetString(buildDEREncodableVector(definitelengthinputstream).v);

            case 16: // '\020'
                if (lazyEvaluate)
                {
                    return new LazyDERSequence(definitelengthinputstream.toByteArray());
                } else
                {
                    return DERFactory.createSequence(buildDEREncodableVector(definitelengthinputstream));
                }

            case 17: // '\021'
                return DERFactory.createSet(buildDEREncodableVector(definitelengthinputstream), false);

            case 8: // '\b'
                return new DERExternal(buildDEREncodableVector(definitelengthinputstream));
            }
        } else
        {
            return createPrimitiveDERObject(j, definitelengthinputstream.toByteArray());
        }
    }

    protected void readFully(byte abyte0[])
        throws IOException
    {
        if (Streams.readFully(this, abyte0) != abyte0.length)
        {
            throw new EOFException("EOF encountered in middle of object");
        } else
        {
            return;
        }
    }

    protected int readLength()
        throws IOException
    {
        return readLength(((InputStream) (this)), limit);
    }

    public DERObject readObject()
        throws IOException
    {
        int i = read();
        if (i <= 0)
        {
            if (i == 0)
            {
                throw new IOException("unexpected end-of-contents marker");
            } else
            {
                return null;
            }
        }
        int j = readTagNumber(this, i);
        boolean flag;
        int k;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = readLength();
        if (k < 0)
        {
            if (!flag)
            {
                throw new IOException("indefinite length primitive encoding encountered");
            }
            ASN1StreamParser asn1streamparser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, limit), limit);
            if ((i & 0x40) != 0)
            {
                return (new BERApplicationSpecificParser(j, asn1streamparser)).getLoadedObject();
            }
            if ((i & 0x80) != 0)
            {
                return (new BERTaggedObjectParser(true, j, asn1streamparser)).getLoadedObject();
            }
            switch (j)
            {
            default:
                throw new IOException("unknown BER object encountered");

            case 4: // '\004'
                return (new BEROctetStringParser(asn1streamparser)).getLoadedObject();

            case 16: // '\020'
                return (new BERSequenceParser(asn1streamparser)).getLoadedObject();

            case 17: // '\021'
                return (new BERSetParser(asn1streamparser)).getLoadedObject();

            case 8: // '\b'
                return (new DERExternalParser(asn1streamparser)).getLoadedObject();
            }
        }
        DERObject derobject;
        try
        {
            derobject = buildObject(i, j, k);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ASN1Exception("corrupted stream detected", illegalargumentexception);
        }
        return derobject;
    }
}
