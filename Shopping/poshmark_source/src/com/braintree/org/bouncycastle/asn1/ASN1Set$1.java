// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1SetParser, ASN1Set, ASN1Sequence, DERObject, 
//            DEREncodable

class ze
    implements ASN1SetParser
{

    private int index;
    private final int max;
    final ASN1Set this$0;
    final ASN1Set val$outer;

    public DERObject getDERObject()
    {
        return val$outer;
    }

    public DERObject getLoadedObject()
    {
        return val$outer;
    }

    public DEREncodable readObject()
        throws IOException
    {
        Object obj;
        if (index == max)
        {
            obj = null;
        } else
        {
            obj = ASN1Set.this;
            int i = index;
            index = i + 1;
            DEREncodable derencodable = ((ASN1Set) (obj)).getObjectAt(i);
            if (derencodable instanceof ASN1Sequence)
            {
                return ((ASN1Sequence)derencodable).parser();
            }
            obj = derencodable;
            if (derencodable instanceof ASN1Set)
            {
                return ((ASN1Set)derencodable).parser();
            }
        }
        return ((DEREncodable) (obj));
    }

    le()
    {
        this$0 = final_asn1set;
        val$outer = ASN1Set.this;
        super();
        max = size();
    }
}
