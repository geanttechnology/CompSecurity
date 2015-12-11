// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERSequence, LazyDERConstructionEnumeration, DEREncodable, DEROutputStream

public class LazyDERSequence extends DERSequence
{

    private byte encoded[];
    private boolean parsed;
    private int size;

    LazyDERSequence(byte abyte0[])
        throws IOException
    {
        parsed = false;
        size = -1;
        encoded = abyte0;
    }

    private void parse()
    {
        for (LazyDERConstructionEnumeration lazyderconstructionenumeration = new LazyDERConstructionEnumeration(encoded); lazyderconstructionenumeration.hasMoreElements(); addObject((DEREncodable)lazyderconstructionenumeration.nextElement())) { }
        parsed = true;
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(48, encoded);
    }

    public DEREncodable getObjectAt(int i)
    {
        this;
        JVM INSTR monitorenter ;
        DEREncodable derencodable;
        if (!parsed)
        {
            parse();
        }
        derencodable = super.getObjectAt(i);
        this;
        JVM INSTR monitorexit ;
        return derencodable;
        Exception exception;
        exception;
        throw exception;
    }

    public Enumeration getObjects()
    {
        this;
        JVM INSTR monitorenter ;
        if (!parsed) goto _L2; else goto _L1
_L1:
        Object obj = super.getObjects();
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Enumeration) (obj));
_L2:
        obj = new LazyDERConstructionEnumeration(encoded);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int size()
    {
        if (size < 0)
        {
            LazyDERConstructionEnumeration lazyderconstructionenumeration = new LazyDERConstructionEnumeration(encoded);
            for (size = 0; lazyderconstructionenumeration.hasMoreElements(); size = size + 1)
            {
                lazyderconstructionenumeration.nextElement();
            }

        }
        return size;
    }
}
