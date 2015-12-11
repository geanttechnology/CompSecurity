// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1ApplicationSpecificParser, ASN1ParsingException, BERApplicationSpecific, ASN1StreamParser, 
//            DERObject, DEREncodable

public class BERApplicationSpecificParser
    implements ASN1ApplicationSpecificParser
{

    private final ASN1StreamParser parser;
    private final int tag;

    BERApplicationSpecificParser(int i, ASN1StreamParser asn1streamparser)
    {
        tag = i;
        parser = asn1streamparser;
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
            throw new ASN1ParsingException(ioexception.getMessage(), ioexception);
        }
        return derobject;
    }

    public DERObject getLoadedObject()
        throws IOException
    {
        return new BERApplicationSpecific(tag, parser.readVector());
    }

    public DEREncodable readObject()
        throws IOException
    {
        return parser.readObject();
    }
}
