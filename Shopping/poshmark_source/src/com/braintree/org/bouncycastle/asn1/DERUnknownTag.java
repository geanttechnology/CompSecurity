// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Arrays;
import java.io.IOException;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERObject, DEROutputStream

public class DERUnknownTag extends DERObject
{

    private byte data[];
    private boolean isConstructed;
    private int tag;

    public DERUnknownTag(int i, byte abyte0[])
    {
        this(false, i, abyte0);
    }

    public DERUnknownTag(boolean flag, int i, byte abyte0[])
    {
        isConstructed = flag;
        tag = i;
        data = abyte0;
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        byte byte0;
        if (isConstructed)
        {
            byte0 = 32;
        } else
        {
            byte0 = 0;
        }
        deroutputstream.writeEncoded(byte0, tag, data);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof DERUnknownTag)
        {
            if (isConstructed == ((DERUnknownTag) (obj = (DERUnknownTag)obj)).isConstructed && tag == ((DERUnknownTag) (obj)).tag && Arrays.areEqual(data, ((DERUnknownTag) (obj)).data))
            {
                return true;
            }
        }
        return false;
    }

    public byte[] getData()
    {
        return data;
    }

    public int getTag()
    {
        return tag;
    }

    public int hashCode()
    {
        byte byte0;
        if (isConstructed)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        return byte0 ^ tag ^ Arrays.hashCode(data);
    }

    public boolean isConstructed()
    {
        return isConstructed;
    }
}
