// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.io.Streams;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1OctetStringParser, ASN1ParsingException, BERConstructedOctetString, ConstructedOctetStream, 
//            ASN1StreamParser, DERObject

public class BEROctetStringParser
    implements ASN1OctetStringParser
{

    private ASN1StreamParser _parser;

    BEROctetStringParser(ASN1StreamParser asn1streamparser)
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
            throw new ASN1ParsingException((new StringBuilder()).append("IOException converting stream to byte array: ").append(ioexception.getMessage()).toString(), ioexception);
        }
        return derobject;
    }

    public DERObject getLoadedObject()
        throws IOException
    {
        return new BERConstructedOctetString(Streams.readAll(getOctetStream()));
    }

    public InputStream getOctetStream()
    {
        return new ConstructedOctetStream(_parser);
    }
}
