// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1OctetStringParser, ASN1ParsingException, DEROctetString, DefiniteLengthInputStream, 
//            DERObject

public class DEROctetStringParser
    implements ASN1OctetStringParser
{

    private DefiniteLengthInputStream stream;

    DEROctetStringParser(DefiniteLengthInputStream definitelengthinputstream)
    {
        stream = definitelengthinputstream;
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
        return new DEROctetString(stream.toByteArray());
    }

    public InputStream getOctetStream()
    {
        return stream;
    }
}
