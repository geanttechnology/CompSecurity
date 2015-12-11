// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;


// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERSequence, DERSet, ASN1EncodableVector

class DERFactory
{

    static final DERSequence EMPTY_SEQUENCE = new DERSequence();
    static final DERSet EMPTY_SET = new DERSet();

    DERFactory()
    {
    }

    static DERSequence createSequence(ASN1EncodableVector asn1encodablevector)
    {
        if (asn1encodablevector.size() < 1)
        {
            return EMPTY_SEQUENCE;
        } else
        {
            return new DERSequence(asn1encodablevector);
        }
    }

    static DERSet createSet(ASN1EncodableVector asn1encodablevector)
    {
        if (asn1encodablevector.size() < 1)
        {
            return EMPTY_SET;
        } else
        {
            return new DERSet(asn1encodablevector);
        }
    }

    static DERSet createSet(ASN1EncodableVector asn1encodablevector, boolean flag)
    {
        if (asn1encodablevector.size() < 1)
        {
            return EMPTY_SET;
        } else
        {
            return new DERSet(asn1encodablevector, flag);
        }
    }

}
