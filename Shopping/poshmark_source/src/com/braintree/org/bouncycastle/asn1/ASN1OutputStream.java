// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DEROutputStream, DERObject, DEREncodable

public class ASN1OutputStream extends DEROutputStream
{

    public ASN1OutputStream(OutputStream outputstream)
    {
        super(outputstream);
    }

    public void writeObject(Object obj)
        throws IOException
    {
        if (obj == null)
        {
            writeNull();
            return;
        }
        if (obj instanceof DERObject)
        {
            ((DERObject)obj).encode(this);
            return;
        }
        if (obj instanceof DEREncodable)
        {
            ((DEREncodable)obj).getDERObject().encode(this);
            return;
        } else
        {
            throw new IOException("object not ASN1Encodable");
        }
    }
}
