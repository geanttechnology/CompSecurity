// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, DERObject, DEROutputStream

public abstract class ASN1Null extends ASN1Object
{

    public ASN1Null()
    {
    }

    boolean asn1Equals(DERObject derobject)
    {
        return derobject instanceof ASN1Null;
    }

    abstract void encode(DEROutputStream deroutputstream)
        throws IOException;

    public int hashCode()
    {
        return -1;
    }

    public String toString()
    {
        return "NULL";
    }
}
