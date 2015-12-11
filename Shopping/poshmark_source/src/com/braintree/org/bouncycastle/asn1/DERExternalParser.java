// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DEREncodable, InMemoryRepresentable, ASN1ParsingException, DERExternal, 
//            ASN1StreamParser, ASN1Exception, DERObject

public class DERExternalParser
    implements DEREncodable, InMemoryRepresentable
{

    private ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser asn1streamparser)
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
            throw new ASN1ParsingException("unable to get DER object", ioexception);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ASN1ParsingException("unable to get DER object", illegalargumentexception);
        }
        return derobject;
    }

    public DERObject getLoadedObject()
        throws IOException
    {
        DERExternal derexternal;
        try
        {
            derexternal = new DERExternal(_parser.readVector());
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ASN1Exception(illegalargumentexception.getMessage(), illegalargumentexception);
        }
        return derexternal;
    }

    public DEREncodable readObject()
        throws IOException
    {
        return _parser.readObject();
    }
}
