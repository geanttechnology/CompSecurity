// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1TaggedObjectParser, ASN1StreamParser, ASN1ParsingException, DERObject, 
//            DEREncodable

public class BERTaggedObjectParser
    implements ASN1TaggedObjectParser
{

    private boolean _constructed;
    private ASN1StreamParser _parser;
    private int _tagNumber;

    protected BERTaggedObjectParser(int i, int j, InputStream inputstream)
    {
        boolean flag;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this(flag, j, new ASN1StreamParser(inputstream));
    }

    BERTaggedObjectParser(boolean flag, int i, ASN1StreamParser asn1streamparser)
    {
        _constructed = flag;
        _tagNumber = i;
        _parser = asn1streamparser;
    }

    public DERObject getDERObject()
    {
        DERObject derobject;
        try
        {
            derobject = getLoadedObject();
        }
        catch (IOException ioexception)
        {
            throw new ASN1ParsingException(ioexception.getMessage());
        }
        return derobject;
    }

    public DERObject getLoadedObject()
        throws IOException
    {
        return _parser.readTaggedObject(_constructed, _tagNumber);
    }

    public DEREncodable getObjectParser(int i, boolean flag)
        throws IOException
    {
        if (flag)
        {
            if (!_constructed)
            {
                throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
            } else
            {
                return _parser.readObject();
            }
        } else
        {
            return _parser.readImplicit(_constructed, i);
        }
    }

    public int getTagNo()
    {
        return _tagNumber;
    }

    public boolean isConstructed()
    {
        return _constructed;
    }
}
