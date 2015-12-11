// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Encodable, DERTags, DEROutputStream

public abstract class DERObject extends ASN1Encodable
    implements DERTags
{

    public DERObject()
    {
    }

    abstract void encode(DEROutputStream deroutputstream)
        throws IOException;

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public DERObject toASN1Object()
    {
        return this;
    }
}
