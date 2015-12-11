// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1SetParser, ASN1ParsingException, BERSet, ASN1StreamParser, 
//            DERObject, DEREncodable

public class BERSetParser
    implements ASN1SetParser
{

    private ASN1StreamParser _parser;

    BERSetParser(ASN1StreamParser asn1streamparser)
    {
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
            throw new ASN1ParsingException(ioexception.getMessage(), ioexception);
        }
        return derobject;
    }

    public DERObject getLoadedObject()
        throws IOException
    {
        return new BERSet(_parser.readVector(), false);
    }

    public DEREncodable readObject()
        throws IOException
    {
        return _parser.readObject();
    }
}
