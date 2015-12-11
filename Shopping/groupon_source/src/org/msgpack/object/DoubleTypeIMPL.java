// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import java.math.BigInteger;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.object:
//            FloatType

class DoubleTypeIMPL extends FloatType
{

    private double value;

    public DoubleTypeIMPL(double d)
    {
        value = d;
    }

    public BigInteger bigIntegerValue()
    {
        return BigInteger.valueOf((long)value);
    }

    public Object clone()
    {
        return new DoubleTypeIMPL(value);
    }

    public boolean equals(Object obj)
    {
        while (obj.getClass() != getClass() || ((DoubleTypeIMPL)obj).value != value) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(value);
        return (int)(l >>> 32 ^ l);
    }

    public long longValue()
    {
        return (long)value;
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packDouble(value);
    }
}
