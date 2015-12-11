// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.util.Vector;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DEREncodable

public class DEREncodableVector
{

    Vector v;

    public DEREncodableVector()
    {
        v = new Vector();
    }

    public void add(DEREncodable derencodable)
    {
        v.addElement(derencodable);
    }

    public DEREncodable get(int i)
    {
        return (DEREncodable)v.elementAt(i);
    }

    public int size()
    {
        return v.size();
    }
}
